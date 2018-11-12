package com.Service;

import java.util.List;

import com.Entity.EmployeeHlo;
import com.Model.Employee;

public interface EmpService {
public boolean addEmp(EmployeeHlo ehlo);
public EmployeeHlo getSingleEmp(int id);
public List<EmployeeHlo> getAllEmp();
public boolean delEmp(int id);
public EmployeeHlo editEmp(EmployeeHlo e);
}
