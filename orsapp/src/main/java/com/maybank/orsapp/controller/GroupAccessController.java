/**
 * 
 */
package com.maybank.orsapp.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maybank.orsapp.controller.requestval.GroupRequestValidator;
import com.maybank.orsapp.controller.response.MenuResponse;
import com.maybank.orsapp.dto.GroupDto;
import com.maybank.orsapp.dto.ResponseMessageDto;
import com.maybank.orsapp.dto.UserGroupAndMenuAccessDto;
import com.maybank.orsapp.exceptions.RequestDataValidationException;
import com.maybank.orsapp.service.GroupService;
import com.maybank.orsapp.service.MenuService;

/**
 * @author 80003905
 *
 */

@RestController
@RequestMapping("/")
public class GroupAccessController {

	@Autowired
	GroupService groupService;

	@Autowired
	MenuService menuService;
	
	@Autowired
	GroupRequestValidator groupRequestValidator;

	@GetMapping(value = "/GetMenuList", headers = "Accept=application/json")
	public ResponseEntity<MenuResponse> getAllActiveMenus() {
		return ResponseEntity.ok(menuService.getMenuList());
	}

	@PreAuthorize("hasRole('GROUP_VIEW')")
	@GetMapping(value = "/GetGroupList", headers = "Accept=application/json")
	public ResponseEntity<UserGroupAndMenuAccessDto> getAllActiveGroups() {
		return ResponseEntity.ok(groupService.getGroupList());
	}

	@PreAuthorize("hasRole('GROUP_VIEW')")
	@GetMapping(value = "/GetGroupDetailByGroupID/{groupId}", headers = "Accept=application/json")
	public ResponseEntity<UserGroupAndMenuAccessDto> getGroupDetailById(@PathVariable("groupId") Long groupId) {
		return ResponseEntity.ok(groupService.getGroupDetailsById(groupId));
	}

	@PreAuthorize("hasRole('GROUP_ADD')")
	@PostMapping(value = "/CreateGroup", headers = "Accept=application/json")
	public ResponseEntity<ResponseMessageDto> createUser(@RequestBody GroupDto groupDto) {
		String requestValidation = groupRequestValidator.validateCreateGroupRequest(groupDto);
		if(StringUtils.isNotBlank(requestValidation)) {
			throw new RequestDataValidationException(requestValidation.trim());
		}else {
			return ResponseEntity.ok(groupService.createGroup(groupDto));
		}
	}

	@PreAuthorize("hasRole('GROUP_EDIT')")
	@PutMapping(value = "/UpdateGroup", headers = "Accept=application/json")
	public ResponseEntity<ResponseMessageDto> updateGroup(@RequestBody GroupDto groupDto) {
		String requestValidation = groupRequestValidator.validateUpdateGroupRequest(groupDto);
		if(StringUtils.isNotBlank(requestValidation)) {
			throw new RequestDataValidationException(requestValidation.trim());
		}else {
			return ResponseEntity.ok(groupService.updateGroup(groupDto));
		}
		
	}

	@PreAuthorize("hasRole('GROUP_DELETE')")
	@DeleteMapping(value = "/DeleteGroup/{groupId}", headers = "Accept=application/json")
	public ResponseEntity<ResponseMessageDto> deleteGroup(@PathVariable("groupId") Long groupId) {
		String requestValidation = groupRequestValidator.findActiveUsersByGroupId(groupId);
		if(StringUtils.isNotBlank(requestValidation)) {
			throw new RequestDataValidationException(requestValidation.trim());
		}else {
			return ResponseEntity.ok(groupService.deleteGroup(groupId));
		}
	}

	
}
