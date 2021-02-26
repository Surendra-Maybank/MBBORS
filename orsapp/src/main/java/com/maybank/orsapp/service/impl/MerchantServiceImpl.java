package com.maybank.orsapp.service.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maybank.orsapp.constant.MBBORSConstant;
import com.maybank.orsapp.controller.request.EditMerchantInfoMerchantReq;
import com.maybank.orsapp.controller.request.EditMerchantInfoTerminalReq;
import com.maybank.orsapp.controller.request.InsertNewMerchantTidReq;
import com.maybank.orsapp.controller.request.MBBORSEditMerchantReq;
import com.maybank.orsapp.controller.request.MBBORSInsertNewMerchantReq;
import com.maybank.orsapp.controller.requestval.MBBORSEditMerchantReqVal;
import com.maybank.orsapp.controller.requestval.MBBORSInsertNewMerchantReqVal;
import com.maybank.orsapp.controller.response.MBBORSDeleteMerchantRes;
import com.maybank.orsapp.controller.response.MBBORSEditMerchantRes;
import com.maybank.orsapp.controller.response.MBBORSGetAllMerchantRes;
import com.maybank.orsapp.controller.response.MBBORSGetMerchantDetailByMidRes;
import com.maybank.orsapp.controller.response.MBBORSGetMerchantInfoByMidRes;
import com.maybank.orsapp.controller.response.MBBORSInsertNewMerchantRes;
import com.maybank.orsapp.dto.MerchantAllDTO;
import com.maybank.orsapp.dto.MerchantDetailDTO;
import com.maybank.orsapp.dto.TerminalDTO;
import com.maybank.orsapp.entities.Merchant;
import com.maybank.orsapp.entities.Terminal;
import com.maybank.orsapp.extapi.sdk.mmp.GetMechantInfoRes;
import com.maybank.orsapp.extapi.sdk.mmp.MMPAPIService;
import com.maybank.orsapp.extapi.sdk.mmp.MMPGetMechantInfoRes;
import com.maybank.orsapp.repository.MerchantRepository;
import com.maybank.orsapp.repository.TerminalRepository;
import com.maybank.orsapp.service.MerchantService;

@Service
public class MerchantServiceImpl implements MerchantService {
	
	@Autowired
	MerchantRepository merchantRepository;
	
	@Autowired
	TerminalRepository terminalRepository;
	
	@Autowired
	MMPAPIService mmpAPIService;
	
	 public MBBORSGetMerchantInfoByMidRes getMMPMerchantDetails(String mid) {
		 MBBORSGetMerchantInfoByMidRes res = new MBBORSGetMerchantInfoByMidRes();
		 List<String> orsTerminalList = null;
		 
		 try {
			 
			 //Get Merchant info from MMP API
			 MMPGetMechantInfoRes extRes = mmpAPIService.getMBBMechantInfo(mid);
			 
			 System.out.println("extRes : ".concat(extRes.getBody().getResponseCode()));
			 
			 //Get Ors Db Terminal
			 
			 
			 BigDecimal merchantId = merchantRepository.getMerchantIdByMid(mid);
			  
			 if(merchantId.compareTo(BigDecimal.ZERO)>0) {
				 res.setResponseCode("01");
				 res.setResponseMessage("MERCHANT_EXIST");
				 return res;
			 }
			 
			 if(extRes!= null&&extRes.getBody()!=null&&extRes.getBody().getResponseCode().equals("0")) {
				 res.setResponseCode(MBBORSConstant.RES_CODE_SUCCESS);
				 res.setResponseMessage(MBBORSConstant.RES_DESC_SUCCESS);
				 //##Test
				 List<String> resultTerminal = extRes.getBody().getTIDsList().stream()
						 .map(e -> e.getTid()).collect(Collectors.toList());
				 
				 orsTerminalList = terminalRepository.getTerminalListByTids(resultTerminal);
				 	 
				 GetMechantInfoRes merchantInfo = extRes.getBody().getORSMerchantInfo();
				 resultTerminal.removeAll(orsTerminalList);
				 
				 res.setMerchantName(merchantInfo.getMerchantName());
				 res.setMerchantNo(merchantInfo.getMerchantNo());
				 res.setStoreName(merchantInfo.getStoreName());
				 res.setStoreNo(merchantInfo.getStoreNo());
				 res.setTeminalList(resultTerminal.toArray(new String[resultTerminal.size()]));
			 }else if(extRes!= null&&extRes.getBody()!=null
					 &&extRes.getBody().getResponseCode().equals("1")
					 &&extRes.getBody().getResponseDescription()!=null){
				 res.setResponseCode("01");
				 res.setResponseMessage("MMP ERROR : ".concat(extRes.getBody().getResponseDescription()));
		 	 }else{
				 res.setResponseCode("01");
				 res.setResponseMessage("MMP_SYSTEM_ERROR");
				 return res;
			 }
			 
		 }catch(Exception ex) {
			 res.setResponseCode(MBBORSConstant.RES_CODE_SYSTEM_ERROR);
			 res.setResponseMessage(MBBORSConstant.RES_DESC_SYSTEM_ERROR);
			 ex.printStackTrace();
		 }
		 
		 return res;
	 }
	
