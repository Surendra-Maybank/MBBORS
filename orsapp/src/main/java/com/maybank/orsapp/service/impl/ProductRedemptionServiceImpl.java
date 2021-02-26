package com.maybank.orsapp.service.impl;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;

import com.maybank.orsapp.constant.MBBORSConstant;
import com.maybank.orsapp.controller.request.MBBORSM2UPointRedemptionReq;
import com.maybank.orsapp.controller.request.MBBORSPointRedemptionAirlineReq;
import com.maybank.orsapp.controller.request.MBBORSPointRedemptionReq;
import com.maybank.orsapp.controller.request.MBBORSSearchProductRedemptionAndCardInfoAirlineReq;
import com.maybank.orsapp.controller.request.MBBORSSearchProductRedemptionAndCardInfoReq;
import com.maybank.orsapp.controller.request.MBBORSTerminalPointRedemptionReq;
import com.maybank.orsapp.controller.request.PointRedemptionCardHolderReq;
import com.maybank.orsapp.controller.request.PointRedemptionProductReq;
import com.maybank.orsapp.controller.requestval.CommonValidator;
import com.maybank.orsapp.controller.requestval.MBBORSM2UPointRedemptionReqVal;
import com.maybank.orsapp.controller.requestval.MBBORSPointRedemptionAirlineReqVal;
import com.maybank.orsapp.controller.requestval.MBBORSPointRedemptionReqVal;
import com.maybank.orsapp.controller.requestval.MBBORSSearchProductRedemptionAndCardInfoReqAirlineVal;
import com.maybank.orsapp.controller.requestval.MBBORSSearchProductRedemptionAndCardInfoReqVal;
import com.maybank.orsapp.controller.response.M2UPointRedemptionDeductedCardRes;
import com.maybank.orsapp.controller.response.MBBORSM2UPointRedemptionRes;
import com.maybank.orsapp.controller.response.MBBORSPointRedemptionAirlineRes;
import com.maybank.orsapp.controller.response.MBBORSPointRedemptionRes;
import com.maybank.orsapp.controller.response.MBBORSSearchProductRedemptionAndCardInfoAirlineRes;
import com.maybank.orsapp.controller.response.MBBORSSearchProductRedemptionAndCardInfoRes;
import com.maybank.orsapp.controller.response.MBBORSTerminalPointRedemptionRes;
import com.maybank.orsapp.dao.ProductRedemptionDao;
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
import com.maybank.orsapp.extapi.sdk.airasia.BigLifeService;
import com.maybank.orsapp.extapi.sdk.airasia.MBBORSBigLifePointsAccrualReqBean;
import com.maybank.orsapp.extapi.sdk.airasia.MBBORSBigLifePointsAccrualResBean;
import com.maybank.orsapp.service.ProductRedemptionService;
import com.maybank.orsapp.utils.ProductRedemptionUtil;

@Service
public class ProductRedemptionServiceImpl implements ProductRedemptionService{

	private final Logger logger = LoggerFactory.getLogger(ProductRedemptionServiceImpl.class);

	@Autowired	
	ProductRedemptionDao productRedemptionDao;
	
	@Autowired
	BigLifeService bigLifeService;
	
	public MBBORSSearchProductRedemptionAndCardInfoRes searchProductRedemptionAndCardInfo(
			MBBORSSearchProductRedemptionAndCardInfoReq request) {
		
		System.out.println("Receive Request searchProductRedemptionAndCardInfo : ".concat(request.toString()));
		
		MBBORSSearchProductRedemptionAndCardInfoRes res = new MBBORSSearchProductRedemptionAndCardInfoRes();
		
		List<CardHolderTotalPointDTO> redeemableCardList = new ArrayList<CardHolderTotalPointDTO>();
			
		String result = MBBORSSearchProductRedemptionAndCardInfoReqVal.validate(request);
		
		if (result.equals("")==false){
			res.setResponseCode("01");
			res.setResponseMessage(result);
			return res;
		}
				
		BigDecimal rewardtypeId = new BigDecimal(request.getReward_type_id());
		String cardNumber = request.getCard_number();
		String icNumber = request.getIc_number();
		
		try {
			
			if(!CommonValidator.isEmptyStr(cardNumber)&&CommonValidator.isEmptyStr(icNumber)) {
				
				
				
				icNumber = productRedemptionDao.getIcNumberByCardNum(cardNumber);
			}
			
			if (icNumber==null||icNumber.equals("")==true){
				res.setResponseCode("01");
				res.setResponseMessage("IC Number Not Found");
				return res;
			}
			
			//Check reward type
			String rewardTypeCode = productRedemptionDao.getRewardCodeById(rewardtypeId.intValue());
			
			if(rewardTypeCode==null) {
				res.setResponseCode("01");
				res.setResponseMessage("Cannot found reward type");
				return res;
			}
			
			//Get Product List
			List<ProductRedemptionDTO> productList = productRedemptionDao.getProductRedemption(rewardtypeId);
			if(productList==null||productList.size()==0) {
				res.setResponseCode("01");
				res.setResponseMessage("Cannot found product");
				return res;
			}
			
			
			//Get Customer Details
			CardHolderDetailDTO customerDetails = productRedemptionDao.getCardHolderDetailsByIcNum(icNumber);
			
			if (customerDetails==null){
				res.setResponseCode("01");
				res.setResponseMessage("Customer Details Not Found");
				return res;
			}
			//Get Credit Debit List
			List<CreditAndDebitCardDTO> creditDebitList = productRedemptionDao.getCreditAndDebitCardByIcNum(icNumber);
			
			//Get Redeemable Card List
			redeemableCardList = ProductRedemptionUtil.getCardRedeemableList(productRedemptionDao,icNumber,rewardtypeId);
			
			res.setResponseCode(MBBORSConstant.RES_CODE_SUCCESS);
			res.setResponseMessage(MBBORSConstant.RES_DESC_SUCCESS);
			res.setCreditDebitList(creditDebitList);
			res.setProductList(productList);
			res.setCustomerDetails(customerDetails);
			res.setCardHolderTotalPoint(redeemableCardList);
		}catch(Exception ex) {
			res.setResponseCode(MBBORSConstant.RES_CODE_SYSTEM_ERROR);
			res.setResponseMessage(MBBORSConstant.RES_DESC_SYSTEM_ERROR);
		}
		
		return res;
	}
	
