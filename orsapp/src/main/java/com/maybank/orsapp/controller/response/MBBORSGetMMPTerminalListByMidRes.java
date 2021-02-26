package com.maybank.orsapp.controller.response;

import java.util.List;

public class MBBORSGetMMPTerminalListByMidRes extends MBBORSCommonRes{

	private List<String> teminalList; 
	
	public List<String> getTeminalList() {
		return teminalList;
	}
	public void setTeminalList(List<String> teminalList) {
		this.teminalList = teminalList;
	}
		
	public String toString() {
		
		String tids = "";
		
		if(teminalList!=null&&teminalList.size()>0) {
			for(int ind=0;teminalList.size()>ind;ind++) {
				if(ind==(teminalList.size()-1)) {
					tids = tids.concat(teminalList.get(ind));
				}else {
					tids = tids.concat(teminalList.get(ind)).concat(",");
				}
			}
		}
		
		
		return "[MBBORSGetMMPTerminalListByMidRes: {responseCode:"+this.getResponseCode()
			+",responseMessage:"+this.getResponseMessage()
			+",teminalList:[".concat(tids).concat("]}");
	}
}
