package com.maybank.orsapp.dao;

import java.math.BigDecimal;
import java.util.List;

import com.maybank.orsapp.dto.CardHolderBucketDetailDTO;
import com.maybank.orsapp.dto.CardHolderDetailDTO;
import com.maybank.orsapp.dto.CardHolderTotalPointDTO;
import com.maybank.orsapp.dto.CreditAndDebitCardDTO;
import com.maybank.orsapp.dto.OrsProgramDTO;
import com.maybank.orsapp.dto.ProductPlaticTypeLinkDTO;
import com.maybank.orsapp.dto.ProductRedemptionDTO;
import com.maybank.orsapp.dto.ProductUnitPointDetailDTO;
import com.maybank.orsapp.dto.TerminalConversionDTO;
import com.maybank.orsapp.dto.ValidateAirlineRedeemProductRequest;
import com.maybank.orsapp.dto.ValidateAirlineRedeemProductResponse;

public interface ProductRedemptionDao {

	public List<ProductRedemptionDTO> getProductRedemption(BigDecimal rewardTypeId); 
	
	public List<ProductRedemptionDTO> getAirLineProductRedemption(BigDecimal rewardTypeId);
	
	public String getIcNumberByCardNum(String cardNum);
	
	public List<CardHolderTotalPointDTO> getCardHolderTotalPoint(String icNum, String custNum, BigDecimal rewardTypeId);
	
	public List<CardHolderBucketDetailDTO> getCardHolderBucketAirline(String icNum, BigDecimal rewardTypeId, List<Integer> platicTypeList);
	
	public List<CardHolderTotalPointDTO> getSupCardHolderTotalPoint(List<String> cust_num, BigDecimal rewardTypeId);
	
	public List<CardHolderBucketDetailDTO> getSupCardHolderBucketAirline(List<String> cust_num, BigDecimal rewardTypeId, List<Integer> platicTypeList);
	
	public CardHolderDetailDTO getCardHolderDetailsByIcNum(String icNum);
	
	public List<CreditAndDebitCardDTO> getCreditAndDebitCardByIcNum(String icNum);
	
	public List<CardHolderBucketDetailDTO> getCardHolderBucket(String icNum, BigDecimal rewardTypeId);
	
	public List<CardHolderBucketDetailDTO> getSupCardHolderBucket(List<String> cust_num, BigDecimal rewardTypeId);
		
	public BigDecimal getProductPointByProductId(BigDecimal productId);
	
	public BigDecimal newPointTxn(String orderNo, String refOrderNo, String custIcNo,String firstName, String lastName,
			BigDecimal totalPointRedeemed,BigDecimal totalAmountPurchased,BigDecimal rewardTypeId,
			String deliveryAddr1,String deliveryAddr2,String deliveryAddr3,String deliveryAddr4,
			String deliveryZipCode,String email,String homeNo,String officeNo,String mobileNo,
			String redemptionSource,String txnType,String redemptionStatus,String username,BigDecimal cardholderId);
	
	public int newPointTxnDetails(BigDecimal txnId,String orderNo,BigDecimal productId,BigDecimal qty,BigDecimal unitPoint,BigDecimal merchantId,
			String deliveryStatus,boolean isPaymentPosted, String username,String firstCardNumber);
	
