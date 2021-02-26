package com.maybank.orsapp.extapi.sdk.mmp;

public class CommonHeaderReq {

	private String projectID;
	private String tranID;
	private String postedTimestamp;

	public String getProjectID() {
		return projectID;
	}

	public void setProjectID(String projectID) {
		this.projectID = projectID;
	}

	public String getTranID() {
		return tranID;
	}

	public void setTranID(String tranID) {
		this.tranID = tranID;
	}

	public String getPostedTimestamp() {
		return postedTimestamp;
	}

	public void setPostedTimestamp(String postedTimestamp) {
		this.postedTimestamp = postedTimestamp;
	}

}
