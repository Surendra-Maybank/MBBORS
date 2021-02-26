package com.maybank.orsapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maybank.orsapp.controller.response.MBBORSGetAllRewardTypeRes;
import com.maybank.orsapp.service.RewardTypeService;

@RestController
@RequestMapping("/")
public class RewardTypeController {

	@Autowired
	RewardTypeService rewardTypeService;
	
	@GetMapping("/GetAllRewardTypeList")
	public ResponseEntity<MBBORSGetAllRewardTypeRes> GetAllRewardTypeList(){
		
		return ResponseEntity.ok(rewardTypeService.getAllRewardTypeList());		
	}
}
