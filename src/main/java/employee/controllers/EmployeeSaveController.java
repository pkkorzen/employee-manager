package employee.controllers;

import employee.dto.EmployeeDto;
import employee.entities.Position;
import employee.services.EmployeeServiceImpl;
import employee.services.EmployeeService;
import employee.services.PositionService;
import employee.services.PositionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EmployeeSaveController", value="/employee/save")
public class EmployeeSaveController extends HttpServlet {

    private EmployeeService employeeService = new EmployeeServiceImpl();
    private PositionService positionService = new PositionServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String positionName = request.getParameter("positionName");
        Position position = positionService.getPositionByName(positionName);
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName(name);
        employeeDto.setSurname(surname);
        employeeDto.setPositionName(positionName);
        employeeDto.setSalary(position.getSalary());
        employeeDto.setPositionId(position.getPositionId());

        if(!id.equals("")){
            employeeDto.setId(Integer.parseInt(id));
        }

        employeeService.saveEmployee(employeeDto);
        response.sendRedirect("/employees");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
