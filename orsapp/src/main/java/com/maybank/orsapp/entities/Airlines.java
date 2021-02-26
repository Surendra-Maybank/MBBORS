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
@Table(name = "lk_AIRLINES")
public class Airlines implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -174305084243235368L;

	@Id
	@Column(name = "AIRLINES_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "AIRLINES_CODE")
	private String airlinesCode;
	
	@Column(name = "AIRLINES_DESC")
	private String airlinesDescription;
	
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
	 * @return the airlinesCode
	 */
	public String getAirlinesCode() {
		return airlinesCode;
	}

	/**
	 * @param airlinesCode the airlinesCode to set
	 */
	public void setAirlinesCode(String airlinesCode) {
		this.airlinesCode = airlinesCode;
	}

	/**
	 * @return the airlinesDescription
	 */
	public String getAirlinesDescription() {
		return airlinesDescription;
	}

	/**
	 * @param airlinesDescription the airlinesDescription to set
	 */
	public void setAirlinesDescription(String airlinesDescription) {
		this.airlinesDescription = airlinesDescription;
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
