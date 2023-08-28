package com.evalu.persistence.entity;
 
import com.evalu.persistence.entity.id_class.WalletCurrencyKey;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
@IdClass(WalletCurrencyKey.class)
public class WalletCurrency {
	@Id
	@ManyToOne(fetch=FetchType.LAZY)
	private Wallet wallet;
	
	@Id
	@ManyToOne(fetch=FetchType.LAZY)
	private Currency currency;
	
	@Column(name="quantity")
	private float quantity;
	
	public WalletCurrency() {
		
	}

	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public float getQuantity() {
		return quantity;
	}

	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}

	public WalletCurrency(Wallet wallet, Currency currency, float quantity) {
		super();
		this.wallet = wallet;
		this.currency = currency;
		this.quantity = quantity;
	}
	
	

}
