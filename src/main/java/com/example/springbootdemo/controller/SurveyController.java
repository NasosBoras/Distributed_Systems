package com.example.springbootdemo.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.springbootdemo.entity.Survey;
import com.example.springbootdemo.repository.SurveyRepository;

@RestController
public class SurveyController {
	
	@Autowired
	private SurveyRepository surveyRepository;

	
	@GetMapping("/surveys")
	public List<Survey> retrieveAllSurveys(){
		return surveyRepository.findAll();
	}
	
	@GetMapping("/surveys/{id}")
	public Survey retrieveSurvey(@PathVariable int id) {
		Optional<Survey> survey = surveyRepository.findById(id);
		return survey.get();
	}
	
	@DeleteMapping("/surveys/{id}")
	public ResponseEntity<Object> deleteSurvey(@RequestBody Survey survey){
		Survey savedSurvey = surveyRepository.save(survey);
		
		URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}")
				.buildAndExpand(savedSurvey.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@PostMapping("/surveys")
	public ResponseEntity<Object> createSurvey(@RequestBody Survey survey){
		Survey savedSurvey = surveyRepository.save(survey);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedSurvey.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping("/surveys/{id}")
	public ResponseEntity<Object> updateSurvey(@RequestBody Survey survey, @PathVariable int id){
		Optional<Survey> surveyOptional = surveyRepository.findById(id);
		
		if(!surveyOptional.isPresent()) 
			return ResponseEntity.notFound().build();
		survey.setId(id);
		
		surveyRepository.save(survey);
		
		return ResponseEntity.noContent().build();
	}
}
