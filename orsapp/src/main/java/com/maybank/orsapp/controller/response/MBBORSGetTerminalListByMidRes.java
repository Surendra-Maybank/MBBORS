package com.maybank.orsapp.controller.response;

import java.util.List;

public class MBBORSGetTerminalListByMidRes extends MBBORSCommonRes {
	
	private List<String> teminalList; 
	
	public List<String> getTeminalList() {
		return teminalList;
	}
	public void setTeminalList(List<String> teminalList) {
		this.teminalList = teminalList;
	}
			
}
