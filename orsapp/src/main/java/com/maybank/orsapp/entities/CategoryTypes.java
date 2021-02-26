/**
 * 
 */
package com.maybank.orsapp.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "lk_CATEGORY_TYPE")
public class CategoryTypes implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 493438807502420670L;

	@Id
	@Column(name = "CATEGORY_TYPE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	
	@Column(name = "CATEGORY_TYPE_CODE")
	public String categoryTypeCode;
	
	@Column(name = "CATEGORY_TYPE_DESC")
	public String categoryTypeDesc;
	
	@Column(name = "IS_CREDIT_AMOUNT")
	private BigDecimal creditAmount;
	
	@Column(name = "IS_DEBIT_AMOUNT")
	private BigDecimal debitAmount;
	
	@Column(name = "IS_POINT_CONVERSION")
	private BigDecimal conversionPoint;
	
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
	 * @return the categoryTypeCode
	 */
	public String getCategoryTypeCode() {
		return categoryTypeCode;
	}

	/**
	 * @param categoryTypeCode the categoryTypeCode to set
	 */
	public void setCategoryTypeCode(String categoryTypeCode) {
		this.categoryTypeCode = categoryTypeCode;
	}

	/**
	 * @return the categoryTypeDesc
	 */
	public String getCategoryTypeDesc() {
		return categoryTypeDesc;
	}

	/**
	 * @param categoryTypeDesc the categoryTypeDesc to set
	 */
	public void setCategoryTypeDesc(String categoryTypeDesc) {
		this.categoryTypeDesc = categoryTypeDesc;
	}

	/**
	 * @return the creditAmount
	 */
	public BigDecimal getCreditAmount() {
		return creditAmount;
	}

	/**
	 * @param creditAmount the creditAmount to set
	 */
	public void setCreditAmount(BigDecimal creditAmount) {
		this.creditAmount = creditAmount;
	}

	/**
	 * @return the debitAmount
	 */
	public BigDecimal getDebitAmount() {
		return debitAmount;
	}

	/**
	 * @param debitAmount the debitAmount to set
	 */
	public void setDebitAmount(BigDecimal debitAmount) {
		this.debitAmount = debitAmount;
	}

	/**
	 * @return the conversionPoint
	 */
	public BigDecimal getConversionPoint() {
		return conversionPoint;
	}

	/**
	 * @param conversionPoint the conversionPoint to set
	 */
	public void setConversionPoint(BigDecimal conversionPoint) {
		this.conversionPoint = conversionPoint;
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
