package com.evalu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.evalu.exception.EvaluException;
import com.evalu.mapper.CurrencyInDtoToCurrency;
import com.evalu.mapper.CurrencyUpdateDtoToCurrency;
import com.evalu.persistence.entity.Currency;
import com.evalu.persistence.repository.CurrencyRepository;
import com.evalu.service.dto.CurrencyInDto;
import com.evalu.service.dto.CurrencyUpdateDto;

@Service
public class CurrencyService {
	private final CurrencyRepository repository;
	private final CurrencyInDtoToCurrency mapper;
	private final CurrencyUpdateDtoToCurrency mapperUpdate;
	
	public CurrencyService(CurrencyRepository repository,CurrencyInDtoToCurrency mapper,CurrencyUpdateDtoToCurrency mapperUpdate) {
		this.repository=repository;
		this.mapper=mapper;
		this.mapperUpdate=mapperUpdate;
	}
	
	public Currency createCurrency(CurrencyInDto currencyInDto) {
		Currency currency=mapper.map(currencyInDto);
		return this.repository.save(currency);
	}
	
	public List<Currency> findAll(){
		return this.repository.findAll();
	}
	
	public Currency findById(Long id){
		Optional<Currency> optionalCurrency =this.repository.findById(id);
		if(optionalCurrency.isEmpty()) {
			throw new EvaluException("Currency not found", HttpStatus.NOT_FOUND); 
		}
		return optionalCurrency.get();
	}
	
	public void deleteById(Long id){
		Optional<Currency> optionalCurrency =this.repository.findById(id);
		if(optionalCurrency.isEmpty()) {
			throw new EvaluException("Currency not found", HttpStatus.NOT_FOUND); 
		}
		this.repository.deleteById(id);
	}
	
	public void updateById(CurrencyUpdateDto currencyUpdateDto){
		Optional<Currency> optionalCurrency =this.repository.findById(currencyUpdateDto.getId());
		if(optionalCurrency.isEmpty()) {
			throw new EvaluException("Currency not found", HttpStatus.NOT_FOUND); 
		}
		Currency currency=mapperUpdate.map(currencyUpdateDto);
		this.repository.save(currency);  
	}
	
	
}
