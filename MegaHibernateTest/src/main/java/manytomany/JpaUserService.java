package manytomany;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUserService {
package manytomany;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

    public class JpaUserService {

        private final EntityManagerFactory emf;
        private final EntityManager em;

        public JpaUserService() {
            emf = Persistence.createEntityManagerFactory("mysql");
            em = emf.createEntityManager();
        }

        public void add(User user) {

            em.getTransaction().begin();
            em.persist(user);
            for (Chat chat : user.getChatList()) {
                em.persist(chat);
            }

            em.getTransaction().commit();
        }

        public void close() {
            em.close();
        }

    }
    private final EntityManagerFactory emf;
    private final EntityManager em;

    public JpaUserService() {
        emf = Persistence.createEntityManagerFactory("mysql");
        em = emf.createEntityManager();
    }

    public void add(User user) {

        em.getTransaction().begin();
        em.persist(user);
        for (Chat chat : user.getChatList()) {
            em.persist(chat);
        }

        em.getTransaction().commit();
    }

    public void close() {
        em.close();
    }

}
