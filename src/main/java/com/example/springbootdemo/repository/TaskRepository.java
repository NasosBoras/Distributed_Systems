package com.example.springbootdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.springbootdemo.entity.Task;

@RepositoryRestResource(path = "tasks")
public interface TaskRepository extends JpaRepository<Task,Integer>{

}
