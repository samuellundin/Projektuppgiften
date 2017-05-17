package services;

import entities.User;
import entities.UserGroup;
import javafx.collections.ObservableList;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by josef on 5/10/2017.
 */
public class UserGroupService {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
    EntityManager entityManager = emf.createEntityManager();

    public void addUserGroup(String name, ObservableList<User> observableChosen){
        UserGroup userGroup = new UserGroup();
        userGroup.setUser(name);

        List<User> userList = new ArrayList<>();
        userGroup.setUserList(userList);

        for(User user: observableChosen ){
            System.out.println(user.getFirstName());
            userGroup.getUserList().add(user);
        }


        entityManager.getTransaction().begin();
        entityManager.persist(userGroup);
        entityManager.getTransaction().commit();

        entityManager.close();
        emf.close();

    }

    public List<UserGroup> getAllUserGroups(){
        try {
            TypedQuery<UserGroup> query = entityManager.createQuery("SELECT g FROM UserGroup g", UserGroup.class);
            return query.getResultList();
        } catch (NoResultException ex) {
            return null;
        }
    }
}
