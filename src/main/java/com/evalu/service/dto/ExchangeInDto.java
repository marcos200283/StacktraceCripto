package com.evalu.service.dto;

import lombok.Data;
@Data
public class ExchangeInDto {
	private Long walletIdOrigin;
	private Long currencyIdOrigin;
	private float quantityOrigin;
	private Long walletIdDestination;
	private Long currencyIdDestination;
	
	
	public ExchangeInDto() {
		
	}

	public Long getWalletIdOrigin() {
		return walletIdOrigin;
	}

	public void setWalletIdOrigin(Long walletIdOrigin) {
		this.walletIdOrigin = walletIdOrigin;
	}

	public Long getCurrencyIdOrigin() {
		return currencyIdOrigin;
	}

	public void setCurrencyIdOrigin(Long currencyIdOrigin) {
		this.currencyIdOrigin = currencyIdOrigin;
	}

	public Long getWalletIdDestination() {
		return walletIdDestination;
	}

	public void setWalletIdDestination(Long walletIdDestination) {
		this.walletIdDestination = walletIdDestination;
	}

	public Long getCurrencyIdDestination() {
		return currencyIdDestination;
	}

	public void setCurrencyIdDestination(Long currencyIdDestination) {
		this.currencyIdDestination = currencyIdDestination;
	}

	public float getQuantityOrigin() {
		return quantityOrigin;
	}

	public void setQuantityOrigin(float quantityOrigin) {
		this.quantityOrigin = quantityOrigin;
	}

	public ExchangeInDto(Long walletIdOrigin, Long currencyIdOrigin, Long walletIdDestination,
			Long currencyIdDestination, float quantityOrigin) {
		super();
		this.walletIdOrigin = walletIdOrigin;
		this.currencyIdOrigin = currencyIdOrigin;
		this.walletIdDestination = walletIdDestination;
		this.currencyIdDestination = currencyIdDestination;
		this.quantityOrigin = quantityOrigin;
	}

	 
}
