/**
 * 
 */
package com.maybank.orsapp.repository;

import java.util.List;

import com.maybank.orsapp.dto.CardHolderPointBucketDto;
import com.maybank.orsapp.dto.MTCardHolderPointBucketDTO;

/**
 * @author 80003905
 *
 */
public interface CardHolderPointBucketRepositoryCustom {
	
	public List<CardHolderPointBucketDto> pointInquiryResponseForIcNo(String customerIcNo, List<Long> programId);
	
	public List<CardHolderPointBucketDto> pointInquiryResponseForCustomerCreditCardNo(String customerCreditCardNo, Boolean isTerminal);

	public List<CardHolderPointBucketDto> pointInquiryResponseForCustomerDebitCardNo(String customerDebitCardNo, Boolean isTerminal);

	public List<MTCardHolderPointBucketDTO> getPointBucketDetailsForVoidRedemption(Long pointTxnId);

}
