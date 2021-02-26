/**
 * 
 */
package com.maybank.orsapp.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author 80003905
 *
 */
public class SecurityLibrary {

	static Logger logger = LoggerFactory.getLogger(SecurityLibrary.class);
	
	public static final String getLoggedInUser() {
		String userName = null;
		Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
		if (currentUser == null) {
			logger.info("No SecurityContextHolder for Logged In User : ");
		}

		if (currentUser instanceof UsernamePasswordAuthenticationToken) {
			UserDetails user = (UserDetails) currentUser.getPrincipal();
			if (user != null) {
				logger.info("Logged In User : " + currentUser.getName());
				userName = currentUser.getName();
			}
		}
		
		return userName;
	}

}
