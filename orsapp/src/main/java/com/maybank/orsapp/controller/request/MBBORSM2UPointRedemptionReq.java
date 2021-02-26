package com.maybank.orsapp.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MBBORSM2UPointRedemptionReq {

	@JsonProperty("Icno")
	private String Icno;
	@JsonProperty("Order_Id")
	private String Order_Id;
	@JsonProperty("Redeem_Points")
	private String Redeem_Points;
	@JsonProperty("Redeem_Type")
	private String Redeem_Type;
	@JsonProperty("Merchant_Code")
	private String Merchant_Code;
	
	public String getIcno() {
		return Icno;
	}
	public void setIcno(String icno) {
		Icno = icno;
	}
	public String getOrder_Id() {
		return Order_Id;
	}
	public void setOrder_Id(String order_Id) {
		Order_Id = order_Id;
	}
	public String getRedeem_Points() {
		return Redeem_Points;
	}
	public void setRedeem_Points(String redeem_Points) {
		Redeem_Points = redeem_Points;
	}
	public String getRedeem_Type() {
		return Redeem_Type;
	}
	public void setRedeem_Type(String redeem_Type) {
		Redeem_Type = redeem_Type;
	}
	public String getMerchant_Code() {
		return Merchant_Code;
	}
	public void setMerchant_Code(String merchant_Code) {
		Merchant_Code = merchant_Code;
	}

	public String toString() {
		return "MBBORSM2UPointRedemptionReq["
				+ "Icno=".concat(Icno)
				+ "Order_Id=".concat(Order_Id)
				+ "Redeem_Points=".concat(Redeem_Points)
				+ "Redeem_Type=".concat(Redeem_Type)
				+ "Merchant_Code=".concat(Merchant_Code)
				+ "]";
	}
}
