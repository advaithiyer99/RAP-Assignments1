package com.revature.models;

public abstract class User {

	protected String username;
	private String PIN;
	
	public User (String username, String PIN) {
		this.setUsername(username);
		this.setPIN(PIN);
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPIN() {
		return PIN;
	}
	public void setPIN(String PIN) {
		this.PIN = PIN;
	}
	
	
}
