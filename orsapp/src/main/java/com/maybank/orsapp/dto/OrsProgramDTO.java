package com.maybank.orsapp.dto;

public class OrsProgramDTO {
	
	private int programId;
	private String programCode;
	private String programDesc;
	private int rewardTypeId;
	
	public int getProgramId() {
		return programId;
	}
	public void setProgramId(int programId) {
		this.programId = programId;
	}
	public String getProgramCode() {
		return programCode;
	}
	public void setProgramCode(String programCode) {
		this.programCode = programCode;
	}
	public String getProgramDesc() {
		return programDesc;
	}
	public void setProgramDesc(String programDesc) {
		this.programDesc = programDesc;
	}
	public int getRewardTypeId() {
		return rewardTypeId;
	}
	public void setRewardTypeId(int rewardTypeId) {
		this.rewardTypeId = rewardTypeId;
	}
		
}
