package com.example.bookshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.bookshop.entity.Publisher;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long>{
	@Query("select p from Publisher p where p.name like %:name%")
	List<Publisher> searchPublisherByName(String name);
}
