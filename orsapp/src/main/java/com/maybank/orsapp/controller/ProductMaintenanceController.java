/**
 * 
 */
package com.maybank.orsapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maybank.orsapp.controller.response.ProductResponse;
import com.maybank.orsapp.dto.ProductDto;
import com.maybank.orsapp.dto.ResponseMessageDto;
import com.maybank.orsapp.service.ProductService;

/**
 * @author 80003905
 *
 */

@RestController
@RequestMapping("/")
public class ProductMaintenanceController {
	
	@Autowired
	ProductService productService;
	
	@PreAuthorize("hasRole('PRODUCT_VIEW')")
	@GetMapping("/GetAllProductList")
	public ResponseEntity<ProductResponse> getAllActiveProducts(){
		return ResponseEntity.ok(productService.getAllProducts());		
	}
	
	@PreAuthorize("hasRole('PRODUCT_VIEW')")
	@GetMapping("/GetProductById/{productId}")
	public ResponseEntity<ProductResponse> getProductByProductId(@PathVariable("productId") Long productId){
		return ResponseEntity.ok(productService.getProduct(productId));
	}
	
	@PreAuthorize("hasRole('PRODUCT_ADD')")
	@PostMapping("/CreateProduct")
	public ResponseEntity<ResponseMessageDto> createProduct(@RequestBody ProductDto productDto){
		return ResponseEntity.ok(productService.saveProduct(productDto));
	}
	
	@PreAuthorize("hasRole('PRODUCT_EDIT')")
	@PutMapping("/UpdateProduct")
	public ResponseEntity<ResponseMessageDto> updateProduct(@RequestBody ProductDto productDto){
		return ResponseEntity.ok(productService.updateProduct(productDto));
	}
	
	@PreAuthorize("hasRole('PRODUCT_DELETE')")
	@DeleteMapping("/DeleteProduct/{productId}")
	public ResponseEntity<ResponseMessageDto> deleteProduct(@PathVariable("productId") Long productId){
		return ResponseEntity.ok(productService.deleteProduct(productId));
	}
	
}
