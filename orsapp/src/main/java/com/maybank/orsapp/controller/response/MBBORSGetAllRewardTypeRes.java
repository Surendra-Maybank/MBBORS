package com.maybank.orsapp.controller.response;

import java.util.List;

import com.maybank.orsapp.dto.RewardTypeDTO;

public class MBBORSGetAllRewardTypeRes extends MBBORSCommonRes{

	private List<RewardTypeDTO> rewardTypeList;

	public List<RewardTypeDTO> getRewardTypeList() {
		return rewardTypeList;
	}

	public void setRewardTypeList(List<RewardTypeDTO> rewardTypeList) {
		this.rewardTypeList = rewardTypeList;
	}

}
