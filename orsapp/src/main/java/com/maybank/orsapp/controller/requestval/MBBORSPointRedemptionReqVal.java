package com.maybank.orsapp.controller.requestval;

import com.maybank.orsapp.controller.request.MBBORSPointRedemptionReq;
import com.maybank.orsapp.controller.request.PointRedemptionCardHolderReq;
import com.maybank.orsapp.controller.request.PointRedemptionProductReq;

public class MBBORSPointRedemptionReqVal {

	public static String validate(MBBORSPointRedemptionReq req) {
		StringBuilder sb = new StringBuilder();
		
		if(req.getCardholder()==null) {
			sb.append("Cardholder cannot be empty.");
		}else {
			PointRedemptionCardHolderReq cardHolder = req.getCardholder();
			if(CommonValidator.isEmptyStr(cardHolder.getIc_number())==true
					&&CommonValidator.isEmptyStr(cardHolder.getCard_number())==true) {
				sb.append("Either IC Num and Card Num cannot be empty.");
			}
			
			if(CommonValidator.isEmptyStr(cardHolder.getEmail())==true) {
				sb.append("Email cannot be empty.");
			}
			
			if(CommonValidator.isEmptyStr(cardHolder.getReward_type_id())==true) {
				sb.append("Reward Type ID cannot be empty.");
			}else {
				if(CommonValidator.isPositiveNumeric(cardHolder.getReward_type_id())==false) {
					sb.append("Reward Type ID must be positive number.");
				}
			}
		}
		
		if(req.getProduct()==null||req.getProduct().size()==0) {
			sb.append("Product cannot be empty.");
		}else {
			for(PointRedemptionProductReq product:req.getProduct()){
				if(CommonValidator.isEmptyStr(product.getProduct_id())==true
						||CommonValidator.isEmptyStr(product.getQuantity())==true) {
					sb.append("Product Id and Quantity cannot be empty.");
				}else {
					if(CommonValidator.isPositiveNumeric(product.getProduct_id())==false
							||CommonValidator.isPositiveNumeric(product.getQuantity())==false) {
						sb.append("Product ID and Quantity must be positive number.");
					}
				}
			}
		}
//		private List<PointRedemptionProductReq> product;
//		
//		private PointRedemptionCardHolderReq cardholder;
		return sb.toString();
	}
}
