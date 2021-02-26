/**
 * 
 */
package com.maybank.orsapp.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author 80003905
 *
 */

@Entity
@Table(name = "ap_POINT_TXN_DETAIL")
public class ApPointTxnDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1522363160942719009L;
	
	@Id
	@Column(name = "POINT_TXN_DETAIL_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long pointTxnDetailId;
	
	@ManyToOne
	@JoinColumn(name = "POINT_TXN_ID", referencedColumnName = "POINT_TXN_ID")
	public ApPointTxn pointTxnId;
	
	@Column(name = "ORDER_NO")
	public String orderNo;
	
	@ManyToOne
	@JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PRODUCT_ID")
	public Product productId;
	
	@Column(name = "REF_PRODUCT_NAME")
	public String refProductName;
	
	@Column(name = "QTY")
	public Integer quantity;
	
	@Column(name = "UNIT_POINT")
	public Integer unitPoint;
	
	@Column(name = "MERCHANT_ID")
	public Long merchantId;
	
	@Column(name = "TID")
	public String tid;
	
	@Column(name = "APPROVAL_CODE")
	public String approvalCode;
	
	@Column(name = "FULFILMENT_DATETIME")
	public Date fulfilmentDatetime;
	
	@Column(name = "DOCKET_NO")
	public String docketNo;
	
	@Column(name = "DELIVERY_STATUS")
	public String deliveryStatus;
	
	@Column(name = "IS_PAYMENT_POSTED")
	public Boolean isPaymentPosted;
	
	@Column(name = "PAYMENT_POSTED_DATETIME")
	public Date paymentPostedDatetime;
	
	@Column(name = "CDCH_CARD_NO")
	public String cdchCardNo;
	
	@Column(name = "CDCH_POSTED_DATETIME")
	public Date cdchPostedDatetime;
	
	@Column(name="STATUS_ID")
	private Integer statusId;

	@Column(name = "CREATED_BY")
	private String createdBy;

	@Column(name = "CREATED_DATETIME")
	private Date createdDatetime;
	
	@Column(name="EDITED_BY")
	private String editedBy;

	@Column(name="EDITED_DATETIME")
	private Date editedDatetime;

	/**
	 * @return the pointTxnDetailId
	 */
	public Long getPointTxnDetailId() {
		return pointTxnDetailId;
	}

	/**
	 * @param pointTxnDetailId the pointTxnDetailId to set
	 */
	public void setPointTxnDetailId(Long pointTxnDetailId) {
		this.pointTxnDetailId = pointTxnDetailId;
	}

	/**
	 * @return the pointTxnId
	 */
	public ApPointTxn getPointTxnId() {
		return pointTxnId;
	}

	/**
	 * @param pointTxnId the pointTxnId to set
	 */
	public void setPointTxnId(ApPointTxn pointTxnId) {
		this.pointTxnId = pointTxnId;
	}

	/**
	 * @return the orderNo
	 */
	public String getOrderNo() {
		return orderNo;
	}

	/**
	 * @param orderNo the orderNo to set
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	/**
	 * @return the productId
	 */
	public Product getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(Product productId) {
		this.productId = productId;
	}

	/**
	 * @return the refProductName
	 */
	public String getRefProductName() {
		return refProductName;
	}

	/**
	 * @param refProductName the refProductName to set
	 */
	public void setRefProductName(String refProductName) {
		this.refProductName = refProductName;
	}

	/**
	 * @return the quantity
	 */
	public Integer getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the unitPoint
	 */
	public Integer getUnitPoint() {
		return unitPoint;
	}

	/**
	 * @param unitPoint the unitPoint to set
	 */
	public void setUnitPoint(Integer unitPoint) {
		this.unitPoint = unitPoint;
	}

	/**
	 * @return the merchantId
	 */
	public Long getMerchantId() {
		return merchantId;
	}

	/**
	 * @param merchantId the merchantId to set
	 */
	public void setMerchantId(Long merchantId) {
		this.merchantId = merchantId;
	}

	/**
	 * @return the tid
	 */
	public String getTid() {
		return tid;
	}

	/**
	 * @param tid the tid to set
	 */
	public void setTid(String tid) {
		this.tid = tid;
	}

	/**
	 * @return the approvalCode
	 */
	public String getApprovalCode() {
		return approvalCode;
	}

	/**
	 * @param approvalCode the approvalCode to set
	 */
	public void setApprovalCode(String approvalCode) {
		this.approvalCode = approvalCode;
	}

	/**
	 * @return the fulfilmentDatetime
	 */
	public Date getFulfilmentDatetime() {
		return fulfilmentDatetime;
	}

	/**
	 * @param fulfilmentDatetime the fulfilmentDatetime to set
	 */
	public void setFulfilmentDatetime(Date fulfilmentDatetime) {
		this.fulfilmentDatetime = fulfilmentDatetime;
	}

	/**
	 * @return the docketNo
	 */
	public String getDocketNo() {
		return docketNo;
	}

	/**
	 * @param docketNo the docketNo to set
	 */
	public void setDocketNo(String docketNo) {
		this.docketNo = docketNo;
	}

	/**
	 * @return the deliveryStatus
	 */
	public String getDeliveryStatus() {
		return deliveryStatus;
	}

	/**
	 * @param deliveryStatus the deliveryStatus to set
	 */
	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	/**
	 * @return the isPaymentPosted
	 */
	public Boolean getIsPaymentPosted() {
		return isPaymentPosted;
	}

	/**
	 * @param isPaymentPosted the isPaymentPosted to set
	 */
	public void setIsPaymentPosted(Boolean isPaymentPosted) {
		this.isPaymentPosted = isPaymentPosted;
	}

	/**
	 * @return the paymentPostedDatetime
	 */
	public Date getPaymentPostedDatetime() {
		return paymentPostedDatetime;
	}

	/**
	 * @param paymentPostedDatetime the paymentPostedDatetime to set
	 */
	public void setPaymentPostedDatetime(Date paymentPostedDatetime) {
		this.paymentPostedDatetime = paymentPostedDatetime;
	}

	/**
	 * @return the cdchCardNo
	 */
	public String getCdchCardNo() {
		return cdchCardNo;
	}

	/**
	 * @param cdchCardNo the cdchCardNo to set
	 */
	public void setCdchCardNo(String cdchCardNo) {
		this.cdchCardNo = cdchCardNo;
	}

	/**
	 * @return the cdchPostedDatetime
	 */
	public Date getCdchPostedDatetime() {
		return cdchPostedDatetime;
	}

	/**
	 * @param cdchPostedDatetime the cdchPostedDatetime to set
	 */
	public void setCdchPostedDatetime(Date cdchPostedDatetime) {
		this.cdchPostedDatetime = cdchPostedDatetime;
	}

	/**
	 * @return the statusId
	 */
	public Integer getStatusId() {
		return statusId;
	}

	/**
	 * @param statusId the statusId to set
	 */
	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the createdDatetime
	 */
	public Date getCreatedDatetime() {
		return createdDatetime;
	}

	/**
	 * @param createdDatetime the createdDatetime to set
	 */
	public void setCreatedDatetime(Date createdDatetime) {
		this.createdDatetime = createdDatetime;
	}

	/**
	 * @return the editedBy
	 */
	public String getEditedBy() {
		return editedBy;
	}

	/**
	 * @param editedBy the editedBy to set
	 */
	public void setEditedBy(String editedBy) {
		this.editedBy = editedBy;
	}

	/**
	 * @return the editedDatetime
	 */
	public Date getEditedDatetime() {
		return editedDatetime;
	}

	/**
	 * @param editedDatetime the editedDatetime to set
	 */
	public void setEditedDatetime(Date editedDatetime) {
		this.editedDatetime = editedDatetime;
	}
	
	

}
