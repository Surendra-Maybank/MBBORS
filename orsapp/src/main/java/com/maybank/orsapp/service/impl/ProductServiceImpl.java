/**
 * 
 */
package com.maybank.orsapp.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.maybank.orsapp.controller.response.ProductResponse;
import com.maybank.orsapp.dao.PointRedemtionDaoImpl;
import com.maybank.orsapp.dao.ProductDao;
import com.maybank.orsapp.dto.AirlinesDto;
import com.maybank.orsapp.dto.CategoryTypeDto;
import com.maybank.orsapp.dto.MerchentDTO;
import com.maybank.orsapp.dto.ProductCreationDto;
import com.maybank.orsapp.dto.ProductDto;
import com.maybank.orsapp.dto.ProductPlasticTypeDto;
import com.maybank.orsapp.dto.ProductProgramDto;
import com.maybank.orsapp.dto.ProgramDto;
import com.maybank.orsapp.dto.ResponseMessageDto;
import com.maybank.orsapp.dto.RewardTypesDto;
import com.maybank.orsapp.entities.Product;
import com.maybank.orsapp.entities.ProductPlasticType;
import com.maybank.orsapp.entities.ProductProgram;
import com.maybank.orsapp.exceptions.RequestDataValidationException;
import com.maybank.orsapp.repository.MerchantRepositoryCustomImpl;
import com.maybank.orsapp.repository.PlasticTypeRepositoryImpl;
import com.maybank.orsapp.repository.ProductRepository;
import com.maybank.orsapp.repository.ProductRepositoryImpl;
import com.maybank.orsapp.service.ProductService;
import com.maybank.orsapp.utils.TimeStampConversion;

