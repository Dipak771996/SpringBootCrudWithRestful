package com.BikkadIT.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.BikkadIT.Model.Employee;
import com.BikkadIT.Service.EmployeeServiceI;

@RestController
public class UpdateController {

	@Autowired
	private EmployeeServiceI employeeServiceI;
	
	@PutMapping(value = "/update",consumes = "application/json",produces = "application/json")
	public ResponseEntity<Employee> update(@RequestBody Employee employee)
	{
		Employee employee2 = employeeServiceI.update(employee);
		
		if(employee2 != null)
		{
			return new ResponseEntity<Employee>(employee2,HttpStatus.OK);
		}
		
		return new ResponseEntity<Employee>(employee2,HttpStatus.BAD_REQUEST);
		
	}	
		
		@PutMapping(value = "/updateMultiple",consumes = "application/json",produces = "application/json")
		public ResponseEntity<List<Employee>> updateMultiple(@RequestBody List<Employee> employees)
		{
			List<Employee> employees1 = employeeServiceI.updateMultiple(employees);
			
			if(employees1 != null)
			{
				return new ResponseEntity<List<Employee>>(employees1,HttpStatus.OK);
			}
			
			return new ResponseEntity<List<Employee>>(employees1,HttpStatus.BAD_REQUEST);
	}
}
