/**
 * 
 */
package com.maybank.orsapp.service.impl;

import java.util.Optional;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.ldap.search.FilterBasedLdapUserSearch;
import org.springframework.stereotype.Service;

import com.maybank.orsapp.entities.User;
import com.maybank.orsapp.exceptions.UserNotFoundException;
import com.maybank.orsapp.service.ADUserDetailsService;

/**
 * @author 80003905
 *
 */


@Service
public class ADUserDetailsServiceImpl implements  ADUserDetailsService{

	
	@Autowired
	FilterBasedLdapUserSearch filterBasedLdapUserSearch;
	
	public ADUserDetailsServiceImpl() {
		super();
	}
 
	public ADUserDetailsServiceImpl(FilterBasedLdapUserSearch filterBasedLdapUserSearch) {
		this.filterBasedLdapUserSearch = filterBasedLdapUserSearch;
	}
	
	
	@Override
    public User loadUserByUsername(String username) throws NamingException { 
		DirContextOperations  dtx = null;
    	Attributes attrs = null;
    	String firstName = null;
    	String lastName = null;
    	String telNo = null;
    	String email = null;
    	try {
    		dtx = filterBasedLdapUserSearch.searchForUser(username);
    		attrs = dtx.getAttributes();
    		if(Optional.ofNullable(attrs.get("givenname")).isPresent()) {
    			firstName = (String) (attrs.get("givenname")).get();
    		}
    		if(Optional.ofNullable(attrs.get("sn")).isPresent()) {
    			lastName = (String) (attrs.get("sn")).get();
    		}
    		if(Optional.ofNullable(attrs.get("mail")).isPresent()) {
    			email = (String) (attrs.get("mail")).get();
    		}
    		if(Optional.ofNullable(attrs.get("telephonenumber")).isPresent()) {
    			telNo = (String) (attrs.get("telephonenumber")).get();
    		}
    		
            return  new User(username, firstName, lastName, email, telNo);
		} catch (UsernameNotFoundException|NamingException e) {
			e.printStackTrace();
			throw new UserNotFoundException("User " + username + " doesn't exist");
		}  
    	
    }
	
	 
}
