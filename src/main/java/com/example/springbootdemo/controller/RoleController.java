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

import com.example.springbootdemo.entity.Role;
import com.example.springbootdemo.repository.RoleRepository;

@RestController
public class RoleController {
	
	@Autowired
	private RoleRepository roleRepository;
	
	@GetMapping("/roles")
	public List<Role> retrieveAllRoles(){
		return roleRepository.findAll();
	}
	
	@GetMapping("/roles/{id}")
	public Role retrieveRole(@PathVariable int id) {
		Optional<Role> role = roleRepository.findById(id);
		
		return role.get();
	}
	
	@DeleteMapping("/role/{id}")
	public void deleteRole(@PathVariable int id) {
		Role role = roleRepository.findById(id).get();
		if(!role.isAdmin()) {
			roleRepository.delete(role);
		}
	}
	
	@PostMapping("/roles")
	public ResponseEntity<Object> createRole(@RequestBody Role role){
		Role savedRole = roleRepository.save(role);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedRole.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping("/roles/{id}")
	public ResponseEntity<Object> updateRole(@RequestBody Role role, @PathVariable int id){
		Optional<Role> roleOptional = roleRepository.findById(id);
		
		if(roleOptional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		role.setId(id);
		
		roleRepository.save(role);
		
		return ResponseEntity.noContent().build();
	}
}
