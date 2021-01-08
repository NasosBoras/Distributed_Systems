package com.example.springbootdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springbootdemo.entity.FutureTeacher;

@Repository
public interface FutureTeacherRepository extends JpaRepository<FutureTeacher,Integer>{
	
	

}
