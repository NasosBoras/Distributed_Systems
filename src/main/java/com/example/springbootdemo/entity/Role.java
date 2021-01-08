package com.example.springbootdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "edit_user")
	private boolean editUser;
	@Column(name = "edit_role")
	private boolean editRole;
	@Column(name = "validate")
	private boolean validate;
	@Column(name = "edit_future_prof")
	private boolean editFutureProf;
	
	public Role() {}
	
	public Role(String name, boolean editUser, boolean editRole, boolean validate, boolean editFutureProf) {
		super();
		this.name = name;
		this.editUser = editUser;
		this.editRole = editRole;
		this.validate = validate;
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

	public boolean isValidate() {
		return validate;
	}

	public void setValidate(boolean validate) {
		this.validate = validate;
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
		return "Role [name=" + name + ", editUser=" + editUser + ", editRole=" + editRole + ", validate=" + validate
				+ ", editFutureProf=" + editFutureProf + "]";
	}
	
	public boolean isAdmin() {
		if(this.getName().equals("admin")) {
			return true;
		}else {
			return false;
		}
	}
	
	
}
