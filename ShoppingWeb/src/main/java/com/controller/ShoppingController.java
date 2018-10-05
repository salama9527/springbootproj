package com.controller;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dao.UserDao;
import com.entity.User_Hlo;
import com.model.User;

@Controller
public class ShoppingController {
	
@Autowired
UserDao userDao; 

@GetMapping(value="/Register")
public String getHome()
{
	System.out.println("controller");
	return "Registeration";	
}

@PostMapping(value="/SubmitData")
public String addDetail(@Valid @ModelAttribute User user,BindingResult br)
{
	User_Hlo user_Hlo=new User_Hlo();
	BeanUtils.copyProperties(user, user_Hlo);
	userDao.saveCategory();
	userDao.saveUser(user_Hlo);
	return "Login";
}


}
