/**
 * 
 */
package com.maybank.orsapp.repository;

import java.util.List;
import java.util.Optional;

import com.maybank.orsapp.dto.ProductDto;
import com.maybank.orsapp.dto.ProductPlasticTypeDto;
import com.maybank.orsapp.dto.ProductProgramDto;
import com.maybank.orsapp.entities.Product;

/**
 * @author 80003905
 *
 */
public interface ProductRepositoryCustom {
	
	public List<ProductDto> getAllProducts();
	
	public List<ProductDto> findProductByProductId(Long id);
	
	public List<ProductProgramDto> getProductProgramsProductById(Long productById);
	
	public List<ProductPlasticTypeDto> getProductlasticTypesProductById(Long productById);
	
	public Optional<Product> findProductByProductCode(String productCode);
	
	public Optional<Product> getProductByProductId(Long id);
	
	public Optional<Product> findProductWithPlasticTypesById(Long productId);

}
