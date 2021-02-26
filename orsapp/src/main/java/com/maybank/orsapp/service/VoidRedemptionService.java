package com.maybank.orsapp.service;

import com.maybank.orsapp.controller.request.VoidRedeemRequest;
import com.maybank.orsapp.dto.ResponseMessageDto;

public interface VoidRedemptionService {
	
	public ResponseMessageDto voidRedemption(VoidRedeemRequest request);

}
