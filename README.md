<<<<<<< HEAD
# EmployeeManagementSystem
=======
# Employee Management System

A Java-based Employee Management System developed using **Java, JDBC, MySQL, HTML, CSS, and JavaScript**. The application allows users to manage employee records with CRUD operations and various employee management features.

---

## Features

### Authentication
- User Login System
- Validates username and password before accessing the system

### Employee Management
- Add Employee
- View All Employees
- Update Employee Salary
- Delete Employee by ID
- Search Employee by ID
- Search Employees by Department

### Reports & Analytics
- Count Total Employees
- Find Highest Salary Employee
- Find Lowest Salary Employee
- Calculate Average Salary
- Sort Employees by Salary

### Frontend
- Dashboard Home Page
- Add Employee Page
- Employee List Page
- Search Employee Page
- Update Employee Page
- Delete Employee Page
- Employee Statistics Page

---

## Technologies Used

### Backend
- Java
- JDBC
- MySQL

### Frontend
- HTML5
- CSS3
- JavaScript

### Database
- MySQL

### Tools
- VS Code
- Git & GitHub
- MySQL Connector/J

---

## Project Structure

```text
EmployeeManagementSystem
│
├── backend
│   ├── DBConnection.java
│   ├── Employee.java
│   ├── EmployeeDAO.java
│   ├── UserDAO.java
│   └── Main.java
│
├── frontend
│   ├── index.html
│   ├── addEmployee.html
│   ├── employeeList.html
│   ├── searchEmployee.html
│   ├── updateEmployee.html
│   ├── deleteEmployee.html
│   ├── employeeStats.html
│   ├── style.css
│   └── script.js
│
└── lib
    └── mysql-connector-j-9.7.0.jar
```

---

## Database Configuration

Create a database:

```sql
CREATE DATABASE employee_db;
USE employee_db;
```

Create employees table:

```sql
CREATE TABLE employees (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    department VARCHAR(100),
    salary DOUBLE
);
```

Create users table:

```sql
CREATE TABLE users (
    username VARCHAR(50),
    password VARCHAR(50)
);
```

Insert login credentials:

```sql
INSERT INTO users VALUES ('admin', 'admin123');
```

---

## How to Run

### Clone Repository

```bash
git clone https://github.com/23691A3202/EmployeeManagementSystem.git
```

### Open Project

Open the project in VS Code.

### Configure Database

Update database credentials in:

```java
DBConnection.java
```

```java
String url = "jdbc:mysql://localhost:3306/employee_db";
String username = "root";
String password = "system";
```

### Run Application

Execute:

```java
Main.java
```

---

## Future Enhancements

- Spring Boot Integration
- REST APIs
- Employee Profile Management
- Department Management
- Web-Based Dashboard
- Role-Based Authentication
- Cloud Deployment

---

## Learning Outcomes

This project demonstrates:

- Core Java Programming
- JDBC Connectivity
- MySQL Database Operations
- CRUD Operations
- Object-Oriented Programming
- Frontend Development
- Git & GitHub Version Control

---

## Author

**Shaik Abubakar Siddiq**

Computer Science Student | Java Developer | Full Stack Development Enthusiast

GitHub: https://github.com/23691A3202
