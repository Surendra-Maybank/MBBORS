/**
 * 
 */
package com.maybank.orsapp.dto;

import java.math.BigDecimal;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author 80003905
 *
 */
public class MerchentDTO {
	
	@JsonProperty
	private BigDecimal merchant_id;
	
	@JsonProperty
	private String mid;
	
	@JsonProperty
	private String merchant_name;

	/**
	 * 
	 */
	public MerchentDTO() {
		
	}

	/**
	 * @param merchant_id
	 * @param mid
	 * @param merchant_name
	 */
	public MerchentDTO(BigDecimal merchant_id, String mid, String merchant_name) {
		this.merchant_id = merchant_id;
		this.mid = mid;
		this.merchant_name = merchant_name;
	}

	/**
	 * @return the merchant_id
	 */
	public BigDecimal getMerchant_id() {
		return merchant_id;
	}

	/**
	 * @param merchant_id the merchant_id to set
	 */
	public void setMerchant_id(BigDecimal merchant_id) {
		this.merchant_id = merchant_id;
	}

	/**
	 * @return the mid
	 */
	public String getMid() {
		return mid;
	}

	/**
	 * @param mid the mid to set
	 */
	public void setMid(String mid) {
		this.mid = mid;
	}

	/**
	 * @return the merchant_name
	 */
	public String getMerchant_name() {
		return merchant_name;
	}

	/**
	 * @param merchant_name the merchant_name to set
	 */
	public void setMerchant_name(String merchant_name) {
		this.merchant_name = merchant_name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(merchant_id, merchant_name, mid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MerchentDTO other = (MerchentDTO) obj;
		return Objects.equals(merchant_id, other.merchant_id) && Objects.equals(merchant_name, other.merchant_name)
				&& Objects.equals(mid, other.mid);
	}

	@Override
	public String toString() {
		return "MerchentDTO [merchant_id=" + merchant_id + ", mid=" + mid + ", merchant_name=" + merchant_name + "]";
	}
	
	

}
