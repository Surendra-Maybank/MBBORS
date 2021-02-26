/**
 * 
 */
package com.maybank.orsapp.service;

import com.maybank.orsapp.controller.response.ProductResponse;
import com.maybank.orsapp.dto.ProductCreationDto;
import com.maybank.orsapp.dto.ProductDto;
import com.maybank.orsapp.dto.ResponseMessageDto;

/**
 * @author 80003905
 *
 */
public interface ProductService {
	
	public ProductCreationDto getInfoToCreateProduct();
	
	public ProductCreationDto getAirlines();

	public ProductCreationDto getCategoryTypes();

	public ProductCreationDto getPrograms();
	
	public ProductResponse getAllProducts();

	public ProductResponse getProduct(Long id);
	
	public ResponseMessageDto saveProduct(ProductDto productDto);
	
	public ResponseMessageDto updateProduct(ProductDto productDto);
	
	public ResponseMessageDto deleteProduct(Long productId);
	
	public ProductCreationDto getAllRewardTypes();
	
	public ProductCreationDto getAllMerchants();
	
	public ProductCreationDto getAllPlasticTypes();

}
