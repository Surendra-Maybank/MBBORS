package com.maybank.orsapp.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InsertNewMerchantTidReq {
	
	@JsonProperty("tid")
	private String tid;

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}	

}
