/**
 * 
 */
package com.maybank.orsapp.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author 80003905
 *
 */

@JsonInclude(Include.NON_NULL)
public class ProductCreationDto {

	@JsonProperty
	private String responseCode;
	
	@JsonProperty
	private String responseMessage;
	
	@JsonProperty
	private List<RewardTypesDto> rewardTypeDtoList;
	
	@JsonProperty
	private List<CategoryTypeDto> categoryTypeDtoList;
	
	@JsonProperty
	private List<AirlinesDto> airlinesDto;
	
	@JsonProperty
	private List<ProgramDto> programDtoList;
	
	@JsonProperty
	private List<MerchentDTO> merchantDtoList;
	
	@JsonProperty
	private List<ProductPlasticTypeDto> plasticTypeDtoList;

	/**
	 * @return the code
	 */
	public String getResponseCode() {
		return responseCode;
	}

	/**
	 * @param code the code to set
	 */
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	/**
	 * @return the message
	 */
	public String getResponseMessage() {
		return responseMessage;
	}

	/**
	 * @param message the message to set
	 */
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	
	/**
	 * @return the rewardTypeDtoList
	 */
	public List<RewardTypesDto> getRewardTypeDtoList() {
		return rewardTypeDtoList;
	}

	/**
	 * @param rewardTypeDtoList the rewardTypeDtoList to set
	 */
	public void setRewardTypeDtoList(List<RewardTypesDto> rewardTypeDtoList) {
		this.rewardTypeDtoList = rewardTypeDtoList;
	}

	/**
	 * @return the categoryTypeDtoList
	 */
	public List<CategoryTypeDto> getCategoryTypeDtoList() {
		return categoryTypeDtoList;
	}

	/**
	 * @param categoryTypeDtoList the categoryTypeDtoList to set
	 */
	public void setCategoryTypeDtoList(List<CategoryTypeDto> categoryTypeDtoList) {
		this.categoryTypeDtoList = categoryTypeDtoList;
	}

	/**
	 * @return the airlinesDto
	 */
	public List<AirlinesDto> getAirlinesDto() {
		return airlinesDto;
	}

	/**
	 * @param airlinesDto the airlinesDto to set
	 */
	public void setAirlinesDto(List<AirlinesDto> airlinesDto) {
		this.airlinesDto = airlinesDto;
	}

	/**
	 * @return the programDtoList
	 */
	public List<ProgramDto> getProgramDtoList() {
		return programDtoList;
	}

	/**
	 * @param programDtoList the programDtoList to set
	 */
	public void setProgramDtoList(List<ProgramDto> programDtoList) {
		this.programDtoList = programDtoList;
	}

	/**
	 * @return the merchantDtoList
	 */
	public List<MerchentDTO> getMerchantDtoList() {
		return merchantDtoList;
	}

	/**
	 * @param merchantDtoList the merchantDtoList to set
	 */
	public void setMerchantDtoList(List<MerchentDTO> merchantDtoList) {
		this.merchantDtoList = merchantDtoList;
	}

	/**
	 * @return the plasticTypeDtoList
	 */
	public List<ProductPlasticTypeDto> getPlasticTypeDtoList() {
		return plasticTypeDtoList;
	}

	/**
	 * @param plasticTypeDtoList the plasticTypeDtoList to set
	 */
	public void setPlasticTypeDtoList(List<ProductPlasticTypeDto> plasticTypeDtoList) {
		this.plasticTypeDtoList = plasticTypeDtoList;
	}

}
