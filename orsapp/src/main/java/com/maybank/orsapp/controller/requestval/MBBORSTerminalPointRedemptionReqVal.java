package com.maybank.orsapp.controller.requestval;

import com.maybank.orsapp.controller.request.MBBORSTerminalPointRedemptionReq;

public class MBBORSTerminalPointRedemptionReqVal {
	public static String validate(MBBORSTerminalPointRedemptionReq req) {
		
		StringBuilder sb = new StringBuilder();
		
		if(CommonValidator.isEmptyStr(req.getCustomerCardNo())==true) {
			sb.append("Card Number cannot be empty.");
		}else {
			if(CommonValidator.isPositiveNumeric(req.getCustomerCardNo())==false) {
				sb.append("Card Number must be positive number.");
			}
		}
		
		if(CommonValidator.isEmptyStr(req.getTid())==true) {
			sb.append("Tid cannot be empty.");
		}
		
		if(CommonValidator.isEmptyStr(req.getRmValue())==true) {
			sb.append("RmValue cannot be empty.");
		}else {
			if(CommonValidator.isPositiveNumeric(req.getRmValue())==false) {
				sb.append("RmValue must be positive number.");
			}
		}
		
		return sb.toString();
	}
}
