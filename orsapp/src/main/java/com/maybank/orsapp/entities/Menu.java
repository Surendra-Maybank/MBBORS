/**
 * 
 */
package com.maybank.orsapp.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author 80003905
 *
 */

@Entity
@Table(name = "mt_MENU")
public class Menu {
	
	@Id
	@Column(name = "MENU_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "MENU_CODE")
	private String menuCode;
	
	@Column(name = "MENU_NAME")
	private String menuName;
	
	@Column(name = "IS_VIEW")
	private Boolean view = Boolean.FALSE;
	
	@Column(name = "IS_ADD")
	private Boolean add = Boolean.FALSE;
	
	@Column(name = "IS_EDIT")
	private Boolean edit = Boolean.FALSE;
	
	@Column(name = "IS_DELETE")
	private Boolean delete = Boolean.FALSE;
	
	@JsonProperty
	@Column(name = "STATUS_ID")
	private Integer statusId;
	
	@Column(name = "CREATED_BY")
	private String createdBy;
	
	@Column(name = "CREATED_DATETIME")
	private Timestamp createdDateTime;
	
	@Column(name = "EDITED_BY")
	private String editedBy;
	
	@Column(name = "EDITED_DATETIME")
	private Timestamp editedDateTime;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
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
	 * @return the view
	 */
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
	public Boolean getDelete() {
		return delete;
	}

	/**
	 * @param delete the delete to set
	 */
	public void setDelete(Boolean delete) {
		this.delete = delete;
	}

	/**
	 * @return the statusId
	 */
	public Integer getStatusId() {
		return statusId;
	}

	/**
	 * @param statusId the statusId to set
	 */
	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the createdDateTime
	 */
	public Timestamp getCreatedDateTime() {
		return createdDateTime;
	}

	/**
	 * @param createdDateTime the createdDateTime to set
	 */
	public void setCreatedDateTime(Timestamp createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	/**
	 * @return the editedBy
	 */
	public String getEditedBy() {
		return editedBy;
	}

	/**
	 * @param editedBy the editedBy to set
	 */
	public void setEditedBy(String editedBy) {
		this.editedBy = editedBy;
	}

	/**
	 * @return the editedDateTime
	 */
	public Timestamp getEditedDateTime() {
		return editedDateTime;
	}

	/**
	 * @param editedDateTime the editedDateTime to set
	 */
	public void setEditedDateTime(Timestamp editedDateTime) {
		this.editedDateTime = editedDateTime;
	}

}
