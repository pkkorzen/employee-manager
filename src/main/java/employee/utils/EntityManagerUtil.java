package employee.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {
    private static EntityManagerUtil instance = new EntityManagerUtil();
    private EntityManagerFactory entityManagerFactory;

    private EntityManagerUtil(){
        entityManagerFactory = Persistence.createEntityManagerFactory("sqlite3");
    }
    public static EntityManagerUtil getInstance(){
        return instance;
    }
    public static EntityManager getEntityManager(){
        EntityManager entityManager = getInstance().entityManagerFactory.createEntityManager();
        return entityManager;
    }

}
