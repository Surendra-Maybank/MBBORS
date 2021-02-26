/**
 * 
 */
package com.maybank.orsapp.entities;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 80003905
 *
 */

@Entity
@Table(name = "lg_LOGIN_SESSION")
public class LoginSessionAudit implements Serializable {

	private static final long serialVersionUID = -7008594323841269156L;
	
	@Id
	@Column(name = "LOGIN_SESSION_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long loginSessionId;
	
	@Column(name="USER_ID", nullable=false)
	private Long userId;
	
	@Column(name = "IS_SUCCESS_LOGIN")
	private Boolean isSucess = Boolean.FALSE;
	
	@Column(name = "LOGIN_DATETIME")
	private Timestamp loginDateTime;
	
	@Column(name = "LOGOUT_DATETIME")
	private Timestamp logoutDateTime;
	
	@Column(name = "ERROR_MSG")
	private String errorMessage;
	
	public LoginSessionAudit() {
		super();
	}
	
	/**
	 * 
	 * @param loginSessionId
	 * @param userId
	 * @param isSucess
	 * @param loginDateTime
	 */
	public LoginSessionAudit(Long loginSessionId, Long userId, Boolean isSucess, Timestamp loginDateTime) {
		this.loginSessionId = loginSessionId;
		this.userId = userId;
		this.isSucess = isSucess;
		this.loginDateTime = loginDateTime;
	}

	/**
	 * @return the loginSessionId
	 */
	public Long getLoginSessionId() {
		return loginSessionId;
	}

	/**
	 * @param loginSessionId the loginSessionId to set
	 */
	public void setLoginSessionId(Long loginSessionId) {
		this.loginSessionId = loginSessionId;
	}

	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * @return the isSucess
	 */
	public Boolean getIsSucess() {
		return isSucess;
	}

	/**
	 * @param isSucess the isSucess to set
	 */
	public void setIsSucess(Boolean isSucess) {
		this.isSucess = isSucess;
	}

	/**
	 * @return the loginDateTime
	 */
	public Timestamp getLoginDateTime() {
		return loginDateTime;
	}

	/**
	 * @param loginDateTime the loginDateTime to set
	 */
	public void setLoginDateTime(Timestamp loginDateTime) {
		this.loginDateTime = loginDateTime;
	}

	/**
	 * @return the logoutDateTime
	 */
	public Timestamp getLogoutDateTime() {
		return logoutDateTime;
	}

	/**
	 * @param logoutDateTime the logoutDateTime to set
	 */
	public void setLogoutDateTime(Timestamp logoutDateTime) {
		this.logoutDateTime = logoutDateTime;
	}

	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	

}
