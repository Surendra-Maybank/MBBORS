package com.maybank.orsapp.extapi.sdk.malindo;

public class MBBORSMalindoAccrualReq {
	
	private String agreementCode;
	private String sourceCurrencyCode;
	private String destCurrencyCode;
	private String qty;
	private String valueType;
	private String sourceAccountRef;
	private String destAccountRef;
	private String sourceOwnerRef;
	private String destOwnerRef;
	private String externalRef;
	private String debitRef;
	private String preStatus;
	private String debitTimestamp;
	private String index;
	
	public String getAgreementCode() {
		return agreementCode;
	}
	public void setAgreementCode(String agreementCode) {
		this.agreementCode = agreementCode;
	}
	public String getSourceCurrencyCode() {
		return sourceCurrencyCode;
	}
	public void setSourceCurrencyCode(String sourceCurrencyCode) {
		this.sourceCurrencyCode = sourceCurrencyCode;
	}
	public String getDestCurrencyCode() {
		return destCurrencyCode;
	}
	public void setDestCurrencyCode(String destCurrencyCode) {
		this.destCurrencyCode = destCurrencyCode;
	}
	public String getQty() {
		return qty;
	}
	public void setQty(String qty) {
		this.qty = qty;
	}
	public String getValueType() {
		return valueType;
	}
	public void setValueType(String valueType) {
		this.valueType = valueType;
	}
	public String getSourceAccountRef() {
		return sourceAccountRef;
	}
	public void setSourceAccountRef(String sourceAccountRef) {
		this.sourceAccountRef = sourceAccountRef;
	}
	public String getDestAccountRef() {
		return destAccountRef;
	}
	public void setDestAccountRef(String destAccountRef) {
		this.destAccountRef = destAccountRef;
	}
	public String getSourceOwnerRef() {
		return sourceOwnerRef;
	}
	public void setSourceOwnerRef(String sourceOwnerRef) {
		this.sourceOwnerRef = sourceOwnerRef;
	}
	public String getDestOwnerRef() {
		return destOwnerRef;
	}
	public void setDestOwnerRef(String destOwnerRef) {
		this.destOwnerRef = destOwnerRef;
	}
	public String getExternalRef() {
		return externalRef;
	}
	public void setExternalRef(String externalRef) {
		this.externalRef = externalRef;
	}
	public String getDebitRef() {
		return debitRef;
	}
	public void setDebitRef(String debitRef) {
		this.debitRef = debitRef;
	}
	public String getPreStatus() {
		return preStatus;
	}
	public void setPreStatus(String preStatus) {
		this.preStatus = preStatus;
	}
	public String getDebitTimestamp() {
		return debitTimestamp;
	}
	public void setDebitTimestamp(String debitTimestamp) {
		this.debitTimestamp = debitTimestamp;
	}
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	
	@Override
	public String toString() {
		
		return "MBBORSMalindoAccrualReq [agreementCode=".concat(agreementCode).concat(",")
				.concat("sourceCurrencyCode=").concat(sourceCurrencyCode).concat(",")				
				.concat("destCurrencyCode=").concat(destCurrencyCode).concat(",")				
				.concat("qty=").concat(qty).concat(",")				
				.concat("valueType=").concat(valueType).concat(",")				
				.concat("sourceAccountRef=").concat(sourceAccountRef).concat(",")				
				.concat("destAccountRef=").concat(destAccountRef).concat(",")				
				.concat("sourceOwnerRef=").concat(sourceOwnerRef).concat(",")				
				.concat("destOwnerRef=").concat(destOwnerRef).concat(",")				
				.concat("externalRef=").concat(externalRef).concat(",")				
				.concat("debitRef=").concat(debitRef).concat(",")				
				.concat("preStatus=").concat(preStatus).concat(",")				
				.concat("debitTimestamp=").concat(debitTimestamp).concat(",")				
				.concat("index=").concat(index);
	}
}
