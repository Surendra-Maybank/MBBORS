/**
 * 
 */
package com.maybank.orsapp.controller.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.maybank.orsapp.dto.LoginMenuDto;
import com.maybank.orsapp.dto.ResponseMessageDto;
import com.maybank.orsapp.entities.User;

/**
 * @author 80003905
 *
 */
public class LoginResponse {
	
	@JsonProperty
	private String responseCode;
	
	@JsonProperty
	private String responseMessage;
	
	@JsonProperty
	private String userName;
	
	@JsonProperty
	private Long groupId;
	
	@JsonProperty
	private String emailId;
	
	@JsonProperty
	private Long loginSessionId;
	
	@JsonProperty
	private String jwtToken;
	
	@JsonProperty
	private List<LoginMenuDto> menuList;
	
	public LoginResponse() {
		super();
	}
	
	public LoginResponse(String username, Long groupId, String email, Long sessionId) {
		this.userName = username;
		this.emailId = email;
		this.loginSessionId = sessionId;
		this.groupId = groupId;
	}
	
	public LoginResponse(User user, Long sessionId, String jwtToken, ResponseMessageDto reponseMessage) {
		this.userName = user.getPfNo();
		this.emailId = user.getEmailId();
		this.loginSessionId = sessionId;
		this.groupId = user.getGroupId();
		this.jwtToken = jwtToken;
		this.responseMessage = reponseMessage.getResponseMessage();
		this.responseCode = reponseMessage.getResponseCode();
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

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the groupId
	 */
	public Long getGroupId() {
		return groupId;
	}

	/**
	 * @param groupId the groupId to set
	 */
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * @return the loginSessionId
	 */
	public Long getLoginSessionId() {
		return loginSessionId;
	}

	/**
	 * @param loginSessionId the loginSessionId to set
	 */
	public void setLoginSessionId(Long loginSessionId) {
		this.loginSessionId = loginSessionId;
	}
	
	/**
	 * @return the jwtToken
	 */
	public String getJwtToken() {
		return jwtToken;
	}

	/**
	 * @param jwtToken the jwtToken to set
	 */
	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}

	/**
	 * @return the menuList
	 */
	public List<LoginMenuDto> getMenuList() {
		return menuList;
	}

	/**
	 * @param menuList the menuList to set
	 */
	public void setMenuList(List<LoginMenuDto> menuList) {
		this.menuList = menuList;
	}
	
}
