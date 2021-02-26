/**
 * 
 */
package com.maybank.orsapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.maybank.orsapp.controller.response.GroupResponse;
import com.maybank.orsapp.controller.response.UserResponse;
import com.maybank.orsapp.dto.ResponseMessageDto;
import com.maybank.orsapp.dto.SearchUserFromADDto;
import com.maybank.orsapp.dto.UserDto;
import com.maybank.orsapp.service.UserService;

/**
 * @author 80003905
 *
 */

@RestController
@RequestMapping("/")
public class UserController {
	
	@Autowired
    UserService userService;
	
	@PreAuthorize("hasRole('USER_ADD')")
	@GetMapping("/SearchUserFromAD/{pfNo}")
	@ResponseBody 
	public ResponseEntity<SearchUserFromADDto> userLogin(@PathVariable("pfNo") String pfNo) { 
		return ResponseEntity.ok(userService.findUserByPfNo(pfNo));
	}
	
	@PreAuthorize("hasRole('USER_VIEW')")
	@GetMapping(value="/getAllUser", headers="Accept=application/json")
    public ResponseEntity<UserResponse> getAllUser() {
    	return ResponseEntity.ok(userService.getAllUser());
    }

	@PreAuthorize("hasRole('USER_VIEW')")
    @GetMapping(value = "/GetUserDetailByUserID/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponse> getUserById(@PathVariable("userId") Long userId) {  
        return ResponseEntity.ok(userService.findUserByUserId(userId));
    }

    @GetMapping(value="/getUserGroups", headers="Accept=application/json")
    public ResponseEntity<GroupResponse> getAllUserGroups() {
    	return ResponseEntity.ok(userService.getAllUserGroups());
    }
    
    @PreAuthorize("hasRole('USER_ADD')")
    @PostMapping(value="/CreateUser",headers="Accept=application/json")
    public ResponseEntity<ResponseMessageDto> createUser(@RequestBody UserDto userDto){
        return ResponseEntity.ok(userService.createUser(userDto));
    }

    @PreAuthorize("hasRole('USER_EDIT')")
    @PutMapping(value="/UpdateUser", headers="Accept=application/json")
    public ResponseEntity<ResponseMessageDto> updateUser(@RequestBody UserDto userDto) {
    	return ResponseEntity.ok(userService.updateUser(userDto));
    }

    @PreAuthorize("hasRole('USER_DELETE')")
    @DeleteMapping(value="/DeleteUser/{userId}", headers ="Accept=application/json")
    public ResponseEntity<?> deleteUser(@PathVariable("userId") Long userId){
    	return ResponseEntity.ok(userService.deleteUserById(userId));
    }

}
