package com.maybank.orsapp.extapi.sdk.mmp;

public class MMPGetTerminalListReq {
	
	private CommonHeaderReq header;
	private CommonBodyReq body;
	
	public CommonHeaderReq getHeader() {
		return header;
	}
	public void setHeader(CommonHeaderReq header) {
		this.header = header;
	}
	public CommonBodyReq getBody() {
		return body;
	}
	public void setBody(CommonBodyReq body) {
		this.body = body;
	}
	
}
