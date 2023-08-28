package com.evalu.service.dto;

import lombok.Data;

@Data
public class QuantityShowDto {
	private Long id;
	private float quantityInPesos;
	 
	public QuantityShowDto(Long id, float quantityInPesos) {
		super();
		this.id = id;
		this.quantityInPesos = quantityInPesos;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public float getQuantityInPesos() {
		return quantityInPesos;
	}
	public void setQuantityInPesos(float quantityInPesos) {
		this.quantityInPesos = quantityInPesos;
	}
	
	 

}
