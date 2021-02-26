package com.maybank.orsapp.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InsertNewTerminalReq {
		
	@JsonProperty("tid")
	private String tid;
	
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}

	public String toString() {
		
		if(tid!=null) {
			return "{tid:"
					+tid
					+ "}";
		}else {
			return "{}";
		}
	}
}
