package com.evalu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.evalu.exception.EvaluException;
import com.evalu.mapper.UserInDtoToUser;
import com.evalu.persistence.entity.User;
import com.evalu.persistence.repository.UserRepository;
import com.evalu.persistence.repository.WalletRepository;
import com.evalu.service.dto.QuantityShowDto;
import com.evalu.service.dto.UserInDto;

@Service
public class UserService {
	private final UserRepository repository;
	private final UserInDtoToUser mapper;
	private final WalletService walletService;
	public UserService(UserRepository repository,UserInDtoToUser mapper,WalletService walletService) {
		this.repository=repository;
		this.mapper=mapper;
		this.walletService=walletService;
	}
	
	public User createUser(UserInDto userInDto) {
		User user=mapper.map(userInDto);
		return this.repository.save(user);
	}
	
	public List<User> findAll(){
		return this.repository.findAll();
	}
	
	public User findById(Long id){
		Optional<User> optionalUser =this.repository.findById(id);
		if(optionalUser.isEmpty()) {
			throw new EvaluException("User not found", HttpStatus.NOT_FOUND); 
		}
		return optionalUser.get();
	}
	
	public void deleteById(Long id){
		Optional<User> optionalUser =this.repository.findById(id);
		if(optionalUser.isEmpty()) {
			throw new EvaluException("User not found", HttpStatus.NOT_FOUND); 
		}
		this.repository.deleteById(id);
	}
	
	public void updateById(User user){
		Optional<User> optionalUser =this.repository.findById(user.getId());
		if(optionalUser.isEmpty()) {
			throw new EvaluException("User not found", HttpStatus.NOT_FOUND); 
		}
		this.repository.save(user);  
	}
	 
	public QuantityShowDto getQuantityInPesos(Long id){
		Optional<User> optionalUser =this.repository.findById(id);
		if(optionalUser.isEmpty()) {
			throw new EvaluException("User not found", HttpStatus.NOT_FOUND); 
		}
		User user=optionalUser.get();
		
		return this.walletService.findbyUserPesos(user);
	}
}
