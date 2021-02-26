package com.maybank.orsapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.maybank.orsapp.controller.request.VoidRedeemRequest;
import com.maybank.orsapp.dto.ResponseMessageDto;
import com.maybank.orsapp.service.VoidRedemptionService;

/**
 * @author 80003905
 *
 */

@RestController
@RequestMapping("/")
public class VoidRedemptionController {
	
	@Autowired
	VoidRedemptionService voidRedemptionService;
	
    @PostMapping(value = "/VoidRedemption", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody 
    public ResponseEntity<ResponseMessageDto> voidPointRedemption(@RequestBody VoidRedeemRequest request) {
        return ResponseEntity.ok(voidRedemptionService.voidRedemption(request));
    }

}
