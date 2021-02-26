/**
 * 
 */
package com.maybank.orsapp.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.maybank.orsapp.controller.response.PointInquiryResponse;
import com.maybank.orsapp.dto.CardHolderPointBucketDto;
import com.maybank.orsapp.dto.CardsDTO;
import com.maybank.orsapp.entities.CardHolder;
import com.maybank.orsapp.entities.TierRate;
import com.maybank.orsapp.enums.StatusCodes;
import com.maybank.orsapp.repository.CardHolderPointBucketRepositoryImpl;
import com.maybank.orsapp.repository.CardHolderRepository;
import com.maybank.orsapp.repository.TierRateRepository;
import com.maybank.orsapp.service.PointInquiryService;

/**
 * @author 80003905
 *
 */

@Service
public class PointInquiryServiceImpl implements PointInquiryService {
	
	Logger logger = LoggerFactory.getLogger(PointInquiryServiceImpl.class);
	
	@Autowired
	CardHolderPointBucketRepositoryImpl cardHolderPointBucketRepositoryImpl;
	
	@Autowired
	TierRateRepository tierRateRepository;
	
	@Autowired
	CardHolderRepository cardHolderRepository;

	@Override
	public PointInquiryResponse pointInquiryForIcNo(String customerIcNo) {
		PointInquiryResponse pointInquiryResponse = new PointInquiryResponse();
		try {
			List<CardHolderPointBucketDto> cardInfoList = cardHolderPointBucketRepositoryImpl.pointInquiryResponseForIcNo(customerIcNo, null);			
			if(CollectionUtils.isEmpty(cardInfoList)) {
				pointInquiryResponse.setResponseCode("14");
				pointInquiryResponse.setResponseMessage("Invalid IC No");
			}else {
				Optional<CardHolder> cardHolder = cardHolderRepository.findCardHolderByIcNo(StatusCodes.valueOf("ACTIVE").getStatusCode(), customerIcNo);
				pointInquiryResponse = getPointInquiryDetails(cardInfoList, cardHolder);
				
			}
		}catch(Exception e) {
			pointInquiryResponse.setResponseCode("96");
			pointInquiryResponse.setResponseMessage("System Error");
			logger.error(e.getMessage());
			e.printStackTrace();
		}	
		return pointInquiryResponse;
	}

	@Override
	public PointInquiryResponse pointInquiryForCardNo(String customerCardNo) {
		PointInquiryResponse pointInquiryResponse = new PointInquiryResponse();
		try {
			List<CardHolderPointBucketDto> creditCardInfoList = cardHolderPointBucketRepositoryImpl.pointInquiryResponseForCustomerCreditCardNo(customerCardNo, Boolean.FALSE);
			if(CollectionUtils.isEmpty(creditCardInfoList)) {
				List<CardHolderPointBucketDto> debitCardInfoList = cardHolderPointBucketRepositoryImpl.pointInquiryResponseForCustomerDebitCardNo(customerCardNo, Boolean.FALSE);
				if(CollectionUtils.isEmpty(debitCardInfoList)) {
					pointInquiryResponse.setResponseCode("14");
					pointInquiryResponse.setResponseMessage("Invalid Card Number");
				}else {
					Optional<String> customerIcNo = debitCardInfoList.stream()
														   .filter(cardInfo -> cardInfo != null && cardInfo.getCardNo() != null && cardInfo.getCardNo().equalsIgnoreCase(customerCardNo))
														   .map(CardHolderPointBucketDto::getCustIcNo).findAny();
					Optional<CardHolder> cardHolder = cardHolderRepository.findCardHolderByIcNo(StatusCodes.valueOf("ACTIVE").getStatusCode(), customerIcNo.get());
					pointInquiryResponse = getPointInquiryDetails(debitCardInfoList, cardHolder);
				}				
			}else {
				Optional<String> customerIcNo = creditCardInfoList.stream()
													   .filter(cardInfo -> cardInfo != null && cardInfo.getCardNo() != null && cardInfo.getCardNo().equalsIgnoreCase(customerCardNo))
													   .map(CardHolderPointBucketDto::getCustIcNo).findAny();
				Optional<CardHolder> cardHolder = cardHolderRepository.findCardHolderByIcNo(StatusCodes.valueOf("ACTIVE").getStatusCode(), customerIcNo.get());
				pointInquiryResponse = getPointInquiryDetails(creditCardInfoList, cardHolder);
			}
		}catch(Exception e) {
			pointInquiryResponse.setResponseCode("96");
			pointInquiryResponse.setResponseMessage("System Error");
			logger.error(e.getMessage());
			e.printStackTrace();
		}	
		return pointInquiryResponse;
	}
	
