package com.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.entity.Category_Hlo;
import com.entity.Subcategory_Hlo;
import com.entity.User_Hlo;

@Repository
public class UserDaoImpl implements UserDao {
	
@Autowired
SessionFactory sessionFactory;

@Transactional
public void saveUser(User_Hlo user_Hlo)
{
	System.out.println("inside dao");
	Session session=sessionFactory.openSession();
	session.save(user_Hlo);
	System.out.println("user saved successfully");
}

@Transactional
public void saveCategory()
{

	Subcategory_Hlo sub_Hlo=new Subcategory_Hlo();
	sub_Hlo.setSubcategory_name("Children");
	sub_Hlo.setSubcategory_id(100);

	Subcategory_Hlo sub_Hlo1=new Subcategory_Hlo();
	sub_Hlo1.setSubcategory_name("Men");
	sub_Hlo1.setSubcategory_id(101);

	Set<Subcategory_Hlo> lsubCategory=new HashSet<>();
	lsubCategory.add(sub_Hlo);	
	lsubCategory.add(sub_Hlo1);
	
	Category_Hlo chlo=new Category_Hlo();
	chlo.setCategory_name("Casual");
	chlo.setCategory_id(1);
	chlo.setSubCategory(lsubCategory);
	
	Session session=sessionFactory.openSession();
	session.save(chlo);
	
	System.out.println("user saved successfully");
}


public User_Hlo getuser(String email)
{
	return null;
}
}
