package com.maybank.orsapp.controller.requestval;

import com.maybank.orsapp.controller.request.EditMerchantInfoMerchantReq;
import com.maybank.orsapp.controller.request.EditMerchantInfoTerminalReq;
import com.maybank.orsapp.controller.request.MBBORSEditMerchantReq;

public class MBBORSEditMerchantReqVal {
	
	public static String validate(MBBORSEditMerchantReq req) {
		
		StringBuilder sb = new StringBuilder();
		
		EditMerchantInfoMerchantReq merchant=req.getMerchant();
		if(merchant==null) {
			sb.append("Merchant cannot be empty.");
		}else {
			if(CommonValidator.isEmptyStr(merchant.getMerchant_id())==true) {
				sb.append("Merchant Id cannot be empty.");
			}else {
				if(CommonValidator.isPositiveNumeric(merchant.getMerchant_id())==false) {
					sb.append("Merchant Id must be positive number.");
				}
			}
		
//			if(CommonValidator.isEmptyStr(merchant.getMerchant_name())==true) {
//				sb.append("Merchant Name cannot be empty.");
//			}

//			if(CommonValidator.isEmptyStr(merchant.getStore_no())==true) {
//				sb.append("Store No cannot be empty.");
//			}
		
//			if(CommonValidator.isEmptyStr(merchant.getStore_name())==true) {
//				sb.append("Store Name cannot be empty.");
//			}
			//Tier Rate
			if(CommonValidator.isEmptyStr(merchant.getTier_rate_id())==true) {
				sb.append("Merchant Tier Rate Id cannot be empty.");
			}else {
				if(CommonValidator.isPositiveNumeric(merchant.getTier_rate_id())==false) {
					sb.append("Merchant Tier Rate Id must be positive number.");
				}
			}
			//Conversion Rate 
			if(CommonValidator.isEmptyStr(merchant.getGlobal_conversion_rate())==true) {
				sb.append("Merchant Conversion rate cannot be empty.");
			}else {
				if(CommonValidator.isPositiveNumeric(merchant.getGlobal_conversion_rate())==false) {
					sb.append("Merchant Conversion Rate must be positive number.");
				}
			}
			//Auto Payment
			if(CommonValidator.isEmptyStr(merchant.getIs_auto_payment())==true) {
				sb.append("Merchant Auto Payment cannot be empty.");
			}else {
				if(CommonValidator.isYN(merchant.getIs_auto_payment())==false) {
					sb.append("Merchant Auto Payment only accept Y or N.");
				}
			}

			//Max Redeem Point
			if(CommonValidator.isEmptyStr(merchant.getGlobal_max_redeem_point())==true) {
				sb.append("Merchant Global Max Redeem Point cannot be empty.");
			}else {
				if(CommonValidator.isPositiveNumeric(merchant.getGlobal_max_redeem_point())==false) {
					sb.append("Merchant Max Redeem Point must be positive number.");
				}
			}

			//Instant reward percentage
			if(CommonValidator.isEmptyStr(merchant.getGlobal_instant_reward_percentage())==true) {
				sb.append("Merchant Global Instant Reward Percentage cannot be empty.");
			}else {
				if(CommonValidator.isPositiveNumeric(merchant.getGlobal_instant_reward_percentage())==false) {
					sb.append("Merchant Instant Reward Percentage must be positive number.");
				}
			}

//			if(CommonValidator.isEmptyStr(req.getGlobal_receipt_hdr_1())==true) {
//				sb.append("Header 1 cannot be empty.");
//			}
	//
//			if(CommonValidator.isEmptyStr(req.getGlobal_receipt_hdr_2())==true) {
//				sb.append("Header 2 cannot be empty.");
//			}
	//
//			if(CommonValidator.isEmptyStr(req.getGlobal_receipt_hdr_3())==true) {
//				sb.append("Header 3 cannot be empty.");
//			}
	//
//			if(CommonValidator.isEmptyStr(req.getGlobal_receipt_ftr_1())==true) {
//				sb.append("Footer 1 cannot be empty.");
//			}
	//
//			if(CommonValidator.isEmptyStr(req.getGlobal_receipt_ftr_2())==true) {
//				sb.append("Footer 2 cannot be empty.");
//			}
	//
//			if(CommonValidator.isEmptyStr(req.getGlobal_receipt_ftr_3())==true) {
//				sb.append("Footer 3 cannot be empty.");
//			}
//		    global_is_point_inquiry;
			if(CommonValidator.isEmptyStr(merchant.getGlobal_is_point_inquiry())==true) {
				sb.append("Merchant Point enquiry cannot be empty.");
			}else {
				if(CommonValidator.isYN(merchant.getGlobal_is_point_inquiry())==false) {
					sb.append("Merchant Point enquiry only accept Y or N.");
				}
			}
			
//		    global_is_instant_reward;
			if(CommonValidator.isEmptyStr(merchant.getGlobal_is_instant_reward())==true) {
				sb.append("Merchant Instant Reward cannot be empty.");
			}else {
				if(CommonValidator.isYN(merchant.getGlobal_is_instant_reward())==false) {
					sb.append("Merchant Instant Reward only accept Y or N.");
				}
			}
//		    global_is_point_redemption;
			if(CommonValidator.isEmptyStr(merchant.getGlobal_is_point_redemption())==true) {
				sb.append("Merchant Point Redemption cannot be empty.");
			}else {
				if(CommonValidator.isYN(merchant.getGlobal_is_point_redemption())==false) {
					sb.append("Merchant Point Redemption only accept Y or N.");
				}
			}
//		    global_is_value_redemption;
			if(CommonValidator.isEmptyStr(merchant.getGlobal_is_value_redemption())==true) {
				sb.append("Merchant Value Redemption cannot be empty.");
			}else {
				if(CommonValidator.isYN(merchant.getGlobal_is_value_redemption())==false) {
					sb.append("Merchant Value Redemption only accept Y or N.");
				}
			}
//		    global_is_gift_code_redemption;
			if(CommonValidator.isEmptyStr(merchant.getGlobal_is_gift_code_redemption())==true) {
				sb.append("Merchant Gift Redemption cannot be empty.");
			}else {
				if(CommonValidator.isYN(merchant.getGlobal_is_gift_code_redemption())==false) {
					sb.append("Merchant Gift Redemption only accept Y or N.");
				}
			}
//		    global_is_hot_deal_redemption;
			if(CommonValidator.isEmptyStr(merchant.getGlobal_is_hot_deal_redemption())==true) {
				sb.append("Merchant Hot Deal Redemption cannot be empty.");
			}else {
				if(CommonValidator.isYN(merchant.getGlobal_is_hot_deal_redemption())==false) {
					sb.append("Merchant Hot Deal Redemption only accept Y or N.");
				}
			}
//		    global_is_void_redemption;
			if(CommonValidator.isEmptyStr(merchant.getGlobal_is_void_redemption())==true) {
				sb.append("Merchant Void Redemption cannot be empty.");
			}else {
				if(CommonValidator.isYN(merchant.getGlobal_is_void_redemption())==false) {
					sb.append("Merchant Void Redemption only accept Y or N.");
				}
			}
//		    global_is_encryption;
			if(CommonValidator.isEmptyStr(merchant.getGlobal_is_encryption())==true) {
				sb.append("Merchant Encrytion cannot be empty.");
			}else {
				if(CommonValidator.isYN(merchant.getGlobal_is_encryption())==false) {
					sb.append("Merchant Encrytion only accept Y or N.");
				}
			}
		}
		
		EditMerchantInfoTerminalReq terminal=req.getTerminal();
		
		if(merchant==null) {
			sb.append("Terminal cannot be empty.");
		}else {
			if(CommonValidator.isEmptyStr(terminal.getTerminal_id())==true) {
				sb.append("Terminal ID cannot be empty.");
			}
			
			if(CommonValidator.isEmptyStr(terminal.getIs_inherit())==true) {
				sb.append("Terminal Inherit cannot be empty.");
			}else {
				if(CommonValidator.isYN(terminal.getIs_inherit())==false) {
					sb.append("Terminal Inherit only accept Y or N.");
				}
			}
		
//			if(CommonValidator.isEmptyStr(terminal.getMerchant_name())==true) {
//				sb.append("Merchant Name cannot be empty.");
//			}

//			if(CommonValidator.isEmptyStr(terminal.getStore_no())==true) {
//				sb.append("Store No cannot be empty.");
//			}
		
//			if(CommonValidator.isEmptyStr(terminal.getStore_name())==true) {
//				sb.append("Store Name cannot be empty.");
//			}
			//Tier Rate
			if(CommonValidator.isEmptyStr(terminal.getTier_rate_id())==true) {
				sb.append("Terminal Tier Rate Id cannot be empty.");
			}else {
				if(CommonValidator.isPositiveNumeric(terminal.getTier_rate_id())==false) {
					sb.append("Terminal Tier Rate Id must be positive number.");
				}
			}
			//Conversion Rate 
			if(CommonValidator.isEmptyStr(terminal.getConversion_rate())==true) {
				sb.append("Conversion rate cannot be empty.");
			}else {
				if(CommonValidator.isPositiveNumeric(terminal.getConversion_rate())==false) {
					sb.append("Terminal Conversion Rate must be positive number.");
				}
			}

			//Max Redeem Point
			if(CommonValidator.isEmptyStr(terminal.getMax_redeem_point())==true) {
				sb.append("Terminal Max Redeem Point cannot be empty.");
			}else {
				if(CommonValidator.isPositiveNumeric(terminal.getMax_redeem_point())==false) {
					sb.append("Terminal Max Redeem Point must be positive number.");
				}
			}

			//Instant reward percentage
			if(CommonValidator.isEmptyStr(terminal.getInstant_reward_percentage())==true) {
				sb.append("Terminal Instant Reward Percentage cannot be empty.");
			}else {
				if(CommonValidator.isPositiveNumeric(terminal.getInstant_reward_percentage())==false) {
					sb.append("Terminal Instant Reward Percentage must be positive number.");
				}
			}

//			if(CommonValidator.isEmptyStr(terminal.getGlobal_receipt_hdr_1())==true) {
//				sb.append("Header 1 cannot be empty.");
//			}
	//
//			if(CommonValidator.isEmptyStr(terminal.getGlobal_receipt_hdr_2())==true) {
//				sb.append("Header 2 cannot be empty.");
//			}
	//
//			if(CommonValidator.isEmptyStr(terminal.getGlobal_receipt_hdr_3())==true) {
//				sb.append("Header 3 cannot be empty.");
//			}
	//
//			if(CommonValidator.isEmptyStr(terminal.getGlobal_receipt_ftr_1())==true) {
//				sb.append("Footer 1 cannot be empty.");
//			}
	//
//			if(CommonValidator.isEmptyStr(terminal.getGlobal_receipt_ftr_2())==true) {
//				sb.append("Footer 2 cannot be empty.");
//			}
	//
//			if(CommonValidator.isEmptyStr(terminal.getGlobal_receipt_ftr_3())==true) {
//				sb.append("Footer 3 cannot be empty.");
//			}
//		    global_is_point_inquiry;
			if(CommonValidator.isEmptyStr(terminal.getIs_point_inquiry())==true) {
				sb.append("Terminal Point enquiry cannot be empty.");
			}else {
				if(CommonValidator.isYN(terminal.getIs_point_inquiry())==false) {
					sb.append("Terminal Point enquiry only accept Y or N.");
				}
			}
			
//		    global_is_instant_reward;
			if(CommonValidator.isEmptyStr(terminal.getIs_instant_reward())==true) {
				sb.append("Terminal Instant Reward cannot be empty.");
			}else {
				if(CommonValidator.isYN(terminal.getIs_instant_reward())==false) {
					sb.append("Terminal Instant Reward only accept Y or N.");
				}
			}
//		    global_is_point_redemption;
			if(CommonValidator.isEmptyStr(terminal.getIs_point_redemption())==true) {
				sb.append("Terminal Point Redemption cannot be empty.");
			}else {
				if(CommonValidator.isYN(terminal.getIs_point_redemption())==false) {
					sb.append("Terminal Point Redemption only accept Y or N.");
				}
			}
//		    global_is_value_redemption;
			if(CommonValidator.isEmptyStr(terminal.getIs_value_redemption())==true) {
				sb.append("Terminal Value Redemption cannot be empty.");
			}else {
				if(CommonValidator.isYN(terminal.getIs_value_redemption())==false) {
					sb.append("Terminal Value Redemption only accept Y or N.");
				}
			}
//		    global_is_gift_code_redemption;
			if(CommonValidator.isEmptyStr(terminal.getIs_gift_code_redemption())==true) {
				sb.append("Terminal Gift Redemption cannot be empty.");
			}else {
				if(CommonValidator.isYN(terminal.getIs_gift_code_redemption())==false) {
					sb.append("Terminal Gift Redemption only accept Y or N.");
				}
			}
//		    global_is_hot_deal_redemption;
			if(CommonValidator.isEmptyStr(terminal.getIs_hot_deal_redemption())==true) {
				sb.append("Terminal Hot Deal Redemption cannot be empty.");
			}else {
				if(CommonValidator.isYN(terminal.getIs_hot_deal_redemption())==false) {
					sb.append("Terminal Hot Deal Redemption only accept Y or N.");
				}
			}
//		    global_is_void_redemption;
			if(CommonValidator.isEmptyStr(terminal.getIs_void_redemption())==true) {
				sb.append("Terminal Void Redemption cannot be empty.");
			}else {
				if(CommonValidator.isYN(terminal.getIs_void_redemption())==false) {
					sb.append("Terminal Void Redemption only accept Y or N.");
				}
			}
//		    global_is_encryption;
			if(CommonValidator.isEmptyStr(terminal.getIs_encryption())==true) {
				sb.append("Terminal Encrytion cannot be empty.");
			}else {
				if(CommonValidator.isYN(terminal.getIs_encryption())==false) {
					sb.append("Terminal Encrytion only accept Y or N.");
				}
			}
		}
		return sb.toString();
	}
			
}
