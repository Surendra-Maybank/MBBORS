/**
 * 
 */
package com.maybank.orsapp.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.maybank.orsapp.controller.response.GroupResponse;
import com.maybank.orsapp.controller.response.UserResponse;
import com.maybank.orsapp.dto.ResponseMessageDto;
import com.maybank.orsapp.dto.SearchUserFromADDto;
import com.maybank.orsapp.dto.UserDto;
import com.maybank.orsapp.entities.User;

/**
 * @author 80003905
 *
 */


public interface UserService {
	
	//public void createUser(User user);
	
    public UserResponse getAllUser();
    
    public ResponseMessageDto updateUser(UserDto userDto);
    
    public ResponseMessageDto deleteUserById(Long userId);

	public SearchUserFromADDto findUserByPfNo(String pfNo);
	
	public Optional<User> findUserForLogin(String pfNo);
	
	public UserResponse findUserByUserId(Long id);

	public GroupResponse getAllUserGroups();

	public ResponseMessageDto createUser(UserDto userDto);
	
	public UserDetails loadUserByUsername(String pfNo, String password) throws UsernameNotFoundException;

}
