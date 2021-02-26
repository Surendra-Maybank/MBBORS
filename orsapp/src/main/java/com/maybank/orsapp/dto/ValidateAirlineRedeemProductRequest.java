package com.maybank.orsapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ValidateAirlineRedeemProductRequest {

	@JsonProperty
	private String productID;
	
	@JsonProperty
	private String icNumber;
	
	@JsonProperty
	private String rewardTypeID;

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getIcNumber() {
		return icNumber;
	}

	public void setIcNumber(String icNumber) {
		this.icNumber = icNumber;
	}

	public String getRewardTypeID() {
		return rewardTypeID;
	}

	public void setRewardTypeID(String rewardTypeID) {
		this.rewardTypeID = rewardTypeID;
	}

}
