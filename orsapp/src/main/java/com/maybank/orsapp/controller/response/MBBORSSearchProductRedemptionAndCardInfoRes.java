package com.maybank.orsapp.controller.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.maybank.orsapp.dto.CardHolderDetailDTO;
import com.maybank.orsapp.dto.CardHolderTotalPointDTO;
import com.maybank.orsapp.dto.CreditAndDebitCardDTO;
import com.maybank.orsapp.dto.ProductRedemptionDTO;

public class MBBORSSearchProductRedemptionAndCardInfoRes extends MBBORSCommonRes{
	
	@JsonProperty("product")
	private List<ProductRedemptionDTO> productList;	
	
	@JsonProperty("credit_debit_card")
	private List<CreditAndDebitCardDTO> creditDebitList;
	
	@JsonProperty("customer")
	private CardHolderDetailDTO customerDetails;
	
	@JsonProperty("card_total_point")
	private List<CardHolderTotalPointDTO> cardHolderTotalPoint;
	
	public List<ProductRedemptionDTO> getProductList() {
		return productList;
	}

	public void setProductList(List<ProductRedemptionDTO> productList) {
		this.productList = productList;
	}

	public List<CardHolderTotalPointDTO> getCardHolderTotalPoint() {
		return cardHolderTotalPoint;
	}

	public void setCardHolderTotalPoint(List<CardHolderTotalPointDTO> cardHolderTotalPoint) {
		this.cardHolderTotalPoint = cardHolderTotalPoint;
	}

	public CardHolderDetailDTO getCustomerDetails() {
		return customerDetails;
	}

	public void setCustomerDetails(CardHolderDetailDTO customerDetails) {
		this.customerDetails = customerDetails;
	}

	public List<CreditAndDebitCardDTO> getCreditDebitList() {
		return creditDebitList;
	}

	public void setCreditDebitList(List<CreditAndDebitCardDTO> creditDebitList) {
		this.creditDebitList = creditDebitList;
	}
		
}
