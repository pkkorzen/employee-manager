package employee.controllers;

import employee.entities.Position;
import employee.services.PositionService;
import employee.services.PositionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PositionSaveController", value="/position/save")
public class PositionSaveController extends HttpServlet {
    private PositionService positionService = new PositionServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("positionId");
        String name = request.getParameter("positionName");
        String salary = request.getParameter("salary");
        Position position = new Position();
        position.setPositionName(name);
        int positionSalary = 0;
        try {
            positionSalary = Integer.parseInt(salary);
        } catch (NumberFormatException ex) {
            System.out.println("Salary should be int value ");
        }
        position.setSalary(positionSalary);
        if(!id.equals("")){
            position.setPositionId(Integer.parseInt(id));
        }
        positionService.savePosition(position);
        response.sendRedirect("/positions");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
