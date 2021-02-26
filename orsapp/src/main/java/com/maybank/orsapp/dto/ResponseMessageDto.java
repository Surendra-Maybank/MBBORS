package com.maybank.orsapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseMessageDto {
	
	@JsonProperty
	private String responseCode;
	
	@JsonProperty
	private String responseMessage;
	
	/**
	 * 
	 */
	public ResponseMessageDto() {
		
	}

	/**
	 * @param responseCode
	 * @param responseMessage
	 */
	public ResponseMessageDto(String responseCode, String responseMessage) {
		this.responseCode = responseCode;
		this.responseMessage = responseMessage;
	}

	/**
	 * @return the code
	 */
	public String getResponseCode() {
		return responseCode;
	}

	/**
	 * @param code the code to set
	 */
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	/**
	 * @return the message
	 */
	public String getResponseMessage() {
		return responseMessage;
	}

	/**
	 * @param message the message to set
	 */
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	
	

}
