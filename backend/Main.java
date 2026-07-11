package backend;
import java.util.Scanner;
public class Main{
public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    // Login System
    UserDAO userDAO = new UserDAO();

    System.out.println("===== Employee Management System Login =====");

    System.out.print("Username: ");
    String username = sc.nextLine();

    System.out.print("Password: ");
    String password = sc.nextLine();

    if (!userDAO.login(username, password)) {
        System.out.println("Invalid Login!");
        sc.close();
        return;
    }

    System.out.println("Login Successful!");

    EmployeeDAO dao = new EmployeeDAO();

    while (true) {

        System.out.println("\n===== Employee Management System =====");
        System.out.println("1. Add Employee");
        System.out.println("2. View Employees");
        System.out.println("3. Update Employee Salary");
        System.out.println("4. Delete Employee");
        System.out.println("5. Search Employee by ID");
        System.out.println("6. Count Total Employees");
        System.out.println("7. Highest Salary Employee");
        System.out.println("8. Lowest Salary Employee");
        System.out.println("9. Average Salary");
        System.out.println("10. Search by Department");
        System.out.println("11. Sort Employees by Salary");
        System.out.println("12. Exit");

        System.out.print("Enter Choice: ");
        int choice = sc.nextInt();

        switch (choice) {

            case 1:
                sc.nextLine();

                System.out.print("Enter Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Department: ");
                String dept = sc.nextLine();

                System.out.print("Enter Salary: ");
                double salary = sc.nextDouble();

                Employee emp = new Employee(name, dept, salary);

                dao.addEmployee(emp);
                break;

            case 2:
                dao.viewEmployees();
                break;

            case 3:
                System.out.print("Enter Employee ID: ");
                int updateId = sc.nextInt();

                System.out.print("Enter New Salary: ");
                double newSalary = sc.nextDouble();

                dao.updateSalary(updateId, newSalary);
                break;

            case 4:
                System.out.print("Enter Employee ID to Delete: ");
                int deleteId = sc.nextInt();

                dao.deleteEmployee(deleteId);
                break;

            case 5:
                System.out.print("Enter Employee ID: ");
                int searchId = sc.nextInt();

                dao.searchEmployee(searchId);
                break;

            case 6:
                dao.countEmployees();
                break;

            case 7:
                dao.highestSalaryEmployee();
                break;

            case 8:
                dao.lowestSalaryEmployee();
                break;

            case 9:
                dao.averageSalary();
                break;

            case 10:
                sc.nextLine();

                System.out.print("Enter Department: ");
                String department = sc.nextLine();

                dao.searchByDepartment(department);
                break;

            case 11:
                dao.sortBySalary();
                break;

            case 12:
                System.out.println("Thank You!");
                sc.close();
                System.exit(0);
                break;

            default:
                System.out.println("Invalid Choice!");
        }
    }
}
}