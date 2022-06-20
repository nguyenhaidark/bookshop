package com.example.bookshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.bookshop.entity.User;
@Service
public interface UserService {
	List<User> getUsers();
	User saveUser(User user);
}
