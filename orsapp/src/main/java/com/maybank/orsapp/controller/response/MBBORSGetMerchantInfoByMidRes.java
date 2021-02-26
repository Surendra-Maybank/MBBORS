package com.maybank.orsapp.controller.response;

public class MBBORSGetMerchantInfoByMidRes extends MBBORSCommonRes{

	private String MerchantNo;
	private String MerchantName;
	private String StoreNo;
	private String StoreName;
	private String[] teminalList;

	public String getMerchantNo() {
		return MerchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		MerchantNo = merchantNo;
	}

	public String getMerchantName() {
		return MerchantName;
	}

	public void setMerchantName(String merchantName) {
		MerchantName = merchantName;
	}

	public String getStoreNo() {
		return StoreNo;
	}

	public void setStoreNo(String storeNo) {
		StoreNo = storeNo;
	}

	public String getStoreName() {
		return StoreName;
	}

	public void setStoreName(String storeName) {
		StoreName = storeName;
	}

	public String[] getTeminalList() {
		return teminalList;
	}

	public void setTeminalList(String[] teminaList) {
		this.teminalList = teminaList;
	}

}
