package com.maybank.orsapp.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.maybank.orsapp.controller.request.VoidRedeemRequest;
import com.maybank.orsapp.dao.VoidRedemptionDao;
import com.maybank.orsapp.dto.MTCardHolderPointBucketDTO;
import com.maybank.orsapp.dto.ResponseMessageDto;
import com.maybank.orsapp.entities.ApPointTxnBucketDetails;
import com.maybank.orsapp.repository.ApPointTxnRepository;
import com.maybank.orsapp.repository.CardHolderPointBucketRepositoryCustom;
import com.maybank.orsapp.service.VoidRedemptionService;

@Service
public class VoidRedemptionServiceImpl implements VoidRedemptionService {
	
	Logger logger = LoggerFactory.getLogger(VoidRedemptionServiceImpl.class);
	
	@Autowired
	ApPointTxnRepository apPointTxnRepository;
	
	@Autowired
	VoidRedemptionDao voidRedemptionDao;
	
	@Autowired
	CardHolderPointBucketRepositoryCustom cardHolderPointBucketRepository;

	@Override
	@Transactional
	public ResponseMessageDto voidRedemption(VoidRedeemRequest request) {
		
		ResponseMessageDto responseMessageDto = new ResponseMessageDto();
		if(StringUtils.isBlank(request.getReversalReason())) {
			responseMessageDto.setResponseCode("01");
			responseMessageDto.setResponseMessage("Reversal Reason is mandatory");
    		return responseMessageDto;
    	}
		
		Long pointTxnId = request.getPointTxnId();
		try {
			List<ApPointTxnBucketDetails> apPointTxnBucketDetailsList = apPointTxnRepository.getPointTxnBucketDetailsForVoidRedemption(pointTxnId);
			if(CollectionUtils.isEmpty(apPointTxnBucketDetailsList)) {
				responseMessageDto.setResponseCode("01");
				responseMessageDto.setResponseMessage("Invalid Point Txn Id");
			}else {
				List<MTCardHolderPointBucketDTO> cardHolderPointBucketList = cardHolderPointBucketRepository.getPointBucketDetailsForVoidRedemption(pointTxnId);
				if(CollectionUtils.isEmpty(cardHolderPointBucketList)) {
					responseMessageDto.setResponseCode("01");
					responseMessageDto.setResponseMessage("Invalid Card List");
				}else {
					List<String> programCode = new ArrayList<>();
					List<MTCardHolderPointBucketDTO> cardBucketDetailsList = new ArrayList<>();
					programCode.add("00001");
					programCode.add("00002");
					for(ApPointTxnBucketDetails apPointTxnBucketDetails : apPointTxnBucketDetailsList) {
						
						BigDecimal pointBucketId = new BigDecimal(apPointTxnBucketDetails.getCardHolderPointBucketId());
						Optional<MTCardHolderPointBucketDTO> cardBucketDetails = cardHolderPointBucketList.stream()
																										 .filter(mtCardHolderPointBucketDTO -> 
																										 		 mtCardHolderPointBucketDTO.getCardholderPointBucketId().equals(pointBucketId))
																										 .findAny();
						
						if(cardBucketDetails.isPresent()) {
							
							MTCardHolderPointBucketDTO voidCardBucketDetails = null;
							
							if(programCode.contains(apPointTxnBucketDetails.getProgramCode())) {
								voidCardBucketDetails = voidPointBucket36List(cardBucketDetails.get(), apPointTxnBucketDetails);
							}
							else {
								voidCardBucketDetails = voidPointsFrom01stBucket(cardBucketDetails.get(), apPointTxnBucketDetails);
							}
							
							if(voidCardBucketDetails != null) {
								cardBucketDetailsList.add(voidCardBucketDetails);
							}
						}
						
					}
					
					for(MTCardHolderPointBucketDTO voidCardBucketDetails : cardBucketDetailsList) {
						updateCardHolderPointBucketDetails(voidCardBucketDetails);
					}
					
					voidRedemptionDao.updateApPointTxn(pointTxnId, request.getReversalReason());
					responseMessageDto.setResponseCode("00");
					responseMessageDto.setResponseMessage("Success");
				}
			}
		}catch(Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			responseMessageDto.setResponseCode("99");
			responseMessageDto.setResponseMessage("SYSTEM_ERROR");
		}
		return responseMessageDto;
	}
	
	private void updateCardHolderPointBucketDetails(MTCardHolderPointBucketDTO voidCardBucketDetails) {
		
		MTCardHolderPointBucketDTO newBucket = voidCardBucketDetails;

		voidRedemptionDao.updateCardBucket(newBucket.getTotalPointsSign(), newBucket.getTotalPointsBal(), newBucket.getTotalPointsBal().setScale(0, RoundingMode.FLOOR), 
				newBucket.getBucket01PointSign(), newBucket.getBucket01PointBal(), newBucket.getBucket02PointSign(), newBucket.getBucket02PointBal(), newBucket.getBucket03PointSign(), newBucket.getBucket03PointBal(), 
				newBucket.getBucket04PointSign(), newBucket.getBucket04PointBal(), newBucket.getBucket05PointSign(), newBucket.getBucket05PointBal(), newBucket.getBucket06PointSign(), newBucket.getBucket06PointBal(), 
				newBucket.getBucket07PointSign(), newBucket.getBucket07PointBal(), newBucket.getBucket08PointSign(), newBucket.getBucket08PointBal(), newBucket.getBucket09PointSign(), newBucket.getBucket09PointBal(), 
				newBucket.getBucket10PointSign(), newBucket.getBucket10PointBal(), newBucket.getBucket11PointSign(), newBucket.getBucket11PointBal(), newBucket.getBucket12PointSign(), newBucket.getBucket12PointBal(), 
				newBucket.getBucket13PointSign(), newBucket.getBucket13PointBal(), newBucket.getBucket14PointSign(), newBucket.getBucket14PointBal(), newBucket.getBucket15PointSign(), newBucket.getBucket15PointBal(), 
				newBucket.getBucket16PointSign(), newBucket.getBucket16PointBal(), newBucket.getBucket17PointSign(), newBucket.getBucket17PointBal(), newBucket.getBucket18PointSign(), newBucket.getBucket18PointBal(), 
				newBucket.getBucket19PointSign(), newBucket.getBucket19PointBal(), newBucket.getBucket20PointSign(), newBucket.getBucket20PointBal(), newBucket.getBucket21PointSign(), newBucket.getBucket21PointBal(), 
				newBucket.getBucket22PointSign(), newBucket.getBucket22PointBal(), newBucket.getBucket23PointSign(), newBucket.getBucket23PointBal(), newBucket.getBucket24PointSign(), newBucket.getBucket24PointBal(), 
				newBucket.getBucket25PointSign(), newBucket.getBucket25PointBal(), newBucket.getBucket26PointSign(), newBucket.getBucket26PointBal(), newBucket.getBucket27PointSign(), newBucket.getBucket27PointBal(), 
				newBucket.getBucket28PointSign(), newBucket.getBucket28PointBal(), newBucket.getBucket29PointSign(), newBucket.getBucket29PointBal(), newBucket.getBucket30PointSign(), newBucket.getBucket30PointBal(), 
				newBucket.getBucket31PointSign(), newBucket.getBucket31PointBal(), newBucket.getBucket32PointSign(), newBucket.getBucket32PointBal(), newBucket.getBucket33PointSign(), newBucket.getBucket33PointBal(), 
				newBucket.getBucket34PointSign(), newBucket.getBucket34PointBal(), newBucket.getBucket35PointSign(), newBucket.getBucket35PointBal(), newBucket.getBucket36PointSign(), newBucket.getBucket36PointBal(), 
				"SYSTEM_USER", newBucket.getCardholderPointBucketId());
	}
	