	public int newPointTxnBucket(
			BigDecimal POINT_TXN_ID,BigDecimal CARDHOLDER_POINT_BUCKET_ID,String ORDER_NO,String ORG_NO,String CARD_TYPE,String CARD_NO
			,String TXN_CODE,String TXN_TYPE,String TXN_DESC,String PROGRAM_CODE
			,BigDecimal TOTAL_POINT_REDEEMED,BigDecimal TOTAL_AMOUNT_PURCHASED,String TOTAL_PREV_POINT_SIGN,BigDecimal TOTAL_PREV_POINT_BAL,String TOTAL_POINT_SIGN,BigDecimal TOTAL_POINT_BAL
			,String MR_PARTNER_TYPE,String MR_PARTNER_CODE,String MR_PARTNER_MEMBER_NO,String MR_PARTNER_POINT,BigDecimal MR_COST_PER_UNIT
			,String BUCKET01_POINT_PREV_SIGN,BigDecimal BUCKET01_POINT_PREV_BAL,BigDecimal BUCKET01_POINT_REDEEMED,String BUCKET01_POINT_SIGN,BigDecimal BUCKET01_POINT_BAL
			,String BUCKET02_POINT_PREV_SIGN,BigDecimal BUCKET02_POINT_PREV_BAL,BigDecimal BUCKET02_POINT_REDEEMED,String BUCKET02_POINT_SIGN,BigDecimal BUCKET02_POINT_BAL
			,String BUCKET03_POINT_PREV_SIGN,BigDecimal BUCKET03_POINT_PREV_BAL,BigDecimal BUCKET03_POINT_REDEEMED,String BUCKET03_POINT_SIGN,BigDecimal BUCKET03_POINT_BAL
			,String BUCKET04_POINT_PREV_SIGN,BigDecimal BUCKET04_POINT_PREV_BAL,BigDecimal BUCKET04_POINT_REDEEMED,String BUCKET04_POINT_SIGN,BigDecimal BUCKET04_POINT_BAL
			,String BUCKET05_POINT_PREV_SIGN,BigDecimal BUCKET05_POINT_PREV_BAL,BigDecimal BUCKET05_POINT_REDEEMED,String BUCKET05_POINT_SIGN,BigDecimal BUCKET05_POINT_BAL
			,String BUCKET06_POINT_PREV_SIGN,BigDecimal BUCKET06_POINT_PREV_BAL,BigDecimal BUCKET06_POINT_REDEEMED,String BUCKET06_POINT_SIGN,BigDecimal BUCKET06_POINT_BAL
			,String BUCKET07_POINT_PREV_SIGN,BigDecimal BUCKET07_POINT_PREV_BAL,BigDecimal BUCKET07_POINT_REDEEMED,String BUCKET07_POINT_SIGN,BigDecimal BUCKET07_POINT_BAL
			,String BUCKET08_POINT_PREV_SIGN,BigDecimal BUCKET08_POINT_PREV_BAL,BigDecimal BUCKET08_POINT_REDEEMED,String BUCKET08_POINT_SIGN,BigDecimal BUCKET08_POINT_BAL
			,String BUCKET09_POINT_PREV_SIGN,BigDecimal BUCKET09_POINT_PREV_BAL,BigDecimal BUCKET09_POINT_REDEEMED,String BUCKET09_POINT_SIGN,BigDecimal BUCKET09_POINT_BAL
			,String BUCKET10_POINT_PREV_SIGN,BigDecimal BUCKET10_POINT_PREV_BAL,BigDecimal BUCKET10_POINT_REDEEMED,String BUCKET10_POINT_SIGN,BigDecimal BUCKET10_POINT_BAL
			,String BUCKET11_POINT_PREV_SIGN,BigDecimal BUCKET11_POINT_PREV_BAL,BigDecimal BUCKET11_POINT_REDEEMED,String BUCKET11_POINT_SIGN,BigDecimal BUCKET11_POINT_BAL
			,String BUCKET12_POINT_PREV_SIGN,BigDecimal BUCKET12_POINT_PREV_BAL,BigDecimal BUCKET12_POINT_REDEEMED,String BUCKET12_POINT_SIGN,BigDecimal BUCKET12_POINT_BAL
			,String BUCKET13_POINT_PREV_SIGN,BigDecimal BUCKET13_POINT_PREV_BAL,BigDecimal BUCKET13_POINT_REDEEMED,String BUCKET13_POINT_SIGN,BigDecimal BUCKET13_POINT_BAL
			,String BUCKET14_POINT_PREV_SIGN,BigDecimal BUCKET14_POINT_PREV_BAL,BigDecimal BUCKET14_POINT_REDEEMED,String BUCKET14_POINT_SIGN,BigDecimal BUCKET14_POINT_BAL
			,String BUCKET15_POINT_PREV_SIGN,BigDecimal BUCKET15_POINT_PREV_BAL,BigDecimal BUCKET15_POINT_REDEEMED,String BUCKET15_POINT_SIGN,BigDecimal BUCKET15_POINT_BAL
			,String BUCKET16_POINT_PREV_SIGN,BigDecimal BUCKET16_POINT_PREV_BAL,BigDecimal BUCKET16_POINT_REDEEMED,String BUCKET16_POINT_SIGN,BigDecimal BUCKET16_POINT_BAL
			,String BUCKET17_POINT_PREV_SIGN,BigDecimal BUCKET17_POINT_PREV_BAL,BigDecimal BUCKET17_POINT_REDEEMED,String BUCKET17_POINT_SIGN,BigDecimal BUCKET17_POINT_BAL
			,String BUCKET18_POINT_PREV_SIGN,BigDecimal BUCKET18_POINT_PREV_BAL,BigDecimal BUCKET18_POINT_REDEEMED,String BUCKET18_POINT_SIGN,BigDecimal BUCKET18_POINT_BAL
			,String BUCKET19_POINT_PREV_SIGN,BigDecimal BUCKET19_POINT_PREV_BAL,BigDecimal BUCKET19_POINT_REDEEMED,String BUCKET19_POINT_SIGN,BigDecimal BUCKET19_POINT_BAL
			,String BUCKET20_POINT_PREV_SIGN,BigDecimal BUCKET20_POINT_PREV_BAL,BigDecimal BUCKET20_POINT_REDEEMED,String BUCKET20_POINT_SIGN,BigDecimal BUCKET20_POINT_BAL
			,String BUCKET21_POINT_PREV_SIGN,BigDecimal BUCKET21_POINT_PREV_BAL,BigDecimal BUCKET21_POINT_REDEEMED,String BUCKET21_POINT_SIGN,BigDecimal BUCKET21_POINT_BAL
			,String BUCKET22_POINT_PREV_SIGN,BigDecimal BUCKET22_POINT_PREV_BAL,BigDecimal BUCKET22_POINT_REDEEMED,String BUCKET22_POINT_SIGN,BigDecimal BUCKET22_POINT_BAL
			,String BUCKET23_POINT_PREV_SIGN,BigDecimal BUCKET23_POINT_PREV_BAL,BigDecimal BUCKET23_POINT_REDEEMED,String BUCKET23_POINT_SIGN,BigDecimal BUCKET23_POINT_BAL
			,String BUCKET24_POINT_PREV_SIGN,BigDecimal BUCKET24_POINT_PREV_BAL,BigDecimal BUCKET24_POINT_REDEEMED,String BUCKET24_POINT_SIGN,BigDecimal BUCKET24_POINT_BAL
			,String BUCKET25_POINT_PREV_SIGN,BigDecimal BUCKET25_POINT_PREV_BAL,BigDecimal BUCKET25_POINT_REDEEMED,String BUCKET25_POINT_SIGN,BigDecimal BUCKET25_POINT_BAL
			,String BUCKET26_POINT_PREV_SIGN,BigDecimal BUCKET26_POINT_PREV_BAL,BigDecimal BUCKET26_POINT_REDEEMED,String BUCKET26_POINT_SIGN,BigDecimal BUCKET26_POINT_BAL
			,String BUCKET27_POINT_PREV_SIGN,BigDecimal BUCKET27_POINT_PREV_BAL,BigDecimal BUCKET27_POINT_REDEEMED,String BUCKET27_POINT_SIGN,BigDecimal BUCKET27_POINT_BAL
			,String BUCKET28_POINT_PREV_SIGN,BigDecimal BUCKET28_POINT_PREV_BAL,BigDecimal BUCKET28_POINT_REDEEMED,String BUCKET28_POINT_SIGN,BigDecimal BUCKET28_POINT_BAL
			,String BUCKET29_POINT_PREV_SIGN,BigDecimal BUCKET29_POINT_PREV_BAL,BigDecimal BUCKET29_POINT_REDEEMED,String BUCKET29_POINT_SIGN,BigDecimal BUCKET29_POINT_BAL
			,String BUCKET30_POINT_PREV_SIGN,BigDecimal BUCKET30_POINT_PREV_BAL,BigDecimal BUCKET30_POINT_REDEEMED,String BUCKET30_POINT_SIGN,BigDecimal BUCKET30_POINT_BAL
			,String BUCKET31_POINT_PREV_SIGN,BigDecimal BUCKET31_POINT_PREV_BAL,BigDecimal BUCKET31_POINT_REDEEMED,String BUCKET31_POINT_SIGN,BigDecimal BUCKET31_POINT_BAL
			,String BUCKET32_POINT_PREV_SIGN,BigDecimal BUCKET32_POINT_PREV_BAL,BigDecimal BUCKET32_POINT_REDEEMED,String BUCKET32_POINT_SIGN,BigDecimal BUCKET32_POINT_BAL
			,String BUCKET33_POINT_PREV_SIGN,BigDecimal BUCKET33_POINT_PREV_BAL,BigDecimal BUCKET33_POINT_REDEEMED,String BUCKET33_POINT_SIGN,BigDecimal BUCKET33_POINT_BAL
			,String BUCKET34_POINT_PREV_SIGN,BigDecimal BUCKET34_POINT_PREV_BAL,BigDecimal BUCKET34_POINT_REDEEMED,String BUCKET34_POINT_SIGN,BigDecimal BUCKET34_POINT_BAL
			,String BUCKET35_POINT_PREV_SIGN,BigDecimal BUCKET35_POINT_PREV_BAL,BigDecimal BUCKET35_POINT_REDEEMED,String BUCKET35_POINT_SIGN,BigDecimal BUCKET35_POINT_BAL
			,String BUCKET36_POINT_PREV_SIGN,BigDecimal BUCKET36_POINT_PREV_BAL,BigDecimal BUCKET36_POINT_REDEEMED,String BUCKET36_POINT_SIGN,BigDecimal BUCKET36_POINT_BAL
			,String LAST_EXPIRED_POINT_SIGN,BigDecimal LAST_EXPIRED_POINT_BAL,String username);

