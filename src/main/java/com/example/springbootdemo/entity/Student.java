package com.example.springbootdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.example.springbootdemo.generalClass.GeneralUser;

@Entity
@Table(name = "students")
public class Student extends GeneralUser{
	@Column(name = "semester")
	private int semester;
	
	public Student() {}

	public Student(String firstName, String lastName, String username, String password,int semester) {
		super(firstName, lastName, username, password);
		this.semester = semester;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	@Override
	public String toString() {
		return "Student "+super.toString()+", semester="+ semester + "]";
	}

	
	
}
