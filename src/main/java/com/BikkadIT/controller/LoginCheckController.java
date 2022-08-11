package com.BikkadIT.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.BikkadIT.Model.Employee;
import com.BikkadIT.Service.EmployeeServiceI;

@RestController
public class LoginCheckController {

	@Autowired
	private EmployeeServiceI employeeServiceI;
	
	@PostMapping(value = "/login",consumes = "application/json")
	public ResponseEntity<String> loginCheck(@RequestBody Employee employee)
	{
		Employee employee1 = employeeServiceI.loginCheck(employee.getEmpName(), employee.getEmpId());
		
		if(employee1 != null)
		{
			return new ResponseEntity<String>("successful login",HttpStatus.OK);
		}
		
		return new ResponseEntity<String>("login failed please check Id or Name",HttpStatus.BAD_REQUEST);
	}
}
