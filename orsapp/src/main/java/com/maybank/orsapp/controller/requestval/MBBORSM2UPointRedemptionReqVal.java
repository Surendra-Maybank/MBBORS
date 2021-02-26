package com.maybank.orsapp.controller.requestval;

import com.maybank.orsapp.controller.request.MBBORSM2UPointRedemptionReq;

public class MBBORSM2UPointRedemptionReqVal {

	public static String validate(MBBORSM2UPointRedemptionReq req) {
		StringBuilder sb = new StringBuilder();
		
		if(CommonValidator.isEmptyStr(req.getIcno())==true) {
			sb.append("Icno cannot be empty.");
		}else {
			if(CommonValidator.isPositiveNumeric(req.getIcno())==false) {
				sb.append("Icno must be positive number.");
			}
		}

		if(CommonValidator.isEmptyStr(req.getOrder_Id())==true) {
			sb.append("Order Id cannot be empty.");
		}

		if(CommonValidator.isEmptyStr(req.getRedeem_Points())==true) {
			sb.append("Redeem Point cannot be empty.");
		}else {
			if(CommonValidator.isPositiveNumeric(req.getRedeem_Points())==false) {
				sb.append("Redeem Point must be positive number.");
			}
		}

		if(CommonValidator.isEmptyStr(req.getRedeem_Type())==true) {
			sb.append("Redeem Type cannot be empty.");
		}
		
		if(CommonValidator.isEmptyStr(req.getMerchant_Code())==true) {
			sb.append("Merchant Code cannot be empty.");
		}
		
		return sb.toString();
	}
}
