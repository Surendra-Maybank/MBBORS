package com.maybank.orsapp.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class SearchUserFromADDto {
	
	@JsonProperty
	private AdUserDto user;
	
	@JsonProperty
	private String responseCode;
	
	@JsonProperty
	private String responseMessage;

	/**
	 * @return the user
	 */
	public AdUserDto getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(AdUserDto user) {
		this.user = user;
	}

	/**
	 * @return the responseCode
	 */
	public String getResponseCode() {
		return responseCode;
	}

	/**
	 * @param responseCode the responseCode to set
	 */
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	/**
	 * @return the responseMessage
	 */
	public String getResponseMessage() {
		return responseMessage;
	}

	/**
	 * @param responseMessage the responseMessage to set
	 */
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	
	

}
