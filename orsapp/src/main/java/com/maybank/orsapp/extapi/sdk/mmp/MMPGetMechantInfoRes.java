package com.maybank.orsapp.extapi.sdk.mmp;

public class MMPGetMechantInfoRes {

	private GetMechantInfoHeaderRes header;
	private GetMechantInfoBodyRes body;

	public GetMechantInfoHeaderRes getHeader() {
		return header;
	}

	public void setHeader(GetMechantInfoHeaderRes header) {
		this.header = header;
	}

	public GetMechantInfoBodyRes getBody() {
		return body;
	}

	public void setBody(GetMechantInfoBodyRes body) {
		this.body = body;
	}

}
