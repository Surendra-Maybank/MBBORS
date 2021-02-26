package com.maybank.orsapp.extapi.sdk.airasia;

public class MBBORSBigLifePointsAccrualReqBean{

	private String memberId;
	
	private String partnerCode;
	
	private String transactionDate;

	private int amount;
	
	private String description;
	
	private String referenceNumber;
	
	private String partnerMID;
	
	public String getMemberId() {
		return memberId;
	}


	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}


	public String getPartnerCode() {
		return partnerCode;
	}


	public void setPartnerCode(String partnerCode) {
		this.partnerCode = partnerCode;
	}


	public String getTransactionDate() {
		return transactionDate;
	}


	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getReferenceNumber() {
		return referenceNumber;
	}


	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}


	public String getPartnerMID() {
		return partnerMID;
	}


	public void setPartnerMID(String partnerMID) {
		this.partnerMID = partnerMID;
	}


	@Override
	public String toString() {
		
		return "MBBORSBigPointsAccrualReqBean [memberId="+memberId+","
				+ "partnerCode="+partnerCode+",transactionDate="+transactionDate+","
				+ "amount="+Integer.valueOf(amount)+",description="+description+","
				+ "referenceNumber="+referenceNumber+",partnerMID="+partnerMID+"]";
	}
	
}
