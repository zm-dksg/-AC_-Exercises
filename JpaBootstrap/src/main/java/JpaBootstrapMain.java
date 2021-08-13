import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaBootstrapMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
        EntityManager em = emf.createEntityManager();

        System.out.println("Result: " + em.createNativeQuery("SELECT 1+1").getSingleResult());

        int id = 1;

        Movie treasurePlanet = new Movie();
        treasurePlanet.setId(id++);
        treasurePlanet.setTitle("Treasure Planet");
        treasurePlanet.setDirector("Ron Clements");
        treasurePlanet.setRating(10);

        Movie toyStory = new Movie();
        toyStory.setId(id);
        toyStory.setTitle("Toy Story");
        toyStory.setDirector("John Lasseter");
        toyStory.setRating(10);

        em.getTransaction().begin();
        em.persist(treasurePlanet);
        em.persist(toyStory);
        em.getTransaction().commit();
    }

}
