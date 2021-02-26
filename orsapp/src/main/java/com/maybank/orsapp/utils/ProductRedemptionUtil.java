package com.maybank.orsapp.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.maybank.orsapp.constant.MBBORSConstant;
import com.maybank.orsapp.controller.request.PointRedemptionProductReq;
import com.maybank.orsapp.dao.ProductRedemptionDao;
import com.maybank.orsapp.dto.CardHolderBucketDetailDTO;
import com.maybank.orsapp.dto.CardHolderDetailDTO;
import com.maybank.orsapp.dto.CardHolderTotalPointDTO;
import com.maybank.orsapp.dto.OrsProgramDTO;
import com.maybank.orsapp.dto.ProductUnitPointDetailDTO;

public class ProductRedemptionUtil {
	public static void printCardNum(List<CardHolderTotalPointDTO> cardTotalPointList, String tag) {
		System.out.println(tag.concat(" List Size : ").concat(Integer.toString(cardTotalPointList.size())));
		for(CardHolderTotalPointDTO  cardTotalPoint :cardTotalPointList) {
			System.out.println(cardTotalPoint.getCard_no());
		}
	}
	
	public static ArrayList<CardHolderTotalPointDTO> sortList(List<CardHolderTotalPointDTO> cardTotalPoint, String icNum) {
		
		List<String> icNumNoOwnerList = new ArrayList<String>();
		Comparator<CardHolderTotalPointDTO> compareByIcNum = Comparator
                .comparing(CardHolderTotalPointDTO::getCust_ic_no);
		
		ArrayList<CardHolderTotalPointDTO> resultList = new ArrayList<CardHolderTotalPointDTO>();
		
		icNumNoOwnerList = cardTotalPoint.stream().filter(e->!e.getCust_ic_no().equals(icNum)).sorted(compareByIcNum)
				.map(e->e.getCust_ic_no()).collect(Collectors.toList());
		
		if(icNumNoOwnerList!=null&&icNumNoOwnerList.size()>0) {
			Set<String> set = new HashSet<>(icNumNoOwnerList);
			icNumNoOwnerList.clear();
			icNumNoOwnerList.addAll(set);
		}
		
				//PP
		List<CardHolderTotalPointDTO> ownerPPAmex = cardTotalPoint.stream().filter(
						e->(
						e.getCust_ic_no().equals(icNum)
						&&e.getCard_post_flag().toUpperCase().equals("PP")
						&&(e.getCard_no().startsWith("03")||e.getCard_no().startsWith("3"))
						)).collect(Collectors.toList());
		
				if(ownerPPAmex!=null&&ownerPPAmex.size()>0) {
					resultList.addAll(ownerPPAmex);
				}
				
		List<CardHolderTotalPointDTO> ownerPPVisa = cardTotalPoint.stream().filter(
						e->(
						e.getCust_ic_no().equals(icNum)
						&&e.getCard_post_flag().toUpperCase().equals("PP")
						&&e.getCard_no().startsWith("4")
						)).collect(Collectors.toList());
		
				if(ownerPPVisa!=null&&ownerPPVisa.size()>0) {
					resultList.addAll(ownerPPVisa);
				}
				
		List<CardHolderTotalPointDTO> ownerPPMaster = cardTotalPoint.stream().filter(
				e->(
				e.getCust_ic_no().equals(icNum)
				&&e.getCard_post_flag().toUpperCase().equals("PP")
				&&e.getCard_no().startsWith("5")
				)).collect(Collectors.toList());
		
				if(ownerPPMaster!=null&&ownerPPMaster.size()>0) {
					resultList.addAll(ownerPPMaster);
				}
		
		List<CardHolderTotalPointDTO> ownerPPBA = cardTotalPoint.stream().filter(
				e->(
				e.getCust_ic_no().equals(icNum)
				&&(e.getCard_post_flag().toUpperCase().equals("PP")||e.getCard_post_flag().toUpperCase().equals("XX"))
				&&e.getCard_no().startsWith("8")
				)).collect(Collectors.toList());
		
				if(ownerPPBA!=null&&ownerPPBA.size()>0) {
					resultList.addAll(ownerPPBA);
				}
				
				//SP
		List<CardHolderTotalPointDTO> ownerSPAmex = cardTotalPoint.stream().filter(
				e->(
				e.getCust_ic_no().equals(icNum)
				&&e.getCard_post_flag().toUpperCase().equals("SP")
				&&(e.getCard_no().startsWith("03")||e.getCard_no().startsWith("3"))
				)).collect(Collectors.toList());
		
				if(ownerSPAmex!=null&&ownerSPAmex.size()>0) {
					resultList.addAll(ownerSPAmex);
				}
				
		List<CardHolderTotalPointDTO> ownerSPVisa = cardTotalPoint.stream().filter(
				e->(
				e.getCust_ic_no().equals(icNum)
				&&e.getCard_post_flag().toUpperCase().equals("SP")
				&&e.getCard_no().startsWith("4")
				)).collect(Collectors.toList());
		
				if(ownerSPVisa!=null&&ownerSPVisa.size()>0) {
					resultList.addAll(ownerSPVisa);
				}
			
		List<CardHolderTotalPointDTO> ownerSPMaster = cardTotalPoint.stream().filter(
				e->(
				e.getCust_ic_no().equals(icNum)
				&&e.getCard_post_flag().toUpperCase().equals("SP")
				&&e.getCard_no().startsWith("5")
				)).collect(Collectors.toList());
		
				if(ownerSPMaster!=null&&ownerSPMaster.size()>0) {
					resultList.addAll(ownerSPMaster);
				}
				
		if(icNumNoOwnerList!=null&&icNumNoOwnerList.size()>0) {
			for(String ic:icNumNoOwnerList){
					//SP
				List<CardHolderTotalPointDTO> otherSPAmex = cardTotalPoint.stream().filter(
						e->(
						e.getCust_ic_no().equals(ic)
						&&e.getCard_post_flag().toUpperCase().equals("SP")
						&&(e.getCard_no().startsWith("03")||e.getCard_no().startsWith("3"))
						)).collect(Collectors.toList());
				
						if(otherSPAmex!=null&&otherSPAmex.size()>0) {
							resultList.addAll(otherSPAmex);
						}
						
				List<CardHolderTotalPointDTO> otherSPVisa = cardTotalPoint.stream().filter(
						e->(
						e.getCust_ic_no().equals(ic)
						&&e.getCard_post_flag().toUpperCase().equals("SP")
						&&e.getCard_no().startsWith("4")
						)).collect(Collectors.toList());
				
						if(otherSPVisa!=null&&otherSPVisa.size()>0) {
							resultList.addAll(otherSPVisa);
						}
					
				List<CardHolderTotalPointDTO> otherSPMaster = cardTotalPoint.stream().filter(
						e->(
						e.getCust_ic_no().equals(ic)
						&&e.getCard_post_flag().toUpperCase().equals("SP")
						&&e.getCard_no().startsWith("5")
						)).collect(Collectors.toList());				
				
						if(otherSPMaster!=null&&otherSPMaster.size()>0) {
							resultList.addAll(otherSPMaster);
						}
			}
			
			for(String ic:icNumNoOwnerList){
				//NP
				List<CardHolderTotalPointDTO> otherNPAmex = cardTotalPoint.stream().filter(
						e->(
						e.getCust_ic_no().equals(ic)
						&&e.getCard_post_flag().toUpperCase().equals("NP")
						&&(e.getCard_no().startsWith("03")||e.getCard_no().startsWith("3"))
						)).collect(Collectors.toList());
				
						if(otherNPAmex!=null&&otherNPAmex.size()>0) {
							resultList.addAll(otherNPAmex);
						}
				
				List<CardHolderTotalPointDTO> otherNPVisa = cardTotalPoint.stream().filter(
						e->(
						e.getCust_ic_no().equals(ic)
						&&e.getCard_post_flag().toUpperCase().equals("NP")
						&&e.getCard_no().startsWith("4")
						)).collect(Collectors.toList());
				
						if(otherNPVisa!=null&&otherNPVisa.size()>0) {
							resultList.addAll(otherNPVisa);
						}
				
				List<CardHolderTotalPointDTO> otherNPMaster = cardTotalPoint.stream().filter(
						e->(
						e.getCust_ic_no().equals(ic)
						&&e.getCard_post_flag().toUpperCase().equals("NP")
						&&e.getCard_no().startsWith("5")
						)).collect(Collectors.toList());
				
						if(otherNPMaster!=null&&otherNPMaster.size()>0) {
							resultList.addAll(otherNPMaster);
						}
			}
		}
		
		return resultList;
	
	}
	
	public static ArrayList<CardHolderTotalPointDTO> getCardRedeemableList(ProductRedemptionDao productRedemptionDao,
			String icNum, BigDecimal rewardtypeId) {
		
		ArrayList<CardHolderTotalPointDTO> resultList = new ArrayList<CardHolderTotalPointDTO>();
		
		//Get Redeemable Card List
		List<CardHolderTotalPointDTO> icOwnerCardList = productRedemptionDao.getCardHolderTotalPoint(icNum,
				null, rewardtypeId);
		if(icOwnerCardList==null||icOwnerCardList.size()==0) {
			return null;
		}
		resultList.addAll(icOwnerCardList);
		printCardNum(icOwnerCardList,"OWNER");
		//Get Owner PP and XX cust no
		List<String> custNoList = icOwnerCardList.stream()
				.filter( cl -> ("PP".equals(cl.getCard_post_flag().toUpperCase())||"XX".equals(cl.getCard_post_flag().toUpperCase())))
				.map(e -> e.getCust_no()).collect(Collectors.toList());		
		
		//Get Sup(Not Owner) Card
		List<CardHolderTotalPointDTO> supCardList = productRedemptionDao.getSupCardHolderTotalPoint(custNoList, rewardtypeId);
		if(supCardList!=null&&supCardList.size()>0) {
			resultList.addAll(supCardList);
			printCardNum(supCardList,"SUP");
		}
		
		resultList = distinctTotalPointList(resultList);
		
		printCardNum(resultList,"ALL");
		
		resultList = sortList(resultList, icNum);
		
		printCardNum(resultList,"ALL - SORTED");
		
		return resultList;
	}
	
	public static ArrayList<CardHolderTotalPointDTO> distinctTotalPointList(List<CardHolderTotalPointDTO> inputList){
		ArrayList<CardHolderTotalPointDTO> resultList = new ArrayList<CardHolderTotalPointDTO>();
		
		for(CardHolderTotalPointDTO input:inputList) {
			boolean foundCard = false;
			for(CardHolderTotalPointDTO result:resultList) {
				if(input.getCard_no().equals(result.getCard_no())) {
					foundCard=true;
					break;
				}
			}
			if(foundCard==false) {
				resultList.add(input);
			}
		}
		
		return resultList;
	}
	
	public static ArrayList<CardHolderBucketDetailDTO> getCardRedeemableBucketList(ProductRedemptionDao productRedemptionDao,
			String icNum, BigDecimal rewardtypeId) {
		
		ArrayList<CardHolderBucketDetailDTO> resultList = new ArrayList<CardHolderBucketDetailDTO>();
		
		//Get Redeemable Card List
		List<CardHolderBucketDetailDTO> icOwnerCardList = productRedemptionDao.getCardHolderBucket(icNum, rewardtypeId);
		if(icOwnerCardList==null||icOwnerCardList.size()==0) {
			return null;
		}
		resultList.addAll(icOwnerCardList);
		printCardNumBucket(icOwnerCardList,"OWNER");
		//Get Owner PP and XX cust no
		List<String> custNoList = icOwnerCardList.stream()
				.filter( cl -> ("PP".equals(cl.getCard_post_flag().toUpperCase())||"XX".equals(cl.getCard_post_flag().toUpperCase())))
				.map(e -> e.getCust_no()).collect(Collectors.toList());		
		
		//Get Sup(Not Owner) Card
		List<CardHolderBucketDetailDTO> supCardList = productRedemptionDao.getSupCardHolderBucket(custNoList, rewardtypeId);
		if(supCardList!=null&&supCardList.size()>0) {		
			resultList.addAll(supCardList);
			printCardNumBucket(supCardList,"SUP");
		}
					
		resultList = distinctBucketList(resultList);
		
		printCardNumBucket(resultList,"ALL");
		
		resultList = sortBucketList(resultList, icNum);
		
		printCardNumBucket(resultList,"ALL - SORTED");
		
		return resultList;
	}
	
	public static ArrayList<CardHolderBucketDetailDTO> getAirlineCardRedeemableBucketList(ProductRedemptionDao productRedemptionDao,
			String icNum, BigDecimal rewardtypeId, List<Integer> platicTypeList) {
		
		ArrayList<CardHolderBucketDetailDTO> resultList = new ArrayList<CardHolderBucketDetailDTO>();
		
		//Get Redeemable Card List
		List<CardHolderBucketDetailDTO> icOwnerCardList = productRedemptionDao.getCardHolderBucketAirline(icNum, rewardtypeId, platicTypeList);
		if(icOwnerCardList==null||icOwnerCardList.size()==0) {
			return null;
		}
		resultList.addAll(icOwnerCardList);
		printCardNumBucket(icOwnerCardList,"OWNER");
		//Get Owner PP and XX cust no
		List<String> custNoList = icOwnerCardList.stream()
				.filter( cl -> ("PP".equals(cl.getCard_post_flag().toUpperCase())||"XX".equals(cl.getCard_post_flag().toUpperCase())))
				.map(e -> e.getCust_no()).collect(Collectors.toList());		
		
		//Get Sup(Not Owner) Card
		List<CardHolderBucketDetailDTO> supCardList = productRedemptionDao.getSupCardHolderBucketAirline(custNoList, rewardtypeId, platicTypeList);
		if(supCardList!=null&&supCardList.size()>0) {		
			resultList.addAll(supCardList);
			printCardNumBucket(supCardList,"SUP");
		}
					
		resultList = distinctBucketList(resultList);
		
		printCardNumBucket(resultList,"ALL");
		
		resultList = sortBucketList(resultList, icNum);
		
		printCardNumBucket(resultList,"ALL - SORTED");
		
		return resultList;
	}
	
	public static ArrayList<CardHolderBucketDetailDTO> getTerminalCardRedeemableBucketList(ProductRedemptionDao productRedemptionDao,
			String icNum, BigDecimal rewardtypeId, String rewardTypeCode) {
		
		ArrayList<CardHolderBucketDetailDTO> resultList = new ArrayList<CardHolderBucketDetailDTO>();
		
		//Get Redeemable Card List
		List<CardHolderBucketDetailDTO> icOwnerCardList = productRedemptionDao.getCardHolderBucket(icNum, rewardtypeId);
		if(icOwnerCardList==null||icOwnerCardList.size()==0) {
			return null;
		}
		resultList.addAll(icOwnerCardList);
		printCardNumBucket(icOwnerCardList,"OWNER");
		
		if(rewardTypeCode.equals(MBBORSConstant.REWARD_TYPE_CODE_TP)) {
			//Get Owner PP and XX cust no
			List<String> custNoList = icOwnerCardList.stream()
					.filter( cl -> ("PP".equals(cl.getCard_post_flag().toUpperCase())||"XX".equals(cl.getCard_post_flag().toUpperCase())))
					.map(e -> e.getCust_no()).collect(Collectors.toList());		
	
			//Get Sup(Not Owner) Card
			List<CardHolderBucketDetailDTO> supCardList = productRedemptionDao.getSupCardHolderBucket(custNoList, rewardtypeId);
			if(supCardList!=null&&supCardList.size()>0) {		
				resultList.addAll(supCardList);
				printCardNumBucket(supCardList,"SUP");
			}
		}
					
		resultList = distinctBucketList(resultList);
		
		printCardNumBucket(resultList,"ALL");
		
		resultList = sortTerminalBucketList(resultList, icNum, rewardTypeCode);
		
		printCardNumBucket(resultList,"ALL - SORTED");
		
		return resultList;
	}
	
	public static ArrayList<CardHolderBucketDetailDTO> distinctBucketList(List<CardHolderBucketDetailDTO> inputList){
		ArrayList<CardHolderBucketDetailDTO> resultList = new ArrayList<CardHolderBucketDetailDTO>();
		
		for(CardHolderBucketDetailDTO input:inputList) {
			boolean foundCard = false;
			for(CardHolderBucketDetailDTO result:resultList) {
				if(input.getCard_no().equals(result.getCard_no())) {
					foundCard=true;
					break;
				}
			}
			if(foundCard==false) {
				resultList.add(input);
			}
		}
		
		return resultList;
	}
	
	public static void printCardNumBucket(List<CardHolderBucketDetailDTO> cardTotalPointList, String tag) {
		System.out.println(tag.concat(" List Size : ").concat(Integer.toString(cardTotalPointList.size())));
		for(CardHolderBucketDetailDTO  cardTotalPoint :cardTotalPointList) {
			System.out.println(cardTotalPoint.getCard_no());
		}
	}
	
	public static ArrayList<CardHolderBucketDetailDTO> sortBucketList(List<CardHolderBucketDetailDTO> cardTotalPoint, String icNum) {
		
		List<String> icNumNoOwnerList = new ArrayList<String>();
		Comparator<CardHolderBucketDetailDTO> compareByIcNum = Comparator
                .comparing(CardHolderBucketDetailDTO::getCust_ic_no);
		
		ArrayList<CardHolderBucketDetailDTO> resultList = new ArrayList<CardHolderBucketDetailDTO>();
		
		icNumNoOwnerList = cardTotalPoint.stream().filter(e->!e.getCust_ic_no().equals(icNum)).sorted(compareByIcNum)
				.map(e->e.getCust_ic_no()).collect(Collectors.toList());
		
		Set<String> set = new HashSet<>(icNumNoOwnerList);
		icNumNoOwnerList.clear();
		icNumNoOwnerList.addAll(set);
		
				//PP
				resultList.addAll(cardTotalPoint.stream().filter(
						e->(
						e.getCust_ic_no().equals(icNum)
						&&e.getCard_post_flag().toUpperCase().equals("PP")
						&&(e.getCard_no().startsWith("03")||e.getCard_no().startsWith("3"))
						)).collect(Collectors.toList()));
				
				resultList.addAll(cardTotalPoint.stream().filter(
						e->(
						e.getCust_ic_no().equals(icNum)
						&&e.getCard_post_flag().toUpperCase().equals("PP")
						&&e.getCard_no().startsWith("4")
						)).collect(Collectors.toList()));
				
				resultList.addAll(cardTotalPoint.stream().filter(
						e->(
						e.getCust_ic_no().equals(icNum)
						&&e.getCard_post_flag().toUpperCase().equals("PP")
						&&e.getCard_no().startsWith("5")
						)).collect(Collectors.toList()));
				
				resultList.addAll(cardTotalPoint.stream().filter(
						e->(
						e.getCust_ic_no().equals(icNum)
						&&(e.getCard_post_flag().toUpperCase().equals("PP")||e.getCard_post_flag().toUpperCase().equals("XX"))
						&&e.getCard_no().startsWith("8")
						)).collect(Collectors.toList()));
				
				//SP
				resultList.addAll(cardTotalPoint.stream().filter(
						e->(
						e.getCust_ic_no().equals(icNum)
						&&e.getCard_post_flag().toUpperCase().equals("SP")
						&&(e.getCard_no().startsWith("03")||e.getCard_no().startsWith("3"))
						)).collect(Collectors.toList()));
				
				resultList.addAll(cardTotalPoint.stream().filter(
						e->(
						e.getCust_ic_no().equals(icNum)
						&&e.getCard_post_flag().toUpperCase().equals("SP")
						&&e.getCard_no().startsWith("4")
						)).collect(Collectors.toList()));
				
				resultList.addAll(cardTotalPoint.stream().filter(
						e->(
						e.getCust_ic_no().equals(icNum)
						&&e.getCard_post_flag().toUpperCase().equals("SP")
						&&e.getCard_no().startsWith("5")
						)).collect(Collectors.toList()));
		
		for(String ic:icNumNoOwnerList){
				//SP
				resultList.addAll(cardTotalPoint.stream().filter(
						e->(
						e.getCust_ic_no().equals(ic)
						&&e.getCard_post_flag().toUpperCase().equals("SP")
						&&(e.getCard_no().startsWith("03")||e.getCard_no().startsWith("3"))
						)).collect(Collectors.toList()));
				
				resultList.addAll(cardTotalPoint.stream().filter(
						e->(
						e.getCust_ic_no().equals(ic)
						&&e.getCard_post_flag().toUpperCase().equals("SP")
						&&e.getCard_no().startsWith("4")
						)).collect(Collectors.toList()));
				
				resultList.addAll(cardTotalPoint.stream().filter(
						e->(
						e.getCust_ic_no().equals(ic)
						&&e.getCard_post_flag().toUpperCase().equals("SP")
						&&e.getCard_no().startsWith("5")
						)).collect(Collectors.toList()));
		}
		
		for(String ic:icNumNoOwnerList){
			//SP
			resultList.addAll(cardTotalPoint.stream().filter(
					e->(
					e.getCust_ic_no().equals(ic)
					&&e.getCard_post_flag().toUpperCase().equals("NP")
					&&(e.getCard_no().startsWith("03")||e.getCard_no().startsWith("3"))
					)).collect(Collectors.toList()));
			
			resultList.addAll(cardTotalPoint.stream().filter(
					e->(
					e.getCust_ic_no().equals(ic)
					&&e.getCard_post_flag().toUpperCase().equals("NP")
					&&e.getCard_no().startsWith("4")
					)).collect(Collectors.toList()));
			
			resultList.addAll(cardTotalPoint.stream().filter(
					e->(
					e.getCust_ic_no().equals(ic)
					&&e.getCard_post_flag().toUpperCase().equals("NP")
					&&e.getCard_no().startsWith("5")
					)).collect(Collectors.toList()));
		}
		
		return resultList;
	
	}
	
