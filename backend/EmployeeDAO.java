package backend;

import java.sql.*;

public class EmployeeDAO {

    public void addEmployee(Employee emp) {

        try {

            Connection con = DBConnection.getConnection();

            String query = "INSERT INTO employees(name, department, salary) VALUES(?,?,?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, emp.getName());
            ps.setString(2, emp.getDepartment());
            ps.setDouble(3, emp.getSalary());

            ps.executeUpdate();

            System.out.println("Employee Added Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ADD THIS BELOW
    public void viewEmployees() {

        try {

            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM employees";

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println(
                        "ID: " + rs.getInt("id") +
                        " | Name: " + rs.getString("name") +
                        " | Department: " + rs.getString("department") +
                        " | Salary: " + rs.getDouble("salary")
              );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


public void deleteEmployee(int id) {

    try {

        Connection con = DBConnection.getConnection();

        String query = "DELETE FROM employees WHERE id = ?";

        PreparedStatement ps = con.prepareStatement(query);

        ps.setInt(1, id);

        int rows = ps.executeUpdate();

        if(rows > 0) {
            System.out.println("Employee Deleted Successfully!");
        } else {
            System.out.println("Employee ID Not Found!");
        }

    } catch(Exception e) {
        e.printStackTrace();
    }
}

public void updateSalary(int id, double salary) {

    try {

        Connection con = DBConnection.getConnection();

        String query = "UPDATE employees SET salary = ? WHERE id = ?";

        PreparedStatement ps = con.prepareStatement(query);

        ps.setDouble(1, salary);
        ps.setInt(2, id);

        int rows = ps.executeUpdate();

        if(rows > 0) {
            System.out.println("Salary Updated Successfully!");
        } else {
            System.out.println("Employee ID Not Found!");
        }

    } catch(Exception e) {
        e.printStackTrace();
    }
}

public void searchEmployee(int id) {

    try {

        Connection con = DBConnection.getConnection();

        String query = "SELECT * FROM employees WHERE id = ?";

        PreparedStatement ps = con.prepareStatement(query);

        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            System.out.println(
                rs.getInt("id") + " | " +
                rs.getString("name") + " | " +
                rs.getString("department") + " | " +
                rs.getDouble("salary")
            );

        } else {
            System.out.println("Employee Not Found!");
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}

public void countEmployees() {

    try {

        Connection con = DBConnection.getConnection();

        String query = "SELECT COUNT(*) FROM employees";

        PreparedStatement ps = con.prepareStatement(query);

        ResultSet rs = ps.executeQuery();

        if(rs.next()) {
            System.out.println("Total Employees: " + rs.getInt(1));
        }

    } catch(Exception e) {
        e.printStackTrace();
    }
}

public void highestSalaryEmployee() {

    try {

        Connection con = DBConnection.getConnection();

        String query =
                "SELECT * FROM employees ORDER BY salary DESC LIMIT 1";

        PreparedStatement ps = con.prepareStatement(query);

        ResultSet rs = ps.executeQuery();

        if(rs.next()) {

            System.out.println("Highest Salary Employee:");
            System.out.println(
                    rs.getInt("id") + " | " +
                    rs.getString("name") + " | " +
                    rs.getString("department") + " | " +
                    rs.getDouble("salary"));
        }

    } catch(Exception e) {
        e.printStackTrace();
    }
}

public void lowestSalaryEmployee() {

    try {

        Connection con = DBConnection.getConnection();

        String query =
                "SELECT * FROM employees ORDER BY salary ASC LIMIT 1";

        PreparedStatement ps = con.prepareStatement(query);

        ResultSet rs = ps.executeQuery();

        if(rs.next()) {

            System.out.println("Lowest Salary Employee:");
            System.out.println(
                    rs.getInt("id") + " | " +
                    rs.getString("name") + " | " +
                    rs.getString("department") + " | " +
                    rs.getDouble("salary"));
        }

    } catch(Exception e) {
        e.printStackTrace();
    }
}

public void averageSalary() {

    try {

        Connection con = DBConnection.getConnection();

        String query = "SELECT AVG(salary) FROM employees";

        PreparedStatement ps = con.prepareStatement(query);

        ResultSet rs = ps.executeQuery();

        if(rs.next()) {
            System.out.println(
                "Average Salary: " + rs.getDouble(1));
        }

    } catch(Exception e) {
        e.printStackTrace();
    }
}

public void searchByDepartment(String department) {

    try {

        Connection con = DBConnection.getConnection();

        String query =
                "SELECT * FROM employees WHERE department = ?";

        PreparedStatement ps = con.prepareStatement(query);

        ps.setString(1, department);

        ResultSet rs = ps.executeQuery();

        while(rs.next()) {

            System.out.println(
                    rs.getInt("id") + " | " +
                    rs.getString("name") + " | " +
                    rs.getString("department") + " | " +
                    rs.getDouble("salary"));
        }

    } catch(Exception e) {
        e.printStackTrace();
    }
}

public void sortBySalary() {

    try {

        Connection con = DBConnection.getConnection();

        String query =
                "SELECT * FROM employees ORDER BY salary DESC";

        PreparedStatement ps = con.prepareStatement(query);

        ResultSet rs = ps.executeQuery();

        while(rs.next()) {

            System.out.println(
                    rs.getInt("id") + " | " +
                    rs.getString("name") + " | " +
                    rs.getString("department") + " | " +
                    rs.getDouble("salary"));
        }

    } catch(Exception e) {
        e.printStackTrace();
    }
}
}