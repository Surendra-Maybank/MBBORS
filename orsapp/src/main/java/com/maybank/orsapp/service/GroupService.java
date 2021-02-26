/**
 * 
 */
package com.maybank.orsapp.service;

import com.maybank.orsapp.dto.GroupDto;
import com.maybank.orsapp.dto.ResponseMessageDto;
import com.maybank.orsapp.dto.UserGroupAndMenuAccessDto;

/**
 * @author 80003905
 *
 */
public interface GroupService {
	
	public UserGroupAndMenuAccessDto getGroupList();
	
	public UserGroupAndMenuAccessDto getGroupDetailsById(Long groupId);
	
	public ResponseMessageDto createGroup(GroupDto groupDto);
	
	public ResponseMessageDto updateGroup(GroupDto groupDto);
	
	public ResponseMessageDto deleteGroup(Long groupId);

}
