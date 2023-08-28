package com.evalu.mapper;

import java.util.HashSet;

import org.springframework.stereotype.Component;

import com.evalu.persistence.entity.Currency;
import com.evalu.persistence.entity.User;
import com.evalu.persistence.entity.Wallet;
import com.evalu.persistence.entity.WalletCurrency;
import com.evalu.service.dto.WalletCurrencyInDto;
@Component
public class WalletCurrencyInDtoToWalletCurrency implements IMapper<WalletCurrencyInDto, WalletCurrency>{

	@Override
	public WalletCurrency map(WalletCurrencyInDto in) {
		// TODO Auto-generated method stub
		Currency currency= new Currency(in.getCurrencyId(),"",0,new HashSet<>() );
		User user = new User((long) 0,"","","","","",new HashSet<>());
		Wallet wallet= new Wallet(in.getWalletId(),user,new HashSet<>());
		WalletCurrency walletCurrency = new WalletCurrency(wallet,currency,in.getQuantity());
		return walletCurrency;
	}

}
