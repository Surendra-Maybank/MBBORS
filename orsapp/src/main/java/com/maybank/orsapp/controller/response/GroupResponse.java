/**
 * 
 */
package com.maybank.orsapp.controller.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.maybank.orsapp.dto.GroupDto;

/**
 * @author 80003905
 *
 */

@JsonInclude(Include.NON_NULL)
public class GroupResponse {
	
	@JsonProperty
	private String responseCode;
	
	@JsonProperty
	private String responseMessage;
	
	@JsonProperty
	private GroupDto groupDto;
	
	@JsonProperty
	private List<GroupDto> listOfActiveGroups;

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
	 * @return the groupDto
	 */
	public GroupDto getGroupDto() {
		return groupDto;
	}

	/**
	 * @param groupDto the groupDto to set
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
	
	

}
