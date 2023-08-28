package com.evalu.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evalu.persistence.entity.WalletCurrency;
import com.evalu.persistence.entity.id_class.WalletCurrencyKey;
import java.util.List;
import com.evalu.persistence.entity.Wallet;

@Repository
public interface WalletCurrencyRepository extends JpaRepository<WalletCurrency, WalletCurrencyKey>{
	public List<WalletCurrency> findByWallet(Wallet wallet);

}
