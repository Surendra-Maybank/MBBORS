package com.maybank.orsapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RedemptionTxnDetailsMMPResponse {

	@JsonProperty
	private String responseCode;
	
	@JsonProperty
	private String responseMessage;

	@JsonProperty
	private String orderNumber;

	@JsonProperty
	private String redemptionDateTime;
	
	@JsonProperty
	private String customerICNo;
	
	@JsonProperty
	private String customerName;
	
	@JsonProperty
	private String contactNumber;
	
	@JsonProperty
	private String deliveryAdd1;
	
	@JsonProperty
	private String deliveryAdd2;
	
	@JsonProperty
	private String deliveryAdd3;
	
	@JsonProperty
	private String deliveryAdd4;
	
	@JsonProperty
	private String pointRedeemed;
	
	@JsonProperty
	private String productCode;
	
	@JsonProperty
	private String productName;
	
	@JsonProperty
	private String deliveryStatus;
	
	@JsonProperty
	private String courierReferenceNo;
	
	@JsonProperty
	private String courierDate;
	
	@JsonProperty
	private String note;

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getRedemptionDateTime() {
		return redemptionDateTime;
	}

	public void setRedemptionDateTime(String redemptionDateTime) {
		this.redemptionDateTime = redemptionDateTime;
	}

	public String getCustomerICNo() {
		return customerICNo;
	}

	public void setCustomerICNo(String customerICNo) {
		this.customerICNo = customerICNo;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getDeliveryAdd1() {
		return deliveryAdd1;
	}

	public void setDeliveryAdd1(String deliveryAdd1) {
		this.deliveryAdd1 = deliveryAdd1;
	}

	public String getDeliveryAdd2() {
		return deliveryAdd2;
	}

	public void setDeliveryAdd2(String deliveryAdd2) {
		this.deliveryAdd2 = deliveryAdd2;
	}

	public String getDeliveryAdd3() {
		return deliveryAdd3;
	}

	public void setDeliveryAdd3(String deliveryAdd3) {
		this.deliveryAdd3 = deliveryAdd3;
	}

	public String getDeliveryAdd4() {
		return deliveryAdd4;
	}

	public void setDeliveryAdd4(String deliveryAdd4) {
		this.deliveryAdd4 = deliveryAdd4;
	}

	public String getPointRedeemed() {
		return pointRedeemed;
	}

	public void setPointRedeemed(String pointRedeemed) {
		this.pointRedeemed = pointRedeemed;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public String getCourierReferenceNo() {
		return courierReferenceNo;
	}

	public void setCourierReferenceNo(String courierReferenceNo) {
		this.courierReferenceNo = courierReferenceNo;
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
	
}