	public static ArrayList<CardHolderBucketDetailDTO> sortTerminalBucketList(List<CardHolderBucketDetailDTO> cardTotalPoint, String icNum, String rewardTypeCode) {
		
		List<String> icNumNoOwnerList = new ArrayList<String>();
		Comparator<CardHolderBucketDetailDTO> compareByIcNum = Comparator
                .comparing(CardHolderBucketDetailDTO::getCust_ic_no);
		
		ArrayList<CardHolderBucketDetailDTO> resultList = new ArrayList<CardHolderBucketDetailDTO>();
		
		icNumNoOwnerList = cardTotalPoint.stream().filter(e->!e.getCust_ic_no().equals(icNum)).sorted(compareByIcNum)
				.map(e->e.getCust_ic_no()).collect(Collectors.toList());
		
		Set<String> set = new HashSet<>(icNumNoOwnerList);
		icNumNoOwnerList.clear();
		icNumNoOwnerList.addAll(set);
		
				//PP
				resultList.addAll(cardTotalPoint.stream().filter(
						e->(
						e.getCust_ic_no().equals(icNum)
						&&e.getCard_post_flag().toUpperCase().equals("PP")
						&&(e.getCard_no().startsWith("03")||e.getCard_no().startsWith("3"))
						)).collect(Collectors.toList()));
				
				resultList.addAll(cardTotalPoint.stream().filter(
						e->(
						e.getCust_ic_no().equals(icNum)
						&&e.getCard_post_flag().toUpperCase().equals("PP")
						&&e.getCard_no().startsWith("4")
						)).collect(Collectors.toList()));
				
				resultList.addAll(cardTotalPoint.stream().filter(
						e->(
						e.getCust_ic_no().equals(icNum)
						&&e.getCard_post_flag().toUpperCase().equals("PP")
						&&e.getCard_no().startsWith("5")
						)).collect(Collectors.toList()));
				
				resultList.addAll(cardTotalPoint.stream().filter(
						e->(
						e.getCust_ic_no().equals(icNum)
						&&(e.getCard_post_flag().toUpperCase().equals("PP")||e.getCard_post_flag().toUpperCase().equals("XX"))
						&&e.getCard_no().startsWith("8")
						)).collect(Collectors.toList()));
				
		if(rewardTypeCode.equals(MBBORSConstant.REWARD_TYPE_CODE_TP)) {		
			
					//SP
					resultList.addAll(cardTotalPoint.stream().filter(
							e->(
							e.getCust_ic_no().equals(icNum)
							&&e.getCard_post_flag().toUpperCase().equals("SP")
							&&(e.getCard_no().startsWith("03")||e.getCard_no().startsWith("3"))
							)).collect(Collectors.toList()));
					
					resultList.addAll(cardTotalPoint.stream().filter(
							e->(
							e.getCust_ic_no().equals(icNum)
							&&e.getCard_post_flag().toUpperCase().equals("SP")
							&&e.getCard_no().startsWith("4")
							)).collect(Collectors.toList()));
					
					resultList.addAll(cardTotalPoint.stream().filter(
							e->(
							e.getCust_ic_no().equals(icNum)
							&&e.getCard_post_flag().toUpperCase().equals("SP")
							&&e.getCard_no().startsWith("5")
							)).collect(Collectors.toList()));
			
			for(String ic:icNumNoOwnerList){
					//SP
					resultList.addAll(cardTotalPoint.stream().filter(
							e->(
							e.getCust_ic_no().equals(ic)
							&&e.getCard_post_flag().toUpperCase().equals("SP")
							&&(e.getCard_no().startsWith("03")||e.getCard_no().startsWith("3"))
							)).collect(Collectors.toList()));
					
					resultList.addAll(cardTotalPoint.stream().filter(
							e->(
							e.getCust_ic_no().equals(ic)
							&&e.getCard_post_flag().toUpperCase().equals("SP")
							&&e.getCard_no().startsWith("4")
							)).collect(Collectors.toList()));
					
					resultList.addAll(cardTotalPoint.stream().filter(
							e->(
							e.getCust_ic_no().equals(ic)
							&&e.getCard_post_flag().toUpperCase().equals("SP")
							&&e.getCard_no().startsWith("5")
							)).collect(Collectors.toList()));
			}
			
			for(String ic:icNumNoOwnerList){
				//SP
				resultList.addAll(cardTotalPoint.stream().filter(
						e->(
						e.getCust_ic_no().equals(ic)
						&&e.getCard_post_flag().toUpperCase().equals("NP")
						&&(e.getCard_no().startsWith("03")||e.getCard_no().startsWith("3"))
						)).collect(Collectors.toList()));
				
				resultList.addAll(cardTotalPoint.stream().filter(
						e->(
						e.getCust_ic_no().equals(ic)
						&&e.getCard_post_flag().toUpperCase().equals("NP")
						&&e.getCard_no().startsWith("4")
						)).collect(Collectors.toList()));
				
				resultList.addAll(cardTotalPoint.stream().filter(
						e->(
						e.getCust_ic_no().equals(ic)
						&&e.getCard_post_flag().toUpperCase().equals("NP")
						&&e.getCard_no().startsWith("5")
						)).collect(Collectors.toList()));
			}
		}
		return resultList;
	
	}
	
	public static ArrayList<CardHolderBucketDetailDTO> getDeductedPointBucket01List(ArrayList<CardHolderBucketDetailDTO> listFromDB
			,BigDecimal totalProductPoint){
		
		ArrayList<CardHolderBucketDetailDTO> resultList = new ArrayList<>(listFromDB);
		
		//01
		for(int ind=0;ind<resultList.size();ind++) {
			
			CardHolderBucketDetailDTO cardBucketDetails =  new CardHolderBucketDetailDTO(resultList.get(ind));
			
			if(totalProductPoint.compareTo(BigDecimal.ZERO)>0
					&&cardBucketDetails.getBucket01_point_bal()!=null
					&&cardBucketDetails.getBucket01_point_bal().compareTo(BigDecimal.ZERO)>0
					&&cardBucketDetails.getBucket01_point_sign().equals("+")
					) {
				
				if(cardBucketDetails.getBucket01_point_bal().compareTo(totalProductPoint)>=0) {
					cardBucketDetails.setTotal_points_bal(
							cardBucketDetails.getTotal_points_bal().subtract(totalProductPoint));
					cardBucketDetails.setBucket01_point_bal(
							cardBucketDetails.getBucket01_point_bal().subtract(totalProductPoint));
					totalProductPoint = BigDecimal.ZERO;
				}
				
				if(cardBucketDetails.getBucket01_point_bal().compareTo(totalProductPoint) < 0) {
					totalProductPoint=totalProductPoint.subtract(cardBucketDetails.getBucket01_point_bal());
					cardBucketDetails.setTotal_points_bal(
							cardBucketDetails.getTotal_points_bal().subtract(
									cardBucketDetails.getBucket01_point_bal()));
					cardBucketDetails.setBucket01_point_bal(BigDecimal.ZERO);
				}
				cardBucketDetails.setDeducted(true);
				resultList.set(ind, cardBucketDetails);
				
				if(totalProductPoint.compareTo(BigDecimal.ZERO)==0) {
					break;
				}
			}
			
		}
		
		if(totalProductPoint.compareTo(BigDecimal.ZERO)>0) {
			return null;
		}
		
		return resultList;
	}
	
