package com.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.Employee;
import com.dao.EmployeeDao;

@Service

public class EmployeeServiceImpl implements EmployeeService  {
@Autowired
EmployeeDao employeeDao;

	@Override
	public void save(Employee e) {
		
		employeeDao.save(e);
	}

	@Override
	public Employee getEmployee(int id) {
		
		return employeeDao.getEmployee(id);
	}

	@Override
	public List<Employee> getAllEmployee() {
		
		return employeeDao.getAllEmployee();
	}

	@Override
	public void deleteEmployee(int id) {
		
		employeeDao.deleteEmployee(id);
	}

	@Override
	public Employee updateEmployee(int id, Employee e) {
		
		return employeeDao.updateEmployee(id, e);
	}

}
