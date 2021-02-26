package com.maybank.orsapp.controller.requestval;

import org.apache.commons.lang.math.NumberUtils;

public class CommonValidator {
	
	public static boolean isEmptyStr(String input) {
		boolean result = true;
		
		if(input!=null&&!input.equals("")&&input.trim().length()>0) {
			return false;
		}
		
		return result;
	}
	
	public static boolean isYN(String input) {
		boolean result = false;
		
		if(input.equals("Y")||input.equals("N")) {
			result = true;
		}
		
		return result;
	}
	
	public static boolean isPositiveNumeric(String input) {
		boolean result = false;
		
		if(NumberUtils.isNumber(input)&&input.startsWith("-")==false) {
			result = true;
		}
		
		return result;
	}
}
