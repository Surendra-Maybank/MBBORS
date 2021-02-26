package com.maybank.orsapp.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maybank.orsapp.constant.MBBORSConstant;
import com.maybank.orsapp.controller.request.InsertNewTerminalReq;
import com.maybank.orsapp.controller.request.MBBORSInsertNewTerminalReq;
import com.maybank.orsapp.controller.requestval.CommonValidator;
import com.maybank.orsapp.controller.requestval.MBBORSInsertNewTerminalReqVal;
import com.maybank.orsapp.controller.response.MBBORSGetMMPTerminalListByMidRes;
import com.maybank.orsapp.controller.response.MBBORSGetTerminalDetailByTidRes;
import com.maybank.orsapp.controller.response.MBBORSGetTerminalListByMidRes;
import com.maybank.orsapp.controller.response.MBBORSGetTerminalRes;
import com.maybank.orsapp.controller.response.MBBORSInsertNewTerminalRes;
import com.maybank.orsapp.dto.MerchantDetailDTO;
import com.maybank.orsapp.dto.TerminalDetailDTO;
import com.maybank.orsapp.entities.Merchant;
import com.maybank.orsapp.entities.Terminal;
import com.maybank.orsapp.extapi.sdk.mmp.MMPAPIService;
import com.maybank.orsapp.extapi.sdk.mmp.MMPGetTerminalListRes;
import com.maybank.orsapp.repository.MerchantRepository;
import com.maybank.orsapp.repository.TerminalRepository;
import com.maybank.orsapp.service.TerminalService;

@Service
public class TerminalServiceImpl implements TerminalService{
	
	private final Logger logger = LoggerFactory.getLogger(TerminalServiceImpl.class);
	
	@Autowired
	MMPAPIService mmpAPIService;
	
	@Autowired
	TerminalRepository terminalRepository;
	
	@Autowired
	MerchantRepository merchantRepository;
	
	public MBBORSGetMMPTerminalListByMidRes getMMPTerminalListByMid (String mid) {
		MBBORSGetMMPTerminalListByMidRes res = new MBBORSGetMMPTerminalListByMidRes();
		
		try {
		
		MMPGetTerminalListRes extRes = mmpAPIService.getMMPTerminalList(mid);
		
		if(extRes!= null&&extRes.getBody()!=null&&extRes.getBody().getResponseCode().equals("0")) {
			 //##Test
			res.setResponseCode(MBBORSConstant.RES_CODE_SUCCESS);
			res.setResponseMessage(MBBORSConstant.RES_DESC_SUCCESS);
			
			 List<String> resultTerminal = extRes.getBody().getTIDsList().stream()
					 .map(e -> e.getTid()).collect(Collectors.toList());
			 
			 List<String> orsTerminalList = terminalRepository.getTerminalListByTids(resultTerminal);
			 
			 resultTerminal.removeAll(orsTerminalList);
			 
			 res.setTeminalList(resultTerminal);
		 }else {
			 res.setResponseCode("01");
			 res.setResponseMessage("MMP_SYSTEM_ERROR");
		 }
		
		}catch(Exception ex) {
			res.setResponseCode(MBBORSConstant.RES_CODE_SYSTEM_ERROR);
			res.setResponseMessage(MBBORSConstant.RES_DESC_SYSTEM_ERROR);
			logger.info("ORS SYSTEM ERROR GetMMPTerminalListByMid [mid = "+mid+"]:", ex);
			ex.printStackTrace();
		}
		
		return res;
	}
	
	
	public MBBORSGetTerminalListByMidRes getTerminalListByMid (String mid) {
		
		MBBORSGetTerminalListByMidRes result = new MBBORSGetTerminalListByMidRes();
		
		try {
			
			List<String> orsTerminalList = terminalRepository.getTerminalListByMid(mid);
			
			result.setTeminalList(orsTerminalList);
			result.setResponseCode(MBBORSConstant.RES_CODE_SUCCESS);
			result.setResponseMessage(MBBORSConstant.RES_DESC_SUCCESS);
			
			}catch(Exception ex) {
				 result.setResponseCode(MBBORSConstant.RES_CODE_SYSTEM_ERROR);
				 result.setResponseMessage(MBBORSConstant.RES_DESC_SYSTEM_ERROR);
				ex.printStackTrace();
			}
		return result;
	}
	
