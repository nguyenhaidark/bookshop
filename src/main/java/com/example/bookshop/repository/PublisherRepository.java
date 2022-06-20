package com.example.bookshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bookshop.entity.Publisher;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long>{

}
