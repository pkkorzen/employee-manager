package employee.services;

import employee.entities.Employee;

import java.util.List;

public interface EmployeeService {
    Employee getEmployeeById(int id);
    List<Employee> getEmployees();
    void saveEmployee(Employee employee);
    void removeEmployee(int id);

}
