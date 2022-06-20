package com.example.bookshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookshop.entity.User;
import com.example.bookshop.repository.UserRepository;
import com.example.bookshop.service.UserService;

@Service
public class UserImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	

}
