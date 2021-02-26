/**
 * 
 */
package com.maybank.orsapp.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.maybank.orsapp.dto.GroupAccessDto;
import com.maybank.orsapp.dto.GroupDto;
import com.maybank.orsapp.dto.MenuRightsDto;
import com.maybank.orsapp.dto.ResponseMessageDto;
import com.maybank.orsapp.dto.UserGroupAndMenuAccessDto;
import com.maybank.orsapp.entities.Group;
import com.maybank.orsapp.entities.GroupAccess;
import com.maybank.orsapp.entities.GroupAccessAudit;
import com.maybank.orsapp.entities.Menu;
import com.maybank.orsapp.enums.StatusCodes;
import com.maybank.orsapp.exceptions.ApplicationException;
import com.maybank.orsapp.repository.GroupAccessAuditRepository;
import com.maybank.orsapp.repository.GroupAccessRepository;
import com.maybank.orsapp.repository.GroupRepository;
import com.maybank.orsapp.repository.MenuRepository;
import com.maybank.orsapp.service.GroupService;
import com.maybank.orsapp.service.MenuService;
import com.maybank.orsapp.utils.SecurityLibrary;
import com.maybank.orsapp.utils.TimeStampConversion;

/**
 * @author 80003905
 *
 */

@Service
public class GroupServiceImpl implements GroupService {
	
	Logger logger = LoggerFactory.getLogger(GroupServiceImpl.class);
	
	@Autowired
	GroupRepository groupRepository;
	
	@Autowired
	MenuRepository menuRepository;

	@Autowired
	GroupAccessRepository groupAccessRepository;

	@Autowired
	MenuService menuService;

	@Autowired
	TimeStampConversion timeStampConversion;
	
	@Autowired
	GroupAccessAuditRepository groupAccessAuditRepository;
	
	@Override
	public UserGroupAndMenuAccessDto getGroupList() {
		UserGroupAndMenuAccessDto userGroupAndMenuAccessDto = new UserGroupAndMenuAccessDto();
		try {
			List<Group> groupList = groupRepository.findAllActiveGroups();
			if(CollectionUtils.isEmpty(groupList)) {
				userGroupAndMenuAccessDto.setResponseCode("01");
				userGroupAndMenuAccessDto.setResponseMessage("NO RECORDS FOUND");
			}else {
				List<GroupDto> activeGroupList = new ArrayList<>();
				for (Group group : groupList) {
					GroupDto groupDto = mapGroupToGroupDto(group);
					activeGroupList.add(groupDto);
				}
				userGroupAndMenuAccessDto.setResponseCode("00");
				userGroupAndMenuAccessDto.setResponseMessage("Success");
				userGroupAndMenuAccessDto.setListOfActiveGroups(activeGroupList);
			}
			
		}catch(Exception ex) {
			userGroupAndMenuAccessDto.setResponseCode("99");
			userGroupAndMenuAccessDto.setResponseMessage("SYSTEM_ERROR");
			logger.error(ex.getMessage(), ex);
		}
		return userGroupAndMenuAccessDto;
	}
	
