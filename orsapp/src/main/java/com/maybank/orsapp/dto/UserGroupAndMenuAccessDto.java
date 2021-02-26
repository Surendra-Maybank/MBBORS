package com.maybank.orsapp.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class UserGroupAndMenuAccessDto {
	
	@JsonProperty
	private String responseCode;
	
	@JsonProperty
	private String responseMessage;

	@JsonProperty
	private GroupDto groupDto;
	
	@JsonProperty
	private List<GroupDto> listOfActiveGroups;
	
	@JsonProperty
	private List<GroupAccessDto> groupAndMenuAccessList;
	
	
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

	/**
	 * @return the group
	 */
	public GroupDto getGroupDto() {
		return groupDto;
	}

	/**
	 * @param group the user to group
	 */
	public void setGroupDto(GroupDto groupDto) {
		this.groupDto = groupDto;
	}

	/**
	 * @return the listOfActiveGroups
	 */
	public List<GroupDto> getListOfActiveGroups() {
		return listOfActiveGroups;
	}

	/**
	 * @param listOfActiveGroups the listOfActiveGroups to set
	 */
	public void setListOfActiveGroups(List<GroupDto> listOfActiveGroups) {
		this.listOfActiveGroups = listOfActiveGroups;
	}

	/**
	 * @return the groupAndMenuAccessList
	 */
	public List<GroupAccessDto> getGroupAndMenuAccessList() {
		return groupAndMenuAccessList;
	}

	/**
	 * @param groupAndMenuAccessList the groupAndMenuAccessList to set
	 */
	public void setGroupAndMenuAccessList(List<GroupAccessDto> groupAndMenuAccessList) {
		this.groupAndMenuAccessList = groupAndMenuAccessList;
	}


}
