package employee.dao;

import employee.entities.Position;
import employee.utils.EntityManagerUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class PositionDaoImpl implements PositionDao {
    @Override
    public Position getPositionById(int id) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        Query query = entityManager.createQuery("from Position where positionId=?1");
        query.setParameter(1, id);
        Position position = (Position)query.getSingleResult();
        entityManager.close();
        return position;
    }

    @Override
    public Position getPositionByName(String name) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        Query query = entityManager.createQuery("from Position where positionName=?1");
        query.setParameter(1, name);
        Position position = (Position)query.getSingleResult();
        entityManager.close();
        return position;
    }

    @Override
    public List<Position> getPositions() {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        Query query = entityManager.createQuery("from Position");
        List<Position> positions = query.getResultList();
        entityManager.close();
        return positions;
    }

    @Override
    public void addPosition(Position position) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        entityManager.getTransaction().begin();
        Position position1 = new Position();
        position1.setSalary(position.getSalary());
        position1.setPositionName(position.getPositionName());
        entityManager.persist(position1);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void editPosition(Position position) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("update Position set positionName=:positionName, salary=:salary where positionId=:positionId");
        query.setParameter("salary", position.getSalary());
        query.setParameter("positionName", position.getPositionName());
        query.setParameter("positionId", position.getPositionId());
        query.executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void removePosition(int id) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("delete from Position where positionId=?1");
        query.setParameter(1, id);
        query.executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
