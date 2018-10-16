package employee.controllers;

import employee.services.EmployeeService;
import employee.services.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EmployeeDeleteController", value="/employee/delete")
public class EmployeeDeleteController extends HttpServlet {

    private EmployeeService employeeService = new EmployeeServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        int employeeId = 0;
        try {
            employeeId = Integer.parseInt(id);
        } catch (NumberFormatException ex) {
            System.out.println("Employee id should be int value ");
        }
        employeeService.removeEmployee(employeeId);
        response.sendRedirect("/employees");
    }
}
