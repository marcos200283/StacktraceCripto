package com.evalu.mapper;

import java.util.HashSet;

import org.springframework.stereotype.Component;

import com.evalu.persistence.entity.User;
import com.evalu.service.dto.UserInDto;

@Component
public class UserInDtoToUser implements IMapper<UserInDto, User>{

	@Override
	public User map(UserInDto in) {
		// TODO Auto-generated method stub
		User user= new User((long) 0,in.getNombre(),in.getApellido(),in.getDni(),in.getEmail(),in.getNombre(),new HashSet<>());
		return user;
	}

}
