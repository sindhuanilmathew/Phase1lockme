package com.dell.lockme.model;

public class Users {
	
	private String name;
	private String userPassword;
	
	public Users() {}

	public Users(String name, String userPassword) {
		this.name = name;
		this.userPassword = userPassword;
	}

	public String getUsername() {
		return name;
	}

	public void setUsername(String name) {
		this.name = name;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Override
	public String toString() {
		return "Users [name=" + name + ", Password=" + userPassword + "]";
	}
}
