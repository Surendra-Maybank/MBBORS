package com.maybank.orsapp.controller.response;

import java.util.List;

import com.maybank.orsapp.dto.MerchantAllDTO;

public class MBBORSGetAllMerchantRes extends MBBORSCommonRes{
	
	private List<MerchantAllDTO> merchantList;
	
	public List<MerchantAllDTO> getMerchantList() {
		return merchantList;
	}
	public void setMerchantList(List<MerchantAllDTO> merchantList) {
		this.merchantList = merchantList;
	}
	
}
