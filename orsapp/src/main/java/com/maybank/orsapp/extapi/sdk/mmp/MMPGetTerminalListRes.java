package com.maybank.orsapp.extapi.sdk.mmp;

public class MMPGetTerminalListRes {
	
	private GetTerminalListHeaderRes header;
	private GetTerminalListBodyRes body;
	
	public GetTerminalListHeaderRes getHeader() {
		return header;
	}
	public void setHeader(GetTerminalListHeaderRes header) {
		this.header = header;
	}
	public GetTerminalListBodyRes getBody() {
		return body;
	}
	public void setBody(GetTerminalListBodyRes body) {
		this.body = body;
	}
}
