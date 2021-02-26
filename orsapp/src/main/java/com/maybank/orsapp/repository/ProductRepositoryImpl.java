/**
 * 
 */
package com.maybank.orsapp.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.maybank.orsapp.dto.ProductDto;
import com.maybank.orsapp.dto.ProductPlasticTypeDto;
import com.maybank.orsapp.dto.ProductProgramDto;
import com.maybank.orsapp.entities.Product;

/**
 * @author 80003905
 *
 */

@Repository
public class ProductRepositoryImpl implements ProductRepositoryCustom {
	
	@PersistenceContext
	@Qualifier("entityManager")
    EntityManager entityManager;
	
	public EntityManager getEntityManager() {
	    return entityManager;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductDto> getAllProducts() {
		
		List<ProductDto> result = null;
    	
    	StringBuilder getAllProducts = new StringBuilder("SELECT "
				    			+ " NEW com.maybank.orsapp.dto.ProductDto(p.id, p.productCode, p.productName, p.unitPoint, p.merchantCost, p.actualProductCost, p.statusId, "
				    			+ " m.merchant_name, p.productQuantity, programs.programCode, p.validStartDate, p.validEndDate, ct.categoryTypeDesc, a.airlinesDescription, "
				    			+ " p.creditAmount, p.debitAmount, p.conversionPoint, p.remarks, p.createdBy, p.createdDateTime, p.editedBy, p.editedDateTime) "
				    			+ " FROM Product p "
				    			+ " INNER JOIN ProductProgram pp ON p.id = pp.productId "
				    			+ " LEFT OUTER JOIN Merchant m ON m.merchant_id = p.merchantId "
				    			+ " LEFT OUTER JOIN Programs programs ON pp.programId = programs.id "
				    			+ " INNER JOIN CategoryTypes ct ON ct.id = p.categoryTypeId "
				    			+ " LEFT OUTER JOIN Airlines a ON a.id = p.airlinesId "
				    			+ " WHERE p.statusId !=:statusId ");

    	Query query = getEntityManager().createQuery(getAllProducts.toString());
        query.setParameter("statusId", 2);
        
        result = query.getResultList();
        if(!CollectionUtils.isEmpty(result)) {
        	return result;
        }
		return Collections.emptyList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductDto> findProductByProductId(Long id) {
		List<ProductDto> result = null;
    	
    	StringBuilder getAllProducts = new StringBuilder("SELECT "
				    			+ " NEW com.maybank.orsapp.dto.ProductDto(p.id, p.productCode, p.productName, p.unitPoint, p.merchantCost, p.actualProductCost, "
				    			+ " p.productQuantity, m.merchant_id, m.merchant_name, p.validStartDate, p.validEndDate, "
				    			+ " ct.id, ct.categoryTypeDesc, a.id, a.airlinesDescription, p.isPremiumRedemption, "
				    			+ " p.creditAmount, p.debitAmount, p.conversionPoint, p.remarks, p.statusId, p.createdBy, p.createdDateTime, p.editedBy, p.editedDateTime) "
				    			+ " FROM Product p "
				    			+ " INNER JOIN ProductProgram pp ON p.id = pp.productId "
				    			+ " LEFT OUTER JOIN Merchant m ON m.merchant_id = p.merchantId "
				    			//+ " LEFT OUTER JOIN Programs programs ON pp.programId = programs.id "
				    			+ " INNER JOIN CategoryTypes ct ON ct.id = p.categoryTypeId "
				    			//+ " INNER JOIN ProductPlasticType ppt ON ppt.productId = p.id "
				    			+ " LEFT OUTER JOIN Airlines a ON a.id = p.airlinesId "
				    			+ " WHERE p.statusId !=:statusId ");

    	if(id != null) {
    		getAllProducts.append(" AND p.id=:id");
    	}
    	
    	Query query = getEntityManager().createQuery(getAllProducts.toString());
        query.setParameter("statusId", 2);
        if(id != null) {
        	query.setParameter("id", id);
    	}
        result = query.getResultList();
        if(!CollectionUtils.isEmpty(result)) {
        	return result;
        }
		return Collections.emptyList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductProgramDto> getProductProgramsProductById(Long productById) {
		
		List<ProductProgramDto> result = null;
    	
    	StringBuilder getAllProducts = new StringBuilder("SELECT "
				    			+ " NEW com.maybank.orsapp.dto.ProductProgramDto(pp.id, programs.id, programs.programCode, programs.programDesc) "
				    			+ " FROM Product p "
				    			+ " INNER JOIN ProductProgram pp ON p.id = pp.productId "
				    			+ " INNER JOIN Programs programs ON pp.programId = programs.id "
				    			+ " WHERE pp.statusId !=:statusId AND p.id=:id ");

    	Query query = getEntityManager().createQuery(getAllProducts.toString());
        query.setParameter("statusId", 2);
        query.setParameter("id", productById);
        
        result = query.getResultList();
        
        if(!CollectionUtils.isEmpty(result)) {
        	return result;
        }
		return Collections.emptyList();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductPlasticTypeDto> getProductlasticTypesProductById(Long productById) {
		List<ProductPlasticTypeDto> result = null;
    	
    	StringBuilder getAllProducts = new StringBuilder("SELECT "
				    			+ " NEW com.maybank.orsapp.dto.ProductPlasticTypeDto(ppt.id, pt.id, pt.plasticTypeCode, pt.plasticTypeDesc) "
				    			+ " FROM Product p "
				    			+ " INNER JOIN ProductPlasticType ppt ON ppt.productId = p.id "
				    			+ " INNER JOIN PlasticType pt ON ppt.plasticTypeId = pt.id "
				    			+ " WHERE ppt.statusId !=:statusId AND p.id=:id ");

    	Query query = getEntityManager().createQuery(getAllProducts.toString());
        query.setParameter("statusId", 2);
        query.setParameter("id", productById);
        
        result = query.getResultList();
        
        if(!CollectionUtils.isEmpty(result)) {
        	return result;
        }
		return Collections.emptyList();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public Optional<Product> findProductByProductCode(String productCode) {
		
		List<Product> result = new ArrayList<>();
		List<Integer> status = new ArrayList<>();
    	status.add(1);
    	status.add(3);
    	
		Query query = getEntityManager().createQuery("SELECT p FROM Product p WHERE p.statusId in (:status) AND p.productCode =:productCode");
        query.setParameter("status", status);
        query.setParameter("productCode", productCode);
        result = query.getResultList();
        if(!CollectionUtils.isEmpty(result)) {
        	return Optional.ofNullable(result.get(0));
        }
		return Optional.empty();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Optional<Product> getProductByProductId(Long id) {
		
		List<Product> result = new ArrayList<>();
		List<Integer> status = new ArrayList<>();
    	status.add(1);
    	status.add(3);
    
		Query query = getEntityManager().createQuery("FROM Product p LEFT JOIN FETCH p.productPrograms pp WHERE p.statusId in (:status) AND p.id =:id");
        query.setParameter("status", status);
        query.setParameter("id", id);
        result = query.getResultList();
        if(!CollectionUtils.isEmpty(result)) {
        	return Optional.ofNullable(result.get(0));
        }
		return Optional.empty();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Optional<Product> findProductWithPlasticTypesById(Long productId) {
		List<Product> result = new ArrayList<>();
		List<Integer> status = new ArrayList<>();
    	status.add(1);
    	status.add(3);
    
		Query query = getEntityManager().createQuery("FROM Product p LEFT JOIN FETCH p.productPlasticTypes plt WHERE p.statusId in (:status) AND p.id =:productId");
        query.setParameter("status", status);
        query.setParameter("productId", productId);
        result = query.getResultList();
        if(!CollectionUtils.isEmpty(result)) {
        	return Optional.ofNullable(result.get(0));
        }
		return Optional.empty();
	}
}
