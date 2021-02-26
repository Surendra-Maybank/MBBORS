/**
 * 
 */
package com.maybank.orsapp.exceptions;

/**
 * @author 80003905
 *
 */
public class UserAccountHandlingException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8083736548096872399L;

	public UserAccountHandlingException(String exception) {
		super(exception);
	}

}
