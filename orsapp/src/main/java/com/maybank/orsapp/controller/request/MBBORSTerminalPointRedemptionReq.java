package com.maybank.orsapp.controller.request;

public class MBBORSTerminalPointRedemptionReq {
	
	private String customerCardNo;
	private String tid;
	private String rmValue;
	
	public String getCustomerCardNo() {
		return customerCardNo;
	}
	public void setCustomerCardNo(String customerCardNo) {
		this.customerCardNo = customerCardNo;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getRmValue() {
		return rmValue;
	}
	public void setRmValue(String rmValue) {
		this.rmValue = rmValue;
	}
	
	
}
