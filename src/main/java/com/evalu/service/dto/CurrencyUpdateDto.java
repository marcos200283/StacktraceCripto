package com.evalu.service.dto;

import lombok.Data;

@Data
public class CurrencyUpdateDto {
	private String name;
	private float valueInPesos;
	private Long id;
	public CurrencyUpdateDto(){
		
	}
	
	public CurrencyUpdateDto(String name, float valueInPesos,Long id) {
		super();
		this.name = name;
		this.valueInPesos = valueInPesos;
		this.id = id;
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
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