	public MBBORSGetTerminalDetailByTidRes getTerminalDetailByTerminalId(String terminalId) {
		
		MBBORSGetTerminalDetailByTidRes result = new MBBORSGetTerminalDetailByTidRes();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-yyyy HH:mm:ss");
		try {
			
			if(CommonValidator.isEmptyStr(terminalId)) {
				result.setResponseCode("01");
				result.setResponseMessage("Terminal ID not found");
				return result;
			}
			
			TerminalDetailDTO terminalDetailDTO = terminalRepository.getTerminalDetailByTerminalId(new BigDecimal(terminalId));
						
			
			
			if(terminalDetailDTO!=null) {
				result.setResponseCode(MBBORSConstant.RES_CODE_SUCCESS);
				result.setResponseMessage(MBBORSConstant.RES_DESC_SUCCESS);
	//			 private String tid;	
				result.setTid(terminalDetailDTO.getTid());
	//		    private BigDecimal mid;	
				result.setMid(terminalDetailDTO.getMid());
	//		    private BigDecimal max_redeem_point;		
				result.setMax_redeem_point(terminalDetailDTO.getMax_redeem_point());
				result.setIs_inherit(terminalDetailDTO.isIs_inherit()==true?"Y":"N");
				result.setInstant_reward_percentage(terminalDetailDTO.getInstant_reward_percentage());
				result.setConversion_rate(terminalDetailDTO.getConversion_rate());
				
				result.setTier_rate_id(terminalDetailDTO.getTier_rate_id());
				result.setTier_rate_code(terminalDetailDTO.getTier_rate_code());
				result.setTier_rate_desc(terminalDetailDTO.getTier_rate_desc());
				
	//		    private String receipt_hdr_1;	
				result.setReceipt_hdr_1(terminalDetailDTO.getReceipt_hdr_1());
	//		    private String receipt_hdr_2;
				result.setReceipt_hdr_2(terminalDetailDTO.getReceipt_hdr_2());
	//		    private String receipt_hdr_3;	
				result.setReceipt_hdr_3(terminalDetailDTO.getReceipt_hdr_3());
	//			
	//		    private String receipt_ftr_1;
				result.setReceipt_ftr_1(terminalDetailDTO.getReceipt_ftr_1());
	//		    private String receipt_ftr_2;	
				result.setReceipt_ftr_2(terminalDetailDTO.getReceipt_ftr_2());
	//		    private String receipt_ftr_3;			
				result.setReceipt_ftr_3(terminalDetailDTO.getReceipt_ftr_3());
	//		    
	//		    private int is_point_inquiry;
				result.setIs_point_inquiry(terminalDetailDTO.isIs_point_inquiry()==true?"Y":"N");
	//		    private int is_instant_reward;
				result.setIs_instant_reward(terminalDetailDTO.isIs_instant_reward()==true?"Y":"N");
	//		    private int is_point_redemption;	
				result.setIs_point_redemption(terminalDetailDTO.isIs_point_redemption()==true?"Y":"N");
	//		    private int is_value_redemption;
				result.setIs_value_redemption(terminalDetailDTO.isIs_value_redemption()==true?"Y":"N");
	//		    private int is_gift_code_redemption;
				result.setIs_gift_code_redemption(terminalDetailDTO.isIs_gift_code_redemption()==true?"Y":"N");
	//		    private int is_hot_deal_redemption;	
				result.setIs_hot_deal_redemption(terminalDetailDTO.isIs_hot_deal_redemption()==true?"Y":"N");
	//		    private int is_void_redemption;
				result.setIs_void_redemption(terminalDetailDTO.isIs_void_redemption()==true?"Y":"N");
	//		    private int is_encryption;
				result.setIs_encryption(terminalDetailDTO.isIs_encryption()==true?"Y":"N");
	//			private int status_id;
				result.setStatus_id(terminalDetailDTO.getStatus_id());
	//			private String created_by;
				result.setCreated_by(terminalDetailDTO.getCreated_by());
	//			private Date created_datetime;
				result.setCreated_datetime(df.format(terminalDetailDTO.getCreated_datetime()));
	//			private String edited_by;
				result.setEdited_by(terminalDetailDTO.getEdited_by());
	//			private Date edited_datetime;
				result.setEdited_datetime(df.format(terminalDetailDTO.getEdited_datetime()));
			}else {
				result.setResponseCode("01");
				result.setResponseMessage("Terminal Id is not found");
			}
			}catch(Exception ex) {
				 result.setResponseCode(MBBORSConstant.RES_CODE_SYSTEM_ERROR);
				 result.setResponseMessage(MBBORSConstant.RES_DESC_SYSTEM_ERROR);
				 logger.info("ORS SYSTEM ERROR GetTerminalDetailByTid [terminalId="+terminalId+"]:", ex);
				 ex.printStackTrace();
			}
		
		return result;
	}
	
