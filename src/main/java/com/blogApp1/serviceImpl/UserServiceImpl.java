package com.blogApp1.serviceImpl;

import com.blogApp1.entity.User;
import com.blogApp1.exception.*;

import com.blogApp1.payload.UserDto;
import com.blogApp1.repository.UserRepo;
import com.blogApp1.service.UserService;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.blogApp1.*;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {
@Autowired
UserRepo userRepo;
	@Override
	public UserDto createNewUser(UserDto userDto) {
		User user = this.dtoToUser(userDto);
		User savedUser = this.userRepo.save(user);
		return this.userToDto(savedUser);
		
		
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		
		  User user =userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","Id",userId));
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		User updateUser = userRepo.save(user);
		UserDto userToDto1 = userToDto(updateUser);
		return userToDto1;
		  
	}

	@Override
	public UserDto getUserById(Integer userId) {
		User user = userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","Id",userId));
		 
		return userToDto(user);
	}

	@Override
	public void deleteUserById(Integer userId) {
		userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","Id",userId));
		userRepo.deleteById(userId);

	}
	@Override
	public List<UserDto> getAllUser() {
		List<User> users = userRepo.findAll();
		List<UserDto> userDtos=users.stream().map(user->this.userToDto(users)).collect(Collectors.toList());
		return userDtos;
	}

	
	private User dtoToUser(UserDto userDto) {
		User user = new User();
		user.setId(userDto.getId());
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		return user;
		
	}
	private UserDto  userToDto(User user) {
		UserDto userDto= new UserDto();
		userDto.setId(user.getId());
		userDto.setName(user.getName());
		userDto.setEmail(user.getEmail());
		userDto.setPassword(user.getPassword());
		userDto.setAbout(user.getAbout());
		return userDto;
		
	}

	
}
