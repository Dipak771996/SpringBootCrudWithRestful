package com.BikkadIT.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.BikkadIT.Model.Employee;
import com.BikkadIT.Service.EmployeeServiceI;

@RestController
public class GetController {

	@Autowired
	private EmployeeServiceI employeeServiceI;
	
	@GetMapping(value = "/getById/{id}",produces = "application/json")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int id)
	{
		Employee employee = employeeServiceI.getEmployeeById(id);
		
		if(employee != null)
		{
			return new ResponseEntity<Employee>(employee,HttpStatus.OK);
		}
		
		return new ResponseEntity<Employee>(employee,HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(value = "/getAllEmployee",produces = "application/json")
	public ResponseEntity<List<Employee>> getAllEmployee()
	{
		List<Employee> allEmployee = employeeServiceI.getAllEmployee();
		if(allEmployee !=null)
		{
		return new ResponseEntity<List<Employee>>(allEmployee,HttpStatus.OK);
	   	}
		
		return new ResponseEntity<List<Employee>>(allEmployee,HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(value = "/getAllEmployee/{age}",produces = "application/json")
	public ResponseEntity<List<Employee>> getAllEmployeeLessThanOrEqual(@PathVariable int age)
	{
		List<Employee> allEmployee = employeeServiceI.findByAgeLessThanOrEqual(age);
		if(allEmployee !=null)
		{
		return new ResponseEntity<List<Employee>>(allEmployee,HttpStatus.OK);
	   	}
		
		return new ResponseEntity<List<Employee>>(allEmployee,HttpStatus.NO_CONTENT);
	}
	
}
