package com.evalu.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
import com.evalu.persistence.entity.Wallet;
import java.util.List;
import com.evalu.persistence.entity.User;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long>{
	public List<Wallet> findByUser(User user);
}
