/**
 * 
 */
package com.maybank.orsapp.controller;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.maybank.orsapp.controller.request.LoginRequest;
import com.maybank.orsapp.controller.response.LoginResponse;
import com.maybank.orsapp.dto.LoginMenuDto;
import com.maybank.orsapp.dto.ResponseMessageDto;
import com.maybank.orsapp.entities.LoginSessionAudit;
import com.maybank.orsapp.entities.User;
import com.maybank.orsapp.exceptions.ApplicationException;
import com.maybank.orsapp.exceptions.RequestDataValidationException;
import com.maybank.orsapp.exceptions.UserAccountHandlingException;
import com.maybank.orsapp.exceptions.UserNotFoundException;
import com.maybank.orsapp.repository.GroupAccessRepositoryImpl;
import com.maybank.orsapp.repository.LoginSessionAuditRepository;
import com.maybank.orsapp.security.JwtTokenProvider;
import com.maybank.orsapp.service.AuthenticationService;
import com.maybank.orsapp.service.UserService;


@RestController
@RequestMapping("/")
public class LoginController {
	
	Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	private static final String USER_ACCOUNT = "User Account";

	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	UserService userService;
	
	@Autowired
	LoginSessionAuditRepository loginSessionAuditRepository;
	
	@Autowired
	GroupAccessRepositoryImpl groupAccessRepository;
	
	@Autowired
    private JwtTokenProvider jwtTokenUtil;
	
	@Autowired
	AuthenticationService authenticationService;
	
	@PostMapping("/login")	  
	@ResponseBody 
	public ResponseEntity<LoginResponse> userLogin(@RequestBody LoginRequest loginRequest) {
		try {
			if(loginRequest.getUserId().isEmpty() || loginRequest.getpassword().isEmpty()) {
	    		 throw new RequestDataValidationException("UserName and Password are required");
	    	}
			logger.info("User Login Details: "+ loginRequest.toString());
			LoginResponse loginResponse = getUserInfo(loginRequest.getUserId(), loginRequest.getpassword());
			if(loginResponse != null) {
				List<LoginMenuDto> menuAccessList = groupAccessRepository.findActiveGroupAndMenuByGroupId(loginResponse.getGroupId());
				if(!CollectionUtils.isEmpty(menuAccessList)) {
					loginResponse.setMenuList(menuAccessList);
				}
				return ResponseEntity.ok(loginResponse);
			}else {
				throw new UserNotFoundException("User "+ loginRequest.getUserId() + " doesn't exist");
			}					
		}
		catch(CredentialsExpiredException e) {
			logger.error(e.getMessage());
			failedLoginSessionAudit(loginRequest.getUserId(), e.getMessage());
			throw new UserAccountHandlingException("Login Credentials Expired");
		}
		catch(BadCredentialsException e) {
			logger.error(e.getMessage());
			failedLoginSessionAudit(loginRequest.getUserId(), e.getMessage());
			throw new BadCredentialsException("Invalid Username/Password");
		}
		catch(UserNotFoundException e){
			logger.error(e.getMessage());
			failedLoginSessionAudit(loginRequest.getUserId(), e.getMessage());
			throw new UserNotFoundException("User "+ loginRequest.getUserId() + " doesn't exist");
		}
		catch(AccountExpiredException e) {
			logger.error(e.getMessage());
			failedLoginSessionAudit(loginRequest.getUserId(), e.getMessage());
			throw new UserAccountHandlingException(USER_ACCOUNT + " "+loginRequest.getUserId() + " has been expired");
		}
		catch(DisabledException e) {
			logger.error(e.getMessage());
			failedLoginSessionAudit(loginRequest.getUserId(), e.getMessage());
			throw new UserAccountHandlingException(USER_ACCOUNT + " "+loginRequest.getUserId() + " has been disabled");
		}
		catch(LockedException e) {
			logger.error(e.getMessage());
			failedLoginSessionAudit(loginRequest.getUserId(), e.getMessage());
			throw new UserAccountHandlingException(USER_ACCOUNT + " "+loginRequest.getUserId() + " has been locked");
		}
		catch(Exception e) {
			logger.error(e.getMessage());
			throw new ApplicationException("SYSTEM_ERROR");
		}
	}
	
