/**
 * 
 */
package com.maybank.orsapp.controller.request;

import java.util.Objects;

/**
 * @author 80003905
 *
 */
public class LoginRequest {
	
	private String userId;
	
	private String password;

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the userPassword
	 */
	public String getpassword() {
		return password;
	}

	/**
	 * @param userPassword the userPassword to set
	 */
	public void setpassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		return Objects.hash(userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoginRequest other = (LoginRequest) obj;
		return Objects.equals(userId, other.userId);
	}

	@Override
	public String toString() {
		return "LoginRequest [userId=" + userId + "]";
	}

}
