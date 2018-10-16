package employee.utils;

import org.junit.Test;

import javax.persistence.EntityManager;

import static org.junit.Assert.*;

public class EntityManagerUtilTest {

    private EntityManagerUtil entityManagerUtil;
    private EntityManager entityManager;

    @Test
    public void shouldReturnEntityManagerUtilInstance() {
        entityManagerUtil = EntityManagerUtil.getInstance();
        assertNotNull(entityManagerUtil);
    }

    @Test
    public void shouldReturnEntityManager() {
        entityManager = EntityManagerUtil.getEntityManager();
        assertNotNull(entityManager);
    }
}