	private Authentication doAuthenticate(UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) {
		Authentication auth = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
		if(auth.isAuthenticated()) {
			return authenticationService.authenticate(usernamePasswordAuthenticationToken);
		}
		return null;
		
	}
	
	private LoginResponse getUserInfo(String userName, String password) {
		ResponseMessageDto responseMessage = new ResponseMessageDto();
		Optional<User> user = userService.findUserForLogin(userName);
		LoginSessionAudit loginSessionAudit = new LoginSessionAudit();
		if(user.isPresent()) {
			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userName, password);
			Authentication authentication = doAuthenticate(usernamePasswordAuthenticationToken);
			if(authentication != null) {
				SecurityContextHolder.getContext().setAuthentication(authentication);
				loginSessionAudit.setUserId(user.get().getUserId());
				loginSessionAudit.setIsSucess(Boolean.TRUE);
				loginSessionAudit.setLoginDateTime(new Timestamp(System.currentTimeMillis()));
				responseMessage.setResponseCode("00");
				responseMessage.setResponseMessage("Success");	
				final String jwtToken = jwtTokenUtil.generateToken(authentication);
				Long loginSessionId = successfulLoginSessionAudit(loginSessionAudit);
				return new LoginResponse(user.get(), loginSessionId, jwtToken, responseMessage);	
			}			
		}else {
			failedLoginSessionAudit(userName, "User doesn't exist");
			throw new UserNotFoundException("User "+ userName + " doesn't exist");
		}
		return null;
			
	}
	
	private Long successfulLoginSessionAudit(LoginSessionAudit loginSessionAudit) {
		try {
			LoginSessionAudit loginSession = loginSessionAuditRepository.save(loginSessionAudit);		
			return loginSession.getLoginSessionId();
		}catch(Exception e) {
			logger.error(e.getMessage());
			throw new ApplicationException("SYSTEM_ERROR");
		}
		
	}
	
	private void failedLoginSessionAudit(String userName, String errorMessage) {
		try {
			Optional<User> user = userService.findUserForLogin(userName);
			if(user.isPresent()){
				Long userId = user.get().getUserId();
				LoginSessionAudit loginSessionAudit = new LoginSessionAudit();
				loginSessionAudit.setUserId(userId);
				loginSessionAudit.setIsSucess(Boolean.FALSE);
				loginSessionAudit.setLoginDateTime(new Timestamp(System.currentTimeMillis()));
				loginSessionAudit.setLogoutDateTime(new Timestamp(System.currentTimeMillis()));
				loginSessionAudit.setErrorMessage(errorMessage);
				loginSessionAuditRepository.save(loginSessionAudit);
			}			
		}catch(Exception e) {
			logger.error(e.getMessage());
			throw new ApplicationException("SYSTEM_ERROR");
		}
	}
	
	@PutMapping("/logOut/{loginSessionId}")	  
	@ResponseBody 
	public ResponseEntity<ResponseMessageDto> userLogin(@PathVariable("loginSessionId") Long loginSessionId) { 
		try {
			Optional<LoginSessionAudit> loginSession = loginSessionAuditRepository.findById(loginSessionId);
			if(loginSession.isPresent()) {
				LoginSessionAudit loginSessionAudit = loginSession.get();
				loginSessionAudit.setLogoutDateTime(new Timestamp(System.currentTimeMillis()));
				loginSessionAuditRepository.save(loginSessionAudit);
			}
			ResponseMessageDto response = new ResponseMessageDto();
			response.setResponseCode("00");
			response.setResponseMessage("Successfully Logged Out");
			return ResponseEntity.ok(response);
		}catch(Exception e) {
			logger.error(e.getMessage());
			throw new ApplicationException("SYSTEM_ERROR");
		}	
	}
	
}