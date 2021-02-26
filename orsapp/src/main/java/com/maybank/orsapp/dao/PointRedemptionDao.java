/**
 * 
 */
package com.maybank.orsapp.dao;

import java.util.List;

import com.maybank.orsapp.dto.DTCardInfoDto;
import com.maybank.orsapp.dto.RewardTypesDto;
import com.maybank.orsapp.entities.Product;

/**
 * @author 80003905
 *
 */
public interface PointRedemptionDao {
	
	public List<RewardTypesDto> getRewardTypesForPointRedemption();
	
	public List<Product> getProductsForRewardTypeId(Long rewardTypeId);

	public List<DTCardInfoDto> getPointsBalForRewardTypeIdAndIcNo(Long rewardTypeId, String customerIcNo);

	public List<DTCardInfoDto> getPointsBalForRewardTypeIdAndCustomerCreditCardNo(Long rewardTypeId, String customerCreditCardNo);

	public List<DTCardInfoDto> getPointsBalForRewardTypeIdAndCustomerDebitCardNo(Long rewardTypeId, String customerDebitCardNo);

}
