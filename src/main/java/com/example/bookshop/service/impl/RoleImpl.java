package com.example.bookshop.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.bookshop.entity.Role;
import com.example.bookshop.myfunction.GetDateNow;
import com.example.bookshop.repository.RoleRepository;
import com.example.bookshop.service.RoleService;

@Service
public class RoleImpl implements RoleService{
	
	@Autowired
	RoleRepository roleRepository;

	@Override
	public List<Role> getRoles(int pageNo, int pageSize, String sortBy, String sortDir) {
		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
				: Sort.by(sortBy).descending();
		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
		Page<Role> role = roleRepository.findAll(pageable);
		List<Role> roles = new ArrayList<>();
		roles = role.getContent();
		return roles;
	}

	@Override
	public Role getRoleById(Long id) {
		return roleRepository.findById(id).get();
	}

	@Override
	public List<Role> getRoleByName(String name) {
		return roleRepository.searchRoleByName(name);
	}

	@Override
	public Role addRole(Role role) {
		role.setCreatedDate(GetDateNow.getDate());
		role.setUpdatedDate("undefined");
		return roleRepository.save(role);
	}

	@Override
	public Role updateRole(Role role) {
		Role exRole = roleRepository.findById(role.getId()).orElse(null);
		exRole.setUpdatedDate(GetDateNow.getDate());
		exRole.setName(role.getName());
		exRole.setStatus(role.isStatus());
		return roleRepository.save(exRole);
	}

	@Override
	public void deleteRole(Long id) {
		roleRepository.deleteById(id);
		
	}

}
