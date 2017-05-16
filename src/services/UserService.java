package services;

import entities.User;

import javax.persistence.*;

public class UserService {

    private EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("persistence");
    private EntityManager entityManager = managerFactory.createEntityManager();

    public User login(String email, String password) {
        try {
            TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u WHERE u.email = :email AND u.password = :password", User.class);
            query.setParameter("email", email);
            query.setParameter("password", password);
            return query.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }

    public void addUser(String firstName, String lastName, String email, String password, int role) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);
        user.setRole(role);

        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();

        entityManager.close();
        managerFactory.close();
    }
}
