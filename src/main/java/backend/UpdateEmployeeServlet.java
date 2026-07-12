package backend;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

public class UpdateEmployeeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Access-Control-Allow-Origin", "*");

        String idParam = request.getParameter("id");
        String name = request.getParameter("name");
        String department = request.getParameter("department");
        String salaryParam = request.getParameter("salary");

        if (idParam == null || idParam.trim().isEmpty() ||
            name == null || name.trim().isEmpty() ||
            department == null || department.trim().isEmpty() ||
            salaryParam == null || salaryParam.trim().isEmpty()) {
            response.getWriter().print("{\"success\":false,\"message\":\"Missing required fields\"}");
            return;
        }
        try {
            int id = Integer.parseInt(idParam.trim());
            double salary = Double.parseDouble(salaryParam.trim());

            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "UPDATE employees SET name=?, department=?, salary=? WHERE id=?");
            ps.setString(1, name.trim());
            ps.setString(2, department.trim());
            ps.setDouble(3, salary);
            ps.setInt(4, id);

            int rows = ps.executeUpdate();
            ps.close(); con.close();

            if (rows > 0) {
                response.getWriter().print("{\"success\":true,\"message\":\"Employee updated successfully\"}");
            } else {
                response.getWriter().print("{\"success\":false,\"message\":\"Employee not found\"}");
            }
        } catch (Exception e) {
            e.printStackTrace();
            String msg = e.getMessage() != null ? e.getMessage().replace("\"", "'") : "Server error";
            response.getWriter().print("{\"success\":false,\"message\":\"Error: " + msg + "\"}");
        }
    }
}
