package com.evalu.mapper;

import java.util.HashSet;

import org.springframework.stereotype.Component;

import com.evalu.persistence.entity.Currency;
import com.evalu.service.dto.CurrencyUpdateDto;

@Component
public class CurrencyUpdateDtoToCurrency implements IMapper<CurrencyUpdateDto, Currency>{

	@Override
	public Currency map(CurrencyUpdateDto in) {
		// TODO Auto-generated method stub
		Currency currency= new Currency(in.getId(),in.getName(),in.getValueInPesos(),new HashSet<>());
		return currency;
	}

}
