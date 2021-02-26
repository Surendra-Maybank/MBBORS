package com.maybank.orsapp.extapi.sdk.mmp;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetMechantInfoRes {

	@JsonProperty("MerchantNo")
	private String merchantNo;
	@JsonProperty("MerchantName")
	private String merchantName;
	@JsonProperty("StoreNo")
	private String storeNo;
	@JsonProperty("StoreName")
	private String storeName;
	
	public String getMerchantNo() {
		return merchantNo;
	}
	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}
	public String getMerchantName() {
		return merchantName;
	}
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}
	public String getStoreNo() {
		return storeNo;
	}
	public void setStoreNo(String storeNo) {
		this.storeNo = storeNo;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	
}
