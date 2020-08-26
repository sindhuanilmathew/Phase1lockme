package com.dell.lockme.model;

public class Credentials {
	
	private String socialSiteName;
	private String loggedInUser;
	private String username;
	private String password;
	
	public Credentials() {}

	public Credentials(String socialSiteName, String loggedInUser, String username, String password) {
		this.socialSiteName = socialSiteName;
		this.loggedInUser = loggedInUser;
		this.username = username;
		this.password = password;
	}

	public String getSocialSiteName() {
		return socialSiteName;
	}

	public void setSocialSiteName(String socialSiteName) {
		this.socialSiteName = socialSiteName;
	}

	public String getLoggedInUser() {
		return loggedInUser;
	}

	public void setLoggedInUser(String loggedInUser) {
		this.loggedInUser = loggedInUser;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserCredentials [socialSiteName=" + socialSiteName + 
				", loggedInUser=" + loggedInUser + 
				", username=" + username
				+ ", password=" + password + "]";
	}
}
