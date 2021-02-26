/**
 * 
 */
package com.maybank.orsapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author 80003905
 *
 */
public class ProgramDto {
	
	@JsonProperty
	private Long programId;
	
	@JsonProperty
	private String programDesc;
	
	@JsonProperty
	private String programCode;
	

	/**
	 * @return the programId
	 */
	public Long getProgramId() {
		return programId;
	}

	/**
	 * @param programId the programId to set
	 */
	public void setProgramId(Long programId) {
		this.programId = programId;
	}

	/**
	 * @return the programDesc
	 */
	public String getProgramDesc() {
		return programDesc;
	}

	/**
	 * @param programDesc the programDesc to set
	 */
	public void setProgramDesc(String programDesc) {
		this.programDesc = programDesc;
	}

	/**
	 * @return the programCode
	 */
	public String getProgramCode() {
		return programCode;
	}

	/**
	 * @param programCode the programCode to set
	 */
	public void setProgramCode(String programCode) {
		this.programCode = programCode;
	}
	
	

}
