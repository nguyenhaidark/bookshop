package com.example.bookshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.bookshop.entity.Blog;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
	@Query("select b from Blog b where b.title like %:title%")
	List<Blog> searchBlogByTitle(String title);
}
