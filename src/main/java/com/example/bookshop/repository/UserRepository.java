package com.example.bookshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bookshop.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
