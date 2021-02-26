package com.maybank.orsapp.controller;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maybank.orsapp.controller.request.MBBORSM2UPointRedemptionReq;
import com.maybank.orsapp.controller.request.MBBORSPointRedemptionAirlineReq;
import com.maybank.orsapp.controller.request.MBBORSPointRedemptionReq;
import com.maybank.orsapp.controller.request.MBBORSSearchProductRedemptionAndCardInfoAirlineReq;
import com.maybank.orsapp.controller.request.MBBORSSearchProductRedemptionAndCardInfoReq;
import com.maybank.orsapp.controller.request.MBBORSTerminalPointRedemptionReq;
import com.maybank.orsapp.controller.response.MBBORSM2UPointRedemptionRes;
import com.maybank.orsapp.controller.response.MBBORSPointRedemptionAirlineRes;
import com.maybank.orsapp.controller.response.MBBORSPointRedemptionRes;
import com.maybank.orsapp.controller.response.MBBORSSearchProductRedemptionAndCardInfoAirlineRes;
import com.maybank.orsapp.controller.response.MBBORSSearchProductRedemptionAndCardInfoRes;
import com.maybank.orsapp.controller.response.MBBORSTerminalPointRedemptionRes;
import com.maybank.orsapp.dto.ValidateAirlineRedeemProductRequest;
import com.maybank.orsapp.dto.ValidateAirlineRedeemProductResponse;
import com.maybank.orsapp.service.ProductRedemptionService;

@RestController
@RequestMapping("/")
public class ProductRedemptionController {

	private final Logger logger = LoggerFactory.getLogger(TerminalController.class);
	
	@Autowired
	ProductRedemptionService productRedemptionService;
	
	@PostMapping(value="/SearchProductRedemptionAndCardInfo",headers="Accept=application/json")
	public ResponseEntity<MBBORSSearchProductRedemptionAndCardInfoRes> SearchProductRedemptionAndCardInfo(
			@RequestBody MBBORSSearchProductRedemptionAndCardInfoReq request){
		
		return ResponseEntity.ok(productRedemptionService.searchProductRedemptionAndCardInfo(request));		
	}
	
	@PostMapping(value="/SearchProductRedemptionAndCardInfoAirline",headers="Accept=application/json")
	public ResponseEntity<MBBORSSearchProductRedemptionAndCardInfoAirlineRes> SearchProductRedemptionAndCardInfoAirline(
			@RequestBody MBBORSSearchProductRedemptionAndCardInfoAirlineReq request){
		
		return ResponseEntity.ok(productRedemptionService.searchProductRedemptionAndCardInfoAirline(request));		
	}
	
	@PostMapping(value="/PointRedemption",headers="Accept=application/json")
	public ResponseEntity<MBBORSPointRedemptionRes> PointRedemption(
			@RequestBody MBBORSPointRedemptionReq request){
		
		return ResponseEntity.ok(productRedemptionService.pointRedemption(request));		
	}
	
	@PostMapping(value="/PointRedemptionAirline",headers="Accept=application/json")
	public ResponseEntity<MBBORSPointRedemptionAirlineRes> PointRedemptionAirline(
			@RequestBody MBBORSPointRedemptionAirlineReq request){
		
		return ResponseEntity.ok(productRedemptionService.pointRedemptionAirline(request));		
	}
	
	@PostMapping(value="/M2UPointRedemption",headers="Accept=application/json")
	public ResponseEntity<MBBORSM2UPointRedemptionRes> M2UPointRedemption(
			@RequestBody MBBORSM2UPointRedemptionReq request){
		logger.info("##Received Request M2UPointRedemption : [".concat(request.toString()).concat("]"));
		
		MBBORSM2UPointRedemptionRes res = productRedemptionService.m2uPointRedemption(request);
		
		logger.info("##Respond M2UPointRedemption : [".concat(res.toString()).concat("]"));
		
		return ResponseEntity.ok(res);		
	}
	
	@PostMapping(value="/TerminalValueRedemption",headers="Accept=application/json")
	public ResponseEntity<MBBORSTerminalPointRedemptionRes> TerminalValueRedemption(
			@RequestBody MBBORSTerminalPointRedemptionReq request){
		
		MBBORSTerminalPointRedemptionRes res = productRedemptionService.terminalPointRedemption(request);
		
		return ResponseEntity.ok(res);		
	}
	
	
	@PostMapping(value="/validateAirlineRedeemProduct",headers="Accept=application/json")
	public ResponseEntity<ValidateAirlineRedeemProductResponse> validateAirlineRedeemProduct(@RequestBody ValidateAirlineRedeemProductRequest validateAirlineRedeemProductRequest){
		
		ValidateAirlineRedeemProductResponse validateAirlineRedeemProductResponse = 
				productRedemptionService.validateAirlineRedeemProduct(validateAirlineRedeemProductRequest);
		
		return ResponseEntity.ok(validateAirlineRedeemProductResponse);
	}
}
