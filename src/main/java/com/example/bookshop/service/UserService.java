package com.example.bookshop.service;

import java.util.List;


import com.example.bookshop.entity.User;

public interface UserService {
	List<User> getUsers(int pageNo, int pageSize, String sortBy, String sortDir);

	User getUserById(Long id);

	List<User> getUserByName(String name);

	User updateUser(User user);

	void deleteUser(Long id);
}
