package com.maybank.orsapp.service;

import java.math.BigDecimal;

import com.maybank.orsapp.controller.request.MBBORSEditMerchantReq;
import com.maybank.orsapp.controller.request.MBBORSInsertNewMerchantReq;
import com.maybank.orsapp.controller.response.MBBORSEditMerchantRes;
import com.maybank.orsapp.controller.response.MBBORSGetAllMerchantRes;
import com.maybank.orsapp.controller.response.MBBORSGetMerchantDetailByMidRes;
import com.maybank.orsapp.controller.response.MBBORSGetMerchantInfoByMidRes;
import com.maybank.orsapp.controller.response.MBBORSInsertNewMerchantRes;
import com.maybank.orsapp.controller.response.MBBORSDeleteMerchantRes;

public interface MerchantService {

    public MBBORSGetMerchantInfoByMidRes getMMPMerchantDetails(String mid);
	
	public MBBORSGetAllMerchantRes getAllMerchant();
    
    public MBBORSGetMerchantDetailByMidRes getMerchantDetailByMerchantId(BigDecimal merchantId); 
    
    public MBBORSInsertNewMerchantRes insertNewMerchant(MBBORSInsertNewMerchantReq request); 
    
    public MBBORSDeleteMerchantRes deleteMerchant(BigDecimal merchantId, String username); 
    
    public MBBORSEditMerchantRes editMerchant(MBBORSEditMerchantReq request);
}
