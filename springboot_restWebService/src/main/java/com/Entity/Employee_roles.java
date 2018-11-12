package com.Entity;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Employee_roles implements Serializable {
	
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int id;

private String name;

@Column(length=100)
private String role;

@OneToOne(mappedBy="emp_role")
private Employee employee;
public Employee_roles() {
	
}

public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}


public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public Employee getEmployee() {
	return employee;
}

public void setEmployee(Employee employee) {
	this.employee = employee;
}

}
