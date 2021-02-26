/**
 * 
 */
package com.maybank.orsapp.repository;

import java.util.List;
import java.util.Optional;

//import com.maybank.orsapp.dto.GroupAndMenuAccessDto;
import com.maybank.orsapp.dto.GroupDto;
import com.maybank.orsapp.entities.Group;

/**
 * @author 80003905
 *
 */
public interface GroupRepositoryCustom {
	
	//List<GroupAndMenuAccessDto> getGroupDetailByid(Long id);

	List<Group> findAllActiveGroups();
	
	List<GroupDto> getAllUserGroups();
	
	Optional<Group> findGroupByGroupId(Long groupId);
	
	Optional<Group> findGroupByGroupCode(String groupCode);
	
	Optional<Group> findGroupAndGroupAccess(Long groupId);

}
