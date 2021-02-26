package com.maybank.orsapp.extapi.sdk.airasia;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class BigLifeService {
	
	private final Logger logger = LoggerFactory.getLogger(BigLifeService.class);
	
	public MBBORSBigLifePointsAccrualResBean accrual(MBBORSBigLifePointsAccrualReqBean requestBean) throws Exception{
		
		MBBORSBigLifePointsAccrualResBean response = null;
		
		ObjectMapper mapper = new ObjectMapper();
		
		
		
		try {
			logger.info(requestBean.toString());
			String strMemberValidateRes = GetS3ObjectSample.getS3Object(BigLifeConstants.bucketName, BigLifeConstants.regionName, BigLifeConstants.awsAccessKey, BigLifeConstants.awsSecretKey, requestBean.getMemberId());
			
			MBBORSBigLifeValidateMemberResBean memberValidateResp = mapper.readValue(strMemberValidateRes, MBBORSBigLifeValidateMemberResBean.class);
			logger.info(memberValidateResp.toString());
			if(memberValidateResp !=null&&memberValidateResp.getCode()==200 &&
					memberValidateResp.getAccountStatus().equals("ACTIVE")) {
			
				String strJson = mapper.writeValueAsString(requestBean);
				
				String strRes = PostS3ObjectSample.postS3Object(BigLifeConstants.bucketName, BigLifeConstants.regionName, BigLifeConstants.awsAccessKey, BigLifeConstants.awsSecretKey, strJson);
				
				response = mapper.readValue(strRes, MBBORSBigLifePointsAccrualResBean.class);
			}else {
				response = new MBBORSBigLifePointsAccrualResBean();
				response.setCode(404);
				response.setMessage("Member Is Not Found");
			}
			
		}catch(Exception ex) {
			logger.error("Error : ".concat(ex.getMessage()));
			response = new MBBORSBigLifePointsAccrualResBean();
			response.setCode(500);
			response.setMessage("System Error");
		}
		logger.info(response.toString());
		return response;
	}
	
	public MBBORSBigLifeValidateMemberResBean validateMember(MBBORSBigLifeValidateMemberReqBean requestBean) throws Exception{
		
		MBBORSBigLifeValidateMemberResBean response = null;
		
		ObjectMapper mapper = new ObjectMapper();
		
		try {
		
			String strRes = GetS3ObjectSample.getS3Object(BigLifeConstants.bucketName, BigLifeConstants.regionName, BigLifeConstants.awsAccessKey, BigLifeConstants.awsSecretKey, requestBean.getMemberId());
			
			response = mapper.readValue(strRes, MBBORSBigLifeValidateMemberResBean.class);
			
		}catch(Exception ex) {
			logger.error("Error : ".concat(ex.getMessage()));
			response = new MBBORSBigLifeValidateMemberResBean();
			response.setCode(500);
			response.setMessage("System Error");
			ex.printStackTrace();
		}	
		
		return response;
	}
}
