package employee.services;

import employee.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto getEmployeeById(int id);
    List<EmployeeDto> getEmployees();
    void saveEmployee(EmployeeDto employeeDto);
    void removeEmployee(int id);

}
