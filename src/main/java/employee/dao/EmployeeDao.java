package employee.dao;

import employee.entities.Employee;

import java.util.List;

public interface EmployeeDao {
    Employee getEmployeeById(int id);
    List<Employee> getEmployees();
    void addEmployee(Employee employee);
    void editEmployee(Employee employee);
    void removeEmployee(int id);
}
