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
import java.util.List;

@WebServlet(name = "EmployeesController", value="/employees")
public class EmployeesController extends HttpServlet {

    private EmployeeService employeeService = new EmployeeServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> employees = employeeService.getEmployees();

        request.setAttribute("employees", employees);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/employees/employees.jsp");
        requestDispatcher.forward(request,response);
    }
}
