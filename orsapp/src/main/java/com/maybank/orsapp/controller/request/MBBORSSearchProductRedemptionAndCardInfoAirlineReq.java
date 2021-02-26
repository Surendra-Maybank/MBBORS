package com.maybank.orsapp.controller.request;

public class MBBORSSearchProductRedemptionAndCardInfoAirlineReq {

	private String ic_number;
	private String card_number;
	private String reward_type_id;
		
	public String getIc_number() {
		return ic_number;
	}

	public void setIc_number(String ic_number) {
		this.ic_number = ic_number;
	}

	public String getCard_number() {
		return card_number;
	}

	public void setCard_number(String card_number) {
		this.card_number = card_number;
	}

	public String getReward_type_id() {
		return reward_type_id;
	}

	public void setReward_type_id(String reward_type_id) {
		this.reward_type_id = reward_type_id;
	}

	@Override
	public String toString() {
		return "MBBORSSearchProductRedemptionAndCardInfoReq [ic_number=".concat((ic_number==null?"":ic_number))
				.concat(",card_number=").concat((card_number==null?"":card_number))
				.concat(",reward_type_id=").concat((reward_type_id==null?"":reward_type_id))
				.concat("]");
	}
}
