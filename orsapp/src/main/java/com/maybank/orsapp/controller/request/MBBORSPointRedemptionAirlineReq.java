package com.maybank.orsapp.controller.request;

public class MBBORSPointRedemptionAirlineReq {

	private PointRedemptionProductReq product;
		
	private PointRedemptionCardHolderReq cardholder;

	public PointRedemptionCardHolderReq getCardholder() {
		return cardholder;
	}

	public void setCardholder(PointRedemptionCardHolderReq cardholder) {
		this.cardholder = cardholder;
	}

	public PointRedemptionProductReq getProduct() {
		return product;
	}

	public void setProduct(PointRedemptionProductReq product) {
		this.product = product;
	}
	
}
