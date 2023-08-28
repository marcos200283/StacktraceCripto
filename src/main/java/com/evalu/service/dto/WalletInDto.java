package com.evalu.service.dto;

import lombok.Data;
@Data
public class WalletInDto {
	private Long userId;
	
	public WalletInDto() {
		
	}
	
	public WalletInDto(Long userId) {
		super();
		this.userId = userId;
	}
 
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	
	 

}
