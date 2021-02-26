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
@Table(name = "mt_CARDHOLDER")
public class CardHolder {

	@Id
	@Column(name = "CARDHOLDER_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigDecimal cardholderId;
	
	@Column(name = "CUST_IC_NO")
	private String custIcNo;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "ADDR1")
	private String addr1;
	
	@Column(name = "ADDR2")
	private String addr2;
	
	@Column(name = "ADDR3")
	private String addr3;
	
	@Column(name = "ADDR4")
	private String addr4;
	
	@Column(name = "ZIP_CODE")
	private String zipCode;
	
	@Column(name = "HOME_NO")
	private String homeNo;
	
	@Column(name = "OFFICE_NO")
	private String officeNo;
	
	@Column(name = "MOBILE_NO")
	private String mobileNo;
	
	@Column(name = "STATUS_ID")
	private Integer statusId; 
	
	@Column(name = "CREATED_BY")
	private String createdBy;
	
	@Column(name = "CREATED_DATETIME")
	private Timestamp createdDatetime;
	
	@Column(name = "EDITED_BY")
	private String editedBy;
	
	@Column(name = "EDITED_DATETIME")
	private Timestamp editedDatetime;

	public BigDecimal getCardholderId() {
		return cardholderId;
	}

	public void setCardholderId(BigDecimal cardholderId) {
		this.cardholderId = cardholderId;
	}

	public String getCustIcNo() {
		return custIcNo;
	}

	public void setCustIcNo(String custIcNo) {
		this.custIcNo = custIcNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddr1() {
		return addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	public String getAddr2() {
		return addr2;
	}

	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	public String getAddr3() {
		return addr3;
	}

	public void setAddr3(String addr3) {
		this.addr3 = addr3;
	}

	public String getAddr4() {
		return addr4;
	}

	public void setAddr4(String addr4) {
		this.addr4 = addr4;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getHomeNo() {
		return homeNo;
	}

	public void setHomeNo(String homeNo) {
		this.homeNo = homeNo;
	}

	public String getOfficeNo() {
		return officeNo;
	}

	public void setOfficeNo(String officeNo) {
		this.officeNo = officeNo;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
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

	public Timestamp getEditedDatetime() {
		return editedDatetime;
	}

	public void setEditedDatetime(Timestamp editedDatetime) {
		this.editedDatetime = editedDatetime;
	} 
	
}
