package com.maybank.orsapp.controller.requestval;

import com.maybank.orsapp.controller.request.MBBORSInsertNewMerchantReq;

public class MBBORSInsertNewMerchantReqVal {
	
	public static String validate(MBBORSInsertNewMerchantReq req) {
		
		StringBuilder sb = new StringBuilder();
		

		if(CommonValidator.isEmptyStr(req.getMid())==true) {
			sb.append("Merchant Code cannot be empty.");
		}
	
//		if(CommonValidator.isEmptyStr(req.getMerchant_name())==true) {
//			sb.append("Merchant Name cannot be empty.");
//		}

//		if(CommonValidator.isEmptyStr(req.getStore_no())==true) {
//			sb.append("Store No cannot be empty.");
//		}
	
//		if(CommonValidator.isEmptyStr(req.getStore_name())==true) {
//			sb.append("Store Name cannot be empty.");
//		}
		//Tier Rate
		if(CommonValidator.isEmptyStr(req.getTier_rate_id())==true) {
			sb.append("Tier Rate Id cannot be empty.");
		}else {
			if(CommonValidator.isPositiveNumeric(req.getTier_rate_id())==false) {
				sb.append("Tier Rate Id must be positive number.");
			}
		}
		//Conversion Rate 
		if(CommonValidator.isEmptyStr(req.getConversion_rate())==true) {
			sb.append("Conversion rate cannot be empty.");
		}else {
			if(CommonValidator.isPositiveNumeric(req.getConversion_rate())==false) {
				sb.append("Conversion Rate must be positive number.");
			}
		}
		//Auto Payment
		if(CommonValidator.isEmptyStr(req.getIs_auto_payment())==true) {
			sb.append("Auto Payment cannot be empty.");
		}else {
			if(CommonValidator.isYN(req.getIs_auto_payment())==false) {
				sb.append("Auto Payment only accept Y or N.");
			}
		}

		//Max Redeem Point
		if(CommonValidator.isEmptyStr(req.getGlobal_max_redeem_point())==true) {
			sb.append("Global Max Redeem Point cannot be empty.");
		}else {
			if(CommonValidator.isPositiveNumeric(req.getGlobal_max_redeem_point())==false) {
				sb.append("Max Redeem Point must be positive number.");
			}
		}

		//Instant reward percentage
		if(CommonValidator.isEmptyStr(req.getGlobal_instant_reward_percentage())==true) {
			sb.append("Global Instant Reward Percentage cannot be empty.");
		}else {
			if(CommonValidator.isPositiveNumeric(req.getGlobal_instant_reward_percentage())==false) {
				sb.append("Instant Reward Percentage must be positive number.");
			}
		}

//		if(CommonValidator.isEmptyStr(req.getGlobal_receipt_hdr_1())==true) {
//			sb.append("Header 1 cannot be empty.");
//		}
//
//		if(CommonValidator.isEmptyStr(req.getGlobal_receipt_hdr_2())==true) {
//			sb.append("Header 2 cannot be empty.");
//		}
//
//		if(CommonValidator.isEmptyStr(req.getGlobal_receipt_hdr_3())==true) {
//			sb.append("Header 3 cannot be empty.");
//		}
//
//		if(CommonValidator.isEmptyStr(req.getGlobal_receipt_ftr_1())==true) {
//			sb.append("Footer 1 cannot be empty.");
//		}
//
//		if(CommonValidator.isEmptyStr(req.getGlobal_receipt_ftr_2())==true) {
//			sb.append("Footer 2 cannot be empty.");
//		}
//
//		if(CommonValidator.isEmptyStr(req.getGlobal_receipt_ftr_3())==true) {
//			sb.append("Footer 3 cannot be empty.");
//		}
//	    global_is_point_inquiry;
		if(CommonValidator.isEmptyStr(req.getGlobal_is_point_inquiry())==true) {
			sb.append("Point enquiry cannot be empty.");
		}else {
			if(CommonValidator.isYN(req.getGlobal_is_point_inquiry())==false) {
				sb.append("Point enquiry only accept Y or N.");
			}
		}
		
//	    global_is_instant_reward;
		if(CommonValidator.isEmptyStr(req.getGlobal_is_instant_reward())==true) {
			sb.append("Instant Reward cannot be empty.");
		}else {
			if(CommonValidator.isYN(req.getGlobal_is_instant_reward())==false) {
				sb.append("Instant Reward only accept Y or N.");
			}
		}
//	    global_is_point_redemption;
		if(CommonValidator.isEmptyStr(req.getGlobal_is_point_redemption())==true) {
			sb.append("Point Redemption cannot be empty.");
		}else {
			if(CommonValidator.isYN(req.getGlobal_is_point_redemption())==false) {
				sb.append("Point Redemption only accept Y or N.");
			}
		}
//	    global_is_value_redemption;
		if(CommonValidator.isEmptyStr(req.getGlobal_is_value_redemption())==true) {
			sb.append("Value Redemption cannot be empty.");
		}else {
			if(CommonValidator.isYN(req.getGlobal_is_value_redemption())==false) {
				sb.append("Value Redemption only accept Y or N.");
			}
		}
//	    global_is_gift_code_redemption;
		if(CommonValidator.isEmptyStr(req.getGlobal_is_gift_code_redemption())==true) {
			sb.append("Gift Redemption cannot be empty.");
		}else {
			if(CommonValidator.isYN(req.getGlobal_is_gift_code_redemption())==false) {
				sb.append("Gift Redemption only accept Y or N.");
			}
		}
//	    global_is_hot_deal_redemption;
		if(CommonValidator.isEmptyStr(req.getGlobal_is_hot_deal_redemption())==true) {
			sb.append("Hot Deal Redemption cannot be empty.");
		}else {
			if(CommonValidator.isYN(req.getGlobal_is_hot_deal_redemption())==false) {
				sb.append("Hot Deal Redemption only accept Y or N.");
			}
		}
//	    global_is_void_redemption;
		if(CommonValidator.isEmptyStr(req.getGlobal_is_void_redemption())==true) {
			sb.append("Void Redemption cannot be empty.");
		}else {
			if(CommonValidator.isYN(req.getGlobal_is_void_redemption())==false) {
				sb.append("Void Redemption only accept Y or N.");
			}
		}
//	    global_is_encryption;
		if(CommonValidator.isEmptyStr(req.getGlobal_is_encryption())==true) {
			sb.append("Encrytion cannot be empty.");
		}else {
			if(CommonValidator.isYN(req.getGlobal_is_encryption())==false) {
				sb.append("Encrytion only accept Y or N.");
			}
		}
//		tids
		if(req.getTid()==null||req.getTid().size()==0) {
			sb.append("At least 1 terminal should be added.");
		}
		
		return sb.toString();
	}
}
