package com.maybank.orsapp.extapi.sdk.krisflyer;

public class RequestorProfile {
	

	private String loyaltyMembershipID;
	private String loyaltyParticpantCode;
	private String loyaltyProgramCode;
	
	public String getLoyaltyMembershipID() {
		return loyaltyMembershipID;
	}
	public void setLoyaltyMembershipID(String loyaltyMembershipID) {
		this.loyaltyMembershipID = loyaltyMembershipID;
	}
	public String getLoyaltyParticpantCode() {
		return loyaltyParticpantCode;
	}
	public void setLoyaltyParticpantCode(String loyaltyParticpantCode) {
		this.loyaltyParticpantCode = loyaltyParticpantCode;
	}
	public String getLoyaltyProgramCode() {
		return loyaltyProgramCode;
	}
	public void setLoyaltyProgramCode(String loyaltyProgramCode) {
		this.loyaltyProgramCode = loyaltyProgramCode;
	}
	
	@Override
	public String toString() {
		
		return "loyaltyMembershipID="+loyaltyMembershipID+",loyaltyParticpantCode="+loyaltyParticpantCode+","
				+ "loyaltyProgramCode="+loyaltyProgramCode;
		
	}
}
