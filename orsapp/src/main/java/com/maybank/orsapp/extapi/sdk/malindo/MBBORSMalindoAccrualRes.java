package com.maybank.orsapp.extapi.sdk.malindo;

public class MBBORSMalindoAccrualRes {
	
    private DataContent data;
    
    private String status;
    private String index;
    private String errorcode;

	public DataContent getData() {
		return data;
	}

	public void setData(DataContent data) {
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public String getErrorcode() {
		return errorcode;
	}

	public void setErrorcode(String errorcode) {
		this.errorcode = errorcode;
	}

	@Override
	public String toString() {
		
		return "MBBORSMalindoAccrualRes [data=".concat("{").concat(data!=null?data.toString():"").concat("},")
				.concat("status=").concat(status).concat(",")
				.concat("index=").concat(index).concat(",")
				.concat("errorcode=").concat(errorcode!=null?errorcode:"");
	}
}
