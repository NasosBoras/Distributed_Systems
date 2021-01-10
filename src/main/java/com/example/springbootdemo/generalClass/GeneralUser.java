package com.example.springbootdemo.generalClass;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class GeneralUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "first_name")
	private String fname;
	@Column(name = "last_name")
	private String lname;
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;
	
	public GeneralUser() {}
	
	public GeneralUser(String firstName, String lastName, String username, String password) {
		super();
		this.fname = firstName;
		this.lname = lastName;
		this.username = username;
		this.password = password;
	}
	public String getFirstName() {
		return fname;
	}


	public void setFirstName(String firstName) {
		this.fname = firstName;
	}


	public String getLastName() {
		return lname;
	}


	public void setLastName(String lastName) {
		this.lname = lastName;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}





	public int getId() {
		return id;
	}

	

	public void setId(int id) {
		this.id = id;
	}
	
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "[id=" + id + ", firstName=" + fname + ", lastName=" + lname + ", username=" + username
				+ ", password=" +password;
	}
}
