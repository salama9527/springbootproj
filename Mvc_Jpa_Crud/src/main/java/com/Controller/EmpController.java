package com.Controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.Entity.EmployeeHlo;
import com.Model.Employee;
import com.Service.EmpService;

@Controller
public class EmpController {
	
@Autowired
EmpService empService;


@PostMapping(value="/addEmp")
public String addEmp(HttpServletRequest req,@Valid @ModelAttribute("emp") EmployeeHlo e,BindingResult br,Map<String,String> m){
	if(br.hasErrors())
	{
		return "EntryForm";
	}
	empService.addEmp(e);
	m.put("success", "employee added successfully");
	return "Display";
}

@GetMapping(value="/EntryForm")
public ModelAndView showForm()
{
	return new ModelAndView("EntryForm","emp",new Employee());
}

@GetMapping(value="/Display")
public String showDisplayForm()
{
	return "Display";
}

@GetMapping(value="/getSingleEmp")
public String getSingleEmp(HttpServletRequest req,HttpServletResponse res,Map<String,Object> m)
{
	int id=Integer.parseInt(req.getParameter("id"));
	EmployeeHlo e=empService.getSingleEmp(id);
	List<EmployeeHlo> l=new ArrayList<>();
	l.add(e);
	System.out.println(e);
	m.put("list", l);
	return "EmpDetail";
}

@PostMapping(value="/delEmp")
public String delEmp(HttpServletRequest req,HttpServletResponse res)
{
	int id=Integer.parseInt(req.getParameter("del"));
	boolean status=empService.delEmp(id);
	return "Display";
}

@GetMapping(value="/updateForm")
public ModelAndView showUpdateForm(HttpServletRequest req)
{
	Employee e=new Employee();
	int id=Integer.parseInt(req.getParameter("id"));
	EmployeeHlo ehlo=empService.getSingleEmp(id);
	BeanUtils.copyProperties(ehlo, e);
	e.setEid(id);
	System.out.println(e.getContact());

	return new ModelAndView("UpdateEmp","emp",e);
}

@PostMapping(value="/updateEmp")
public String editEmp(@Valid @ModelAttribute("emp")Employee e,HttpServletRequest req,HttpServletResponse res,Map<String,EmployeeHlo> map)
{
	int id= Integer.parseInt(req.getParameter("id"));
	EmployeeHlo ehlo=new EmployeeHlo();
	BeanUtils.copyProperties(e, ehlo);
	ehlo.setEid(id);
	EmployeeHlo e1= empService.editEmp(ehlo);
	map.put("emp",e1);
	 return "Display";
}

@GetMapping(value="/getAllEmp")
public String getAllEmp(Map<String,Object> m)
{
	List l=empService.getAllEmp();
	m.put("list", l);
	return "EmpDetail";
}


}
