package com.example.bookshop.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.bookshop.entity.Blog;

public interface BlogService {
	List<Blog> getBlogs(int pageNo, int pageSize, String sortBy, String sortDir)throws Exception;

	Blog getBlogById(Long id);

	List<Blog> getBlogByTitle(String title);

	Blog addBlog(Blog blog, MultipartFile multipartFile)throws Exception;

	Blog updateBlog(Blog blog, MultipartFile multipartFile);

	void deleteBlog(Long id);
}
