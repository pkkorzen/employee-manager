package employee.services;

import employee.dao.EmployeeDao;
import employee.dao.EmployeeDaoImpl;
import employee.entities.Employee;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    EmployeeDao employeeDao = new EmployeeDaoImpl();
    @Override
    public Employee getEmployeeById(int id) {
        return employeeDao.getEmployeeById(id);
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeDao.getEmployees();
    }

    @Override
    public void saveEmployee(Employee employee) {
        if(employee.getId()==0){
            employeeDao.addEmployee(employee);
        } else {
            employeeDao.editEmployee(employee);
        }
    }

    @Override
    public void removeEmployee(int id) {
        employeeDao.removeEmployee(id);
    }
}
