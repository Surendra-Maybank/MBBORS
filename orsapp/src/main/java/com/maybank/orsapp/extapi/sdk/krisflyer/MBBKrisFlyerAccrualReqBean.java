package com.maybank.orsapp.extapi.sdk.krisflyer;

public class MBBKrisFlyerAccrualReqBean {
	
	private RequestorProfile requestorProfile;

	private PartnerProfile partnerProfile;

	private TransDetails transDetails;
	
	private String transactionCode;
	
	private String familyName;
	
	private String givenName;
	
	private int miles;
	
	private String awardDate;
	
	private String awardEndDate;
	
	private String awardDescription;
	
	private String participantCode;
	
	private String propertyLocationCode;
	
	private String kfReferenceCode;
	
	private String promotionAwardDate;
	
	private String promotionAwardDescription;
	
	private int promotionMileAwarded;
	
	private String promotionCode;
	
	private String reversalFlag;
	
	private String amendmentCode;
	
	private String partnerTransactionCode;
	
	public RequestorProfile getRequestorProfile() {
		return requestorProfile;
	}
	public void setRequestorProfile(RequestorProfile requestorProfile) {
		this.requestorProfile = requestorProfile;
	}
	public PartnerProfile getPartnerProfile() {
		return partnerProfile;
	}
	public void setPartnerProfile(PartnerProfile partnerProfile) {
		this.partnerProfile = partnerProfile;
	}
	public TransDetails getTransDetails() {
		return transDetails;
	}
	public void setTransDetails(TransDetails transDetails) {
		this.transDetails = transDetails;
	}
	public String getTransactionCode() {
		return transactionCode;
	}
	public void setTransactionCode(String transactionCode) {
		this.transactionCode = transactionCode;
	}
	public String getFamilyName() {
		return familyName;
	}
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	public String getGivenName() {
		return givenName;
	}
	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}
	public int getMiles() {
		return miles;
	}
	public void setMiles(int miles) {
		this.miles = miles;
	}
	public String getAwardDate() {
		return awardDate;
	}
	public void setAwardDate(String awardDate) {
		this.awardDate = awardDate;
	}
	public String getAwardEndDate() {
		return awardEndDate;
	}
	public void setAwardEndDate(String awardEndDate) {
		this.awardEndDate = awardEndDate;
	}
	public String getAwardDescription() {
		return awardDescription;
	}
	public void setAwardDescription(String awardDescription) {
		this.awardDescription = awardDescription;
	}
	public String getParticipantCode() {
		return participantCode;
	}
	public void setParticipantCode(String participantCode) {
		this.participantCode = participantCode;
	}
	public String getPropertyLocationCode() {
		return propertyLocationCode;
	}
	public void setPropertyLocationCode(String propertyLocationCode) {
		this.propertyLocationCode = propertyLocationCode;
	}
	public String getKfReferenceCode() {
		return kfReferenceCode;
	}
	public void setKfReferenceCode(String kfReferenceCode) {
		this.kfReferenceCode = kfReferenceCode;
	}
	public String getPromotionAwardDate() {
		return promotionAwardDate;
	}
	public void setPromotionAwardDate(String promotionAwardDate) {
		this.promotionAwardDate = promotionAwardDate;
	}
	public String getPromotionAwardDescription() {
		return promotionAwardDescription;
	}
	public void setPromotionAwardDescription(String promotionAwardDescription) {
		this.promotionAwardDescription = promotionAwardDescription;
	}
	public int getPromotionMileAwarded() {
		return promotionMileAwarded;
	}
	public void setPromotionMileAwarded(int promotionMileAwarded) {
		this.promotionMileAwarded = promotionMileAwarded;
	}
	public String getPromotionCode() {
		return promotionCode;
	}
	public void setPromotionCode(String promotionCode) {
		this.promotionCode = promotionCode;
	}
	public String getReversalFlag() {
		return reversalFlag;
	}
	public void setReversalFlag(String reversalFlag) {
		this.reversalFlag = reversalFlag;
	}
	public String getAmendmentCode() {
		return amendmentCode;
	}
	public void setAmendmentCode(String amendmentCode) {
		this.amendmentCode = amendmentCode;
	}
	public String getPartnerTransactionCode() {
		return partnerTransactionCode;
	}
	public void setPartnerTransactionCode(String partnerTransactionCode) {
		this.partnerTransactionCode = partnerTransactionCode;
	}
	
	
	@Override
	public String toString() {
		
		return "MBBKrisFlyerAccrualReqBean [requestorProfile={"+(requestorProfile!=null?requestorProfile.toString():"")+"},"
				+ "partnerProfile={"+(partnerProfile!=null?partnerProfile.toString():"")+"},"
				+ "transDetails={"+(transDetails!=null?transDetails.toString():"")+"},"
				+ "transactionCode="+transactionCode+","
				+ "familyName="+familyName+",givenName="+givenName+","
				
				+ "miles="+Integer.valueOf(miles)+",awardDate="+awardDate+","
				+ "awardEndDate="+awardEndDate+",awardDescription="+awardDescription+","
				+ "participantCode="+participantCode+",propertyLocationCode="+propertyLocationCode+","
				
				+ "kfReferenceCode="+kfReferenceCode+",promotionAwardDate="+promotionAwardDate+","
				+ "promotionAwardDescription="+promotionAwardDescription+",promotionMileAwarded="+Integer.valueOf(promotionMileAwarded)+","
				+ "promotionCode="+promotionCode+",reversalFlag="+reversalFlag+","
				
				+ "kfReferenceCode="+kfReferenceCode+",promotionAwardDate="+promotionAwardDate+","
				+ "promotionAwardDescription="+promotionAwardDescription+",promotionMileAwarded="+Integer.valueOf(promotionMileAwarded)+","
				+ "promotionCode="+promotionCode+",reversalFlag="+reversalFlag+","
				
				+ "amendmentCode="+amendmentCode+",partnerTransactionCode="+partnerTransactionCode
				
				+"]";
				
	}
	
}
