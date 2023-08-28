package com.evalu.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evalu.persistence.entity.User;
import com.evalu.persistence.entity.Wallet;
import com.evalu.service.UserService;
import com.evalu.service.WalletService;
import com.evalu.service.dto.WalletCurrencyInDto;
import com.evalu.service.dto.ExchangeInDto;
import com.evalu.service.dto.QuantityShowDto;
import com.evalu.service.dto.WalletInDto;

 

@RestController
@RequestMapping("/wallets")
public class WalletController {
	private final WalletService walletService;
	private final UserService userService;
	
	public WalletController(WalletService walletService,UserService userService){
		this.walletService=walletService;
		this.userService=userService;
	}
	
	@PostMapping
	public  Wallet createWallet(@RequestBody WalletInDto walletInDto) {
		User user= this.userService.findById(walletInDto.getUserId());
		return this.walletService.createWallet(walletInDto,user);
	}
	
	@GetMapping
	public List<Wallet> findAll(){
		return this.walletService.findAll();
	}
	
	@GetMapping("/{walletId}")
	public Wallet findById(@PathVariable("walletId") Long walletId){
		return this.walletService.findById(walletId);
	}
	
	@DeleteMapping("/delete/{walletId}")
	public ResponseEntity<Void> deleteById(@PathVariable("walletId") Long walletId){
		this.walletService.deleteById(walletId);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value="update/")
	public ResponseEntity<Void> updateWallet(@RequestBody Wallet wallet) {
		this.walletService.updateById(wallet);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping("/deposit/")
	public ResponseEntity<Void> deposit(@RequestBody WalletCurrencyInDto walletCurrencyInDto) {
		this.walletService.Deposit(walletCurrencyInDto);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping("/exchange/")
	public ResponseEntity<Void> exchange(@RequestBody ExchangeInDto exchangeInDto) {
		this.walletService.Exchange(exchangeInDto);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/quantityPesos/{walletId}")
	public QuantityShowDto getQuantityInPesos(@PathVariable("walletId") Long walletId){
		return this.walletService.getQuantityInPesos(walletId);
	}
}
