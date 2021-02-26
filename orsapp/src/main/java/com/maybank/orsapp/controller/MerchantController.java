package com.maybank.orsapp.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maybank.orsapp.controller.request.MBBORSEditMerchantReq;
import com.maybank.orsapp.controller.request.MBBORSInsertNewMerchantReq;
import com.maybank.orsapp.controller.response.MBBORSEditMerchantRes;
import com.maybank.orsapp.controller.response.MBBORSGetAllMerchantRes;
import com.maybank.orsapp.controller.response.MBBORSGetMerchantDetailByMidRes;
import com.maybank.orsapp.controller.response.MBBORSGetMerchantInfoByMidRes;
import com.maybank.orsapp.controller.response.MBBORSInsertNewMerchantRes;
import com.maybank.orsapp.controller.response.MBBORSDeleteMerchantRes;
import com.maybank.orsapp.service.MerchantService;

@RestController
@RequestMapping("/")
public class MerchantController {

	@Autowired
	MerchantService merchantService;
	
	@GetMapping("/Test")
	public ResponseEntity<MBBORSGetAllMerchantRes> Test(){
		
		return ResponseEntity.ok(null);		
	}
	
	@GetMapping("/GetAllMerchantList")
	public ResponseEntity<MBBORSGetAllMerchantRes> GetAllMerchantList(){
		
		return ResponseEntity.ok(merchantService.getAllMerchant());		
	}
	
	@GetMapping("/GetMerchantDetailByMerchantID/{merchantId}")
	public ResponseEntity<MBBORSGetMerchantDetailByMidRes> GetMerchantDetailByMerchantID(@PathVariable("merchantId") BigDecimal merchantId){
		
		return ResponseEntity.ok(merchantService.getMerchantDetailByMerchantId(merchantId));		
	}
	
	@GetMapping("/GetMMPMerchantDetailByMerchantID/{mid}")
	public ResponseEntity<MBBORSGetMerchantInfoByMidRes> GetMMPMerchantDetailByMerchantID(@PathVariable("mid") String mid){
		
		return ResponseEntity.ok(merchantService.getMMPMerchantDetails(mid));		
	}
	
   @PostMapping(value="/CreateMerchant",headers="Accept=application/json")
   public ResponseEntity<MBBORSInsertNewMerchantRes> CreateMerchant(@RequestBody MBBORSInsertNewMerchantReq merchant){
        System.out.println("Creating Merchant "+ merchant.getMid());  
        
        return ResponseEntity.ok(merchantService.insertNewMerchant(merchant));
   }
  
   @PutMapping(value="/EditMerchant",headers="Accept=application/json")
   public ResponseEntity<MBBORSEditMerchantRes> EditMerchant(@RequestBody MBBORSEditMerchantReq merchant){
//        System.out.println("Creating Merchant "+ merchant.getMid());  
        
        return ResponseEntity.ok(merchantService.editMerchant(merchant));
   }

   @DeleteMapping(value="/DeleteMerchant/{merchantId}",headers="Accept=application/json")
   public ResponseEntity<MBBORSDeleteMerchantRes> DeleteMerchant(@PathVariable("merchantId") BigDecimal merchant){
	        
	    return ResponseEntity.ok(merchantService.deleteMerchant(merchant, "SYSTEM"));
   }
   
}