/**
 * 
 */
package com.maybank.orsapp.controller;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.util.StringUtils;

import com.maybank.orsapp.controller.request.MBBORSPointRedemptionReq;
import com.maybank.orsapp.controller.request.MBBORSSearchProductRedemptionAndCardInfoReq;
import com.maybank.orsapp.controller.request.PointsBalRequestDto;
import com.maybank.orsapp.controller.response.MBBORSPointRedemptionRes;
import com.maybank.orsapp.controller.response.MBBORSSearchProductRedemptionAndCardInfoRes;
import com.maybank.orsapp.controller.response.PointInquiryResponse;
import com.maybank.orsapp.dao.PointRedemtionDaoImpl;
import com.maybank.orsapp.dto.DTCardInfoDto;
import com.maybank.orsapp.dto.ValidateAirlineRedeemProductRequest;
import com.maybank.orsapp.dto.ValidateAirlineRedeemProductResponse;
import com.maybank.orsapp.service.ProductRedemptionService;

/**
 * @author 80003905
 *
 */

@RestController
@RequestMapping("/")
public class PointRedemptionController {
	
	@Autowired
	PointRedemtionDaoImpl pointRedemptionDao;
	
	@Autowired
	ProductRedemptionService productRedemptionService;
	
	
	@PostMapping("/InquirePointsBalWithRewardTypeAndIcno")
	public ResponseEntity<PointInquiryResponse> getPointsBalForCustomerIcno(@RequestBody PointsBalRequestDto pointsBalRequestDto){
		PointInquiryResponse pointInquiry = new PointInquiryResponse();
		try {
			List<DTCardInfoDto> cardInfoList = pointRedemptionDao.getPointsBalForRewardTypeIdAndIcNo(pointsBalRequestDto.getRewardTypeId(), pointsBalRequestDto.getCustomerIcNo());
			if(CollectionUtils.isEmpty(cardInfoList)) {
				pointInquiry.setResponseCode("30");
				pointInquiry.setResponseMessage("Invalid IC No");
			}else {
				pointInquiry.setResponseCode("00");
				pointInquiry.setResponseMessage("Success");
				pointInquiry.setRewardTypeCardInfoList(cardInfoList);
			}
			//pointInquiry.setResponseMessage(responseMessage);
			return ResponseEntity.ok(pointInquiry);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	@PostMapping("/InquirePointsBalWithRewardTypeAndCardNo")
	public ResponseEntity<PointInquiryResponse> getPointsBalForCardNo(@RequestBody PointsBalRequestDto pointsBalRequestDto){
		PointInquiryResponse pointInquiry = new PointInquiryResponse();
		try {
			
			List<DTCardInfoDto> cardInfoList = pointRedemptionDao.getPointsBalForRewardTypeIdAndCustomerCreditCardNo(pointsBalRequestDto.getRewardTypeId(), pointsBalRequestDto.getCustomerCardNo());
			if(CollectionUtils.isEmpty(cardInfoList)) {
				List<DTCardInfoDto> debitCardInfoList = pointRedemptionDao.getPointsBalForRewardTypeIdAndCustomerDebitCardNo(pointsBalRequestDto.getRewardTypeId(), pointsBalRequestDto.getCustomerCardNo());
				if(CollectionUtils.isEmpty(debitCardInfoList)) {
					pointInquiry.setResponseCode("30");
					pointInquiry.setResponseMessage("Invalid Card Number");
				}else {
					pointInquiry.setResponseCode("00");
					pointInquiry.setResponseMessage("Success");
					pointInquiry.setRewardTypeCardInfoList(cardInfoList);
				}				
			}else {
				pointInquiry.setResponseCode("00");
				pointInquiry.setResponseMessage("Success");
				pointInquiry.setRewardTypeCardInfoList(cardInfoList);
			}
			//pointInquiry.setResponseMessage(responseMessage);
			return ResponseEntity.ok(pointInquiry);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	
/**	
	@PostMapping(value="/SearchProductRedemptionAndCardInfo",headers="Accept=application/json")
	public ResponseEntity<MBBORSSearchProductRedemptionAndCardInfoRes> SearchProductRedemptionAndCardInfo(
			@RequestBody MBBORSSearchProductRedemptionAndCardInfoReq request){
		
		return ResponseEntity.ok(productRedemptionService.searchProductRedemptionAndCardInfo(request));		
	}
	
	@PostMapping(value="/PointRedemption",headers="Accept=application/json")
	public ResponseEntity<MBBORSPointRedemptionRes> PointRedemption(
			@RequestBody MBBORSPointRedemptionReq request){
		
		return ResponseEntity.ok(productRedemptionService.pointRedemption(request));		
	}
**/
}
