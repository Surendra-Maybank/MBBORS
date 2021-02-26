package com.maybank.orsapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RedemptionTxnDetailsMMPRequest {

	@JsonProperty
	private String pointTxnDetailID;

	public String getPointTxnDetailID() {
		return pointTxnDetailID;
	}

	public void setPointTxnDetailID(String pointTxnDetailID) {
		this.pointTxnDetailID = pointTxnDetailID;
	}
}
