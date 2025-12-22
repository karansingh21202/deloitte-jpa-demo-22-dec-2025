package com.deloitte.demo.service;

import com.deloitte.demo.model.Employee;
import com.deloitte.demo.util.JPAUtil;

import jakarta.persistence.EntityManager;

import java.util.List;

public class EmployeeService {

	public void addEmployee(String name, double salary) {

		// SELECT == em.find()
		// INSERT == persist()
		// UPDATE set methods in java
		// DELETE == remove()

		EntityManager em = JPAUtil.getEntityManager();

		em.getTransaction().begin();
		em.persist(new Employee(name, salary));
		em.getTransaction().commit();
		em.close();
	}

	public Employee getEmployeeById(int id) {
		EntityManager em = JPAUtil.getEntityManager();
		Employee emp = em.find(Employee.class, id);
		em.close();
		return emp;
	}

	public List<Employee> getAllEmployees() {
		EntityManager em = JPAUtil.getEntityManager();
		List<Employee> list = em.createQuery("from Employee", Employee.class).getResultList();
		em.close();
		return list;
	}

	public void updateEmployee(int id, String name, double salary) {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		Employee emp = em.find(Employee.class, id);
		if (emp != null) {
			emp.setName(name);
			emp.setSalary(salary);
		}
		em.getTransaction().commit();
		em.close();
	}

	public void deleteEmployee(int id) {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		Employee emp = em.find(Employee.class, id);
		if (emp != null) {
			em.remove(emp);
		}
		em.getTransaction().commit();
		em.close();
	}
}