	@Override
	public UserGroupAndMenuAccessDto getGroupDetailsById(Long groupId) {
		UserGroupAndMenuAccessDto userGroupAndMenuAccess = new UserGroupAndMenuAccessDto();
		try {
			Optional<Group> group = groupRepository.findGroupByGroupId(groupId);
			if (group.isPresent()) {
				GroupDto groupDto = mapGroupToGroupDto(group.get());
				userGroupAndMenuAccess.setGroupDto(groupDto);
				Collection<GroupAccess> groupAccessList = groupAccessRepository.findAllActiveGroupAccess(group.get());
				if(CollectionUtils.isEmpty(groupAccessList)) {
					userGroupAndMenuAccess.setResponseCode("01");
					userGroupAndMenuAccess.setResponseMessage("Group Access for Group " + groupId + " not found");
				}else {
					Collection<Menu> menuList = menuRepository.findAllActiveMenu();
					List<GroupAccessDto> mappedGroupAndMenuAccess = mappingGroupAndMenu(menuList, groupAccessList);
					if (!CollectionUtils.isEmpty(mappedGroupAndMenuAccess)) {
						userGroupAndMenuAccess.setGroupAndMenuAccessList(mappedGroupAndMenuAccess);
					}
					userGroupAndMenuAccess.setResponseCode("00");
					userGroupAndMenuAccess.setResponseMessage("Success");
				}
			} else {
				userGroupAndMenuAccess.setResponseCode("01");
				userGroupAndMenuAccess.setResponseMessage("Group " + groupId + " not found");
			}
			
		}catch(Exception ex) {
			userGroupAndMenuAccess.setResponseCode("99");
			userGroupAndMenuAccess.setResponseMessage("SYSTEM_ERROR");
			logger.error(ex.getMessage(), ex);
			ex.printStackTrace();
		}
		
		return userGroupAndMenuAccess;
	}

	private GroupDto mapGroupToGroupDto(Group group) {
		GroupDto groupDto = new GroupDto();
		groupDto.setGroupId(group.getId());
		groupDto.setGroupCode(group.getGroupCode());
		groupDto.setGroupDescription(group.getGroupDescription());
		groupDto.setStatusDesc(StatusCodes.valueOf(group.getStatusId()));
		groupDto.setCreatedBy(group.getCreatedBy());
		groupDto.setCreatedDateTime(timeStampConversion.dateFormat(group.getCreatedDateTime()));
		groupDto.setEditedBy(group.getEditedBy());
		groupDto.setEditedDateTime(timeStampConversion.dateFormat(group.getEditedDateTime()));
		return groupDto;
	}
	
	private List<GroupAccessDto> mappingGroupAndMenu(Collection<Menu> menuList, Collection<GroupAccess> groupAccessList) {
		List<GroupAccessDto> groupAndMenuAccessList = new ArrayList<>();
		List<MenuRightsDto> menuRights = null;
		for (Menu menu : menuList) {
			GroupAccessDto groupAndMenuAccessDto = new GroupAccessDto();
			groupAndMenuAccessDto.setMenuName(menu.getMenuName());
			groupAndMenuAccessDto.setMenuId(menu.getId());
			List<GroupAccess> tempGroupAccessList = groupAccessList.stream()
					.filter(groupAccesss -> groupAccesss.getMenuId().equals(menu.getId())).collect(Collectors.toList());
			if (!CollectionUtils.isEmpty(tempGroupAccessList) && tempGroupAccessList.size() == 1
					&& tempGroupAccessList.get(0) != null) {
				menuRights = getRightsIfMenuExists(menu, tempGroupAccessList.get(0));
			} else {
				menuRights = getUnAssignedMenu(menu);
			}
			groupAndMenuAccessDto.setRights(menuRights);
			groupAndMenuAccessList.add(groupAndMenuAccessDto);
		}

		return groupAndMenuAccessList;
	}

	private List<MenuRightsDto> getRightsIfMenuExists(Menu menu, GroupAccess groupAccess) {
		List<MenuRightsDto> rights = new ArrayList<>();
		MenuRightsDto right = null;

		if (menu.getAdd() || !menu.getAdd()) {
			right = new MenuRightsDto();
			right.setName("add");
			right.setAccess(menu.getAdd());
			right.setChecked(groupAccess.getAdd());
			rights.add(right);
		}
		if (menu.getView() || !menu.getView()) {
			right = new MenuRightsDto();
			right.setName("view");
			right.setAccess(menu.getView());
			right.setChecked(groupAccess.getView());
			rights.add(right);
		}
		if (menu.getEdit() || !menu.getEdit()) {
			right = new MenuRightsDto();
			right.setName("edit");
			right.setAccess(menu.getEdit());
			right.setChecked(groupAccess.getEdit());
			rights.add(right);
		}
		if (menu.getDelete() || !menu.getDelete()) {
			right = new MenuRightsDto();
			right.setName("delete");
			right.setAccess(menu.getDelete());
			right.setChecked(groupAccess.getDelete());
			rights.add(right);
		}
		if (CollectionUtils.isEmpty(rights)) {
			return Collections.emptyList();
		} else {
			return rights;
		}
	}