/**
 * @author 80003905
 *
 */

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	ProductRepositoryImpl productRepositoryImpl;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	PointRedemtionDaoImpl pointRedemptionDao;
	
	@Autowired
	MerchantRepositoryCustomImpl merchantRepositoryCustomImpl;
	
	@Autowired
	PlasticTypeRepositoryImpl plasticTypeRepository;

	@Override
	public ProductCreationDto getInfoToCreateProduct() {
		
		ProductCreationDto productCreationDto = new ProductCreationDto();
		List<CategoryTypeDto> activeCategoryTypes = productDao.getAllActiveCategoryTypes();
		if(!CollectionUtils.isEmpty(activeCategoryTypes)) {
			productCreationDto.setCategoryTypeDtoList(activeCategoryTypes);
		}
		List<AirlinesDto> activeAirlines = productDao.getAllActiveAirlines();
		if(!CollectionUtils.isEmpty(activeAirlines)) {
			productCreationDto.setAirlinesDto(activeAirlines);
		}
		List<ProgramDto> activePrograms = productDao.getAllActivePrograms();
		if(!CollectionUtils.isEmpty(activePrograms)) {
			productCreationDto.setProgramDtoList(activePrograms);
		}
		
		Boolean validateProductCreation = validateProductCreationDto(productCreationDto);
		if(validateProductCreation.equals(Boolean.TRUE)) {
			productCreationDto.setResponseCode("00");
			productCreationDto.setResponseMessage("Success");
		}
		else {
			productCreationDto.setResponseCode("01");
			productCreationDto.setResponseMessage("No Active Records found");
		}
		return productCreationDto;
	}
	
	private Boolean validateProductCreationDto(ProductCreationDto productCreationDto) {
		if(!CollectionUtils.isEmpty(productCreationDto.getCategoryTypeDtoList())) {
			return Boolean.TRUE;
		}
		else if(!CollectionUtils.isEmpty(productCreationDto.getAirlinesDto())) {
			return Boolean.TRUE;
		}
		else if(!CollectionUtils.isEmpty(productCreationDto.getProgramDtoList())) {
			return Boolean.TRUE;
		}
		else return Boolean.FALSE;
	}
	
	

	@Override
	public ProductCreationDto getAllRewardTypes() {
		ProductCreationDto productCreationDto = new ProductCreationDto();
		List<RewardTypesDto> rewardTypeList = pointRedemptionDao.getRewardTypesForPointRedemption();
		if(!CollectionUtils.isEmpty(rewardTypeList)) {
			productCreationDto.setResponseCode("00");
			productCreationDto.setResponseMessage("Success");
			productCreationDto.setRewardTypeDtoList(rewardTypeList);
		}else {
			productCreationDto.setResponseCode("00");
			productCreationDto.setResponseMessage("No Active Records found");
		}
		return productCreationDto;
	}

	@Override
	public ProductCreationDto getAirlines() {
		ProductCreationDto productCreationDto = new ProductCreationDto();
		List<AirlinesDto> activeAirlines = productDao.getAllActiveAirlines();
		if(!CollectionUtils.isEmpty(activeAirlines)) {
			productCreationDto.setResponseCode("00");
			productCreationDto.setResponseMessage("Success");
			productCreationDto.setAirlinesDto(activeAirlines);
		}else {
			productCreationDto.setResponseCode("01");
			productCreationDto.setResponseMessage("No Active Records found");
		}
		
		return productCreationDto;
	}
	
	@Override
	public ProductCreationDto getCategoryTypes() {
		ProductCreationDto productCreationDto = new ProductCreationDto();
		List<CategoryTypeDto> activeCategoryTypes = productDao.getAllActiveCategoryTypes();
		if(!CollectionUtils.isEmpty(activeCategoryTypes)) {
			productCreationDto.setCategoryTypeDtoList(activeCategoryTypes);
			productCreationDto.setResponseCode("00");
			productCreationDto.setResponseMessage("Success");
		}else {
			productCreationDto.setResponseCode("01");
			productCreationDto.setResponseMessage("No Active Records found");
		}
		
		return productCreationDto;
	}
	
	@Override
	public ProductCreationDto getPrograms() {
		ProductCreationDto productCreationDto = new ProductCreationDto();
		List<ProgramDto> activePrograms = productDao.getAllActivePrograms();
		if(!CollectionUtils.isEmpty(activePrograms)) {
			productCreationDto.setProgramDtoList(activePrograms);
			productCreationDto.setResponseCode("00");
			productCreationDto.setResponseMessage("Success");
		}else {
			productCreationDto.setResponseCode("01");
			productCreationDto.setResponseMessage("No Active Records found");
		}
		
		return productCreationDto;
	}

	@Override
	public ProductResponse getAllProducts() {
		ProductResponse productResponse = new ProductResponse();
		try {
			List<ProductDto> productList = productRepositoryImpl.getAllProducts();
			//productDao.getAllActiveProducts();
			//productRepositoryImpl.getAllProducts(null);
			List<ProductDto> targetList = getProducts(productList);
			if(CollectionUtils.isEmpty(targetList)) {
				productResponse.setResponseCode("01");
				productResponse.setResponseMessage("No Products Found");
			}else {
				productResponse.setResponseCode("00");
				productResponse.setResponseMessage("Success");
				productResponse.setListOfActiveProducts(targetList);
			}
		}catch(Exception e) {
			productResponse.setResponseCode("01");
			productResponse.setResponseMessage("SYSTEM_ERROR");
			e.printStackTrace();
		}
        return productResponse;
	}
	
	private List<ProductDto> getProducts(List<ProductDto> productList){
		List<ProductDto> listOfProducts = new ArrayList<>();
		Map<Long, List<ProductDto>> mapById = productList.stream().collect(Collectors.groupingBy(ProductDto::getProductId));
		Iterator<Entry<Long, List<ProductDto>>> iterator = mapById.entrySet().iterator();
		while (iterator.hasNext()) {
	        Map.Entry<Long, List<ProductDto>> entry = iterator.next();
	        ProductDto productDto = mapById.get(entry.getKey()).get(0);
	        List<String> programs = getProgramList(mapById.get(entry.getKey()));
	        productDto.setProgramCodes(String.join(",", programs));
	        listOfProducts.add(productDto);
	    }
		
		return listOfProducts;
	}
	
	private List<String> getProgramList(List<ProductDto> productList){
		return productList.stream().map(p ->p.getRewardType()).collect(Collectors.toList());
	}

	@Override
	public ProductResponse getProduct(Long id) {
		ProductResponse productResponse = new ProductResponse();
		try {
			List<ProductDto> productList = productRepositoryImpl.findProductByProductId(id);
			//List<ProductDto> targetList = getProducts(productList);
			if(CollectionUtils.isEmpty(productList)) {
				productResponse.setResponseCode("01");
				productResponse.setResponseMessage("No Active Products Found");
			}else {
				productResponse.setResponseCode("00");
				productResponse.setResponseMessage("Success");
				ProductDto productDto = productList.get(0);
				
				List<ProductProgramDto> productProgramDtos = productRepositoryImpl.getProductProgramsProductById(id);
				if(!CollectionUtils.isEmpty(productProgramDtos))
					productDto.setProductProgramDtos(productProgramDtos);
				
				List<ProductPlasticTypeDto> productPlasticTypeDtos = productRepositoryImpl.getProductlasticTypesProductById(id);
				if(!CollectionUtils.isEmpty(productPlasticTypeDtos))
					productDto.setListOfSelectedPlasticTypes(productPlasticTypeDtos);
				
				productResponse.setProductDto(productDto);
			}
		}catch(Exception e) {
			productResponse.setResponseCode("01");
			productResponse.setResponseMessage("SYSTEM_ERROR");
			e.printStackTrace();
		}
        return productResponse;
	}

	@Override
	public ResponseMessageDto saveProduct(ProductDto productDto) {		
		//ProductMaintenanceHelper.validateRequest(productDto);
		ResponseMessageDto responseMessage = new ResponseMessageDto();
		Optional<Product> productCode = productRepositoryImpl.findProductByProductCode(productDto.getProductCode());
		if(productCode.isPresent()) {
			throw new RequestDataValidationException("Product with product code " + productDto.getProductCode() + " already exists");
		}else {
			try {
				Product product = productDtoToProductMapping(null, productDto, Boolean.TRUE);
				productRepository.save(product);				
				responseMessage.setResponseCode("00");
				responseMessage.setResponseMessage("Success");
			}catch(Exception e) {
				e.printStackTrace();
				responseMessage.setResponseCode("01");
				responseMessage.setResponseMessage("Error while creating Product");
			}
		}
		return responseMessage;
	}
	
	@Override
	public ResponseMessageDto updateProduct(ProductDto productDto) {
		
		ResponseMessageDto responseMessage = new ResponseMessageDto();
		Optional<Product> optionalProduct = productRepositoryImpl.getProductByProductId(productDto.getProductId());
		try {
			if(optionalProduct.isPresent()) {
				Product product = productDtoToProductMapping(optionalProduct.get(), productDto, Boolean.FALSE);
				productRepository.save(product);
				responseMessage.setResponseCode("00");
				responseMessage.setResponseMessage("Success");
			}else {
				responseMessage.setResponseCode("02");
				responseMessage.setResponseMessage("Product doesnot exist");
			}
		}catch(Exception e) {
			e.printStackTrace();
			responseMessage.setResponseCode("01");
			responseMessage.setResponseMessage("Error while updating Product");
		}
		return responseMessage;
	}

	private Product productDtoToProductMapping(Product product, ProductDto productDto, Boolean isCreate) {
		TimeStampConversion dateConversion = new TimeStampConversion();
		if(isCreate) {
			product = new Product();
			product.setStatusId(1);
			product.setCreatedBy("Logged In User");
			product.setCreatedDateTime(new Timestamp(System.currentTimeMillis()));
		}else {
			product.setStatusId(productDto.getStatusDesc().getStatusCode());
		}
		product.setProductCode(productDto.getProductCode());
		product.setProductName(productDto.getProductName());
		product.setUnitPoint(productDto.getUnitPoint());
		product.setActualProductCost(productDto.getActualProductCost());
		product.setMerchantCost(productDto.getMerchantCost());
		product.setMerchantId(productDto.getMerchantId());
		product.setProductQuantity(productDto.getProductQuantity());
		product.setValidStartDate(new Timestamp(dateConversion.dateTime(productDto.getValidStartDate()).getTime()));
		product.setValidEndDate(new Timestamp(dateConversion.dateTime(productDto.getValidEndDate()).getTime()));
		product.setCategoryTypeId(productDto.getCategoryTypeId());
		product.setAirlinesId(productDto.getAirlinesId());
		product.setCreditAmount(productDto.getCreditAmount());
		product.setDebitAmount(productDto.getDebitAmount());
		product.setConversionPoint(productDto.getConversionPoint());
		product.setRemarks(productDto.getRemarks());
		product.setIsPremiumRedemption(productDto.getIsPremiumRedemption());
		product.setEditedBy("Logged In User");
		product.setEditedDateTime(new Timestamp(System.currentTimeMillis()));
		if(isCreate) {
			List<ProductProgram> productProgramList = createProductPrograms(productDto.getProductProgramDtos(), product);
	        if(CollectionUtils.isEmpty(productProgramList)) {
	        	product.setProductPrograms(Collections.emptyList());
	        }else {
	        	product.setProductPrograms(productProgramList);
	        }
	        List<ProductPlasticType> productPlasticTypeList = createProductPlasticTypes(productDto.getListOfSelectedPlasticTypes(), product);
	        if(CollectionUtils.isEmpty(productPlasticTypeList)) {
	        	product.setProductPlasticTypes(Collections.emptyList());
	        }else {
	        	product.setProductPlasticTypes(productPlasticTypeList);
	        }
		}else {
			List<ProductProgram> productProgramList = getUpdatedProductProgram(product.getProductPrograms(), productDto.getProductProgramDtos(), product);
	        if(CollectionUtils.isEmpty(productProgramList)) {
	        	product.setProductPrograms(Collections.emptyList());
	        }else {
	        	product.setProductPrograms(productProgramList);
	        }
	        Optional<Product> optionalProductWithPlasticType = productRepositoryImpl.findProductWithPlasticTypesById(product.getId());
	        if(optionalProductWithPlasticType.isPresent()) {
	        	List<ProductPlasticType> productPlasticTypeList = getUpdatedProductPlasticTypes(optionalProductWithPlasticType.get().getProductPlasticTypes(), productDto.getListOfSelectedPlasticTypes(), product);
		        if(CollectionUtils.isEmpty(productPlasticTypeList)) {
		        	product.setProductPlasticTypes(Collections.emptyList());
		        }else {
		        	product.setProductPlasticTypes(productPlasticTypeList);
		        }
	        }
	        
		}
        return product;
	}
	
	private List<ProductProgram> createProductPrograms(List<ProductProgramDto> productProgramDtoList, Product product){
		List<ProductProgram> productProgramList = new ArrayList<>();
        for(ProductProgramDto productPrograms : productProgramDtoList) {
        	ProductProgram productProgram = new ProductProgram();
        	productProgram.setProgramId(productPrograms.getProgramId());
        	productProgram.setProductId(product);
        	productProgram.setStatusId(1);
        	productProgram.setCreatedBy("Logged In User");
        	productProgram.setCreatedDateTime(new Timestamp(System.currentTimeMillis()));
        	productProgram.setEditedBy("Logged In User");
        	productProgram.setEditedDateTime(new Timestamp(System.currentTimeMillis()));        	
        	productProgramList.add(productProgram);
        }
		return productProgramList;
	}
	
	private List<ProductPlasticType> createProductPlasticTypes(List<ProductPlasticTypeDto> productPlasticTypeDtoList, Product product){
		List<ProductPlasticType> productPlasticTypeList = new ArrayList<>();
        for(ProductPlasticTypeDto productPlasticTypeDtos : productPlasticTypeDtoList) {
        	ProductPlasticType productPlasticType = new ProductPlasticType();
        	productPlasticType.setPlasticTypeId(productPlasticTypeDtos.getPlasticTypeId());
        	productPlasticType.setProductId(product);
        	productPlasticType.setStatusId(1);
        	productPlasticType.setCreatedBy("Logged In User");
        	productPlasticType.setCreatedDateTime(new Timestamp(System.currentTimeMillis()));
        	productPlasticType.setEditedBy("Logged In User");
        	productPlasticType.setEditedDateTime(new Timestamp(System.currentTimeMillis()));        	
        	productPlasticTypeList.add(productPlasticType);
        }
		return productPlasticTypeList;
	}
	
	private List<ProductProgram> getUpdatedProductProgram(List<ProductProgram> oldProductProgramList, List<ProductProgramDto> newProductProgramList, Product product){
		ProductProgram productProgram = null;
		List<ProductProgram> updatedProductProgramList = new ArrayList<>();
		List<ProductProgram> removedProductPrograms = new ArrayList<>(oldProductProgramList);
		for(ProductProgramDto newProductProgram : newProductProgramList) {
			Optional<ProductProgram> matchingObject = oldProductProgramList.stream()
																		   .filter(p -> p.getProgramId().equals(newProductProgram.getProgramId())).findAny();
			if(matchingObject.isPresent()) {
				productProgram = matchingObject.get();
				productProgram.setStatusId(product.getStatusId());
				removedProductPrograms.remove(productProgram);
			}else {
				productProgram = new ProductProgram();	
				productProgram.setProgramId(newProductProgram.getProgramId());
				productProgram.setStatusId(product.getStatusId());
				productProgram.setCreatedBy("Logged In User");
				productProgram.setCreatedDateTime(new Timestamp(System.currentTimeMillis()));       					
			}
			
			productProgram.setProductId(product);
			productProgram.setEditedBy("Logged In User");
			productProgram.setEditedDateTime(new Timestamp(System.currentTimeMillis())); 
			updatedProductProgramList.add(productProgram);
		}
		
		updatedProductProgramList.addAll(removedOldProductPrograms(removedProductPrograms));
		return updatedProductProgramList;
	}
	
	private List<ProductProgram> removedOldProductPrograms(List<ProductProgram> oldProductProgramList){
		ProductProgram productProgram = null;
		List<ProductProgram> updatedProductProgramList = new ArrayList<>();
		for(ProductProgram oldProductProgram : oldProductProgramList) {
			productProgram = oldProductProgram;	
			productProgram.setStatusId(2);
			productProgram.setEditedBy("Logged In User");
			productProgram.setEditedDateTime(new Timestamp(System.currentTimeMillis()));
			updatedProductProgramList.add(productProgram);
		}
		return updatedProductProgramList;
	}
	
	private List<ProductPlasticType> getUpdatedProductPlasticTypes(List<ProductPlasticType> oldProductPlasticTypeList, List<ProductPlasticTypeDto> newProductPlasticTypeDtoList, Product product){
		ProductPlasticType productPlasticType = null;
		List<ProductPlasticType> updatedProductPlasticTypeList = new ArrayList<>();
		List<ProductPlasticType> removedProductPlasticTypes = new ArrayList<>(oldProductPlasticTypeList);
		for(ProductPlasticTypeDto newProductPlasticType : newProductPlasticTypeDtoList) {
			Optional<ProductPlasticType> matchingObject = oldProductPlasticTypeList.stream()
																		   .filter(p -> p.getPlasticTypeId().equals(newProductPlasticType.getPlasticTypeId())).findAny();
			if(matchingObject.isPresent()) {
				productPlasticType = matchingObject.get();
				productPlasticType.setStatusId(product.getStatusId());
				removedProductPlasticTypes.remove(productPlasticType);
			}else {
				productPlasticType = new ProductPlasticType();	
				productPlasticType.setPlasticTypeId(newProductPlasticType.getPlasticTypeId());
				productPlasticType.setStatusId(product.getStatusId());
				productPlasticType.setCreatedBy("Logged In User");
				productPlasticType.setCreatedDateTime(new Timestamp(System.currentTimeMillis()));       					
			}			
			productPlasticType.setProductId(product);
			productPlasticType.setEditedBy("Logged In User");
			productPlasticType.setEditedDateTime(new Timestamp(System.currentTimeMillis())); 
			updatedProductPlasticTypeList.add(productPlasticType);
		}
		
		updatedProductPlasticTypeList.addAll(removedOldProductPlasticTypes(removedProductPlasticTypes));
		return updatedProductPlasticTypeList;
	}
	
	private List<ProductPlasticType> removedOldProductPlasticTypes(List<ProductPlasticType> oldProductPlasticTypeList){
		ProductPlasticType productPlasticType = null;
		List<ProductPlasticType> updatedProductPlasticTypeList = new ArrayList<>();
		for(ProductPlasticType oldProductPlasticType : oldProductPlasticTypeList) {
			productPlasticType = oldProductPlasticType;	
			productPlasticType.setStatusId(2);
			productPlasticType.setEditedBy("Logged In User");
			productPlasticType.setEditedDateTime(new Timestamp(System.currentTimeMillis()));
			updatedProductPlasticTypeList.add(productPlasticType);
		}
		return updatedProductPlasticTypeList;
	}

	@Override
	public ResponseMessageDto deleteProduct(Long productId) {
		ResponseMessageDto responseMessage = new ResponseMessageDto();
		Optional<Product> optionalProduct = productRepositoryImpl.getProductByProductId(productId);
		try {
			if(optionalProduct.isPresent()) {
				Product product = optionalProduct.get();
				product.setStatusId(2);
				product.setEditedBy("Logged In User");
				product.setEditedDateTime(new Timestamp(System.currentTimeMillis())); 
				List<ProductProgram> productProgramList = removedOldProductPrograms(product.getProductPrograms());
		        if(CollectionUtils.isEmpty(productProgramList)) {
		        	product.setProductPrograms(Collections.emptyList());
		        }else {
		        	product.setProductPrograms(productProgramList);
		        }
		        Optional<Product> optionalProductWithPlasticType = productRepositoryImpl.findProductWithPlasticTypesById(productId);
		        if(optionalProductWithPlasticType.isPresent()) {
		        	List<ProductPlasticType> productPlasticTypes = removedOldProductPlasticTypes(optionalProductWithPlasticType.get().getProductPlasticTypes());
			        if(CollectionUtils.isEmpty(productPlasticTypes)) {
			        	product.setProductPlasticTypes(Collections.emptyList());
			        }else {
			        	product.setProductPlasticTypes(productPlasticTypes);
			        }
		        }
				productRepository.save(product);
				responseMessage.setResponseCode("00");
				responseMessage.setResponseMessage("Success");
			}else {
				responseMessage.setResponseCode("02");
				responseMessage.setResponseMessage("Product doesnot exist");
			}
		}catch(Exception e) {
			responseMessage.setResponseCode("01");
			responseMessage.setResponseMessage("Error while deleting Product");
		}
		return responseMessage;
	}

	@Override
	public ProductCreationDto getAllMerchants() {
		ProductCreationDto productCreationDto = new ProductCreationDto();
		try {
			List<MerchentDTO> merchantList = merchantRepositoryCustomImpl.getAllActiveMerchant();
			if(CollectionUtils.isEmpty(merchantList)) {
				productCreationDto.setResponseCode("01");
				productCreationDto.setResponseMessage("No Active Merchants Found");
			}else {
				productCreationDto.setResponseCode("00");
				productCreationDto.setResponseMessage("Success");
				productCreationDto.setMerchantDtoList(merchantList);
			}
		}catch(Exception e) {
			productCreationDto.setResponseCode("01");
			productCreationDto.setResponseMessage("SYSTEM_ERROR");
			e.printStackTrace();
		}
        return productCreationDto;
	}

	@Override
	public ProductCreationDto getAllPlasticTypes() {
		ProductCreationDto productCreationDto = new ProductCreationDto();
		try {
			List<ProductPlasticTypeDto> plasticTypeDtos = plasticTypeRepository.findAllActivePlasticTypes();
			if(CollectionUtils.isEmpty(plasticTypeDtos)) {
				productCreationDto.setResponseCode("01");
				productCreationDto.setResponseMessage("No Active PlasticTypes Found");
			}else {
				productCreationDto.setResponseCode("00");
				productCreationDto.setResponseMessage("Success");
				productCreationDto.setPlasticTypeDtoList(plasticTypeDtos);
			}
		}catch(Exception e) {
			productCreationDto.setResponseCode("01");
			productCreationDto.setResponseMessage("SYSTEM_ERROR");
			e.printStackTrace();
		}
        return productCreationDto;
	}
	
}
