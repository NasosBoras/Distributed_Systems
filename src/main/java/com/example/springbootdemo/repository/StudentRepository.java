package com.example.springbootdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.springbootdemo.entity.Student;

@RepositoryRestResource(path = "users")
public interface StudentRepository extends JpaRepository<Student,Integer>{

}
