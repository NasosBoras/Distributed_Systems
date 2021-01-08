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

import com.example.springbootdemo.entity.FutureTeacher;
import com.example.springbootdemo.repository.FutureTeacherRepository;

@RestController
public class FutureTeacherController {
	@Autowired
	private FutureTeacherRepository futureTeacherRepository;
	
	@GetMapping("/future_teachers")
	public List<FutureTeacher> retreiveAllTeaches(){
		return futureTeacherRepository.findAll();
	}
	
	@GetMapping("/future_teacher/{id}")
	public FutureTeacher retrieveTeacher(@PathVariable int id) {
		Optional<FutureTeacher> teacher = futureTeacherRepository.findById(id);
		return teacher.get();
	}
	
	@DeleteMapping("/future_teacher/{id}")
	public void deleteTeacher(@PathVariable int id) {
		futureTeacherRepository.deleteById(id);
	}
	
	@PostMapping("/teachers")
	public ResponseEntity<Object> createTeacher(@RequestBody FutureTeacher teacher){
		FutureTeacher savedTeacher = futureTeacherRepository.save(teacher);
		
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedTeacher.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping("/future_teachers/{id}")
	public ResponseEntity<Object> updateTeacher(@RequestBody FutureTeacher teacher, @PathVariable int id){
		Optional<FutureTeacher> teacherOptional = futureTeacherRepository.findById(id);
		
		if(!teacherOptional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		teacher.setId(id);
		
		futureTeacherRepository.save(teacher);
		
		return ResponseEntity.noContent().build();
	}
}
