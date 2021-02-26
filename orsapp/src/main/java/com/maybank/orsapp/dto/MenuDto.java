/**
 * 
 */
package com.maybank.orsapp.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author 80003905
 *
 */

@JsonInclude(Include.NON_NULL)
public class MenuDto {
	
	@JsonProperty
	private Long menuId;
	
	@JsonProperty
	private String menuCode;
	
	@JsonProperty
	private String menuName;
	
	@JsonProperty
	private List<MenuRightsDto> rights;
	
	@JsonProperty
	@JsonIgnore
	private Boolean view = Boolean.FALSE;
	
	@JsonProperty
	@JsonIgnore
	private Boolean add = Boolean.FALSE;
	
	@JsonProperty
	@JsonIgnore
	private Boolean edit = Boolean.FALSE;
	
	@JsonProperty
	@JsonIgnore
	private Boolean delete = Boolean.FALSE;

	/**
	 * 
	 */
	public MenuDto() {

	}
	
	/**
	 * @param menuId
	 * @param menuCode
	 * @param menuName
	 * @param view
	 * @param add
	 * @param edit
	 * @param delete
	 */
	public MenuDto(Long menuId, String menuCode, String menuName, Boolean view, Boolean add, Boolean edit,
			Boolean delete) {
		this.menuId = menuId;
		this.menuCode = menuCode;
		this.menuName = menuName;
		this.view = view;
		this.add = add;
		this.edit = edit;
		this.delete = delete;
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
	 * @return the menuCode
	 */
	public String getMenuCode() {
		return menuCode;
	}

	/**
	 * @param menuCode the menuCode to set
	 */
	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
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

	/**
	 * @return the view
	 */
	@JsonIgnore
	public Boolean getView() {
		return view;
	}

	/**
	 * @param view the view to set
	 */
	public void setView(Boolean view) {
		this.view = view;
	}

	/**
	 * @return the add
	 */
	@JsonIgnore
	public Boolean getAdd() {
		return add;
	}

	/**
	 * @param add the add to set
	 */
	public void setAdd(Boolean add) {
		this.add = add;
	}

	/**
	 * @return the edit
	 */
	@JsonIgnore
	public Boolean getEdit() {
		return edit;
	}

	/**
	 * @param edit the edit to set
	 */
	public void setEdit(Boolean edit) {
		this.edit = edit;
	}

	/**
	 * @return the delete
	 */
	@JsonIgnore
	public Boolean getDelete() {
		return delete;
	}

	/**
	 * @param delete the delete to set
	 */
	public void setDelete(Boolean delete) {
		this.delete = delete;
	}
	
}
