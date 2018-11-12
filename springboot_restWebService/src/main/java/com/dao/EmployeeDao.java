package com.dao;

import java.util.List;

import com.Entity.Employee;

public interface EmployeeDao {
	public void save(Employee e);
	public Employee getEmployee(int id);
	public List<Employee> getAllEmployee();
	public void deleteEmployee(int id);
	public Employee updateEmployee(int id,Employee e);
}
