package com.BikkadIT.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.BikkadIT.Service.EmployeeServiceI;

@RestController
public class DeleteController {

	@Autowired
	private EmployeeServiceI employeeServiceI;
	
	@DeleteMapping(value = "/deleteById/{id}")
	public ResponseEntity<String> delete(@PathVariable int id)
	{
		boolean flag = employeeServiceI.delete(id);
		
		if(flag)
		{
			return new ResponseEntity<String>("Data Deleted for Id : "+id,HttpStatus.OK);
		}
		
		return new ResponseEntity<String>("Data Can not delete because id is not matching",HttpStatus.BAD_REQUEST);

	}
	
	@DeleteMapping("/deleteAll")
	public ResponseEntity<String> deleteAll()
	{
		employeeServiceI.deleteAll();
		
		return new ResponseEntity<String>("All Employees Data Deleted Successfully",HttpStatus.OK);
	}
}
