package com.evalu.service;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.evalu.exception.EvaluException;
import com.evalu.mapper.WalletCurrencyInDtoToWalletCurrency;
import com.evalu.persistence.entity.Currency;
import com.evalu.persistence.entity.OperationLog;
import com.evalu.persistence.entity.Wallet;
import com.evalu.persistence.entity.WalletCurrency;
import com.evalu.persistence.entity.id_class.WalletCurrencyKey;
import com.evalu.persistence.enums.OperationType;
import com.evalu.persistence.repository.WalletCurrencyRepository;
import com.evalu.service.dto.WalletCurrencyInDto;
import com.evalu.service.dto.ExchangeInDto;


@Service
public class WalletCurrencyService {
	private final WalletCurrencyRepository repository;
	private final WalletCurrencyInDtoToWalletCurrency mapper;
	private final OperationLogService operationLogService;
	public WalletCurrencyService(WalletCurrencyRepository repository,WalletCurrencyInDtoToWalletCurrency mapper,OperationLogService operationLogService,CurrencyService currencyService) {
		this.repository=repository;
		this.mapper=mapper;
		this.operationLogService=operationLogService;
	}
	
	public WalletCurrency getById(WalletCurrencyKey walletCurrencyKey){
		Optional<WalletCurrency> optionalWalletCurrency =this.repository.findById(walletCurrencyKey);
		if(optionalWalletCurrency.isEmpty()) {
			return null;
		}
		return optionalWalletCurrency.get();
	}
	
	public WalletCurrency Deposit(WalletCurrencyInDto walletCurrencyInDto,Currency currency,Wallet wallet){
		WalletCurrency walletCurrency=this.mapper.map(walletCurrencyInDto);
		WalletCurrencyKey walletCurrencyKey = new WalletCurrencyKey(currency,wallet);
		WalletCurrency walletCurrencyDB=getById(walletCurrencyKey);
		if(walletCurrencyDB != null) {
			walletCurrency.setQuantity(walletCurrency.getQuantity()+walletCurrencyDB.getQuantity());
		}
		walletCurrency.setCurrency(currency);
		walletCurrency.setWallet(wallet);
		
		walletCurrency = this.repository.save(walletCurrency);

		OperationLog operationLog= new OperationLog((long)0,null,wallet,null,currency,LocalDateTime.now(),OperationType.DEPOSIT,walletCurrencyInDto.getQuantity()); 
		this.operationLogService.depositLog(operationLog);
		
		return walletCurrency;
	}
	
	public WalletCurrency exchange(ExchangeInDto exchangeInDto,Currency currencyOrigin,Wallet walletOrigin,Currency currencyDestination,Wallet walletDestination){
	
		WalletCurrencyKey walletCurrencyKeyOrigin = new WalletCurrencyKey(currencyOrigin,walletOrigin);
		WalletCurrency walletCurrencyOrigin=new WalletCurrency(walletOrigin,currencyOrigin,0);
		
		WalletCurrency walletCurrencyDBOrigin=getById(walletCurrencyKeyOrigin);
		
		float valuePesoOrigin=currencyOrigin.getValueInPesos()*exchangeInDto.getQuantityOrigin();
		
		if(walletCurrencyDBOrigin != null) {
			walletCurrencyOrigin=walletCurrencyDBOrigin;
			walletCurrencyOrigin.setQuantity(walletCurrencyDBOrigin.getQuantity()-exchangeInDto.getQuantityOrigin());
		}else {
			throw new EvaluException("Not have enough money in the currency "+currencyOrigin.getName(), HttpStatus.NOT_FOUND); 
		}

		///////////////////
		WalletCurrency walletCurrencyDestination=new WalletCurrency(walletDestination,currencyDestination,0);
		WalletCurrencyKey walletCurrencyKeyDestination = new WalletCurrencyKey(currencyDestination,walletDestination);
		WalletCurrency walletCurrencyDBDestination=getById(walletCurrencyKeyDestination);
		float valuePesoDestination=0;
		float resultDestination=0;
		if(walletCurrencyDBDestination != null) {
			walletCurrencyDestination=walletCurrencyDBDestination;
		} 
		valuePesoDestination=currencyDestination.getValueInPesos()*walletCurrencyDestination.getQuantity();
		resultDestination=valuePesoDestination+valuePesoOrigin;
		walletCurrencyDestination.setQuantity(resultDestination/currencyDestination.getValueInPesos());
	 
		if(walletCurrencyDBOrigin.getQuantity()<0) {
			throw new EvaluException("Not have enough money in the currency "+currencyOrigin.getName(), HttpStatus.NOT_FOUND); 
		}
		
		this.repository.save(walletCurrencyOrigin);
		walletCurrencyDestination= this.repository.save(walletCurrencyDestination);
 
		
		OperationLog operationLog= new OperationLog((long)0,walletOrigin,walletDestination,currencyOrigin,currencyDestination,LocalDateTime.now(),OperationType.EXCHANGE,exchangeInDto.getQuantityOrigin()); 
		this.operationLogService.depositLog(operationLog);
		
		return walletCurrencyDestination;
	}
	
	public float getAllbyWallet(Wallet wallet) {
		List<WalletCurrency> listWalletCurrency=this.repository.findByWallet(wallet);
		Iterator<WalletCurrency> it = listWalletCurrency.iterator();
	    float result=0;
		while(it.hasNext()){
			WalletCurrency walletCurrency=it.next();
			result +=(walletCurrency.getCurrency().getValueInPesos()*walletCurrency.getQuantity());
		}
		return result;
	}
	
}
