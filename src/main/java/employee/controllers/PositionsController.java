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
import java.util.List;

@WebServlet(name = "PositionsController", value="/positions")
public class PositionsController extends HttpServlet {
    private PositionService positionService = new PositionServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Position> positions = positionService.getPositions();

        request.setAttribute("positions", positions);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/positions/positions.jsp");
        requestDispatcher.forward(request,response);
    }
}
