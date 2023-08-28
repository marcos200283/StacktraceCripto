package com.evalu.service.dto;

import lombok.Data;
@Data
public class WalletCurrencyInDto {
	private Long walletId;
	private Long currencyId;
	private float quantity;
	
	public WalletCurrencyInDto() {
		
	}

	public WalletCurrencyInDto(Long walletId, Long currencyId, float quantity) {
		super();
		this.walletId = walletId;
		this.currencyId = currencyId;
		this.quantity = quantity;
	}

	public Long getWalletId() {
		return walletId;
	}

	public void setWalletId(Long walletId) {
		this.walletId = walletId;
	}

	public Long getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(Long currencyId) {
		this.currencyId = currencyId;
	}

	public float getQuantity() {
		return quantity;
	}

	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}
	
	 
	
	 

}
