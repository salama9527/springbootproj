package com.controller;


import java.util.List;

import javax.annotation.Resource;
import javax.swing.text.html.FormSubmitEvent.MethodType;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.Response.StatusType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Entity.Employee;
import com.Entity.Employee_roles;
import com.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService empService;
	

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public List<Employee>  get()
	{
		List<Employee> list=empService.getAllEmployee();
		System.out.println("controller:"+list);
		return list;
	}
	
	@RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
	public Employee  getSingleEmp(@PathVariable("id") String id)
	{
		Employee emp=empService.getEmployee(Integer.parseInt(id));
		return emp;
	}
	
	 @RequestMapping(value = "/add", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('ROLE_ADMIN')")
	public  String addEmployee(@RequestBody Employee e)
	{
		 Employee_roles er=new Employee_roles();
		 er.setName(e.getName());
		 er.setRole("ROLE_USER");
        e.setEmp_role(er);
        e.setEnable("true");
        //er.setId(e.getEid());
		empService.save(e);
		return "created";
	}
	
	 @RequestMapping(value = "/put/{id}", method = RequestMethod.PUT)
	public Employee updateDetails(@RequestBody Employee e, @PathVariable("id") String id)
	{
		 System.out.println(id);
		 
		 e.setEid(Integer.parseInt(id));
		 System.out.println(e);
		Employee emp=empService.updateEmployee(Integer.parseInt(id), e);
		System.out.println(emp);
		return emp;
	}
	
	 @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	 @PreAuthorize("hasRole('ROLE_ADMIN')")
	public String delete(@PathVariable("id") String id)
	{
		empService.deleteEmployee(Integer.parseInt(id));
		return "record deleted Sucessfully";
	}
}
