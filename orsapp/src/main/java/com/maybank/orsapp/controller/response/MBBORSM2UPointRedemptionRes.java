package com.maybank.orsapp.controller.response;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.maybank.orsapp.constant.MBBORSConstant;

public class MBBORSM2UPointRedemptionRes extends MBBORSCommonRes{
	
//	@JsonProperty("Merchant_Code")
//	private String merchant_Code;
	@JsonProperty("Icno")
	private String icno;
	@JsonProperty("Order_Id")
	private String order_Id;
	@JsonProperty("Refno")
	private String refno;
	@JsonProperty("Prev_Pts_Bal")
	private BigDecimal prev_pts_bal;
	@JsonProperty("Deducted_Points")
	private BigDecimal deducted_Points;
	@JsonProperty("New_Pts_Bal")
	private BigDecimal new_pts_bal;
	@JsonProperty("Reward_Type")
	private String reward_type;
//	@JsonProperty("Card_Points_Deduct_List")
//	private List<M2UPointRedemptionDeductedCardRes> card_Points_Deduct_List;

	public String getIcno() {
		return icno;
	}

	public void setIcno(String icno) {
		this.icno = icno;
	}

	public String getOrder_Id() {
		return order_Id;
	}

	public void setOrder_Id(String order_Id) {
		this.order_Id = order_Id;
	}

	public String getRefno() {
		return refno;
	}

	public void setRefno(String refno) {
		this.refno = refno;
	}

	public BigDecimal getDeducted_Points() {
		return deducted_Points;
	}

	public void setDeducted_Points(BigDecimal deducted_Points) {
		this.deducted_Points = deducted_Points;
	}
		
//	public List<M2UPointRedemptionDeductedCardRes> getCard_Points_Deduct_List() {
//		return card_Points_Deduct_List;
//	}
//
//	public void setCard_Points_Deduct_List(List<M2UPointRedemptionDeductedCardRes> card_Points_Deduct_List) {
//		this.card_Points_Deduct_List = card_Points_Deduct_List;
//	}

	public BigDecimal getPrev_pts_bal() {
		return prev_pts_bal;
	}

	public void setPrev_pts_bal(BigDecimal prev_pts_bal) {
		this.prev_pts_bal = prev_pts_bal;
	}

	public BigDecimal getNew_pts_bal() {
		return new_pts_bal;
	}

	public void setNew_pts_bal(BigDecimal new_pts_bal) {
		this.new_pts_bal = new_pts_bal;
	}

	public String getReward_type() {
		return reward_type;
	}

	public void setReward_type(String reward_type) {
		this.reward_type = reward_type;
	}

	public String toString() {
		
		String output = "";
		
		if(this.getResponseCode().equals(MBBORSConstant.RES_CODE_SUCCESS)) {
			output = "[MBBORSM2UPointRedemptionRes : {"
					+"responseCode=".concat(this.getResponseCode())
					+",responseMessage=".concat(this.getResponseMessage())
					+",Icno=".concat(icno)
					+",Order_Id=".concat(order_Id)
					+",Refno=".concat(refno)
					+",Deducted_Points=".concat(deducted_Points.toString())
					+",Refno=".concat(refno)
//					+",Card_Points_Deduct_List=[".concat(Integer.toString(card_Points_Deduct_List.size()))+"]"
					+"}";
			
		}else {
			output = "[MBBORSM2UPointRedemptionRes : {"
					+"responseCode=".concat(this.getResponseCode())
					+",responseMessage=".concat(this.getResponseMessage())
					+"}";
		}
		
		return output;
	}
	
}
