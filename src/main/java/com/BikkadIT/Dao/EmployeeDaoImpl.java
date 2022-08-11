package com.BikkadIT.Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.BikkadIT.Model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDaoI{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Employee saveEmployee(Employee employee) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(employee);
		session.getTransaction().commit();
		session.close();
		return employee;
	}

	@Override
	public List<Employee> saveMultiEmployee(List<Employee> employees) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		for(Employee e:employees)
		{
			session.save(e);
		}
		session.getTransaction().commit();
		return employees;
	}

	@Override
	public Employee getEmployeeById(int id) {
		Session session = sessionFactory.openSession();
		Employee employee = session.get(Employee.class, id);
		return employee;
	}

	@Override
	public List<Employee> getAllEmployee() {
		Session session = sessionFactory.openSession();
		String hql="from Employee";
		Query query = session.createQuery(hql);
		List list = query.getResultList();
		
		return list;
	}

	@Override
	public List<Employee> findByAgeLessThanOrEqual(int age) {
		Session session = sessionFactory.openSession();
		String hql="from Employee where empAge<=:age";
		Query query = session.createQuery(hql);
		query.setParameter("age", age);
		List list = query.getResultList();
		return list;
	}

	@Override
	public Employee loginCheck(String name, int id) {
		Session session = sessionFactory.openSession();
		String hql="from Employee where empName=:name and empId=:id";
		Query query = session.createQuery(hql);
		query.setParameter("name", name);
		query.setParameter("id", id);
		Employee employee = (Employee) query.uniqueResult();
		return employee;
	}

	@Override
	public Employee update(Employee employee) {
		Session session = sessionFactory.openSession();
		
		Employee emp = session.get(Employee.class, employee.getEmpId());//here we are checking availability of employee
        session.clear();
        
        session.beginTransaction();
		if(emp != null)
		{
			session.update(employee);
			session.getTransaction().commit();
			session.close();
			return employee;
		}
		session.getTransaction().commit();
		session.close();
		return emp;
	}

	@Override
	public List<Employee> updateMultiple(List<Employee> employees) {
		List<Employee> l=new ArrayList<>();
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		for(Employee e:employees)
		{
			Employee emp = session.get(Employee.class, e.getEmpId());//here we are checking availability of employee
			session.clear();
			if(emp!=null)
			{
			session.update(e);
			l.add(e); // adding updated employee into a list
			}
		}
		session.getTransaction().commit();
		session.close();
		return l;
	}

	@Override
	public boolean delete(int id) {
		Session session = sessionFactory.openSession();
		Employee employee = session.get(Employee.class,id);
		if(employee!=null)
		{
		  session.beginTransaction();
		  session.delete(employee);
		  session.getTransaction().commit();
		  return true;
		}
		return false;
	}

	@Override
	public void deleteAll() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		String hql="delete from Employee";
		Query query = session.createQuery(hql);
		query.executeUpdate();
		session.close();
	}

}