	public MBBORSSearchProductRedemptionAndCardInfoAirlineRes searchProductRedemptionAndCardInfoAirline(
			MBBORSSearchProductRedemptionAndCardInfoAirlineReq request) {
		
		System.out.println("Receive Request searchProductRedemptionAndCardInfo : ".concat(request.toString()));
		
		MBBORSSearchProductRedemptionAndCardInfoAirlineRes res = new MBBORSSearchProductRedemptionAndCardInfoAirlineRes();
		
		List<CardHolderTotalPointDTO> redeemableCardList = new ArrayList<CardHolderTotalPointDTO>();
			
		String result = MBBORSSearchProductRedemptionAndCardInfoReqAirlineVal.validate(request);
		
		if (result.equals("")==false){
			res.setResponseCode("01");
			res.setResponseMessage(result);
			return res;
		}
				
		BigDecimal rewardtypeId = new BigDecimal(request.getReward_type_id());
		String cardNumber = request.getCard_number();
		String icNumber = request.getIc_number();
		
		try {
			
			if(!CommonValidator.isEmptyStr(cardNumber)&&CommonValidator.isEmptyStr(icNumber)) {
				
				
				
				icNumber = productRedemptionDao.getIcNumberByCardNum(cardNumber);
			}
			
			if (icNumber==null||icNumber.equals("")==true){
				res.setResponseCode("01");
				res.setResponseMessage("IC Number Not Found");
				return res;
			}
			
			//Check reward type
			String rewardTypeCode = productRedemptionDao.getRewardCodeById(rewardtypeId.intValue());
			
			if(rewardTypeCode==null) {
				res.setResponseCode("01");
				res.setResponseMessage("Cannot found reward type");
				return res;
			}
			
			//Get Product List
			List<ProductRedemptionDTO> productList = productRedemptionDao.getAirLineProductRedemption(rewardtypeId);
			if(productList==null||productList.size()==0) {
				res.setResponseCode("01");
				res.setResponseMessage("Cannot found product");
				return res;
			}
			
			
			//Get Customer Details
			CardHolderDetailDTO customerDetails = productRedemptionDao.getCardHolderDetailsByIcNum(icNumber);
			
			if (customerDetails==null){
				res.setResponseCode("01");
				res.setResponseMessage("Customer Details Not Found");
				return res;
			}
			//Get Credit Debit List
			List<CreditAndDebitCardDTO> creditDebitList = productRedemptionDao.getCreditAndDebitCardByIcNum(icNumber);
			
			//Get Redeemable Card List
			redeemableCardList = ProductRedemptionUtil.getCardRedeemableList(productRedemptionDao,icNumber,rewardtypeId);
			
			res.setResponseCode(MBBORSConstant.RES_CODE_SUCCESS);
			res.setResponseMessage(MBBORSConstant.RES_DESC_SUCCESS);
			res.setCreditDebitList(creditDebitList);
			res.setProductList(productList);
			res.setCustomerDetails(customerDetails);
			res.setCardHolderTotalPoint(redeemableCardList);
		}catch(Exception ex) {
			res.setResponseCode(MBBORSConstant.RES_CODE_SYSTEM_ERROR);
			res.setResponseMessage(MBBORSConstant.RES_DESC_SYSTEM_ERROR);
		}
		
		return res;
	}

//	public static List<CardHolderTotalPointDTO> removeDuplicate(List<CardHolderTotalPointDTO> cardTotalPoint) {
//		HashSet<CardHolderTotalPointDTO> set = new HashSet<CardHolderTotalPointDTO>(); 
//		
//		List<CardHolderTotalPointDTO> resultList = new ArrayList<CardHolderTotalPointDTO>();
//		
//		set.addAll(cardTotalPoint);
//		
//		resultList.addAll(set);
//		
//		return resultList;
//	}
	
