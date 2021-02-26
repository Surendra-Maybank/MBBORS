package com.maybank.orsapp.extapi.sdk.mmp;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetMechantInfoBodyRes {

	@JsonProperty("ORSMerchantInfo")
	private GetMechantInfoRes ORSMerchantInfo;
	@JsonProperty("TIDsList")
	private List<GetMechantInfoTIDRes> TIDsList;
	private String responseCode;
	private String responseDescription;

	public GetMechantInfoRes getORSMerchantInfo() {
		return ORSMerchantInfo;
	}

	public void setORSMerchantInfo(GetMechantInfoRes oRSMerchantInfo) {
		ORSMerchantInfo = oRSMerchantInfo;
	}	

	public List<GetMechantInfoTIDRes> getTIDsList() {
		return TIDsList;
	}

	public void setTIDsList(List<GetMechantInfoTIDRes> tIDsList) {
		TIDsList = tIDsList;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseDescription() {
		return responseDescription;
	}

	public void setResponseDescription(String responseDescription) {
		this.responseDescription = responseDescription;
	}

}
