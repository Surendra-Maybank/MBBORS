package com.maybank.orsapp.extapi.sdk.malindo;

public class DataContent {

	private int sourceCurrencyDebitQty;
	private int destCurrencyCreditQty;
	private String status;
	private String debitRef;
	private String creditRef;
	private String exchangeRef;
	
	public int getSourceCurrencyDebitQty() {
		return sourceCurrencyDebitQty;
	}
	public void setSourceCurrencyDebitQty(int sourceCurrencyDebitQty) {
		this.sourceCurrencyDebitQty = sourceCurrencyDebitQty;
	}
	public int getDestCurrencyCreditQty() {
		return destCurrencyCreditQty;
	}
	public void setDestCurrencyCreditQty(int destCurrencyCreditQty) {
		this.destCurrencyCreditQty = destCurrencyCreditQty;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDebitRef() {
		return debitRef;
	}
	public void setDebitRef(String debitRef) {
		this.debitRef = debitRef;
	}
	public String getCreditRef() {
		return creditRef;
	}
	public void setCreditRef(String creditRef) {
		this.creditRef = creditRef;
	}
	public String getExchangeRef() {
		return exchangeRef;
	}
	public void setExchangeRef(String exchangeRef) {
		this.exchangeRef = exchangeRef;
	}
	
	@Override
	public String toString() {
		
		return "{sourceCurrencyDebitQty=".concat(Integer.toString(sourceCurrencyDebitQty))
				.concat("destCurrencyCreditQty=").concat(Integer.toString(destCurrencyCreditQty)).concat(",")
				
				.concat("status=").concat(status).concat(",")
				.concat("debitRef=").concat(debitRef).concat(",")
				.concat("creditRef=").concat(creditRef).concat(",")
				.concat("exchangeRef=").concat(exchangeRef)
				.concat("}");
		
	}
}
