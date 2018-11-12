package com.resource;

import java.util.List;

import javax.annotation.Resource;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Entity.Employee;
import com.dao.EmployeeDao;


@Path("/employee")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmployeeResource {

	public EmployeeResource(EmployeeDao employeeDao) {
		System.out.println("constructor");
	}

	@Autowired
	EmployeeDao employeeDao;
	
@GET
public Response getAllEmployee()
{
	List<Employee> list=employeeDao.getAllEmployee();
	ResponseBuilder rb=Response.ok();
	return rb.entity(list).build();
}
}
