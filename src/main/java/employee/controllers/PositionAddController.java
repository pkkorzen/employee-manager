package employee.controllers;

import employee.services.PositionService;
import employee.services.PositionServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PositionAddController", value="/position/add")
public class PositionAddController extends HttpServlet {
    private PositionService positionService = new PositionServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("h2Text", "Add position");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/positions/position.jsp");
        requestDispatcher.forward(request, response);
    }
}