	public static ArrayList<CardHolderBucketDetailDTO> getDeductedPointBucket36List(ArrayList<CardHolderBucketDetailDTO> listFromDB
			,BigDecimal totalProductPoint){
		
		ArrayList<CardHolderBucketDetailDTO> resultList = new ArrayList<>(listFromDB);
		
		//36
		for(int ind=0;ind<resultList.size();ind++) {
			
			CardHolderBucketDetailDTO cardBucketDetails = new CardHolderBucketDetailDTO(resultList.get(ind));
			
			
			if(totalProductPoint.compareTo(BigDecimal.ZERO)>0
					&&cardBucketDetails.getBucket36_point_bal()!=null
					&&cardBucketDetails.getBucket36_point_bal().compareTo(BigDecimal.ZERO)>0
					&&cardBucketDetails.getBucket36_point_sign().equals("+")
					) {
				
				if(cardBucketDetails.getBucket36_point_bal().compareTo(totalProductPoint)>=0) {
					cardBucketDetails.setTotal_points_bal(
							cardBucketDetails.getTotal_points_bal().subtract(totalProductPoint));
					cardBucketDetails.setBucket36_point_bal(
							cardBucketDetails.getBucket36_point_bal().subtract(totalProductPoint));
					totalProductPoint = BigDecimal.ZERO;
				}else{
					totalProductPoint=totalProductPoint.subtract(cardBucketDetails.getBucket36_point_bal());
					cardBucketDetails.setTotal_points_bal(
							cardBucketDetails.getTotal_points_bal().subtract(
									cardBucketDetails.getBucket36_point_bal()));
					cardBucketDetails.setBucket36_point_bal(BigDecimal.ZERO);
					
				}
				cardBucketDetails.setDeducted(true);
				resultList.set(ind,cardBucketDetails);
				
				if(totalProductPoint.compareTo(BigDecimal.ZERO)==0) {
					break;
				}
			}
			
		}
		
		//35
		for(int ind=0;ind<resultList.size();ind++) {
			
			CardHolderBucketDetailDTO cardBucketDetails =  new CardHolderBucketDetailDTO(resultList.get(ind));
			
			
			if(totalProductPoint.compareTo(BigDecimal.ZERO)>0
					&&cardBucketDetails.getBucket35_point_bal()!=null
					&&cardBucketDetails.getBucket35_point_bal().compareTo(BigDecimal.ZERO)>0
					&&cardBucketDetails.getBucket35_point_sign().equals("+")
					) {
				
				if(cardBucketDetails.getBucket35_point_bal().compareTo(totalProductPoint)>=0) {
					cardBucketDetails.setTotal_points_bal(
							cardBucketDetails.getTotal_points_bal().subtract(totalProductPoint));
					cardBucketDetails.setBucket35_point_bal(
							cardBucketDetails.getBucket35_point_bal().subtract(totalProductPoint));
					totalProductPoint = BigDecimal.ZERO;
				}else{
					totalProductPoint=totalProductPoint.subtract(cardBucketDetails.getBucket35_point_bal());
					cardBucketDetails.setTotal_points_bal(
							cardBucketDetails.getTotal_points_bal().subtract(
									cardBucketDetails.getBucket35_point_bal()));
					cardBucketDetails.setBucket35_point_bal(BigDecimal.ZERO);
					
				}
				cardBucketDetails.setDeducted(true);
				resultList.set(ind, cardBucketDetails);
				
				if(totalProductPoint.compareTo(BigDecimal.ZERO)==0) {
					break;
				}
			}
			
		}
		
		//34
		for(int ind=0;ind<resultList.size();ind++) {
			
			CardHolderBucketDetailDTO cardBucketDetails =  new CardHolderBucketDetailDTO(resultList.get(ind));
			
			
			if(totalProductPoint.compareTo(BigDecimal.ZERO)>0
					&&cardBucketDetails.getBucket34_point_bal()!=null
					&&cardBucketDetails.getBucket34_point_bal().compareTo(BigDecimal.ZERO)>0
					&&cardBucketDetails.getBucket34_point_sign().equals("+")
					) {
				
				if(cardBucketDetails.getBucket34_point_bal().compareTo(totalProductPoint)>=0) {
					cardBucketDetails.setTotal_points_bal(
							cardBucketDetails.getTotal_points_bal().subtract(totalProductPoint));
					cardBucketDetails.setBucket34_point_bal(
							cardBucketDetails.getBucket34_point_bal().subtract(totalProductPoint));
					totalProductPoint = BigDecimal.ZERO;
				}else{
					totalProductPoint=totalProductPoint.subtract(cardBucketDetails.getBucket34_point_bal());
					cardBucketDetails.setTotal_points_bal(
							cardBucketDetails.getTotal_points_bal().subtract(
									cardBucketDetails.getBucket34_point_bal()));
					cardBucketDetails.setBucket34_point_bal(BigDecimal.ZERO);
				}
				cardBucketDetails.setDeducted(true);
				resultList.set(ind, cardBucketDetails);
				
				if(totalProductPoint.compareTo(BigDecimal.ZERO)==0) {
					break;
				}
			}
			
		}
		
		//33
		for(int ind=0;ind<resultList.size();ind++) {
			
			CardHolderBucketDetailDTO cardBucketDetails =  new CardHolderBucketDetailDTO(resultList.get(ind));
			
			
			if(totalProductPoint.compareTo(BigDecimal.ZERO)>0
					&&cardBucketDetails.getBucket33_point_bal()!=null
					&&cardBucketDetails.getBucket33_point_bal().compareTo(BigDecimal.ZERO)>0
					&&cardBucketDetails.getBucket33_point_sign().equals("+")
					) {
				
				if(cardBucketDetails.getBucket33_point_bal().compareTo(totalProductPoint)>=0) {
					cardBucketDetails.setTotal_points_bal(
							cardBucketDetails.getTotal_points_bal().subtract(totalProductPoint));
					cardBucketDetails.setBucket33_point_bal(
							cardBucketDetails.getBucket33_point_bal().subtract(totalProductPoint));
					totalProductPoint = BigDecimal.ZERO;				
				}else{
					totalProductPoint=totalProductPoint.subtract(cardBucketDetails.getBucket33_point_bal());
					cardBucketDetails.setTotal_points_bal(
							cardBucketDetails.getTotal_points_bal().subtract(
									cardBucketDetails.getBucket33_point_bal()));
					cardBucketDetails.setBucket33_point_bal(BigDecimal.ZERO);
					
				}
				cardBucketDetails.setDeducted(true);
				resultList.set(ind, cardBucketDetails);
				
				if(totalProductPoint.compareTo(BigDecimal.ZERO)==0) {
					break;
				}
			}
			
		}
		
		//32
		for(int ind=0;ind<resultList.size();ind++) {
			
			CardHolderBucketDetailDTO cardBucketDetails =  new CardHolderBucketDetailDTO(resultList.get(ind));
			
			
			if(totalProductPoint.compareTo(BigDecimal.ZERO)>0
					&&cardBucketDetails.getBucket32_point_bal()!=null
					&&cardBucketDetails.getBucket32_point_bal().compareTo(BigDecimal.ZERO)>0
					&&cardBucketDetails.getBucket32_point_sign().equals("+")
					) {
				
				if(cardBucketDetails.getBucket32_point_bal().compareTo(totalProductPoint)>=0) {
					cardBucketDetails.setTotal_points_bal(
							cardBucketDetails.getTotal_points_bal().subtract(totalProductPoint));
					cardBucketDetails.setBucket32_point_bal(
							cardBucketDetails.getBucket32_point_bal().subtract(totalProductPoint));					
					totalProductPoint = BigDecimal.ZERO;
				}else{
					totalProductPoint=totalProductPoint.subtract(cardBucketDetails.getBucket32_point_bal());
					cardBucketDetails.setTotal_points_bal(
							cardBucketDetails.getTotal_points_bal().subtract(
									cardBucketDetails.getBucket32_point_bal()));
					cardBucketDetails.setBucket32_point_bal(BigDecimal.ZERO);					
				}
				cardBucketDetails.setDeducted(true);
				resultList.set(ind, cardBucketDetails);
				
				if(totalProductPoint.compareTo(BigDecimal.ZERO)==0) {
					break;
				}
			}
			
		}
		
		//31
		for(int ind=0;ind<resultList.size();ind++) {
			
			CardHolderBucketDetailDTO cardBucketDetails =  new CardHolderBucketDetailDTO(resultList.get(ind));
			
			
			if(totalProductPoint.compareTo(BigDecimal.ZERO)>0
					&&cardBucketDetails.getBucket31_point_bal()!=null
					&&cardBucketDetails.getBucket31_point_bal().compareTo(BigDecimal.ZERO)>0
					&&cardBucketDetails.getBucket31_point_sign().equals("+")
					) {
				
				if(cardBucketDetails.getBucket31_point_bal().compareTo(totalProductPoint)>=0) {
					cardBucketDetails.setTotal_points_bal(
							cardBucketDetails.getTotal_points_bal().subtract(totalProductPoint));
					cardBucketDetails.setBucket31_point_bal(
							cardBucketDetails.getBucket31_point_bal().subtract(totalProductPoint));
					totalProductPoint = BigDecimal.ZERO;
				}else{
					totalProductPoint=totalProductPoint.subtract(cardBucketDetails.getBucket31_point_bal());
					cardBucketDetails.setTotal_points_bal(
							cardBucketDetails.getTotal_points_bal().subtract(
									cardBucketDetails.getBucket31_point_bal()));
					cardBucketDetails.setBucket31_point_bal(BigDecimal.ZERO);
					
				}
				cardBucketDetails.setDeducted(true);
				resultList.set(ind, cardBucketDetails);
				
				if(totalProductPoint.compareTo(BigDecimal.ZERO)==0) {
					break;
				}
			}
			
		}
		
		//30
		for(int ind=0;ind<resultList.size();ind++) {
			
			CardHolderBucketDetailDTO cardBucketDetails =  new CardHolderBucketDetailDTO(resultList.get(ind));
			
			
			if(totalProductPoint.compareTo(BigDecimal.ZERO)>0
					&&cardBucketDetails.getBucket30_point_bal()!=null
					&&cardBucketDetails.getBucket30_point_bal().compareTo(BigDecimal.ZERO)>0
					&&cardBucketDetails.getBucket30_point_sign().equals("+")
					) {
				
				if(cardBucketDetails.getBucket30_point_bal().compareTo(totalProductPoint)>=0) {
					cardBucketDetails.setTotal_points_bal(
							cardBucketDetails.getTotal_points_bal().subtract(totalProductPoint));
					cardBucketDetails.setBucket30_point_bal(
							cardBucketDetails.getBucket30_point_bal().subtract(totalProductPoint));
					totalProductPoint = BigDecimal.ZERO;
				}else{
					totalProductPoint=totalProductPoint.subtract(cardBucketDetails.getBucket30_point_bal());
					cardBucketDetails.setTotal_points_bal(
							cardBucketDetails.getTotal_points_bal().subtract(
									cardBucketDetails.getBucket30_point_bal()));
					cardBucketDetails.setBucket30_point_bal(BigDecimal.ZERO);
			
				}
				cardBucketDetails.setDeducted(true);
				resultList.set(ind, cardBucketDetails);
				
				if(totalProductPoint.compareTo(BigDecimal.ZERO)==0) {
					break;
				}
			}
			
		}
		
		//29
		for(int ind=0;ind<resultList.size();ind++) {
			
			CardHolderBucketDetailDTO cardBucketDetails =  new CardHolderBucketDetailDTO(resultList.get(ind));
			
			
			if(totalProductPoint.compareTo(BigDecimal.ZERO)>0
					&&cardBucketDetails.getBucket29_point_bal()!=null
					&&cardBucketDetails.getBucket29_point_bal().compareTo(BigDecimal.ZERO)>0
					&&cardBucketDetails.getBucket29_point_sign().equals("+")
					) {
				
				if(cardBucketDetails.getBucket29_point_bal().compareTo(totalProductPoint)>=0) {
					cardBucketDetails.setTotal_points_bal(
							cardBucketDetails.getTotal_points_bal().subtract(totalProductPoint));
					cardBucketDetails.setBucket29_point_bal(
							cardBucketDetails.getBucket29_point_bal().subtract(totalProductPoint));
					
					totalProductPoint = BigDecimal.ZERO;
				}else{
					totalProductPoint=totalProductPoint.subtract(cardBucketDetails.getBucket29_point_bal());
					cardBucketDetails.setTotal_points_bal(
							cardBucketDetails.getTotal_points_bal().subtract(
									cardBucketDetails.getBucket29_point_bal()));
					cardBucketDetails.setBucket29_point_bal(BigDecimal.ZERO);
				
				}
				cardBucketDetails.setDeducted(true);
				resultList.set(ind, cardBucketDetails);
				
				if(totalProductPoint.compareTo(BigDecimal.ZERO)==0) {
					break;
				}
			}
			
		}
		
		//28
		for(int ind=0;ind<resultList.size();ind++) {
			
			CardHolderBucketDetailDTO cardBucketDetails =  new CardHolderBucketDetailDTO(resultList.get(ind));
			
			
			if(totalProductPoint.compareTo(BigDecimal.ZERO)>0
					&&cardBucketDetails.getBucket28_point_bal()!=null
					&&cardBucketDetails.getBucket28_point_bal().compareTo(BigDecimal.ZERO)>0
					&&cardBucketDetails.getBucket28_point_sign().equals("+")
					) {
				
				if(cardBucketDetails.getBucket28_point_bal().compareTo(totalProductPoint)>=0) {
					cardBucketDetails.setTotal_points_bal(
							cardBucketDetails.getTotal_points_bal().subtract(totalProductPoint));
					cardBucketDetails.setBucket28_point_bal(
							cardBucketDetails.getBucket28_point_bal().subtract(totalProductPoint));
					totalProductPoint = BigDecimal.ZERO;
				}else {
					totalProductPoint=totalProductPoint.subtract(cardBucketDetails.getBucket28_point_bal());
					cardBucketDetails.setTotal_points_bal(
							cardBucketDetails.getTotal_points_bal().subtract(
									cardBucketDetails.getBucket28_point_bal()));
					cardBucketDetails.setBucket28_point_bal(BigDecimal.ZERO);				
				}
				cardBucketDetails.setDeducted(true);
				resultList.set(ind, cardBucketDetails);
				
				if(totalProductPoint.compareTo(BigDecimal.ZERO)==0) {
					break;
				}
			}
			
		}
		
		//27
		for(int ind=0;ind<resultList.size();ind++) {
			
			CardHolderBucketDetailDTO cardBucketDetails =  new CardHolderBucketDetailDTO(resultList.get(ind));
			
			
			if(totalProductPoint.compareTo(BigDecimal.ZERO)>0
					&&cardBucketDetails.getBucket27_point_bal()!=null
					&&cardBucketDetails.getBucket27_point_bal().compareTo(BigDecimal.ZERO)>0
					&&cardBucketDetails.getBucket27_point_sign().equals("+")
					) {
				
				if(cardBucketDetails.getBucket27_point_bal().compareTo(totalProductPoint)>=0) {
					cardBucketDetails.setTotal_points_bal(
							cardBucketDetails.getTotal_points_bal().subtract(totalProductPoint));
					cardBucketDetails.setBucket27_point_bal(
							cardBucketDetails.getBucket27_point_bal().subtract(totalProductPoint));
					totalProductPoint = BigDecimal.ZERO;
				}else {
					totalProductPoint=totalProductPoint.subtract(cardBucketDetails.getBucket27_point_bal());
					cardBucketDetails.setTotal_points_bal(
							cardBucketDetails.getTotal_points_bal().subtract(
									cardBucketDetails.getBucket27_point_bal()));
					cardBucketDetails.setBucket27_point_bal(BigDecimal.ZERO);
					
				}
				cardBucketDetails.setDeducted(true);
				resultList.set(ind, cardBucketDetails);
				
				if(totalProductPoint.compareTo(BigDecimal.ZERO)==0) {
					break;
				}
			}
			
		}
		
		//26
		for(int ind=0;ind<resultList.size();ind++) {
			
			CardHolderBucketDetailDTO cardBucketDetails =  new CardHolderBucketDetailDTO(resultList.get(ind));
			
			
			if(totalProductPoint.compareTo(BigDecimal.ZERO)>0
					&&cardBucketDetails.getBucket26_point_bal()!=null
					&&cardBucketDetails.getBucket26_point_bal().compareTo(BigDecimal.ZERO)>0
					&&cardBucketDetails.getBucket26_point_sign().equals("+")
					) {
				
				if(cardBucketDetails.getBucket26_point_bal().compareTo(totalProductPoint)>=0) {
					cardBucketDetails.setTotal_points_bal(
							cardBucketDetails.getTotal_points_bal().subtract(totalProductPoint));
					cardBucketDetails.setBucket26_point_bal(
							cardBucketDetails.getBucket26_point_bal().subtract(totalProductPoint));		
					totalProductPoint = BigDecimal.ZERO;
				}else{
					totalProductPoint=totalProductPoint.subtract(cardBucketDetails.getBucket26_point_bal());
					cardBucketDetails.setTotal_points_bal(
							cardBucketDetails.getTotal_points_bal().subtract(
									cardBucketDetails.getBucket26_point_bal()));
					cardBucketDetails.setBucket26_point_bal(BigDecimal.ZERO);
					
				}
				cardBucketDetails.setDeducted(true);
				resultList.set(ind, cardBucketDetails);
				
				if(totalProductPoint.compareTo(BigDecimal.ZERO)==0) {
					break;
				}
			}
			
		}
		
		//25
		for(int ind=0;ind<resultList.size();ind++) {
			
			CardHolderBucketDetailDTO cardBucketDetails =  new CardHolderBucketDetailDTO(resultList.get(ind));
			
			
			if(totalProductPoint.compareTo(BigDecimal.ZERO)>0
					&&cardBucketDetails.getBucket25_point_bal()!=null
					&&cardBucketDetails.getBucket25_point_bal().compareTo(BigDecimal.ZERO)>0
					&&cardBucketDetails.getBucket25_point_sign().equals("+")
					) {
				
				if(cardBucketDetails.getBucket25_point_bal().compareTo(totalProductPoint)>=0) {
					cardBucketDetails.setTotal_points_bal(
							cardBucketDetails.getTotal_points_bal().subtract(totalProductPoint));
					cardBucketDetails.setBucket25_point_bal(
							cardBucketDetails.getBucket25_point_bal().subtract(totalProductPoint));
					
					totalProductPoint = BigDecimal.ZERO;
				}else{
					totalProductPoint=totalProductPoint.subtract(cardBucketDetails.getBucket25_point_bal());
					cardBucketDetails.setTotal_points_bal(
							cardBucketDetails.getTotal_points_bal().subtract(
									cardBucketDetails.getBucket25_point_bal()));
					cardBucketDetails.setBucket25_point_bal(BigDecimal.ZERO);
					
				}
				cardBucketDetails.setDeducted(true);
				resultList.set(ind, cardBucketDetails);
				
				if(totalProductPoint.compareTo(BigDecimal.ZERO)==0) {
					break;
				}
			}
			
		}
		
		//24
		for(int ind=0;ind<resultList.size();ind++) {
			
			CardHolderBucketDetailDTO cardBucketDetails =  new CardHolderBucketDetailDTO(resultList.get(ind));
			
			
			if(totalProductPoint.compareTo(BigDecimal.ZERO)>0
					&&cardBucketDetails.getBucket24_point_bal()!=null
					&&cardBucketDetails.getBucket24_point_bal().compareTo(BigDecimal.ZERO)>0
					&&cardBucketDetails.getBucket24_point_sign().equals("+")
					) {
				
				if(cardBucketDetails.getBucket24_point_bal().compareTo(totalProductPoint)>=0) {
					cardBucketDetails.setTotal_points_bal(
							cardBucketDetails.getTotal_points_bal().subtract(totalProductPoint));
					cardBucketDetails.setBucket24_point_bal(
							cardBucketDetails.getBucket24_point_bal().subtract(totalProductPoint));
					
					totalProductPoint = BigDecimal.ZERO;
				}else {
					totalProductPoint=totalProductPoint.subtract(cardBucketDetails.getBucket24_point_bal());
					cardBucketDetails.setTotal_points_bal(
							cardBucketDetails.getTotal_points_bal().subtract(
									cardBucketDetails.getBucket24_point_bal()));
					cardBucketDetails.setBucket24_point_bal(BigDecimal.ZERO);
					
				}
				cardBucketDetails.setDeducted(true);
				resultList.set(ind, cardBucketDetails);
				
				if(totalProductPoint.compareTo(BigDecimal.ZERO)==0) {
					break;
				}
			}
			
		}
		
		//23
		for(int ind=0;ind<resultList.size();ind++) {
			
			CardHolderBucketDetailDTO cardBucketDetails =  new CardHolderBucketDetailDTO(resultList.get(ind));
			
			
			if(totalProductPoint.compareTo(BigDecimal.ZERO)>0
					&&cardBucketDetails.getBucket23_point_bal()!=null
					&&cardBucketDetails.getBucket23_point_bal().compareTo(BigDecimal.ZERO)>0
					&&cardBucketDetails.getBucket23_point_sign().equals("+")
					) {
				
				if(cardBucketDetails.getBucket23_point_bal().compareTo(totalProductPoint)>=0) {
					cardBucketDetails.setTotal_points_bal(
							cardBucketDetails.getTotal_points_bal().subtract(totalProductPoint));
					cardBucketDetails.setBucket23_point_bal(
							cardBucketDetails.getBucket23_point_bal().subtract(totalProductPoint));
					
					totalProductPoint = BigDecimal.ZERO;
				}else {
					totalProductPoint=totalProductPoint.subtract(cardBucketDetails.getBucket23_point_bal());
					cardBucketDetails.setTotal_points_bal(
							cardBucketDetails.getTotal_points_bal().subtract(
									cardBucketDetails.getBucket23_point_bal()));
					cardBucketDetails.setBucket23_point_bal(BigDecimal.ZERO);
					
				}
				cardBucketDetails.setDeducted(true);
				resultList.set(ind, cardBucketDetails);
				
				if(totalProductPoint.compareTo(BigDecimal.ZERO)==0) {
					break;
				}
			}
			
		}
		
		//22
		for(int ind=0;ind<resultList.size();ind++) {
			
			CardHolderBucketDetailDTO cardBucketDetails =  new CardHolderBucketDetailDTO(resultList.get(ind));
			
			
			if(totalProductPoint.compareTo(BigDecimal.ZERO)>0
					&&cardBucketDetails.getBucket22_point_bal()!=null
					&&cardBucketDetails.getBucket22_point_bal().compareTo(BigDecimal.ZERO)>0
					&&cardBucketDetails.getBucket22_point_sign().equals("+")
					) {
				
				if(cardBucketDetails.getBucket22_point_bal().compareTo(totalProductPoint)>=0) {
					cardBucketDetails.setTotal_points_bal(
							cardBucketDetails.getTotal_points_bal().subtract(totalProductPoint));
					cardBucketDetails.setBucket22_point_bal(
							cardBucketDetails.getBucket22_point_bal().subtract(totalProductPoint));
					
					totalProductPoint = BigDecimal.ZERO;
				}else{
					totalProductPoint=totalProductPoint.subtract(cardBucketDetails.getBucket22_point_bal());
					cardBucketDetails.setTotal_points_bal(
							cardBucketDetails.getTotal_points_bal().subtract(
									cardBucketDetails.getBucket22_point_bal()));
					cardBucketDetails.setBucket22_point_bal(BigDecimal.ZERO);

				}
				cardBucketDetails.setDeducted(true);
				resultList.set(ind, cardBucketDetails);
				
				if(totalProductPoint.compareTo(BigDecimal.ZERO)==0) {
					break;
				}
			}
			
		}
		
		//21
		for(int ind=0;ind<resultList.size();ind++) {
			
			CardHolderBucketDetailDTO cardBucketDetails =  new CardHolderBucketDetailDTO(resultList.get(ind));
			
			
			if(totalProductPoint.compareTo(BigDecimal.ZERO)>0
					&&cardBucketDetails.getBucket21_point_bal()!=null
					&&cardBucketDetails.getBucket21_point_bal().compareTo(BigDecimal.ZERO)>0
					&&cardBucketDetails.getBucket21_point_sign().equals("+")
					) {
				
				if(cardBucketDetails.getBucket21_point_bal().compareTo(totalProductPoint)>=0) {
					cardBucketDetails.setTotal_points_bal(
							cardBucketDetails.getTotal_points_bal().subtract(totalProductPoint));
					cardBucketDetails.setBucket21_point_bal(
							cardBucketDetails.getBucket21_point_bal().subtract(totalProductPoint));
					totalProductPoint = BigDecimal.ZERO;
				}else{
					totalProductPoint=totalProductPoint.subtract(cardBucketDetails.getBucket21_point_bal());
					cardBucketDetails.setTotal_points_bal(
							cardBucketDetails.getTotal_points_bal().subtract(
									cardBucketDetails.getBucket21_point_bal()));
					cardBucketDetails.setBucket21_point_bal(BigDecimal.ZERO);		
				}
				cardBucketDetails.setDeducted(true);
				resultList.set(ind, cardBucketDetails);
				
				if(totalProductPoint.compareTo(BigDecimal.ZERO)==0) {
					break;
				}
			}
			
		}
		
		
		//20
		for(int ind=0;ind<resultList.size();ind++) {
			
			CardHolderBucketDetailDTO cardBucketDetails =  new CardHolderBucketDetailDTO(resultList.get(ind));
			
			
			if(totalProductPoint.compareTo(BigDecimal.ZERO)>0
					&&cardBucketDetails.getBucket20_point_bal()!=null
					&&cardBucketDetails.getBucket20_point_bal().compareTo(BigDecimal.ZERO)>0
					&&cardBucketDetails.getBucket20_point_sign().equals("+")
					) {
				
				if(cardBucketDetails.getBucket20_point_bal().compareTo(totalProductPoint)>=0) {
					cardBucketDetails.setTotal_points_bal(
							cardBucketDetails.getTotal_points_bal().subtract(totalProductPoint));
					cardBucketDetails.setBucket20_point_bal(
							cardBucketDetails.getBucket20_point_bal().subtract(totalProductPoint));
					totalProductPoint = BigDecimal.ZERO;
				}else {
					totalProductPoint=totalProductPoint.subtract(cardBucketDetails.getBucket20_point_bal());
					cardBucketDetails.setTotal_points_bal(
							cardBucketDetails.getTotal_points_bal().subtract(
									cardBucketDetails.getBucket20_point_bal()));
					cardBucketDetails.setBucket20_point_bal(BigDecimal.ZERO);
					
				}
				cardBucketDetails.setDeducted(true);
				resultList.set(ind, cardBucketDetails);
				
				if(totalProductPoint.compareTo(BigDecimal.ZERO)==0) {
					break;
				}
			}
			
		}
		
		//19
		for(int ind=0;ind<resultList.size();ind++) {
			
			CardHolderBucketDetailDTO cardBucketDetails =  new CardHolderBucketDetailDTO(resultList.get(ind));
			
			
			if(totalProductPoint.compareTo(BigDecimal.ZERO)>0
					&&cardBucketDetails.getBucket19_point_bal()!=null
					&&cardBucketDetails.getBucket19_point_bal().compareTo(BigDecimal.ZERO)>0
					&&cardBucketDetails.getBucket19_point_sign().equals("+")
					) {
				
				if(cardBucketDetails.getBucket19_point_bal().compareTo(totalProductPoint)>=0) {
					cardBucketDetails.setTotal_points_bal(
							cardBucketDetails.getTotal_points_bal().subtract(totalProductPoint));
					cardBucketDetails.setBucket19_point_bal(
							cardBucketDetails.getBucket19_point_bal().subtract(totalProductPoint));
					
					totalProductPoint = BigDecimal.ZERO;
				}else{
					totalProductPoint=totalProductPoint.subtract(cardBucketDetails.getBucket19_point_bal());
					cardBucketDetails.setTotal_points_bal(
							cardBucketDetails.getTotal_points_bal().subtract(
									cardBucketDetails.getBucket19_point_bal()));
					cardBucketDetails.setBucket19_point_bal(BigDecimal.ZERO);
					
				}
				cardBucketDetails.setDeducted(true);
				resultList.set(ind, cardBucketDetails);
				
				if(totalProductPoint.compareTo(BigDecimal.ZERO)==0) {
					break;
				}
			}
			
		}
		
		//18
		for(int ind=0;ind<resultList.size();ind++) {
			
			CardHolderBucketDetailDTO cardBucketDetails =  new CardHolderBucketDetailDTO(resultList.get(ind));
			
			
			if(totalProductPoint.compareTo(BigDecimal.ZERO)>0
					&&cardBucketDetails.getBucket18_point_bal()!=null
					&&cardBucketDetails.getBucket18_point_bal().compareTo(BigDecimal.ZERO)>0
					&&cardBucketDetails.getBucket18_point_sign().equals("+")
					) {
				
				if(cardBucketDetails.getBucket18_point_bal().compareTo(totalProductPoint)>=0) {
					cardBucketDetails.setTotal_points_bal(
							cardBucketDetails.getTotal_points_bal().subtract(totalProductPoint));
					cardBucketDetails.setBucket18_point_bal(
							cardBucketDetails.getBucket18_point_bal().subtract(totalProductPoint));
					
					totalProductPoint = BigDecimal.ZERO;
				}else{
					totalProductPoint=totalProductPoint.subtract(cardBucketDetails.getBucket18_point_bal());
					cardBucketDetails.setTotal_points_bal(
							cardBucketDetails.getTotal_points_bal().subtract(
									cardBucketDetails.getBucket18_point_bal()));
					cardBucketDetails.setBucket18_point_bal(BigDecimal.ZERO);
					
				}
				cardBucketDetails.setDeducted(true);
				resultList.set(ind, cardBucketDetails);
				
				if(totalProductPoint.compareTo(BigDecimal.ZERO)==0) {
					break;
				}
			}
			
		}
		
		//17
		for(int ind=0;ind<resultList.size();ind++) {
			
			CardHolderBucketDetailDTO cardBucketDetails =  new CardHolderBucketDetailDTO(resultList.get(ind));
			
			
			if(totalProductPoint.compareTo(BigDecimal.ZERO)>0
					&&cardBucketDetails.getBucket17_point_bal()!=null
					&&cardBucketDetails.getBucket17_point_bal().compareTo(BigDecimal.ZERO)>0
					&&cardBucketDetails.getBucket17_point_sign().equals("+")
					) {
				
				if(cardBucketDetails.getBucket17_point_bal().compareTo(totalProductPoint)>=0) {
					cardBucketDetails.setTotal_points_bal(
							cardBucketDetails.getTotal_points_bal().subtract(totalProductPoint));
					cardBucketDetails.setBucket17_point_bal(
							cardBucketDetails.getBucket17_point_bal().subtract(totalProductPoint));
					
					totalProductPoint = BigDecimal.ZERO;
				}else{
					totalProductPoint=totalProductPoint.subtract(cardBucketDetails.getBucket17_point_bal());
					cardBucketDetails.setTotal_points_bal(
							cardBucketDetails.getTotal_points_bal().subtract(
									cardBucketDetails.getBucket17_point_bal()));
					cardBucketDetails.setBucket17_point_bal(BigDecimal.ZERO);
					
				}
				cardBucketDetails.setDeducted(true);
				resultList.set(ind, cardBucketDetails);
				
				if(totalProductPoint.compareTo(BigDecimal.ZERO)==0) {
					break;
				}
			}
			
		}
		
		//16
		for(int ind=0;ind<resultList.size();ind++) {
			
			CardHolderBucketDetailDTO cardBucketDetails =  new CardHolderBucketDetailDTO(resultList.get(ind));
			
			
			if(totalProductPoint.compareTo(BigDecimal.ZERO)>0
					&&cardBucketDetails.getBucket16_point_bal()!=null
					&&cardBucketDetails.getBucket16_point_bal().compareTo(BigDecimal.ZERO)>0
					&&cardBucketDetails.getBucket16_point_sign().equals("+")
					) {
				
				if(cardBucketDetails.getBucket16_point_bal().compareTo(totalProductPoint)>=0) {
					cardBucketDetails.setTotal_points_bal(
							cardBucketDetails.getTotal_points_bal().subtract(totalProductPoint));
					cardBucketDetails.setBucket16_point_bal(
							cardBucketDetails.getBucket16_point_bal().subtract(totalProductPoint));
					
					totalProductPoint = BigDecimal.ZERO;
				}else{
					totalProductPoint=totalProductPoint.subtract(cardBucketDetails.getBucket16_point_bal());
					cardBucketDetails.setTotal_points_bal(
							cardBucketDetails.getTotal_points_bal().subtract(
									cardBucketDetails.getBucket16_point_bal()));
					cardBucketDetails.setBucket16_point_bal(BigDecimal.ZERO);
					
				}
				cardBucketDetails.setDeducted(true);
				resultList.set(ind, cardBucketDetails);
				
				if(totalProductPoint.compareTo(BigDecimal.ZERO)==0) {
					break;
				}
			}
			
		}
		
		//15
		for(int ind=0;ind<resultList.size();ind++) {
			
			CardHolderBucketDetailDTO cardBucketDetails =  new CardHolderBucketDetailDTO(resultList.get(ind));
			
			
			if(totalProductPoint.compareTo(BigDecimal.ZERO)>0
					&&cardBucketDetails.getBucket15_point_bal()!=null
					&&cardBucketDetails.getBucket15_point_bal().compareTo(BigDecimal.ZERO)>0
					&&cardBucketDetails.getBucket15_point_sign().equals("+")
					) {
				
				if(cardBucketDetails.getBucket15_point_bal().compareTo(totalProductPoint)>=0) {
					cardBucketDetails.setTotal_points_bal(
							cardBucketDetails.getTotal_points_bal().subtract(totalProductPoint));
					cardBucketDetails.setBucket15_point_bal(
							cardBucketDetails.getBucket15_point_bal().subtract(totalProductPoint));
					totalProductPoint = BigDecimal.ZERO;
				}else{
					totalProductPoint=totalProductPoint.subtract(cardBucketDetails.getBucket15_point_bal());
					cardBucketDetails.setTotal_points_bal(
							cardBucketDetails.getTotal_points_bal().subtract(
									cardBucketDetails.getBucket15_point_bal()));
					cardBucketDetails.setBucket15_point_bal(BigDecimal.ZERO);			
				}
				cardBucketDetails.setDeducted(true);
				resultList.set(ind, cardBucketDetails);
				
				if(totalProductPoint.compareTo(BigDecimal.ZERO)==0) {
					break;
				}
			}
			
		}
		
		//14
		for(int ind=0;ind<resultList.size();ind++) {
			
			CardHolderBucketDetailDTO cardBucketDetails =  new CardHolderBucketDetailDTO(resultList.get(ind));
			
			
			if(totalProductPoint.compareTo(BigDecimal.ZERO)>0
					&&cardBucketDetails.getBucket14_point_bal()!=null
					&&cardBucketDetails.getBucket14_point_bal().compareTo(BigDecimal.ZERO)>0
					&&cardBucketDetails.getBucket14_point_sign().equals("+")
					) {
				
				if(cardBucketDetails.getBucket14_point_bal().compareTo(totalProductPoint)>=0) {
					cardBucketDetails.setTotal_points_bal(
							cardBucketDetails.getTotal_points_bal().subtract(totalProductPoint));
					cardBucketDetails.setBucket14_point_bal(
							cardBucketDetails.getBucket14_point_bal().subtract(totalProductPoint));
					totalProductPoint = BigDecimal.ZERO;
				}else {
					totalProductPoint=totalProductPoint.subtract(cardBucketDetails.getBucket14_point_bal());
					cardBucketDetails.setTotal_points_bal(
							cardBucketDetails.getTotal_points_bal().subtract(
									cardBucketDetails.getBucket14_point_bal()));
					cardBucketDetails.setBucket14_point_bal(BigDecimal.ZERO);
				}
				cardBucketDetails.setDeducted(true);
				resultList.set(ind, cardBucketDetails);
				
				if(totalProductPoint.compareTo(BigDecimal.ZERO)==0) {
					break;
				}
			}
			
		}
		
		//13
		for(int ind=0;ind<resultList.size();ind++) {
			
			CardHolderBucketDetailDTO cardBucketDetails =  new CardHolderBucketDetailDTO(resultList.get(ind));
			
			
			if(totalProductPoint.compareTo(BigDecimal.ZERO)>0
					&&cardBucketDetails.getBucket13_point_bal()!=null
					&&cardBucketDetails.getBucket13_point_bal().compareTo(BigDecimal.ZERO)>0
					&&cardBucketDetails.getBucket13_point_sign().equals("+")
					) {
				
				if(cardBucketDetails.getBucket13_point_bal().compareTo(totalProductPoint)>=0) {
					cardBucketDetails.setTotal_points_bal(
							cardBucketDetails.getTotal_points_bal().subtract(totalProductPoint));
					cardBucketDetails.setBucket13_point_bal(
							cardBucketDetails.getBucket13_point_bal().subtract(totalProductPoint));
					
					totalProductPoint = BigDecimal.ZERO;
				}else{
					totalProductPoint=totalProductPoint.subtract(cardBucketDetails.getBucket13_point_bal());
					cardBucketDetails.setTotal_points_bal(
							cardBucketDetails.getTotal_points_bal().subtract(
									cardBucketDetails.getBucket13_point_bal()));
					cardBucketDetails.setBucket13_point_bal(BigDecimal.ZERO);
					
				}
				cardBucketDetails.setDeducted(true);
				resultList.set(ind, cardBucketDetails);
				
				if(totalProductPoint.compareTo(BigDecimal.ZERO)==0) {
					break;
				}
			}
			
		}
		
		//12
		for(int ind=0;ind<resultList.size();ind++) {
			
			CardHolderBucketDetailDTO cardBucketDetails =  new CardHolderBucketDetailDTO(resultList.get(ind));
			
			if(totalProductPoint.compareTo(BigDecimal.ZERO)>0
					&&cardBucketDetails.getBucket12_point_bal()!=null
					&&cardBucketDetails.getBucket12_point_bal().compareTo(BigDecimal.ZERO)>0
					&&cardBucketDetails.getBucket12_point_sign().equals("+")
					) {
				
				if(cardBucketDetails.getBucket12_point_bal().compareTo(totalProductPoint)>=0) {
					cardBucketDetails.setTotal_points_bal(
							cardBucketDetails.getTotal_points_bal().subtract(totalProductPoint));
					cardBucketDetails.setBucket12_point_bal(
							cardBucketDetails.getBucket12_point_bal().subtract(totalProductPoint));
					totalProductPoint = BigDecimal.ZERO;
				}else{
					totalProductPoint=totalProductPoint.subtract(cardBucketDetails.getBucket12_point_bal());
					cardBucketDetails.setTotal_points_bal(
							cardBucketDetails.getTotal_points_bal().subtract(
									cardBucketDetails.getBucket12_point_bal()));
					cardBucketDetails.setBucket12_point_bal(BigDecimal.ZERO);
					
				}
				cardBucketDetails.setDeducted(true);
				resultList.set(ind, cardBucketDetails);
				
				if(totalProductPoint.compareTo(BigDecimal.ZERO)==0) {
					break;
				}
			}
			
		}
		
		//11
		for(int ind=0;ind<resultList.size();ind++) {
			
			CardHolderBucketDetailDTO cardBucketDetails =  new CardHolderBucketDetailDTO(resultList.get(ind));
			
			if(totalProductPoint.compareTo(BigDecimal.ZERO)>0
					&&cardBucketDetails.getBucket11_point_bal()!=null
					&&cardBucketDetails.getBucket11_point_bal().compareTo(BigDecimal.ZERO)>0
					&&cardBucketDetails.getBucket11_point_sign().equals("+")
					) {
				
				if(cardBucketDetails.getBucket11_point_bal().compareTo(totalProductPoint)>=0) {
					cardBucketDetails.setTotal_points_bal(
							cardBucketDetails.getTotal_points_bal().subtract(totalProductPoint));
					cardBucketDetails.setBucket11_point_bal(
							cardBucketDetails.getBucket11_point_bal().subtract(totalProductPoint));
					totalProductPoint = BigDecimal.ZERO;
				}else{
					totalProductPoint=totalProductPoint.subtract(cardBucketDetails.getBucket11_point_bal());
					cardBucketDetails.setTotal_points_bal(
							cardBucketDetails.getTotal_points_bal().subtract(
									cardBucketDetails.getBucket11_point_bal()));
					cardBucketDetails.setBucket11_point_bal(BigDecimal.ZERO);
					
				}
				cardBucketDetails.setDeducted(true);
				resultList.set(ind, cardBucketDetails);
				
				if(totalProductPoint.compareTo(BigDecimal.ZERO)==0) {
					break;
				}
			}
			
		}
		
		//10
		for(int ind=0;ind<resultList.size();ind++) {
			
			CardHolderBucketDetailDTO cardBucketDetails =  new CardHolderBucketDetailDTO(resultList.get(ind));
			
			if(totalProductPoint.compareTo(BigDecimal.ZERO)>0
					&&cardBucketDetails.getBucket10_point_bal()!=null
					&&cardBucketDetails.getBucket10_point_bal().compareTo(BigDecimal.ZERO)>0
					&&cardBucketDetails.getBucket10_point_sign().equals("+")
					) {
				
				if(cardBucketDetails.getBucket10_point_bal().compareTo(totalProductPoint)>=0) {
					cardBucketDetails.setTotal_points_bal(
							cardBucketDetails.getTotal_points_bal().subtract(totalProductPoint));
					cardBucketDetails.setBucket10_point_bal(
							cardBucketDetails.getBucket10_point_bal().subtract(totalProductPoint));
					
					totalProductPoint = BigDecimal.ZERO;
				}else{
					totalProductPoint=totalProductPoint.subtract(cardBucketDetails.getBucket10_point_bal());
					cardBucketDetails.setTotal_points_bal(
							cardBucketDetails.getTotal_points_bal().subtract(
									cardBucketDetails.getBucket10_point_bal()));
					cardBucketDetails.setBucket10_point_bal(BigDecimal.ZERO);
					
				}
				cardBucketDetails.setDeducted(true);
				resultList.set(ind, cardBucketDetails);
				
				if(totalProductPoint.compareTo(BigDecimal.ZERO)==0) {
					break;
				}
			}
			
		}
		
		//09
		for(int ind=0;ind<resultList.size();ind++) {
			
			CardHolderBucketDetailDTO cardBucketDetails =  new CardHolderBucketDetailDTO(resultList.get(ind));
			
			if(totalProductPoint.compareTo(BigDecimal.ZERO)>0
					&&cardBucketDetails.getBucket09_point_bal()!=null
					&&cardBucketDetails.getBucket09_point_bal().compareTo(BigDecimal.ZERO)>0
					&&cardBucketDetails.getBucket09_point_sign().equals("+")
					) {
				
				if(cardBucketDetails.getBucket09_point_bal().compareTo(totalProductPoint)>=0) {
					cardBucketDetails.setTotal_points_bal(
							cardBucketDetails.getTotal_points_bal().subtract(totalProductPoint));
					cardBucketDetails.setBucket09_point_bal(
							cardBucketDetails.getBucket09_point_bal().subtract(totalProductPoint));
					
					totalProductPoint = BigDecimal.ZERO;
				}else{
					totalProductPoint=totalProductPoint.subtract(cardBucketDetails.getBucket09_point_bal());
					cardBucketDetails.setTotal_points_bal(
							cardBucketDetails.getTotal_points_bal().subtract(
									cardBucketDetails.getBucket09_point_bal()));
					cardBucketDetails.setBucket09_point_bal(BigDecimal.ZERO);
					
				}
				cardBucketDetails.setDeducted(true);
				resultList.set(ind, cardBucketDetails);
				
				if(totalProductPoint.compareTo(BigDecimal.ZERO)==0) {
					break;
				}
			}
			
		}
		
		//08
		for(int ind=0;ind<resultList.size();ind++) {
			
			CardHolderBucketDetailDTO cardBucketDetails =  new CardHolderBucketDetailDTO(resultList.get(ind));
			
			if(totalProductPoint.compareTo(BigDecimal.ZERO)>0
					&&cardBucketDetails.getBucket08_point_bal()!=null
					&&cardBucketDetails.getBucket08_point_bal().compareTo(BigDecimal.ZERO)>0
					&&cardBucketDetails.getBucket08_point_sign().equals("+")
					) {
				
				if(cardBucketDetails.getBucket08_point_bal().compareTo(totalProductPoint)>=0) {
					cardBucketDetails.setTotal_points_bal(
							cardBucketDetails.getTotal_points_bal().subtract(totalProductPoint));
					cardBucketDetails.setBucket08_point_bal(
							cardBucketDetails.getBucket08_point_bal().subtract(totalProductPoint));
					
					totalProductPoint = BigDecimal.ZERO;
				}else{
					totalProductPoint=totalProductPoint.subtract(cardBucketDetails.getBucket08_point_bal());
					cardBucketDetails.setTotal_points_bal(
							cardBucketDetails.getTotal_points_bal().subtract(
									cardBucketDetails.getBucket08_point_bal()));
					cardBucketDetails.setBucket08_point_bal(BigDecimal.ZERO);
					
				}
				cardBucketDetails.setDeducted(true);
				resultList.set(ind, cardBucketDetails);
				
				if(totalProductPoint.compareTo(BigDecimal.ZERO)==0) {
					break;
				}
			}
			
		}
		
		//07
		for(int ind=0;ind<resultList.size();ind++) {
			
			CardHolderBucketDetailDTO cardBucketDetails =  new CardHolderBucketDetailDTO(resultList.get(ind));
			
			if(totalProductPoint.compareTo(BigDecimal.ZERO)>0
					&&cardBucketDetails.getBucket07_point_bal()!=null
					&&cardBucketDetails.getBucket07_point_bal().compareTo(BigDecimal.ZERO)>0
					&&cardBucketDetails.getBucket07_point_sign().equals("+")
					) {
				
				if(cardBucketDetails.getBucket07_point_bal().compareTo(totalProductPoint)>=0) {
					cardBucketDetails.setTotal_points_bal(
							cardBucketDetails.getTotal_points_bal().subtract(totalProductPoint));
					cardBucketDetails.setBucket07_point_bal(
							cardBucketDetails.getBucket07_point_bal().subtract(totalProductPoint));
					
					totalProductPoint = BigDecimal.ZERO;
				}else{
					totalProductPoint=totalProductPoint.subtract(cardBucketDetails.getBucket07_point_bal());
					cardBucketDetails.setTotal_points_bal(
							cardBucketDetails.getTotal_points_bal().subtract(
									cardBucketDetails.getBucket07_point_bal()));
					cardBucketDetails.setBucket07_point_bal(BigDecimal.ZERO);
					
				}
				cardBucketDetails.setDeducted(true);
				resultList.set(ind, cardBucketDetails);
				
				if(totalProductPoint.compareTo(BigDecimal.ZERO)==0) {
					break;
				}
			}
			
		}
		
		//06
		for(int ind=0;ind<resultList.size();ind++) {
			
			CardHolderBucketDetailDTO cardBucketDetails =  new CardHolderBucketDetailDTO(resultList.get(ind));
			
			if(totalProductPoint.compareTo(BigDecimal.ZERO)>0
					&&cardBucketDetails.getBucket06_point_bal()!=null
					&&cardBucketDetails.getBucket06_point_bal().compareTo(BigDecimal.ZERO)>0
					&&cardBucketDetails.getBucket06_point_sign().equals("+")
					) {
				
				if(cardBucketDetails.getBucket06_point_bal().compareTo(totalProductPoint)>=0) {
					cardBucketDetails.setTotal_points_bal(
							cardBucketDetails.getTotal_points_bal().subtract(totalProductPoint));
					cardBucketDetails.setBucket06_point_bal(
							cardBucketDetails.getBucket06_point_bal().subtract(totalProductPoint));
					
					totalProductPoint = BigDecimal.ZERO;
				}else{
					totalProductPoint=totalProductPoint.subtract(cardBucketDetails.getBucket06_point_bal());
					cardBucketDetails.setTotal_points_bal(
							cardBucketDetails.getTotal_points_bal().subtract(
									cardBucketDetails.getBucket06_point_bal()));
					cardBucketDetails.setBucket06_point_bal(BigDecimal.ZERO);
					
				}
				cardBucketDetails.setDeducted(true);
				resultList.set(ind, cardBucketDetails);
				
				if(totalProductPoint.compareTo(BigDecimal.ZERO)==0) {
					break;
				}
			}
			
		}
		
		//05
		for(int ind=0;ind<resultList.size();ind++) {
			
			CardHolderBucketDetailDTO cardBucketDetails =  new CardHolderBucketDetailDTO(resultList.get(ind));
			
			if(totalProductPoint.compareTo(BigDecimal.ZERO)>0
					&&cardBucketDetails.getBucket05_point_bal()!=null
					&&cardBucketDetails.getBucket05_point_bal().compareTo(BigDecimal.ZERO)>0
					&&cardBucketDetails.getBucket05_point_sign().equals("+")
					) {
				
				if(cardBucketDetails.getBucket05_point_bal().compareTo(totalProductPoint)>=0) {
					cardBucketDetails.setTotal_points_bal(
							cardBucketDetails.getTotal_points_bal().subtract(totalProductPoint));
					cardBucketDetails.setBucket05_point_bal(
							cardBucketDetails.getBucket05_point_bal().subtract(totalProductPoint));
					totalProductPoint = BigDecimal.ZERO;
				}else {
					totalProductPoint=totalProductPoint.subtract(cardBucketDetails.getBucket05_point_bal());
					cardBucketDetails.setTotal_points_bal(
							cardBucketDetails.getTotal_points_bal().subtract(
									cardBucketDetails.getBucket05_point_bal()));
					cardBucketDetails.setBucket05_point_bal(BigDecimal.ZERO);
					
				}
				cardBucketDetails.setDeducted(true);
				resultList.set(ind, cardBucketDetails);
				
				if(totalProductPoint.compareTo(BigDecimal.ZERO)==0) {
					break;
				}
			}
			
		}
		
		//04
		for(int ind=0;ind<resultList.size();ind++) {
			
			CardHolderBucketDetailDTO cardBucketDetails =  new CardHolderBucketDetailDTO(resultList.get(ind));
			
			if(totalProductPoint.compareTo(BigDecimal.ZERO)>0
					&&cardBucketDetails.getBucket04_point_bal()!=null
					&&cardBucketDetails.getBucket04_point_bal().compareTo(BigDecimal.ZERO)>0
					&&cardBucketDetails.getBucket04_point_sign().equals("+")
					) {
				
				if(cardBucketDetails.getBucket04_point_bal().compareTo(totalProductPoint)>=0) {
					cardBucketDetails.setTotal_points_bal(
							cardBucketDetails.getTotal_points_bal().subtract(totalProductPoint));
					cardBucketDetails.setBucket04_point_bal(
							cardBucketDetails.getBucket04_point_bal().subtract(totalProductPoint));
					totalProductPoint = BigDecimal.ZERO;
				}else{
					totalProductPoint=totalProductPoint.subtract(cardBucketDetails.getBucket04_point_bal());
					cardBucketDetails.setTotal_points_bal(
							cardBucketDetails.getTotal_points_bal().subtract(
									cardBucketDetails.getBucket04_point_bal()));
					cardBucketDetails.setBucket04_point_bal(BigDecimal.ZERO);
				}
				cardBucketDetails.setDeducted(true);
				resultList.set(ind, cardBucketDetails);
				
				if(totalProductPoint.compareTo(BigDecimal.ZERO)==0) {
					break;
				}
			}
			
		}
		
		//03
		for(int ind=0;ind<resultList.size();ind++) {
			
			CardHolderBucketDetailDTO cardBucketDetails =  new CardHolderBucketDetailDTO(resultList.get(ind));
			
			if(totalProductPoint.compareTo(BigDecimal.ZERO)>0
					&&cardBucketDetails.getBucket03_point_bal()!=null
					&&cardBucketDetails.getBucket03_point_bal().compareTo(BigDecimal.ZERO)>0
					&&cardBucketDetails.getBucket03_point_sign().equals("+")
					) {
				
				if(cardBucketDetails.getBucket03_point_bal().compareTo(totalProductPoint)>=0) {
					cardBucketDetails.setTotal_points_bal(
							cardBucketDetails.getTotal_points_bal().subtract(totalProductPoint));
					cardBucketDetails.setBucket03_point_bal(
							cardBucketDetails.getBucket03_point_bal().subtract(totalProductPoint));
					
					totalProductPoint = BigDecimal.ZERO;
				}else{
					totalProductPoint=totalProductPoint.subtract(cardBucketDetails.getBucket03_point_bal());
					cardBucketDetails.setTotal_points_bal(
							cardBucketDetails.getTotal_points_bal().subtract(
									cardBucketDetails.getBucket03_point_bal()));
					cardBucketDetails.setBucket03_point_bal(BigDecimal.ZERO);
					
				}
				cardBucketDetails.setDeducted(true);
				resultList.set(ind, cardBucketDetails);
				
				if(totalProductPoint.compareTo(BigDecimal.ZERO)==0) {
					break;
				}
			}
			
		}
		
		//02
		for(int ind=0;ind<resultList.size();ind++) {
			
			CardHolderBucketDetailDTO cardBucketDetails =  new CardHolderBucketDetailDTO(resultList.get(ind));
			
			if(totalProductPoint.compareTo(BigDecimal.ZERO)>0
					&&cardBucketDetails.getBucket02_point_bal()!=null
					&&cardBucketDetails.getBucket02_point_bal().compareTo(BigDecimal.ZERO)>0
					&&cardBucketDetails.getBucket02_point_sign().equals("+")
					) {
				
				if(cardBucketDetails.getBucket02_point_bal().compareTo(totalProductPoint)>=0) {
					cardBucketDetails.setTotal_points_bal(
							cardBucketDetails.getTotal_points_bal().subtract(totalProductPoint));
					cardBucketDetails.setBucket02_point_bal(
							cardBucketDetails.getBucket02_point_bal().subtract(totalProductPoint));
					
					totalProductPoint = BigDecimal.ZERO;
				}else{
					totalProductPoint=totalProductPoint.subtract(cardBucketDetails.getBucket02_point_bal());
					cardBucketDetails.setTotal_points_bal(
							cardBucketDetails.getTotal_points_bal().subtract(
									cardBucketDetails.getBucket02_point_bal()));
					cardBucketDetails.setBucket02_point_bal(BigDecimal.ZERO);
					
				}
				cardBucketDetails.setDeducted(true);
				resultList.set(ind, cardBucketDetails);
				
				if(totalProductPoint.compareTo(BigDecimal.ZERO)==0) {
					break;
				}
			}
			
		}
		
		//01
		for(int ind=0;ind<resultList.size();ind++) {
			
			CardHolderBucketDetailDTO cardBucketDetails =  new CardHolderBucketDetailDTO(resultList.get(ind));
			
			if(totalProductPoint.compareTo(BigDecimal.ZERO)>0
					&&cardBucketDetails.getBucket01_point_bal()!=null
					&&cardBucketDetails.getBucket01_point_bal().compareTo(BigDecimal.ZERO)>0
					&&cardBucketDetails.getBucket01_point_sign().equals("+")
					) {
				
				if(cardBucketDetails.getBucket01_point_bal().compareTo(totalProductPoint)>=0) {
					cardBucketDetails.setTotal_points_bal(
							cardBucketDetails.getTotal_points_bal().subtract(totalProductPoint));
					cardBucketDetails.setBucket01_point_bal(
							cardBucketDetails.getBucket01_point_bal().subtract(totalProductPoint));
					
					totalProductPoint = BigDecimal.ZERO;
				}else{
					totalProductPoint=totalProductPoint.subtract(cardBucketDetails.getBucket01_point_bal());
					cardBucketDetails.setTotal_points_bal(
							cardBucketDetails.getTotal_points_bal().subtract(
									cardBucketDetails.getBucket01_point_bal()));
					cardBucketDetails.setBucket01_point_bal(BigDecimal.ZERO);
					
				}
				cardBucketDetails.setDeducted(true);
				resultList.set(ind, cardBucketDetails);
				
				if(totalProductPoint.compareTo(BigDecimal.ZERO)==0) {
					break;
				}
			}
			
		}
		
		if(totalProductPoint.compareTo(BigDecimal.ZERO)>0) {
			return null;
		}
		
		return resultList;
	}
	
