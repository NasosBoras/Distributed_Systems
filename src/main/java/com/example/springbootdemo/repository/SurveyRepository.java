package com.example.springbootdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.springbootdemo.entity.Survey;

@RepositoryRestResource(path = "surveys")
public interface SurveyRepository extends JpaRepository<Survey,Integer>{

}
