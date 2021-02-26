package com.maybank.orsapp.dao;

import java.util.ArrayList;

import com.maybank.orsapp.dto.RedemptionTxnDetailsMMPRequest;
import com.maybank.orsapp.dto.RedemptionTxnDetailsMMPResponse;
import com.maybank.orsapp.dto.RedemptionTxnMMPDetail;
import com.maybank.orsapp.dto.RedemptionTxnMMPRequest;
import com.maybank.orsapp.dto.UpdateDeliveryStatusMMPRequest;

public interface MMPServiceDao {

	public ArrayList<RedemptionTxnMMPDetail> getRedemptionTxnMMP(RedemptionTxnMMPRequest redemptionTxnMMPRequest) throws Exception;
	
	public RedemptionTxnDetailsMMPResponse getRedemptionTxnDetailsMMP(RedemptionTxnDetailsMMPRequest redemptionTxnDetailsMMPRequest) throws Exception;

	public int updateDeliveryStatusMMP(UpdateDeliveryStatusMMPRequest updateDeliveryStatusMMPRequest) throws Exception;

}
