/**
 * 
 */
package com.maybank.orsapp.service;

import com.maybank.orsapp.controller.response.PointInquiryResponse;

/**
 * @author 80003905
 *
 */


public interface PointInquiryService {
	
	public PointInquiryResponse pointInquiryForIcNo(String customerIcNo);
	
	public PointInquiryResponse pointInquiryForCardNo(String customerCardNo);
	
	public PointInquiryResponse pointInquiryForTerminal(String customerCardNo);

}
