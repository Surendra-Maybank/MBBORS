package com.maybank.orsapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ValidateAirlineRedeemProductResponse {

	@JsonProperty
	private String responseCode;
	
	@JsonProperty
	private String responseMessage;

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
}