	private MTCardHolderPointBucketDTO voidPointBucket36List(MTCardHolderPointBucketDTO cardBucketDetail, ApPointTxnBucketDetails apPointTxnBucketDetails){
		
		MTCardHolderPointBucketDTO cardBucketDetails = cardBucketDetail;
		BigDecimal totalPointsBal = BigDecimal.ZERO;
				
		logger.info("******************************************************** ");
		logger.info("Card Holder Point Bucket Details Before Void Redemption: " + cardBucketDetails.toString());
		logger.info("******************************************************** ");
		
		//36th Bucket 
		if(apPointTxnBucketDetails.getBucket36PointRedeemed() != null && apPointTxnBucketDetails.getBucket36PointRedeemed().compareTo(BigDecimal.ZERO) > 0) {
			if(cardBucketDetails.getBucket36PointBal() != null) {
				if(cardBucketDetails.getBucket36PointSign() != null) {
					String pointsString = cardBucketDetails.getBucket36PointSign().concat(cardBucketDetails.getBucket36PointBal().toString());
					BigDecimal bucket36Points = apPointTxnBucketDetails.getBucket36PointRedeemed().add(new BigDecimal(pointsString));
					if(bucket36Points.compareTo(BigDecimal.ZERO) >= 0) {
						cardBucketDetails.setBucket36PointBal(bucket36Points);
						cardBucketDetails.setBucket36PointSign("+");
					}else {						
						cardBucketDetails.setBucket36PointBal(bucket36Points.abs());
						cardBucketDetails.setBucket36PointSign("-");
					}
				}
				
			}
		}
		
		//35th Bucket 
		if(apPointTxnBucketDetails.getBucket35PointRedeemed() != null && apPointTxnBucketDetails.getBucket35PointRedeemed().compareTo(BigDecimal.ZERO) > 0) {
			if(cardBucketDetails.getBucket35PointBal() != null) {
				if(cardBucketDetails.getBucket35PointSign() != null) {
					String pointsString = cardBucketDetails.getBucket35PointSign().concat(cardBucketDetails.getBucket35PointBal().toString());
					BigDecimal bucket35Points = apPointTxnBucketDetails.getBucket35PointRedeemed().add(new BigDecimal(pointsString));
					if(bucket35Points.compareTo(BigDecimal.ZERO) >= 0) {
						cardBucketDetails.setBucket35PointBal(bucket35Points);
						cardBucketDetails.setBucket35PointSign("+");
					}else {						
						cardBucketDetails.setBucket35PointBal(bucket35Points.abs());
						cardBucketDetails.setBucket35PointSign("-");
					}
				}
			}
		}
		
		//34th Bucket 
		if(apPointTxnBucketDetails.getBucket34PointRedeemed() != null && apPointTxnBucketDetails.getBucket34PointRedeemed().compareTo(BigDecimal.ZERO) > 0) {
			if(cardBucketDetails.getBucket34PointBal() != null) {
				if(cardBucketDetails.getBucket34PointSign() != null) {
					String pointsString = cardBucketDetails.getBucket34PointSign().concat(cardBucketDetails.getBucket34PointBal().toString());
					BigDecimal bucket34Points = apPointTxnBucketDetails.getBucket34PointRedeemed().add(new BigDecimal(pointsString));
					if(bucket34Points.compareTo(BigDecimal.ZERO) >= 0) {
						cardBucketDetails.setBucket34PointBal(bucket34Points);
						cardBucketDetails.setBucket34PointSign("+");
					}else {						
						cardBucketDetails.setBucket34PointBal(bucket34Points.abs());
						cardBucketDetails.setBucket34PointSign("-");
					}
				}
			}
		}
		
		//33th Bucket 
		if(apPointTxnBucketDetails.getBucket33PointRedeemed() != null && apPointTxnBucketDetails.getBucket33PointRedeemed().compareTo(BigDecimal.ZERO) > 0) {
			if(cardBucketDetails.getBucket33PointBal() != null) {
				if(cardBucketDetails.getBucket33PointSign() != null) {
					String pointsString = cardBucketDetails.getBucket33PointSign().concat(cardBucketDetails.getBucket33PointBal().toString());
					BigDecimal bucket33Points = apPointTxnBucketDetails.getBucket33PointRedeemed().add(new BigDecimal(pointsString));
					if(bucket33Points.compareTo(BigDecimal.ZERO) >= 0) {
						cardBucketDetails.setBucket33PointBal(bucket33Points);
						cardBucketDetails.setBucket33PointSign("+");
					}else {						
						cardBucketDetails.setBucket33PointBal(bucket33Points.abs());
						cardBucketDetails.setBucket33PointSign("-");
					}
				}
			}
		}
		
		//32th Bucket 
		if(apPointTxnBucketDetails.getBucket32PointRedeemed() != null && apPointTxnBucketDetails.getBucket32PointRedeemed().compareTo(BigDecimal.ZERO) > 0) {
			if(cardBucketDetails.getBucket32PointBal() != null) {
				if(cardBucketDetails.getBucket32PointSign() != null) {
					String pointsString = cardBucketDetails.getBucket32PointSign().concat(cardBucketDetails.getBucket32PointBal().toString());
					BigDecimal bucket32Points = apPointTxnBucketDetails.getBucket32PointRedeemed().add(new BigDecimal(pointsString));
					if(bucket32Points.compareTo(BigDecimal.ZERO) >= 0) {
						cardBucketDetails.setBucket32PointBal(bucket32Points);
						cardBucketDetails.setBucket32PointSign("+");
					}else {						
						cardBucketDetails.setBucket32PointBal(bucket32Points.abs());
						cardBucketDetails.setBucket32PointSign("-");
					}
				}
			}
		}
		
		//31th Bucket 
		if(apPointTxnBucketDetails.getBucket31PointRedeemed() != null && apPointTxnBucketDetails.getBucket31PointRedeemed().compareTo(BigDecimal.ZERO) > 0) {
			if(cardBucketDetails.getBucket31PointBal() != null) {
				if(cardBucketDetails.getBucket31PointSign() != null) {
					String pointsString = cardBucketDetails.getBucket31PointSign().concat(cardBucketDetails.getBucket31PointBal().toString());
					BigDecimal bucket31Points = apPointTxnBucketDetails.getBucket31PointRedeemed().add(new BigDecimal(pointsString));
					if(bucket31Points.compareTo(BigDecimal.ZERO) >= 0) {
						cardBucketDetails.setBucket31PointBal(bucket31Points);
						cardBucketDetails.setBucket31PointSign("+");
					}else {						
						cardBucketDetails.setBucket31PointBal(bucket31Points.abs());
						cardBucketDetails.setBucket31PointSign("-");
					}
				}
			}
		}
		
		//30th Bucket 
		if(apPointTxnBucketDetails.getBucket30PointRedeemed() != null && apPointTxnBucketDetails.getBucket30PointRedeemed().compareTo(BigDecimal.ZERO) > 0) {
			if(cardBucketDetails.getBucket30PointBal() != null) {
				if(cardBucketDetails.getBucket30PointSign() != null) {
					String pointsString = cardBucketDetails.getBucket30PointSign().concat(cardBucketDetails.getBucket30PointBal().toString());
					BigDecimal bucket30Points = apPointTxnBucketDetails.getBucket30PointRedeemed().add(new BigDecimal(pointsString));
					if(bucket30Points.compareTo(BigDecimal.ZERO) >= 0) {
						cardBucketDetails.setBucket30PointBal(bucket30Points);
						cardBucketDetails.setBucket30PointSign("+");
					}else {						
						cardBucketDetails.setBucket30PointBal(bucket30Points.abs());
						cardBucketDetails.setBucket30PointSign("-");
					}					
				}
			}
		}
		
		//29th Bucket 
		if(apPointTxnBucketDetails.getBucket29PointRedeemed() != null && apPointTxnBucketDetails.getBucket29PointRedeemed().compareTo(BigDecimal.ZERO) > 0) {
			if(cardBucketDetails.getBucket29PointBal() != null) {
				if(cardBucketDetails.getBucket29PointSign() != null) {
					String pointsString = cardBucketDetails.getBucket29PointSign().concat(cardBucketDetails.getBucket29PointBal().toString());
					BigDecimal bucket29Points = apPointTxnBucketDetails.getBucket29PointRedeemed().add(new BigDecimal(pointsString));
					if(bucket29Points.compareTo(BigDecimal.ZERO) >= 0) {
						cardBucketDetails.setBucket29PointBal(bucket29Points);
						cardBucketDetails.setBucket29PointSign("+");
					}else {						
						cardBucketDetails.setBucket29PointBal(bucket29Points.abs());
						cardBucketDetails.setBucket29PointSign("-");
					}
				}
			}
		}
		
		//28th Bucket 
		if(apPointTxnBucketDetails.getBucket28PointRedeemed() != null && apPointTxnBucketDetails.getBucket28PointRedeemed().compareTo(BigDecimal.ZERO) > 0) {
			if(cardBucketDetails.getBucket28PointBal() != null) {
				if(cardBucketDetails.getBucket28PointSign() != null) {
					String pointsString = cardBucketDetails.getBucket28PointSign().concat(cardBucketDetails.getBucket28PointBal().toString());
					BigDecimal bucket28Points = apPointTxnBucketDetails.getBucket28PointRedeemed().add(new BigDecimal(pointsString));
					if(bucket28Points.compareTo(BigDecimal.ZERO) >= 0) {
						cardBucketDetails.setBucket28PointBal(bucket28Points);
						cardBucketDetails.setBucket28PointSign("+");
					}else {						
						cardBucketDetails.setBucket28PointBal(bucket28Points.abs());
						cardBucketDetails.setBucket28PointSign("-");
					}
				}
			}
		}
		
		//27th Bucket 
		if(apPointTxnBucketDetails.getBucket27PointRedeemed() != null && apPointTxnBucketDetails.getBucket27PointRedeemed().compareTo(BigDecimal.ZERO) > 0) {
			if(cardBucketDetails.getBucket27PointBal() != null) {
				if(cardBucketDetails.getBucket27PointSign() != null) {
					String pointsString = cardBucketDetails.getBucket27PointSign().concat(cardBucketDetails.getBucket27PointBal().toString());
					BigDecimal bucket27Points = apPointTxnBucketDetails.getBucket27PointRedeemed().add(new BigDecimal(pointsString));
					if(bucket27Points.compareTo(BigDecimal.ZERO) >= 0) {
						cardBucketDetails.setBucket27PointBal(bucket27Points);
						cardBucketDetails.setBucket27PointSign("+");
					}else {						
						cardBucketDetails.setBucket27PointBal(bucket27Points.abs());
						cardBucketDetails.setBucket27PointSign("-");
					}
				}
			}
		}
		
		//26th Bucket 
		if(apPointTxnBucketDetails.getBucket26PointRedeemed() != null && apPointTxnBucketDetails.getBucket26PointRedeemed().compareTo(BigDecimal.ZERO) > 0) {
			if(cardBucketDetails.getBucket26PointBal() != null) {
				if(cardBucketDetails.getBucket26PointSign() != null) {
					String pointsString = cardBucketDetails.getBucket26PointSign().concat(cardBucketDetails.getBucket26PointBal().toString());
					BigDecimal bucket26Points = apPointTxnBucketDetails.getBucket26PointRedeemed().add(new BigDecimal(pointsString));
					if(bucket26Points.compareTo(BigDecimal.ZERO) >= 0) {
						cardBucketDetails.setBucket26PointBal(bucket26Points);
						cardBucketDetails.setBucket26PointSign("+");
					}else {						
						cardBucketDetails.setBucket26PointBal(bucket26Points.abs());
						cardBucketDetails.setBucket26PointSign("-");
					}
				}
			}
		}
		
		//25th Bucket 
		if(apPointTxnBucketDetails.getBucket25PointRedeemed() != null && apPointTxnBucketDetails.getBucket25PointRedeemed().compareTo(BigDecimal.ZERO) > 0) {
			if(cardBucketDetails.getBucket25PointBal() != null) {
				if(cardBucketDetails.getBucket25PointSign() != null) {
					String pointsString = cardBucketDetails.getBucket25PointSign().concat(cardBucketDetails.getBucket25PointBal().toString());
					BigDecimal bucket25Points = apPointTxnBucketDetails.getBucket25PointRedeemed().add(new BigDecimal(pointsString));
					if(bucket25Points.compareTo(BigDecimal.ZERO) >= 0) {
						cardBucketDetails.setBucket25PointBal(bucket25Points);
						cardBucketDetails.setBucket25PointSign("+");
					}else {						
						cardBucketDetails.setBucket25PointBal(bucket25Points.abs());
						cardBucketDetails.setBucket25PointSign("-");
					}
				}
			}
		}

		//24th Bucket 
		if(apPointTxnBucketDetails.getBucket24PointRedeemed() != null && apPointTxnBucketDetails.getBucket24PointRedeemed().compareTo(BigDecimal.ZERO) > 0) {
			if(cardBucketDetails.getBucket24PointBal() != null) {
				if(cardBucketDetails.getBucket24PointSign() != null) {
					String pointsString = cardBucketDetails.getBucket24PointSign().concat(cardBucketDetails.getBucket24PointBal().toString());
					BigDecimal bucket24Points = apPointTxnBucketDetails.getBucket24PointRedeemed().add(new BigDecimal(pointsString));
					if(bucket24Points.compareTo(BigDecimal.ZERO) >= 0) {
						cardBucketDetails.setBucket24PointBal(bucket24Points);
						cardBucketDetails.setBucket24PointSign("+");
					}else {						
						cardBucketDetails.setBucket24PointBal(bucket24Points.abs());
						cardBucketDetails.setBucket24PointSign("-");
					}					
				}
			}
		}

		//23th Bucket 
		if(apPointTxnBucketDetails.getBucket23PointRedeemed() != null && apPointTxnBucketDetails.getBucket23PointRedeemed().compareTo(BigDecimal.ZERO) > 0) {
			if(cardBucketDetails.getBucket23PointBal() != null) {
				if(cardBucketDetails.getBucket23PointSign() != null) {
					String pointsString = cardBucketDetails.getBucket23PointSign().concat(cardBucketDetails.getBucket23PointBal().toString());
					BigDecimal bucket23Points = apPointTxnBucketDetails.getBucket23PointRedeemed().add(new BigDecimal(pointsString));
					if(bucket23Points.compareTo(BigDecimal.ZERO) >= 0) {
						cardBucketDetails.setBucket23PointBal(bucket23Points);
						cardBucketDetails.setBucket23PointSign("+");
					}else {						
						cardBucketDetails.setBucket23PointBal(bucket23Points.abs());
						cardBucketDetails.setBucket23PointSign("-");
					}
				}
			}
		}

		//22th Bucket 
		if(apPointTxnBucketDetails.getBucket22PointRedeemed() != null && apPointTxnBucketDetails.getBucket22PointRedeemed().compareTo(BigDecimal.ZERO) > 0) {
			if(cardBucketDetails.getBucket22PointBal() != null) {
				if(cardBucketDetails.getBucket22PointSign() != null) {
					String pointsString = cardBucketDetails.getBucket22PointSign().concat(cardBucketDetails.getBucket22PointBal().toString());
					BigDecimal bucket22Points = apPointTxnBucketDetails.getBucket22PointRedeemed().add(new BigDecimal(pointsString));
					if(bucket22Points.compareTo(BigDecimal.ZERO) >= 0) {
						cardBucketDetails.setBucket22PointBal(bucket22Points);
						cardBucketDetails.setBucket22PointSign("+");
					}else {						
						cardBucketDetails.setBucket22PointBal(bucket22Points.abs());
						cardBucketDetails.setBucket22PointSign("-");
					}
				}
			}
		}
		
		//21th Bucket 
		if(apPointTxnBucketDetails.getBucket21PointRedeemed() != null && apPointTxnBucketDetails.getBucket21PointRedeemed().compareTo(BigDecimal.ZERO) > 0) {
			if(cardBucketDetails.getBucket21PointBal() != null) {
				if(cardBucketDetails.getBucket21PointSign() != null) {
					String pointsString = cardBucketDetails.getBucket21PointSign().concat(cardBucketDetails.getBucket21PointBal().toString());
					BigDecimal bucket21Points = apPointTxnBucketDetails.getBucket21PointRedeemed().add(new BigDecimal(pointsString));
					if(bucket21Points.compareTo(BigDecimal.ZERO) >= 0) {
						cardBucketDetails.setBucket21PointBal(bucket21Points);
						cardBucketDetails.setBucket21PointSign("+");
					}else {						
						cardBucketDetails.setBucket21PointBal(bucket21Points.abs());
						cardBucketDetails.setBucket21PointSign("-");
					}
				}
			}
		}

		//20th Bucket 
		if(apPointTxnBucketDetails.getBucket20PointRedeemed() != null && apPointTxnBucketDetails.getBucket20PointRedeemed().compareTo(BigDecimal.ZERO) > 0) {
			if(cardBucketDetails.getBucket20PointBal() != null) {
				if(cardBucketDetails.getBucket20PointSign() != null) {
					String pointsString = cardBucketDetails.getBucket20PointSign().concat(cardBucketDetails.getBucket20PointBal().toString());
					BigDecimal bucket20Points = apPointTxnBucketDetails.getBucket20PointRedeemed().add(new BigDecimal(pointsString));
					if(bucket20Points.compareTo(BigDecimal.ZERO) >= 0) {
						cardBucketDetails.setBucket20PointBal(bucket20Points);
						cardBucketDetails.setBucket20PointSign("+");
					}else {						
						cardBucketDetails.setBucket20PointBal(bucket20Points.abs());
						cardBucketDetails.setBucket20PointSign("-");
					}
				}
			}
		}

		//19th Bucket 
		if(apPointTxnBucketDetails.getBucket19PointRedeemed() != null && apPointTxnBucketDetails.getBucket19PointRedeemed().compareTo(BigDecimal.ZERO) > 0) {
			if(cardBucketDetails.getBucket19PointBal() != null) {
				if(cardBucketDetails.getBucket19PointSign() != null) {
					String pointsString = cardBucketDetails.getBucket19PointSign().concat(cardBucketDetails.getBucket19PointBal().toString());
					BigDecimal bucket19Points = apPointTxnBucketDetails.getBucket19PointRedeemed().add(new BigDecimal(pointsString));
					if(bucket19Points.compareTo(BigDecimal.ZERO) >= 0) {
						cardBucketDetails.setBucket19PointBal(bucket19Points);
						cardBucketDetails.setBucket19PointSign("+");
					}else {						
						cardBucketDetails.setBucket19PointBal(bucket19Points.abs());
						cardBucketDetails.setBucket19PointSign("-");
					}
				}
			}
		}

		//18th Bucket 
		if(apPointTxnBucketDetails.getBucket18PointRedeemed() != null && apPointTxnBucketDetails.getBucket18PointRedeemed().compareTo(BigDecimal.ZERO) > 0) {
			if(cardBucketDetails.getBucket18PointBal() != null) {
				if(cardBucketDetails.getBucket18PointSign() != null) {
					String pointsString = cardBucketDetails.getBucket18PointSign().concat(cardBucketDetails.getBucket18PointBal().toString());
					BigDecimal bucket18Points = apPointTxnBucketDetails.getBucket18PointRedeemed().add(new BigDecimal(pointsString));
					if(bucket18Points.compareTo(BigDecimal.ZERO) >= 0) {
						cardBucketDetails.setBucket18PointBal(bucket18Points);
						cardBucketDetails.setBucket18PointSign("+");
					}else {						
						cardBucketDetails.setBucket18PointBal(bucket18Points.abs());
						cardBucketDetails.setBucket18PointSign("-");
					}
				}
			}
		}

		//17th Bucket 
		if(apPointTxnBucketDetails.getBucket17PointRedeemed() != null && apPointTxnBucketDetails.getBucket17PointRedeemed().compareTo(BigDecimal.ZERO) > 0) {
			if(cardBucketDetails.getBucket17PointBal() != null) {
				if(cardBucketDetails.getBucket17PointSign() != null) {
					String pointsString = cardBucketDetails.getBucket17PointSign().concat(cardBucketDetails.getBucket17PointBal().toString());
					BigDecimal bucket17Points = apPointTxnBucketDetails.getBucket17PointRedeemed().add(new BigDecimal(pointsString));
					if(bucket17Points.compareTo(BigDecimal.ZERO) >= 0) {
						cardBucketDetails.setBucket17PointBal(bucket17Points);
						cardBucketDetails.setBucket17PointSign("+");
					}else {						
						cardBucketDetails.setBucket17PointBal(bucket17Points.abs());
						cardBucketDetails.setBucket17PointSign("-");
					}
				}
			}
		}

		//16th Bucket 
		if(apPointTxnBucketDetails.getBucket16PointRedeemed() != null && apPointTxnBucketDetails.getBucket16PointRedeemed().compareTo(BigDecimal.ZERO) > 0) {
			if(cardBucketDetails.getBucket16PointBal() != null) {
				if(cardBucketDetails.getBucket16PointSign() != null) {
					String pointsString = cardBucketDetails.getBucket16PointSign().concat(cardBucketDetails.getBucket16PointBal().toString());
					BigDecimal bucket16Points = apPointTxnBucketDetails.getBucket16PointRedeemed().add(new BigDecimal(pointsString));
					if(bucket16Points.compareTo(BigDecimal.ZERO) >= 0) {
						cardBucketDetails.setBucket16PointBal(bucket16Points);
						cardBucketDetails.setBucket16PointSign("+");
					}else {						
						cardBucketDetails.setBucket16PointBal(bucket16Points.abs());
						cardBucketDetails.setBucket16PointSign("-");
					}
				}
			}
		}

		//15th Bucket 
		if(apPointTxnBucketDetails.getBucket15PointRedeemed() != null && apPointTxnBucketDetails.getBucket15PointRedeemed().compareTo(BigDecimal.ZERO) > 0) {
			if(cardBucketDetails.getBucket15PointBal() != null) {
				if(cardBucketDetails.getBucket15PointSign() != null) {
					String pointsString = cardBucketDetails.getBucket15PointSign().concat(cardBucketDetails.getBucket15PointBal().toString());
					BigDecimal bucket15Points = apPointTxnBucketDetails.getBucket15PointRedeemed().add(new BigDecimal(pointsString));
					if(bucket15Points.compareTo(BigDecimal.ZERO) >= 0) {
						cardBucketDetails.setBucket15PointBal(bucket15Points);
						cardBucketDetails.setBucket15PointSign("+");
					}else {						
						cardBucketDetails.setBucket15PointBal(bucket15Points.abs());
						cardBucketDetails.setBucket15PointSign("-");
					}
				}
			}
		}

		//14th Bucket 
		if(apPointTxnBucketDetails.getBucket14PointRedeemed() != null && apPointTxnBucketDetails.getBucket14PointRedeemed().compareTo(BigDecimal.ZERO) > 0) {
			if(cardBucketDetails.getBucket14PointBal() != null) {
				if(cardBucketDetails.getBucket14PointSign() != null) {
					String pointsString = cardBucketDetails.getBucket14PointSign().concat(cardBucketDetails.getBucket14PointBal().toString());
					BigDecimal bucket14Points = apPointTxnBucketDetails.getBucket14PointRedeemed().add(new BigDecimal(pointsString));
					if(bucket14Points.compareTo(BigDecimal.ZERO) >= 0) {
						cardBucketDetails.setBucket14PointBal(bucket14Points);
						cardBucketDetails.setBucket14PointSign("+");
					}else {						
						cardBucketDetails.setBucket14PointBal(bucket14Points.abs());
						cardBucketDetails.setBucket14PointSign("-");
					}
				}
			}
		}

		//13th Bucket 
		if(apPointTxnBucketDetails.getBucket13PointRedeemed() != null && apPointTxnBucketDetails.getBucket13PointRedeemed().compareTo(BigDecimal.ZERO) > 0) {
			if(cardBucketDetails.getBucket13PointBal() != null) {
				if(cardBucketDetails.getBucket13PointSign() != null) {
					String pointsString = cardBucketDetails.getBucket13PointSign().concat(cardBucketDetails.getBucket13PointBal().toString());
					BigDecimal bucket13Points = apPointTxnBucketDetails.getBucket13PointRedeemed().add(new BigDecimal(pointsString));
					if(bucket13Points.compareTo(BigDecimal.ZERO) >= 0) {
						cardBucketDetails.setBucket13PointBal(bucket13Points);
						cardBucketDetails.setBucket13PointSign("+");
					}else {						
						cardBucketDetails.setBucket13PointBal(bucket13Points.abs());
						cardBucketDetails.setBucket13PointSign("-");
					}
				}
			}
		}

		//12th Bucket 
		if(apPointTxnBucketDetails.getBucket12PointRedeemed() != null && apPointTxnBucketDetails.getBucket12PointRedeemed().compareTo(BigDecimal.ZERO) > 0) {
			if(cardBucketDetails.getBucket12PointBal() != null) {
				if(cardBucketDetails.getBucket12PointSign() != null) {
					String pointsString = cardBucketDetails.getBucket12PointSign().concat(cardBucketDetails.getBucket12PointBal().toString());
					BigDecimal bucket12Points = apPointTxnBucketDetails.getBucket12PointRedeemed().add(new BigDecimal(pointsString));
					if(bucket12Points.compareTo(BigDecimal.ZERO) >= 0) {
						cardBucketDetails.setBucket12PointBal(bucket12Points);
						cardBucketDetails.setBucket12PointSign("+");
					}else {						
						cardBucketDetails.setBucket12PointBal(bucket12Points.abs());
						cardBucketDetails.setBucket12PointSign("-");
					}
				}
			}
		}

		//11th Bucket 
		if(apPointTxnBucketDetails.getBucket11PointRedeemed() != null && apPointTxnBucketDetails.getBucket11PointRedeemed().compareTo(BigDecimal.ZERO) > 0) {
			if(cardBucketDetails.getBucket11PointBal() != null) {
				if(cardBucketDetails.getBucket11PointSign() != null) {
					String pointsString = cardBucketDetails.getBucket11PointSign().concat(cardBucketDetails.getBucket11PointBal().toString());
					BigDecimal bucket11Points = apPointTxnBucketDetails.getBucket11PointRedeemed().add(new BigDecimal(pointsString));
					if(bucket11Points.compareTo(BigDecimal.ZERO) >= 0) {
						cardBucketDetails.setBucket11PointBal(bucket11Points);
						cardBucketDetails.setBucket11PointSign("+");
					}else {						
						cardBucketDetails.setBucket11PointBal(bucket11Points.abs());
						cardBucketDetails.setBucket11PointSign("-");
					}
				}
			}
		}
		
		//10th Bucket 
		if(apPointTxnBucketDetails.getBucket10PointRedeemed() != null && apPointTxnBucketDetails.getBucket10PointRedeemed().compareTo(BigDecimal.ZERO) > 0) {
			if(cardBucketDetails.getBucket10PointBal() != null) {
				if(cardBucketDetails.getBucket10PointSign() != null) {
					String pointsString = cardBucketDetails.getBucket10PointSign().concat(cardBucketDetails.getBucket10PointBal().toString());
					BigDecimal bucket10Points = apPointTxnBucketDetails.getBucket10PointRedeemed().add(new BigDecimal(pointsString));
					if(bucket10Points.compareTo(BigDecimal.ZERO) >= 0) {
						cardBucketDetails.setBucket10PointBal(bucket10Points);
						cardBucketDetails.setBucket10PointSign("+");
					}else {						
						cardBucketDetails.setBucket10PointBal(bucket10Points.abs());
						cardBucketDetails.setBucket10PointSign("-");
					}
				}
			}
		}

		//09th Bucket 
		if(apPointTxnBucketDetails.getBucket09PointRedeemed() != null && apPointTxnBucketDetails.getBucket09PointRedeemed().compareTo(BigDecimal.ZERO) > 0) {
			if(cardBucketDetails.getBucket09PointBal() != null) {
				if(cardBucketDetails.getBucket09PointSign() != null) {
					String pointsString = cardBucketDetails.getBucket09PointSign().concat(cardBucketDetails.getBucket09PointBal().toString());
					BigDecimal bucket09Points = apPointTxnBucketDetails.getBucket09PointRedeemed().add(new BigDecimal(pointsString));
					if(bucket09Points.compareTo(BigDecimal.ZERO) >= 0) {
						cardBucketDetails.setBucket09PointBal(bucket09Points);
						cardBucketDetails.setBucket09PointSign("+");
					}else {						
						cardBucketDetails.setBucket09PointBal(bucket09Points.abs());
						cardBucketDetails.setBucket09PointSign("-");
					}
				}
			}
		}

		//08th Bucket 
		if(apPointTxnBucketDetails.getBucket08PointRedeemed() != null && apPointTxnBucketDetails.getBucket08PointRedeemed().compareTo(BigDecimal.ZERO) > 0) {
			if(cardBucketDetails.getBucket08PointBal() != null) {
				if(cardBucketDetails.getBucket08PointSign() != null) {
					String pointsString = cardBucketDetails.getBucket08PointSign().concat(cardBucketDetails.getBucket08PointBal().toString());
					BigDecimal bucket08Points = apPointTxnBucketDetails.getBucket08PointRedeemed().add(new BigDecimal(pointsString));
					if(bucket08Points.compareTo(BigDecimal.ZERO) >= 0) {
						cardBucketDetails.setBucket08PointBal(bucket08Points);
						cardBucketDetails.setBucket08PointSign("+");
					}else {						
						cardBucketDetails.setBucket08PointBal(bucket08Points.abs());
						cardBucketDetails.setBucket08PointSign("-");
					}
				}
			}
		}

		//07th Bucket 
		if(apPointTxnBucketDetails.getBucket07PointRedeemed() != null && apPointTxnBucketDetails.getBucket07PointRedeemed().compareTo(BigDecimal.ZERO) > 0) {
			if(cardBucketDetails.getBucket07PointBal() != null) {
				if(cardBucketDetails.getBucket07PointSign() != null) {
					String pointsString = cardBucketDetails.getBucket07PointSign().concat(cardBucketDetails.getBucket07PointBal().toString());
					BigDecimal bucket07Points = apPointTxnBucketDetails.getBucket07PointRedeemed().add(new BigDecimal(pointsString));
					if(bucket07Points.compareTo(BigDecimal.ZERO) >= 0) {
						cardBucketDetails.setBucket07PointBal(bucket07Points);
						cardBucketDetails.setBucket07PointSign("+");
					}else {						
						cardBucketDetails.setBucket07PointBal(bucket07Points.abs());
						cardBucketDetails.setBucket07PointSign("-");
					}
				}
			}
		}

		//06th Bucket 
		if(apPointTxnBucketDetails.getBucket06PointRedeemed() != null && apPointTxnBucketDetails.getBucket06PointRedeemed().compareTo(BigDecimal.ZERO) > 0) {
			if(cardBucketDetails.getBucket06PointBal() != null) {
				if(cardBucketDetails.getBucket06PointSign() != null) {
					String pointsString = cardBucketDetails.getBucket06PointSign().concat(cardBucketDetails.getBucket06PointBal().toString());
					BigDecimal bucket06Points = apPointTxnBucketDetails.getBucket06PointRedeemed().add(new BigDecimal(pointsString));
					if(bucket06Points.compareTo(BigDecimal.ZERO) >= 0) {
						cardBucketDetails.setBucket06PointBal(bucket06Points);
						cardBucketDetails.setBucket06PointSign("+");
					}else {						
						cardBucketDetails.setBucket06PointBal(bucket06Points.abs());
						cardBucketDetails.setBucket06PointSign("-");
					}
				}
			}
		}

		//05th Bucket 
		if(apPointTxnBucketDetails.getBucket05PointRedeemed() != null && apPointTxnBucketDetails.getBucket05PointRedeemed().compareTo(BigDecimal.ZERO) > 0) {
			if(cardBucketDetails.getBucket05PointBal() != null) {
				if(cardBucketDetails.getBucket05PointSign() != null) {
					String pointsString = cardBucketDetails.getBucket05PointSign().concat(cardBucketDetails.getBucket05PointBal().toString());
					BigDecimal bucket05Points = apPointTxnBucketDetails.getBucket05PointRedeemed().add(new BigDecimal(pointsString));
					if(bucket05Points.compareTo(BigDecimal.ZERO) >= 0) {
						cardBucketDetails.setBucket05PointBal(bucket05Points);
						cardBucketDetails.setBucket05PointSign("+");
					}else {						
						cardBucketDetails.setBucket05PointBal(bucket05Points.abs());
						cardBucketDetails.setBucket05PointSign("-");
					}
				}
			}
		}

		//04th Bucket 
		if(apPointTxnBucketDetails.getBucket04PointRedeemed() != null && apPointTxnBucketDetails.getBucket04PointRedeemed().compareTo(BigDecimal.ZERO) > 0) {
			if(cardBucketDetails.getBucket04PointBal() != null) {
				if(cardBucketDetails.getBucket04PointSign() != null) {
					String pointsString = cardBucketDetails.getBucket04PointSign().concat(cardBucketDetails.getBucket04PointBal().toString());
					BigDecimal bucket04Points = apPointTxnBucketDetails.getBucket04PointRedeemed().add(new BigDecimal(pointsString));
					if(bucket04Points.compareTo(BigDecimal.ZERO) >= 0) {
						cardBucketDetails.setBucket04PointBal(bucket04Points);
						cardBucketDetails.setBucket04PointSign("+");
					}else {						
						cardBucketDetails.setBucket04PointBal(bucket04Points.abs());
						cardBucketDetails.setBucket04PointSign("-");
					}
				}
			}
		}

		//03th Bucket 
		if(apPointTxnBucketDetails.getBucket03PointRedeemed() != null && apPointTxnBucketDetails.getBucket03PointRedeemed().compareTo(BigDecimal.ZERO) > 0) {
			if(cardBucketDetails.getBucket03PointBal() != null) {
				if(cardBucketDetails.getBucket03PointSign() != null) {
					String pointsString = cardBucketDetails.getBucket03PointSign().concat(cardBucketDetails.getBucket03PointBal().toString());
					BigDecimal bucket03Points = apPointTxnBucketDetails.getBucket03PointRedeemed().add(new BigDecimal(pointsString));
					if(bucket03Points.compareTo(BigDecimal.ZERO) >= 0) {
						cardBucketDetails.setBucket03PointBal(bucket03Points);
						cardBucketDetails.setBucket03PointSign("+");
					}else {						
						cardBucketDetails.setBucket03PointBal(bucket03Points.abs());
						cardBucketDetails.setBucket03PointSign("-");
					}
				}
			}
		}

		//02th Bucket 
		if(apPointTxnBucketDetails.getBucket02PointRedeemed() != null && apPointTxnBucketDetails.getBucket02PointRedeemed().compareTo(BigDecimal.ZERO) > 0) {
			if(cardBucketDetails.getBucket02PointBal() != null) {
				if(cardBucketDetails.getBucket02PointSign() != null) {
					String pointsString = cardBucketDetails.getBucket02PointSign().concat(cardBucketDetails.getBucket02PointBal().toString());
					BigDecimal bucket02Points = apPointTxnBucketDetails.getBucket02PointRedeemed().add(new BigDecimal(pointsString));
					
					if(bucket02Points.compareTo(BigDecimal.ZERO) >= 0) {
						cardBucketDetails.setBucket02PointBal(bucket02Points);
						cardBucketDetails.setBucket02PointSign("+");
					}else {						
						cardBucketDetails.setBucket02PointBal(bucket02Points.abs());
						cardBucketDetails.setBucket02PointSign("-");
					}
				}
			}
		}

		//01th Bucket 
		if(apPointTxnBucketDetails.getBucket01PointRedeemed() != null && apPointTxnBucketDetails.getBucket01PointRedeemed().compareTo(BigDecimal.ZERO) > 0) {
			if(cardBucketDetails.getBucket01PointBal() != null) {
				if(cardBucketDetails.getBucket01PointSign() != null) {
					String pointsString = cardBucketDetails.getBucket01PointSign().concat(cardBucketDetails.getBucket01PointBal().toString());
					BigDecimal bucket01Points = apPointTxnBucketDetails.getBucket01PointRedeemed().add(new BigDecimal(pointsString));
					if(bucket01Points.compareTo(BigDecimal.ZERO) >= 0) {
						cardBucketDetails.setBucket01PointBal(bucket01Points);
						cardBucketDetails.setBucket01PointSign("+");
					}else {						
						cardBucketDetails.setBucket01PointBal(bucket01Points.abs());
						cardBucketDetails.setBucket01PointSign("-");
					}
				}
			}
		}
		
		totalPointsBal = getTotalPointsBal(cardBucketDetails);
		if(totalPointsBal != null) {
			if(totalPointsBal.compareTo(BigDecimal.ZERO) >= 0) {
				cardBucketDetails.setTotalPointsBal(totalPointsBal.abs());
				cardBucketDetails.setTotalPointsSign("+");
			}else {						
				cardBucketDetails.setTotalPointsBal(totalPointsBal.abs());
				cardBucketDetails.setTotalPointsSign("-");
			}
		}
		
		int transformedTotalPointsBal = cardBucketDetails.getTotalPointsBal().intValue();
		cardBucketDetails.setTransformedTotalPointsBal(transformedTotalPointsBal);
		
		logger.info("******************************************************** ");
		logger.info("Card Holder Point Bucket Details After Void Redemption: " + cardBucketDetails.toString());
		logger.info("******************************************************** ");
		
		return cardBucketDetails;
	}
	
