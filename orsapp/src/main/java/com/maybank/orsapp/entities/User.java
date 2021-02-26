/**
 * 
 */
package com.maybank.orsapp.entities;

import java.io.Serializable;
import java.util.Date;

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
@Table(name = "mt_USER")
public class User implements Serializable {

	private static final long serialVersionUID = -8224012526902633714L;

	@Id
	@Column(name = "USER_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	@JsonProperty
	@Column(name = "USER_NO")
	private String pfNo;

	@JsonProperty
	@Column(name = "FIRST_NAME")
	private String firstName;

	@JsonProperty
	@Column(name = "LAST_NAME")
	private String lastName;

	@JsonProperty
	@Column(name = "EMAIL")
	private String emailId;

	@JsonProperty
	@Column(name = "TEL_NO")
	private String telephoneNumber;

	@JsonProperty
	//@OneToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "GROUP_ID", referencedColumnName = "GROUP_ID")
	@Column(name = "GROUP_ID")
	private Long groupId;

	@Column(name = "MERCHANT_ID")
	private Integer merchantId;

	@Column(name = "STATUS_ID")
	private Integer statusId;

	@Column(name = "CREATED_BY")
	private String createdBy;

	@Column(name = "CREATED_DATETIME")
	private Date createdDateTime;

	@Column(name = "EDITED_BY")
	private String editedBy;

	@Column(name = "EDITED_DATETIME")
	private Date editedDateTime;

	public User() {
		super();
	}

	public User(String pfNo, String firstName, String lastName, String emailId, String telephoneNumber) {
		this.pfNo = pfNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.telephoneNumber = telephoneNumber;
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
	public Date getCreatedDateTime() {
		return createdDateTime;
	}

	/**
	 * @param createdDateTime the createdDateTime to set
	 */
	public void setCreatedDateTime(Date createdDateTime) {
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
	public Date getEditedDateTime() {
		return editedDateTime;
	}

	/**
	 * @param editedDateTime the editedDateTime to set
	 */
	public void setEditedDateTime(Date editedDateTime) {
		this.editedDateTime = editedDateTime;
	}

}
