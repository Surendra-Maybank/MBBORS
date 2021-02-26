package com.maybank.orsapp.controller.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.maybank.orsapp.dto.UserDto;

@JsonInclude(Include.NON_NULL)
public class UserResponse {
	
	@JsonProperty
	private String responseCode;
	
	@JsonProperty
	private String responseMessage;
	
	@JsonProperty
	private UserDto userDto;
	
	@JsonProperty
	private List<UserDto> listOfActiveUsers;

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

	/**
	 * @return the userDto
	 */
	public UserDto getUserDto() {
		return userDto;
	}

	/**
	 * @param userDto the userDto to set
	 */
	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}

	/**
	 * @return the listOfActiveUsers
	 */
	public List<UserDto> getListOfActiveUsers() {
		return listOfActiveUsers;
	}

	/**
	 * @param listOfActiveUsers the listOfActiveUsers to set
	 */
	public void setListOfActiveUsers(List<UserDto> listOfActiveUsers) {
		this.listOfActiveUsers = listOfActiveUsers;
	}
	
	

}
