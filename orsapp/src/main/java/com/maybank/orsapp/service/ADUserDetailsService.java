package com.maybank.orsapp.service;

import javax.naming.NamingException;
import com.maybank.orsapp.entities.User;

public interface ADUserDetailsService {

	public User loadUserByUsername(String username) throws NamingException;

}
