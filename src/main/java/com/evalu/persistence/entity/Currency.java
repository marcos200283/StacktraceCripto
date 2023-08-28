package com.evalu.persistence.entity;
 
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table (name="currencys")
public class Currency {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private float valueInPesos;
	 
	//idClass
	@OneToMany(mappedBy = "currency", cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<WalletCurrency> walletCurrency;

	public Currency() {
		
	}
	
	public Currency(Long id, String name, float valueInPesos, Set<WalletCurrency> walletCurrency) {
		super();
		this.id = id;
		this.name = name;
		this.valueInPesos = valueInPesos;
		this.walletCurrency = walletCurrency;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Set<WalletCurrency> getWalletCurrency() {
		return walletCurrency;
	}

	public void setWalletCurrency(Set<WalletCurrency> walletCurrency) {
		this.walletCurrency = walletCurrency;
	}
	
 
	
	
}
