package com.example.bookshop.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.bookshop.entity.Author;
import com.example.bookshop.myfunction.GetDateNow;
import com.example.bookshop.repository.AuthorRepository;
import com.example.bookshop.service.AuthorService;

@Service
public class AuthorImpl implements AuthorService{
	
	@Autowired
	AuthorRepository authorRepository;

	@Override
	public List<Author> getAuthors(int pageNo, int pageSize, String sortBy, String sortDir) {
		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
				: Sort.by(sortBy).descending();
		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
		Page<Author> author = authorRepository.findAll(pageable);
		List<Author> authors = new ArrayList<>();
		authors = author.getContent();
		return authors;
	}

	@Override
	public Author getAuthorById(Long id) {
		return authorRepository.findById(id).get();
	}

	@Override
	public List<Author> getAuthorByName(String name) {
		return authorRepository.searchAuthorByName(name);
	}

	@Override
	public Author addAuthor(Author author) {
		author.setCreatedDate(GetDateNow.getDate());
		author.setUpdatedDate("undefined");
		return authorRepository.save(author);
	}

	@Override
	public Author updateAuthor(Author author) {
		Author exAuthor = authorRepository.findById(author.getId()).orElse(null);
		exAuthor.setUpdatedDate(GetDateNow.getDate());
		exAuthor.setName(author.getName());
		exAuthor.setStatus(author.isStatus());
		return authorRepository.save(exAuthor);
	}

	@Override
	public void deleteAuthor(Long id) {
		authorRepository.deleteById(id);
		
	}

}
