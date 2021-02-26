/**
 * 
 */
package com.maybank.orsapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maybank.orsapp.controller.request.RedemptionHistorySearchRequest;
import com.maybank.orsapp.controller.requestval.RedemptionHistoryRequestValidtor;
import com.maybank.orsapp.controller.response.RedemptionHistoryResponse;
import com.maybank.orsapp.exceptions.RequestDataValidationException;
import com.maybank.orsapp.service.RedemptionHistoryService;

/**
 * @author 80003905
 *
 */

@RestController
@RequestMapping("/")
public class RedemptionHistoryController {
	
	@Autowired
	RedemptionHistoryRequestValidtor redemptionHistoryRequestValidtor;
	
	@Autowired
	RedemptionHistoryService redemptionHistoryService;
	
	@PostMapping(value = "/GetRedemptionHistoryList", headers="Accept=application/json")
	public ResponseEntity<RedemptionHistoryResponse> getRedemptionHistory(@RequestBody RedemptionHistorySearchRequest searchRequest){
		
		Boolean requestValidation = redemptionHistoryRequestValidtor.isValidRequest(searchRequest);

		if(requestValidation) {
			return ResponseEntity.ok(redemptionHistoryService.redemptionHistoryResponse(searchRequest));
		}else {
			throw new RequestDataValidationException("Atleast one field is required");
		}
	}
	
	@GetMapping(value = "/GetRedemptionHistoryDetails/{pointTxnId}", headers="Accept=application/json")
	public ResponseEntity<RedemptionHistoryResponse> getRedemptionHistory(@PathVariable("pointTxnId") Long pointTxnId){
		return ResponseEntity.ok(redemptionHistoryService.redemptionHistoryViewResponse(pointTxnId));		
	}

}
