package com.evalu.persistence.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table (name="wallets")
public class Wallet {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne
	private User user;
	 
	//idClass
	@OneToMany(mappedBy = "wallet", cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<WalletCurrency> walletCurrency;
	
	public Wallet() {
    }
	
	public Set<WalletCurrency> getWalletCurrency() {
		return walletCurrency;
	}

	public void setWalletCurrency(Set<WalletCurrency> walletCurrency) {
		this.walletCurrency = walletCurrency;
	}

	public Wallet(Long id, User user, Set<WalletCurrency> walletCurrency) {
		super();
		this.id = id;
		this.user = user;
		this.walletCurrency = walletCurrency;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
