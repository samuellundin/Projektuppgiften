package services;

import entities.UserGroup;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by josef on 5/10/2017.
 */
public class UserGroupService {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
    EntityManager entityManager = emf.createEntityManager();

    public void addUserGroup(String name){
        UserGroup userGroup = new UserGroup();
        userGroup.setUser(name);
        entityManager.getTransaction().begin();
        entityManager.persist(userGroup);
        entityManager.getTransaction().commit();

        entityManager.close();
        emf.close();

    }
}
