package employee.services;

import employee.dao.EmployeeDao;
import employee.dao.EmployeeDaoImpl;
import employee.dao.PositionDao;
import employee.dao.PositionDaoImpl;
import employee.dto.EmployeeDto;
import employee.entities.Position;
import employee.entities.Employee;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeServiceImpl implements EmployeeService {

    EmployeeDao employeeDao = new EmployeeDaoImpl();
    private EmployeeDtoConverter employeeDtoConverter = new EmployeeDtoConverter();

    @Override
    public EmployeeDto getEmployeeById(int id) {
        Employee employee = employeeDao.getEmployeeById(id);
        EmployeeDto employeeDto = employeeDtoConverter.convert(employee);
        return employeeDto;
    }

    @Override
    public List<EmployeeDto> getEmployees() {
        List<Employee> employeeDtos = employeeDao.getEmployees();
        return employeeDtos.stream()
                .map(employee -> employeeDtoConverter.convert(employee))
                .collect(Collectors.toList());
    }

    @Override
    public void saveEmployee(EmployeeDto employeeDto) {
        if(employeeDto.getId()==0) {
            employeeDao.addEmployee(employeeDtoConverter.convert(employeeDto));
        } else {
            employeeDao.editEmployee(employeeDtoConverter.convert(employeeDto));
        }
    }

    @Override
    public void removeEmployee(int id) {
        employeeDao.removeEmployee(id);
    }

    private class EmployeeDtoConverter {
        PositionDao postionDao = new PositionDaoImpl();

        public EmployeeDto convert (Employee employee){
            EmployeeDto employeeDto = new EmployeeDto(employee.getName(), employee.getSurname(),
                    employee.getPosition().getSalary(), employee.getPosition().getPositionName(), employee.getPosition().getPositionId());
            if (employee.getId()!=0){
                employeeDto.setId(employee.getId());
            }
            return employeeDto;
        }

        public Employee convert (EmployeeDto employeeDto){
            Employee employee = new Employee();
            employee.setName(employeeDto.getName());
            employee.setSurname(employeeDto.getSurname());
            Position position = postionDao.getPositionById(employeeDto.getPositionId());
            employee.setPosition(position);
            if (employeeDto.getId()!=0){
                employee.setId(employeeDto.getId());
            }
            return employee;
        }

    }
}
