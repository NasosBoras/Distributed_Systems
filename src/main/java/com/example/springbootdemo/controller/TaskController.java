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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.springbootdemo.entity.Task;
import com.example.springbootdemo.repository.TaskRepository;

@RestController
@RequestMapping("/api")
public class TaskController {
	
	@Autowired
	private TaskRepository taskRepository;

	
	@GetMapping("/tasks")
	public List<Task> retrieveAllTasks(){
		return taskRepository.findAll();
	}
	
	@GetMapping("/tasks/{id}")
	public Task retrieveTask(@PathVariable int id) {
		Optional<Task> task = taskRepository.findById(id);
		return task.get();
	}
	
	@DeleteMapping("/tasks/{id}")
	public ResponseEntity<Object> deleteTask(@RequestBody Task task){
		Task savedTask = taskRepository.save(task);
		
		URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}")
				.buildAndExpand(savedTask.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@PostMapping("/tasks")
	public ResponseEntity<Object> createTask(@RequestBody Task task){
		Task savedTask = taskRepository.save(task);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedTask.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping("/tasks/{id}")
	public ResponseEntity<Object> updateTask(@RequestBody Task task, @PathVariable int id){
		Optional<Task> taskOptional = taskRepository.findById(id);
		
		if(!taskOptional.isPresent()) 
			return ResponseEntity.notFound().build();
		task.setId(id);
		
		taskRepository.save(task);
		
		return ResponseEntity.noContent().build();
	}
}
