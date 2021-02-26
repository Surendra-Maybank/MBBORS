package com.maybank.orsapp.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RedemptionTxnMMPResponse {

	@JsonProperty
	private String responseCode;
	
	@JsonProperty
	private String responseMessage;
	
	@JsonProperty
	private List<RedemptionTxnMMPDetail> redemptionTxnMMPDetail;

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

	public List<RedemptionTxnMMPDetail> getRedemptionTxnMMPDetail() {
		return redemptionTxnMMPDetail;
	}

	public void setRedemptionTxnMMPDetail(List<RedemptionTxnMMPDetail> redemptionTxnMMPDetail) {
		this.redemptionTxnMMPDetail = redemptionTxnMMPDetail;
	}
}
