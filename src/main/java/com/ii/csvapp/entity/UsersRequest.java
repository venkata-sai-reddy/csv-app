package com.ii.csvapp.entity;

public class UsersRequest {
	
	private String first_name;
	
	private String last_name;
	
	private String role;
	
	private int pageNo;
	
	private int pageRecords;
	
	public UsersRequest(String first_name, String last_name, String role, int pageNo, int pageRecords) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.role = role;
		this.pageNo = pageNo;
		this.pageRecords = pageRecords;
	}
	
	public UsersRequest() {
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageRecords() {
		return pageRecords;
	}

	public void setPageRecords(int pageRecords) {
		this.pageRecords = pageRecords;
	}

}
