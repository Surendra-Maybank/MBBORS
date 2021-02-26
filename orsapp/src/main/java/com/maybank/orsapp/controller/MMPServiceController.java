package com.maybank.orsapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maybank.orsapp.dao.MMPServiceDao;
import com.maybank.orsapp.dto.RedemptionTxnDetailsMMPRequest;
import com.maybank.orsapp.dto.RedemptionTxnDetailsMMPResponse;
import com.maybank.orsapp.dto.RedemptionTxnMMPDetail;
import com.maybank.orsapp.dto.RedemptionTxnMMPRequest;
import com.maybank.orsapp.dto.RedemptionTxnMMPResponse;
import com.maybank.orsapp.dto.UpdateDeliveryStatusMMPRequest;
import com.maybank.orsapp.dto.UpdateDeliveryStatusMMPResponse;

@RestController
@RequestMapping("/")
public class MMPServiceController {

	@Autowired
	MMPServiceDao mmpServiceDao;
	
	@PostMapping("/getRedemptionTxnMMP")
	public ResponseEntity<RedemptionTxnMMPResponse> getRedemptionTxnMMP(@RequestBody RedemptionTxnMMPRequest redemptionTxnMMPRequest){
		RedemptionTxnMMPResponse redemptionTxnMMPResponse = new RedemptionTxnMMPResponse();
		try {
			// check mandatory field
			if(!StringUtils.isEmpty(redemptionTxnMMPRequest.getORSMID())
			&& !StringUtils.isEmpty(redemptionTxnMMPRequest.getStartDate())
			&& !StringUtils.isEmpty(redemptionTxnMMPRequest.getEndDate())) {
				List<RedemptionTxnMMPDetail> redemptionTxnMMPDetail = mmpServiceDao.getRedemptionTxnMMP(redemptionTxnMMPRequest);
				if(!CollectionUtils.isEmpty(redemptionTxnMMPDetail)) {
					redemptionTxnMMPResponse.setResponseCode("00");
					redemptionTxnMMPResponse.setResponseMessage("Success");
					redemptionTxnMMPResponse.setRedemptionTxnMMPDetail(redemptionTxnMMPDetail);
				}else {
					redemptionTxnMMPResponse.setResponseCode("01");
					redemptionTxnMMPResponse.setResponseMessage("No Record");
				}
			}else {
				redemptionTxnMMPResponse.setResponseCode("97");
				redemptionTxnMMPResponse.setResponseMessage("Missing Mandatory Field");
			}
		}catch(EmptyResultDataAccessException e) {
			redemptionTxnMMPResponse.setResponseCode("98");
			redemptionTxnMMPResponse.setResponseMessage("EmptyResultDataAccessException");
		}catch(Exception e) {
			// print error
			redemptionTxnMMPResponse.setResponseCode("99");
			redemptionTxnMMPResponse.setResponseMessage("System Error");
		}
		return ResponseEntity.ok(redemptionTxnMMPResponse);
	}
	
	@PostMapping("/getRedemptionTxnDetailsMMP")
	public ResponseEntity<RedemptionTxnDetailsMMPResponse> getRedemptionTxnDetailsMMP(@RequestBody RedemptionTxnDetailsMMPRequest redemptionTxnDetailsMMPRequest){
		RedemptionTxnDetailsMMPResponse redemptionTxnDetailsMMPResponse = new RedemptionTxnDetailsMMPResponse();
		try {
			
			// check mandatory field
			if(!StringUtils.isEmpty(redemptionTxnDetailsMMPRequest.getPointTxnDetailID())){
				redemptionTxnDetailsMMPResponse = mmpServiceDao.getRedemptionTxnDetailsMMP(redemptionTxnDetailsMMPRequest);
			
				if(!StringUtils.isEmpty(redemptionTxnDetailsMMPResponse.getOrderNumber())){
					redemptionTxnDetailsMMPResponse.setResponseCode("00");
					redemptionTxnDetailsMMPResponse.setResponseMessage("Success");
				}else {
					redemptionTxnDetailsMMPResponse.setResponseCode("01");
					redemptionTxnDetailsMMPResponse.setResponseMessage("No Record");
				}
			}else {
				redemptionTxnDetailsMMPResponse.setResponseCode("97");
				redemptionTxnDetailsMMPResponse.setResponseMessage("Missing Mandatory Field");
			}
		}catch(EmptyResultDataAccessException e) {
			redemptionTxnDetailsMMPResponse.setResponseCode("98");
			redemptionTxnDetailsMMPResponse.setResponseMessage("EmptyResultDataAccessException");
		}catch(Exception e) {
			redemptionTxnDetailsMMPResponse.setResponseCode("99");
			redemptionTxnDetailsMMPResponse.setResponseMessage("System Error");
		}
		return ResponseEntity.ok(redemptionTxnDetailsMMPResponse);
	}
	
	@PostMapping("/updateDeliveryStatusMMP")
	public ResponseEntity<UpdateDeliveryStatusMMPResponse> updateDeliveryStatusMMP(@RequestBody UpdateDeliveryStatusMMPRequest updateDeliveryStatusMMPRequest){
		UpdateDeliveryStatusMMPResponse updateDeliveryStatusMMPResponse = new UpdateDeliveryStatusMMPResponse();
		try {
			// double check value
			if(!StringUtils.isEmpty(updateDeliveryStatusMMPRequest.getPointTxnDetailID())
			&& !StringUtils.isEmpty(updateDeliveryStatusMMPRequest.getCourierRefNo())
			&& !StringUtils.isEmpty(updateDeliveryStatusMMPRequest.getCourierDate())
			&& !StringUtils.isEmpty(updateDeliveryStatusMMPRequest.getUserPFNo())) {
				int updateStatus = mmpServiceDao.updateDeliveryStatusMMP(updateDeliveryStatusMMPRequest);
				if(updateStatus>0) {
					updateDeliveryStatusMMPResponse.setResponseCode("00");
					updateDeliveryStatusMMPResponse.setResponseMessage("Success");
				}else {
					updateDeliveryStatusMMPResponse.setResponseCode("01");
					updateDeliveryStatusMMPResponse.setResponseMessage("No Record Updated");
				}
			}else {
				updateDeliveryStatusMMPResponse.setResponseCode("97");
				updateDeliveryStatusMMPResponse.setResponseMessage("Missing Mandatory Field");
			}
		}catch(EmptyResultDataAccessException e) {
			updateDeliveryStatusMMPResponse.setResponseCode("98");
			updateDeliveryStatusMMPResponse.setResponseMessage("EmptyResultDataAccessException");
		}catch(Exception e) {
			updateDeliveryStatusMMPResponse.setResponseCode("99");
			updateDeliveryStatusMMPResponse.setResponseMessage("System Error");
		}
		return ResponseEntity.ok(updateDeliveryStatusMMPResponse);
	}
	
}
