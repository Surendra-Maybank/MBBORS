package com.maybank.orsapp.extapi.sdk.airasia;

public class BigLifeValidateMemberErrorDetails {
	
    private String domain;
    private String reason;
    private String message;
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
    
	@Override
	public String toString() {
		
		return "[domain="+domain+",reason="+reason+","
				+ "message="+message+"]";
	
	}
}