	@Override
    public MBBORSGetAllMerchantRes getAllMerchant() {		
		
		MBBORSGetAllMerchantRes res = new MBBORSGetAllMerchantRes();
		
		try {
			List<MerchantAllDTO> merchantList = merchantRepository.getAllMerchant();
			if(merchantList.size()>0) {
				res.setResponseCode(MBBORSConstant.RES_CODE_SUCCESS);
				res.setResponseMessage(MBBORSConstant.RES_DESC_SUCCESS);
				res.setMerchantList(merchantList);
			}else {
				res.setResponseCode("01");
				res.setResponseMessage("Empty Merchant List");
			}

		}catch(Exception ex) {
			res.setResponseCode(MBBORSConstant.RES_CODE_SYSTEM_ERROR);
			res.setResponseMessage(MBBORSConstant.RES_DESC_SYSTEM_ERROR);
			ex.printStackTrace();
		}
		
        return res;
    }
	
	@Override
    public MBBORSGetMerchantDetailByMidRes getMerchantDetailByMerchantId(BigDecimal merchantId) {
		
		MBBORSGetMerchantDetailByMidRes res = new MBBORSGetMerchantDetailByMidRes();
		
		try {
			MerchantDetailDTO merchantDetail = merchantRepository.getMerchantDetailByMerchantId(merchantId);
				
			List<TerminalDTO> terminalIdList = terminalRepository.getTerminalListByMerchantId(merchantId);
			if(merchantDetail != null) {
				res.setResponseCode(MBBORSConstant.RES_CODE_SUCCESS);
				res.setResponseMessage(MBBORSConstant.RES_DESC_SUCCESS);
				
				res.setMerchant_id(merchantDetail.getMerchant_id().toPlainString());
				res.setMid(merchantDetail.getMid());											
				res.setMerchant_name(merchantDetail.getMerchant_name());
				res.setStore_no(merchantDetail.getStore_no());
				res.setStore_name(merchantDetail.getStore_name());
				res.setTier_rate_id(merchantDetail.getTier_rate_id());
				res.setTier_rate_code(merchantDetail.getTier_rate_code());
				res.setConversion_rate(merchantDetail.getConversion_rate());
				res.setTier_rate_desc(merchantDetail.getTier_rate_desc());
				res.setIs_auto_payment(merchantDetail.getIs_auto_payment());
				res.setGlobal_max_redeem_point(merchantDetail.getGlobal_max_redeem_point());	
				res.setGlobal_instant_reward_percentage(merchantDetail.getGlobal_instant_reward_percentage());	
				res.setGlobal_receipt_hdr_1(merchantDetail.getGlobal_receipt_hdr_1());
				res.setGlobal_receipt_hdr_2(merchantDetail.getGlobal_receipt_hdr_2());
				res.setGlobal_receipt_hdr_3(merchantDetail.getGlobal_receipt_hdr_3());
				res.setGlobal_receipt_ftr_1(merchantDetail.getGlobal_receipt_ftr_1()); 
				res.setGlobal_receipt_ftr_2(merchantDetail.getGlobal_receipt_ftr_2()); 
				res.setGlobal_receipt_ftr_3(merchantDetail.getGlobal_receipt_ftr_3()); 
				res.setGlobal_is_point_inquiry(merchantDetail.getGlobal_is_point_inquiry());
				res.setGlobal_is_instant_reward(merchantDetail.getGlobal_is_instant_reward()); 
				res.setGlobal_is_point_redemption(merchantDetail.getGlobal_is_point_redemption());
				res.setGlobal_is_value_redemption(merchantDetail.getGlobal_is_value_redemption());
				res.setGlobal_is_gift_code_redemption(merchantDetail.getGlobal_is_gift_code_redemption());
				res.setGlobal_is_hot_deal_redemption(merchantDetail.getGlobal_is_hot_deal_redemption());
				res.setGlobal_is_void_redemption(merchantDetail.getGlobal_is_void_redemption());  
				res.setGlobal_is_encryption(merchantDetail.getGlobal_is_encryption());
				res.setStatus_desc(merchantDetail.getStatus_desc());
				res.setCreated_by(merchantDetail.getCreated_by());
				res.setCreated_datetime(merchantDetail.getCreated_datetime());
				res.setEdited_by(merchantDetail.getEdited_by());
				res.setEdited_datetime(merchantDetail.getEdited_datetime());
				res.setTerminalId(terminalIdList);
			}else {
				res.setResponseCode("01");
				res.setResponseMessage("MERCHANT_NOT_FOUND");
			}
		}catch(Exception ex) {
			res.setResponseCode(MBBORSConstant.RES_CODE_SYSTEM_ERROR);
			res.setResponseMessage(MBBORSConstant.RES_DESC_SYSTEM_ERROR);
			ex.printStackTrace();
		}
				
        return res;
    }
	