	private PointInquiryResponse getPointInquiryDetails(List<CardHolderPointBucketDto> cardInfoList, Optional<CardHolder> cardHolder) {
		List<CardsDTO> userCardsList = getUserCardsList(cardInfoList);
		//Map<String, List<CardHolderPointBucketDto>> mapCardInfo = groupByProgramDesc(cardInfoList);
		//Map<String, BigDecimal> sum = mapTotalPointsBal(mapCardInfo);
		
		PointInquiryResponse pointInquiryResponse = new PointInquiryResponse();
		pointInquiryResponse.setResponseCode("00");
		pointInquiryResponse.setResponseMessage("Success");
		if(cardHolder.isPresent()) {
			pointInquiryResponse.setCustomerIcNumber(cardHolder.get().getCustIcNo().trim());
			pointInquiryResponse.setCustomerName(cardHolder.get().getFirstName().concat(" ").concat(cardHolder.get().getLastName()).trim());
		}
		pointInquiryResponse.setCardInfoList(userCardsList);
		//pointInquiryResponse.setSumOfTotalPointsBalance(sum);
		//pointInquiryResponse.setCardInfoList(mapCardInfo);
		
		return pointInquiryResponse;
	}
	
	private List<CardsDTO> getUserCardsList(List<CardHolderPointBucketDto> cardInfoList){
		List<CardsDTO> userCardsList = new ArrayList<>();
		Map<String, List<CardHolderPointBucketDto>> mapCardInfo = groupByProgramDesc(cardInfoList);
	    Iterator<Map.Entry<String, List<CardHolderPointBucketDto>>> iterator = mapCardInfo.entrySet().iterator();
	    while (iterator.hasNext()) {
	        Map.Entry<String, List<CardHolderPointBucketDto>> entry = iterator.next();
	        CardsDTO cardsDTO = new CardsDTO();
	        cardsDTO.setProgramCodeDesc(entry.getKey());
	        cardsDTO.setUserCardsList(entry.getValue());
	        cardsDTO.setSumOfTotalPointsBalance(sumOfTotalPointsBalForPostingFlag(entry.getValue()));
	        userCardsList.add(cardsDTO);
	    }
		return userCardsList;
	}

	@Override
	public PointInquiryResponse pointInquiryForTerminal(String customerCardNo) {
		PointInquiryResponse pointInquiryResponse = new PointInquiryResponse();
		try {
			List<CardHolderPointBucketDto> creditCardInfoList = cardHolderPointBucketRepositoryImpl.pointInquiryResponseForCustomerCreditCardNo(customerCardNo, Boolean.TRUE);
			if(CollectionUtils.isEmpty(creditCardInfoList)) {
				List<CardHolderPointBucketDto> debitCardInfoList = cardHolderPointBucketRepositoryImpl.pointInquiryResponseForCustomerDebitCardNo(customerCardNo, Boolean.TRUE);
				if(CollectionUtils.isEmpty(debitCardInfoList)) {
					pointInquiryResponse.setResponseCode("14");
					pointInquiryResponse.setResponseMessage("Invalid Card Number");
				}else {
					Map<String, List<CardHolderPointBucketDto>> mapCardInfo = groupByPostFlag(debitCardInfoList);
					pointInquiryResponse = terminalPointInquiryResponse(mapCardInfo);
				}				
			}else {
				Map<String, List<CardHolderPointBucketDto>> mapCardInfo = groupByPostFlag(creditCardInfoList);
				pointInquiryResponse = terminalPointInquiryResponse(mapCardInfo);
			}
		}catch(Exception e) {
			pointInquiryResponse.setResponseCode("96");
			pointInquiryResponse.setResponseMessage("System Error");
			logger.error(e.getMessage());
			e.printStackTrace();
		}	
		return pointInquiryResponse;
	}
	
	private Map<String, BigDecimal> mapTotalPointsBal(Map<String, List<CardHolderPointBucketDto>> mapCardInfo){
		Map<String, BigDecimal> finalMappedAndSortedCardInfoList = new HashMap<>();
	    Iterator<Map.Entry<String, List<CardHolderPointBucketDto>>> iterator = mapCardInfo.entrySet().iterator();
	    while (iterator.hasNext()) {
	        Map.Entry<String, List<CardHolderPointBucketDto>> entry = iterator.next();
	        finalMappedAndSortedCardInfoList.put(entry.getKey(), sumOfTotalPointsBalForPostingFlag(entry.getValue()));
	    }
	    
	    return finalMappedAndSortedCardInfoList;
	}

