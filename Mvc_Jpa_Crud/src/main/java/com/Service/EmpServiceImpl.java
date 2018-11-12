package com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Dao.EmpDao;
import com.Entity.EmployeeHlo;
import com.Model.Employee;

@Service
public class EmpServiceImpl implements EmpService {
@Autowired
EmpDao empDao;
	@Override
	public boolean addEmp(EmployeeHlo e) {
		System.out.println("service add method");
	boolean status=	empDao.insertEmp(e);
	
	return status;
	}

	@Override
	public EmployeeHlo getSingleEmp(int id) {
		EmployeeHlo e=empDao.retrieveSingleEmp(id);
		return e;
	}

	@Override
	public boolean delEmp(int id) {
		boolean status=empDao.removeEmp(id);
		return status;
	}

	
	@Override
	public EmployeeHlo editEmp(EmployeeHlo e) {
		EmployeeHlo e1=empDao.updateEmp(e);
		return e1;
	}

	@Override
	public List<EmployeeHlo> getAllEmp() {
		List l=empDao.retrieveAllEmp();
		return l;
	}
	

}
