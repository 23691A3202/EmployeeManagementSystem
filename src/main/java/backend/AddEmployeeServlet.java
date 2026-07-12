package backend;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddEmployeeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String department = request.getParameter("department");
        double salary = Double.parseDouble(request.getParameter("salary"));

        Employee emp = new Employee(id, name, department, salary);
        EmployeeDAO dao = new EmployeeDAO();
        dao.addEmployee(emp);

        response.setContentType("text/html");
        response.getWriter().println(
            "<h2>Employee Added Successfully!</h2>"
            + "<br>"
            + "<a href='addEmployee.html'>Add Another Employee</a>"
        );
    }
}
