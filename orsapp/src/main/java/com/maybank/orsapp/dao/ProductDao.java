/**
 * 
 */
package com.maybank.orsapp.dao;

import java.util.List;

import com.maybank.orsapp.dto.AirlinesDto;
import com.maybank.orsapp.dto.CategoryTypeDto;
import com.maybank.orsapp.dto.ProductDto;
import com.maybank.orsapp.dto.ProgramDto;

/**
 * @author 80003905
 *
 */


public interface ProductDao {
	
	public List<CategoryTypeDto> getAllActiveCategoryTypes();
	
	public List<AirlinesDto> getAllActiveAirlines();
	
	public List<ProgramDto> getAllActivePrograms();
	
	public List<ProductDto> getAllActiveProducts();

}
