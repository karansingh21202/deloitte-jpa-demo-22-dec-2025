# deloitte-jpa-demo-22-dec-2025

JPA + Hibernate Maven Project 

JPA configuration using persistence.xml

Hibernate as JPA provider

CRUD operations

Layered architecture (model, service, util, main)

Menu-driven console application

This project is used as part of Deloitte VILT training to understand JPA & Hibernate fundamentals.

🧰 Tech Stack

Java 17+

Maven

JPA (Jakarta Persistence)

Hibernate ORM

MySQL

Console-based execution

🛠 Prerequisites

Before running the application, ensure:

Java is installed and configured (java -version)

Maven is installed (mvn -version)

MySQL Server is running

You know how to:

Import a Maven project

Run a Java main() class

🗄️ Database Setup

Start MySQL server

Create database:

CREATE DATABASE emsdb;

Update DB credentials in:

src/main/resources/META-INF/persistence.xml

<property name="jakarta.persistence.jdbc.user" value="root"/>
<property name="jakarta.persistence.jdbc.password" value="root"/>

⚙️ Hibernate Configuration Notes

Tables are auto-created on application startup

Controlled by this property in persistence.xml:

<property name="hibernate.hbm2ddl.auto" value="update"/>

▶️ How to Run the Application

Step 0: Import as maven project into eclipse 

Step 1: Build the project right click -> maven -> update project 

mvn clean install

Step 2: Run the App class


📋 Application Menu

Once the application starts, you will see:

==== Employee Management System ====
1. Add Employee
2. View Employee by ID
3. View All Employees
4. Update Employee
5. Delete Employee
6. Exit


Use the menu options to perform CRUD operations on employees.

🧪 Sample Operations

Add employee (name, salary)

Fetch employee by ID

View all employees

Update employee details

Delete employee

Exit application safely

🔍 Important Learning Concepts

This project demonstrates:

EntityManagerFactory vs EntityManager

JPA entity lifecycle

Persistence context

Hibernate auto DDL generation

Transactions and dirty checking

Layered Java application design

⚠️ Common Issues & Fixes
persistence.xml not found

Ensure the file is located at:

src/main/resources/META-INF/persistence.xml

🎯 Training Objective

By completing this project, trainees should be able to:

Configure JPA in Java Maven projects 

Understand Hibernate internals

Perform CRUD using EntityManager

Debug common JPA/Hibernate issues


