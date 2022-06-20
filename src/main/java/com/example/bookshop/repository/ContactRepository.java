package com.example.bookshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.bookshop.entity.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long>{
	@Query("select c from Contact c where c.email like %:email%")
	List<Contact> searchContactByEmail(String email);
}
