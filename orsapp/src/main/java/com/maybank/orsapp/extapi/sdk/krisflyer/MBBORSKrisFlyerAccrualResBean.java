package com.maybank.orsapp.extapi.sdk.krisflyer;

public class MBBORSKrisFlyerAccrualResBean {

	private String code;
	private String status;
	private KrisFlyerAccrualRes response;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public KrisFlyerAccrualRes getResponse() {
		return response;
	}
	public void setResponse(KrisFlyerAccrualRes response) {
		this.response = response;
	}
	
	@Override
	public String toString() {
		
		return "MBBORSKrisFlyerAccrualResBean [code="+code+","
				+ "status="+status+",response={"+(response!=null?response.toString():"")+"}]";
	}
	
}
