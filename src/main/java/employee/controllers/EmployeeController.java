package employee.controllers;

import employee.entities.Employee;
import employee.services.EmployeeService;
import employee.services.EmployeeServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EmployeeController", value = "/employee")
public class EmployeeController extends HttpServlet {
    private EmployeeService employeeService = new EmployeeServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        int employeeId = 0;
        try {
            employeeId = Integer.parseInt(id);
        } catch (NumberFormatException ex) {
            System.out.println("Employee id should be int value ");
        }

        Employee employee = employeeService.getEmployeeById(employeeId);
        request.setAttribute("employee", employee);
        request.setAttribute("h2Text", "Edit employee");

        RequestDispatcher requestDispatcher =request.getRequestDispatcher("/employees/employee.jsp");
        requestDispatcher.forward(request,response);
    }
}
