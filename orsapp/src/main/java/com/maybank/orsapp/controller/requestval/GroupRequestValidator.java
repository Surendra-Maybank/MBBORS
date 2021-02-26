/**
 * 
 */
package com.maybank.orsapp.controller.requestval;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.maybank.orsapp.dto.GroupAccessDto;
import com.maybank.orsapp.dto.GroupDto;
import com.maybank.orsapp.dto.MenuRightsDto;
import com.maybank.orsapp.entities.User;
import com.maybank.orsapp.enums.StatusCodes;
import com.maybank.orsapp.repository.MenuRepositoryImpl;
import com.maybank.orsapp.repository.UserRepositoryImpl;

/**
 * @author 80003905
 *
 */

@Component
public class GroupRequestValidator {
	
	@Autowired
	UserRepositoryImpl userRepository;
	
	@Autowired
	MenuRepositoryImpl menuRepository;
	
	public String validateCreateGroupRequest(GroupDto groupDto) {
		StringBuilder sb = new StringBuilder();
		
		if(StringUtils.isBlank(groupDto.getGroupCode())) {
			sb.append(" Group Code cannot empty ");
		}
		
		checkGroupAccess(groupDto, sb);
		
		return sb.toString();
	}
	
	public String validateUpdateGroupRequest(GroupDto groupDto) {
		StringBuilder sb = new StringBuilder();
		
		if(groupDto.getGroupId() == null) {
			sb.append(" Group ID cannot empty ");
		}
		
		if(groupDto.getGroupId() != null && groupDto.getStatusDesc() != null && groupDto.getStatusDesc() == StatusCodes.INACTIVE) {
			sb.append(findActiveUsersByGroupId(groupDto.getGroupId()));
		}
		
		checkGroupAccess(groupDto, sb);
		
		return sb.toString();
	}
	
	private StringBuilder checkGroupAccess(GroupDto groupDto, StringBuilder sb) {
		
		if(StringUtils.isBlank(groupDto.getGroupDescription())) {
			sb.append(" Group Description cannot empty ");
		}
		if(groupDto.getStatusDesc() == null) {
			sb.append(" Status Description cannot empty ");
		}
		
		if(CollectionUtils.isEmpty(groupDto.getGroupAccessList())) {
			sb.append(" Atleast select 1 Menu Access ");
		}
		
		if(!CollectionUtils.isEmpty(groupDto.getGroupAccessList())) {
			GroupAccessDto groupAccess = groupDto.getGroupAccessList().get(0);
			String view = checkMenuViewAccess(groupAccess);
			if(StringUtils.isNotBlank(view)) {
				sb.append(view);
			}
		}
		return sb;
	}
	
	private String checkMenuViewAccess(GroupAccessDto groupAccess) {
		
		String sb = null;
		
		MenuRightsDto menu = groupAccess.getRights().get(0);
		Boolean checked = menu.getChecked();
		
		if(menu.getName().equalsIgnoreCase("VIEW") && Boolean.TRUE.equals(checked)) {
			String menuName = menuRepository.getMenuName(groupAccess.getMenuId());
			sb = " Please check view Access for the menu: " + menuName;
		}
		return sb;
	}
	
	public String findActiveUsersByGroupId(Long groupId) {
		
		StringBuilder sb = new StringBuilder();
		
		List<User> activeUsers = userRepository.findUsersByGroupId(groupId);
		if(!CollectionUtils.isEmpty(activeUsers)) {
			sb.append(" " + activeUsers.size() + " active users exits for this group ");
		}
		return sb.toString();
	}

}
