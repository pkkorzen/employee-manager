package employee.services;

import employee.entities.Employee;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class EmployeeServiceImplTest {

    EmployeeService employeeService = new EmployeeServiceImpl();

    @Test
    public void shouldFindEmployeeById() {
        Employee employee = employeeService.getEmployeeById(1);
        assertEquals("jan", employee.getName());
    }

    @Test
    public void shouldFindAllEmployees() {
        List<Employee> employees = employeeService.getEmployees();
        assertEquals(7, employees.size());
    }

    @Test
    public void shouldUpdateEmployee() {
        Employee employee = employeeService.getEmployeeById(2);
        employee.setSalary(3000);
        employeeService.saveEmployee(employee);
        assertEquals(3000, employeeService.getEmployeeById(2).getSalary());
    }

    @Test
    public void shouldAddEmployee() {
        Employee employee = new Employee();
        employee.setSurname("Kaczmarczyk");
        employee.setName("Michał");
        employee.setSalary(2500);
        employeeService.saveEmployee(employee);
        List<Employee> employees = employeeService.getEmployees();
        int lastEmployeeIndex = employees.size()-1;
        assertEquals("Michał", employees.get(lastEmployeeIndex).getName());
    }

    @Test
    public void shouldRemoveEmployee() {
        List<Employee> employees = employeeService.getEmployees();
        int lastEmployeeIndex = employees.size()-1;
        Employee employee = employees.get(lastEmployeeIndex);
        employeeService.removeEmployee(employee.getId());
        assertEquals(lastEmployeeIndex, employeeService.getEmployees().size());
    }

    @Test(expected = NumberFormatException.class)
    public void shouldThrowNumberFormatExceptionWhenIdIsNotAProperNumber() {
        List<Employee> employees = employeeService.getEmployees();
        int lastEmployeeIndex = employees.size()-1;
        Employee employee = employees.get(lastEmployeeIndex);
        employeeService.removeEmployee(employee.getId());

    }

}