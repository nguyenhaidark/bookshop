package com.example.bookshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookshop.repository.RoleRepository;
import com.example.bookshop.service.RoleService;

@Service
public class RoleImpl implements RoleService {

	@Autowired
	RoleRepository roleRepository;

}
