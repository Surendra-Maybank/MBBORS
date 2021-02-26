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
@Table(name = "lk_PROGRAM")
public class Programs implements Serializable{
		
	/**
	 * 
	 */
	private static final long serialVersionUID = -7676434702972619756L;

	@Id
	@Column(name = "PROGRAM_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)		    		  
	private Long id;
	
	@Column(name = "PROGRAM_CODE")
	private String programCode;
	
	@Column(name = "PROGRAM_DESC")
	private String programDesc;
	
	@Column(name = "REWARD_TYPE_ID")
	private Long rewardTypeId;
	
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
	 * @return the programCode
	 */
	public String getProgramCode() {
		return programCode;
	}

	/**
	 * @param programCode the programCode to set
	 */
	public void setProgramCode(String programCode) {
		this.programCode = programCode;
	}

	/**
	 * @return the programDesc
	 */
	public String getProgramDesc() {
		return programDesc;
	}

	/**
	 * @param programDesc the programDesc to set
	 */
	public void setProgramDesc(String programDesc) {
		this.programDesc = programDesc;
	}

	/**
	 * @return the rewardTypeId
	 */
	public Long getRewardTypeId() {
		return rewardTypeId;
	}

	/**
	 * @param rewardTypeId the rewardTypeId to set
	 */
	public void setRewardTypeId(Long rewardTypeId) {
		this.rewardTypeId = rewardTypeId;
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
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	} 
	
	

}
