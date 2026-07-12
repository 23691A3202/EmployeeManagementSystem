package backend;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

public class DeleteEmployeeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Access-Control-Allow-Origin", "*");

        String idParam = request.getParameter("id");
        if (idParam == null || idParam.trim().isEmpty()) {
            response.getWriter().print("{\"success\":false,\"message\":\"Missing employee ID\"}");
            return;
        }
        try {
            int id = Integer.parseInt(idParam.trim());

            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("DELETE FROM employees WHERE id=?");
            ps.setInt(1, id);

            int rows = ps.executeUpdate();
            ps.close(); con.close();

            if (rows > 0) {
                response.getWriter().print("{\"success\":true,\"message\":\"Employee deleted successfully\"}");
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
