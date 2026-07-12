package backend;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class EmployeeDAO {

    public void addEmployee(Employee emp) {

        System.out.println("EmployeeDAO Started");

        String sql = "INSERT INTO employees(id, name, department, salary) VALUES (?, ?, ?, ?)";

        try {
            Connection con = DBConnection.getConnection();

            if (con == null) {
                System.out.println("Connection is NULL");
                return;
            }

            System.out.println("Database Connected");

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, emp.getId());
            ps.setString(2, emp.getName());
            ps.setString(3, emp.getDepartment());
            ps.setDouble(4, emp.getSalary());

            int rows = ps.executeUpdate();

            System.out.println("Rows inserted = " + rows);

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}