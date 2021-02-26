/**
 * 
 */
package com.maybank.orsapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.maybank.orsapp.service.AuthenticationService;
import com.maybank.orsapp.service.UserService;

/**
 * @author 80003905
 *
 */

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
	
	@Autowired
	UserService userService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = null;
		final String userName = authentication.getName();
		final String password = authentication.getCredentials().toString();
		UserDetails userDetail = userService.loadUserByUsername(userName, password);
		if(userDetail != null) {
			usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetail, "", userDetail.getAuthorities());
		}
		return usernamePasswordAuthenticationToken;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
