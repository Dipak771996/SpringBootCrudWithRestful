package com.BikkadIT.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BikkadIT.Dao.EmployeeDaoI;
import com.BikkadIT.Model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeServiceI {

	@Autowired
	private EmployeeDaoI employeeDaoI;
	
	@Override
	public Employee saveEmployee(Employee employee) {
		Employee saveEmployee = employeeDaoI.saveEmployee(employee);
		return saveEmployee;
	}

	@Override
	public List<Employee> saveMultiEmployee(List<Employee> employees) {
		List<Employee> multiEmployee = employeeDaoI.saveMultiEmployee(employees);
		return multiEmployee;
	}

	@Override
	public Employee getEmployeeById(int id) {
		Employee employeeById = employeeDaoI.getEmployeeById(id);
		
		return employeeById;
	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> allEmployee = employeeDaoI.getAllEmployee();
		return allEmployee;
	}

	@Override
	public List<Employee> findByAgeLessThanOrEqual(int age) {
		List<Employee> findByAgeLessThanOrEqual = employeeDaoI.findByAgeLessThanOrEqual(age);
		return findByAgeLessThanOrEqual;
	}

	@Override
	public Employee loginCheck(String name, int id) {
		Employee employee = employeeDaoI.loginCheck(name, id);
		return employee;
	}

	@Override
	public Employee update(Employee employee) {
		Employee employee2 = employeeDaoI.update(employee);
		return employee2;
	}

	@Override
	public List<Employee> updateMultiple(List<Employee> employees) {
		List<Employee> updateMultiple = employeeDaoI.updateMultiple(employees);
		return updateMultiple;
	}

	@Override
	public boolean delete(int id) {
		boolean delete = employeeDaoI.delete(id);
		return delete;
	}

	@Override
	public void deleteAll() {
		employeeDaoI.deleteAll();
		
	}

}