	public static BigDecimal getTotalProducPoint(ProductRedemptionDao productRedemptionDao, List<PointRedemptionProductReq> productList) {
		
		BigDecimal totalPoint = BigDecimal.ZERO;
		
		if(productList.size()>0) {		
			for(PointRedemptionProductReq product:productList) {
				
				BigDecimal productUnitPoint = productRedemptionDao.getProductPointByProductId(
						new BigDecimal(product.getProduct_id()));
				
				if(productUnitPoint==null) {
					return null;
				}
				
				totalPoint = totalPoint.add((productUnitPoint.multiply(new BigDecimal(product.getQuantity()))));
			}
		}
		
		return totalPoint;
	}
	
	public static void insertTxn(ProductRedemptionDao productRedemptionDao, 
			List<CardHolderBucketDetailDTO> redeemableCardList, 
			List<CardHolderBucketDetailDTO> deductedPointBucketList,
			List<PointRedemptionProductReq> productList,
			List<ProductUnitPointDetailDTO> productDetailList,
			CardHolderDetailDTO customerDetails, 
			BigDecimal totalPointRedeem, BigDecimal rewardTypeId, 
			String rewardTypeCode, String email, String partnerMemberNo) {
		
			List<OrsProgramDTO> programList = productRedemptionDao.getProgramList();
			
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
			String strNow = df.format(new Date());
			String mrPartnerType = "";
			String mrPartnerCode = "";
			
			BigDecimal txtId= productRedemptionDao.newPointTxn(strNow, 
					null,
					customerDetails.getCust_ic_no(), 
					customerDetails.getFirst_name(), 
					customerDetails.getLast_name(), 
					totalPointRedeem, BigDecimal.ZERO, rewardTypeId, 
					customerDetails.getAddr1(), 
					customerDetails.getAddr2(),
					customerDetails.getAddr1(), 
					customerDetails.getAddr4(),
					customerDetails.getZip_code(),
					email, customerDetails.getHome_no(), 
					customerDetails.getOffice_no(), customerDetails.getMobile_no(), "ORS Web", 
					"R","S", "YAU",  
					customerDetails.getCardholder_id());
			System.out.println("txtId".concat(txtId.toPlainString()));
		
			
			for(PointRedemptionProductReq product:productList) {
				
				ProductUnitPointDetailDTO  productDetail=null;
				
				for(ProductUnitPointDetailDTO record:productDetailList) {
					if(product.getProduct_id().equals(record.getProduct_id().toPlainString())) {
						productDetail = record;
						break;
					}
				}
		
				productRedemptionDao.newPointTxnDetails(txtId,strNow, 
						productDetail.getProduct_id(), 
						new BigDecimal(product.getQuantity()), 
						new BigDecimal(productDetail.getUnit_point()), 
						productDetail.getMerchant_id(), 
						"P", 
						false, 
						"YAU",
						redeemableCardList.get(0).getCard_no());
			}
			
			if(rewardTypeCode.equals(MBBORSConstant.REWARD_TYPE_CODE_TP)) {
			
				for(int ind=0;redeemableCardList.size()>ind;ind++) {
					
					CardHolderBucketDetailDTO bucket = redeemableCardList.get(ind);
					CardHolderBucketDetailDTO newBucket = deductedPointBucketList.get(ind);
					
					if(newBucket.isDeducted()) {
						productRedemptionDao.newPointTxnBucket(
								txtId,bucket.getCardholder_point_bucket_id(),strNow,bucket.getOrg_no(),bucket.getCard_type(),bucket.getCard_no()
								,"91","R","ORS Redemption",getProgramCode(programList, bucket.getProgram_id())
								,totalPointRedeem,BigDecimal.ZERO,bucket.getTotal_points_sign(),bucket.getTotal_points_bal(),newBucket.getTotal_points_sign(),newBucket.getTotal_points_bal()
								,null,null,null,null,null
								,bucket.getBucket01_point_sign(),bucket.getBucket01_point_bal(),diffValue(bucket.getBucket01_point_bal(), newBucket.getBucket01_point_bal()),newBucket.getBucket01_point_sign(),newBucket.getBucket01_point_bal()
								,bucket.getBucket02_point_sign(),bucket.getBucket02_point_bal(),diffValue(bucket.getBucket02_point_bal(), newBucket.getBucket02_point_bal()),newBucket.getBucket02_point_sign(),newBucket.getBucket02_point_bal()
								,bucket.getBucket03_point_sign(),bucket.getBucket03_point_bal(),diffValue(bucket.getBucket03_point_bal(), newBucket.getBucket03_point_bal()),newBucket.getBucket03_point_sign(),newBucket.getBucket03_point_bal()
								,bucket.getBucket04_point_sign(),bucket.getBucket04_point_bal(),diffValue(bucket.getBucket04_point_bal(), newBucket.getBucket04_point_bal()),newBucket.getBucket04_point_sign(),newBucket.getBucket04_point_bal()
								,bucket.getBucket05_point_sign(),bucket.getBucket05_point_bal(),diffValue(bucket.getBucket05_point_bal(), newBucket.getBucket05_point_bal()),newBucket.getBucket05_point_sign(),newBucket.getBucket05_point_bal()
								,bucket.getBucket06_point_sign(),bucket.getBucket06_point_bal(),diffValue(bucket.getBucket06_point_bal(), newBucket.getBucket06_point_bal()),newBucket.getBucket06_point_sign(),newBucket.getBucket06_point_bal()
								,bucket.getBucket07_point_sign(),bucket.getBucket07_point_bal(),diffValue(bucket.getBucket07_point_bal(), newBucket.getBucket07_point_bal()),newBucket.getBucket07_point_sign(),newBucket.getBucket07_point_bal()
								,bucket.getBucket08_point_sign(),bucket.getBucket08_point_bal(),diffValue(bucket.getBucket08_point_bal(), newBucket.getBucket08_point_bal()),newBucket.getBucket08_point_sign(),newBucket.getBucket08_point_bal()
								,bucket.getBucket09_point_sign(),bucket.getBucket09_point_bal(),diffValue(bucket.getBucket09_point_bal(), newBucket.getBucket09_point_bal()),newBucket.getBucket09_point_sign(),newBucket.getBucket09_point_bal()
								,bucket.getBucket10_point_sign(),bucket.getBucket10_point_bal(),diffValue(bucket.getBucket10_point_bal(), newBucket.getBucket10_point_bal()),newBucket.getBucket10_point_sign(),newBucket.getBucket10_point_bal()
								
								,bucket.getBucket11_point_sign(),bucket.getBucket11_point_bal(),diffValue(bucket.getBucket11_point_bal(), newBucket.getBucket11_point_bal()),newBucket.getBucket11_point_sign(),newBucket.getBucket11_point_bal()
								,bucket.getBucket12_point_sign(),bucket.getBucket12_point_bal(),diffValue(bucket.getBucket12_point_bal(), newBucket.getBucket12_point_bal()),newBucket.getBucket12_point_sign(),newBucket.getBucket12_point_bal()
								,bucket.getBucket13_point_sign(),bucket.getBucket13_point_bal(),diffValue(bucket.getBucket13_point_bal(), newBucket.getBucket13_point_bal()),newBucket.getBucket13_point_sign(),newBucket.getBucket13_point_bal()
								,bucket.getBucket14_point_sign(),bucket.getBucket14_point_bal(),diffValue(bucket.getBucket14_point_bal(), newBucket.getBucket14_point_bal()),newBucket.getBucket14_point_sign(),newBucket.getBucket14_point_bal()
								,bucket.getBucket15_point_sign(),bucket.getBucket15_point_bal(),diffValue(bucket.getBucket15_point_bal(), newBucket.getBucket15_point_bal()),newBucket.getBucket15_point_sign(),newBucket.getBucket15_point_bal()
								,bucket.getBucket16_point_sign(),bucket.getBucket16_point_bal(),diffValue(bucket.getBucket16_point_bal(), newBucket.getBucket16_point_bal()),newBucket.getBucket16_point_sign(),newBucket.getBucket16_point_bal()
								,bucket.getBucket17_point_sign(),bucket.getBucket17_point_bal(),diffValue(bucket.getBucket17_point_bal(), newBucket.getBucket17_point_bal()),newBucket.getBucket17_point_sign(),newBucket.getBucket17_point_bal()
								,bucket.getBucket18_point_sign(),bucket.getBucket18_point_bal(),diffValue(bucket.getBucket18_point_bal(), newBucket.getBucket18_point_bal()),newBucket.getBucket18_point_sign(),newBucket.getBucket18_point_bal()
								,bucket.getBucket19_point_sign(),bucket.getBucket19_point_bal(),diffValue(bucket.getBucket19_point_bal(), newBucket.getBucket19_point_bal()),newBucket.getBucket19_point_sign(),newBucket.getBucket19_point_bal()
								,bucket.getBucket20_point_sign(),bucket.getBucket20_point_bal(),diffValue(bucket.getBucket20_point_bal(), newBucket.getBucket20_point_bal()),newBucket.getBucket20_point_sign(),newBucket.getBucket20_point_bal()
								
								,bucket.getBucket21_point_sign(),bucket.getBucket21_point_bal(),diffValue(bucket.getBucket21_point_bal(), newBucket.getBucket21_point_bal()),newBucket.getBucket21_point_sign(),newBucket.getBucket21_point_bal()
								,bucket.getBucket22_point_sign(),bucket.getBucket22_point_bal(),diffValue(bucket.getBucket22_point_bal(), newBucket.getBucket22_point_bal()),newBucket.getBucket22_point_sign(),newBucket.getBucket22_point_bal()
								,bucket.getBucket23_point_sign(),bucket.getBucket23_point_bal(),diffValue(bucket.getBucket23_point_bal(), newBucket.getBucket23_point_bal()),newBucket.getBucket23_point_sign(),newBucket.getBucket23_point_bal()
								,bucket.getBucket24_point_sign(),bucket.getBucket24_point_bal(),diffValue(bucket.getBucket24_point_bal(), newBucket.getBucket24_point_bal()),newBucket.getBucket24_point_sign(),newBucket.getBucket24_point_bal()
								,bucket.getBucket25_point_sign(),bucket.getBucket25_point_bal(),diffValue(bucket.getBucket25_point_bal(), newBucket.getBucket25_point_bal()),newBucket.getBucket25_point_sign(),newBucket.getBucket25_point_bal()
								,bucket.getBucket26_point_sign(),bucket.getBucket26_point_bal(),diffValue(bucket.getBucket26_point_bal(), newBucket.getBucket26_point_bal()),newBucket.getBucket26_point_sign(),newBucket.getBucket26_point_bal()
								,bucket.getBucket27_point_sign(),bucket.getBucket27_point_bal(),diffValue(bucket.getBucket27_point_bal(), newBucket.getBucket27_point_bal()),newBucket.getBucket27_point_sign(),newBucket.getBucket27_point_bal()
								,bucket.getBucket28_point_sign(),bucket.getBucket28_point_bal(),diffValue(bucket.getBucket28_point_bal(), newBucket.getBucket28_point_bal()),newBucket.getBucket28_point_sign(),newBucket.getBucket28_point_bal()
								,bucket.getBucket29_point_sign(),bucket.getBucket29_point_bal(),diffValue(bucket.getBucket29_point_bal(), newBucket.getBucket29_point_bal()),newBucket.getBucket29_point_sign(),newBucket.getBucket29_point_bal()
								,bucket.getBucket30_point_sign(),bucket.getBucket30_point_bal(),diffValue(bucket.getBucket30_point_bal(), newBucket.getBucket30_point_bal()),newBucket.getBucket30_point_sign(),newBucket.getBucket30_point_bal()
								
								,bucket.getBucket31_point_sign(),bucket.getBucket31_point_bal(),diffValue(bucket.getBucket31_point_bal(), newBucket.getBucket31_point_bal()),newBucket.getBucket31_point_sign(),newBucket.getBucket31_point_bal()
								,bucket.getBucket32_point_sign(),bucket.getBucket32_point_bal(),diffValue(bucket.getBucket32_point_bal(), newBucket.getBucket32_point_bal()),newBucket.getBucket32_point_sign(),newBucket.getBucket32_point_bal()
								,bucket.getBucket33_point_sign(),bucket.getBucket33_point_bal(),diffValue(bucket.getBucket33_point_bal(), newBucket.getBucket33_point_bal()),newBucket.getBucket33_point_sign(),newBucket.getBucket33_point_bal()
								,bucket.getBucket34_point_sign(),bucket.getBucket34_point_bal(),diffValue(bucket.getBucket34_point_bal(), newBucket.getBucket34_point_bal()),newBucket.getBucket34_point_sign(),newBucket.getBucket34_point_bal()
								,bucket.getBucket35_point_sign(),bucket.getBucket35_point_bal(),diffValue(bucket.getBucket35_point_bal(), newBucket.getBucket35_point_bal()),newBucket.getBucket35_point_sign(),newBucket.getBucket35_point_bal()
								,bucket.getBucket36_point_sign(),bucket.getBucket36_point_bal(),diffValue(bucket.getBucket36_point_bal(), newBucket.getBucket36_point_bal()),newBucket.getBucket36_point_sign(),newBucket.getBucket36_point_bal()
								,bucket.getLast_expired_point_sign(),bucket.getLast_expired_point_bal(),"YAU"
								);
					}
				}
			}
			
			if(rewardTypeCode.equals(MBBORSConstant.REWARD_TYPE_CODE_TM)) {
				
				for(int ind=0;redeemableCardList.size()>ind;ind++) {
					
					CardHolderBucketDetailDTO bucket = redeemableCardList.get(ind);
					CardHolderBucketDetailDTO newBucket = deductedPointBucketList.get(ind);
					
					if(newBucket.isDeducted()) {
						productRedemptionDao.newPointTxnBucket(
								txtId,bucket.getCardholder_point_bucket_id(),"ORR001",bucket.getOrg_no(),bucket.getCard_type(),bucket.getCard_no()
								,"91","R","ORS Redemption",getProgramCode(programList, bucket.getProgram_id())
								,totalPointRedeem,BigDecimal.ZERO,bucket.getTotal_points_sign(),bucket.getTotal_points_bal(),newBucket.getTotal_points_sign(),newBucket.getTotal_points_bal()
								,null,null,null,null,null
								,bucket.getBucket01_point_sign(),bucket.getBucket01_point_bal(),diffValue(bucket.getBucket01_point_bal(), newBucket.getBucket01_point_bal()),newBucket.getBucket01_point_sign(),newBucket.getBucket01_point_bal()
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								
								,bucket.getLast_expired_point_sign(),bucket.getLast_expired_point_bal(),"YAU"
								);
					}
				}
			}
			
			if(rewardTypeCode.equals(MBBORSConstant.REWARD_TYPE_CODE_MR)) {
				
				for(int ind=0;redeemableCardList.size()>ind;ind++) {
					
					CardHolderBucketDetailDTO bucket = redeemableCardList.get(ind);
					CardHolderBucketDetailDTO newBucket = deductedPointBucketList.get(ind);
					
					if(newBucket.isDeducted()) {
						productRedemptionDao.newPointTxnBucket(
								txtId,bucket.getCardholder_point_bucket_id(),"ORR001",bucket.getOrg_no(),bucket.getCard_type(),bucket.getCard_no()
								,"91","R","ORS Redemption",getProgramCode(programList, bucket.getProgram_id())
								,totalPointRedeem,BigDecimal.ZERO,bucket.getTotal_points_sign(),bucket.getTotal_points_bal(),newBucket.getTotal_points_sign(),newBucket.getTotal_points_bal()
								,null,null,null,null,null
								,bucket.getBucket01_point_sign(),bucket.getBucket01_point_bal(),diffValue(bucket.getBucket01_point_bal(), newBucket.getBucket01_point_bal()),newBucket.getBucket01_point_sign(),newBucket.getBucket01_point_bal()
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								
								,bucket.getLast_expired_point_sign(),bucket.getLast_expired_point_bal(),"YAU"
								);
					}
				}
			}
			
			for(int ind=0;deductedPointBucketList.size()>ind;ind++) {
				
				CardHolderBucketDetailDTO newBucket = deductedPointBucketList.get(ind);
				
				productRedemptionDao.updateCardBucket(newBucket.getTotal_points_sign(), newBucket.getTotal_points_bal(), newBucket.getTotal_points_bal().setScale(0, RoundingMode.FLOOR), 
						newBucket.getBucket01_point_sign(), newBucket.getBucket01_point_bal(), newBucket.getBucket02_point_sign(), newBucket.getBucket02_point_bal(), newBucket.getBucket03_point_sign(), newBucket.getBucket03_point_bal(), 
						newBucket.getBucket04_point_sign(), newBucket.getBucket04_point_bal(), newBucket.getBucket05_point_sign(), newBucket.getBucket05_point_bal(), newBucket.getBucket06_point_sign(), newBucket.getBucket06_point_bal(), 
						newBucket.getBucket07_point_sign(), newBucket.getBucket07_point_bal(), newBucket.getBucket08_point_sign(), newBucket.getBucket08_point_bal(), newBucket.getBucket09_point_sign(), newBucket.getBucket09_point_bal(), 
						newBucket.getBucket10_point_sign(), newBucket.getBucket10_point_bal(), newBucket.getBucket11_point_sign(), newBucket.getBucket11_point_bal(), newBucket.getBucket12_point_sign(), newBucket.getBucket12_point_bal(), 
						newBucket.getBucket13_point_sign(), newBucket.getBucket13_point_bal(), newBucket.getBucket14_point_sign(), newBucket.getBucket14_point_bal(), newBucket.getBucket15_point_sign(), newBucket.getBucket15_point_bal(), 
						newBucket.getBucket16_point_sign(), newBucket.getBucket16_point_bal(), newBucket.getBucket17_point_sign(), newBucket.getBucket17_point_bal(), newBucket.getBucket18_point_sign(), newBucket.getBucket18_point_bal(), 
						newBucket.getBucket19_point_sign(), newBucket.getBucket19_point_bal(), newBucket.getBucket20_point_sign(), newBucket.getBucket20_point_bal(), newBucket.getBucket21_point_sign(), newBucket.getBucket21_point_bal(), 
						newBucket.getBucket22_point_sign(), newBucket.getBucket22_point_bal(), newBucket.getBucket23_point_sign(), newBucket.getBucket23_point_bal(), newBucket.getBucket24_point_sign(), newBucket.getBucket24_point_bal(), 
						newBucket.getBucket25_point_sign(), newBucket.getBucket25_point_bal(), newBucket.getBucket26_point_sign(), newBucket.getBucket26_point_bal(), newBucket.getBucket27_point_sign(), newBucket.getBucket27_point_bal(), 
						newBucket.getBucket28_point_sign(), newBucket.getBucket28_point_bal(), newBucket.getBucket29_point_sign(), newBucket.getBucket29_point_bal(), newBucket.getBucket30_point_sign(), newBucket.getBucket30_point_bal(), 
						newBucket.getBucket31_point_sign(), newBucket.getBucket31_point_bal(), newBucket.getBucket32_point_sign(), newBucket.getBucket32_point_bal(), newBucket.getBucket33_point_sign(), newBucket.getBucket33_point_bal(), 
						newBucket.getBucket34_point_sign(), newBucket.getBucket34_point_bal(), newBucket.getBucket35_point_sign(), newBucket.getBucket35_point_bal(), newBucket.getBucket36_point_sign(), newBucket.getBucket36_point_bal(), 
						"YAU", newBucket.getCardholder_point_bucket_id());
			}
	}
	
