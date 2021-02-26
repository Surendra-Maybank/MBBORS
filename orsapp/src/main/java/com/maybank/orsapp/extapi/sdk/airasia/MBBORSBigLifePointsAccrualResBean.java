package com.maybank.orsapp.extapi.sdk.airasia;

public class MBBORSBigLifePointsAccrualResBean{

	private int code;
	private String message;
	private String transactionId;
	private String memberId;
	private String partnerCode;
	private String type;
	private String processingDate;
	private String transactionDate;
	private String referenceNumber;
	private String description;
	private int amount;
	private String voidId;
	
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
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getProcessingDate() {
		return processingDate;
	}
	public void setProcessingDate(String processingDate) {
		this.processingDate = processingDate;
	}
	public String getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getReferenceNumber() {
		return referenceNumber;
	}
	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getVoidId() {
		return voidId;
	}
	public void setVoidId(String voidId) {
		this.voidId = voidId;
	}
	
	@Override
	public String toString() {
	
		return "MBBORSBigLifePointsAccrualResBean [code="+Integer.valueOf(code)+",message="+message+","
				+ "transactionId="+transactionId+",memberId="+memberId+","
				+ "partnerCode="+partnerCode+",type="+type+","
				+ "processingDate="+processingDate+",transactionDate="+transactionDate+","
				+ "referenceNumber="+referenceNumber+",description="+description+","
				+ "amount="+amount+",voidId="+voidId+"]";
	
	}
	
}
