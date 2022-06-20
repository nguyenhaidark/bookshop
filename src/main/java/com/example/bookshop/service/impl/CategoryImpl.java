package com.example.bookshop.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.bookshop.entity.Category;
import com.example.bookshop.myfunction.GetDateNow;
import com.example.bookshop.repository.CategoryRepository;
import com.example.bookshop.service.CategoryService;

@Service
public class CategoryImpl implements CategoryService{
	
	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public List<Category> getCategories(int pageNo, int pageSize, String sortBy, String sortDir) {
		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
				: Sort.by(sortBy).descending();
		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
		Page<Category> category = categoryRepository.findAll(pageable);
		List<Category> categories = new ArrayList<>();
		categories = category.getContent();
		return categories;
	}

	@Override
	public Category getCategoryById(Long id) {
		return categoryRepository.findById(id).get();
	}

	@Override
	public List<Category> getCategoryName(String name) {
		return categoryRepository.searchCategoryByName(name);
	}

	@Override
	public Category addCategory(Category category) {
		category.setCreatedDate(GetDateNow.getDate());
		category.setUpdatedDate("undefined");
		return categoryRepository.save(category);
	}

	@Override
	public Category updateCategory(Category category) {
		Category exCategory = categoryRepository.findById(category.getId()).orElse(null);
		exCategory.setUpdatedDate(GetDateNow.getDate());
		exCategory.setName(category.getName());
		exCategory.setStatus(category.isStatus());
		return categoryRepository.save(exCategory);
	}

	@Override
	public void deleteCategory(Long id) {
		categoryRepository.deleteById(id);
		
	}

}
