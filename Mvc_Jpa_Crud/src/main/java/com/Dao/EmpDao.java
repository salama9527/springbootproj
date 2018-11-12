package com.Dao;

import java.util.List;

import com.Entity.EmployeeHlo;
import com.Model.Employee;

public interface EmpDao {
public boolean insertEmp(EmployeeHlo e);
public EmployeeHlo retrieveSingleEmp(int id);
public List<EmployeeHlo> retrieveAllEmp();
public boolean removeEmp(int id);
public EmployeeHlo updateEmp(EmployeeHlo e);
}
