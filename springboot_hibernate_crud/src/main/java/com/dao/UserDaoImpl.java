package com.dao;

import java.util.ArrayList;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.engine.spi.SessionImplementor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.Entity.User;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	SessionFactory sessionFactory;
	Session session=null;
	
	public Session getSession()
	{
		if(session!=null)
			return session;
		else
		{
			session=sessionFactory.openSession();
			return session;
		}
		
	}
	
	public void saveData(User user)
	{
		Session session=getSession();
		//Transaction t=session.beginTransaction();
		session.save(user);
		//t.commit();
		
	}
	public List<User> getAllUser()
	{
		Session session=getSession();
		Criteria criteria=session.createCriteria(User.class);
	    List l=	criteria.list();
	   return l;
	}
	public User getUser(int id)
	{
		Session session=getSession();
		User user=session.load(User.class, id);
		return  user;
	}
	public void delete(int id)
	{
		Session session=getSession();
		Transaction t=session.beginTransaction();
		User user=getUser(id);
		session.remove(user);
		t.commit();
	}
	public void updateUser(User user) {
		Session session=getSession();
		User user1=session.load(User.class, user.getUid());
		user1.setEmail(user.getEmail());
		user1.setUserName(user.getUserName());
		user1.setAge(user.getAge());
		Transaction t=session.beginTransaction();
		session.persist(user1);
		t.commit();
	}
}
