/**
 * 
 */
package com.maybank.orsapp.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "mt_PRODUCT_PLASTIC_TYPE")
public class ProductPlasticType {
	
	@Id
	@Column(name = "PRODUCT_PLASTIC_TYPE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)		    		  
	private Long id;
	
	@Column(name = "PLASTIC_TYPE_ID")
	private Long plasticTypeId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="PRODUCT_ID", referencedColumnName = "PRODUCT_ID")
	private Product productId;
	
	@Column(name = "STATUS_ID")
	private Integer statusId;

	@Column(name = "CREATED_BY")
	private String createdBy;

	@Column(name = "CREATED_DATETIME")
	private Timestamp createdDateTime;

	@Column(name = "EDITED_BY")
	private String editedBy;

	@Column(name = "EDITED_DATETIME")
	private Timestamp editedDateTime;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the plasticTypeId
	 */
	public Long getPlasticTypeId() {
		return plasticTypeId;
	}

	/**
	 * @param plasticTypeId the plasticTypeId to set
	 */
	public void setPlasticTypeId(Long plasticTypeId) {
		this.plasticTypeId = plasticTypeId;
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
	 * @return the createdDateTime
	 */
	public Timestamp getCreatedDateTime() {
		return createdDateTime;
	}

	/**
	 * @param createdDateTime the createdDateTime to set
	 */
	public void setCreatedDateTime(Timestamp createdDateTime) {
		this.createdDateTime = createdDateTime;
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
	 * @return the editedDateTime
	 */
	public Timestamp getEditedDateTime() {
		return editedDateTime;
	}

	/**
	 * @param editedDateTime the editedDateTime to set
	 */
	public void setEditedDateTime(Timestamp editedDateTime) {
		this.editedDateTime = editedDateTime;
	}
	
	

}