	@Override
	public MBBORSInsertNewMerchantRes insertNewMerchant(MBBORSInsertNewMerchantReq request) {
		
		MBBORSInsertNewMerchantRes res = new MBBORSInsertNewMerchantRes();		
		
		String result = MBBORSInsertNewMerchantReqVal.validate(request);
		
		System.out.println("VALIDATE RESULT : ".concat(result));
		
		if (result.equals("")==false){
			res.setResponseCode("01");
			res.setResponseMessage(result);
			return res;
		}
		
		String mid = request.getMid();
		String merchantName = request.getMerchant_name();
		String storeNo = request.getStore_no();
		String storeName = request.getStore_name();
		int tierRateId = Integer.valueOf(request.getTier_rate_id());
		
		BigDecimal conversionRate = new BigDecimal(request.getConversion_rate());
		boolean isAutoPayment = request.getIs_auto_payment().equals("Y")?true:false;
		BigDecimal maxRedeemPoint = new BigDecimal(request.getGlobal_max_redeem_point());
		BigDecimal instantRewardPercentage = new BigDecimal(request.getGlobal_instant_reward_percentage());
		
		String header1 = request.getGlobal_receipt_hdr_1();
		String header2 = request.getGlobal_receipt_hdr_2();
		String header3 = request.getGlobal_receipt_hdr_3();
		
		String footer1 = request.getGlobal_receipt_ftr_1();
		String footer2 = request.getGlobal_receipt_ftr_2();
		String footer3 = request.getGlobal_receipt_ftr_3();
		
		boolean isPointInquiry = request.getGlobal_is_point_inquiry().equals("Y")?true:false;
		boolean isInstantReward = request.getGlobal_is_instant_reward().equals("Y")?true:false;
		boolean isPointRedemption = request.getGlobal_is_point_redemption().equals("Y")?true:false;
		boolean isValueRedemption = request.getGlobal_is_value_redemption().equals("Y")?true:false;	
		
		boolean isGiftCodeRedemption = 	request.getGlobal_is_gift_code_redemption().equals("Y")?true:false;
		boolean isHotDealRedemption = request.getGlobal_is_hot_deal_redemption().equals("Y")?true:false;
		boolean isVoidRedemption = request.getGlobal_is_void_redemption().equals("Y")?true:false;
		boolean isEncryption = request.getGlobal_is_encryption().equals("Y")?true:false;
		
		Timestamp now = new Timestamp(System.currentTimeMillis());
		
        Merchant merchantEntity = new Merchant();
        merchantEntity.setMid(mid);
        merchantEntity.setMerchant_name(merchantName);
        merchantEntity.setStore_no(storeNo);
        merchantEntity.setStore_name(storeName);
        merchantEntity.setTier_rate_id(tierRateId);
        
        merchantEntity.setConversion_rate(conversionRate);
        merchantEntity.setIs_auto_payment(isAutoPayment);
        merchantEntity.setGlobal_max_redeem_point(maxRedeemPoint);
        merchantEntity.setGlobal_instant_reward_percentage(instantRewardPercentage);
        
        merchantEntity.setGlobal_receipt_hdr_1(header1);
        merchantEntity.setGlobal_receipt_hdr_2(header2);
        merchantEntity.setGlobal_receipt_hdr_3(header3);
        
        merchantEntity.setGlobal_receipt_ftr_1(footer1);
        merchantEntity.setGlobal_receipt_ftr_2(footer2);
        merchantEntity.setGlobal_receipt_ftr_3(footer3);
        
        merchantEntity.setGlobal_is_point_inquiry(isPointInquiry);
        merchantEntity.setGlobal_is_instant_reward(isInstantReward);
        merchantEntity.setGlobal_is_point_redemption(isPointRedemption);
        merchantEntity.setGlobal_is_value_redemption(isValueRedemption);
        
        merchantEntity.setGlobal_is_gift_code_redemption(isGiftCodeRedemption);
        merchantEntity.setGlobal_is_hot_deal_redemption(isHotDealRedemption);
        merchantEntity.setGlobal_is_void_redemption(isVoidRedemption);
        merchantEntity.setGlobal_is_encryption(isEncryption);
        
        merchantEntity.setStatus_id(MBBORSConstant.DB_STATUS_ACTIVE);
        merchantEntity.setCreated_by(MBBORSConstant.USER_SYSTEM);
        merchantEntity.setCreated_datetime(now);
        merchantEntity.setEdited_by(MBBORSConstant.USER_SYSTEM);
        merchantEntity.setEdited_datetime(now);
		
		try {
			Merchant resultObj = merchantRepository.save(merchantEntity);
			
			List<InsertNewMerchantTidReq> tidS= request.getTid();
			
			for(InsertNewMerchantTidReq tid : tidS) {
				Terminal terminal = new Terminal();
				
	
				terminal.setTid(tid.getTid());	
				terminal.setMerchant_id(resultObj.getMerchant_id());
				terminal.setTier_rate_id(tierRateId);
				terminal.setConversion_rate(conversionRate);
				terminal.setIs_inherit(true);
				
				terminal.setMax_redeem_point(maxRedeemPoint);
				terminal.setInstant_reward_percentage(instantRewardPercentage);

	
				terminal.setReceipt_hdr_1(header1);
				terminal.setReceipt_hdr_2(header2);
				terminal.setReceipt_hdr_3(header3);

				terminal.setReceipt_ftr_1(footer1);
				terminal.setReceipt_ftr_2(footer2);
				terminal.setReceipt_ftr_3(footer3);
				
				terminal.setIs_point_inquiry(isPointInquiry);
				terminal.setIs_instant_reward(isInstantReward);
				terminal.setIs_point_redemption(isPointRedemption);
				terminal.setIs_value_redemption(isValueRedemption);
				
				terminal.setIs_gift_code_redemption(isGiftCodeRedemption);
				terminal.setIs_hot_deal_redemption(isHotDealRedemption);
				terminal.setIs_void_redemption(isVoidRedemption);
				terminal.setIs_encryption(isEncryption);
				
				terminal.setStatus_id(MBBORSConstant.DB_STATUS_ACTIVE);
				terminal.setCreated_by(MBBORSConstant.USER_SYSTEM);
				terminal.setCreated_datetime(now);
				terminal.setEdited_by(MBBORSConstant.USER_SYSTEM);
				terminal.setEdited_datetime(now);
				
				terminalRepository.save(terminal);
			}
			
			res.setResponseCode(MBBORSConstant.RES_CODE_SUCCESS);
			res.setResponseMessage(MBBORSConstant.RES_DESC_SUCCESS);
			
		}catch(Exception ex) {
			res.setResponseCode(MBBORSConstant.RES_CODE_SYSTEM_ERROR);
			res.setResponseMessage(MBBORSConstant.RES_DESC_SYSTEM_ERROR);
			ex.printStackTrace();
		}
		
		return res;
	}
	
