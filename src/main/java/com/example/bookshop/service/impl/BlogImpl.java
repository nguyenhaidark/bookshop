package com.example.bookshop.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.bookshop.entity.Blog;
import com.example.bookshop.myfunction.GetDateNow;
import com.example.bookshop.myfunction.Upload;
import com.example.bookshop.repository.BlogRepository;
import com.example.bookshop.service.BlogService;

@Service
public class BlogImpl implements BlogService {

	@Autowired
	BlogRepository blogRepository;

	@Override
	public List<Blog> getBlogs(int pageNo, int pageSize, String sortBy, String sortDir) {
		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
				: Sort.by(sortBy).descending();
		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
		Page<Blog> blog = blogRepository.findAll(pageable);
		List<Blog> blogs = new ArrayList<>();
		blogs = blog.getContent();
		return blogs;
	}

	@Override
	public Blog addBlog(Blog blog, MultipartFile multipartFile) throws Exception {
		blog.setCreatedDate(GetDateNow.getDate());
		blog.setUpdatedDate("undefined");
		blog.setFileName(Upload.UploadImage(multipartFile));
		return blogRepository.save(blog);
	}

	@Override
	public Blog updateBlog(Blog blog, MultipartFile multipartFile) {
		Blog exBlog = blogRepository.findById(blog.getId()).orElse(null);
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		exBlog.setUpdatedDate(GetDateNow.getDate());
		if (multipartFile.getOriginalFilename().length() > 2) {
			exBlog.setFileName(fileName);
		}
		exBlog.setUpdatedDate(GetDateNow.getDate());
		exBlog.setContent(blog.getContent());
		exBlog.setTitle(blog.getTitle());
		exBlog.setStatus(blog.isStatus());
		return blogRepository.save(exBlog);
	}

	@Override
	public void deleteBlog(Long id) {
		blogRepository.deleteById(id);
	}

	@Override
	public Blog getBlogById(Long id) {
		return blogRepository.findById(id).get();
	}

	@Override
	public List<Blog> getBlogByTitle(String title) {
		return blogRepository.searchBlogByTitle(title);
	}

}
