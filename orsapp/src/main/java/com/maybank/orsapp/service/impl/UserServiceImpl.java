/**
 * 
 */
package com.maybank.orsapp.service.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.naming.NamingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.maybank.orsapp.controller.response.GroupResponse;
import com.maybank.orsapp.controller.response.UserResponse;
import com.maybank.orsapp.dto.AdUserDto;
import com.maybank.orsapp.dto.GroupDto;
import com.maybank.orsapp.dto.MenuDto;
import com.maybank.orsapp.dto.ResponseMessageDto;
import com.maybank.orsapp.dto.SearchUserFromADDto;
import com.maybank.orsapp.dto.UserDto;
import com.maybank.orsapp.entities.User;
import com.maybank.orsapp.exceptions.ApplicationException;
import com.maybank.orsapp.exceptions.UserNotFoundException;
import com.maybank.orsapp.repository.GroupAccessRepositoryImpl;
import com.maybank.orsapp.repository.GroupRepositoryImpl;
import com.maybank.orsapp.repository.UserRepositoryImpl;
import com.maybank.orsapp.service.ADUserDetailsService;
import com.maybank.orsapp.service.UserService;

/**
 * @author 80003905
 *
 */

@Service(value = "userService")
@Transactional
public class UserServiceImpl implements UserService {
	
	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	UserRepositoryImpl userDao;
	
	@Autowired
	GroupRepositoryImpl groupDao;
	
	@Autowired
	ADUserDetailsService adUserDetailsService;
	
	@Autowired
	GroupAccessRepositoryImpl groupAccessRepository;

	@Override
	@Transactional(readOnly = true)
    public UserResponse getAllUser() {
		UserResponse userResponse = new UserResponse();
		try {
			List<UserDto> usersList = userDao.getAllUser();
			if(CollectionUtils.isEmpty(usersList)) {
				userResponse.setResponseCode("01");
				userResponse.setResponseMessage("No Active Users Found");
			}else {
				userResponse.setResponseCode("00");
				userResponse.setResponseMessage("Success");
				userResponse.setListOfActiveUsers(usersList);
			}
		}catch(Exception e) {
			logger.error(e.getMessage(), e);
			throw new ApplicationException("SYSTEM_ERROR");
		}
        return userResponse;
    }

	@Override
	@Transactional(readOnly = true)
	public Optional<User> findUserForLogin(String pfNo) {
		return userDao.findUserForLogin(pfNo);
	}



	@Override
	@Transactional(readOnly = true)
    public SearchUserFromADDto findUserByPfNo(String pfNo) {
		SearchUserFromADDto searchUserFromADDto = new SearchUserFromADDto();
		try {
			Optional<User> user = userDao.findUserByPfNo(pfNo);
			if(!user.isPresent()) {
				User userDetails = adUserDetailsService.loadUserByUsername(pfNo);
				searchUserFromADDto.setResponseCode("00");
				searchUserFromADDto.setResponseMessage("Success");			
				searchUserFromADDto.setUser(new AdUserDto(userDetails));
			} else {
				throw new UserNotFoundException("User PF No: "+ pfNo + " already exists");
			}
		}catch(UsernameNotFoundException|NamingException e) {
			logger.error(e.getMessage(), e);
			throw new UserNotFoundException("User " + pfNo + " doesn't exist");
		}catch(Exception e) {
			logger.error(e.getMessage(), e);
			throw new ApplicationException("SYSTEM_ERROR");
    	}
        return searchUserFromADDto;
    }

	@Override
	@Transactional(readOnly = false)
    public ResponseMessageDto createUser(UserDto userDto) {
		Optional<User> users = userDao.findUserByPfNo(userDto.getPfNo());
    	ResponseMessageDto headers = new ResponseMessageDto();
    	try {
    		if(!users.isPresent()) {
    			User user = new User();
    			user.setPfNo(userDto.getPfNo());
    			user.setFirstName(userDto.getFirstName());
    			user.setLastName(userDto.getLastName());
    			user.setEmailId(userDto.getEmailId());
    			user.setTelephoneNumber(userDto.getTelephoneNumber());
    			user.setGroupId(userDto.getGroupId());
    	        user.setStatusId(1);
    	        user.setCreatedBy("Logged In User");
    	        user.setCreatedDateTime(new Date());
    	        user.setEditedBy("Logged In User");
    	        user.setEditedDateTime(new Date());
    	        userDao.saveUser(user);
    	        headers.setResponseCode("00");
    	        headers.setResponseMessage("Successfully Saved");
    		} else {
    			logger.error("User PF No: "+ userDto.getPfNo() + " already exists");
    			throw new UserNotFoundException("User PF No: "+ userDto.getPfNo() + " already exists");
    		}
    	}catch(Exception e) {
    		logger.error(e.getMessage(), e);
    		throw new ApplicationException("SYSTEM_ERROR");
    	}
    	
    	return headers;
        
    }

