package com.example.bookshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.bookshop.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
	Book findByName(String name);
	
	@Query("select b from Book b where b.name like %:name%")
	List<Book> searchBookByName(String name);
}
