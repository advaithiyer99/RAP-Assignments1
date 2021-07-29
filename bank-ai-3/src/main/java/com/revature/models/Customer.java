package com.revature.models;

public class Customer extends User {

	private String name;
	private String gender;
	private int age;
	
	public Customer(String username, String PIN, String name) {
		super(username, PIN);
		this.setName(name);
		this.setGender(gender);
		this.setAge(age);
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}


	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

}
