package com.evalu.mapper;

import java.util.HashSet;

import org.springframework.stereotype.Component;

import com.evalu.persistence.entity.User;
import com.evalu.persistence.entity.Wallet;
import com.evalu.service.dto.WalletInDto;

@Component
public class WalletInDtoToWallet implements IMapper<WalletInDto, Wallet>{

	@Override
	public Wallet map(WalletInDto in) {
		// TODO Auto-generated method stub
		User user= new User(in.getUserId(),"","","","","",new HashSet<>());
		Wallet wallet= new Wallet((long) 0,user,new HashSet<>());
		return wallet;
	}

}
