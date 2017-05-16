package services;

import entities.Test;

import javax.persistence.*;
import java.util.List;

public class TestService {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
    EntityManager entityManager = emf.createEntityManager();

    public void addTest(Test test){
        entityManager.getTransaction().begin();
        entityManager.persist(test);
        entityManager.getTransaction().commit();

        entityManager.close();
        emf.close();
    }

    public List<Test> getTest() {

        try {
            TypedQuery<Test> query = entityManager.createQuery("SELECT t FROM Test t", Test.class);

            return query.getResultList();

        } catch (NoResultException ex) {
            return null;

        }
    }
}
