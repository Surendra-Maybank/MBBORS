package com.maybank.orsapp.service;

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

public interface ProductRedemptionService {

	public MBBORSSearchProductRedemptionAndCardInfoRes searchProductRedemptionAndCardInfo(MBBORSSearchProductRedemptionAndCardInfoReq icNumOrCardNum);
	
	public MBBORSSearchProductRedemptionAndCardInfoAirlineRes searchProductRedemptionAndCardInfoAirline(MBBORSSearchProductRedemptionAndCardInfoAirlineReq icNumOrCardNum);
	
	public MBBORSPointRedemptionRes pointRedemption(MBBORSPointRedemptionReq request);
	
	public MBBORSPointRedemptionAirlineRes pointRedemptionAirline(MBBORSPointRedemptionAirlineReq request);
	
	public MBBORSM2UPointRedemptionRes m2uPointRedemption(MBBORSM2UPointRedemptionReq request);
	
	public MBBORSTerminalPointRedemptionRes terminalPointRedemption(MBBORSTerminalPointRedemptionReq request);
	
	public ValidateAirlineRedeemProductResponse validateAirlineRedeemProduct(ValidateAirlineRedeemProductRequest validateAirlineRedeemProductRequest);
	
}