	public MBBORSPointRedemptionRes pointRedemption(MBBORSPointRedemptionReq request) {
		
		logger.info("MSG-IN");
		
		MBBORSPointRedemptionRes res = new MBBORSPointRedemptionRes();
		
		String result = MBBORSPointRedemptionReqVal.validate(request);
		
		if (result.equals("")==false){
			res.setResponseCode("01");
			res.setResponseMessage(result);
			return res;
		}
		
		List<PointRedemptionProductReq> productList = request.getProduct();
		PointRedemptionCardHolderReq cardHolder = request.getCardholder();
		BigDecimal totalProductPoint = BigDecimal.ZERO;
		
		BigDecimal rewardTypeId = new BigDecimal(cardHolder.getReward_type_id());
		String cardNumber = cardHolder.getCard_number();
		String icNumber = cardHolder.getIc_number();
		String email = cardHolder.getEmail();
		String memberNumber = cardHolder.getMember_number();
		String address1 = cardHolder.getAddress1();
		String address2 = cardHolder.getAddress2();
		String address3 = cardHolder.getAddress3();
		String address4 = cardHolder.getAddress4();
		String zipCode = cardHolder.getZipCode();
		
		try {
			
			if(!CommonValidator.isEmptyStr(cardNumber)&&CommonValidator.isEmptyStr(icNumber)) {
				icNumber = productRedemptionDao.getICNumFromDebitCardNum(cardNumber);
				if (icNumber==null||icNumber.equals("")==true){
					icNumber = productRedemptionDao.getIcNumberByCardNum(cardNumber);
				}
			}
			
			if (icNumber==null||icNumber.equals("")==true){
				res.setResponseCode("01");
				res.setResponseMessage("IC Number Not Found");
				return res;
			}
			
			//Check reward type
			String rewardTypeCode = productRedemptionDao.getRewardCodeById(rewardTypeId.intValue());
			
			if(rewardTypeCode==null) {
				res.setResponseCode("01");
				res.setResponseMessage("Cannot found reward type");
				return res;
			}
			
			//Get customer card bucket
			List<CardHolderBucketDetailDTO> redeemableCardList = ProductRedemptionUtil.getCardRedeemableBucketList(productRedemptionDao,icNumber,rewardTypeId);
			if(redeemableCardList==null) {
				res.setResponseCode("01");
				res.setResponseMessage("Cannot found card");
				return res;
			}
			
			redeemableCardList = ProductRedemptionUtil.sortBucketList(redeemableCardList, icNumber);
			
			if(redeemableCardList==null||redeemableCardList.size()==0) {
				res.setResponseCode("01");
				res.setResponseMessage("No available card");
				return res;
			}
			
			BigDecimal availableTotalPoint = ProductRedemptionUtil.totalAvailableRedeemPoint(redeemableCardList);
			
			List<CardHolderBucketDetailDTO> deductedPointBucketList = new ArrayList<CardHolderBucketDetailDTO>();
			
			//Get total product point
			totalProductPoint = ProductRedemptionUtil.getTotalProducPoint(productRedemptionDao, productList);
			
			if(totalProductPoint == null) {
				res.setResponseCode("01");
				res.setResponseMessage("Cannot found product Unit point");
				return res;
			}
			
			if(availableTotalPoint.compareTo(totalProductPoint)<0) {
				res.setResponseCode("01");
				res.setResponseMessage("Total available point not enough");
				return res;
			}
			
			if(rewardTypeCode.equals(MBBORSConstant.REWARD_TYPE_CODE_MR)
					&&(CommonValidator.isEmptyStr(memberNumber))) {
				res.setResponseCode("01");
				res.setResponseMessage("Member number cannot empty if Reward Type is 'Membership Rewards'");
				return res;
			}
			
			System.out.println("totalProductPoint : ".concat(totalProductPoint.toPlainString()));
			
			if(rewardTypeCode.equals(MBBORSConstant.REWARD_TYPE_CODE_TP)) {
				deductedPointBucketList = ProductRedemptionUtil.getDeductedPointBucket36List(new ArrayList<CardHolderBucketDetailDTO>(redeemableCardList)
					, totalProductPoint);
			}else {
				deductedPointBucketList = ProductRedemptionUtil.getDeductedPointBucket01List(new ArrayList<CardHolderBucketDetailDTO>(redeemableCardList)
						, totalProductPoint);
			}
			
			if(deductedPointBucketList==null) {
				res.setResponseCode("01");
				res.setResponseMessage("Bucket Point Not Enough");
				return res;
			}
			
			//Get Customer Details
			CardHolderDetailDTO customerDetails = productRedemptionDao.getCardHolderDetailsByIcNum(icNumber);
			if(customerDetails == null) {
				res.setResponseCode("01");
				res.setResponseMessage("Cannot found customer details");
				return res;
			}else {
				customerDetails.setAddr1(address1);
				customerDetails.setAddr2(address2);
				customerDetails.setAddr3(address3);
				customerDetails.setAddr4(address4);
				customerDetails.setZip_code(zipCode);
			}
			
			//Get Product List
			List<ProductUnitPointDetailDTO> productDetailList = productRedemptionDao
					.getProductPointDetailByID(
							productList.stream()
							.map(e -> new BigDecimal(e.getProduct_id()))
							.collect(Collectors.toList()));
			
			if(productDetailList==null||productDetailList.size()==0) {
				res.setResponseCode("01");
				res.setResponseMessage("Cannot found product details");
				return res;
			}
			System.out.println("rewardTypeCode = ".concat(rewardTypeCode));
			System.out.println("redeemableCardList = ".concat(Integer.toString(redeemableCardList.size())));
			System.out.println("deductedPointBucketList = ".concat(Integer.toString(deductedPointBucketList.size())));
			ProductRedemptionUtil.insertTxn(productRedemptionDao, 
					redeemableCardList, deductedPointBucketList,
					productList,productDetailList,
					customerDetails, totalProductPoint, 
					rewardTypeId, 
					rewardTypeCode,
					email,
					memberNumber);
			
			res.setResponseCode(MBBORSConstant.RES_CODE_SUCCESS);
			res.setResponseMessage(MBBORSConstant.RES_DESC_SUCCESS);
			
		}catch(Exception ex) {
			ex.printStackTrace();
			res.setResponseCode(MBBORSConstant.RES_CODE_SYSTEM_ERROR);
			res.setResponseMessage(MBBORSConstant.RES_DESC_SYSTEM_ERROR);
		}
		
		return res;
	}
	
