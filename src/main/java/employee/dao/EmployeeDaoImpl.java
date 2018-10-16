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
        entityManager.getEntityManagerFactory().close();
        entityManager.close();
        return employee;
    }

    @Override
    public List<Employee> getEmployees() {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        Query query = entityManager.createQuery("from Employee");
        List<Employee> employees = query.getResultList();
        entityManager.getEntityManagerFactory().close();
        entityManager.close();
        return employees;
    }

    @Override
    public void addEmployee(Employee employee) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        entityManager.getTransaction().begin();
        Employee employee1 = new Employee();
        employee1.setName(employee.getName());
        employee1.setSalary(employee.getSalary());
        entityManager.persist(employee1);
        entityManager.getTransaction().commit();
        entityManager.getEntityManagerFactory().close();
        entityManager.close();
    }

    @Override
    public void editEmployee(Employee employee) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("update Employee set name=:name, salary=:salary where id=:id");
        query.setParameter("name", employee.getName());
        query.setParameter("salary", employee.getSalary());
        query.setParameter("id", employee.getId());
        query.executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.getEntityManagerFactory().close();
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
        entityManager.getEntityManagerFactory().close();
        entityManager.close();
    }
}
