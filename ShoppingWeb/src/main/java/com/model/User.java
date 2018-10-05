package com.model;

import org.springframework.stereotype.Component;

@Component
public class User {
private String name;
private int age;
private String gender;
private int number;
private String password;
private String email;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public int getNumber() {
	return number;
}
public void setNumber(int number) {
	this.number = number;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

}
