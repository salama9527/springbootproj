package com.controller;

import java.util.List;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.Entity.User;

import com.dao.UserDao;
import com.dao.UserDaoImpl;
import com.service.UserService;

@Controller
public class UserController {
	
@Autowired
UserService userService;

	@GetMapping("/Form")
	public String getForm()
	{
		return "RegisterationForm";
	}
	@GetMapping("/FormOp")
	public String getFormOp()
	{
		return "FormOp";
	}
	
	
	@PostMapping("/update")
	public String editEmp(@ModelAttribute("user")User user)
	{
		System.out.println(user);
		userService.updateUser(user);
		 return "FormOp";
	}

	@PostMapping("/save")
	public String saveUser(@ModelAttribute User user)
	{
		userService.saveUser(user);
		return "FormOp";
	}
	
	@PostMapping("/operation")
	public ModelAndView deleteUser(HttpServletRequest req)
	{
		try{
			String id=req.getParameter("delete");
			userService.delete(Integer.parseInt(id));
			return new ModelAndView("FormOp");
		}
		catch(Exception e)
		{
			String id=req.getParameter("update");
			User user=userService.getUser(Integer.parseInt(id));
			return new ModelAndView("UpdateUser","user",user);
		}
		
	}
	
	@PostMapping("/retrieve")
	public String retrieveUser(@RequestParam("id") String  id)
	{
		userService.getUser(Integer.parseInt(id));
		return "Success";
	}
	
	@PostMapping("/retrieveAll")
	public String retrieveAllUser(Map<String,List<User>> m)
	{
	    List<User> l=	userService.getAllUser();
		m.put("list",l);
		return "Success";
	}
	
}
