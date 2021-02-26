package com.maybank.orsapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RedemptionTxnMMPRequest {

	@JsonProperty
	private String startDate;
	
	@JsonProperty
	private String endDate;
	
	@JsonProperty
	private String orderNumber;
	
	@JsonProperty
	private String ORSMID;
	
	@JsonProperty
	private String customerICNo;
	
	@JsonProperty
	private String courierRefNo;

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getORSMID() {
		return ORSMID;
	}

	public void setORSMID(String ORSMID) {
		this.ORSMID = ORSMID;
	}

	public String getCustomerICNo() {
		return customerICNo;
	}

	public void setCustomerICNo(String customerICNo) {
		this.customerICNo = customerICNo;
	}

	public String getCourierRefNo() {
		return courierRefNo;
	}

	public void setCourierRefNo(String courierRefNo) {
		this.courierRefNo = courierRefNo;
	}
	
}
