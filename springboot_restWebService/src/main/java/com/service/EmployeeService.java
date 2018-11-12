package com.service;

import java.util.List;

import com.Entity.Employee;

public interface EmployeeService {
	public void save(Employee e);
	public Employee getEmployee(int id);
	public List<Employee> getAllEmployee();
	public void deleteEmployee(int id);
	public Employee updateEmployee(int id,Employee e);
	
}
