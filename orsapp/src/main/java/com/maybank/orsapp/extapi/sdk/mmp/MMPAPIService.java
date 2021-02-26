package com.maybank.orsapp.extapi.sdk.mmp;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.maybank.orsapp.util.DateUtil;

@Service("mmpAPIService")
public class MMPAPIService {
	
	private final String domain = "172.30.2.31";
	private final int port = 8006;
	private final String suffixGetMerchant = "/api/GetMerchantInfoByORSMID";
	private final String suffixGetTerminalList = "/api/GetTIDsListByORSMID";
	private final String username = "ORS001";
	private final String password = "Maybank@123";
	private final String projectID = "ORS";
	
	public MMPGetMechantInfoRes getMBBMechantInfo(String ORSMid) {
		MMPGetMechantInfoRes result = null;
		String strReq = "";
		try {
			
			CommonHeaderReq header = new CommonHeaderReq();
			header.setProjectID(projectID);
			header.setTranID(ORSMid);
			header.setPostedTimestamp(DateUtil.getDate(MMPConstants.DF_YYYY_MM_DD_HH_MM_SS, new Date(), 0));
			
			CommonBodyReq body = new CommonBodyReq();
			body.setOrsMID(ORSMid);
			
			MMPGetMechantInfoReq req = new MMPGetMechantInfoReq();
			req.setHeader(header);
			req.setBody(body);
			
			ObjectMapper mapper = new ObjectMapper();
			strReq = mapper.writeValueAsString(req);
			System.out.println("strReq : ".concat(strReq));
			
			String mmpResult = MMPAPIUtil.requestOnce(domain, port, suffixGetMerchant, username, password, strReq);
			
			System.out.println("mmpResult : ".concat(mmpResult));
			
			result = mapper.readValue(mmpResult, MMPGetMechantInfoRes.class);
			
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return result;
	}
	
	public MMPGetTerminalListRes getMMPTerminalList(String ORSMid) {
		MMPGetTerminalListRes result = null;
		String strReq = "";
		try {
			
			CommonHeaderReq header = new CommonHeaderReq();
			header.setProjectID(projectID);
			header.setTranID(ORSMid);
			header.setPostedTimestamp(DateUtil.getDate(MMPConstants.DF_YYYY_MM_DD_HH_MM_SS, new Date(), 0));
			
			CommonBodyReq body = new CommonBodyReq();
			body.setOrsMID(ORSMid);
			
			MMPGetTerminalListReq req = new MMPGetTerminalListReq();
			req.setHeader(header);
			req.setBody(body);
			
			ObjectMapper mapper = new ObjectMapper();
			strReq = mapper.writeValueAsString(req);
			
			result = mapper.readValue(MMPAPIUtil.requestOnce(domain, port, suffixGetTerminalList, username, password, strReq), MMPGetTerminalListRes.class);
			
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return result;
	}
}
