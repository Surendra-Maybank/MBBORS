package com.maybank.orsapp.entities;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mt_DEBIT_CARDHOLDER")
public class DebitCardHolder {

	@Id
	@Column(name = "DEBIT_CARDHOLDER_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigDecimal debitCardholderId;
	
	@Column(name = "CARD_NO")
	private String cardNo;
	
	@Column(name = "CUST_IC_NO")
	private String custIcNo;
	
	@Column(name = "STATUS_ID")
	private Integer statusId;
	
	@Column(name = "CREATED_BY")
	private String createdBy;
	
	@Column(name = "CREATED_DATETIME")
	private Timestamp createdDatetime;
	
	@Column(name = "EDITED_BY")
	private String editedBy;
	
	@Column(name = "EDITED_DATETIME")
	private Timestamp editedDateTime;

	public BigDecimal getDebitCardholderId() {
		return debitCardholderId;
	}

	public void setDebitCardholderId(BigDecimal debitCardholderId) {
		this.debitCardholderId = debitCardholderId;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getCustIcNo() {
		return custIcNo;
	}

	public void setCustIcNo(String custIcNo) {
		this.custIcNo = custIcNo;
	}

	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedDatetime() {
		return createdDatetime;
	}

	public void setCreatedDatetime(Timestamp createdDatetime) {
		this.createdDatetime = createdDatetime;
	}

	public String getEditedBy() {
		return editedBy;
	}

	public void setEditedBy(String editedBy) {
		this.editedBy = editedBy;
	}

	public Timestamp getEditedDateTime() {
		return editedDateTime;
	}

	public void setEditedDateTime(Timestamp editedDateTime) {
		this.editedDateTime = editedDateTime;
	}
	
}
