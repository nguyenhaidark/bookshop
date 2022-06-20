package com.example.bookshop.service;

import java.util.List;


import com.example.bookshop.entity.Publisher;

public interface PublisherService {
	List<Publisher> getPublishers(int pageNo, int pageSize, String sortBy, String sortDir);

	Publisher getPublisherById(Long id);

	List<Publisher> getPublisherByName(String name);

	Publisher addPublisher(Publisher publisher);

	Publisher updatePublisher(Publisher publisher);

	void deletePublisher(Long id);
}
