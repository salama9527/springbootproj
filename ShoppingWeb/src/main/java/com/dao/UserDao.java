package com.dao;

import com.entity.User_Hlo;

public interface UserDao {
	public void saveUser(User_Hlo user_Hlo);
	public User_Hlo getuser(String email);
	public void saveCategory();
}
