package com.evalu.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evalu.persistence.entity.User;
import com.evalu.service.UserService;
import com.evalu.service.dto.QuantityShowDto;
import com.evalu.service.dto.UserInDto;
 

@RestController
@RequestMapping("/users")
public class UserController {
	private final UserService userService;
	
	public UserController(UserService userService){
		this.userService=userService;
	}
	
	@PostMapping
	public User createUser(@RequestBody UserInDto userInDto) {
		return this.userService.createUser(userInDto);
	}
	
	@GetMapping
	public List<User> findAll(){
		return this.userService.findAll();
	}
	
	@GetMapping("/{userId}")
	public User findById(@PathVariable("userId") Long userId){
		return this.userService.findById(userId);
	}
	
	@PutMapping(value="update/")
	public ResponseEntity<Void> updateUser(@RequestBody User user) {
		this.userService.updateById(user);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<Void> deleteById(@PathVariable("userId") Long userId){
		this.userService.deleteById(userId);
		return ResponseEntity.noContent().build();
	}
	 
	@GetMapping("/quantityPesos/{userId}")
	public QuantityShowDto getQuantityInPesos(@PathVariable("userId") Long userId){
		return this.userService.getQuantityInPesos(userId);
	}
}
