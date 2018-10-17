package employee.dao;

import employee.entities.Employee;
import employee.utils.EntityManagerUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao{

    @Override
    public Employee getEmployeeById(int id) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        Query query = entityManager.createQuery("from Employee where id=?1");
        query.setParameter(1, id);
        Employee employee = (Employee)query.getSingleResult();
        entityManager.close();
        return employee;
    }

    @Override
    public List<Employee> getEmployees() {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        Query query = entityManager.createQuery("from Employee");
        List<Employee> employees = query.getResultList();
        entityManager.close();
        return employees;
    }

    @Override
    public void addEmployee(Employee employee) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        entityManager.getTransaction().begin();
        Employee employee1 = new Employee();
        employee1.setName(employee.getName());
        employee1.setSurname(employee.getSurname());
        if(employee.getPosition()!=null){
            employee1.setPosition(employee.getPosition());
        }
        entityManager.persist(employee1);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void editEmployee(Employee employee) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("update Employee set name=:name, surname=: surname, position=:position where id=:id");
        query.setParameter("name", employee.getName());
        query.setParameter("surname", employee.getSurname());
        query.setParameter("id", employee.getId());
        query.setParameter("position", employee.getPosition());
        query.executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void removeEmployee(int id) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("delete from Employee where id=?1");
        query.setParameter(1, id);
        query.executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