	private List<MenuRightsDto> getUnAssignedMenu(Menu menu) {
		List<MenuRightsDto> rights = new ArrayList<>();
		MenuRightsDto right = null;

		if (menu.getAdd() || !menu.getAdd()) {
			right = new MenuRightsDto();
			right.setName("add");
			right.setAccess(menu.getAdd());
			right.setChecked(Boolean.FALSE);
			rights.add(right);
		}
		if (menu.getView() || !menu.getView()) {
			right = new MenuRightsDto();
			right.setName("view");
			right.setAccess(menu.getView());
			right.setChecked(Boolean.FALSE);
			rights.add(right);
		}
		if (menu.getEdit() || !menu.getEdit()) {
			right = new MenuRightsDto();
			right.setName("edit");
			right.setAccess(menu.getEdit());
			right.setChecked(Boolean.FALSE);
			rights.add(right);
		}
		if (menu.getDelete() || !menu.getDelete()) {
			right = new MenuRightsDto();
			right.setName("delete");
			right.setAccess(menu.getDelete());
			right.setChecked(Boolean.FALSE);
			rights.add(right);
		}

		if (CollectionUtils.isEmpty(rights)) {
			return Collections.emptyList();
		} else {
			return rights;
		}
	}
	
	@Override
	public ResponseMessageDto createGroup(GroupDto groupDto) {
		Optional<Group> optionalGroup = groupRepository.findGroupByGroupCode(groupDto.getGroupCode());
		ResponseMessageDto headers = new ResponseMessageDto();
		String userName = SecurityLibrary.getLoggedInUser();
		try {
			if (!optionalGroup.isPresent()) {
				Group group = new Group();
				group.setGroupCode(groupDto.getGroupCode());
				group.setGroupDescription(groupDto.getGroupDescription());
				group.setStatusId(groupDto.getStatusDesc().getStatusCode());
				group.setCreatedBy(userName);
				group.setCreatedDateTime(new Timestamp(System.currentTimeMillis()));
				group.setEditedBy(userName);
				group.setEditedDateTime(new Timestamp(System.currentTimeMillis()));
				List<GroupAccess> groupAccessList = new ArrayList<>();
				for (GroupAccessDto groupAccessDto : groupDto.getGroupAccessList()) {
					GroupAccess groupAccess = new GroupAccess();
					groupAccess.setGroupId(group);
					groupAccess.setMenuId(groupAccessDto.getMenuId());
					for (MenuRightsDto rights : groupAccessDto.getRights()) {
						if (rights.getName().equalsIgnoreCase("view") && rights.getAccess()) {
							groupAccess.setView(rights.getChecked());
						}
						if (rights.getName().equalsIgnoreCase("add") && rights.getAccess()) {
							groupAccess.setAdd(rights.getChecked());
						}
						if (rights.getName().equalsIgnoreCase("edit") && rights.getAccess()) {
							groupAccess.setEdit(rights.getChecked());
						}
						if (rights.getName().equalsIgnoreCase("delete") && rights.getAccess()) {
							groupAccess.setDelete(rights.getChecked());
						}
					}
					groupAccess.setStatusId(groupDto.getStatusDesc().getStatusCode());
					groupAccess.setCreatedBy(userName);
					groupAccess.setCreatedDateTime(new Timestamp(System.currentTimeMillis()));
					groupAccess.setEditedBy(userName);
					groupAccess.setEditedDateTime(new Timestamp(System.currentTimeMillis()));
					groupAccessList.add(groupAccess);
				}
				if (!CollectionUtils.isEmpty(groupAccessList)) {
					group.setGroupAccess(groupAccessList);
				}
				groupRepository.save(group);
				createGroupAccessAudit(group.getGroupAccess());
				headers.setResponseCode("00");
				headers.setResponseMessage("Successfully Saved");
				return headers;
			} else {
				headers.setResponseCode("02");
				headers.setResponseMessage("Group with group code: " + groupDto.getGroupCode() + " already exists");
				return headers;
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new ApplicationException("SYSTEM_ERROR");
		}
	}

	@Override
	public ResponseMessageDto updateGroup(GroupDto groupDto) {
		ResponseMessageDto headers = new ResponseMessageDto();
		Optional<Group> optionalGroup = groupRepository.findGroupAndGroupAccess(groupDto.getGroupId());
		String userName = SecurityLibrary.getLoggedInUser();
		try {
			if (optionalGroup.isPresent()) {
				Group group = optionalGroup.get();
				group.setGroupDescription(groupDto.getGroupDescription());
				group.setStatusId(groupDto.getStatusDesc().getStatusCode());
				group.setEditedBy(userName);
				group.setEditedDateTime(new Timestamp(System.currentTimeMillis()));
				List<GroupAccess> groupAccessList = getUpdatedGroupAccess(group.getGroupAccess(), groupDto.getGroupAccessList(), group);
				if (!CollectionUtils.isEmpty(groupAccessList)) {
					group.setGroupAccess(groupAccessList);
				}
				groupRepository.save(group);
				createGroupAccessAudit(group.getGroupAccess());
				headers.setResponseCode("00");
				headers.setResponseMessage("Successfully Updated");
			} else {
				headers.setResponseCode("02");
				headers.setResponseMessage("Group: " + groupDto.getGroupId() + " doesnot exists");
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new ApplicationException("SYSTEM_ERROR");
		}
		return headers;
	}
	
	@Override
	public ResponseMessageDto deleteGroup(Long groupId) {
		ResponseMessageDto headers = new ResponseMessageDto();
		Optional<Group> optionalGroup = groupRepository.findGroupAndGroupAccess(groupId);
		try {
			if (optionalGroup.isPresent()) {
				Group group = optionalGroup.get();
				group.setStatusId(2);
				group.setEditedBy(SecurityLibrary.getLoggedInUser());
				group.setEditedDateTime(new Timestamp(System.currentTimeMillis()));
				List<GroupAccess> deletedGroupAccesslist = removedGroupAccess(group.getGroupAccess());
				if(!CollectionUtils.isEmpty(deletedGroupAccesslist)) {
					group.setGroupAccess(deletedGroupAccesslist);
				}
				groupRepository.save(group);
				createGroupAccessAudit(group.getGroupAccess());
				headers.setResponseCode("00");
				headers.setResponseMessage("Successfully Deleted");
			} else {
				headers.setResponseCode("02");
				headers.setResponseMessage("Error While Updating Group: " + groupId);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new ApplicationException("SYSTEM_ERROR");
		}
		return headers;
	}

	private List<GroupAccess> getUpdatedGroupAccess(List<GroupAccess> groupAccessList, List<GroupAccessDto> groupAccessDtoList, Group group) {
		GroupAccess groupAccess = null;
		List<GroupAccess> updatedGroupAccessList = new ArrayList<>();
		List<GroupAccess> listToRemoveGroupAccess = groupAccessList;
		for (GroupAccessDto groupAccessDto : groupAccessDtoList) {
			Optional<GroupAccess> matchingObject = groupAccessList.stream()
					.filter(p -> p.getMenuId().equals(groupAccessDto.getMenuId())).findAny();
			if (matchingObject.isPresent()) {
				groupAccess = matchingObject.get();
				//groupAccess.setStatusId(group.getStatusId());
				listToRemoveGroupAccess.remove(groupAccess);
			} else {
				groupAccess = new GroupAccess();
				groupAccess.setGroupId(group);
				groupAccess.setMenuId(groupAccessDto.getMenuId());
				//groupAccess.setStatusId(group.getStatusId());
				groupAccess.setCreatedBy(SecurityLibrary.getLoggedInUser());
				groupAccess.setCreatedDateTime(new Timestamp(System.currentTimeMillis()));
			}
			GroupAccess ga = assignAccessRights(group, groupAccess, groupAccessDto.getRights());
			updatedGroupAccessList.add(ga);
		}

		if(CollectionUtils.isEmpty(listToRemoveGroupAccess)) {
			List<GroupAccess> deletedGroupAccesslist = removedGroupAccess(listToRemoveGroupAccess);
			if(CollectionUtils.isEmpty(deletedGroupAccesslist)) {
				updatedGroupAccessList.addAll(deletedGroupAccesslist);
			}
		}
		return updatedGroupAccessList;
	}
	
	private GroupAccess assignAccessRights(Group group, GroupAccess groupAccess, List<MenuRightsDto> accessRights) {
		for (MenuRightsDto rights : accessRights) {
			if (rights.getName().equalsIgnoreCase("view") && rights.getAccess()) {
				groupAccess.setView(rights.getChecked());
			}
			if (rights.getName().equalsIgnoreCase("add") && rights.getAccess()) {
				groupAccess.setAdd(rights.getChecked());
			}
			if (rights.getName().equalsIgnoreCase("edit") && rights.getAccess()) {
				groupAccess.setEdit(rights.getChecked());
			}
			if (rights.getName().equalsIgnoreCase("delete") && rights.getAccess()) {
				groupAccess.setDelete(rights.getChecked());
			}
		}
		
		groupAccess.setStatusId(group.getStatusId());
		groupAccess.setEditedBy(SecurityLibrary.getLoggedInUser());
		groupAccess.setEditedDateTime(new Timestamp(System.currentTimeMillis()));
		return groupAccess;
	}
	
	private List<GroupAccess> removedGroupAccess(List<GroupAccess> groupAccessList){
		List<GroupAccess> listToRemoveGroupAccess = new ArrayList<>();
		GroupAccess updateGroupAccess = null;
		
		if(!CollectionUtils.isEmpty(groupAccessList)) {
			for (GroupAccess groupAccesss : groupAccessList) {
				updateGroupAccess = groupAccesss;
				updateGroupAccess.setStatusId(2);
				updateGroupAccess.setEditedBy(SecurityLibrary.getLoggedInUser());
				updateGroupAccess.setEditedDateTime(new Timestamp(System.currentTimeMillis()));
				listToRemoveGroupAccess.add(updateGroupAccess);
			}
		}
		return listToRemoveGroupAccess;
	}
	
	private void createGroupAccessAudit(List<GroupAccess> groupAccessList) {
		try {
			if(!CollectionUtils.isEmpty(groupAccessList)) {
				for(GroupAccess groupAccess : groupAccessList) {
					GroupAccessAudit groupAccessAudit = new GroupAccessAudit();
					groupAccessAudit.setGroupAccessId(groupAccess.getId());
					groupAccessAudit.setGroupId(groupAccess.getGroupId().getId());
					groupAccessAudit.setMenuId(groupAccess.getMenuId());
					groupAccessAudit.setAdd(groupAccess.getAdd());
					groupAccessAudit.setView(groupAccess.getView());
					groupAccessAudit.setDelete(groupAccess.getDelete());
					groupAccessAudit.setEdit(groupAccess.getEdit());
					groupAccessAudit.setStatusId(groupAccess.getStatusId());
					groupAccessAudit.setCreatedBy(SecurityLibrary.getLoggedInUser());
					groupAccessAudit.setCreatedDateTime(new Timestamp(System.currentTimeMillis()));
					groupAccessAudit.setEditedBy(SecurityLibrary.getLoggedInUser());
					groupAccessAudit.setEditedDateTime(new Timestamp(System.currentTimeMillis()));
					groupAccessAuditRepository.save(groupAccessAudit);
				}
			}
		}catch(Exception e) {
			logger.error(e.getMessage(), e);
			throw new ApplicationException("SYSTEM_ERROR");
		}
	}
}
