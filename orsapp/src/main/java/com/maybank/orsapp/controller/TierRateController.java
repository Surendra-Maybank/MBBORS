package com.maybank.orsapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maybank.orsapp.controller.response.MBBORSGetAllTierRateRes;
import com.maybank.orsapp.service.TierRateService;

@RestController
@RequestMapping("/")
public class TierRateController {

	@Autowired
	TierRateService tierRateService;
	
	@GetMapping("/GetAllTierRateList")
	public ResponseEntity<MBBORSGetAllTierRateRes> GetAllTierRateList(){
		
		return ResponseEntity.ok(tierRateService.getAllTierRate());		
	}
}
