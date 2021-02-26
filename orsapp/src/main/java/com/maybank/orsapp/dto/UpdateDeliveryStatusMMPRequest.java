package com.maybank.orsapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateDeliveryStatusMMPRequest {

	@JsonProperty
	private String pointTxnDetailID;
	
	@JsonProperty
	private String courierRefNo;
	
	@JsonProperty
	private String courierDate;
	
	@JsonProperty
	private String note;
	
	@JsonProperty
	private String userPFNo;

	public String getPointTxnDetailID() {
		return pointTxnDetailID;
	}

	public void setPointTxnDetailID(String pointTxnDetailID) {
		this.pointTxnDetailID = pointTxnDetailID;
	}

	public String getCourierRefNo() {
		return courierRefNo;
	}

	public void setCourierRefNo(String courierRefNo) {
		this.courierRefNo = courierRefNo;
	}

	public String getCourierDate() {
		return courierDate;
	}

	public void setCourierDate(String courierDate) {
		this.courierDate = courierDate;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getUserPFNo() {
		return userPFNo;
	}

	public void setUserPFNo(String userPFNo) {
		this.userPFNo = userPFNo;
	}
	
}
