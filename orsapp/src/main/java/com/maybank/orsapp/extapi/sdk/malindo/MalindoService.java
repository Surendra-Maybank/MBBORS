package com.maybank.orsapp.extapi.sdk.malindo;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class MalindoService {
	
	public MBBORSMalindoAccrualRes accrual(MBBORSMalindoAccrualReq requestBean) {
		MBBORSMalindoAccrualRes response = null;
		
		ObjectMapper mapper = new ObjectMapper();
		
		String domain = "stg.malindo.inspirenetz.com";
//		String domain = "172.31.13.243";
		String urlSuffix = "/inspirenetz-api/0.9/json/exchange/request/proceed";
		String url = "http".concat(domain).concat(urlSuffix);
		
		String username = "stg_maybank_apiuser";
		String password = "l9cmKpGxOkFh7QV";
		
		try {
		
			String data = mapper.writeValueAsString(requestBean);
			System.out.println("Input data : ".concat(data));
			String result = MalindoUtils.sendRequest(domain, urlSuffix,username,password, data);

			response = mapper.readValue(result, MBBORSMalindoAccrualRes.class);	
			
		}catch(Exception ex) {
//			response = new MBBORSMalindoAccrualRes();
//			response.setCode("500");
//			response.setResponse(new MBBORSMalindoAccrualRes("500","System Error"));
//			logger.error("Error : ".concat(ex.getMessage()));
			ex.printStackTrace();
		}
		

		return response;
	}

}
