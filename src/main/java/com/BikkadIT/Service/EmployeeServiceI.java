package com.BikkadIT.Service;

import java.util.List;

import com.BikkadIT.Model.Employee;

public interface EmployeeServiceI {

	public Employee saveEmployee(Employee employee);
	public List<Employee> saveMultiEmployee(List<Employee> employees);
	public Employee getEmployeeById(int id);
	public List<Employee> getAllEmployee();
	public List<Employee> findByAgeLessThanOrEqual(int age);
	public Employee loginCheck(String name,int id);
	public Employee update(Employee employee);
	public List<Employee> updateMultiple(List<Employee> employees);
	public boolean delete(int id);
	public void deleteAll();
}