	public List<ProductUnitPointDetailDTO> getProductPointDetailByID(List<BigDecimal> productIds);

	public List<OrsProgramDTO> getProgramList();
	
	public String getRewardCodeById(int rewardTypeId);
	
	public BigDecimal getRewardTypeIdByCode(String rewardTypeCode);
	
	public BigDecimal getM2UOrderNumCount(String orderNum, String mid);
	
	public int updateCardBucket(String TOTAL_POINTS_SIGN,BigDecimal TOTAL_POINTS_BAL,BigDecimal TRANSFORMED_TOTAL_POINTS_BAL
			,String BUCKET01_POINT_SIGN,BigDecimal BUCKET01_POINT_BAL,String BUCKET02_POINT_SIGN,BigDecimal BUCKET02_POINT_BAL,String BUCKET03_POINT_SIGN,BigDecimal BUCKET03_POINT_BAL
			,String BUCKET04_POINT_SIGN,BigDecimal BUCKET04_POINT_BAL,String BUCKET05_POINT_SIGN,BigDecimal BUCKET05_POINT_BAL,String BUCKET06_POINT_SIGN,BigDecimal BUCKET06_POINT_BAL
			,String BUCKET07_POINT_SIGN,BigDecimal BUCKET07_POINT_BAL,String BUCKET08_POINT_SIGN,BigDecimal BUCKET08_POINT_BAL,String BUCKET09_POINT_SIGN,BigDecimal BUCKET09_POINT_BAL
			,String BUCKET10_POINT_SIGN,BigDecimal BUCKET10_POINT_BAL,String BUCKET11_POINT_SIGN,BigDecimal BUCKET11_POINT_BAL,String BUCKET12_POINT_SIGN,BigDecimal BUCKET12_POINT_BAL
			,String BUCKET13_POINT_SIGN,BigDecimal BUCKET13_POINT_BAL,String BUCKET14_POINT_SIGN,BigDecimal BUCKET14_POINT_BAL,String BUCKET15_POINT_SIGN,BigDecimal BUCKET15_POINT_BAL
			,String BUCKET16_POINT_SIGN,BigDecimal BUCKET16_POINT_BAL,String BUCKET17_POINT_SIGN,BigDecimal BUCKET17_POINT_BAL,String BUCKET18_POINT_SIGN,BigDecimal BUCKET18_POINT_BAL
			,String BUCKET19_POINT_SIGN,BigDecimal BUCKET19_POINT_BAL,String BUCKET20_POINT_SIGN,BigDecimal BUCKET20_POINT_BAL,String BUCKET21_POINT_SIGN,BigDecimal BUCKET21_POINT_BAL
			,String BUCKET22_POINT_SIGN,BigDecimal BUCKET22_POINT_BAL,String BUCKET23_POINT_SIGN,BigDecimal BUCKET23_POINT_BAL,String BUCKET24_POINT_SIGN,BigDecimal BUCKET24_POINT_BAL
			,String BUCKET25_POINT_SIGN,BigDecimal BUCKET25_POINT_BAL,String BUCKET26_POINT_SIGN,BigDecimal BUCKET26_POINT_BAL,String BUCKET27_POINT_SIGN,BigDecimal BUCKET27_POINT_BAL
			,String BUCKET28_POINT_SIGN,BigDecimal BUCKET28_POINT_BAL,String BUCKET29_POINT_SIGN,BigDecimal BUCKET29_POINT_BAL,String BUCKET30_POINT_SIGN,BigDecimal BUCKET30_POINT_BAL
			,String BUCKET31_POINT_SIGN,BigDecimal BUCKET31_POINT_BAL,String BUCKET32_POINT_SIGN,BigDecimal BUCKET32_POINT_BAL,String BUCKET33_POINT_SIGN,BigDecimal BUCKET33_POINT_BAL
			,String BUCKET34_POINT_SIGN,BigDecimal BUCKET34_POINT_BAL,String BUCKET35_POINT_SIGN,BigDecimal BUCKET35_POINT_BAL,String BUCKET36_POINT_SIGN,BigDecimal BUCKET36_POINT_BAL
			,String EDITED_BY,BigDecimal CARDHOLDER_POINT_BUCKET_ID);
	
	public BigDecimal getMerchantIdByMID(String MID);
	
	public TerminalConversionDTO getTerminalConversionInfoByTID(String TID);
	
	public Integer getProgramIdByCardNum(String cardNum);
	
	public String getICNumFromDebitCardNum(String debitCardNum);
	
	public String getApprovalCode();
	
	public String getORSOrderNum();
	
	public List<ProductPlaticTypeLinkDTO> getProductPlasticType(BigDecimal productId);
	
	public ValidateAirlineRedeemProductResponse validateAirlineRedeemProduct(ValidateAirlineRedeemProductRequest validateAirlineRedeemProductRequest) throws Exception;
}
