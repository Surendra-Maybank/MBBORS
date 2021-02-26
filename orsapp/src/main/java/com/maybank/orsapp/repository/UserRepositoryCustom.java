/**
 * 
 */
package com.maybank.orsapp.repository;

import java.util.List;
import java.util.Optional;

import com.maybank.orsapp.dto.UserDto;
import com.maybank.orsapp.entities.User;

/**
 * @author 80003905
 *
 */
public interface UserRepositoryCustom {
	
	public Optional<User> findUserByPfNo(String pfNo);
	
	public Optional<User> findUserById(Long id);
	
	public Optional<User> findUserForLogin(String pfNo);
	
	public List<UserDto> getAllUser();
	
	public UserDto findUserByUserId(Long id);
	
	public void saveUser(User user);
	
    public User updateUser(User user);
    
    public void deleteUser(User user);
    
    public List<User> findUsersByGroupId(Long groupId);
    
}
