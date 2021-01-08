package com.example.springbootdemo.entity;


import java.util.ArrayList;
import java.util.List;

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
	private String fname;
	@Column(name = "last_name")
	private String lname;
	@Column(name = "list_of_tasks")
	private String tasks;
	@Column(name = "total_points")
	private int points;
	
	public FutureTeacher() {}
	
	public FutureTeacher(String firstName, String lastName, int points) {
		super();
		this.fname = firstName;
		this.lname = lastName;
		this.points = points;
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
		return "FutureTeacher [id=" + id + ", firstName=" + fname + ", lastName=" + lname + ", tasks=" + tasks
				+ ", points=" + points + "]";
	}

	
	public void addTask(int id) {
		this.tasks += ","+id;
	}
	
	public void removeTask(int id) {
		String[] listOfTasks = this.tasks.split(",");
		String temp = "";
		for(String task : listOfTasks) {
			if(Integer.parseInt(task) == id) {
				continue;
			}
			temp += ","+task;
		}
		this.tasks = temp;
	}
	
	public static List<Integer> getListFromString(String data){
		List<Integer> list = new ArrayList<Integer>();
		String[] temp = data.split(",");
		for(String elem : temp) {
			list.add(Integer.parseInt(elem));
		}
		return list;
	}
	
}
