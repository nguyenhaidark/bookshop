package com.example.bookshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookshop.entity.User;
import com.example.bookshop.service.impl.UserImpl;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserImpl userImpl;

	@GetMapping("/get")
	public List<User> getAll() {
		return userImpl.getUsers();
	}

}
