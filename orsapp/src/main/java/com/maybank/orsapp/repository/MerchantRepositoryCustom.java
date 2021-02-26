package com.maybank.orsapp.repository;

import java.math.BigDecimal;
import java.util.List;

import com.maybank.orsapp.dto.MerchantAllDTO;
import com.maybank.orsapp.dto.MerchantDTO;
import com.maybank.orsapp.dto.MerchantDetailDTO;
import com.maybank.orsapp.dto.MerchentDTO;
import com.maybank.orsapp.entities.Merchant;

public interface MerchantRepositoryCustom {

	public List<MerchantAllDTO> getAllMerchant();
	
	public MerchantDetailDTO getMerchantDetailByMerchantId(BigDecimal merchantId);
	
	public Merchant getMerchantByMid(String mid);
	
	public int deleteMerchantByMerchantId(BigDecimal merchantId, String username);
	
	int updateMerchantByMerchantId(Merchant merchant, String username);
	
	public BigDecimal getMerchantIdByMid(String mid);
	
	public List<MerchentDTO> getAllActiveMerchant();	

}