	public static String insertTxnAirline(ProductRedemptionDao productRedemptionDao, 
			List<CardHolderBucketDetailDTO> redeemableCardList, 
			List<CardHolderBucketDetailDTO> deductedPointBucketList,
			List<PointRedemptionProductReq> productList,
			List<ProductUnitPointDetailDTO> productDetailList,
			CardHolderDetailDTO customerDetails, 
			BigDecimal totalPointRedeem, BigDecimal rewardTypeId, 
			String rewardTypeCode, String email, String partnerMemberNo, String orderNum) {
		
			List<OrsProgramDTO> programList = productRedemptionDao.getProgramList();
			
			String mrPartnerType = "";
			String mrPartnerCode = "";
			
			BigDecimal txtId= productRedemptionDao.newPointTxn(orderNum, 
					null,
					customerDetails.getCust_ic_no(), 
					customerDetails.getFirst_name(), 
					customerDetails.getLast_name(), 
					totalPointRedeem, BigDecimal.ZERO, rewardTypeId, 
					customerDetails.getAddr1(), 
					customerDetails.getAddr2(),
					customerDetails.getAddr1(), 
					customerDetails.getAddr4(),
					customerDetails.getZip_code(),
					email, customerDetails.getHome_no(), 
					customerDetails.getOffice_no(), customerDetails.getMobile_no(), "ORS Web", 
					"R","S", "YAU",  
					customerDetails.getCardholder_id());
			System.out.println("txtId".concat(txtId.toPlainString()));
		
			
			for(PointRedemptionProductReq product:productList) {
				
				ProductUnitPointDetailDTO  productDetail=null;
				
				for(ProductUnitPointDetailDTO record:productDetailList) {
					if(product.getProduct_id().equals(record.getProduct_id().toPlainString())) {
						productDetail = record;
						break;
					}
				}
		
				productRedemptionDao.newPointTxnDetails(txtId,orderNum, 
						productDetail.getProduct_id(), 
						new BigDecimal(product.getQuantity()), 
						new BigDecimal(productDetail.getUnit_point()), 
						productDetail.getMerchant_id(), 
						"P", 
						false, 
						"YAU",
						redeemableCardList.get(0).getCard_no());
			}
			
			if(rewardTypeCode.equals(MBBORSConstant.REWARD_TYPE_CODE_TP)) {
			
				for(int ind=0;redeemableCardList.size()>ind;ind++) {
					
					CardHolderBucketDetailDTO bucket = redeemableCardList.get(ind);
					CardHolderBucketDetailDTO newBucket = deductedPointBucketList.get(ind);
					
					if(newBucket.isDeducted()) {
						productRedemptionDao.newPointTxnBucket(
								txtId,bucket.getCardholder_point_bucket_id(),orderNum,bucket.getOrg_no(),bucket.getCard_type(),bucket.getCard_no()
								,"91","R","ORS Redemption",getProgramCode(programList, bucket.getProgram_id())
								,totalPointRedeem,BigDecimal.ZERO,bucket.getTotal_points_sign(),bucket.getTotal_points_bal(),newBucket.getTotal_points_sign(),newBucket.getTotal_points_bal()
								,null,null,null,null,null
								,bucket.getBucket01_point_sign(),bucket.getBucket01_point_bal(),diffValue(bucket.getBucket01_point_bal(), newBucket.getBucket01_point_bal()),newBucket.getBucket01_point_sign(),newBucket.getBucket01_point_bal()
								,bucket.getBucket02_point_sign(),bucket.getBucket02_point_bal(),diffValue(bucket.getBucket02_point_bal(), newBucket.getBucket02_point_bal()),newBucket.getBucket02_point_sign(),newBucket.getBucket02_point_bal()
								,bucket.getBucket03_point_sign(),bucket.getBucket03_point_bal(),diffValue(bucket.getBucket03_point_bal(), newBucket.getBucket03_point_bal()),newBucket.getBucket03_point_sign(),newBucket.getBucket03_point_bal()
								,bucket.getBucket04_point_sign(),bucket.getBucket04_point_bal(),diffValue(bucket.getBucket04_point_bal(), newBucket.getBucket04_point_bal()),newBucket.getBucket04_point_sign(),newBucket.getBucket04_point_bal()
								,bucket.getBucket05_point_sign(),bucket.getBucket05_point_bal(),diffValue(bucket.getBucket05_point_bal(), newBucket.getBucket05_point_bal()),newBucket.getBucket05_point_sign(),newBucket.getBucket05_point_bal()
								,bucket.getBucket06_point_sign(),bucket.getBucket06_point_bal(),diffValue(bucket.getBucket06_point_bal(), newBucket.getBucket06_point_bal()),newBucket.getBucket06_point_sign(),newBucket.getBucket06_point_bal()
								,bucket.getBucket07_point_sign(),bucket.getBucket07_point_bal(),diffValue(bucket.getBucket07_point_bal(), newBucket.getBucket07_point_bal()),newBucket.getBucket07_point_sign(),newBucket.getBucket07_point_bal()
								,bucket.getBucket08_point_sign(),bucket.getBucket08_point_bal(),diffValue(bucket.getBucket08_point_bal(), newBucket.getBucket08_point_bal()),newBucket.getBucket08_point_sign(),newBucket.getBucket08_point_bal()
								,bucket.getBucket09_point_sign(),bucket.getBucket09_point_bal(),diffValue(bucket.getBucket09_point_bal(), newBucket.getBucket09_point_bal()),newBucket.getBucket09_point_sign(),newBucket.getBucket09_point_bal()
								,bucket.getBucket10_point_sign(),bucket.getBucket10_point_bal(),diffValue(bucket.getBucket10_point_bal(), newBucket.getBucket10_point_bal()),newBucket.getBucket10_point_sign(),newBucket.getBucket10_point_bal()
								
								,bucket.getBucket11_point_sign(),bucket.getBucket11_point_bal(),diffValue(bucket.getBucket11_point_bal(), newBucket.getBucket11_point_bal()),newBucket.getBucket11_point_sign(),newBucket.getBucket11_point_bal()
								,bucket.getBucket12_point_sign(),bucket.getBucket12_point_bal(),diffValue(bucket.getBucket12_point_bal(), newBucket.getBucket12_point_bal()),newBucket.getBucket12_point_sign(),newBucket.getBucket12_point_bal()
								,bucket.getBucket13_point_sign(),bucket.getBucket13_point_bal(),diffValue(bucket.getBucket13_point_bal(), newBucket.getBucket13_point_bal()),newBucket.getBucket13_point_sign(),newBucket.getBucket13_point_bal()
								,bucket.getBucket14_point_sign(),bucket.getBucket14_point_bal(),diffValue(bucket.getBucket14_point_bal(), newBucket.getBucket14_point_bal()),newBucket.getBucket14_point_sign(),newBucket.getBucket14_point_bal()
								,bucket.getBucket15_point_sign(),bucket.getBucket15_point_bal(),diffValue(bucket.getBucket15_point_bal(), newBucket.getBucket15_point_bal()),newBucket.getBucket15_point_sign(),newBucket.getBucket15_point_bal()
								,bucket.getBucket16_point_sign(),bucket.getBucket16_point_bal(),diffValue(bucket.getBucket16_point_bal(), newBucket.getBucket16_point_bal()),newBucket.getBucket16_point_sign(),newBucket.getBucket16_point_bal()
								,bucket.getBucket17_point_sign(),bucket.getBucket17_point_bal(),diffValue(bucket.getBucket17_point_bal(), newBucket.getBucket17_point_bal()),newBucket.getBucket17_point_sign(),newBucket.getBucket17_point_bal()
								,bucket.getBucket18_point_sign(),bucket.getBucket18_point_bal(),diffValue(bucket.getBucket18_point_bal(), newBucket.getBucket18_point_bal()),newBucket.getBucket18_point_sign(),newBucket.getBucket18_point_bal()
								,bucket.getBucket19_point_sign(),bucket.getBucket19_point_bal(),diffValue(bucket.getBucket19_point_bal(), newBucket.getBucket19_point_bal()),newBucket.getBucket19_point_sign(),newBucket.getBucket19_point_bal()
								,bucket.getBucket20_point_sign(),bucket.getBucket20_point_bal(),diffValue(bucket.getBucket20_point_bal(), newBucket.getBucket20_point_bal()),newBucket.getBucket20_point_sign(),newBucket.getBucket20_point_bal()
								
								,bucket.getBucket21_point_sign(),bucket.getBucket21_point_bal(),diffValue(bucket.getBucket21_point_bal(), newBucket.getBucket21_point_bal()),newBucket.getBucket21_point_sign(),newBucket.getBucket21_point_bal()
								,bucket.getBucket22_point_sign(),bucket.getBucket22_point_bal(),diffValue(bucket.getBucket22_point_bal(), newBucket.getBucket22_point_bal()),newBucket.getBucket22_point_sign(),newBucket.getBucket22_point_bal()
								,bucket.getBucket23_point_sign(),bucket.getBucket23_point_bal(),diffValue(bucket.getBucket23_point_bal(), newBucket.getBucket23_point_bal()),newBucket.getBucket23_point_sign(),newBucket.getBucket23_point_bal()
								,bucket.getBucket24_point_sign(),bucket.getBucket24_point_bal(),diffValue(bucket.getBucket24_point_bal(), newBucket.getBucket24_point_bal()),newBucket.getBucket24_point_sign(),newBucket.getBucket24_point_bal()
								,bucket.getBucket25_point_sign(),bucket.getBucket25_point_bal(),diffValue(bucket.getBucket25_point_bal(), newBucket.getBucket25_point_bal()),newBucket.getBucket25_point_sign(),newBucket.getBucket25_point_bal()
								,bucket.getBucket26_point_sign(),bucket.getBucket26_point_bal(),diffValue(bucket.getBucket26_point_bal(), newBucket.getBucket26_point_bal()),newBucket.getBucket26_point_sign(),newBucket.getBucket26_point_bal()
								,bucket.getBucket27_point_sign(),bucket.getBucket27_point_bal(),diffValue(bucket.getBucket27_point_bal(), newBucket.getBucket27_point_bal()),newBucket.getBucket27_point_sign(),newBucket.getBucket27_point_bal()
								,bucket.getBucket28_point_sign(),bucket.getBucket28_point_bal(),diffValue(bucket.getBucket28_point_bal(), newBucket.getBucket28_point_bal()),newBucket.getBucket28_point_sign(),newBucket.getBucket28_point_bal()
								,bucket.getBucket29_point_sign(),bucket.getBucket29_point_bal(),diffValue(bucket.getBucket29_point_bal(), newBucket.getBucket29_point_bal()),newBucket.getBucket29_point_sign(),newBucket.getBucket29_point_bal()
								,bucket.getBucket30_point_sign(),bucket.getBucket30_point_bal(),diffValue(bucket.getBucket30_point_bal(), newBucket.getBucket30_point_bal()),newBucket.getBucket30_point_sign(),newBucket.getBucket30_point_bal()
								
								,bucket.getBucket31_point_sign(),bucket.getBucket31_point_bal(),diffValue(bucket.getBucket31_point_bal(), newBucket.getBucket31_point_bal()),newBucket.getBucket31_point_sign(),newBucket.getBucket31_point_bal()
								,bucket.getBucket32_point_sign(),bucket.getBucket32_point_bal(),diffValue(bucket.getBucket32_point_bal(), newBucket.getBucket32_point_bal()),newBucket.getBucket32_point_sign(),newBucket.getBucket32_point_bal()
								,bucket.getBucket33_point_sign(),bucket.getBucket33_point_bal(),diffValue(bucket.getBucket33_point_bal(), newBucket.getBucket33_point_bal()),newBucket.getBucket33_point_sign(),newBucket.getBucket33_point_bal()
								,bucket.getBucket34_point_sign(),bucket.getBucket34_point_bal(),diffValue(bucket.getBucket34_point_bal(), newBucket.getBucket34_point_bal()),newBucket.getBucket34_point_sign(),newBucket.getBucket34_point_bal()
								,bucket.getBucket35_point_sign(),bucket.getBucket35_point_bal(),diffValue(bucket.getBucket35_point_bal(), newBucket.getBucket35_point_bal()),newBucket.getBucket35_point_sign(),newBucket.getBucket35_point_bal()
								,bucket.getBucket36_point_sign(),bucket.getBucket36_point_bal(),diffValue(bucket.getBucket36_point_bal(), newBucket.getBucket36_point_bal()),newBucket.getBucket36_point_sign(),newBucket.getBucket36_point_bal()
								,bucket.getLast_expired_point_sign(),bucket.getLast_expired_point_bal(),"YAU"
								);
					}
				}
			}
			
			if(rewardTypeCode.equals(MBBORSConstant.REWARD_TYPE_CODE_TM)) {
				
				for(int ind=0;redeemableCardList.size()>ind;ind++) {
					
					CardHolderBucketDetailDTO bucket = redeemableCardList.get(ind);
					CardHolderBucketDetailDTO newBucket = deductedPointBucketList.get(ind);
					
					if(newBucket.isDeducted()) {
						productRedemptionDao.newPointTxnBucket(
								txtId,bucket.getCardholder_point_bucket_id(),"ORR001",bucket.getOrg_no(),bucket.getCard_type(),bucket.getCard_no()
								,"91","R","ORS Redemption",getProgramCode(programList, bucket.getProgram_id())
								,totalPointRedeem,BigDecimal.ZERO,bucket.getTotal_points_sign(),bucket.getTotal_points_bal(),newBucket.getTotal_points_sign(),newBucket.getTotal_points_bal()
								,null,null,null,null,null
								,bucket.getBucket01_point_sign(),bucket.getBucket01_point_bal(),diffValue(bucket.getBucket01_point_bal(), newBucket.getBucket01_point_bal()),newBucket.getBucket01_point_sign(),newBucket.getBucket01_point_bal()
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								
								,bucket.getLast_expired_point_sign(),bucket.getLast_expired_point_bal(),"YAU"
								);
					}
				}
			}
			
			if(rewardTypeCode.equals(MBBORSConstant.REWARD_TYPE_CODE_MR)) {
				
				for(int ind=0;redeemableCardList.size()>ind;ind++) {
					
					CardHolderBucketDetailDTO bucket = redeemableCardList.get(ind);
					CardHolderBucketDetailDTO newBucket = deductedPointBucketList.get(ind);
					
					if(newBucket.isDeducted()) {
						productRedemptionDao.newPointTxnBucket(
								txtId,bucket.getCardholder_point_bucket_id(),"ORR001",bucket.getOrg_no(),bucket.getCard_type(),bucket.getCard_no()
								,"91","R","ORS Redemption",getProgramCode(programList, bucket.getProgram_id())
								,totalPointRedeem,BigDecimal.ZERO,bucket.getTotal_points_sign(),bucket.getTotal_points_bal(),newBucket.getTotal_points_sign(),newBucket.getTotal_points_bal()
								,null,null,null,null,null
								,bucket.getBucket01_point_sign(),bucket.getBucket01_point_bal(),diffValue(bucket.getBucket01_point_bal(), newBucket.getBucket01_point_bal()),newBucket.getBucket01_point_sign(),newBucket.getBucket01_point_bal()
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								
								,bucket.getLast_expired_point_sign(),bucket.getLast_expired_point_bal(),"YAU"
								);
					}
				}
			}
			
			for(int ind=0;deductedPointBucketList.size()>ind;ind++) {
				
				CardHolderBucketDetailDTO newBucket = deductedPointBucketList.get(ind);
				
				productRedemptionDao.updateCardBucket(newBucket.getTotal_points_sign(), newBucket.getTotal_points_bal(), newBucket.getTotal_points_bal().setScale(0, RoundingMode.FLOOR), 
						newBucket.getBucket01_point_sign(), newBucket.getBucket01_point_bal(), newBucket.getBucket02_point_sign(), newBucket.getBucket02_point_bal(), newBucket.getBucket03_point_sign(), newBucket.getBucket03_point_bal(), 
						newBucket.getBucket04_point_sign(), newBucket.getBucket04_point_bal(), newBucket.getBucket05_point_sign(), newBucket.getBucket05_point_bal(), newBucket.getBucket06_point_sign(), newBucket.getBucket06_point_bal(), 
						newBucket.getBucket07_point_sign(), newBucket.getBucket07_point_bal(), newBucket.getBucket08_point_sign(), newBucket.getBucket08_point_bal(), newBucket.getBucket09_point_sign(), newBucket.getBucket09_point_bal(), 
						newBucket.getBucket10_point_sign(), newBucket.getBucket10_point_bal(), newBucket.getBucket11_point_sign(), newBucket.getBucket11_point_bal(), newBucket.getBucket12_point_sign(), newBucket.getBucket12_point_bal(), 
						newBucket.getBucket13_point_sign(), newBucket.getBucket13_point_bal(), newBucket.getBucket14_point_sign(), newBucket.getBucket14_point_bal(), newBucket.getBucket15_point_sign(), newBucket.getBucket15_point_bal(), 
						newBucket.getBucket16_point_sign(), newBucket.getBucket16_point_bal(), newBucket.getBucket17_point_sign(), newBucket.getBucket17_point_bal(), newBucket.getBucket18_point_sign(), newBucket.getBucket18_point_bal(), 
						newBucket.getBucket19_point_sign(), newBucket.getBucket19_point_bal(), newBucket.getBucket20_point_sign(), newBucket.getBucket20_point_bal(), newBucket.getBucket21_point_sign(), newBucket.getBucket21_point_bal(), 
						newBucket.getBucket22_point_sign(), newBucket.getBucket22_point_bal(), newBucket.getBucket23_point_sign(), newBucket.getBucket23_point_bal(), newBucket.getBucket24_point_sign(), newBucket.getBucket24_point_bal(), 
						newBucket.getBucket25_point_sign(), newBucket.getBucket25_point_bal(), newBucket.getBucket26_point_sign(), newBucket.getBucket26_point_bal(), newBucket.getBucket27_point_sign(), newBucket.getBucket27_point_bal(), 
						newBucket.getBucket28_point_sign(), newBucket.getBucket28_point_bal(), newBucket.getBucket29_point_sign(), newBucket.getBucket29_point_bal(), newBucket.getBucket30_point_sign(), newBucket.getBucket30_point_bal(), 
						newBucket.getBucket31_point_sign(), newBucket.getBucket31_point_bal(), newBucket.getBucket32_point_sign(), newBucket.getBucket32_point_bal(), newBucket.getBucket33_point_sign(), newBucket.getBucket33_point_bal(), 
						newBucket.getBucket34_point_sign(), newBucket.getBucket34_point_bal(), newBucket.getBucket35_point_sign(), newBucket.getBucket35_point_bal(), newBucket.getBucket36_point_sign(), newBucket.getBucket36_point_bal(), 
						"YAU", newBucket.getCardholder_point_bucket_id());
			}
			
			return txtId.toPlainString();
	}
	
