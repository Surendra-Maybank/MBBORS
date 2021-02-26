package com.maybank.orsapp.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VoidRedeemRequest {
	
	@JsonProperty
	private Long pointTxnId;
	
	@JsonProperty
	private String reversalReason;

	/**
	 * @return the pointTxnId
	 */
	public Long getPointTxnId() {
		return pointTxnId;
	}

	/**
	 * @param pointTxnId the pointTxnId to set
	 */
	public void setPointTxnId(Long pointTxnId) {
		this.pointTxnId = pointTxnId;
	}

	/**
	 * @return the reversalReason
	 */
	public String getReversalReason() {
		return reversalReason;
	}

	/**
	 * @param reversalReason the reversalReason to set
	 */
	public void setReversalReason(String reversalReason) {
		this.reversalReason = reversalReason;
	}

	@Override
	public String toString() {
		return "VoidRedeemRequest [pointTxnId=" + pointTxnId + ", reversalReason=" + reversalReason + "]";
	}
}
