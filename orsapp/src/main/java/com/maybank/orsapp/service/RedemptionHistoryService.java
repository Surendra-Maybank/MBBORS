/**
 * 
 */
package com.maybank.orsapp.service;

import com.maybank.orsapp.controller.request.RedemptionHistorySearchRequest;
import com.maybank.orsapp.controller.response.RedemptionHistoryResponse;

/**
 * @author 80003905
 *
 */
public interface RedemptionHistoryService {
	
	public RedemptionHistoryResponse redemptionHistoryResponse(RedemptionHistorySearchRequest searchRequest);
	
	public RedemptionHistoryResponse redemptionHistoryViewResponse(Long pointTxnId);

}
