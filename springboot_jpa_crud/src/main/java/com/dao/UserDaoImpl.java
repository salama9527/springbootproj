package com.dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.Entity.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	@PersistenceContext
	EntityManager em;
	
	public void saveData(User user)
	{
		System.out.println("hello");
		em.persist(user);
	}
	public List<User> getAllUser()
	{
		Query q=em.createQuery("select u from User u");
	    List l=	q.getResultList();
	   return l;
	}
	public User getUser(int id)
	{
		User user=em.find(User.class,id);
		return user;
	}
	public void delete(int id)
	{
		User user=getUser(id);
		em.remove(user);
	}
	public void updateUser(User user) {
		User user1=em.find(User.class, user.getUid());
		user1.setEmail(user.getEmail());
		user1.setUserName(user.getUserName());
		user1.setAge(user.getAge());
		em.persist(user1);
	}
}
