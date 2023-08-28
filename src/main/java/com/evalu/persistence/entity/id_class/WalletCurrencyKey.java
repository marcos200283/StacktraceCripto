package com.evalu.persistence.entity.id_class;

import java.io.Serializable;
import java.util.Objects;

import com.evalu.persistence.entity.Currency;
import com.evalu.persistence.entity.Wallet;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class WalletCurrencyKey implements Serializable{
	private Currency currency;
	private Wallet wallet;
	
	public WalletCurrencyKey() {
		
	}
	public WalletCurrencyKey(Currency currency, Wallet wallet) {
		this.currency = currency;
		this.wallet = wallet;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;
		
		WalletCurrencyKey that = (WalletCurrencyKey) o;
		
		if(!Objects.equals(currency ,that.currency)) return false;
		return Objects.equals(wallet ,that.wallet);
	}
	
	@Override
	public int hashCode() {
		int result = Objects.hash(currency);
		result = 31 * result * Objects.hash(wallet);
		return result;
	}
	
	@Override 
	public String toString(){
		return "WalletCurrencyKey{currency="+currency+", wallet="+wallet+"}";
	}
	
	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}
	
}
