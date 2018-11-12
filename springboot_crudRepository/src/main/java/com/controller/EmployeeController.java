package com.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.Entity.Employee;
import com.dao.EmployeeDao;


@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeDao emp;
	
	@GetMapping("/Form")
	public String getForm()
	{
		return "RegForm";
	}
	@PostMapping("/save")
	public String save(HttpServletRequest req)
	{
		Employee e=new Employee();
		String fname=req.getParameter("fname");
		String lname=req.getParameter("lname");
		System.out.println(fname);
		System.out.println(lname);
		e.setFname(fname);
		e.setLname(lname);
		System.out.println(e.getFname());
		System.out.println(e.getLname());
		emp.save(e);
		return "success";
	}
	@GetMapping("/FindForm")
	public void getFindForm()
	{
	}
	
	@PostMapping("/find")
	public String find(HttpServletRequest req,Map m)
	{  
		String lname=req.getParameter("lname");
		if(lname!=null)
			{
				boolean b=emp.existsBylname(lname);
				System.out.println("b found by lname");}
		String id=req.getParameter("id");
		if(id!=null)
			{boolean b=emp.existsById(Integer.parseInt(id));
			System.out.println("b found by id");}
		String fname=req.getParameter("fname");
		if(fname!=null)
			{emp.existsByfname(fname);
			System.out.println("b found by fname");}
		
		return "success";
	}
	
	@PostMapping("/Retrieve")
	public String retrieve(HttpServletRequest req,Map<String,Employee> m)
	{ 
		String lname=req.getParameter("lname");
		if(lname!=null)
			{
			System.out.println(lname);
				Employee b=emp.findBylname(lname);
				m.put("Employee", b);
				}
		String id=req.getParameter("id");
		if(id!=null)
			{
			System.out.println(id);Employee b=emp.findById(Integer.parseInt(id));
			  m.put("Employee", b);
			}
		return "success";
	}
	
	@PostMapping("/delete")
	public String delete(HttpServletRequest req,Map<String,Employee> m)
	{ 
		String fname=req.getParameter("fname");
		if(fname!=null)
			{
				System.out.println(fname);
				emp.deleteByfname(fname);
				}
		String id=req.getParameter("id");
		if(id!=null)
			{
			System.out.println(id);
			emp.deleteById(Integer.parseInt(id));
			}
		return "success";
	}
	
	
}
