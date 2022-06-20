package com.example.bookshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookshop.entity.Publisher;
import com.example.bookshop.entity.Role;
import com.example.bookshop.myfunction.AppConstants;
import com.example.bookshop.service.impl.RoleImpl;

@RestController
@RequestMapping("/role")
public class RoleController {
	
	@Autowired
	RoleImpl roleImpl;
	
	@GetMapping("/get")
	public List<Role> getAll(
			@RequestParam(defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
			@RequestParam(defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
			@RequestParam(defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
			@RequestParam(defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir) {
		return roleImpl.getRoles(pageNo, pageSize, sortBy, sortDir);
	}

	@GetMapping("/findById")
	public Role getById(@RequestParam Long id) {
		return roleImpl.getRoleById(id);
	}

	@GetMapping("/findByName")
	public List<Role> getByName(@RequestParam String name) {
		return roleImpl.getRoleByName(name);
	}

	@PostMapping("/add")
	public Role addRole(@RequestBody Role role) {
		return roleImpl.addRole(role);
	}

	@PutMapping("/update")
	public Role updateRole(@RequestBody Role role) {
		return roleImpl.updateRole(role);
	}

	@DeleteMapping("/delete")
	public void deleteRole(@RequestParam Long id) {
		roleImpl.deleteRole(id);
	}

}