	@Override
	@Transactional(readOnly = false)
    public ResponseMessageDto deleteUserById(Long userId) {
		Optional<User> user = userDao.findUserById(userId);
		ResponseMessageDto headers = new ResponseMessageDto();
		try {
    		if(user.isPresent()) {
    			User userDetail = user.get();
            	userDetail.setEditedBy("System");
            	userDetail.setEditedDateTime(new Date());
            	userDetail.setStatusId(2);
            	userDao.deleteUser(userDetail);
    	        headers.setResponseCode("00");
    	        headers.setResponseMessage("Successfully Deleted");
    		} else {
    			logger.error("User : "+ userId + " already exists");
    			throw new UserNotFoundException("User : "+ userId + " already exists");
    		}
    	}catch(Exception e) {
    		logger.error(e.getMessage(), e);
    		throw new ApplicationException("SYSTEM_ERROR");
    	}
        return headers;
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public ResponseMessageDto updateUser(UserDto userDto) {
    	Optional<User> users = userDao.findUserById(userDto.getUserId());
    	ResponseMessageDto headers = new ResponseMessageDto();
    	try {
    		if(users.isPresent()) {
    			User userDetail = users.get();
            	userDetail.setGroupId(userDto.getGroupId());
            	userDetail.setStatusId(userDto.getStatusDesc().getStatusCode());
            	userDetail.setEditedBy("System");
            	userDetail.setEditedDateTime(new Date());
    	        userDao.updateUser(userDetail);
    	        headers.setResponseCode("00");
    	        headers.setResponseMessage("Successfully Updated");
    		} else {
    			logger.error("User PF No: "+ userDto.getPfNo() + " already exists");
    			throw new UserNotFoundException("User PF No: "+ userDto.getPfNo() + " already exists");
    		}
    	}catch(Exception e) {
    		logger.error(e.getMessage(), e);
    		throw new ApplicationException("SYSTEM_ERROR");
    	}
        return headers;
    }

	@Override
	public UserResponse findUserByUserId(Long id) {
		UserResponse userResponse = new UserResponse();
		try {
			UserDto userDto = userDao.findUserByUserId(id);
			if(userDto != null) {
				userResponse.setResponseCode("00");
				userResponse.setResponseMessage("Success");
				userResponse.setUserDto(userDto);
			}else {
				logger.error("User " + id + " doesn't exist");
				throw new UserNotFoundException("User " + id + " doesn't exist");
			}
		}catch(Exception e) {
			logger.error(e.getMessage(), e);
			throw new ApplicationException("SYSTEM_ERROR");
		}
        return userResponse;
	}

	@Override
	public GroupResponse getAllUserGroups() {
		GroupResponse groupResponse = new GroupResponse();
		try {
			List<GroupDto> groupDtoList = groupDao.getAllUserGroups();
			if(CollectionUtils.isEmpty(groupDtoList)) {
				groupResponse.setResponseCode("01");
				groupResponse.setResponseMessage("No Active User Groups Found");
			}else {
				groupResponse.setResponseCode("00");
				groupResponse.setResponseMessage("Success");
				groupResponse.setListOfActiveGroups(groupDtoList);
			}
		}catch(Exception e) {
			logger.error(e.getMessage(), e);
			throw new ApplicationException("SYSTEM_ERROR");
		}
        return groupResponse;
	}

	@Override
	public UserDetails loadUserByUsername(String pfNo, String password) throws UsernameNotFoundException {
		Optional<User> user = userDao.findUserForLogin(pfNo);
        if(!user.isPresent()){
        	logger.error("Invalid username or password.");
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        System.out.println("Get Authorities");
        return new org.springframework.security.core.userdetails.User(user.get().getPfNo(), "", getAuthority(user.get().getGroupId()));
	}
	
	private Set<SimpleGrantedAuthority> getAuthority(Long groupId) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        List<MenuDto> menuAccessList = groupAccessRepository.getMenuAccessByGroupId(groupId);
        menuAccessList.forEach(role -> {
        	if(role.getAdd()) {
        		System.out.println("ROLE_"+role.getMenuCode().trim()+"_ADD");
        		authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getMenuCode().trim()+"_ADD"));
        	}
        	if(role.getDelete()) {
        		System.out.println("ROLE_"+role.getMenuCode().trim()+"_DELETE");
        		authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getMenuCode().trim()+"_DELETE"));
        	}
        	if(role.getEdit()) {
        		System.out.println("ROLE_"+role.getMenuCode().trim()+"_EDIT");
        		authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getMenuCode().trim()+"_EDIT"));
        	}
        	if(role.getView()) {
        		System.out.println("ROLE_"+role.getMenuCode().trim()+"_VIEW");
        		authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getMenuCode().trim()+"_VIEW"));
        	}
        });
        System.out.println("authorities in userservice: " + authorities);
        return authorities;
    }
	
}
