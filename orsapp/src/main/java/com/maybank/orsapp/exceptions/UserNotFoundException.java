/**
 * 
 */
package com.maybank.orsapp.exceptions;

/**
 * @author 80003905
 *
 */
public class UserNotFoundException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4058956497100179996L;

	public UserNotFoundException(String exception) {
		super(exception);
	}

}
