package com.maybank.orsapp.controller.response;

import java.util.List;

import com.maybank.orsapp.dto.TierRateDTO;

public class MBBORSGetAllTierRateRes extends MBBORSCommonRes{

	List<TierRateDTO> tierRateList;
	
	public List<TierRateDTO> getTierRateList() {
		return tierRateList;
	}
	public void setTierRateList(List<TierRateDTO> tierRateList) {
		this.tierRateList = tierRateList;
	}
			
}