	@Override
	@Transactional
	public MBBORSEditMerchantRes editMerchant(MBBORSEditMerchantReq request) {

		MBBORSEditMerchantRes res = new MBBORSEditMerchantRes();	
		
		String result = MBBORSEditMerchantReqVal.validate(request);
		
		System.out.println("VALIDATE RESULT : ".concat(result));
		
		if (result.equals("")==false){
			res.setResponseCode("01");
			res.setResponseMessage(result);
			return res;
		}
		
		EditMerchantInfoMerchantReq merchantReq =request.getMerchant();
		EditMerchantInfoTerminalReq terminalReq =request.getTerminal();
		
		BigDecimal merchandId = new BigDecimal(merchantReq.getMerchant_id());
		int tierRateId = Integer.valueOf(merchantReq.getTier_rate_id());
		
		BigDecimal conversionRate = new BigDecimal(merchantReq.getGlobal_conversion_rate());
		boolean isAutoPayment = merchantReq.getIs_auto_payment().equals("Y")?true:false;
		BigDecimal maxRedeemPoint = new BigDecimal(merchantReq.getGlobal_max_redeem_point());
		BigDecimal instantRewardPercentage = new BigDecimal(merchantReq.getGlobal_instant_reward_percentage());
		
		String header1 = merchantReq.getGlobal_receipt_hdr_1();
		String header2 = merchantReq.getGlobal_receipt_hdr_2();
		String header3 = merchantReq.getGlobal_receipt_hdr_3();
		
		String footer1 = merchantReq.getGlobal_receipt_ftr_1();
		String footer2 = merchantReq.getGlobal_receipt_ftr_2();
		String footer3 = merchantReq.getGlobal_receipt_ftr_3();
		
		boolean isPointInquiry = merchantReq.getGlobal_is_point_inquiry().equals("Y")?true:false;
		boolean isInstantReward = merchantReq.getGlobal_is_instant_reward().equals("Y")?true:false;
		boolean isPointRedemption = merchantReq.getGlobal_is_point_redemption().equals("Y")?true:false;
		boolean isValueRedemption = merchantReq.getGlobal_is_value_redemption().equals("Y")?true:false;	
		
		boolean isGiftCodeRedemption = 	merchantReq.getGlobal_is_gift_code_redemption().equals("Y")?true:false;
		boolean isHotDealRedemption = merchantReq.getGlobal_is_hot_deal_redemption().equals("Y")?true:false;
		boolean isVoidRedemption = merchantReq.getGlobal_is_void_redemption().equals("Y")?true:false;
		boolean isEncryption = merchantReq.getGlobal_is_encryption().equals("Y")?true:false;
		
		Timestamp now = new Timestamp(System.currentTimeMillis());
		
		
        Merchant merchantEdit = new Merchant();
        merchantEdit.setMerchant_id(merchandId);
        merchantEdit.setTier_rate_id(tierRateId);
        merchantEdit.setConversion_rate(conversionRate);
        
        merchantEdit.setIs_auto_payment(isAutoPayment);
        merchantEdit.setGlobal_max_redeem_point(maxRedeemPoint);
        merchantEdit.setGlobal_instant_reward_percentage(instantRewardPercentage);

        merchantEdit.setGlobal_receipt_hdr_1(header1);
        merchantEdit.setGlobal_receipt_hdr_2(header2);
        merchantEdit.setGlobal_receipt_hdr_3(header3);
        merchantEdit.setGlobal_receipt_ftr_1(footer1);
        merchantEdit.setGlobal_receipt_ftr_2(footer2);
        merchantEdit.setGlobal_receipt_ftr_3(footer3);

        merchantEdit.setGlobal_is_point_inquiry(isPointInquiry);
        merchantEdit.setGlobal_is_instant_reward(isInstantReward);
        merchantEdit.setGlobal_is_point_redemption(isPointRedemption);
        merchantEdit.setGlobal_is_value_redemption(isValueRedemption);
        merchantEdit.setGlobal_is_gift_code_redemption(isGiftCodeRedemption);
        merchantEdit.setGlobal_is_hot_deal_redemption(isHotDealRedemption);
        merchantEdit.setGlobal_is_void_redemption(isVoidRedemption);
        merchantEdit.setGlobal_is_encryption(isEncryption);
        
        merchantEdit.setCreated_by(MBBORSConstant.USER_SYSTEM);
        merchantEdit.setCreated_datetime(now);
        merchantEdit.setEdited_by(MBBORSConstant.USER_SYSTEM);
        merchantEdit.setEdited_datetime(now);
		
		try {
			
			BigDecimal terminalId = new BigDecimal(terminalReq.getTerminal_id());
			int terTierRateId = Integer.valueOf(terminalReq.getTier_rate_id());
			boolean terIsInherit = terminalReq.getIs_inherit().equals("Y")?true:false;
			BigDecimal terConversionRate = new BigDecimal(terminalReq.getConversion_rate());
			BigDecimal terMaxRedeemPoint = new BigDecimal(terminalReq.getMax_redeem_point());
			BigDecimal terInstantRewardPercentage = new BigDecimal(terminalReq.getInstant_reward_percentage());
			
			String terHeader1 = terminalReq.getReceipt_hdr_1();
			String terHeader2 = terminalReq.getReceipt_hdr_2();
			String terHeader3 = terminalReq.getReceipt_hdr_3();
			
			String terFooter1 = terminalReq.getReceipt_ftr_1();
			String terFooter2 = terminalReq.getReceipt_ftr_2();
			String terFooter3 = terminalReq.getReceipt_ftr_3();
			
			boolean terIsPointInquiry = terminalReq.getIs_point_inquiry().equals("Y")?true:false;
			boolean terIsInstantReward = terminalReq.getIs_instant_reward().equals("Y")?true:false;
			boolean terIsPointRedemption = terminalReq.getIs_point_redemption().equals("Y")?true:false;
			boolean terIsValueRedemption = terminalReq.getIs_value_redemption().equals("Y")?true:false;	
			
			boolean terIsGiftCodeRedemption = 	terminalReq.getIs_gift_code_redemption().equals("Y")?true:false;
			boolean terIsHotDealRedemption = terminalReq.getIs_hot_deal_redemption().equals("Y")?true:false;
			boolean terIsVoidRedemption = terminalReq.getIs_void_redemption().equals("Y")?true:false;
			boolean terIsEncryption = terminalReq.getIs_encryption().equals("Y")?true:false;	
			
				Terminal terminalEdit = new Terminal();
				terminalEdit.setTerminal_id(terminalId);
				terminalEdit.setMax_redeem_point(terMaxRedeemPoint);
//		
				terminalEdit.setInstant_reward_percentage(terInstantRewardPercentage);
				terminalEdit.setConversion_rate(terConversionRate);
				terminalEdit.setTier_rate_id(terTierRateId);
				terminalEdit.setIs_inherit(terIsInherit);

				terminalEdit.setReceipt_hdr_1(terHeader1);
				terminalEdit.setReceipt_hdr_2(terHeader2);
				terminalEdit.setReceipt_hdr_3(terHeader3);

				terminalEdit.setReceipt_ftr_1(terFooter1);
				terminalEdit.setReceipt_ftr_2(terFooter2);
				terminalEdit.setReceipt_ftr_3(terFooter3);		
				
				terminalEdit.setIs_point_inquiry(terIsPointInquiry);
				terminalEdit.setIs_instant_reward(terIsInstantReward);
				terminalEdit.setIs_point_redemption(terIsPointRedemption);
				terminalEdit.setIs_value_redemption(terIsValueRedemption);
				terminalEdit.setIs_gift_code_redemption(terIsGiftCodeRedemption);
				terminalEdit.setIs_hot_deal_redemption(terIsHotDealRedemption);
				terminalEdit.setIs_void_redemption(terIsVoidRedemption);
				terminalEdit.setIs_encryption(terIsEncryption);

				terminalEdit.setStatus_id(1);

				terminalEdit.setCreated_by(MBBORSConstant.USER_SYSTEM);

				terminalEdit.setCreated_datetime(now);
				terminalEdit.setEdited_by(MBBORSConstant.USER_SYSTEM);
				terminalEdit.setCreated_datetime(now);
				
				Optional<Terminal> terminalOpt = terminalRepository.findById(terminalId);
				
				Optional<Merchant> merchantOpt = merchantRepository.findById(merchandId);
				
				Terminal terminalDB = null;
				Merchant merchantDB = null;
				
				if(terminalOpt.isPresent()) {
					terminalDB = terminalOpt.get();
				}else {
					res.setResponseCode("01");
					res.setResponseMessage("TERMINAL_NOT_FOUND");
					return res;
				}
				
				if(merchantOpt.isPresent()) {
					merchantDB = merchantOpt.get();
				}else {
					res.setResponseCode("01");
					res.setResponseMessage("MERCHANT_NOT_FOUND");
					return res;
				}
				
//				System.out.println("terminalDB:".concat(terminalDB.getReceipt_hdr_1()));
//				System.out.println("merchantDB:".concat(merchantDB.getGlobal_receipt_hdr_1()));
//				
//				System.out.println("terminalEdit TID:".concat(terminalEdit.getTerminal_id().toPlainString()));
//				System.out.println("terminalEdit:".concat(terminalEdit.getReceipt_hdr_1()));
//				System.out.println("merchantEdit:".concat(merchantEdit.getGlobal_receipt_hdr_1()));
				
				boolean isSameTerminal = isSameTerminal(terminalEdit, terminalDB);

				boolean isSameMerchant = isSameMerchant(merchantEdit, merchantDB);
			
				
				if(isSameTerminal==false) {
					System.out.println("IN: 1");
					terminalRepository.updateTerminalByTid(terminalEdit, "SYSTEM");
				}
			
				if(isSameMerchant==false) {
					System.out.println("IN: 2");
					merchantRepository.updateMerchantByMerchantId(merchantEdit, "SYSTEM");
					System.out.println("IN: 3");
					terminalRepository.updateGlobalTerminalByMid(merchantEdit, "SYSTEM");
				}
			
			res.setResponseCode(MBBORSConstant.RES_CODE_SUCCESS);
			res.setResponseMessage(MBBORSConstant.RES_DESC_SUCCESS);
			
		}catch(Exception ex) {
			res.setResponseCode(MBBORSConstant.RES_CODE_SYSTEM_ERROR);
			res.setResponseMessage(MBBORSConstant.RES_DESC_SYSTEM_ERROR);
			ex.printStackTrace();
		}
		
		return res;
	}
	
