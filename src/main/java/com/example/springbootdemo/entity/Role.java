package com.example.springbootdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "edit_user")
	private boolean editUser;
	@Column(name = "edit_role")
	private boolean editRole;
	@Column(name = "edit_task")
	private boolean ediTask;
	@Column(name = "edit_future_prof")
	private boolean editFutureProf;
	
	public Role() {}
	
	public Role(String name, boolean editUser, boolean editRole, boolean editTask, boolean editFutureProf) {
		super();
		this.name = name;
		this.editUser = editUser;
		this.editRole = editRole;
		this.ediTask = editTask;
		this.editFutureProf = editFutureProf;
	}

	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isEditUser() {
		return editUser;
	}

	public void setEditUser(boolean editUser) {
		this.editUser = editUser;
	}

	public boolean isEditRole() {
		return editRole;
	}

	public void setEditRole(boolean editRole) {
		this.editRole = editRole;
	}

	public boolean isEditTask() {
		return ediTask;
	}

	public void setEditTask(boolean validate) {
		this.ediTask = validate;
	}

	public boolean isEditFutureProf() {
		return editFutureProf;
	}

	public void setEditFutureProf(boolean editFutureProf) {
		this.editFutureProf = editFutureProf;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", editUser=" + editUser + ", editRole=" + editRole + ", ediTask="
				+ ediTask + ", editFutureProf=" + editFutureProf + "]";
	}

	public boolean isAdmin() {
		if(this.getName().equals("admin")) {
			return true;
		}else {
			return false;
		}
	}
	
	
}
