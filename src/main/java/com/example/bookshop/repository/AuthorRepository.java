package com.example.bookshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.bookshop.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long>{
	Author findByName(String name);
	
	@Query("select a from Author a where a.name like %:name%")
	List<Author> searchAuthorByName(String name);
}
