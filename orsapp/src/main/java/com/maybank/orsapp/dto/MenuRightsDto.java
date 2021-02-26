package com.maybank.orsapp.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class MenuRightsDto {
	
	@JsonProperty
	private String name;
	
	@JsonProperty
	private Boolean access = Boolean.FALSE;
	
	@JsonProperty
	private Boolean checked = Boolean.FALSE;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the access
	 */
	public Boolean getAccess() {
		return access;
	}

	/**
	 * @param access the access to set
	 */
	public void setAccess(Boolean access) {
		this.access = access;
	}

	/**
	 * @return the checked
	 */
	public Boolean getChecked() {
		return checked;
	}

	/**
	 * @param checked the checked to set
	 */
	public void setChecked(Boolean checked) {
		this.checked = checked;
	}
	
	

}
