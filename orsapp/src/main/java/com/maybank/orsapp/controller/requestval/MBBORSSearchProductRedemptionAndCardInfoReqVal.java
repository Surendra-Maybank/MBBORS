package com.maybank.orsapp.controller.requestval;

import com.maybank.orsapp.controller.request.MBBORSSearchProductRedemptionAndCardInfoReq;

public class MBBORSSearchProductRedemptionAndCardInfoReqVal {

	public static String validate(MBBORSSearchProductRedemptionAndCardInfoReq req) {
			
		StringBuilder sb = new StringBuilder();
		
		if(CommonValidator.isEmptyStr(req.getReward_type_id())==true) {
			sb.append("Reward Type ID cannot be empty.");
		}else {
			if(CommonValidator.isPositiveNumeric(req.getReward_type_id())==false) {
				sb.append("Reward Type ID must be positive number.");
			}
		}
		
		if(CommonValidator.isEmptyStr(req.getIc_number())==true
				&&CommonValidator.isEmptyStr(req.getCard_number())==true) {
			sb.append("Either IC Num and Card Num cannot be empty.");
		}
		
		return sb.toString();
	}
}
