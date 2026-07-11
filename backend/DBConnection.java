package backend;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {

        try {

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/employee_db",
                    "root",
                    "system"
            );

            System.out.println("Database Connected Successfully!");
            return con;

        } catch (Exception e) {

            System.out.println("Connection Failed!");
            e.printStackTrace();
        }

        return null;
    }
}