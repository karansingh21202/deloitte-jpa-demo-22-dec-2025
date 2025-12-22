
package com.deloitte.demo.model;

import jakarta.persistence.*;

@Entity // mandatory - remove and see // tells JPA to treat this class as entity

@Table(name = "employee") // change the name e.g. deloitte_employee and see on workbench // optional but
							// recommended

public class Employee {

	@Id // mandatory // shows PK column name

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// insert PK values automatically
	// remobve and see

	@Column(name = "id") // optional
	private int id;

	// find out other annotations -
//	@
	private String name;

	private double salary;

	@ManyToOne(fetch = FetchType.LAZY) // argument is optional but must be recommended
	@JoinColumn(name = "department")
	private Department department;

//	private int departmentId; // ?

	public Employee() {
		super();
	}

	public Employee(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

	public Employee(int id, String name, double salary, Department department) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.department = department;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", department=" + department + "]";
	}

}

//package com.deloitte.demo.model;
//
//import jakarta.persistence.*;
//
//@Entity // mandatory - remove and see // tells JPA to treat this class as entity
//
//@Table(name = "employee") // change the name e.g. deloitte_employee and see on workbench // optional but
//							// recommended
//
//public class Employee {
//
//	@Id // mandatory // shows PK column name
//
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	// insert PK values automatically
//	// remobve and see
//
//	@Column(name = "id") // optional
//	private int id;
//
//	// find out other annotations - 
////	@
//	private String name;
//
//	private double salary;
//
//	public Employee() {
//		super();
//	}
//
//	public Employee(String name, double salary) {
//		super();
//		this.name = name;
//		this.salary = salary;
//	}
//
//	public int getId() {
//		return id;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public double getSalary() {
//		return salary;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public void setSalary(double salary) {
//		this.salary = salary;
//	}
//
//	@Override
//	public String toString() {
//		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
//	}
//}