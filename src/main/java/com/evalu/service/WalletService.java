package com.evalu.service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.evalu.exception.EvaluException;
import com.evalu.mapper.WalletInDtoToWallet;
import com.evalu.persistence.entity.Currency;
import com.evalu.persistence.entity.User;
import com.evalu.persistence.entity.Wallet;
import com.evalu.persistence.entity.WalletCurrency;
import com.evalu.persistence.repository.WalletRepository;
import com.evalu.service.dto.WalletCurrencyInDto;
import com.evalu.service.dto.ExchangeInDto;
import com.evalu.service.dto.QuantityShowDto;
import com.evalu.service.dto.WalletInDto;

@Service
public class WalletService {
	private final WalletRepository repository;
	private final WalletInDtoToWallet mapper;
	private final WalletCurrencyService walletCurrencyService;
	private final CurrencyService currencyService;

	public WalletService(WalletRepository repository,WalletInDtoToWallet mapper,WalletCurrencyService walletCurrencyService,CurrencyService currencyService) {
		this.repository=repository;
		this.currencyService=currencyService;
		this.mapper=mapper;
		this.walletCurrencyService=walletCurrencyService;
		
	}
	
	public Wallet createWallet(WalletInDto walletInDto, User user) {
		Wallet wallet=mapper.map(walletInDto);
		wallet.setUser(user);
        return this.repository.save(wallet);
	}
	
	public List<Wallet> findAll(){
		return this.repository.findAll();
	}

	public Wallet findById(Long id){
		Optional<Wallet> optionalWallet =this.repository.findById(id);
		if(optionalWallet.isEmpty()) {
			throw new EvaluException("Wallet not found", HttpStatus.NOT_FOUND); 
		}
		return optionalWallet.get();
	}
	
	public QuantityShowDto getQuantityInPesos(Long id){
		Optional<Wallet> optionalWallet =this.repository.findById(id);
		if(optionalWallet.isEmpty()) {
			throw new EvaluException("Wallet not found", HttpStatus.NOT_FOUND); 
		}
		float result=this.walletCurrencyService.getAllbyWallet(optionalWallet.get());
		QuantityShowDto quantityShowDto= new QuantityShowDto(id,result);
		return quantityShowDto;
	}
	
	public void deleteById(Long id){
		Optional<Wallet> optionalWallet =this.repository.findById(id);
		if(optionalWallet.isEmpty()) {
			throw new EvaluException("Wallet not found", HttpStatus.NOT_FOUND); 
		}
		this.repository.deleteById(id);
	}
	
	public void updateById(Wallet wallet){
		Optional<Wallet> optionalWallet =this.repository.findById(wallet.getId());
		if(optionalWallet.isEmpty()) {
			throw new EvaluException("Wallet not found", HttpStatus.NOT_FOUND); 
		}
		this.repository.save(wallet);  
	}
	
	public QuantityShowDto findbyUserPesos(User user){
		List<Wallet> listWallet=this.repository.findByUser(user);
		Iterator<Wallet> it = listWallet.iterator();
	    float result=0;
		while(it.hasNext()){
			Wallet wallet=it.next();
			QuantityShowDto quantityShowDtoW =getQuantityInPesos(wallet.getId());
			result+=quantityShowDtoW.getQuantityInPesos();
		}
	 
		QuantityShowDto quantityShowDtoUser= new QuantityShowDto(user.getId(),result);
		return quantityShowDtoUser;
	}
	
	public WalletCurrency Deposit(WalletCurrencyInDto walletCurrencyInDto) {
		Wallet wallet= this.findById(walletCurrencyInDto.getWalletId());
		Currency currency= this.currencyService.findById(walletCurrencyInDto.getCurrencyId());
		return this.walletCurrencyService.Deposit(walletCurrencyInDto,currency,wallet);
	}
	
	public WalletCurrency Exchange(ExchangeInDto exchangeInDto) {
		Wallet walletOrigin= this.findById(exchangeInDto.getWalletIdOrigin());
		Currency currencyOrigin= this.currencyService.findById(exchangeInDto.getCurrencyIdOrigin());
		
		Wallet walletDestination= this.findById(exchangeInDto.getWalletIdDestination());
		Currency currencyDestination= this.currencyService.findById(exchangeInDto.getCurrencyIdDestination());

		return this.walletCurrencyService.exchange(exchangeInDto,currencyOrigin,walletOrigin,currencyDestination,walletDestination);
	}
}
