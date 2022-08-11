package com.BikkadIT.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.BikkadIT.Service.EmployeeServiceI;
import com.BikkadIT.Model.Employee;


@RestController
public class SaveController {

	@Autowired
	private EmployeeServiceI employeeServiceI;
	
	@PostMapping(value = "/save",consumes = "application/json")
	public ResponseEntity<String> saveEmployee(@RequestBody Employee employee)
	{
		Employee employee1 = employeeServiceI.saveEmployee(employee);
		
		return new ResponseEntity<String>("Employee Data Saved With Id and Name: "+employee1.getEmpId()+"---"+employee1.getEmpName(), HttpStatus.CREATED);
	}
	
	@PostMapping(value = "/saveMultiple",produces = "application/json",consumes = "application/json")
	public ResponseEntity<List<Employee>> saveMultiEmployee(@RequestBody List<Employee> employees)
	{
		 List<Employee> multiEmployee = employeeServiceI.saveMultiEmployee(employees);
		
		return new ResponseEntity<List<Employee>>(multiEmployee, HttpStatus.CREATED);
	}
}
