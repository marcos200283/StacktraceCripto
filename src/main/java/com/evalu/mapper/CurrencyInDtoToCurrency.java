package com.evalu.mapper;

import java.util.HashSet;

import org.springframework.stereotype.Component;

import com.evalu.persistence.entity.Currency;
import com.evalu.service.dto.CurrencyInDto;

@Component
public class CurrencyInDtoToCurrency implements IMapper<CurrencyInDto, Currency>{

	@Override
	public Currency map(CurrencyInDto in) {
		// TODO Auto-generated method stub
		Currency currency= new Currency((long) 0,in.getName(),in.getValueInPesos(),new HashSet<>());
		return currency;
	}

}
