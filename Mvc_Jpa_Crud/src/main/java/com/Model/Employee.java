package com.Model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;

@Component
public class Employee {
	
@NotNull(message="id cannot be null")
private int eid;

@NotBlank(message="*name required!")
private String name;

@Email(message="*enter correct email")
@NotBlank(message="*required")
private String email;

@NotBlank(message="*required!")
private String password;

@isValidContact
private String contact;

public int getEid() {
	return eid;
}

public void setEid(int eid) {
	this.eid = eid;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getContact() {
	return contact;
}

public void setContact(String contact) {
	this.contact = contact;
}
@Override
public String toString() {
	return "Employee [eid=" + eid + ", name=" + name + ", email=" + email + ", password=" + password + ", contact="
			+ contact + "]";
}


}
