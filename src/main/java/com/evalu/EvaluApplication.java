package com.evalu;

import java.util.HashSet;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.evalu.persistence.entity.Currency;
import com.evalu.persistence.entity.User;
import com.evalu.persistence.entity.Wallet;
import com.evalu.persistence.entity.WalletCurrency;
import com.evalu.persistence.repository.CurrencyRepository;
import com.evalu.persistence.repository.UserRepository;
import com.evalu.persistence.repository.WalletCurrencyRepository;
import com.evalu.persistence.repository.WalletRepository;

import lombok.AllArgsConstructor;

@SpringBootApplication
@AllArgsConstructor
public class EvaluApplication implements CommandLineRunner  {
	private final UserRepository userRepository;	
	private final WalletRepository walletRepository;
	private final CurrencyRepository currencyRepository;
	private final WalletCurrencyRepository walletCurrencyRepository;
	public EvaluApplication(UserRepository userRepository,WalletRepository walletRepository,CurrencyRepository currencyRepository,WalletCurrencyRepository walletCurrencyRepository) {
		super();
		this.userRepository = userRepository;
		this.walletRepository = walletRepository;
		this.currencyRepository = currencyRepository;
		this.walletCurrencyRepository = walletCurrencyRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(EvaluApplication.class, args);
		System.out.print("Ingresar en Swagger por este link \n http://localhost:8080/swagger-ui/index.html#/");
         
		
	}
	
	  @Override
	  public void run(String... arg0) throws Exception {
		  User user1=this.userRepository.save(new User((long)0,"usuario1","apellido1","dni1","email1","telefono1",new HashSet<>()));
		  User user2=this.userRepository.save(new User((long)0,"usuario2","apellido2","dni2","email2","telefono2",new HashSet<>()));
		  User user3=this.userRepository.save(new User((long)0,"usuario3","apellido3","dni3","email3","telefono3",new HashSet<>()));
		  User user4=this.userRepository.save(new User((long)0,"usuario4","apellido4","dni4","email4","telefono4",new HashSet<>()));
		  
		  Wallet wallet1=this.walletRepository.save(new Wallet((long)0,user1,new HashSet<>()));
	      Wallet wallet2=this.walletRepository.save(new Wallet((long)0,user1,new HashSet<>()));
		  Wallet wallet3=this.walletRepository.save(new Wallet((long)0,user2,new HashSet<>()));		  
		  Wallet wallet4=this.walletRepository.save(new Wallet((long)0,user2,new HashSet<>()));
		  Wallet wallet5=this.walletRepository.save(new Wallet((long)0,user3,new HashSet<>()));		  
		  Wallet wallet6=this.walletRepository.save(new Wallet((long)0,user4,new HashSet<>()));
 
		  Currency currency1=this.currencyRepository.save(new Currency((long)0,"Peso",1,new HashSet<>()));
		  Currency currency2=this.currencyRepository.save(new Currency((long)0,"BTC",100,new HashSet<>()));
		  Currency currency3=this.currencyRepository.save(new Currency((long)0,"ETH",20,new HashSet<>()));
		  
		  this.walletCurrencyRepository.save(new WalletCurrency(wallet1,currency1,100));
		  this.walletCurrencyRepository.save(new WalletCurrency(wallet1,currency2,5));
		  this.walletCurrencyRepository.save(new WalletCurrency(wallet1,currency3,10));
		  
		  this.walletCurrencyRepository.save(new WalletCurrency(wallet2,currency1,150));
		  this.walletCurrencyRepository.save(new WalletCurrency(wallet2,currency2,2));
	      
		  this.walletCurrencyRepository.save(new WalletCurrency(wallet3,currency1,100));
		  this.walletCurrencyRepository.save(new WalletCurrency(wallet4,currency2,15));
		  this.walletCurrencyRepository.save(new WalletCurrency(wallet5,currency3,50));
		  this.walletCurrencyRepository.save(new WalletCurrency(wallet6,currency3,30));
		  
	  }

}
