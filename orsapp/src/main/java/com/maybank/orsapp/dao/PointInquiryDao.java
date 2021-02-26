/**
 * 
 */
package com.maybank.orsapp.dao;

import java.util.List;

import com.maybank.orsapp.dto.DTCardInfoDto;

/**
 * @author 80003905
 *
 */
public interface PointInquiryDao {

	List<DTCardInfoDto> pointInquiryResponseForIcNo(String customerIcNo);
	
	List<DTCardInfoDto> pointInquiryResponseForCustomerCreditCardNo(String customerCreditCardNo);

	List<DTCardInfoDto> pointInquiryResponseForCustomerDebitCardNo(String customerDebitCardNo);
	
	public List<DTCardInfoDto> pointInquiryTerminalForCustomerCreditCardNo(String customerCreditCardNo);

	public List<DTCardInfoDto> pointInquiryTerminalForCustomerDebitCardNo(String customerDebitCardNo);
	
	public Double getConversionRate();

}
