package com.maybank.orsapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maybank.orsapp.constant.MBBORSConstant;
import com.maybank.orsapp.controller.response.MBBORSGetAllRewardTypeRes;
import com.maybank.orsapp.dto.RewardTypeDTO;
import com.maybank.orsapp.repository.RewardTypeRepository;
import com.maybank.orsapp.service.RewardTypeService;

@Service
public class RewardTypeServiceImpl implements RewardTypeService{
	
	@Autowired
	RewardTypeRepository rewardTypeRepository;
	
	public MBBORSGetAllRewardTypeRes getAllRewardTypeList() {
		MBBORSGetAllRewardTypeRes res = new MBBORSGetAllRewardTypeRes();
		
		try {
			List<RewardTypeDTO> resultList = rewardTypeRepository.getAllRewardTypeList();
			res.setResponseCode(MBBORSConstant.RES_CODE_SUCCESS);
			res.setResponseMessage(MBBORSConstant.RES_DESC_SUCCESS);
			res.setRewardTypeList(resultList);
		}catch(Exception ex) {
			res.setResponseCode(MBBORSConstant.RES_CODE_SYSTEM_ERROR);
			res.setResponseMessage(MBBORSConstant.RES_DESC_SYSTEM_ERROR);
			ex.printStackTrace();
		}
		
		return res;
	};


}
