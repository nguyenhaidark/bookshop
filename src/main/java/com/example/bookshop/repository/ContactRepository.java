package com.example.bookshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bookshop.entity.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long>{

}
