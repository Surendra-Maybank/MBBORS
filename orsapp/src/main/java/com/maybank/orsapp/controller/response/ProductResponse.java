/**
 * 
 */
package com.maybank.orsapp.controller.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.maybank.orsapp.dto.ProductDto;

/**
 * @author 80003905
 *
 */

@JsonInclude(Include.NON_NULL)
public class ProductResponse {

	@JsonProperty
	private String responseCode;
	
	@JsonProperty
	private String responseMessage;
	
	@JsonProperty
	private ProductDto productDto;
	
	@JsonProperty
	private List<ProductDto> listOfActiveProducts;

	/**
	 * @return the responseCode
	 */
	public String getResponseCode() {
		return responseCode;
	}

	/**
	 * @param responseCode the responseCode to set
	 */
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	/**
	 * @return the responseMessage
	 */
	public String getResponseMessage() {
		return responseMessage;
	}

	/**
	 * @param responseMessage the responseMessage to set
	 */
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	/**
	 * @return the productDto
	 */
	public ProductDto getProductDto() {
		return productDto;
	}

	/**
	 * @param productDto the productDto to set
	 */
	public void setProductDto(ProductDto productDto) {
		this.productDto = productDto;
	}

	/**
	 * @return the listOfActiveProducts
	 */
	public List<ProductDto> getListOfActiveProducts() {
		return listOfActiveProducts;
	}

	/**
	 * @param listOfActiveProducts the listOfActiveProducts to set
	 */
	public void setListOfActiveProducts(List<ProductDto> listOfActiveProducts) {
		this.listOfActiveProducts = listOfActiveProducts;
	}
	
	
	
}
