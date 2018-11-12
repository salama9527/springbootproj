package com.service;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.User;
import com.dao.UserDao;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao userDao;
	
public void saveUser(User user)
{
	userDao.saveData(user);
} 
public List<User> getAllUser()
{
	List<User> l=userDao.getAllUser();
	return l;
}
public User getUser(int id)
{
	User user=userDao.getUser(id);
	return user;
}
public void delete(int id)
{
	userDao.delete(id);
}
public void updateUser(User user)
{
	userDao.updateUser(user);
}
}
