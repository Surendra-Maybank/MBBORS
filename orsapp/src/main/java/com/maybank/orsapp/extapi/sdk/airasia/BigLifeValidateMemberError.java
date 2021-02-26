package com.maybank.orsapp.extapi.sdk.airasia;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BigLifeValidateMemberError {
	
	@JsonProperty("errors")
	private BigLifeValidateMemberErrorDetails[] errors;

	public BigLifeValidateMemberErrorDetails[] getErrors() {
		return errors;
	}

	public void setErrors(BigLifeValidateMemberErrorDetails[] errors) {
		this.errors = errors;
	}
	
	@Override
	public String toString() {
		if(errors!=null&&errors.length>0) {
			String message="";
			if(errors.length==1) {
				message = errors[0].toString();
			}else {
				for(BigLifeValidateMemberErrorDetails error:errors){
					message = message.concat(error.toString()).concat(",");
				}
				message = message.substring(0, message.length()-1);
			}
			return message;
		}else {
			
			return "[domain=,reason=,"
					+ "message=]";
			
		}
	}
}
