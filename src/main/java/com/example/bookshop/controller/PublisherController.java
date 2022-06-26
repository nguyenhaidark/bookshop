package com.example.bookshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookshop.entity.Publisher;
import com.example.bookshop.myfunction.AppConstants;
import com.example.bookshop.service.impl.PublisherImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/publisher")
public class PublisherController {
	@Autowired
	PublisherImpl publisherImpl;

	@GetMapping("/get")
	public List<Publisher> getAll(
			@RequestParam(defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
			@RequestParam(defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
			@RequestParam(defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
			@RequestParam(defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir) {
		return publisherImpl.getPublishers(pageNo, pageSize, sortBy, sortDir);
	}

	@GetMapping("/findById")
	public Publisher getById(@RequestParam Long id) {
		return publisherImpl.getPublisherById(id);
	}

	@GetMapping("/findByName")
	public List<Publisher> getByName(@RequestParam String name) {
		return publisherImpl.getPublisherByName(name);
	}

	@PostMapping("/add")
	public Publisher addPublisher(@RequestBody Publisher publisher) {
		return publisherImpl.addPublisher(publisher);
	}

	@PutMapping("/update")
	public Publisher updatePublisher(@RequestBody Publisher publisher) {
		return publisherImpl.updatePublisher(publisher);
	}

	@DeleteMapping("/delete")
	public void deletePublisher(@RequestParam Long id) {
		publisherImpl.deletePublisher(id);
	}
}
