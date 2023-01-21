package com.blogApp1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogApp1.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
