package com.example.bookshop.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.bookshop.entity.Publisher;
import com.example.bookshop.myfunction.GetDateNow;
import com.example.bookshop.repository.PublisherRepository;
import com.example.bookshop.service.PublisherService;

@Service
public class PublisherImpl implements PublisherService {
	@Autowired
	PublisherRepository publisherRepository;

	@Override
	public List<Publisher> getPublishers(int pageNo, int pageSize, String sortBy, String sortDir) {
		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
				: Sort.by(sortBy).descending();
		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
		Page<Publisher> publisher = publisherRepository.findAll(pageable);
		List<Publisher> publishes = new ArrayList<>();
		publishes = publisher.getContent();
		return publishes;
	}

	@Override
	public Publisher getPublisherById(Long id) {
		return publisherRepository.findById(id).get();
	}

	@Override
	public List<Publisher> getPublisherByName(String name) {
		return publisherRepository.searchPublisherByName(name);
	}

	@Override
	public Publisher addPublisher(Publisher publisher) {
		publisher.setCreatedDate(GetDateNow.getDate());
		publisher.setUpdatedDate("undefined");
		return publisherRepository.save(publisher);
	}

	@Override
	public Publisher updatePublisher(Publisher publisher) {
		Publisher exPublisher = publisherRepository.findById(publisher.getId()).orElse(null);
		exPublisher.setUpdatedDate(GetDateNow.getDate());
		exPublisher.setName(publisher.getName());
		exPublisher.setAddress(publisher.getAddress());
		exPublisher.setStatus(publisher.isStatus());
		return publisherRepository.save(exPublisher);
	}

	@Override
	public void deletePublisher(Long id) {
		publisherRepository.deleteById(id);

	}

}
