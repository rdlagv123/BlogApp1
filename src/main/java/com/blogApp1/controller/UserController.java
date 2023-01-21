package com.blogApp1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogApp1.payload.UserDto;
import com.blogApp1.repository.UserRepo;
import com.blogApp1.service.UserService;
@RestController
@RequestMapping("/api/users")
public class UserController {
@Autowired
private UserService userService;
@PostMapping("/")
public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
	UserDto user = userService.createNewUser(userDto);
	return new ResponseEntity<UserDto>(user, HttpStatus.CREATED);
	
}
}
