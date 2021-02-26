/**
 * 
 */
package com.maybank.orsapp.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 80003905
 *
 */
public enum StatusCodes {
	
	ACTIVE(1), DELETE(2), INACTIVE(3);
	
	private Integer statusCode;
	private static Map<Integer, StatusCodes> map = new HashMap<>();

	/**
	 * @param statusCode
	 */
	private StatusCodes(Integer statusCode) {
		this.setStatusCode(statusCode);
	}
	
    static {
        for (StatusCodes statusCodes : StatusCodes.values()) {
            map.put(statusCodes.statusCode, statusCodes);
        }
    }

    
    public static StatusCodes valueOf(Integer statusId) {
		return (StatusCodes) map.get(statusId);
	}

	/**
	 * @return the statusCode
	 */
	public Integer getStatusCode() {
		return statusCode;
	}


	/**
	 * @param statusCode the statusCode to set
	 */
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}


}
