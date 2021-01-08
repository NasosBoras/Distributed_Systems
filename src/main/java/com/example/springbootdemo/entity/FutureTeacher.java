package com.example.springbootdemo.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "future_teachers")
public class FutureTeacher {
	
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "list_of_tasks")
	private String tasks;
	@Column(name = "total_points")
	private int points;
	
	public FutureTeacher() {}
	
	public FutureTeacher(String firstName, String lastName, int points) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.points = points;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getTasks() {
		return tasks;
	}

	public void setTasks(String tasks) {
		this.tasks = tasks;
	}

	@Override
	public String toString() {
		return "FutureTeacher [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", tasks=" + tasks
				+ ", points=" + points + "]";
	}


	

	
	
	
}
