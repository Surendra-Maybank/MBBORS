/**
 * 
 */
package com.maybank.orsapp.repository;

import java.util.List;

import com.maybank.orsapp.dto.ProductPlasticTypeDto;

/**
 * @author 80003905
 *
 */
public interface PlasticTypeRepositoryCustom {
	
	List<ProductPlasticTypeDto> findAllActivePlasticTypes();

}
