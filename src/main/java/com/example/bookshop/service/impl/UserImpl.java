package com.example.bookshop.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.bookshop.entity.User;
import com.example.bookshop.myfunction.GetDateNow;
import com.example.bookshop.repository.RoleRepository;
import com.example.bookshop.repository.UserRepository;
import com.example.bookshop.service.UserService;

@Service
public class UserImpl implements UserService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;

	@Override
	public List<User> getUsers(int pageNo, int pageSize, String sortBy, String sortDir) {
		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
				: Sort.by(sortBy).descending();
		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
		Page<User> user = userRepository.findAll(pageable);
		List<User> users = new ArrayList<>();
		users = user.getContent();
		return users;
	}

	@Override
	public User getUserById(Long id) {
		return userRepository.findById(id).get();
	}

	@Override
	public List<User> getUserByName(String name) {
		return userRepository.searchByUsername(name);
	}

	@Override
	public User updateUser(User user) {
		User exUser = userRepository.findById(user.getId()).orElse(null);
		exUser.setUpdatedDate(GetDateNow.getDate());
		exUser.setName(user.getName());
		exUser.setUsername(user.getUsername());
		exUser.setAddress(user.getAddress());
		exUser.setPhone(user.getPhone());
		exUser.setEmail(user.getEmail());
		exUser.setGender(user.isGender());
		exUser.setStatus(user.isStatus());
		return userRepository.save(exUser);
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

}
