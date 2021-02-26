/**
 * 
 */
package com.maybank.orsapp.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.maybank.orsapp.entities.Group;

/**
 * @author 80003905
 *
 */

@JsonInclude(Include.NON_NULL)
public class GroupAccessDto {
	
	@JsonProperty
	private Group groupId;
	
	@JsonProperty
	private Long menuId;
	
	@JsonProperty
	private String menuName;
	
	@JsonProperty
	private List<MenuRightsDto> rights;

	/**
	 * @return the groupId
	 */
	public Group getGroupId() {
		return groupId;
	}

	/**
	 * @param groupId the groupId to set
	 */
	public void setGroupId(Group groupId) {
		this.groupId = groupId;
	}

	/**
	 * @return the menuId
	 */
	public Long getMenuId() {
		return menuId;
	}

	/**
	 * @param menuId the menuId to set
	 */
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}
	
	/**
	 * @return the menuName
	 */
	public String getMenuName() {
		return menuName;
	}

	/**
	 * @param menuName the menuName to set
	 */
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	/**
	 * @return the rights
	 */
	public List<MenuRightsDto> getRights() {
		return rights;
	}

	/**
	 * @param rights the rights to set
	 */
	public void setRights(List<MenuRightsDto> rights) {
		this.rights = rights;
	}
	
	
}
