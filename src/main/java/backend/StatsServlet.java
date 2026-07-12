package backend;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class StatsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Access-Control-Allow-Origin", "*");

        PrintWriter out = response.getWriter();

        try {
            Connection con = DBConnection.getConnection();

            // Aggregate stats
            PreparedStatement ps1 = con.prepareStatement(
                "SELECT COUNT(*) AS total, COUNT(DISTINCT department) AS depts, " +
                "MAX(salary) AS maxSal, MIN(salary) AS minSal, AVG(salary) AS avgSal FROM employees");
            ResultSet rs1 = ps1.executeQuery();
            int total = 0, depts = 0;
            double maxSal = 0, minSal = 0, avgSal = 0;
            if (rs1.next()) {
                total  = rs1.getInt("total");
                depts  = rs1.getInt("depts");
                maxSal = rs1.getDouble("maxSal");
                minSal = rs1.getDouble("minSal");
                avgSal = rs1.getDouble("avgSal");
            }
            rs1.close(); ps1.close();

            // Department distribution
            PreparedStatement ps2 = con.prepareStatement(
                "SELECT department, COUNT(*) AS cnt FROM employees GROUP BY department ORDER BY cnt DESC");
            ResultSet rs2 = ps2.executeQuery();
            StringBuilder deptLabels = new StringBuilder("[");
            StringBuilder deptData   = new StringBuilder("[");
            boolean first = true;
            while (rs2.next()) {
                if (!first) { deptLabels.append(","); deptData.append(","); }
                deptLabels.append("\"").append(escape(rs2.getString("department"))).append("\"");
                deptData.append(rs2.getInt("cnt"));
                first = false;
            }
            deptLabels.append("]"); deptData.append("]");
            rs2.close(); ps2.close();

            // Salary buckets
            PreparedStatement ps3 = con.prepareStatement(
                "SELECT " +
                "SUM(CASE WHEN salary < 30000 THEN 1 ELSE 0 END) AS b1," +
                "SUM(CASE WHEN salary >= 30000 AND salary < 60000 THEN 1 ELSE 0 END) AS b2," +
                "SUM(CASE WHEN salary >= 60000 AND salary < 100000 THEN 1 ELSE 0 END) AS b3," +
                "SUM(CASE WHEN salary >= 100000 THEN 1 ELSE 0 END) AS b4 FROM employees");
            ResultSet rs3 = ps3.executeQuery();
            int b1=0, b2=0, b3=0, b4=0;
            if (rs3.next()) {
                b1 = rs3.getInt("b1"); b2 = rs3.getInt("b2");
                b3 = rs3.getInt("b3"); b4 = rs3.getInt("b4");
            }
            rs3.close(); ps3.close();
            con.close();

            out.print("{" +
                "\"total\":"       + total + "," +
                "\"departments\":" + depts + "," +
                "\"maxSalary\":"   + String.format("%.2f", maxSal) + "," +
                "\"minSalary\":"   + String.format("%.2f", minSal) + "," +
                "\"avgSalary\":"   + String.format("%.2f", avgSal) + "," +
                "\"deptLabels\":"  + deptLabels + "," +
                "\"deptData\":"    + deptData + "," +
                "\"salaryBuckets\":[" + b1 + "," + b2 + "," + b3 + "," + b4 + "]" +
                "}");

        } catch (Exception e) {
            e.printStackTrace();
            out.print("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }

    private String escape(String s) {
        if (s == null) return "";
        return s.replace("\\", "\\\\").replace("\"", "\\\"");
    }
}
