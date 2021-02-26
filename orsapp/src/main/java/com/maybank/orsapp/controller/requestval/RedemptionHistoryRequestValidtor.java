/**
 * 
 */
package com.maybank.orsapp.controller.requestval;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.maybank.orsapp.controller.request.RedemptionHistorySearchRequest;

/**
 * @author 80003905
 *
 */

@Component
public class RedemptionHistoryRequestValidtor {
	
	public Boolean isValidRequest(RedemptionHistorySearchRequest searchRequest) {
		
		Boolean isValid = Boolean.FALSE;
		
		if(StringUtils.isBlank(searchRequest.getCustomerIcNo()) 
				&& StringUtils.isBlank(searchRequest.getOrderNo()) 
				&& StringUtils.isBlank(searchRequest.getMerchantId()) 
				&& StringUtils.isBlank(searchRequest.getRedemptionStartDate()) 
				&& StringUtils.isBlank(searchRequest.getRedemptionEndDate()) 
				&& StringUtils.isBlank(searchRequest.getMyTreatsOrderNo())) {
			
			isValid = Boolean.FALSE;
			
		}else {
			isValid = Boolean.TRUE;
		}		
		return isValid;
	}
}
