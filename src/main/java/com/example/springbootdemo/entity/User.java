package com.example.springbootdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.example.springbootdemo.generalClass.GeneralUser;

@Entity
@Table(name = "users")
public class User extends GeneralUser{

	@Column(name = "role")
	private String role;

	
	User(){
		super();
	}
	
	public User(String firstName, String lastName, String username, String password, String role) {
		super(firstName, lastName, username, password);
		this.role = role;
	}
	
	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		return "User "+super.toString()+", role="+ role + "]";
	}
	
	
	

	
	
}
