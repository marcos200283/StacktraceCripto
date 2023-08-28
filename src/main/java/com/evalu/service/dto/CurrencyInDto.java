package com.evalu.service.dto;

import lombok.Data;

@Data
public class CurrencyInDto {
	private String name;
	private float valueInPesos;
	
	public CurrencyInDto(){
		
	}
	
	public CurrencyInDto(String name, float valueInPesos) {
		super();
		this.name = name;
		this.valueInPesos = valueInPesos;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getValueInPesos() {
		return valueInPesos;
	}

	public void setValueInPesos(float valueInPesos) {
		this.valueInPesos = valueInPesos;
	}
	
}