	private Map<String, List<CardHolderPointBucketDto>> groupByProgramDesc(List<CardHolderPointBucketDto> cardInfoList){
		Map<String, List<CardHolderPointBucketDto>> groupCardInfoListByProgramDesc = cardInfoList.stream()
				  														.collect(Collectors.groupingBy(CardHolderPointBucketDto::getProgramDesc));
		
		return sortedCardInfoForProgramDesc(groupCardInfoListByProgramDesc);
	}
	
	private Map<String, List<CardHolderPointBucketDto>> sortedCardInfoForProgramDesc(Map<String, List<CardHolderPointBucketDto>> map) {
		Map<String, List<CardHolderPointBucketDto>> finalMappedAndSortedCardInfoList = new HashMap<>();
	    Iterator<Map.Entry<String, List<CardHolderPointBucketDto>>> iterator = map.entrySet().iterator();
	    while (iterator.hasNext()) {
	        Map.Entry<String, List<CardHolderPointBucketDto>> entry = iterator.next();
	        finalMappedAndSortedCardInfoList.put(entry.getKey(), sortByCardNoToAscOrder(entry.getValue()));
	    }
	    
	    return finalMappedAndSortedCardInfoList;
	}
	
	private List<CardHolderPointBucketDto> sortByCardNoToAscOrder(List<CardHolderPointBucketDto> cardInfoList) {
		
		Set<CardHolderPointBucketDto> cardoInfoSet = cardInfoList.stream().distinct().collect(Collectors.toSet());
		return cardoInfoSet.stream().collect(Collectors.toList()).stream().sorted(Comparator.comparing(CardHolderPointBucketDto::getCardNo))
			      					.collect(Collectors.toList());
	}
	
	private Map<String, List<CardHolderPointBucketDto>> groupByPostFlag(List<CardHolderPointBucketDto> cardInfoList){
		return cardInfoList.stream().collect(Collectors.groupingBy(CardHolderPointBucketDto::getCardPostFlag));
		
	}
	
	private PointInquiryResponse terminalPointInquiryResponse(Map<String, List<CardHolderPointBucketDto>> cardInfoList) {
		PointInquiryResponse pointInquiry = new PointInquiryResponse();
		pointInquiry.setResponseCode("00");
		pointInquiry.setResponseMessage("Success");
		BigDecimal totalPointsBalForPP = sumOfTotalPointsBalForPostingFlag(cardInfoList.get("PP"));
		BigDecimal totalPointsBalForSP = sumOfTotalPointsBalForPostingFlag(cardInfoList.get("SP"));
		BigDecimal totalPointsBalForXX = sumOfTotalPointsBalForPostingFlag(cardInfoList.get("XX"));
		BigDecimal totalPointsBal = totalPointsBalForPP.add(totalPointsBalForSP).add(totalPointsBalForXX);
		Optional<TierRate> optionalTierRate = tierRateRepository.findTierRateById(new BigDecimal(1));
		BigDecimal conversionValue = BigDecimal.ZERO;
		if(optionalTierRate.isPresent()) {
			conversionValue = optionalTierRate.get().getConversion_rate();
		}
		BigDecimal totalEquivalentRMValue = totalPointsBal.multiply(conversionValue);
		//System.out.println(totalEquivalentRMValue);
		pointInquiry.setTotalPointsBalForPP(numberFormat(totalPointsBalForPP.add(totalPointsBalForXX)));
		pointInquiry.setTotalPointsBalForSP(numberFormat(totalPointsBalForSP));
		pointInquiry.setTotalPointsBal(numberFormat(totalPointsBal));
		pointInquiry.setTotalEquivalentRMValue(numberFormat(totalEquivalentRMValue));
		return pointInquiry;
	}
	
	private BigDecimal sumOfTotalPointsBalForPostingFlag(List<CardHolderPointBucketDto> cardInfoList) {
		if(CollectionUtils.isEmpty(cardInfoList))
			return BigDecimal.ZERO;
		else {
			Double sumOfTotalPointsBalForPostingFlag = cardInfoList.stream()
																   .filter(cardInfo -> cardInfo != null && cardInfo.getPointsBal() != null && cardInfo.getPointsBal() >= 0)
																   .mapToDouble(CardHolderPointBucketDto::getPointsBal)
																   .sum();
			return BigDecimal.valueOf(sumOfTotalPointsBalForPostingFlag);
		}
	}
	
	private String numberFormat(BigDecimal value) {
		Double x = value.doubleValue() * 100;
		BigDecimal b = new BigDecimal(x).setScale(2, RoundingMode.HALF_DOWN);
		String cs = String.format("%012d", b.setScale(0, RoundingMode.HALF_UP).intValue());
		return cs;
	}
}
