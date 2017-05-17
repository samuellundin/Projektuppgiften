
package services;

import entities.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

/**
 * Created by Leon on 2017-05-11.
 */

public class SettingsService {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
    EntityManager entityManager = emf.createEntityManager();

    public void settings(String currentPassword, String newPassword, String confirmNewPassword) {

        User user = User.sessionUser;
        user.setPassword(currentPassword);
        user.setPassword(newPassword);
        user.setPassword(confirmNewPassword);

        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();

        entityManager.close();
        emf.close();

    }
}