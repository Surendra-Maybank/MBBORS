/**
 * 
 */
package com.maybank.orsapp.controller.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.maybank.orsapp.dto.MenuDto;

/**
 * @author 80003905
 *
 */

@JsonInclude(Include.NON_NULL)
public class MenuResponse {
	
	@JsonProperty
	private String responseCode;
	
	@JsonProperty
	private String responseMessage;
	
	@JsonProperty
	private List<MenuDto> listOfActiveMenus;

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
	 * @return the listOfActiveMenus
	 */
	public List<MenuDto> getListOfActiveMenus() {
		return listOfActiveMenus;
	}

	/**
	 * @param listOfActiveMenus the listOfActiveMenus to set
	 */
	public void setListOfActiveMenus(List<MenuDto> listOfActiveMenus) {
		this.listOfActiveMenus = listOfActiveMenus;
	}
	
	

}
