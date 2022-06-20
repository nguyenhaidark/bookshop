package com.example.bookshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.bookshop.entity.Book;

@Service
@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

}
