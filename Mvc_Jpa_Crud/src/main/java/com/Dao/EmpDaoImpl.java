package com.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Entity.EmployeeHlo;
import com.Model.Employee;

@Repository
public class EmpDaoImpl implements EmpDao {
	
@PersistenceContext
EntityManager em;

	@Override
	@Transactional
	public boolean insertEmp(EmployeeHlo e) {
		System.out.println("emp dao insert");
		em.persist(e);
		return true;
	}
	
	@Override
	@Transactional
	public EmployeeHlo retrieveSingleEmp(int id) {
		System.out.println(id);
		EmployeeHlo e=em.find(EmployeeHlo.class, id);
		return e;
	}


	@Override
	@Transactional
	public boolean removeEmp(int id) {
		EmployeeHlo e=retrieveSingleEmp(id);
		em.remove(e);
		return true;
	}

	@Override
	@Transactional
	public EmployeeHlo updateEmp(EmployeeHlo e) {
		EmployeeHlo e1=em.find(EmployeeHlo.class, e.getEid());
		e1.setEmail(e.getEmail());
		e1.setName(e.getName());
		e1.setPassword(e.getPassword());
		e1.setContact(e.getContact());
		em.persist(e1);
		EmployeeHlo emp=retrieveSingleEmp(e1.getEid());
		return emp;
	}

	@Override
	public List<EmployeeHlo> retrieveAllEmp() {
		Query q=em.createNativeQuery("select * from EmployeeHlo",EmployeeHlo.class);
		List l=q.getResultList();
		return l;
	}

	

}
