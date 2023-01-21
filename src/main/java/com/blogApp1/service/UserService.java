package com.blogApp1.service;

import java.util.List;

import com.blogApp1.payload.UserDto;

public interface UserService {
UserDto createNewUser(UserDto userDto);
UserDto updateUser(UserDto userDto, Integer userId);
UserDto getUserById(Integer userId);
 void deleteUserById(Integer userId);
 List<UserDto> getAllUser();


}
