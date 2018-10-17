package employee.services;

import employee.dto.EmployeeDto;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class EmployeeServiceImplTest {
    EmployeeService employeeService = new EmployeeServiceImpl();

    @Test
    public void shouldFindEmployeeById() {
        EmployeeDto employeeDto = employeeService.getEmployeeById(52);
        assertEquals("Jan", employeeDto.getName());
    }

    @Test
    public void shouldFindAllEmployees() {
        List<EmployeeDto> employeeDtos = employeeService.getEmployees();
        assertEquals(6, employeeDtos.size());
    }

    @Test
    public void shouldUpdateEmployee() {
        EmployeeDto employeeDto = employeeService.getEmployeeById(52);
        employeeDto.setSurname("Burda");
        employeeService.saveEmployee(employeeDto);
        assertEquals("Burda", employeeService.getEmployeeById(52).getSurname());
    }

    @Test
    public void shouldAddEmployee() {
        int before = employeeService.getEmployees().size();
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("Albert");
        employeeDto.setSurname("Janczyk");
        employeeDto.setPositionId(1);
        employeeService.saveEmployee(employeeDto);
        int after = employeeService.getEmployees().size();
        assertEquals(before, after-1);
    }

    @Test
    public void shouldRemoveEmployee() {
        List<EmployeeDto> employeeDtos = employeeService.getEmployees();
        int lastIndex = employeeDtos.size()-1;
        EmployeeDto employeeDto = employeeDtos.get(lastIndex);
        employeeService.removeEmployee(employeeDto.getId());
        int after = employeeService.getEmployees().size();
        assertEquals(lastIndex, after);
    }

}