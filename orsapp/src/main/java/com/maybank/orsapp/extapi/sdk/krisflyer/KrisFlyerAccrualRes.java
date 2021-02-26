package com.maybank.orsapp.extapi.sdk.krisflyer;

public class KrisFlyerAccrualRes {
	
	private String transactionID;
	private String externalTransactionID;
	private String errorCode;
	private String errorDescription;
	
	public KrisFlyerAccrualRes() {}
	
	public KrisFlyerAccrualRes(String errorCode,String errorDescription) {
		this.errorCode = errorCode;
		this.errorDescription = errorDescription;
	}
	
	public String getTransactionID() {
		return transactionID;
	}
	public void setTransactionID(String transactionID) {
		this.transactionID = transactionID;
	}
	public String getExternalTransactionID() {
		return externalTransactionID;
	}
	public void setExternalTransactionID(String externalTransactionID) {
		this.externalTransactionID = externalTransactionID;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorDescription() {
		return errorDescription;
	}
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

	@Override
	public String toString() {
		
//		private String transactionID;
//		private String ;
//		private String errorCode;
//		private String errorDescription;
		
		return "transactionID="+transactionID+","
				+ "externalTransactionID="+externalTransactionID+","
				+ "errorCode="+errorCode+",errorDescription="+errorDescription+"";
	}
}
