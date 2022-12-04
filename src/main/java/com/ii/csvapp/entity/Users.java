package com.ii.csvapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Users {
	
	@Id
	private int id;
	
	@Column
	private String last_name;

	@Column
	private String first_name;

	@Column
	private String email;

	@Column
	private String gender;

	@Column
	private String dob;

	@Column
	private String role;
	
	public Users(int id, String last_name, String first_name, String email, String gender, String dob, String role) {
		super();
		this.id = id;
		this.last_name = last_name;
		this.first_name = first_name;
		this.email = email;
		this.gender = gender;
		this.dob = dob;
		this.role = role;
	}
	
	public Users() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
