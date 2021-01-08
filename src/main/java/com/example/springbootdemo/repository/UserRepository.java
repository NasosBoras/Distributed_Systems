package com.example.springbootdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.springbootdemo.entity.User;

@RepositoryRestResource(path = "users")
public interface UserRepository extends JpaRepository<User,Integer>{

}
