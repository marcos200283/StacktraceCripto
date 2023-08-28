package com.evalu.persistence.entity;

import java.time.LocalDateTime;

import com.evalu.persistence.enums.OperationType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
@JsonIgnoreProperties("hibernateLazyInitializer")
public class OperationLog {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	 
	@ManyToOne
	@JsonIgnoreProperties("hibernateLazyInitializer")
	private Wallet walletOrigin;
	
	@ManyToOne
	@JsonIgnoreProperties("hibernateLazyInitializer")
	private Wallet walletDestination;
	
	@ManyToOne
	@JsonIgnoreProperties("hibernateLazyInitializer")
	private Currency currencyOrigin;
	
	@ManyToOne
	@JsonIgnoreProperties("hibernateLazyInitializer")
	private Currency currencyDestination;
	
	private LocalDateTime localDateTime;
	private OperationType operationType;
	private float quantity;
	
	public OperationLog() {}
	
	public OperationLog(Long id, Wallet walletOrigin, Wallet walletDestination, Currency currencyOrigin,
			Currency currencyDestination, LocalDateTime localDateTime, OperationType operationType,float quantity) {
		super();
		this.id = id;
		this.walletOrigin = walletOrigin;
		this.walletDestination = walletDestination;
		this.currencyOrigin = currencyOrigin;
		this.currencyDestination = currencyDestination;
		this.localDateTime = localDateTime;
		this.operationType = operationType;
		this.quantity=quantity;
	}

	public float getQuantity() {
		return quantity;
	}

	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Wallet getWalletOrigin() {
		return walletOrigin;
	}

	public void setWalletOrigin(Wallet walletOrigin) {
		this.walletOrigin = walletOrigin;
	}

	public Wallet getWalletDestination() {
		return walletDestination;
	}

	public void setWalletDestination(Wallet walletDestination) {
		this.walletDestination = walletDestination;
	}

	public Currency getCurrencyOrigin() {
		return currencyOrigin;
	}

	public void setCurrencyOrigin(Currency currencyOrigin) {
		this.currencyOrigin = currencyOrigin;
	}

	public Currency getCurrencyDestination() {
		return currencyDestination;
	}

	public void setCurrencyDestination(Currency currencyDestination) {
		this.currencyDestination = currencyDestination;
	}

	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}

	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}

	public OperationType getOperationType() {
		return operationType;
	}

	public void setOperationType(OperationType operationType) {
		this.operationType = operationType;
	}
	
	
	
}
