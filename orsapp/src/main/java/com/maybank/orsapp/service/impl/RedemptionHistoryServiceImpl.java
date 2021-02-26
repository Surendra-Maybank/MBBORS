/**
 * 
 */
package com.maybank.orsapp.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.maybank.orsapp.controller.request.RedemptionHistorySearchRequest;
import com.maybank.orsapp.controller.response.RedemptionHistoryResponse;
import com.maybank.orsapp.dto.RedemptionCustomerDto;
import com.maybank.orsapp.dto.RedemptionHistorySearchDto;
import com.maybank.orsapp.dto.RedemptionSearchCardDto;
import com.maybank.orsapp.dto.RedemptionSearchProductDto;
import com.maybank.orsapp.exceptions.ApplicationException;
import com.maybank.orsapp.exceptions.RequestDataValidationException;
import com.maybank.orsapp.repository.ApPointTxnRepositoryImpl;
import com.maybank.orsapp.service.RedemptionHistoryService;

/**
 * @author 80003905
 *
 */

@Service
public class RedemptionHistoryServiceImpl implements RedemptionHistoryService {
	
	Logger logger = LoggerFactory.getLogger(RedemptionHistoryServiceImpl.class);
	
	@Autowired
	ApPointTxnRepositoryImpl apPointTxnRepositoryImpl;

	@Override
	public RedemptionHistoryResponse redemptionHistoryResponse(RedemptionHistorySearchRequest searchRequest) {
		
		RedemptionHistoryResponse redemptionHistoryResponse = new RedemptionHistoryResponse();
		redemptionHistoryResponse.setTotalPointsRedeemed(null);
		try {
			List<RedemptionHistorySearchDto> redemptionSearchList = apPointTxnRepositoryImpl.getRedemptionHistorySearchList(searchRequest);
			
			if(CollectionUtils.isEmpty(redemptionSearchList)) {
				redemptionHistoryResponse.setResponseCode("01");
				redemptionHistoryResponse.setResponseMessage("No Records Found");
			}
			else {
				redemptionHistoryResponse.setResponseCode("00");
				redemptionHistoryResponse.setResponseMessage("Success");
				redemptionHistoryResponse.setRedemptionHistorySearchList(redemptionSearchList);
			}
		}catch(Exception e) {
			logger.error(e.getMessage(), e);
			throw new ApplicationException("SYSTEM_ERROR");
		}
		
		return redemptionHistoryResponse;
	}

	@Override
	public RedemptionHistoryResponse redemptionHistoryViewResponse(Long pointTxnId) {
		
		RedemptionHistoryResponse redemptionHistoryResponse = new RedemptionHistoryResponse();
		try {
			
			RedemptionCustomerDto redeemedCustomer = apPointTxnRepositoryImpl.getRedemptionCustomer(pointTxnId);
			if(redeemedCustomer != null) {
				
				redemptionHistoryResponse.setResponseCode("00");
				redemptionHistoryResponse.setResponseMessage("Success");
				redemptionHistoryResponse.setCustomerDetails(redeemedCustomer);
				List<RedemptionSearchCardDto> redeemedCardList = apPointTxnRepositoryImpl.getRedeemedCardList(pointTxnId);
				
				if(!CollectionUtils.isEmpty(redeemedCardList)) {
					redemptionHistoryResponse.setRedeemedCardList(redeemedCardList);
				}
				
				List<RedemptionSearchProductDto> redeemedProductList = apPointTxnRepositoryImpl.getRedeemedProductList(pointTxnId);
				
				if(!CollectionUtils.isEmpty(redeemedProductList)) {
					BigDecimal result = redeemedProductList.stream().map(productList -> productList.getTotalPoints()).reduce(BigDecimal.ZERO, BigDecimal::add);
					redemptionHistoryResponse.setTotalPointsRedeemed(result);
					redemptionHistoryResponse.setProductList(redeemedProductList);
				}
			}else {
				redemptionHistoryResponse.setResponseCode("01");
				redemptionHistoryResponse.setResponseMessage("No Records Found");
			}
			
		}catch(Exception e) {
			logger.error(e.getMessage(), e);
			throw new RequestDataValidationException("SYSTEM_ERROR");
		}
		
		return redemptionHistoryResponse;
	}
	
	

}
