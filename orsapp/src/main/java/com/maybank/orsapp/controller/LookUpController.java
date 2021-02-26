/**
 * 
 */
package com.maybank.orsapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maybank.orsapp.dto.ProductCreationDto;
import com.maybank.orsapp.service.ProductService;

/**
 * @author 80003905
 *
 */

@RestController
@RequestMapping("/")
public class LookUpController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/GetInfoForProductCreation")
	public ResponseEntity<ProductCreationDto> getInfoForProductCreation(){
		return ResponseEntity.ok(productService.getInfoToCreateProduct());		
	}
	
	@GetMapping("/GetRewardTypeList")
	public ResponseEntity<ProductCreationDto> getRewardTypesForPointRedemption(){
		return ResponseEntity.ok(productService.getAllRewardTypes());
	}
	
	@GetMapping("/GetAllAirlines")
	public ResponseEntity<ProductCreationDto> getAirlines(){
		return ResponseEntity.ok(productService.getAirlines());		
	}
	
	@GetMapping("/GetAllPrograms")
	public ResponseEntity<ProductCreationDto> getPrograms(){
		return ResponseEntity.ok(productService.getPrograms());		
	}
	
	@GetMapping("/GetAllCategoryTypes")
	public ResponseEntity<ProductCreationDto> getCategoryTypes(){
		return ResponseEntity.ok(productService.getCategoryTypes());		
	}

	@GetMapping("/GetAllMerchants")
	public ResponseEntity<ProductCreationDto> getAllMerchants(){
		return ResponseEntity.ok(productService.getAllMerchants());		
	}

	@GetMapping("/GetAllPlasticTypes")
	public ResponseEntity<ProductCreationDto> getAllPlasticTypes(){
		return ResponseEntity.ok(productService.getAllPlasticTypes());		
	}

}
