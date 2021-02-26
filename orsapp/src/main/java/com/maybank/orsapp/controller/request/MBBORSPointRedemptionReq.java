package com.maybank.orsapp.controller.request;

import java.util.List;

public class MBBORSPointRedemptionReq {

	private List<PointRedemptionProductReq> product;
		
	private PointRedemptionCardHolderReq cardholder;

	public PointRedemptionCardHolderReq getCardholder() {
		return cardholder;
	}

	public void setCardholder(PointRedemptionCardHolderReq cardholder) {
		this.cardholder = cardholder;
	}

	public List<PointRedemptionProductReq> getProduct() {
		return product;
	}

	public void setProduct(List<PointRedemptionProductReq> product) {
		this.product = product;
	}

}
