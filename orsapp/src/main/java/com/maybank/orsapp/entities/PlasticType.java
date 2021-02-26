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

/**
 * @author 80003905
 *
 */

@Entity
@Table(name = "lk_PLASTIC_TYPE")
public class PlasticType {
	
	@Id
	@Column(name = "PLASTIC_TYPE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)		    		  
	private Long id;
	
	@Column(name = "PLASTIC_TYPE_CODE")
	private String plasticTypeCode;
	
	@Column(name = "PLASTIC_TYPE_DESC")
	private String plasticTypeDesc;
	
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
	 * @return the plasticTypeCode
	 */
	public String getPlasticTypeCode() {
		return plasticTypeCode;
	}

	/**
	 * @param plasticTypeCode the plasticTypeCode to set
	 */
	public void setPlasticTypeCode(String plasticTypeCode) {
		this.plasticTypeCode = plasticTypeCode;
	}

	/**
	 * @return the plasticTypeDesc
	 */
	public String getPlasticTypeDesc() {
		return plasticTypeDesc;
	}

	/**
	 * @param plasticTypeDesc the plasticTypeDesc to set
	 */
	public void setPlasticTypeDesc(String plasticTypeDesc) {
		this.plasticTypeDesc = plasticTypeDesc;
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
