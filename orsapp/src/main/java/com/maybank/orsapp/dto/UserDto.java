package com.maybank.orsapp.dto;

import java.util.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.maybank.orsapp.enums.StatusCodes;
import com.maybank.orsapp.utils.TimeStampConversion;


public class UserDto extends TimeStampConversion{
	
	@JsonProperty
	private Long userId;
	
	@JsonProperty
	private String pfNo;

	@JsonProperty
	private String firstName;

	@JsonProperty
	private String lastName;

	@JsonProperty
	private String emailId;

	@JsonProperty
	private String telephoneNumber;

	@JsonProperty
	private Long groupId;
	
	@JsonProperty
	private String groupDesc;

	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	private Integer merchantId;

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
	
	public UserDto() {
		
	}
	
	public UserDto(Long userId, String pfNo, String firstName, String lastName, String emailId, String telephoneNumber, 
			Long groupId, String groupCode, String groupDescription, Integer statusId, String createdBy, Date createdDateTime, String editedBy, Date editDateTime) {
		this.userId = userId;
		this.pfNo = pfNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.telephoneNumber = telephoneNumber;
		this.groupId = groupId;
		this.statusDesc = StatusCodes.valueOf(statusId);
		this.groupDesc = groupCode.concat("-").concat(groupDescription);
		this.createdBy = createdBy;
		this.createdDateTime = dateTimeFormat(createdDateTime);
		this.editedBy = editedBy;
		this.editedDateTime = dateTimeFormat(editDateTime);
	}

	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * @return the pfNo
	 */
	public String getPfNo() {
		return pfNo;
	}

	/**
	 * @param pfNo the pfNo to set
	 */
	public void setPfNo(String pfNo) {
		this.pfNo = pfNo;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * @return the telephoneNumber
	 */
	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	/**
	 * @param telephoneNumber the telephoneNumber to set
	 */
	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	/**
	 * @return the groupId
	 */
	public Long getGroupId() {
		return groupId;
	}

	/**
	 * @return the groupDesc
	 */
	public String getGroupDesc() {
		return groupDesc;
	}

	/**
	 * @param groupDesc the groupDesc to set
	 */
	public void setGroupDesc(String groupDesc) {
		this.groupDesc = groupDesc;
	}

	/**
	 * @param groupId the groupId to set
	 */
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	/**
	 * @return the merchantId
	 */
	public Integer getMerchantId() {
		return merchantId;
	}

	/**
	 * @param merchantId the merchantId to set
	 */
	public void setMerchantId(Integer merchantId) {
		this.merchantId = merchantId;
	}

	/**
	 * @return the status
	 */
	public StatusCodes getStatusDesc() {
		return statusDesc;
	}

	/**
	 * @param statusDesc the statusDesc to set
	 */
	public void setStatus(StatusCodes statusDesc) {
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

	@Override
	public int hashCode() {
		return Objects.hash(emailId, firstName, lastName, pfNo, telephoneNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDto other = (UserDto) obj;
		return Objects.equals(emailId, other.emailId) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(pfNo, other.pfNo)
				&& Objects.equals(telephoneNumber, other.telephoneNumber);
	}

	@Override
	public String toString() {
		return "UserDto [userId=" + userId + ", pfNo=" + pfNo + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", emailId=" + emailId + ", telephoneNumber=" + telephoneNumber + ", groupId=" + groupId + "]";
	}
	
}
