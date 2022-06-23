package com.example.bookshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookshop.entity.User;
import com.example.bookshop.myfunction.AppConstants;
import com.example.bookshop.service.impl.UserImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserImpl userImpl;

	@GetMapping("/get")
	public List<User> getAll(
			@RequestParam(defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
			@RequestParam(defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
			@RequestParam(defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
			@RequestParam(defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir) {
		return userImpl.getUsers(pageNo, pageSize, sortBy, sortDir);
	}

	@GetMapping("/findById")
	public User getById(@RequestParam Long id) {
		return userImpl.getUserById(id);
	}

	@GetMapping("/findByName")
	public List<User> getByName(@RequestParam String name) {
		return userImpl.getUserByName(name);
	}

	@PutMapping("/update")
	public User updateUser(@RequestBody User user) {
		return userImpl.updateUser(user);
	}

	@DeleteMapping("/delete")
	public void deleteUser(@RequestParam Long id) {
		userImpl.deleteUser(id);
	}
}
