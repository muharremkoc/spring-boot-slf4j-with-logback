package com.example.springbootslf4jwithlogback.repository;


import com.example.springbootslf4jwithlogback.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
}
