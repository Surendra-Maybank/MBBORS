package com.maybank.orsapp.repository;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetMechantInfoBodyTIDRes {
	
	@JsonProperty("TID")
	private String TID;

	public String getTID() {
		return TID;
	}

	public void setTID(String tID) {
		TID = tID;
	}
	
	
}
