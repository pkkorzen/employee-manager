package employee.controllers;

import employee.entities.Employee;
import employee.services.EmployeeService;
import employee.services.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EmployeeSaveController", value="/employee/save")
public class EmployeeSaveController extends HttpServlet {
    private EmployeeService employeeService = new EmployeeServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String salary = request.getParameter("salary");
        Employee employee = new Employee();
        employee.setName(name);
        employee.setSurname(surname);

        if(!salary.equals("")){
            int employeeSalary = 0;
            try {
                employeeSalary = Integer.parseInt(salary);
            } catch (NumberFormatException ex) {
                System.out.println("Employee id should be int value ");
            }
            employee.setSalary(employeeSalary);
        }

        if(!id.equals("")){
            employee.setId(Integer.parseInt(id));
        }
        employeeService.saveEmployee(employee);
        response.sendRedirect("/employees");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
