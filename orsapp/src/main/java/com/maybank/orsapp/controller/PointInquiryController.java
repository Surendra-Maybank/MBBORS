/**
 * 
 */
package com.maybank.orsapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maybank.orsapp.controller.request.PointsBalRequestDto;
import com.maybank.orsapp.controller.response.PointInquiryResponse;
import com.maybank.orsapp.service.PointInquiryService;

/**
 * @author 80003905
 *
 */

@RestController
@RequestMapping("/")
public class PointInquiryController {
	
	@Autowired
	PointInquiryService pointInquiryService;
	
	@PreAuthorize("hasRole('POINT_INQ_VIEW')")
	@PostMapping("/InquirePointsBalWithIcno")
	public ResponseEntity<PointInquiryResponse> getPointsBalForCustomerIcno(@RequestBody PointsBalRequestDto pointsBalRequestDto){
		return ResponseEntity.ok(pointInquiryService.pointInquiryForIcNo(pointsBalRequestDto.getCustomerIcNo()));
	}
	
	@PreAuthorize("hasRole('POINT_INQ_VIEW')")
	@PostMapping("/InquirePointsBalWithCardNo")
	public ResponseEntity<PointInquiryResponse> getPointsBalForCardNo(@RequestBody PointsBalRequestDto pointsBalRequestDto){
		return ResponseEntity.ok(pointInquiryService.pointInquiryForCardNo(pointsBalRequestDto.getCustomerCardNo()));	
	}
	
//	@PreAuthorize("hasRole('POINT_INQ_VIEW')")
	@PostMapping("/InquirePointsBalWithCardNoForTerminal")
	public ResponseEntity<PointInquiryResponse> getPointsBalForTerminal(@RequestBody PointsBalRequestDto pointsBalRequestDto){
		return ResponseEntity.ok(pointInquiryService.pointInquiryForTerminal(pointsBalRequestDto.getCustomerCardNo()));
	}
}
