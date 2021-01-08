package com.example.springbootdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tasks")
public class Task {
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "hours")
	private int hours;
	@Column(name = "description")
	private String description;
	@Column(name = "assigned_on")
	private String assignedOn;
	@Column(name = "completed")
	private boolean completed;
	
	public Task() {}
	
	public Task(int hours, String description) {
		super();
		this.hours = hours;
		this.description = description;
	}
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getId() {
		return id;
	}
	
	
	
	public String getAssignedOn() {
		return assignedOn;
	}

	public void setAssignedOn(String assignedOn) {
		this.assignedOn = assignedOn;
	}

	public void setId(int id) {
		this.id = id;
	}
	

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", hours=" + hours + ", description=" + description + ", assignedOn=" + assignedOn
				+ ", completed=" + completed + "]";
	}

	

	
	
	
}