	private BigDecimal getTotalPointsBal(MTCardHolderPointBucketDTO cardBucketDetails) {
		BigDecimal totalPointsBal = BigDecimal.ZERO;
		
		//36th Bucket 
		if(cardBucketDetails.getBucket36PointBal() != null) {
			if(cardBucketDetails.getBucket36PointSign() != null) {
				String pointsString = cardBucketDetails.getBucket36PointSign().concat(cardBucketDetails.getBucket36PointBal().toString());
				totalPointsBal = totalPointsBal.add(new BigDecimal(pointsString));
			}
		}
		
		//35th Bucket 
		if(cardBucketDetails.getBucket35PointBal() != null) {
			if(cardBucketDetails.getBucket35PointSign() != null) {
				String pointsString = cardBucketDetails.getBucket35PointSign().concat(cardBucketDetails.getBucket35PointBal().toString());
				totalPointsBal = totalPointsBal.add(new BigDecimal(pointsString));
			}
		}
		
		//34th Bucket 
		if(cardBucketDetails.getBucket34PointBal() != null) {
			if(cardBucketDetails.getBucket34PointSign() != null) {
				String pointsString = cardBucketDetails.getBucket34PointSign().concat(cardBucketDetails.getBucket34PointBal().toString());
				totalPointsBal = totalPointsBal.add(new BigDecimal(pointsString));
			}
		}
		
		//33th Bucket 
		if(cardBucketDetails.getBucket33PointBal() != null) {
			if(cardBucketDetails.getBucket33PointSign() != null) {
				String pointsString = cardBucketDetails.getBucket33PointSign().concat(cardBucketDetails.getBucket33PointBal().toString());
				totalPointsBal = totalPointsBal.add(new BigDecimal(pointsString));
			}
		}
		
		//32th Bucket 
		if(cardBucketDetails.getBucket32PointBal() != null) {
			if(cardBucketDetails.getBucket32PointSign() != null) {
				String pointsString = cardBucketDetails.getBucket32PointSign().concat(cardBucketDetails.getBucket32PointBal().toString());
				totalPointsBal = totalPointsBal.add(new BigDecimal(pointsString));
			}
		}
		
		//31th Bucket 
		if(cardBucketDetails.getBucket31PointBal() != null) {
			if(cardBucketDetails.getBucket31PointSign() != null) {
				String pointsString = cardBucketDetails.getBucket31PointSign().concat(cardBucketDetails.getBucket31PointBal().toString());
				totalPointsBal = totalPointsBal.add(new BigDecimal(pointsString));
			}
		}
		
		//30th Bucket 
		if(cardBucketDetails.getBucket30PointBal() != null) {
			if(cardBucketDetails.getBucket30PointSign() != null) {
				String pointsString = cardBucketDetails.getBucket30PointSign().concat(cardBucketDetails.getBucket30PointBal().toString());
				totalPointsBal = totalPointsBal.add(new BigDecimal(pointsString));
			}
		}
		
		//29th Bucket 
		if(cardBucketDetails.getBucket29PointBal() != null) {
			if(cardBucketDetails.getBucket29PointSign() != null) {
				String pointsString = cardBucketDetails.getBucket29PointSign().concat(cardBucketDetails.getBucket29PointBal().toString());
				totalPointsBal = totalPointsBal.add(new BigDecimal(pointsString));
			}
		}
		
		//28th Bucket 
		if(cardBucketDetails.getBucket28PointBal() != null) {
			if(cardBucketDetails.getBucket28PointSign() != null) {
				String pointsString = cardBucketDetails.getBucket28PointSign().concat(cardBucketDetails.getBucket28PointBal().toString());
				totalPointsBal = totalPointsBal.add(new BigDecimal(pointsString));
			}
		}
		
		//27th Bucket 
		if(cardBucketDetails.getBucket27PointBal() != null) {
			if(cardBucketDetails.getBucket27PointSign() != null) {
				String pointsString = cardBucketDetails.getBucket27PointSign().concat(cardBucketDetails.getBucket27PointBal().toString());
				totalPointsBal = totalPointsBal.add(new BigDecimal(pointsString));
			}
		}
		
		//26th Bucket 
		if(cardBucketDetails.getBucket26PointBal() != null) {
			if(cardBucketDetails.getBucket26PointSign() != null) {
				String pointsString = cardBucketDetails.getBucket26PointSign().concat(cardBucketDetails.getBucket26PointBal().toString());
				totalPointsBal = totalPointsBal.add(new BigDecimal(pointsString));
			}
		}
		
		//25th Bucket 
		if(cardBucketDetails.getBucket25PointBal() != null) {
			if(cardBucketDetails.getBucket25PointSign() != null) {
				String pointsString = cardBucketDetails.getBucket25PointSign().concat(cardBucketDetails.getBucket25PointBal().toString());
				totalPointsBal = totalPointsBal.add(new BigDecimal(pointsString));
			}
		}

		//24th Bucket 
		if(cardBucketDetails.getBucket24PointBal() != null) {
			if(cardBucketDetails.getBucket24PointSign() != null) {
				String pointsString = cardBucketDetails.getBucket24PointSign().concat(cardBucketDetails.getBucket24PointBal().toString());
				totalPointsBal = totalPointsBal.add(new BigDecimal(pointsString));
			}
		}

		//23th Bucket 
		if(cardBucketDetails.getBucket23PointBal() != null) {
			if(cardBucketDetails.getBucket23PointSign() != null) {
				String pointsString = cardBucketDetails.getBucket23PointSign().concat(cardBucketDetails.getBucket23PointBal().toString());
				totalPointsBal = totalPointsBal.add(new BigDecimal(pointsString));
			}
		}

		//22th Bucket 
		if(cardBucketDetails.getBucket22PointBal() != null) {
			if(cardBucketDetails.getBucket22PointSign() != null) {
				String pointsString = cardBucketDetails.getBucket22PointSign().concat(cardBucketDetails.getBucket22PointBal().toString());
				totalPointsBal = totalPointsBal.add(new BigDecimal(pointsString));
			}
		}
		
		//21th Bucket 
		if(cardBucketDetails.getBucket21PointBal() != null) {
			if(cardBucketDetails.getBucket21PointSign() != null) {
				String pointsString = cardBucketDetails.getBucket21PointSign().concat(cardBucketDetails.getBucket21PointBal().toString());
				totalPointsBal = totalPointsBal.add(new BigDecimal(pointsString));
			}
		}

		//20th Bucket 
		if(cardBucketDetails.getBucket20PointBal() != null) {
			if(cardBucketDetails.getBucket20PointSign() != null) {
				String pointsString = cardBucketDetails.getBucket20PointSign().concat(cardBucketDetails.getBucket20PointBal().toString());
				totalPointsBal = totalPointsBal.add(new BigDecimal(pointsString));
			}
		}

		//19th Bucket 
		if(cardBucketDetails.getBucket19PointBal() != null) {
			if(cardBucketDetails.getBucket19PointSign() != null) {
				String pointsString = cardBucketDetails.getBucket19PointSign().concat(cardBucketDetails.getBucket19PointBal().toString());
				totalPointsBal = totalPointsBal.add(new BigDecimal(pointsString));
			}
		}

		//18th Bucket 
		if(cardBucketDetails.getBucket18PointBal() != null) {
			if(cardBucketDetails.getBucket18PointSign() != null) {
				String pointsString = cardBucketDetails.getBucket18PointSign().concat(cardBucketDetails.getBucket18PointBal().toString());
				totalPointsBal = totalPointsBal.add(new BigDecimal(pointsString));
			}
		}

		//17th Bucket 
		if(cardBucketDetails.getBucket17PointBal() != null) {
			if(cardBucketDetails.getBucket17PointSign() != null) {
				String pointsString = cardBucketDetails.getBucket17PointSign().concat(cardBucketDetails.getBucket17PointBal().toString());
				totalPointsBal = totalPointsBal.add(new BigDecimal(pointsString));
			}
		}

		//16th Bucket 
		if(cardBucketDetails.getBucket16PointBal() != null) {
			if(cardBucketDetails.getBucket16PointSign() != null) {
				String pointsString = cardBucketDetails.getBucket16PointSign().concat(cardBucketDetails.getBucket16PointBal().toString());
				totalPointsBal = totalPointsBal.add(new BigDecimal(pointsString));
			}
		}

		//15th Bucket 
		if(cardBucketDetails.getBucket15PointBal() != null) {
			if(cardBucketDetails.getBucket15PointSign() != null) {
				String pointsString = cardBucketDetails.getBucket15PointSign().concat(cardBucketDetails.getBucket15PointBal().toString());
				totalPointsBal = totalPointsBal.add(new BigDecimal(pointsString));
			}
		}

		//14th Bucket 
		if(cardBucketDetails.getBucket14PointBal() != null) {
			if(cardBucketDetails.getBucket14PointSign() != null) {
				String pointsString = cardBucketDetails.getBucket14PointSign().concat(cardBucketDetails.getBucket14PointBal().toString());
				totalPointsBal = totalPointsBal.add(new BigDecimal(pointsString));
			}
		}

		//13th Bucket 
		if(cardBucketDetails.getBucket13PointBal() != null) {
			if(cardBucketDetails.getBucket13PointSign() != null) {
				String pointsString = cardBucketDetails.getBucket13PointSign().concat(cardBucketDetails.getBucket13PointBal().toString());
				totalPointsBal = totalPointsBal.add(new BigDecimal(pointsString));
			}
		}

		//12th Bucket 
		if(cardBucketDetails.getBucket12PointBal() != null) {
			if(cardBucketDetails.getBucket12PointSign() != null) {
				String pointsString = cardBucketDetails.getBucket12PointSign().concat(cardBucketDetails.getBucket12PointBal().toString());
				totalPointsBal = totalPointsBal.add(new BigDecimal(pointsString));
			}
		}

		//11th Bucket 
		if(cardBucketDetails.getBucket11PointBal() != null) {
			if(cardBucketDetails.getBucket11PointSign() != null) {
				String pointsString = cardBucketDetails.getBucket11PointSign().concat(cardBucketDetails.getBucket11PointBal().toString());
				totalPointsBal = totalPointsBal.add(new BigDecimal(pointsString));
			}
		}
		
		//10th Bucket 
		if(cardBucketDetails.getBucket10PointBal() != null) {
			if(cardBucketDetails.getBucket10PointSign() != null) {
				String pointsString = cardBucketDetails.getBucket10PointSign().concat(cardBucketDetails.getBucket10PointBal().toString());
				totalPointsBal = totalPointsBal.add(new BigDecimal(pointsString));
			}
		}

		//09th Bucket 
		if(cardBucketDetails.getBucket09PointBal() != null) {
			if(cardBucketDetails.getBucket09PointBal() != null) {
				String pointsString = cardBucketDetails.getBucket09PointSign().concat(cardBucketDetails.getBucket09PointBal().toString());
				totalPointsBal = totalPointsBal.add(new BigDecimal(pointsString));
			}
		}

		//08th Bucket 
		if(cardBucketDetails.getBucket08PointBal() != null) {
			if(cardBucketDetails.getBucket08PointSign() != null) {
				String pointsString = cardBucketDetails.getBucket08PointSign().concat(cardBucketDetails.getBucket08PointBal().toString());
				totalPointsBal = totalPointsBal.add(new BigDecimal(pointsString));
			}
		}

		//07th Bucket 
		if(cardBucketDetails.getBucket07PointBal() != null) {
			if(cardBucketDetails.getBucket07PointSign() != null) {
				String pointsString = cardBucketDetails.getBucket07PointSign().concat(cardBucketDetails.getBucket07PointBal().toString());
				totalPointsBal = totalPointsBal.add(new BigDecimal(pointsString));
			}
		}

		//06th Bucket 
		if(cardBucketDetails.getBucket06PointBal() != null) {
			if(cardBucketDetails.getBucket06PointSign() != null) {
				String pointsString = cardBucketDetails.getBucket06PointSign().concat(cardBucketDetails.getBucket06PointBal().toString());
				totalPointsBal = totalPointsBal.add(new BigDecimal(pointsString));
			}
		}

		//05th Bucket 
		if(cardBucketDetails.getBucket05PointBal() != null) {
			if(cardBucketDetails.getBucket05PointSign() != null) {
				String pointsString = cardBucketDetails.getBucket05PointSign().concat(cardBucketDetails.getBucket05PointBal().toString());
				totalPointsBal = totalPointsBal.add(new BigDecimal(pointsString));
			}
		}

		//04th Bucket 
		if(cardBucketDetails.getBucket04PointBal() != null) {
			if(cardBucketDetails.getBucket04PointSign() != null) {
				String pointsString = cardBucketDetails.getBucket04PointSign().concat(cardBucketDetails.getBucket04PointBal().toString());
				totalPointsBal = totalPointsBal.add(new BigDecimal(pointsString));
			}
		}

		//03th Bucket 
		if(cardBucketDetails.getBucket03PointBal() != null) {
			if(cardBucketDetails.getBucket03PointSign() != null) {
				String pointsString = cardBucketDetails.getBucket03PointSign().concat(cardBucketDetails.getBucket03PointBal().toString());
				totalPointsBal = totalPointsBal.add(new BigDecimal(pointsString));
			}
		}

		//02th Bucket 
		if(cardBucketDetails.getBucket02PointBal() != null) {
			if(cardBucketDetails.getBucket02PointSign() != null) {
				String pointsString = cardBucketDetails.getBucket02PointSign().concat(cardBucketDetails.getBucket02PointBal().toString());
				totalPointsBal = totalPointsBal.add(new BigDecimal(pointsString));
			}
		}

		//01th Bucket 
		if(cardBucketDetails.getBucket01PointBal() != null) {
			if(cardBucketDetails.getBucket01PointSign() != null) {
				String pointsString = cardBucketDetails.getBucket01PointSign().concat(cardBucketDetails.getBucket01PointBal().toString());
				totalPointsBal = totalPointsBal.add(new BigDecimal(pointsString));
			}
		}
		
		return totalPointsBal;
	}
	
