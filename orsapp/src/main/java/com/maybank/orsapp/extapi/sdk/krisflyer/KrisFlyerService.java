package com.maybank.orsapp.extapi.sdk.krisflyer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class KrisFlyerService {
	
	private Logger logger = LoggerFactory.getLogger(KrisFlyerService.class);
	
	public MBBORSKrisFlyerAccrualResBean accrual(MBBKrisFlyerAccrualReqBean requestBean) throws Exception{
		
		MBBORSKrisFlyerAccrualResBean response = null;
		
		ObjectMapper mapper = new ObjectMapper();
		
		String domain = "apigw.singaporeair.com";
		String urlSuffix = "/api/v1/lsl-uat/creditnonairmiles";
		
		try {
		
			String data = mapper.writeValueAsString(requestBean);
			
			String result = KrisFlyerUtils.requestOnce(domain, urlSuffix, data);

			response = mapper.readValue(result, MBBORSKrisFlyerAccrualResBean.class);	
			
			throw new Exception("Testing"); 
			
		}catch(Exception ex) {
			response = new MBBORSKrisFlyerAccrualResBean();
			response.setCode("500");
			response.setResponse(new KrisFlyerAccrualRes("500","System Error"));
			logger.error("Error : ".concat(ex.getMessage()));
			ex.printStackTrace();
		}
		

		return response;
	}
	
}
