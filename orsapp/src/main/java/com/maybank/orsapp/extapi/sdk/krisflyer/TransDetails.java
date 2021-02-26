package com.maybank.orsapp.extapi.sdk.krisflyer;

public class TransDetails {
	

	private String conversionRate;
	private int partnerProgramPoint;
	private int requestorPgmPoint;
	private String transactionDate;
	private String transactionDescription;
	
	public String getConversionRate() {
		return conversionRate;
	}
	public void setConversionRate(String conversionRate) {
		this.conversionRate = conversionRate;
	}
	public int getPartnerProgramPoint() {
		return partnerProgramPoint;
	}
	public void setPartnerProgramPoint(int partnerProgramPoint) {
		this.partnerProgramPoint = partnerProgramPoint;
	}
	public int getRequestorPgmPoint() {
		return requestorPgmPoint;
	}
	public void setRequestorPgmPoint(int requestorPgmPoint) {
		this.requestorPgmPoint = requestorPgmPoint;
	}
	public String getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getTransactionDescription() {
		return transactionDescription;
	}
	public void setTransactionDescription(String transactionDescription) {
		this.transactionDescription = transactionDescription;
	}
	
	@Override
	public String toString() {
		
		return "conversionRate="+conversionRate+",partnerProgramPoint="+Integer.valueOf(partnerProgramPoint)+","
				+ "requestorPgmPoint="+Integer.valueOf(requestorPgmPoint)+",transactionDate="+transactionDate+","
				+ "transactionDescription="+transactionDescription;
		
	}
	
}