	private MTCardHolderPointBucketDTO voidPointsFrom01stBucket(MTCardHolderPointBucketDTO cardBucketDetail, ApPointTxnBucketDetails apPointTxnBucketDetails){
		
		MTCardHolderPointBucketDTO cardBucketDetails = cardBucketDetail;
		BigDecimal totalPointsBal = BigDecimal.ZERO;
		
		logger.info("******************************************************** ");
		logger.info("Card Holder Point Bucket Details From 01st Bucket Before Void Redemption: " + cardBucketDetails.toString());
		logger.info("******************************************************** ");
		
		//01st - Bucket
		if(apPointTxnBucketDetails.getBucket01PointRedeemed() != null && apPointTxnBucketDetails.getBucket01PointRedeemed().compareTo(BigDecimal.ZERO) > 0) {
			if(cardBucketDetails.getBucket01PointBal() != null) {
				if(cardBucketDetails.getBucket01PointSign() != null) {
					String pointsString = cardBucketDetails.getBucket01PointSign().concat(cardBucketDetails.getBucket01PointBal().toString());
					BigDecimal bucket01Points = apPointTxnBucketDetails.getBucket01PointRedeemed().add(new BigDecimal(pointsString));
					if(bucket01Points.compareTo(BigDecimal.ZERO) >= 0) {
						cardBucketDetails.setBucket01PointBal(bucket01Points);
						cardBucketDetails.setBucket01PointSign("+");
					}else {						
						cardBucketDetails.setBucket01PointBal(bucket01Points.abs());
						cardBucketDetails.setBucket01PointSign("-");
					}
				}
			}
		}
		
		totalPointsBal = getTotalPointsBal(cardBucketDetails);
		if(totalPointsBal != null) {
			if(totalPointsBal.compareTo(BigDecimal.ZERO) >= 0) {
				cardBucketDetails.setTotalPointsBal(totalPointsBal.abs());
				cardBucketDetails.setTotalPointsSign("+");
			}else {						
				cardBucketDetails.setTotalPointsBal(totalPointsBal.abs());
				cardBucketDetails.setTotalPointsSign("-");
			}
		}
		
		logger.info("******************************************************** ");
		logger.info("Card Holder Point Bucket Details From 01st Bucket After Void Redemption: " + cardBucketDetails.toString());
		logger.info("******************************************************** ");
		
		return cardBucketDetails;
	}

}
