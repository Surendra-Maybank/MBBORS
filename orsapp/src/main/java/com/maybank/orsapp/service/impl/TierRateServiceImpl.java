package com.maybank.orsapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maybank.orsapp.constant.MBBORSConstant;
import com.maybank.orsapp.controller.response.MBBORSGetAllTierRateRes;
import com.maybank.orsapp.dto.TierRateDTO;
import com.maybank.orsapp.repository.TierRateRepositoryCustomImpl;
import com.maybank.orsapp.service.TierRateService;

@Service
public class TierRateServiceImpl implements TierRateService{

	@Autowired
	TierRateRepositoryCustomImpl tierRateRepository;
	
	public MBBORSGetAllTierRateRes getAllTierRate() {
		MBBORSGetAllTierRateRes res = new MBBORSGetAllTierRateRes();
		
		try {
			List<TierRateDTO> resultList = tierRateRepository.getAllTierRate();
			res.setResponseCode(MBBORSConstant.RES_CODE_SUCCESS);
			res.setResponseMessage(MBBORSConstant.RES_DESC_SUCCESS);
			res.setTierRateList(resultList);
		}catch(Exception ex) {
			res.setResponseCode(MBBORSConstant.RES_CODE_SYSTEM_ERROR);
			res.setResponseMessage(MBBORSConstant.RES_DESC_SYSTEM_ERROR);
		}
		
		return res;
	};

}