	public MBBORSPointRedemptionAirlineRes pointRedemptionAirline(MBBORSPointRedemptionAirlineReq request) {
		
		logger.info("MSG-IN");
		
		MBBORSPointRedemptionAirlineRes res = new MBBORSPointRedemptionAirlineRes();
		
		String result = MBBORSPointRedemptionAirlineReqVal.validate(request);
		
		if (result.equals("")==false){
			res.setResponseCode("01");
			res.setResponseMessage(result);
			return res;
		}
		
		PointRedemptionProductReq product = request.getProduct();
		PointRedemptionCardHolderReq cardHolder = request.getCardholder();
		BigDecimal totalProductPoint = BigDecimal.ZERO;
		
		BigDecimal rewardTypeId = new BigDecimal(cardHolder.getReward_type_id());
		String cardNumber = cardHolder.getCard_number();
		String icNumber = cardHolder.getIc_number();
		String email = cardHolder.getEmail();
		String memberNumber = cardHolder.getMember_number();
		String address1 = cardHolder.getAddress1();
		String address2 = cardHolder.getAddress2();
		String address3 = cardHolder.getAddress3();
		String address4 = cardHolder.getAddress4();
		String zipCode = cardHolder.getZipCode();
		List<PointRedemptionProductReq> productList = new ArrayList<PointRedemptionProductReq>();
		List<ProductPlaticTypeLinkDTO> productPlasticTypeList = null;
		List<Integer> productPlasticTypeIDList = null;
		productList.add(product);
		
		try {
			
			if(!CommonValidator.isEmptyStr(cardNumber)&&CommonValidator.isEmptyStr(icNumber)) {
				icNumber = productRedemptionDao.getICNumFromDebitCardNum(cardNumber);
				if (icNumber==null||icNumber.equals("")==true){
					icNumber = productRedemptionDao.getIcNumberByCardNum(cardNumber);
				}
			}
			
			if (icNumber==null||icNumber.equals("")==true){
				res.setResponseCode("01");
				res.setResponseMessage("IC Number Not Found");
				return res;
			}
			//Get Plastic Type
			productPlasticTypeList = productRedemptionDao.getProductPlasticType(new BigDecimal(product.getProduct_id()));
			if (productPlasticTypeList==null||productPlasticTypeList.size()==0){
				res.setResponseCode("01");
				res.setResponseMessage("Cannot found plastic type");
				return res;
			}else {
				productPlasticTypeIDList = productPlasticTypeList.stream().map(e -> e.getPlastic_type_id())
						.collect(Collectors.toList());
			}
			
			//Check reward type
			String rewardTypeCode = productRedemptionDao.getRewardCodeById(rewardTypeId.intValue());
			
			if(rewardTypeCode==null) {
				res.setResponseCode("01");
				res.setResponseMessage("Cannot found reward type");
				return res;
			}
			
			//Get customer card bucket
			List<CardHolderBucketDetailDTO> redeemableCardList = ProductRedemptionUtil.getAirlineCardRedeemableBucketList(productRedemptionDao,icNumber,rewardTypeId,productPlasticTypeIDList);
			if(redeemableCardList==null) {
				res.setResponseCode("01");
				res.setResponseMessage("Cannot found card");
				return res;
			}
			
			redeemableCardList = ProductRedemptionUtil.sortBucketList(redeemableCardList, icNumber);
			
			if(redeemableCardList==null||redeemableCardList.size()==0) {
				res.setResponseCode("01");
				res.setResponseMessage("No available card");
				return res;
			}
			
			BigDecimal availableTotalPoint = ProductRedemptionUtil.totalAvailableRedeemPoint(redeemableCardList);
			
			List<CardHolderBucketDetailDTO> deductedPointBucketList = new ArrayList<CardHolderBucketDetailDTO>();
			
			//Get total product point
			totalProductPoint = ProductRedemptionUtil.getTotalProducPoint(productRedemptionDao, productList);
			
			if(totalProductPoint == null) {
				res.setResponseCode("01");
				res.setResponseMessage("Cannot found product Unit point");
				return res;
			}
			
			if(availableTotalPoint.compareTo(totalProductPoint)<0) {
				res.setResponseCode("01");
				res.setResponseMessage("Total available point not enough");
				return res;
			}
			
			if(rewardTypeCode.equals(MBBORSConstant.REWARD_TYPE_CODE_MR)
					&&(CommonValidator.isEmptyStr(memberNumber))) {
				res.setResponseCode("01");
				res.setResponseMessage("Member number cannot empty if Reward Type is 'Membership Rewards'");
				return res;
			}
			
			System.out.println("totalProductPoint : ".concat(totalProductPoint.toPlainString()));
			
			if(rewardTypeCode.equals(MBBORSConstant.REWARD_TYPE_CODE_TP)) {
				deductedPointBucketList = ProductRedemptionUtil.getDeductedPointBucket36List(new ArrayList<CardHolderBucketDetailDTO>(redeemableCardList)
					, totalProductPoint);
			}else {
				deductedPointBucketList = ProductRedemptionUtil.getDeductedPointBucket01List(new ArrayList<CardHolderBucketDetailDTO>(redeemableCardList)
						, totalProductPoint);
			}
			
			if(deductedPointBucketList==null) {
				res.setResponseCode("01");
				res.setResponseMessage("Bucket Point Not Enough");
				return res;
			}
			
			//Get Customer Details
			CardHolderDetailDTO customerDetails = productRedemptionDao.getCardHolderDetailsByIcNum(icNumber);
			if(customerDetails == null) {
				res.setResponseCode("01");
				res.setResponseMessage("Cannot found customer details");
				return res;
			}else {
				customerDetails.setAddr1(address1);
				customerDetails.setAddr2(address2);
				customerDetails.setAddr3(address3);
				customerDetails.setAddr4(address4);
				customerDetails.setZip_code(zipCode);
			}
			
			//Get Product List
			List<ProductUnitPointDetailDTO> productDetailList = productRedemptionDao
					.getProductPointDetailByID(
							productList.stream()
							.map(e -> new BigDecimal(e.getProduct_id()))
							.collect(Collectors.toList()));
			
			if(productDetailList==null||productDetailList.size()==0) {
				res.setResponseCode("01");
				res.setResponseMessage("Cannot found product details");
				return res;
			}
			System.out.println("rewardTypeCode = ".concat(rewardTypeCode));
			System.out.println("redeemableCardList = ".concat(Integer.toString(redeemableCardList.size())));
			System.out.println("deductedPointBucketList = ".concat(Integer.toString(deductedPointBucketList.size())));
						
			
			String orderNum = productRedemptionDao.getORSOrderNum();
			
			

			MBBORSBigLifePointsAccrualReqBean airAsiaReq = new MBBORSBigLifePointsAccrualReqBean();
			airAsiaReq.setMemberId(memberNumber);
			airAsiaReq.setPartnerCode("MAYB");
			airAsiaReq.setAmount(totalProductPoint.intValue());
			airAsiaReq.setTransactionDate(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
			airAsiaReq.setDescription("Point Redemption");
			airAsiaReq.setReferenceNumber(orderNum);
			airAsiaReq.setPartnerMID("4582008304");
			
			MBBORSBigLifePointsAccrualResBean airAsiaRes = bigLifeService.accrual(airAsiaReq);
			
			if(airAsiaRes.getCode()!=200) {
				res.setResponseCode("01");
				res.setResponseMessage("AIRLINE_API_FAIL_REVERSE_PLS");
				return res;
			}
			
			String txnId = ProductRedemptionUtil.insertTxnAirline(productRedemptionDao, 
					redeemableCardList, deductedPointBucketList,
					productList,productDetailList,
					customerDetails, totalProductPoint, 
					rewardTypeId, 
					rewardTypeCode,
					email,
					memberNumber, orderNum);
			
			
			res.setResponseCode(MBBORSConstant.RES_CODE_SUCCESS);
			res.setResponseMessage(MBBORSConstant.RES_DESC_SUCCESS);
			res.setOrder_num(orderNum);
			
		}catch(Exception ex) {
			ex.printStackTrace();
			res.setResponseCode(MBBORSConstant.RES_CODE_SYSTEM_ERROR);
			res.setResponseMessage(MBBORSConstant.RES_DESC_SYSTEM_ERROR);
		}
		
		return res;
	}
	
	public MBBORSM2UPointRedemptionRes m2uPointRedemption(MBBORSM2UPointRedemptionReq request) {
		
		MBBORSM2UPointRedemptionRes res = new MBBORSM2UPointRedemptionRes();
		
		String result = MBBORSM2UPointRedemptionReqVal.validate(request);
		
		if (result.equals("")==false){
			res.setResponseCode("32");
			res.setResponseMessage(result);
			return res;
		}
		
		String icNumber = request.getIcno();
		String refOrderNum = request.getOrder_Id();
		
		BigDecimal totalProductPoint = new BigDecimal(request.getRedeem_Points());
		String rewardTypeCode = request.getRedeem_Type();
		String mid = request.getMerchant_Code();
		BigDecimal rewardTypeId = BigDecimal.ZERO;
		BigDecimal merchantId = BigDecimal.ZERO;
		String OrsOrderNum = null;
		List<M2UPointRedemptionDeductedCardRes> Card_Points_Deduct_List = new ArrayList<M2UPointRedemptionDeductedCardRes>();
		
		try {
			
			merchantId = productRedemptionDao.getMerchantIdByMID(mid);
			
			if(merchantId==null||merchantId.compareTo(BigDecimal.ZERO)==0) {
				res.setResponseCode("11");
				res.setResponseMessage("Merchant Not Found");
				return res;
			}
			
			
			
			//Get rewardType Id
			rewardTypeId = productRedemptionDao.getRewardTypeIdByCode(rewardTypeCode);
			
			if(rewardTypeId==null||rewardTypeId.compareTo(BigDecimal.ZERO)==0) {
				res.setResponseCode("25");
				res.setResponseMessage("insufficient Point");
				return res;
			}
			
			//Get customer card bucket
			List<CardHolderBucketDetailDTO> redeemableCardList = ProductRedemptionUtil.getCardRedeemableBucketList(productRedemptionDao,icNumber,rewardTypeId);
			if(redeemableCardList==null) {
				res.setResponseCode("30");
				res.setResponseMessage("Cannot found card");
				return res;
			}
			
			redeemableCardList = ProductRedemptionUtil.sortBucketList(redeemableCardList, icNumber);
			
			if(redeemableCardList==null||redeemableCardList.size()==0) {
				res.setResponseCode("30");
				res.setResponseMessage("No available card for redemption");
				return res;
			}
			
			BigDecimal availableTotalPoint = ProductRedemptionUtil.totalAvailableRedeemPoint(redeemableCardList);
			
			List<CardHolderBucketDetailDTO> deductedPointBucketList = new ArrayList<CardHolderBucketDetailDTO>();
			
			if(availableTotalPoint.compareTo(totalProductPoint)<0) {
				res.setResponseCode("25");
				res.setResponseMessage("insufficient Point");
				return res;
			}
			
			if(rewardTypeCode.equals(MBBORSConstant.REWARD_TYPE_CODE_TP)) {
				deductedPointBucketList = ProductRedemptionUtil.getDeductedPointBucket36List(new ArrayList<CardHolderBucketDetailDTO>(redeemableCardList)
					, totalProductPoint);
			}else {
				deductedPointBucketList = ProductRedemptionUtil.getDeductedPointBucket01List(new ArrayList<CardHolderBucketDetailDTO>(redeemableCardList)
						, totalProductPoint);
			}
			
			if(deductedPointBucketList==null) {
				res.setResponseCode("25");
				res.setResponseMessage("Bucket Point Not Enough");
				return res;
			}
			
			//Get Customer Details
			CardHolderDetailDTO customerDetails = productRedemptionDao.getCardHolderDetailsByIcNum(icNumber);
			if(customerDetails == null) {
				res.setResponseCode("99");
				res.setResponseMessage("Cannot found customer details");
				return res;
			}			
			
			//Check Duplicate
			BigDecimal countOrderNum =productRedemptionDao.getM2UOrderNumCount(refOrderNum, mid);
			
			if(countOrderNum!=null&&countOrderNum.compareTo(BigDecimal.ZERO)>0) {
				res.setResponseCode("31");
				res.setResponseMessage("Duplicate order number");
				return res;
			}
			
			System.out.println("rewardTypeCode = ".concat(rewardTypeCode));
			System.out.println("redeemableCardList = ".concat(Integer.toString(redeemableCardList.size())));
			System.out.println("deductedPointBucketList = ".concat(Integer.toString(deductedPointBucketList.size())));
			OrsOrderNum = ProductRedemptionUtil.insertTxnM2U(productRedemptionDao, 
					redeemableCardList, deductedPointBucketList,
					customerDetails, totalProductPoint, 
					rewardTypeId, 
					rewardTypeCode,
					"",merchantId, refOrderNum);
			
			if(OrsOrderNum == null) {
				res.setResponseCode("99");
				res.setResponseMessage("Cannot update data");
				return res;
			}
			
			res.setResponseCode(MBBORSConstant.RES_CODE_SUCCESS);
			res.setResponseMessage(MBBORSConstant.RES_DESC_SUCCESS);
			res.setIcno(icNumber);
			res.setOrder_Id(refOrderNum);
			res.setRefno(OrsOrderNum);
			res.setPrev_pts_bal(availableTotalPoint.setScale(0, RoundingMode.FLOOR));
			res.setDeducted_Points(totalProductPoint.setScale(0, RoundingMode.FLOOR));
			res.setNew_pts_bal(availableTotalPoint.subtract(totalProductPoint).setScale(0, RoundingMode.FLOOR));
			res.setReward_type(rewardTypeCode);
//			for(int ind=0;ind<deductedPointBucketList.size();ind++) {
//				CardHolderBucketDetailDTO afterDeduct = deductedPointBucketList.get(ind);
//				CardHolderBucketDetailDTO beforeDeduct = redeemableCardList.get(ind);
//				
//				if(afterDeduct.isDeducted()) {
//				M2UPointRedemptionDeductedCardRes newRecord = new M2UPointRedemptionDeductedCardRes();
//				newRecord.setCard_PAN(afterDeduct.getCard_no());
//				newRecord.setIcno(afterDeduct.getCust_ic_no());
//				newRecord.setPrev_Pts_Bal(beforeDeduct.getTotal_points_bal());
//				newRecord.setNew_Pts_Bal(afterDeduct.getTotal_points_bal());
//				newRecord.setPts_Deducted(ProductRedemptionUtil.diffValue(beforeDeduct.getTotal_points_bal(),afterDeduct.getTotal_points_bal()));
//				newRecord.setPosting_Flag((afterDeduct.getCard_post_flag().toUpperCase().equals("XX")?"PP":afterDeduct.getCard_post_flag()));
//				String programCodeM2u = "";
//				for(OrsProgramDTO program:programList) {
//					if(program.getProgramId()==afterDeduct.getProgram_id()) {
//						programCodeM2u = program.getProgramCode();
//					}
//				}
//				
//				newRecord.setProgram_Id(programCodeM2u);
//				Card_Points_Deduct_List.add(newRecord);		
//				}
//			}
//			
//			res.setCard_Points_Deduct_List(Card_Points_Deduct_List);		
			
		}catch(Exception ex) {
			ex.printStackTrace();
			res.setResponseCode(MBBORSConstant.RES_CODE_SYSTEM_ERROR);
			res.setResponseMessage(MBBORSConstant.RES_DESC_SYSTEM_ERROR);
		}
		
		return res;
	}
	
	public MBBORSTerminalPointRedemptionRes terminalPointRedemption(MBBORSTerminalPointRedemptionReq request) {
		
		MBBORSTerminalPointRedemptionRes res = new MBBORSTerminalPointRedemptionRes();
		
		if(CommonValidator.isEmptyStr(request.getCustomerCardNo())==true
				||CommonValidator.isPositiveNumeric(request.getCustomerCardNo())==false) {
			res.setResponseCode("14");
			res.setResponseMessage("Card Number cannot be empty.");
			return res;
		}
		
		if(CommonValidator.isEmptyStr(request.getTid())==true) {
			res.setResponseCode("03");
			res.setResponseMessage("Tid cannot be empty.");
			return res;
		}
		
		if(CommonValidator.isEmptyStr(request.getRmValue())==true
				||CommonValidator.isPositiveNumeric(request.getRmValue())==false) {
			res.setResponseMessage("RmValue cannot be empty.");
			return res;
		}
		
		String tid = request.getTid();
		String cardNum = request.getCustomerCardNo();
		BigDecimal rmValue = new BigDecimal(request.getRmValue()).divide(new BigDecimal("100"),2,RoundingMode.FLOOR);
		BigDecimal merchantId = BigDecimal.ZERO;
		BigDecimal totalProductPoint = BigDecimal.ZERO;
		int rewardTypeId = 0;
		Integer programId = null;
		String icNumber = null;
		
		try {
			if(!CommonValidator.isEmptyStr(cardNum)) {
				icNumber = productRedemptionDao.getICNumFromDebitCardNum(cardNum);
				if (icNumber==null||icNumber.equals("")==true){
					icNumber = productRedemptionDao.getIcNumberByCardNum(cardNum);
				}
			}
			
			
			
			if (icNumber==null||icNumber.equals("")==true){
				res.setResponseCode("14");
				res.setResponseMessage("IC Number Not Found");
				return res;
			}
			
			TerminalConversionDTO terminalConversion = productRedemptionDao.getTerminalConversionInfoByTID(tid);
			
			if(terminalConversion==null) {
				res.setResponseCode("03");
				res.setResponseMessage("Terminal Not Found");
				return res;
			}
			merchantId = terminalConversion.getMerchant_id();
			
			programId = productRedemptionDao.getProgramIdByCardNum(cardNum);
			if(programId==null) {
				res.setResponseCode("14");
				res.setResponseMessage("Program Id Not Found");
				return res;
			}
			
			List<OrsProgramDTO>  programList= productRedemptionDao.getProgramList();
			
			if(programList==null||programList.size()==0) {
				res.setResponseCode("14");
				res.setResponseMessage("No available program list");
				return res;
			}
			
			for(OrsProgramDTO program:programList) {
				if(program.getProgramId()==programId) {
					rewardTypeId = program.getRewardTypeId();
				}
			}
			
			if(rewardTypeId==0) {
				res.setResponseCode("14");
				res.setResponseMessage("Reward Type ID Not Found");
				return res;
			}
			
			//Check reward type
			String rewardTypeCode = productRedemptionDao.getRewardCodeById(rewardTypeId);
			
			if(rewardTypeCode.equals(MBBORSConstant.REWARD_TYPE_CODE_TM)) {
				res.setResponseCode("14");
				res.setResponseMessage("Invalid Reward Type");
				return res;
			}
			
			
			//Get customer card bucket
			List<CardHolderBucketDetailDTO> redeemableCardList = ProductRedemptionUtil.getTerminalCardRedeemableBucketList(productRedemptionDao,icNumber,new BigDecimal(rewardTypeId),rewardTypeCode);
			if(redeemableCardList==null) {
				res.setResponseCode("14");
				res.setResponseMessage("Cannot found card");
				return res;
			}
			
			BigDecimal availableTotalPoint = ProductRedemptionUtil.totalAvailableRedeemPoint(redeemableCardList);
			
			List<CardHolderBucketDetailDTO> deductedPointBucketList = new ArrayList<CardHolderBucketDetailDTO>();
			

			totalProductPoint = rmValue.divide(terminalConversion.getConversion_rate(), 2, RoundingMode.FLOOR);
			
			if(availableTotalPoint.compareTo(BigDecimal.ZERO)==0) {
				res.setResponseCode("83");
				res.setResponseMessage("Total is ZERO");
				return res;
			}
			
			if(availableTotalPoint.compareTo(totalProductPoint)<0) {
				res.setResponseCode("84");
				res.setResponseMessage("Total available point not enough");
				return res;
			}
			
			if(terminalConversion.getMax_redeem_point().compareTo(totalProductPoint)<0) {
				res.setResponseCode("81");
				res.setResponseMessage("Total available point not enough");
				return res;
			}
			
			System.out.println("totalProductPoint : ".concat(totalProductPoint.toPlainString()));
			
			if(rewardTypeCode.equals(MBBORSConstant.REWARD_TYPE_CODE_TP)) {
				deductedPointBucketList = ProductRedemptionUtil.getDeductedPointBucket36List(new ArrayList<CardHolderBucketDetailDTO>(redeemableCardList)
					, totalProductPoint);
			}else {
				deductedPointBucketList = ProductRedemptionUtil.getDeductedPointBucket01List(new ArrayList<CardHolderBucketDetailDTO>(redeemableCardList)
						, totalProductPoint);
			}
			
			if(deductedPointBucketList==null) {
				res.setResponseCode("84");
				res.setResponseMessage("Bucket Point Not Enough");
				return res;
			}
			
			//Get Customer Details
			CardHolderDetailDTO customerDetails = productRedemptionDao.getCardHolderDetailsByIcNum(icNumber);
			if(customerDetails == null) {
				res.setResponseCode("01");
				res.setResponseMessage("Cannot found customer details");
				return res;
			}			
			
			System.out.println("rewardTypeCode = ".concat(rewardTypeCode));
			System.out.println("redeemableCardList = ".concat(Integer.toString(redeemableCardList.size())));
			System.out.println("deductedPointBucketList = ".concat(Integer.toString(deductedPointBucketList.size())));
			String orsOrderNum = ProductRedemptionUtil.insertTxnTerminal(productRedemptionDao, 
					redeemableCardList, deductedPointBucketList,
					customerDetails, totalProductPoint, 
					new BigDecimal(Integer.toString(rewardTypeId)), 
					rewardTypeCode,
					"",merchantId);
			
			DecimalFormat df = new DecimalFormat("000000000000");
			
			String approvalCode = productRedemptionDao.getApprovalCode();
//			private String totalNewPointBalPP;
			String totalNewPointBalPP = ProductRedemptionUtil.getTotalBalance12N(deductedPointBucketList,"PP");
//			private String totalPrevPointBalPP;
			String totalPrevPointBalPP = ProductRedemptionUtil.getTotalBalance12N(redeemableCardList,"PP");
//			private String totalPointRedeemedPP;
			String totalPointRedeemedPP = df.format(ProductRedemptionUtil.diffValue(new BigDecimal(totalNewPointBalPP), new BigDecimal(totalPrevPointBalPP)));
//			private String totalNewPointBalSP;
			String totalNewPointBalSP = ProductRedemptionUtil.getTotalBalance12N(deductedPointBucketList,"SP");
//			private String totalPrevPointBalSP;
			String totalPrevPointBalSP = ProductRedemptionUtil.getTotalBalance12N(redeemableCardList,"SP");
//			private String totalPointRedeemedSP;
			String totalPointRedeemedSP = df.format(ProductRedemptionUtil.diffValue(new BigDecimal(totalNewPointBalSP), new BigDecimal(totalPrevPointBalSP)));
//			private String totalNewPointBal;
			String totalNewPointBal = df.format(new BigDecimal(totalNewPointBalPP).add(new BigDecimal(totalNewPointBalSP)));
//			private String totalPrevPointBal;
			String totalPrevPointBal = df.format(new BigDecimal(totalPrevPointBalPP).add(new BigDecimal(totalPrevPointBalSP)));
//			private String totalPointRedeemed;
			String totalPointRedeemed = df.format(new BigDecimal(totalPointRedeemedPP).add(new BigDecimal(totalPointRedeemedSP)));
//			private String totalPayAmount;
			String totalPayAmount = df.format(BigDecimal.ZERO);
//			private String pointsNeededPerGiftCode;
			String pointsNeededPerGiftCode = df.format(BigDecimal.ZERO);
//			private String quantity;
			String quantity = "00";
//			private String payAmountPerGiftCode;
			String payAmountPerGiftCode = df.format(BigDecimal.ZERO);
			
			
			res.setResponseCode(MBBORSConstant.RES_CODE_SUCCESS);
			res.setResponseMessage(MBBORSConstant.RES_DESC_SUCCESS);
//			private String retrievalReferenceNumber;
			res.setRetrievalReferenceNumber(orsOrderNum);
//			private String approvalCode;
			res.setApprovalCode(approvalCode);
//			private String totalNewPointBalPP;
			res.setTotalNewPointBalPP(totalNewPointBalPP);
//			private String totalPrevPointBalPP;
			res.setTotalPrevPointBalPP(totalPrevPointBalPP);
//			private String totalPointRedeemedPP;
			res.setTotalPointRedeemedPP(totalPointRedeemedPP);
//			private String totalNewPointBalSP;
			res.setTotalNewPointBalSP(totalNewPointBalSP);
//			private String totalPrevPointBalSP;
			res.setTotalPrevPointBalSP(totalPrevPointBalSP);
//			private String totalPointRedeemedSP;
			res.setTotalPointRedeemedSP(totalPointRedeemedSP);
//			private String totalNewPointBal;
			res.setTotalNewPointBal(totalNewPointBal);
//			private String totalPrevPointBal;
			res.setTotalPrevPointBal(totalPrevPointBal);
//			private String totalPointRedeemed;
			res.setTotalPointRedeemed(totalPointRedeemed);
//			private String totalPayAmount;
			res.setTotalPayAmount(totalPayAmount);
//			private String pointsNeededPerGiftCode;
			res.setPointsNeededPerGiftCode(pointsNeededPerGiftCode);
//			private String quantity;
			res.setQuantity(quantity);
//			private String payAmountPerGiftCode;
			res.setPayAmountPerGiftCode(payAmountPerGiftCode);
			
		}catch(Exception ex) {
			ex.printStackTrace();
			res.setResponseCode("96");
			res.setResponseMessage(MBBORSConstant.RES_DESC_SYSTEM_ERROR);
		}
		
		return res;
	}
	
	public ValidateAirlineRedeemProductResponse validateAirlineRedeemProduct(ValidateAirlineRedeemProductRequest validateAirlineRedeemProductRequest){
		ValidateAirlineRedeemProductResponse validateAirlineRedeemProductResponse = new ValidateAirlineRedeemProductResponse();
		try {
			// check mandatory field
			if(!StringUtils.isEmpty(validateAirlineRedeemProductRequest.getRewardTypeID())
			&& !StringUtils.isEmpty(validateAirlineRedeemProductRequest.getIcNumber())		
			&& !StringUtils.isEmpty(validateAirlineRedeemProductRequest.getProductID())){
				validateAirlineRedeemProductResponse = productRedemptionDao.validateAirlineRedeemProduct(validateAirlineRedeemProductRequest);
			}else {
				validateAirlineRedeemProductResponse.setResponseCode("97");
				validateAirlineRedeemProductResponse.setResponseMessage("Missing Mandatory Field");
			}
		}catch(EmptyResultDataAccessException e) {
			validateAirlineRedeemProductResponse.setResponseCode("98");
			validateAirlineRedeemProductResponse.setResponseMessage("EmptyResultDataAccessException");
		}catch(Exception e) {
			StringWriter trace = new StringWriter();
			e.printStackTrace(new PrintWriter(trace));
			System.out.println(trace);
			validateAirlineRedeemProductResponse.setResponseCode("99");
			validateAirlineRedeemProductResponse.setResponseMessage("System Error");
		}
		
		return validateAirlineRedeemProductResponse;
	}
}
