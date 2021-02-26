package com.maybank.orsapp.extapi.sdk.airasia;

public class MBBORSBigLifeValidateMemberReqBean{

	private String memberId;	
	
	
	public String getMemberId() {
		return memberId;
	}


	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}


	@Override
	public String toString() {
		return "MBBORSBigLifeValidateMemberReqBean [memberId="+memberId+"]";
	}
//
//
//	@Override
//	public String fetchAllChecksumFields() {
//		return app_id+settlemnt_id+batch_id+terminal_id+terminal_ip+settlemnt_dt+mac_id+sub_mch_id;
//	}


	
	
	
}
