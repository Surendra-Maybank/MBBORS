package com.maybank.orsapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.maybank.orsapp.entities.User;

public class AdUserDto {
	
	@JsonProperty
	private String pfNo;
	
	@JsonProperty
	private String firstName;
	
	@JsonProperty
	private String lastName;
	
	@JsonProperty
	private String emailId;
	
	@JsonProperty
	private String telephoneNumber;
	
	public AdUserDto(User user) {
		this.pfNo = user.getPfNo();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.telephoneNumber = user.getTelephoneNumber();
	}

	/**
	 * @return the pfNo
	 */
	public String getPfNo() {
		return pfNo;
	}

	/**
	 * @param pfNo the pfNo to set
	 */
	public void setPfNo(String pfNo) {
		this.pfNo = pfNo;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	 * @return the telephoneNumber
	 */
	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	/**
	 * @param telephoneNumber the telephoneNumber to set
	 */
	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}
	
	

}
