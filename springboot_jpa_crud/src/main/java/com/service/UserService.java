package com.service;

import java.util.List;


import com.Entity.User;

public interface UserService {
	public void saveUser(User user);
	public List<User> getAllUser();
	public User getUser(int id);
	public void delete(int id);
	public void updateUser(User user);
}