	public static String getProgramCode(List<OrsProgramDTO> programList, int programId) {
		
		for(OrsProgramDTO program:programList) {
			if(program.getProgramId()==programId) {
				return program.getProgramCode();
			}
		}
		
		return "NA";
	}
	
	public static BigDecimal diffValue(BigDecimal val1, BigDecimal val2) {
		BigDecimal value1 = val1==null?BigDecimal.ZERO:val1;
		BigDecimal value2 = val2==null?BigDecimal.ZERO:val2;
		BigDecimal result = BigDecimal.ZERO;
		
		if(value1.compareTo(value2)>0) {
			result = value1.subtract(value2);
		}else {
			result = value2.subtract(value1);
		}
		
		return result;
	}
	
	public static BigDecimal totalAvailableRedeemPoint(List<CardHolderBucketDetailDTO> redeemableCardList) {
		BigDecimal result = BigDecimal.ZERO;
		
		for(int ind = 0;redeemableCardList.size()>ind;ind++ ) {
			result = result.add(new BigDecimal(
					(redeemableCardList.get(ind).getTotal_points_sign()
							.concat(redeemableCardList.get(ind).getTotal_points_bal().toPlainString())))
					);
		}
		
		return result;
	}
	
	public static String insertTxnM2U(ProductRedemptionDao productRedemptionDao, 
			List<CardHolderBucketDetailDTO> redeemableCardList, 
			List<CardHolderBucketDetailDTO> deductedPointBucketList,
			CardHolderDetailDTO customerDetails, 
			BigDecimal totalPointRedeem, BigDecimal rewardTypeId, 
			String rewardTypeCode, String email, BigDecimal merchantId, String refOrderNum) {
		
		String orsOrderNum = null;
			
		try {
			List<OrsProgramDTO> programList = productRedemptionDao.getProgramList();
			
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
			String strNow = df.format(new Date());
			orsOrderNum = strNow;

//					      ,[MR_PARTNER_MEMBER_NO]
//					      ,[MR_PARTNER_POINT]
//					      ,[MR_COST_PER_UNIT]
			
			BigDecimal	txtId= productRedemptionDao.newPointTxn(strNow, 
					refOrderNum,
					customerDetails.getCust_ic_no(), 
					customerDetails.getFirst_name(), 
					customerDetails.getLast_name(), 
					totalPointRedeem, BigDecimal.ZERO, rewardTypeId, 
					customerDetails.getAddr1(), 
					customerDetails.getAddr2(),
					customerDetails.getAddr1(), 
					customerDetails.getAddr4(),
					customerDetails.getZip_code(),
					email, customerDetails.getHome_no(), 
					customerDetails.getOffice_no(), customerDetails.getMobile_no(), "ORS Web", 
					"R","S", "YAU",  
					customerDetails.getCardholder_id());
			System.out.println("txtId".concat(txtId.toPlainString()));
		
			productRedemptionDao.newPointTxnDetails(txtId,strNow, 
					null, 
					BigDecimal.ONE, 
					totalPointRedeem, 
					merchantId, 
					"P", 
					false, 
					"YAU",
					redeemableCardList.get(0).getCard_no());

			
			if(rewardTypeCode.equals(MBBORSConstant.REWARD_TYPE_CODE_TP)) {
			
				for(int ind=0;redeemableCardList.size()>ind;ind++) {
					
					CardHolderBucketDetailDTO bucket = redeemableCardList.get(ind);
					CardHolderBucketDetailDTO newBucket = deductedPointBucketList.get(ind);
					
					if(newBucket.isDeducted()) {
						productRedemptionDao.newPointTxnBucket(
								txtId,bucket.getCardholder_point_bucket_id(),strNow,bucket.getOrg_no(),bucket.getCard_type(),bucket.getCard_no()
								,"91","R","ORS Redemption",getProgramCode(programList, bucket.getProgram_id())
								,totalPointRedeem,BigDecimal.ZERO,bucket.getTotal_points_sign(),bucket.getTotal_points_bal(),newBucket.getTotal_points_sign(),newBucket.getTotal_points_bal()
								,null,null,null,null,null
								,bucket.getBucket01_point_sign(),bucket.getBucket01_point_bal(),diffValue(bucket.getBucket01_point_bal(), newBucket.getBucket01_point_bal()),newBucket.getBucket01_point_sign(),newBucket.getBucket01_point_bal()
								,bucket.getBucket02_point_sign(),bucket.getBucket02_point_bal(),diffValue(bucket.getBucket02_point_bal(), newBucket.getBucket02_point_bal()),newBucket.getBucket02_point_sign(),newBucket.getBucket02_point_bal()
								,bucket.getBucket03_point_sign(),bucket.getBucket03_point_bal(),diffValue(bucket.getBucket03_point_bal(), newBucket.getBucket03_point_bal()),newBucket.getBucket03_point_sign(),newBucket.getBucket03_point_bal()
								,bucket.getBucket04_point_sign(),bucket.getBucket04_point_bal(),diffValue(bucket.getBucket04_point_bal(), newBucket.getBucket04_point_bal()),newBucket.getBucket04_point_sign(),newBucket.getBucket04_point_bal()
								,bucket.getBucket05_point_sign(),bucket.getBucket05_point_bal(),diffValue(bucket.getBucket05_point_bal(), newBucket.getBucket05_point_bal()),newBucket.getBucket05_point_sign(),newBucket.getBucket05_point_bal()
								,bucket.getBucket06_point_sign(),bucket.getBucket06_point_bal(),diffValue(bucket.getBucket06_point_bal(), newBucket.getBucket06_point_bal()),newBucket.getBucket06_point_sign(),newBucket.getBucket06_point_bal()
								,bucket.getBucket07_point_sign(),bucket.getBucket07_point_bal(),diffValue(bucket.getBucket07_point_bal(), newBucket.getBucket07_point_bal()),newBucket.getBucket07_point_sign(),newBucket.getBucket07_point_bal()
								,bucket.getBucket08_point_sign(),bucket.getBucket08_point_bal(),diffValue(bucket.getBucket08_point_bal(), newBucket.getBucket08_point_bal()),newBucket.getBucket08_point_sign(),newBucket.getBucket08_point_bal()
								,bucket.getBucket09_point_sign(),bucket.getBucket09_point_bal(),diffValue(bucket.getBucket09_point_bal(), newBucket.getBucket09_point_bal()),newBucket.getBucket09_point_sign(),newBucket.getBucket09_point_bal()
								,bucket.getBucket10_point_sign(),bucket.getBucket10_point_bal(),diffValue(bucket.getBucket10_point_bal(), newBucket.getBucket10_point_bal()),newBucket.getBucket10_point_sign(),newBucket.getBucket10_point_bal()
								
								,bucket.getBucket11_point_sign(),bucket.getBucket11_point_bal(),diffValue(bucket.getBucket11_point_bal(), newBucket.getBucket11_point_bal()),newBucket.getBucket11_point_sign(),newBucket.getBucket11_point_bal()
								,bucket.getBucket12_point_sign(),bucket.getBucket12_point_bal(),diffValue(bucket.getBucket12_point_bal(), newBucket.getBucket12_point_bal()),newBucket.getBucket12_point_sign(),newBucket.getBucket12_point_bal()
								,bucket.getBucket13_point_sign(),bucket.getBucket13_point_bal(),diffValue(bucket.getBucket13_point_bal(), newBucket.getBucket13_point_bal()),newBucket.getBucket13_point_sign(),newBucket.getBucket13_point_bal()
								,bucket.getBucket14_point_sign(),bucket.getBucket14_point_bal(),diffValue(bucket.getBucket14_point_bal(), newBucket.getBucket14_point_bal()),newBucket.getBucket14_point_sign(),newBucket.getBucket14_point_bal()
								,bucket.getBucket15_point_sign(),bucket.getBucket15_point_bal(),diffValue(bucket.getBucket15_point_bal(), newBucket.getBucket15_point_bal()),newBucket.getBucket15_point_sign(),newBucket.getBucket15_point_bal()
								,bucket.getBucket16_point_sign(),bucket.getBucket16_point_bal(),diffValue(bucket.getBucket16_point_bal(), newBucket.getBucket16_point_bal()),newBucket.getBucket16_point_sign(),newBucket.getBucket16_point_bal()
								,bucket.getBucket17_point_sign(),bucket.getBucket17_point_bal(),diffValue(bucket.getBucket17_point_bal(), newBucket.getBucket17_point_bal()),newBucket.getBucket17_point_sign(),newBucket.getBucket17_point_bal()
								,bucket.getBucket18_point_sign(),bucket.getBucket18_point_bal(),diffValue(bucket.getBucket18_point_bal(), newBucket.getBucket18_point_bal()),newBucket.getBucket18_point_sign(),newBucket.getBucket18_point_bal()
								,bucket.getBucket19_point_sign(),bucket.getBucket19_point_bal(),diffValue(bucket.getBucket19_point_bal(), newBucket.getBucket19_point_bal()),newBucket.getBucket19_point_sign(),newBucket.getBucket19_point_bal()
								,bucket.getBucket20_point_sign(),bucket.getBucket20_point_bal(),diffValue(bucket.getBucket20_point_bal(), newBucket.getBucket20_point_bal()),newBucket.getBucket20_point_sign(),newBucket.getBucket20_point_bal()
								
								,bucket.getBucket21_point_sign(),bucket.getBucket21_point_bal(),diffValue(bucket.getBucket21_point_bal(), newBucket.getBucket21_point_bal()),newBucket.getBucket21_point_sign(),newBucket.getBucket21_point_bal()
								,bucket.getBucket22_point_sign(),bucket.getBucket22_point_bal(),diffValue(bucket.getBucket22_point_bal(), newBucket.getBucket22_point_bal()),newBucket.getBucket22_point_sign(),newBucket.getBucket22_point_bal()
								,bucket.getBucket23_point_sign(),bucket.getBucket23_point_bal(),diffValue(bucket.getBucket23_point_bal(), newBucket.getBucket23_point_bal()),newBucket.getBucket23_point_sign(),newBucket.getBucket23_point_bal()
								,bucket.getBucket24_point_sign(),bucket.getBucket24_point_bal(),diffValue(bucket.getBucket24_point_bal(), newBucket.getBucket24_point_bal()),newBucket.getBucket24_point_sign(),newBucket.getBucket24_point_bal()
								,bucket.getBucket25_point_sign(),bucket.getBucket25_point_bal(),diffValue(bucket.getBucket25_point_bal(), newBucket.getBucket25_point_bal()),newBucket.getBucket25_point_sign(),newBucket.getBucket25_point_bal()
								,bucket.getBucket26_point_sign(),bucket.getBucket26_point_bal(),diffValue(bucket.getBucket26_point_bal(), newBucket.getBucket26_point_bal()),newBucket.getBucket26_point_sign(),newBucket.getBucket26_point_bal()
								,bucket.getBucket27_point_sign(),bucket.getBucket27_point_bal(),diffValue(bucket.getBucket27_point_bal(), newBucket.getBucket27_point_bal()),newBucket.getBucket27_point_sign(),newBucket.getBucket27_point_bal()
								,bucket.getBucket28_point_sign(),bucket.getBucket28_point_bal(),diffValue(bucket.getBucket28_point_bal(), newBucket.getBucket28_point_bal()),newBucket.getBucket28_point_sign(),newBucket.getBucket28_point_bal()
								,bucket.getBucket29_point_sign(),bucket.getBucket29_point_bal(),diffValue(bucket.getBucket29_point_bal(), newBucket.getBucket29_point_bal()),newBucket.getBucket29_point_sign(),newBucket.getBucket29_point_bal()
								,bucket.getBucket30_point_sign(),bucket.getBucket30_point_bal(),diffValue(bucket.getBucket30_point_bal(), newBucket.getBucket30_point_bal()),newBucket.getBucket30_point_sign(),newBucket.getBucket30_point_bal()
								
								,bucket.getBucket31_point_sign(),bucket.getBucket31_point_bal(),diffValue(bucket.getBucket31_point_bal(), newBucket.getBucket31_point_bal()),newBucket.getBucket31_point_sign(),newBucket.getBucket31_point_bal()
								,bucket.getBucket32_point_sign(),bucket.getBucket32_point_bal(),diffValue(bucket.getBucket32_point_bal(), newBucket.getBucket32_point_bal()),newBucket.getBucket32_point_sign(),newBucket.getBucket32_point_bal()
								,bucket.getBucket33_point_sign(),bucket.getBucket33_point_bal(),diffValue(bucket.getBucket33_point_bal(), newBucket.getBucket33_point_bal()),newBucket.getBucket33_point_sign(),newBucket.getBucket33_point_bal()
								,bucket.getBucket34_point_sign(),bucket.getBucket34_point_bal(),diffValue(bucket.getBucket34_point_bal(), newBucket.getBucket34_point_bal()),newBucket.getBucket34_point_sign(),newBucket.getBucket34_point_bal()
								,bucket.getBucket35_point_sign(),bucket.getBucket35_point_bal(),diffValue(bucket.getBucket35_point_bal(), newBucket.getBucket35_point_bal()),newBucket.getBucket35_point_sign(),newBucket.getBucket35_point_bal()
								,bucket.getBucket36_point_sign(),bucket.getBucket36_point_bal(),diffValue(bucket.getBucket36_point_bal(), newBucket.getBucket36_point_bal()),newBucket.getBucket36_point_sign(),newBucket.getBucket36_point_bal()
								,bucket.getLast_expired_point_sign(),bucket.getLast_expired_point_bal(),"YAU"
								);
					}
				}
			}
			
			if(rewardTypeCode.equals(MBBORSConstant.REWARD_TYPE_CODE_TM)) {
				
				for(int ind=0;redeemableCardList.size()>ind;ind++) {
					
					CardHolderBucketDetailDTO bucket = redeemableCardList.get(ind);
					CardHolderBucketDetailDTO newBucket = deductedPointBucketList.get(ind);
					
					if(newBucket.isDeducted()) {
						productRedemptionDao.newPointTxnBucket(
								txtId,bucket.getCardholder_point_bucket_id(),strNow,bucket.getOrg_no(),bucket.getCard_type(),bucket.getCard_no()
								,"91","R","ORS Redemption",getProgramCode(programList, bucket.getProgram_id())
								,totalPointRedeem,BigDecimal.ZERO,bucket.getTotal_points_sign(),bucket.getTotal_points_bal(),newBucket.getTotal_points_sign(),newBucket.getTotal_points_bal()
								,null,null,null,null,null
								,bucket.getBucket01_point_sign(),bucket.getBucket01_point_bal(),diffValue(bucket.getBucket01_point_bal(), newBucket.getBucket01_point_bal()),newBucket.getBucket01_point_sign(),newBucket.getBucket01_point_bal()
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								
								,bucket.getLast_expired_point_sign(),bucket.getLast_expired_point_bal(),"YAU"
								);
					}
				}
			}
			
			if(rewardTypeCode.equals(MBBORSConstant.REWARD_TYPE_CODE_MR)) {
				
				for(int ind=0;redeemableCardList.size()>ind;ind++) {
					
					CardHolderBucketDetailDTO bucket = redeemableCardList.get(ind);
					CardHolderBucketDetailDTO newBucket = deductedPointBucketList.get(ind);
					
					if(newBucket.isDeducted()) {
						productRedemptionDao.newPointTxnBucket(
								txtId,bucket.getCardholder_point_bucket_id(),strNow,bucket.getOrg_no(),bucket.getCard_type(),bucket.getCard_no()
								,"91","R","ORS Redemption",getProgramCode(programList, bucket.getProgram_id())
								,totalPointRedeem,BigDecimal.ZERO,bucket.getTotal_points_sign(),bucket.getTotal_points_bal(),newBucket.getTotal_points_sign(),newBucket.getTotal_points_bal()
								,null,null,null,null,null
								,bucket.getBucket01_point_sign(),bucket.getBucket01_point_bal(),diffValue(bucket.getBucket01_point_bal(), newBucket.getBucket01_point_bal()),newBucket.getBucket01_point_sign(),newBucket.getBucket01_point_bal()
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								
								,bucket.getLast_expired_point_sign(),bucket.getLast_expired_point_bal(),"YAU"
								);
					}
				}
			}
			
			for(int ind=0;deductedPointBucketList.size()>ind;ind++) {
				
				CardHolderBucketDetailDTO newBucket = deductedPointBucketList.get(ind);
				
				productRedemptionDao.updateCardBucket(newBucket.getTotal_points_sign(), newBucket.getTotal_points_bal(), newBucket.getTotal_points_bal().setScale(0, RoundingMode.FLOOR), 
						newBucket.getBucket01_point_sign(), newBucket.getBucket01_point_bal(), newBucket.getBucket02_point_sign(), newBucket.getBucket02_point_bal(), newBucket.getBucket03_point_sign(), newBucket.getBucket03_point_bal(), 
						newBucket.getBucket04_point_sign(), newBucket.getBucket04_point_bal(), newBucket.getBucket05_point_sign(), newBucket.getBucket05_point_bal(), newBucket.getBucket06_point_sign(), newBucket.getBucket06_point_bal(), 
						newBucket.getBucket07_point_sign(), newBucket.getBucket07_point_bal(), newBucket.getBucket08_point_sign(), newBucket.getBucket08_point_bal(), newBucket.getBucket09_point_sign(), newBucket.getBucket09_point_bal(), 
						newBucket.getBucket10_point_sign(), newBucket.getBucket10_point_bal(), newBucket.getBucket11_point_sign(), newBucket.getBucket11_point_bal(), newBucket.getBucket12_point_sign(), newBucket.getBucket12_point_bal(), 
						newBucket.getBucket13_point_sign(), newBucket.getBucket13_point_bal(), newBucket.getBucket14_point_sign(), newBucket.getBucket14_point_bal(), newBucket.getBucket15_point_sign(), newBucket.getBucket15_point_bal(), 
						newBucket.getBucket16_point_sign(), newBucket.getBucket16_point_bal(), newBucket.getBucket17_point_sign(), newBucket.getBucket17_point_bal(), newBucket.getBucket18_point_sign(), newBucket.getBucket18_point_bal(), 
						newBucket.getBucket19_point_sign(), newBucket.getBucket19_point_bal(), newBucket.getBucket20_point_sign(), newBucket.getBucket20_point_bal(), newBucket.getBucket21_point_sign(), newBucket.getBucket21_point_bal(), 
						newBucket.getBucket22_point_sign(), newBucket.getBucket22_point_bal(), newBucket.getBucket23_point_sign(), newBucket.getBucket23_point_bal(), newBucket.getBucket24_point_sign(), newBucket.getBucket24_point_bal(), 
						newBucket.getBucket25_point_sign(), newBucket.getBucket25_point_bal(), newBucket.getBucket26_point_sign(), newBucket.getBucket26_point_bal(), newBucket.getBucket27_point_sign(), newBucket.getBucket27_point_bal(), 
						newBucket.getBucket28_point_sign(), newBucket.getBucket28_point_bal(), newBucket.getBucket29_point_sign(), newBucket.getBucket29_point_bal(), newBucket.getBucket30_point_sign(), newBucket.getBucket30_point_bal(), 
						newBucket.getBucket31_point_sign(), newBucket.getBucket31_point_bal(), newBucket.getBucket32_point_sign(), newBucket.getBucket32_point_bal(), newBucket.getBucket33_point_sign(), newBucket.getBucket33_point_bal(), 
						newBucket.getBucket34_point_sign(), newBucket.getBucket34_point_bal(), newBucket.getBucket35_point_sign(), newBucket.getBucket35_point_bal(), newBucket.getBucket36_point_sign(), newBucket.getBucket36_point_bal(), 
						"YAU", newBucket.getCardholder_point_bucket_id());
			}
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
		return orsOrderNum;
	}
	
	public static String insertTxnTerminal(ProductRedemptionDao productRedemptionDao, 
			List<CardHolderBucketDetailDTO> redeemableCardList, 
			List<CardHolderBucketDetailDTO> deductedPointBucketList,
			CardHolderDetailDTO customerDetails, 
			BigDecimal totalPointRedeem, BigDecimal rewardTypeId, 
			String rewardTypeCode, String email, BigDecimal merchantId) {
			
			SimpleDateFormat df = new SimpleDateFormat("yyMMddHHmmss");
			String strNow = df.format(new Date());
			
		try {
			List<OrsProgramDTO> programList = productRedemptionDao.getProgramList();
			
			
			
			BigDecimal txtId= productRedemptionDao.newPointTxn(strNow, 
					null,
					customerDetails.getCust_ic_no(), 
					null, 
					null, 
					totalPointRedeem, BigDecimal.ZERO, rewardTypeId, 
					null, 
					null,
					null, 
					null,
					null, 
					null,null,
					null, null, "Terminal", 
					"R","S", "YAU", 
					customerDetails.getCardholder_id());
		
			productRedemptionDao.newPointTxnDetails(txtId,strNow, 
					null, 
					BigDecimal.ZERO, 
					totalPointRedeem, 
					merchantId, 
					"P", 
					false, 
					"YAU",
					redeemableCardList.get(0).getCard_no());

			
			if(rewardTypeCode.equals(MBBORSConstant.REWARD_TYPE_CODE_TP)) {
			
				for(int ind=0;redeemableCardList.size()>ind;ind++) {
					
					CardHolderBucketDetailDTO bucket = redeemableCardList.get(ind);
					CardHolderBucketDetailDTO newBucket = deductedPointBucketList.get(ind);
					
					if(newBucket.isDeducted()) {
						productRedemptionDao.newPointTxnBucket(
								txtId,bucket.getCardholder_point_bucket_id(),strNow,bucket.getOrg_no(),bucket.getCard_type(),bucket.getCard_no()
								,"91","R","ORS Redemption",getProgramCode(programList, bucket.getProgram_id())
								,totalPointRedeem,BigDecimal.ZERO,bucket.getTotal_points_sign(),bucket.getTotal_points_bal(),newBucket.getTotal_points_sign(),newBucket.getTotal_points_bal()
								,null,null,null,null,null
								,bucket.getBucket01_point_sign(),bucket.getBucket01_point_bal(),diffValue(bucket.getBucket01_point_bal(), newBucket.getBucket01_point_bal()),newBucket.getBucket01_point_sign(),newBucket.getBucket01_point_bal()
								,bucket.getBucket02_point_sign(),bucket.getBucket02_point_bal(),diffValue(bucket.getBucket02_point_bal(), newBucket.getBucket02_point_bal()),newBucket.getBucket02_point_sign(),newBucket.getBucket02_point_bal()
								,bucket.getBucket03_point_sign(),bucket.getBucket03_point_bal(),diffValue(bucket.getBucket03_point_bal(), newBucket.getBucket03_point_bal()),newBucket.getBucket03_point_sign(),newBucket.getBucket03_point_bal()
								,bucket.getBucket04_point_sign(),bucket.getBucket04_point_bal(),diffValue(bucket.getBucket04_point_bal(), newBucket.getBucket04_point_bal()),newBucket.getBucket04_point_sign(),newBucket.getBucket04_point_bal()
								,bucket.getBucket05_point_sign(),bucket.getBucket05_point_bal(),diffValue(bucket.getBucket05_point_bal(), newBucket.getBucket05_point_bal()),newBucket.getBucket05_point_sign(),newBucket.getBucket05_point_bal()
								,bucket.getBucket06_point_sign(),bucket.getBucket06_point_bal(),diffValue(bucket.getBucket06_point_bal(), newBucket.getBucket06_point_bal()),newBucket.getBucket06_point_sign(),newBucket.getBucket06_point_bal()
								,bucket.getBucket07_point_sign(),bucket.getBucket07_point_bal(),diffValue(bucket.getBucket07_point_bal(), newBucket.getBucket07_point_bal()),newBucket.getBucket07_point_sign(),newBucket.getBucket07_point_bal()
								,bucket.getBucket08_point_sign(),bucket.getBucket08_point_bal(),diffValue(bucket.getBucket08_point_bal(), newBucket.getBucket08_point_bal()),newBucket.getBucket08_point_sign(),newBucket.getBucket08_point_bal()
								,bucket.getBucket09_point_sign(),bucket.getBucket09_point_bal(),diffValue(bucket.getBucket09_point_bal(), newBucket.getBucket09_point_bal()),newBucket.getBucket09_point_sign(),newBucket.getBucket09_point_bal()
								,bucket.getBucket10_point_sign(),bucket.getBucket10_point_bal(),diffValue(bucket.getBucket10_point_bal(), newBucket.getBucket10_point_bal()),newBucket.getBucket10_point_sign(),newBucket.getBucket10_point_bal()
								
								,bucket.getBucket11_point_sign(),bucket.getBucket11_point_bal(),diffValue(bucket.getBucket11_point_bal(), newBucket.getBucket11_point_bal()),newBucket.getBucket11_point_sign(),newBucket.getBucket11_point_bal()
								,bucket.getBucket12_point_sign(),bucket.getBucket12_point_bal(),diffValue(bucket.getBucket12_point_bal(), newBucket.getBucket12_point_bal()),newBucket.getBucket12_point_sign(),newBucket.getBucket12_point_bal()
								,bucket.getBucket13_point_sign(),bucket.getBucket13_point_bal(),diffValue(bucket.getBucket13_point_bal(), newBucket.getBucket13_point_bal()),newBucket.getBucket13_point_sign(),newBucket.getBucket13_point_bal()
								,bucket.getBucket14_point_sign(),bucket.getBucket14_point_bal(),diffValue(bucket.getBucket14_point_bal(), newBucket.getBucket14_point_bal()),newBucket.getBucket14_point_sign(),newBucket.getBucket14_point_bal()
								,bucket.getBucket15_point_sign(),bucket.getBucket15_point_bal(),diffValue(bucket.getBucket15_point_bal(), newBucket.getBucket15_point_bal()),newBucket.getBucket15_point_sign(),newBucket.getBucket15_point_bal()
								,bucket.getBucket16_point_sign(),bucket.getBucket16_point_bal(),diffValue(bucket.getBucket16_point_bal(), newBucket.getBucket16_point_bal()),newBucket.getBucket16_point_sign(),newBucket.getBucket16_point_bal()
								,bucket.getBucket17_point_sign(),bucket.getBucket17_point_bal(),diffValue(bucket.getBucket17_point_bal(), newBucket.getBucket17_point_bal()),newBucket.getBucket17_point_sign(),newBucket.getBucket17_point_bal()
								,bucket.getBucket18_point_sign(),bucket.getBucket18_point_bal(),diffValue(bucket.getBucket18_point_bal(), newBucket.getBucket18_point_bal()),newBucket.getBucket18_point_sign(),newBucket.getBucket18_point_bal()
								,bucket.getBucket19_point_sign(),bucket.getBucket19_point_bal(),diffValue(bucket.getBucket19_point_bal(), newBucket.getBucket19_point_bal()),newBucket.getBucket19_point_sign(),newBucket.getBucket19_point_bal()
								,bucket.getBucket20_point_sign(),bucket.getBucket20_point_bal(),diffValue(bucket.getBucket20_point_bal(), newBucket.getBucket20_point_bal()),newBucket.getBucket20_point_sign(),newBucket.getBucket20_point_bal()
								
								,bucket.getBucket21_point_sign(),bucket.getBucket21_point_bal(),diffValue(bucket.getBucket21_point_bal(), newBucket.getBucket21_point_bal()),newBucket.getBucket21_point_sign(),newBucket.getBucket21_point_bal()
								,bucket.getBucket22_point_sign(),bucket.getBucket22_point_bal(),diffValue(bucket.getBucket22_point_bal(), newBucket.getBucket22_point_bal()),newBucket.getBucket22_point_sign(),newBucket.getBucket22_point_bal()
								,bucket.getBucket23_point_sign(),bucket.getBucket23_point_bal(),diffValue(bucket.getBucket23_point_bal(), newBucket.getBucket23_point_bal()),newBucket.getBucket23_point_sign(),newBucket.getBucket23_point_bal()
								,bucket.getBucket24_point_sign(),bucket.getBucket24_point_bal(),diffValue(bucket.getBucket24_point_bal(), newBucket.getBucket24_point_bal()),newBucket.getBucket24_point_sign(),newBucket.getBucket24_point_bal()
								,bucket.getBucket25_point_sign(),bucket.getBucket25_point_bal(),diffValue(bucket.getBucket25_point_bal(), newBucket.getBucket25_point_bal()),newBucket.getBucket25_point_sign(),newBucket.getBucket25_point_bal()
								,bucket.getBucket26_point_sign(),bucket.getBucket26_point_bal(),diffValue(bucket.getBucket26_point_bal(), newBucket.getBucket26_point_bal()),newBucket.getBucket26_point_sign(),newBucket.getBucket26_point_bal()
								,bucket.getBucket27_point_sign(),bucket.getBucket27_point_bal(),diffValue(bucket.getBucket27_point_bal(), newBucket.getBucket27_point_bal()),newBucket.getBucket27_point_sign(),newBucket.getBucket27_point_bal()
								,bucket.getBucket28_point_sign(),bucket.getBucket28_point_bal(),diffValue(bucket.getBucket28_point_bal(), newBucket.getBucket28_point_bal()),newBucket.getBucket28_point_sign(),newBucket.getBucket28_point_bal()
								,bucket.getBucket29_point_sign(),bucket.getBucket29_point_bal(),diffValue(bucket.getBucket29_point_bal(), newBucket.getBucket29_point_bal()),newBucket.getBucket29_point_sign(),newBucket.getBucket29_point_bal()
								,bucket.getBucket30_point_sign(),bucket.getBucket30_point_bal(),diffValue(bucket.getBucket30_point_bal(), newBucket.getBucket30_point_bal()),newBucket.getBucket30_point_sign(),newBucket.getBucket30_point_bal()
								
								,bucket.getBucket31_point_sign(),bucket.getBucket31_point_bal(),diffValue(bucket.getBucket31_point_bal(), newBucket.getBucket31_point_bal()),newBucket.getBucket31_point_sign(),newBucket.getBucket31_point_bal()
								,bucket.getBucket32_point_sign(),bucket.getBucket32_point_bal(),diffValue(bucket.getBucket32_point_bal(), newBucket.getBucket32_point_bal()),newBucket.getBucket32_point_sign(),newBucket.getBucket32_point_bal()
								,bucket.getBucket33_point_sign(),bucket.getBucket33_point_bal(),diffValue(bucket.getBucket33_point_bal(), newBucket.getBucket33_point_bal()),newBucket.getBucket33_point_sign(),newBucket.getBucket33_point_bal()
								,bucket.getBucket34_point_sign(),bucket.getBucket34_point_bal(),diffValue(bucket.getBucket34_point_bal(), newBucket.getBucket34_point_bal()),newBucket.getBucket34_point_sign(),newBucket.getBucket34_point_bal()
								,bucket.getBucket35_point_sign(),bucket.getBucket35_point_bal(),diffValue(bucket.getBucket35_point_bal(), newBucket.getBucket35_point_bal()),newBucket.getBucket35_point_sign(),newBucket.getBucket35_point_bal()
								,bucket.getBucket36_point_sign(),bucket.getBucket36_point_bal(),diffValue(bucket.getBucket36_point_bal(), newBucket.getBucket36_point_bal()),newBucket.getBucket36_point_sign(),newBucket.getBucket36_point_bal()
								,bucket.getLast_expired_point_sign(),bucket.getLast_expired_point_bal(),"YAU"
								);
					}
				}
			}
			
			if(rewardTypeCode.equals(MBBORSConstant.REWARD_TYPE_CODE_TM)) {
				
				for(int ind=0;redeemableCardList.size()>ind;ind++) {
					
					CardHolderBucketDetailDTO bucket = redeemableCardList.get(ind);
					CardHolderBucketDetailDTO newBucket = deductedPointBucketList.get(ind);
					
					if(newBucket.isDeducted()) {
						productRedemptionDao.newPointTxnBucket(
								txtId,bucket.getCardholder_point_bucket_id(),strNow,bucket.getOrg_no(),bucket.getCard_type(),bucket.getCard_no()
								,"91","R","ORS Redemption",getProgramCode(programList, bucket.getProgram_id())
								,totalPointRedeem,BigDecimal.ZERO,bucket.getTotal_points_sign(),bucket.getTotal_points_bal(),newBucket.getTotal_points_sign(),newBucket.getTotal_points_bal()
								,null,null,null,null,null
								,bucket.getBucket01_point_sign(),bucket.getBucket01_point_bal(),diffValue(bucket.getBucket01_point_bal(), newBucket.getBucket01_point_bal()),newBucket.getBucket01_point_sign(),newBucket.getBucket01_point_bal()
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								
								,bucket.getLast_expired_point_sign(),bucket.getLast_expired_point_bal(),"YAU"
								);
					}
				}
			}
			
			if(rewardTypeCode.equals(MBBORSConstant.REWARD_TYPE_CODE_MR)) {
				
				for(int ind=0;redeemableCardList.size()>ind;ind++) {
					
					CardHolderBucketDetailDTO bucket = redeemableCardList.get(ind);
					CardHolderBucketDetailDTO newBucket = deductedPointBucketList.get(ind);
					
					if(newBucket.isDeducted()) {
						productRedemptionDao.newPointTxnBucket(
								txtId,bucket.getCardholder_point_bucket_id(),strNow,bucket.getOrg_no(),bucket.getCard_type(),bucket.getCard_no()
								,"91","R","ORS Redemption",getProgramCode(programList, bucket.getProgram_id())
								,totalPointRedeem,BigDecimal.ZERO,bucket.getTotal_points_sign(),bucket.getTotal_points_bal(),newBucket.getTotal_points_sign(),newBucket.getTotal_points_bal()
								,null,null,null,null,null
								,bucket.getBucket01_point_sign(),bucket.getBucket01_point_bal(),diffValue(bucket.getBucket01_point_bal(), newBucket.getBucket01_point_bal()),newBucket.getBucket01_point_sign(),newBucket.getBucket01_point_bal()
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								,null,null,null,null,null
								
								,bucket.getLast_expired_point_sign(),bucket.getLast_expired_point_bal(),"YAU"
								);
					}
				}
			}
			
			for(int ind=0;deductedPointBucketList.size()>ind;ind++) {
				
				CardHolderBucketDetailDTO newBucket = deductedPointBucketList.get(ind);
				
				productRedemptionDao.updateCardBucket(newBucket.getTotal_points_sign(), newBucket.getTotal_points_bal(), newBucket.getTotal_points_bal().setScale(0, RoundingMode.FLOOR), 
						newBucket.getBucket01_point_sign(), newBucket.getBucket01_point_bal(), newBucket.getBucket02_point_sign(), newBucket.getBucket02_point_bal(), newBucket.getBucket03_point_sign(), newBucket.getBucket03_point_bal(), 
						newBucket.getBucket04_point_sign(), newBucket.getBucket04_point_bal(), newBucket.getBucket05_point_sign(), newBucket.getBucket05_point_bal(), newBucket.getBucket06_point_sign(), newBucket.getBucket06_point_bal(), 
						newBucket.getBucket07_point_sign(), newBucket.getBucket07_point_bal(), newBucket.getBucket08_point_sign(), newBucket.getBucket08_point_bal(), newBucket.getBucket09_point_sign(), newBucket.getBucket09_point_bal(), 
						newBucket.getBucket10_point_sign(), newBucket.getBucket10_point_bal(), newBucket.getBucket11_point_sign(), newBucket.getBucket11_point_bal(), newBucket.getBucket12_point_sign(), newBucket.getBucket12_point_bal(), 
						newBucket.getBucket13_point_sign(), newBucket.getBucket13_point_bal(), newBucket.getBucket14_point_sign(), newBucket.getBucket14_point_bal(), newBucket.getBucket15_point_sign(), newBucket.getBucket15_point_bal(), 
						newBucket.getBucket16_point_sign(), newBucket.getBucket16_point_bal(), newBucket.getBucket17_point_sign(), newBucket.getBucket17_point_bal(), newBucket.getBucket18_point_sign(), newBucket.getBucket18_point_bal(), 
						newBucket.getBucket19_point_sign(), newBucket.getBucket19_point_bal(), newBucket.getBucket20_point_sign(), newBucket.getBucket20_point_bal(), newBucket.getBucket21_point_sign(), newBucket.getBucket21_point_bal(), 
						newBucket.getBucket22_point_sign(), newBucket.getBucket22_point_bal(), newBucket.getBucket23_point_sign(), newBucket.getBucket23_point_bal(), newBucket.getBucket24_point_sign(), newBucket.getBucket24_point_bal(), 
						newBucket.getBucket25_point_sign(), newBucket.getBucket25_point_bal(), newBucket.getBucket26_point_sign(), newBucket.getBucket26_point_bal(), newBucket.getBucket27_point_sign(), newBucket.getBucket27_point_bal(), 
						newBucket.getBucket28_point_sign(), newBucket.getBucket28_point_bal(), newBucket.getBucket29_point_sign(), newBucket.getBucket29_point_bal(), newBucket.getBucket30_point_sign(), newBucket.getBucket30_point_bal(), 
						newBucket.getBucket31_point_sign(), newBucket.getBucket31_point_bal(), newBucket.getBucket32_point_sign(), newBucket.getBucket32_point_bal(), newBucket.getBucket33_point_sign(), newBucket.getBucket33_point_bal(), 
						newBucket.getBucket34_point_sign(), newBucket.getBucket34_point_bal(), newBucket.getBucket35_point_sign(), newBucket.getBucket35_point_bal(), newBucket.getBucket36_point_sign(), newBucket.getBucket36_point_bal(), 
						"YAU", newBucket.getCardholder_point_bucket_id());
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return strNow;
	}
	
	public static String getTotalBalance12N(List<CardHolderBucketDetailDTO> redeemableCardList, String postingFlag) {
		String result = "";
		BigDecimal total = BigDecimal.ZERO;
		DecimalFormat df = new DecimalFormat("000000000000");
		
		if(redeemableCardList!=null&&redeemableCardList.size()>0) {
			for(int ind=0;ind<redeemableCardList.size();ind++) {
				CardHolderBucketDetailDTO record = redeemableCardList.get(ind);
				record.setCard_post_flag(record.getCard_post_flag().toUpperCase().equals("XX")?"PP":record.getCard_post_flag());
				if(record!=null
						&&record.getTotal_points_sign()!=null
						&&record.getTotal_points_bal()!=null
						&&record.getCard_post_flag()!=null
						&&record.getCard_post_flag().equals(postingFlag)) {
					total = total.add(new BigDecimal(record.getTotal_points_sign()
							.concat(record.getTotal_points_bal().toPlainString())));
				}
			}
		}
		
		result = df.format(total.multiply(new BigDecimal("100")));
		
		return result;
	}
}
