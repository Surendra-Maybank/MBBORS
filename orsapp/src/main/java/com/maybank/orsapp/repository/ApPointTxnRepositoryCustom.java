/**
 * 
 */
package com.maybank.orsapp.repository;

import java.util.List;

import com.maybank.orsapp.controller.request.RedemptionHistorySearchRequest;
import com.maybank.orsapp.dto.RedemptionCustomerDto;
import com.maybank.orsapp.dto.RedemptionHistorySearchDto;
import com.maybank.orsapp.dto.RedemptionSearchCardDto;
import com.maybank.orsapp.dto.RedemptionSearchProductDto;
import com.maybank.orsapp.entities.ApPointTxnBucketDetails;

/**
 * @author 80003905
 *
 */
public interface ApPointTxnRepositoryCustom {
	
	public List<RedemptionHistorySearchDto> getRedemptionHistorySearchList(RedemptionHistorySearchRequest searchRequest);
	
	public RedemptionCustomerDto getRedemptionCustomer(Long pointTxnId);
	
	public List<RedemptionSearchProductDto> getRedeemedProductList(Long pointTxnId);
	
	public List<RedemptionSearchCardDto> getRedeemedCardList(Long pointTxnId);

	public List<ApPointTxnBucketDetails> getPointTxnBucketDetailsForVoidRedemption(Long pointTxnId);

}
