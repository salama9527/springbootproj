package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Entity.Employee;
@Repository
public class EmployeeDaoImpl implements EmployeeDao{

	@Autowired
	SessionFactory sf;
	
	
	@Override
	public void save(Employee e) {
		Session session =sf.openSession();
		Transaction tx=session.beginTransaction();
		session.save(e);
		tx.commit();
	}

	@Override
	public Employee getEmployee(int id) {
		Session session =sf.openSession();
		Employee emp=session.load(Employee.class, id);
		return emp;
	}

	@Override
	public List<Employee> getAllEmployee() {
		Session session =sf.openSession();
		Criteria cr=session.createCriteria(Employee.class);
		
		List<Employee> l=cr.list();
		System.out.println(l);
		return l;
	}

	@Override
	public void deleteEmployee(int id) {
		
		Session session =sf.openSession();
		System.out.println("id: "+id);
		Employee emp=session.load(Employee.class,id);
		System.out.println(emp);
		Transaction tx=session.beginTransaction();
		session.delete(emp);
		tx.commit();
	}

	@Override
	public Employee updateEmployee(int id, Employee e) {
		Session session =sf.openSession();
		Employee emp=session.load(Employee.class,id);
		Transaction tx=session.beginTransaction();
		session.merge(e);
		tx.commit();
		Employee emp1=getEmployee(id);
		return emp1;
	}

}
