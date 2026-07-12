# Employee Management System

A full-stack Employee Management System developed using **Java, Servlets, JDBC, MySQL, Apache Tomcat, Maven, HTML, CSS, and JavaScript**. The application enables efficient employee record management through a responsive web interface with database integration and dashboard analytics.

---

## Features

### Employee Management
- Add Employee
- View Employee Records
- Update Employee Details
- Delete Employee Records
- Search Employee by ID
- Search Employee by Department

### Dashboard & Analytics
- Total Employees
- Total Departments
- Highest Salary
- Lowest Salary
- Average Salary
- Employee Statistics Dashboard

### User Interface
- Responsive Dashboard
- Professional Sidebar Navigation
- Employee Management Forms
- Search Functionality
- Statistics Cards
- Modern UI Design

### Database Integration
- MySQL Database Connectivity
- Real-Time Data Storage
- JDBC-Based CRUD Operations
- Persistent Employee Records

---

## Technologies Used

### Backend
- Java
- Java Servlets
- JDBC

### Frontend
- HTML5
- CSS3
- JavaScript

### Database
- MySQL

### Server
- Apache Tomcat 9

### Build Tool
- Maven

### Version Control
- Git
- GitHub

### IDE
- IntelliJ IDEA
- VS Code

---

## Project Structure

```text
EmployeeManagementSystem
│
├── src
│   └── main
│       ├── java
│       │   └── backend
│       │       ├── DBConnection.java
│       │       ├── Employee.java
│       │       ├── EmployeeDAO.java
│       │       ├── UserDAO.java
│       │       └── Main.java
│       │
│       └── webapp
│           ├── index.html
│           ├── addEmployee.html
│           ├── employeeList.html
│           ├── searchEmployee.html
│           ├── updateEmployee.html
│           ├── deleteEmployee.html
│           ├── employeeStats.html
│           ├── style.css
│           ├── script.js
│           └── WEB-INF
│               └── web.xml
│
├── pom.xml
├── README.md
└── target
```

---

## Database Setup

### Create Database

```sql
CREATE DATABASE employee_db;
USE employee_db;
```

### Create Employees Table

```sql
CREATE TABLE employees (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    department VARCHAR(100),
    salary DOUBLE
);
```

---

## How to Run

### 1. Clone Repository

```bash
git clone https://github.com/23691A3202/EmployeeManagementSystem.git
```

### 2. Open Project

Open the project in IntelliJ IDEA or VS Code.

### 3. Configure Database

Update your database credentials in:

```java
DBConnection.java
```

### 4. Build Project

```bash
mvn clean package
```

### 5. Deploy WAR File

After a successful build:

```text
target/EmployeeManagementSystem.war
```

Copy the WAR file to:

```text
apache-tomcat-9/webapps/
```

### 6. Start Apache Tomcat

```bash
startup.bat
```

### 7. Open Application

```text
http://localhost:8080/EmployeeManagementSystem
```

---

## Key Functionalities

### Add Employee
- Insert employee details into MySQL database

### View Employees
- Display all employee records

### Update Employee
- Modify employee information

### Delete Employee
- Remove employee records safely

### Search Employee
- Search by Employee ID
- Search by Department

### Dashboard Statistics
- Total Employees
- Highest Salary
- Lowest Salary
- Average Salary

---

## Maven Integration

This project uses Maven for:

- Dependency Management
- Build Automation
- WAR File Generation
- Tomcat Deployment Support

Build Command:

```bash
mvn clean package
```

---

## Apache Tomcat Integration

The application is deployed on Apache Tomcat 9 and supports:

- WAR Deployment
- Servlet Execution
- Dynamic Web Pages
- Database Connectivity

---

## Learning Outcomes

This project demonstrates:

- Core Java Programming
- Object-Oriented Programming (OOP)
- JDBC Connectivity
- MySQL Database Operations
- CRUD Operations
- Java Servlets
- Apache Tomcat Deployment
- Maven Project Management
- Frontend Development
- Git & GitHub Version Control

---

## Future Enhancements

- Spring Boot Migration
- REST API Development
- Role-Based Access Control
- JWT Authentication
- Department Management
- Cloud Deployment (AWS)

---

## Author

**Shaik Abubakar Siddiq**

Computer Science Student | Java Developer | Full Stack Development Enthusiast

GitHub: https://github.com/23691A3202

Project Repository:
https://github.com/23691A3202/EmployeeManagementSystem

---

⭐ If you found this project useful, consider giving it a Star on GitHub.