	@Override
	public MBBORSInsertNewTerminalRes insertNewTerminal(MBBORSInsertNewTerminalReq request) {
		
		MBBORSInsertNewTerminalRes res = new MBBORSInsertNewTerminalRes();		
		
		String result = MBBORSInsertNewTerminalReqVal.validate(request);
			
		if (result.equals("")==false){
			res.setResponseCode("01");
			res.setResponseMessage(result);
			return res;
		}
		
		BigDecimal merchantId = new BigDecimal(request.getMerchant_id());
		List<InsertNewTerminalReq> tids = request.getTIDs();
		int tierRateId = Integer.valueOf(request.getTier_rate_id());
		
		BigDecimal conversionRate = new BigDecimal(request.getConversion_rate());
		BigDecimal maxRedeemPoint = new BigDecimal(request.getMax_redeem_point());
		BigDecimal instantRewardPercentage = new BigDecimal(request.getInstant_reward_percentage());
		
		String header1 = request.getReceipt_hdr_1();
		String header2 = request.getReceipt_hdr_2();
		String header3 = request.getReceipt_hdr_3();
		
		String footer1 = request.getReceipt_ftr_1();
		String footer2 = request.getReceipt_ftr_2();
		String footer3 = request.getReceipt_ftr_3();
		
		boolean isPointInquiry = request.getIs_point_inquiry().equals("Y")?true:false;
		boolean isInstantReward = request.getIs_instant_reward().equals("Y")?true:false;
		boolean isPointRedemption = request.getIs_point_redemption().equals("Y")?true:false;
		boolean isValueRedemption = request.getIs_value_redemption().equals("Y")?true:false;	
		
		boolean isGiftCodeRedemption = 	request.getIs_gift_code_redemption().equals("Y")?true:false;
		boolean isHotDealRedemption = request.getIs_hot_deal_redemption().equals("Y")?true:false;
		boolean isVoidRedemption = request.getIs_void_redemption().equals("Y")?true:false;
		boolean isEncryption = request.getIs_encryption().equals("Y")?true:false;
		
		Timestamp now = new Timestamp(System.currentTimeMillis());	
		
		try {

			for(InsertNewTerminalReq tid:tids) {
				Terminal terminal = new Terminal();
				
	
				terminal.setTid(tid.getTid());	
				terminal.setMerchant_id(merchantId);
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
			logger.info("ORS SYSTEM ERROR CreateTerminal [merchantId = "+merchantId+"]:", ex);
			ex.printStackTrace();
		}
		
		return res;
	}
	
	public MBBORSGetTerminalRes getTerminalDetails(String tid) {
		MBBORSGetTerminalRes respond = null;
		
		TerminalDetailDTO terminalDetail = null;
		
		DecimalFormat dc12 = new DecimalFormat("000000000000");
		
 		try {
 			terminalDetail = terminalRepository.getTerminalDetailsByTID(tid);
			
			if(terminalDetail!=null) {
				
						respond = new MBBORSGetTerminalRes();
						
						respond.setCode("00");
						
						respond.setTid(terminalDetail.getTid());
						respond.setMax_redeem_point(dc12.format(terminalDetail.getMax_redeem_point().setScale(0, RoundingMode.FLOOR)));
			//
			
						respond.setReceipt_hdr_1(terminalDetail.getReceipt_hdr_1()!=null?String.format("%-24s", terminalDetail.getReceipt_hdr_1()):String.format("%-24s", " "));
						respond.setReceipt_hdr_2(terminalDetail.getReceipt_hdr_2()!=null?String.format("%-24s", terminalDetail.getReceipt_hdr_2()):String.format("%-24s", " "));
						respond.setReceipt_hdr_3(terminalDetail.getReceipt_hdr_3()!=null?String.format("%-24s", terminalDetail.getReceipt_hdr_3()):String.format("%-24s", " "));
			//			
						respond.setReceipt_ftr_1(terminalDetail.getReceipt_ftr_1()!=null?String.format("%-24s", terminalDetail.getReceipt_ftr_1()):String.format("%-24s", " "));
						respond.setReceipt_ftr_2(terminalDetail.getReceipt_ftr_2()!=null?String.format("%-24s", terminalDetail.getReceipt_ftr_2()):String.format("%-24s", " "));
						respond.setReceipt_ftr_3(terminalDetail.getReceipt_ftr_3()!=null?String.format("%-24s", terminalDetail.getReceipt_ftr_3()):String.format("%-24s", " "));
			//		    
						respond.setIs_point_inquiry(terminalDetail.isIs_point_inquiry()==true?"Y":"N");
						respond.setIs_instant_reward(terminalDetail.isIs_instant_reward()==true?"Y":"N");
						respond.setIs_point_redemption(terminalDetail.isIs_point_redemption()==true?"Y":"N");
						respond.setIs_value_redemption(terminalDetail.isIs_value_redemption()==true?"Y":"N");
						respond.setIs_gift_code_redemption(terminalDetail.isIs_gift_code_redemption()==true?"Y":"N");
						respond.setIs_hot_deal_redemption(terminalDetail.isIs_hot_deal_redemption()==true?"Y":"N");
						respond.setIs_void_redemption(terminalDetail.isIs_void_redemption()==true?"Y":"N");
						respond.setIs_encryption(terminalDetail.isIs_encryption()==true?"Y":"N");
				}else {
					respond = new MBBORSGetTerminalRes();
					respond.setCode("03");
				}
		
		}catch(Exception ex) {
			respond = new MBBORSGetTerminalRes(); 
			respond = new MBBORSGetTerminalRes();
			respond.setCode("96");
			ex.printStackTrace();
		}
			
		return respond;
	}
}
