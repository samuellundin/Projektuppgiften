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

    public void deleteUserGroup(int userGroupId){
        UserGroup userGroup = entityManager.find(UserGroup.class, userGroupId);
        entityManager.getTransaction().begin();
        entityManager.remove(userGroup);
        entityManager.getTransaction().commit();
    }

    public void updateUserGroup(int userGroupId ,String name, ObservableList<User> observableChosen){

        List<User> userList = new ArrayList<>();
        for(User user: observableChosen){
            userList.add(user);
        }

        UserGroup userGroup = entityManager.find(UserGroup.class, userGroupId);
        entityManager.getTransaction().begin();
        userGroup.setUserList(userList);
        userGroup.setUser(name);
        entityManager.getTransaction().commit();

    }

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
