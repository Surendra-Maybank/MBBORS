/**
 * 
 */
package com.maybank.orsapp.entities;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author 80003905
 *
 */

@Entity
@Table(name = "mt_GROUP")
public class Group {
	
	@Id
	@Column(name = "GROUP_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonProperty
	@Column(name = "GROUP_CODE")
	private String groupCode;
	
	@JsonProperty
	@Column(name = "GROUP_DESC")
	private String groupDescription;
	
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
		
	@OneToMany(targetEntity=GroupAccess.class, mappedBy="groupId", cascade=CascadeType.ALL, fetch = FetchType.LAZY)    
	private List<GroupAccess> groupAccess;


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
	 * @return the groupCode
	 */
	public String getGroupCode() {
		return groupCode;
	}

	/**
	 * @param groupCode the groupCode to set
	 */
	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	/**
	 * @return the groupDescription
	 */
	public String getGroupDescription() {
		return groupDescription;
	}

	/**
	 * @param groupDescription the groupDescription to set
	 */
	public void setGroupDescription(String groupDescription) {
		this.groupDescription = groupDescription;
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

	/**
	 * @return the groupAccess
	 */
	public List<GroupAccess> getGroupAccess() {
		return groupAccess;
	}

	/**
	 * @param groupAccess the groupAccess to set
	 */
	public void setGroupAccess(List<GroupAccess> groupAccess) {
		this.groupAccess = groupAccess;
	}
	
	

}
