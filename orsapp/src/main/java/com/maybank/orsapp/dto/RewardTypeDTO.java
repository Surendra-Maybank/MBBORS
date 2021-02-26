package com.maybank.orsapp.dto;

public class RewardTypeDTO {

	private int reward_type_id; 
	private String reward_type_code;
	private String reward_type_desc;
	
	public RewardTypeDTO() {}
	
	public RewardTypeDTO(int reward_type_id,
				String reward_type_code,
				String reward_type_desc) {
		this.reward_type_id=reward_type_id;
		this.reward_type_desc=reward_type_desc;
	}
	
	public int getReward_type_id() {
		return reward_type_id;
	}
	public void setReward_type_id(int reward_type_id) {
		this.reward_type_id = reward_type_id;
	}
	public String getReward_type_desc() {
		return reward_type_desc;
	}
	public void setReward_type_desc(String reward_type_desc) {
		this.reward_type_desc = reward_type_desc;
	}

	public String getReward_type_code() {
		return reward_type_code;
	}

	public void setReward_type_code(String reward_type_code) {
		this.reward_type_code = reward_type_code;
	}
	
}