	@Transactional
	public MBBORSDeleteMerchantRes deleteMerchant(BigDecimal merchantId, String username) {
		MBBORSDeleteMerchantRes res = new MBBORSDeleteMerchantRes();
		int resultMerchant = 0;
		
		try {
			terminalRepository.deleteTerminalByMerchantId(merchantId, username);	
			resultMerchant = merchantRepository.deleteMerchantByMerchantId(merchantId, username);
			
			res.setResponseCode(MBBORSConstant.RES_CODE_SUCCESS);
			res.setResponseMessage(MBBORSConstant.RES_DESC_SUCCESS);
		}catch (Exception e) {
			// TODO: handle exception
			res.setResponseCode(MBBORSConstant.RES_CODE_SYSTEM_ERROR);
			res.setResponseMessage(MBBORSConstant.RES_DESC_SYSTEM_ERROR);
			e.printStackTrace();
		}
		
		return res;
	}
	
	public static boolean isSameMerchant(Merchant merchant1, Merchant merchant2) {
		
		boolean  result = true;
		
		System.out.println("isSameMerchant");
		
		if(merchant1.getTier_rate_id()!=merchant2.getTier_rate_id()) {
			System.out.println("getTier_rate_id : ".concat(Integer.toString(merchant1.getTier_rate_id())).concat(":").concat(Integer.toString(merchant2.getTier_rate_id())));
			return false;
		}else if(merchant1.getConversion_rate().compareTo(merchant2.getConversion_rate())!=0) {
			System.out.println("getConversion_rate : ".concat(merchant1.getConversion_rate().toPlainString()).concat(":").concat(merchant2.getConversion_rate().toPlainString()));
		
			return false;
		}else if(merchant1.isIs_auto_payment()!=merchant2.isIs_auto_payment()) {
			System.out.println("isIs_auto_payment : ".concat(Boolean.toString(merchant1.isIs_auto_payment())).concat(":").concat(Boolean.toString(merchant2.isIs_auto_payment())));
			
			return false;
		}else if(merchant1.getGlobal_max_redeem_point().compareTo(merchant2.getGlobal_max_redeem_point())!=0) {
			System.out.println("getGlobal_max_redeem_point : ".concat(merchant1.getGlobal_max_redeem_point().toPlainString()).concat(":").concat(merchant2.getGlobal_max_redeem_point().toPlainString()));
						
			return false;
		}else if(merchant1.getGlobal_instant_reward_percentage().compareTo(merchant2.getGlobal_instant_reward_percentage())!=0) {
			System.out.println("getGlobal_instant_reward_percentage : ".concat(merchant1.getGlobal_instant_reward_percentage().toPlainString()).concat(":").concat(merchant2.getGlobal_instant_reward_percentage().toPlainString()));
			
			return false;
		}else if((merchant1.getGlobal_receipt_hdr_1()==null?"":merchant1.getGlobal_receipt_hdr_1())
				.equals(merchant2.getGlobal_receipt_hdr_1())==false){
			System.out.println("getGlobal_receipt_hdr_1 : ".concat(merchant1.getGlobal_receipt_hdr_1()).concat(":").concat(merchant2.getGlobal_receipt_hdr_1()));
			
			return false;
		}else if((merchant1.getGlobal_receipt_hdr_2()==null?"":merchant1.getGlobal_receipt_hdr_2())
			.equals(merchant2.getGlobal_receipt_hdr_2())==false){
			System.out.println("getGlobal_receipt_hdr_2 : ".concat(merchant1.getGlobal_receipt_hdr_2()).concat(":").concat(merchant2.getGlobal_receipt_hdr_2()));
			return false;
		}else if((merchant1.getGlobal_receipt_hdr_3()==null?"":merchant1.getGlobal_receipt_hdr_3())
			.equals((merchant2.getGlobal_receipt_hdr_3()==null?"":merchant1.getGlobal_receipt_hdr_3()))==false){
			System.out.println("getGlobal_receipt_hdr_3 : ".concat(merchant1.getGlobal_receipt_hdr_3()).concat(":").concat(merchant2.getGlobal_receipt_hdr_3()));
			return false;
		}else if((merchant1.getGlobal_receipt_ftr_1()==null?"":merchant1.getGlobal_receipt_ftr_1())
			.equals((merchant2.getGlobal_receipt_ftr_1()==null?"":merchant1.getGlobal_receipt_ftr_1()))==false){
			System.out.println("getGlobal_receipt_ftr_1 : ".concat(merchant1.getGlobal_receipt_ftr_1()).concat(":").concat(merchant2.getGlobal_receipt_ftr_1()));
			return false;
		}else if((merchant1.getGlobal_receipt_ftr_2()==null?"":merchant1.getGlobal_receipt_ftr_2())
			.equals((merchant2.getGlobal_receipt_ftr_2()==null?"":merchant1.getGlobal_receipt_ftr_2()))==false){
			System.out.println("getGlobal_receipt_ftr_2 : ".concat(merchant1.getGlobal_receipt_ftr_2()).concat(":").concat(merchant2.getGlobal_receipt_ftr_2()));
			return false;
		}else if((merchant1.getGlobal_receipt_ftr_3()==null?"":merchant1.getGlobal_receipt_ftr_3())
			.equals((merchant2.getGlobal_receipt_ftr_3()==null?"":merchant1.getGlobal_receipt_ftr_3()))==false){
			System.out.println("getGlobal_receipt_ftr_3 : ".concat(merchant1.getGlobal_receipt_ftr_3()).concat(":").concat(merchant2.getGlobal_receipt_ftr_3()));
			return false;
		}else if(merchant1.isGlobal_is_point_inquiry()!=merchant2.isGlobal_is_point_inquiry()){
			System.out.println("isGlobal_is_point_inquiry : ".concat(Boolean.toString(merchant1.isGlobal_is_point_inquiry())).concat(":").concat(Boolean.toString(merchant2.isGlobal_is_point_inquiry())));
			return false;
		}else if(merchant1.isGlobal_is_instant_reward()!=merchant2.isGlobal_is_instant_reward()){
			System.out.println("isGlobal_is_instant_reward : ".concat(Boolean.toString(merchant1.isGlobal_is_instant_reward())).concat(":").concat(Boolean.toString(merchant2.isGlobal_is_instant_reward())));
			return false;
		}else if(merchant1.isGlobal_is_point_redemption()!=merchant2.isGlobal_is_point_redemption()){
			System.out.println("isGlobal_is_point_redemption : ".concat(Boolean.toString(merchant1.isGlobal_is_point_redemption())).concat(":").concat(Boolean.toString(merchant2.isGlobal_is_point_redemption())));
			return false;
		}else if(merchant1.isGlobal_is_value_redemption()!=merchant2.isGlobal_is_value_redemption()){	
			System.out.println("isGlobal_is_value_redemption : ".concat(Boolean.toString(merchant1.isGlobal_is_value_redemption())).concat(":").concat(Boolean.toString(merchant2.isGlobal_is_value_redemption())));
			return false;
		}else if(merchant1.isGlobal_is_gift_code_redemption()!=merchant2.isGlobal_is_gift_code_redemption()){
			System.out.println("isGlobal_is_gift_code_redemption : ".concat(Boolean.toString(merchant1.isGlobal_is_gift_code_redemption())).concat(":").concat(Boolean.toString(merchant2.isGlobal_is_gift_code_redemption())));
			return false;
		}else if(merchant1.isGlobal_is_hot_deal_redemption()!=merchant2.isGlobal_is_hot_deal_redemption()){	
			System.out.println("isGlobal_is_hot_deal_redemption : ".concat(Boolean.toString(merchant1.isGlobal_is_hot_deal_redemption())).concat(":").concat(Boolean.toString(merchant2.isGlobal_is_hot_deal_redemption())));
			return false;
		}else if(merchant1.isGlobal_is_void_redemption()!=merchant2.isGlobal_is_void_redemption()){
			System.out.println("isGlobal_is_void_redemption : ".concat(Boolean.toString(merchant1.isGlobal_is_void_redemption())).concat(":").concat(Boolean.toString(merchant2.isGlobal_is_void_redemption())));
			return false;
		}else if(merchant1.isGlobal_is_encryption()!=merchant2.isGlobal_is_encryption()){	
			System.out.println("isGlobal_is_encryption : ".concat(Boolean.toString(merchant1.isGlobal_is_encryption())).concat(":").concat(Boolean.toString(merchant2.isGlobal_is_encryption())));
			return false;
		}
		
		return result;
	}
	
