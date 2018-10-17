package employee.controllers;

import employee.entities.Position;
import employee.services.PositionService;
import employee.services.PositionServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PositionController", value="/position")
public class PositionController extends HttpServlet {
    private PositionService positionService = new PositionServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        int positionId = 0;
        try {
            positionId = Integer.parseInt(id);
        } catch (NumberFormatException ex) {
            System.out.println("Position id should be int value ");
        }

        Position position = positionService.getPositionByID(positionId);
        request.setAttribute("position", position);
        request.setAttribute("h2Text", "Edit position");

        RequestDispatcher requestDispatcher =request.getRequestDispatcher("/positions/position.jsp");
        requestDispatcher.forward(request,response);
    }
}
