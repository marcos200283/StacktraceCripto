package com.evalu.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evalu.persistence.entity.Currency;
@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long>{

}