	public static boolean isSameTerminal(Terminal terminal1, Terminal terminal2) {
		
		boolean  result = true;
		
		System.out.println("isSameTerminal");
		
		if(terminal1.getTier_rate_id()!=terminal2.getTier_rate_id()){
			System.out.println("getTier_rate_id : ".concat(Integer.toString(terminal1.getTier_rate_id())).concat(":").concat(Integer.toString(terminal2.getTier_rate_id())));
			return false;
		}else if(terminal1.getConversion_rate().compareTo(terminal2.getConversion_rate())!=0) {
			System.out.println("getConversion_rate : ".concat(terminal1.getConversion_rate().toPlainString()).concat(":").concat(terminal2.getConversion_rate().toPlainString()));
			return false;
		}else if(terminal1.getIs_inherit()!=terminal2.getIs_inherit()){
			System.out.println("getIs_inherit : ".concat(Boolean.toString(terminal1.getIs_inherit())).concat(":").concat(Boolean.toString(terminal2.getIs_inherit())));
			return false;
		}else if(terminal1.getMax_redeem_point().compareTo(terminal2.getMax_redeem_point())!=0) {	
			System.out.println("getMax_redeem_point : ".concat(terminal1.getMax_redeem_point().toPlainString()).concat(":").concat(terminal2.getMax_redeem_point().toPlainString()));
			return false;
		}else if(terminal1.getInstant_reward_percentage().compareTo(terminal2.getInstant_reward_percentage())!=0) {
			System.out.println("getInstant_reward_percentage : ".concat(terminal1.getInstant_reward_percentage().toPlainString()).concat(":").concat(terminal2.getInstant_reward_percentage().toPlainString()));
			return false;
		}else if((terminal1.getReceipt_hdr_1()==null?"":terminal1.getReceipt_hdr_1())
				.equals((terminal2.getReceipt_hdr_1()==null?"":terminal2.getReceipt_hdr_1()))==false){
			System.out.println("getReceipt_hdr_1 : ".concat(terminal1.getReceipt_hdr_1()).concat(":").concat(terminal2.getReceipt_hdr_1()));
			return false;
		}else if((terminal1.getReceipt_hdr_2()==null?"":terminal1.getReceipt_hdr_2())
				.equals((terminal2.getReceipt_hdr_2()==null?"":terminal2.getReceipt_hdr_2()))==false){
			System.out.println("getReceipt_hdr_2 : ".concat(terminal1.getReceipt_hdr_2()).concat(":").concat(terminal2.getReceipt_hdr_2()));
			return false;
		}else if((terminal1.getReceipt_hdr_3()==null?"":terminal1.getReceipt_hdr_3())
				.equals((terminal2.getReceipt_hdr_3()==null?"":terminal2.getReceipt_hdr_3()))==false){
			System.out.println("getReceipt_hdr_3 : ".concat(terminal1.getReceipt_hdr_3()).concat(":").concat(terminal2.getReceipt_hdr_3()));
			return false;
		}else if((terminal1.getReceipt_ftr_1()==null?"":terminal1.getReceipt_ftr_1())
				.equals((terminal2.getReceipt_ftr_1()==null?"":terminal2.getReceipt_ftr_1()))==false){
			System.out.println("getReceipt_ftr_1 : ".concat(terminal1.getReceipt_ftr_1()).concat(":").concat(terminal2.getReceipt_ftr_1()));
			return false;
		}else if((terminal1.getReceipt_ftr_2()==null?"":terminal1.getReceipt_ftr_2())
				.equals((terminal2.getReceipt_ftr_2()==null?"":terminal2.getReceipt_ftr_2()))==false){	
			System.out.println("getReceipt_ftr_2 : ".concat(terminal1.getReceipt_ftr_2()).concat(":").concat(terminal2.getReceipt_ftr_2()));
			return false;
		}else if((terminal1.getReceipt_ftr_3()==null?"":terminal1.getReceipt_ftr_3())
				.equals((terminal2.getReceipt_ftr_3()==null?"":terminal2.getReceipt_ftr_3()))==false){	
			System.out.println("getReceipt_ftr_3 : ".concat(terminal1.getReceipt_ftr_3()).concat(":").concat(terminal2.getReceipt_ftr_3()));
			return false;
		}else if(terminal1.getIs_point_inquiry()!=terminal2.getIs_point_inquiry()) {
			System.out.println("getIs_point_inquiry : ".concat(Boolean.toString(terminal1.getIs_point_inquiry())).concat(":").concat(Boolean.toString(terminal2.getIs_point_inquiry())));
			return false;
		}else if(terminal1.getIs_instant_reward()!=terminal2.getIs_instant_reward()) {
			System.out.println("getIs_instant_reward : ".concat(Boolean.toString(terminal1.getIs_instant_reward())).concat(":").concat(Boolean.toString(terminal2.getIs_instant_reward())));
			return false;
		}else if(terminal1.getIs_point_redemption()!=terminal2.getIs_point_redemption()) {
			System.out.println("getIs_point_redemption : ".concat(Boolean.toString(terminal1.getIs_point_redemption())).concat(":").concat(Boolean.toString(terminal2.getIs_point_redemption())));
			return false;
		}else if(terminal1.getIs_value_redemption()!=terminal2.getIs_value_redemption()) {
			System.out.println("getIs_value_redemption : ".concat(Boolean.toString(terminal1.getIs_value_redemption())).concat(":").concat(Boolean.toString(terminal2.getIs_value_redemption())));
			return false;
		}else if(terminal1.getIs_gift_code_redemption()!=terminal2.getIs_gift_code_redemption()) {
			System.out.println("getIs_gift_code_redemption : ".concat(Boolean.toString(terminal1.getIs_gift_code_redemption())).concat(":").concat(Boolean.toString(terminal2.getIs_gift_code_redemption())));
			return false;
		}else if(terminal1.getIs_hot_deal_redemption()!=terminal2.getIs_hot_deal_redemption()) {
			System.out.println("getIs_hot_deal_redemption : ".concat(Boolean.toString(terminal1.getIs_hot_deal_redemption())).concat(":").concat(Boolean.toString(terminal2.getIs_hot_deal_redemption())));
			return false;
		}else if(terminal1.getIs_void_redemption()!=terminal2.getIs_void_redemption()) {
			System.out.println("getIs_void_redemption : ".concat(Boolean.toString(terminal1.getIs_void_redemption())).concat(":").concat(Boolean.toString(terminal2.getIs_void_redemption())));
			return false;
		}else if(terminal1.getIs_encryption()!=terminal2.getIs_encryption()) {
			System.out.println("getIs_encryption : ".concat(Boolean.toString(terminal1.getIs_encryption())).concat(":").concat(Boolean.toString(terminal2.getIs_encryption())));
			return false;
		}
//		else if(terminal1.getStatus_id()!=terminal2.getStatus_id()) {
//			System.out.println("getStatus_id : ".concat(Integer.toString(terminal1.getStatus_id())).concat(":").concat(Integer.toString(terminal2.getStatus_id())));
//			return false;
//		}
		
		return result;
	}
}
