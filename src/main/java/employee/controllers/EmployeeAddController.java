package employee.controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EmployeeAddController", value = "/employee/add")
public class EmployeeAddController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("h2Text", "Add employee");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/employees/employee.jsp");
        requestDispatcher.forward(request, response);
    }
}
