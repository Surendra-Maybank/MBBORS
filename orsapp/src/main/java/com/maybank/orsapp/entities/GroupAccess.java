/**
 * 
 */
package com.maybank.orsapp.entities;

import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author 80003905
 *
 */

@Entity
@Table(name = "mt_GROUP_ACCESS")
public class GroupAccess {
	
	@Id
	@Column(name = "GROUP_ACCESS_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="GROUP_ID", referencedColumnName = "GROUP_ID")    
	private Group groupId;
	
	@JsonProperty
	@Column(name = "MENU_ID")
	private Long menuId;
	
	@JsonProperty
	@Column(name = "IS_VIEW")
	private Boolean view = Boolean.FALSE;
	
	@JsonProperty
	@Column(name = "IS_ADD")
	private Boolean add = Boolean.FALSE;
	
	@JsonProperty
	@Column(name = "IS_EDIT")
	private Boolean edit = Boolean.FALSE;
	
	@JsonProperty
	@Column(name = "IS_DELETE")
	private Boolean delete = Boolean.FALSE;
	
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

	@Override
	public int hashCode() {
		return Objects.hash(id, menuId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GroupAccess other = (GroupAccess) obj;
		return Objects.equals(id, other.id) && Objects.equals(menuId, other.menuId);
	}

	@Override
	public String toString() {
		return "GroupAccess [id=" + id + ", menuId=" + menuId + "]";
	}

}
