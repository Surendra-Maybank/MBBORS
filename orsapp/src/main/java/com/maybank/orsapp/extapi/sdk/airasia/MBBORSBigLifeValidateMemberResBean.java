package com.maybank.orsapp.extapi.sdk.airasia;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MBBORSBigLifeValidateMemberResBean {

	private int code;
	private String message;
	private String AccountStatus;
	@JsonProperty("error")
	private BigLifeValidateMemberError error;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getAccountStatus() {
		return AccountStatus;
	}
	public void setAccountStatus(String accountStatus) {
		AccountStatus = accountStatus;
	}
	public BigLifeValidateMemberError getError() {
		return error;
	}
	public void setError(BigLifeValidateMemberError error) {
		this.error = error;
	}
	
	@Override
	public String toString() {
		
		return "MBBORSBigLifeValidateMemberResBean [code="+Integer.valueOf(code)+",message="+message+","
				+ "AccountStatus="+AccountStatus+",error={"+(error!=null?(error.toString()):"").toString()+"}]";
	
	}
}
