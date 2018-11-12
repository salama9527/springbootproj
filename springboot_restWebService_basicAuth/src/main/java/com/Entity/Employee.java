package com.Entity;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Employee {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int eid;


private String name;
private String department;
private String password;
private String enable;

@OneToOne(cascade=CascadeType.ALL)
@JoinColumn(name="empRoleId",referencedColumnName="id")
@JsonIgnore
private Employee_roles emp_role;

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

public String getDepartment() {
	return department;
}

public void setDepartment(String department) {
	this.department = department;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getEnable() {
	return enable;
}

public void setEnable(String enable) {
	this.enable = enable;
}

public Employee_roles getEmp_role() {
	return emp_role;
}

public void setEmp_role(Employee_roles emp_role) {
	this.emp_role = emp_role;
}

@Override
public String toString() {
	return "Employee [eid=" + eid + ", name=" + name + ", department=" + department + ", password=" + password
			+ ", enable=" + enable + ", emp_role=" + emp_role + "]";
}

}
