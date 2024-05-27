package services;

import dao.FilmyDao;
import entities.Filmy;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import java.util.List;

public class FilmyService implements FilmyDao {

    private EntityManagerFactory emf;

    public FilmyService() {
        emf = Persistence.createEntityManagerFactory("ApplicationPU");
    }

    @Override
    @Transactional
    public void save(Filmy filmy) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            if (filmy.getIdFilmy() == 0 || em.find(Filmy.class, filmy.getIdFilmy()) == null) {
                em.persist(filmy);
            } else {
                em.merge(filmy);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public Filmy findById(Long id) {
        EntityManager em = emf.createEntityManager();
        Filmy filmy = em.find(Filmy.class, id);
        em.close();
        return filmy;
    }

    @Override
    public List<Filmy> findAll() {
        EntityManager em = emf.createEntityManager();
        List<Filmy> result = em.createQuery("SELECT f FROM Filmy f", Filmy.class).getResultList();
        em.close();
        return result;
    }

    @Override
    @Transactional
    public void delete(Filmy filmy) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Filmy managedFilmy = em.merge(filmy); // Attach the entity to the current persistence context
            em.remove(managedFilmy); // Remove the attached entity
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Transactional
    public void performTransactionalOperations() {
        EntityManager em = emf.createEntityManager();
        try {
            // Begin transaction with isolation level REPEATABLE READ
            em.getTransaction().begin();
            em.createNativeQuery("SET TRANSACTION ISOLATION LEVEL REPEATABLE READ").executeUpdate();

            System.out.println("Transaction started with REPEATABLE READ isolation level.");

            // Perform updates as specified in CP-4
            System.out.println("Updating genre to 'Drama' for film with id 1.");
            em.createQuery("UPDATE Filmy SET zanr = 'Drama' WHERE idFilmy = 1").executeUpdate();

            System.out.println("Updating genre to 'Komedie' for film with id 2.");
            em.createQuery("UPDATE Filmy SET zanr = 'Komedie' WHERE idFilmy = 2").executeUpdate();

            System.out.println("Updating sales for film with id 1.");
            em.createQuery("UPDATE Filmy SET prodeje = prodeje + 1000 WHERE idFilmy = 1").executeUpdate();

            System.out.println("Updating sales for film with id 2.");
            em.createQuery("UPDATE Filmy SET prodeje = prodeje + 2000 WHERE idFilmy = 2").executeUpdate();

            // Commit transaction
            em.getTransaction().commit();
            System.out.println("Transaction committed successfully.");
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
                System.out.println("Transaction rolled back due to an error.");
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public List<Filmy> findByGenre(String genre) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Filmy> query = em.createQuery("SELECT f FROM Filmy f WHERE f.zanr = :genre", Filmy.class);
            query.setParameter("genre", genre);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
}
