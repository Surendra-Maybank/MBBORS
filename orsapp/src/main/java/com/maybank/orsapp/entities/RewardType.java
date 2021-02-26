/**
 * 
 */
package com.maybank.orsapp.entities;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 80003905
 *
 */

@Entity
@Table(name = "lk_REWARD_TYPE")
public class RewardType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7211206523404188622L;
	
	@Id
	@Column(name = "REWARD_TYPE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	
	@Column(name = "REWARD_TYPE_CODE")
	public String rewardTypeCode;
	
	@Column(name = "REWARD_TYPE_DESC")
	public String rewardTypeDesc;
	
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
	 * @return the rewardTypeId
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param rewardTypeId the rewardTypeId to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the rewardTypeCode
	 */
	public String getRewardTypeCode() {
		return rewardTypeCode;
	}

	/**
	 * @param rewardTypeCode the rewardTypeCode to set
	 */
	public void setRewardTypeCode(String rewardTypeCode) {
		this.rewardTypeCode = rewardTypeCode;
	}

	/**
	 * @return the rewardTypeDesc
	 */
	public String getRewardTypeDesc() {
		return rewardTypeDesc;
	}

	/**
	 * @param rewardTypeDesc the rewardTypeDesc to set
	 */
	public void setRewardTypeDesc(String rewardTypeDesc) {
		this.rewardTypeDesc = rewardTypeDesc;
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
