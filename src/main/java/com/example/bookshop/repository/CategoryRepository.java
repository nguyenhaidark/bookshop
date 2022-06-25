package com.example.bookshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.bookshop.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	Category findByName(String name);

	@Query("select c from Category c where c.name like %:name%")
	List<Category> searchCategoryByName(String name);
}
