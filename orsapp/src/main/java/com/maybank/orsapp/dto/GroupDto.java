/**
 * 
 */
package com.maybank.orsapp.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.maybank.orsapp.enums.StatusCodes;

/**
 * @author 80003905
 *
 */

@JsonInclude(Include.NON_NULL)
public class GroupDto {
	
	@JsonProperty
	private Long groupId;
	
	@JsonProperty
	private String groupCode;
	
	@JsonProperty
	private String groupDescription;
	
	@JsonProperty
	private StatusCodes statusDesc;
	
	@JsonProperty
	private String createdBy;
	
	@JsonProperty
	private String createdDateTime;
	
	@JsonProperty
	private String editedBy;
	
	@JsonProperty
	private String editedDateTime;
	
	@JsonProperty
	List<GroupAccessDto> groupAccessList;
	
	public GroupDto() {
		
	}
	
	public GroupDto(Long groupId, String groupCode, String groupDesc) {
		this.groupId = groupId;
		this.groupCode = groupCode;
		this.groupDescription = groupDesc;
	}
	
	/**
	 * @return the groupId
	 */
	public Long getGroupId() {
		return groupId;
	}

	/**
	 * @param groupId the groupId to set
	 */
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
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
	 * @return the statusDesc
	 */
	public StatusCodes getStatusDesc() {
		return statusDesc;
	}

	/**
	 * @param statusDesc the statusDesc to set
	 */
	public void setStatusDesc(StatusCodes statusDesc) {
		this.statusDesc = statusDesc;
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
	public String getCreatedDateTime() {
		return createdDateTime;
	}

	/**
	 * @param createdDateTime the createdDateTime to set
	 */
	public void setCreatedDateTime(String createdDateTime) {
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
	public String getEditedDateTime() {
		return editedDateTime;
	}

	/**
	 * @param editedDateTime the editedDateTime to set
	 */
	public void setEditedDateTime(String editedDateTime) {
		this.editedDateTime = editedDateTime;
	}

	/**
	 * @return the groupAccessList
	 */
	public List<GroupAccessDto> getGroupAccessList() {
		return groupAccessList;
	}

	/**
	 * @param groupAccessList the groupAccessList to set
	 */
	public void setGroupAccessList(List<GroupAccessDto> groupAccessList) {
		this.groupAccessList = groupAccessList;
	}
	
}
