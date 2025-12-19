package com.deloitte.demo;

import java.util.List;
import java.util.Scanner;

import com.deloitte.demo.model.Employee;
import com.deloitte.demo.service.EmployeeService;
import com.deloitte.demo.util.JPAUtil;

/**
 * 
 * 
 * @author Vaman Rao Deshmukh
 * 
 */

public class App {

	public static void main(String[] args) {

		EmployeeService service = new EmployeeService();
		Scanner sc = new Scanner(System.in);
		int choice;

		do {
			System.out.println("\n==== Employee Management System ====");
			System.out.println("1. Add Employee");
			System.out.println("2. View Employee by ID");
			System.out.println("3. View All Employees");
			System.out.println("4. Update Employee");
			System.out.println("5. Delete Employee");
			System.out.println("6. Exit");
			System.out.print("Enter choice: ");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.print("Enter name: ");
				sc.nextLine();
				String name = sc.nextLine();
				System.out.print("Enter salary: ");
				double salary = sc.nextDouble();
				service.addEmployee(name, salary);
				System.out.println("Employee added");
				break;

			case 2:
				System.out.print("Enter ID: ");
				int id = sc.nextInt();
				Employee emp = service.getEmployeeById(id);
				System.out.println(emp != null ? emp : "Employee not found");
				break;

			case 3:
				List<Employee> list = service.getAllEmployees();
				list.forEach(System.out::println);
				break;

			case 4:
				System.out.print("Enter ID: ");
				id = sc.nextInt();
				System.out.print("Enter new name: ");
				sc.nextLine();
				name = sc.nextLine();
				System.out.print("Enter new salary: ");
				salary = sc.nextDouble();
				service.updateEmployee(id, name, salary);
				System.out.println("Employee updated");
				break;

			case 5:
				System.out.print("Enter ID: ");
				id = sc.nextInt();
				service.deleteEmployee(id);
				System.out.println("Employee deleted");
				break;

			case 6:
				System.out.println("Exiting...");
				JPAUtil.close();
				break;

			default:
				System.out.println("Invalid choice");
			}

		} while (choice != 6);

		sc.close();
	}
}