package com.example.bookshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bookshop.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long>{

}
