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

import com.evalu.persistence.entity.Currency;
import com.evalu.service.CurrencyService;
import com.evalu.service.dto.CurrencyInDto;
import com.evalu.service.dto.CurrencyUpdateDto;
 

@RestController
@RequestMapping("/currencys")
public class CurrencyController {
	private final CurrencyService currencyService;
	
	public CurrencyController(CurrencyService currencyService){
		this.currencyService=currencyService;
	}
	
	@PostMapping
	public Currency createCurrency(@RequestBody CurrencyInDto currencyInDto) {
		return this.currencyService.createCurrency(currencyInDto);
	}
	
	@GetMapping
	public List<Currency> findAll(){
		return this.currencyService.findAll();
	}
	
	@GetMapping("/{currencyId}")
	public Currency findById(@PathVariable("currencyId") Long currencyId){
		return this.currencyService.findById(currencyId);
	}
	
	@PutMapping(value="update/")
	public ResponseEntity<Void> updateCurrency(@RequestBody CurrencyUpdateDto currencyUpdateDto) {
		this.currencyService.updateById(currencyUpdateDto);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/delete/{currencyId}")
	public ResponseEntity<Void> deleteById(@PathVariable("currencyId") Long currencyId){
		this.currencyService.deleteById(currencyId);
		return ResponseEntity.noContent().build();
	}
}
