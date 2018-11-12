package com.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.Entity.Employee;

@Repository
public interface EmployeeDao extends CrudRepository<Employee,Integer>{
	
	public Employee save(Employee e);
	//predefined(check if exist)
	public  boolean existsById(int id);
	//custom(check if exist)
	public  boolean existsBylname(String lname);
	public  boolean existsByfname(String fname);
	
	//predefined(delete)
	public void deleteById(int id);
	
	
	//custom(delete)
	@Transactional
	public void deleteByfname(String fname);

	
	//predefined(retrieve)
	public Employee findById(int id);
	
	//custom(retrieve)
	public Employee findBylname(String lname);
	
	
}
