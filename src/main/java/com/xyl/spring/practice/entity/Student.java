package com.xyl.spring.practice.entity;


public class Student {
	
	private String username;
	
	private int age;
	
	public Student(){
		System.out.println("instance a student");
	}
	
	private void init(){
		System.out.println("Student is instanced");
	}
	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [username=" + username + ", age=" + age + "]";
	}
	
}
