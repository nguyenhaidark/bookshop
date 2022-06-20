package com.example.bookshop.service;

import java.util.List;

import com.example.bookshop.entity.Role;

public interface RoleService {
	List<Role> getRoles(int pageNo, int pageSize, String sortBy, String sortDir);

	Role getRoleById(Long id);

	List<Role> getRoleByName(String name);

	Role addRole(Role role);

	Role updateRole(Role role);

	void deleteRole(Long id);
}
