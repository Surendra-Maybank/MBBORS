package com.maybank.orsapp.extapi.sdk.mmp;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetMechantInfoTIDRes {

	@JsonProperty("TID")
	private String tid;

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}
	
}
