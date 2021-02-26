package com.maybank.orsapp.controller.response;

public class MBBORSInsertNewTerminalRes extends MBBORSCommonRes{
	
	public String toString() {
		return "MBBORSInsertNewTerminalRes:{"
				+ "responseCode:".concat(this.getResponseCode())
				+ "responseMessage:".concat(this.getResponseMessage())
				+ "}";
	}
}
