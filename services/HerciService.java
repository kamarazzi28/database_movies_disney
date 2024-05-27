package services;

import dao.HerciDao;
import entities.Herci;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.transaction.Transactional;
import java.util.List;

public class HerciService implements HerciDao {
    private EntityManagerFactory emf;

    public HerciService() {
        emf = Persistence.createEntityManagerFactory("ApplicationPU");
    }

    @Override
    @Transactional
    public void save(Herci herci) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            if (herci.getIdHerci() == 0 || em.find(Herci.class, herci.getIdHerci()) == null) {
                em.persist(herci);
            } else {
                em.merge(herci);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public Herci findById(Long id) {
        EntityManager em = emf.createEntityManager();
        Herci herci = em.find(Herci.class, id);
        em.close();
        return herci;
    }

    @Override
    public List<Herci> findAll() {
        EntityManager em = emf.createEntityManager();
        List<Herci> result = em.createQuery("SELECT h FROM Herci h", Herci.class).getResultList();
        em.close();
        return result;
    }

    @Override
    @Transactional
    public void delete(Herci herci) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Herci managedHerci = em.merge(herci); // Attach the entity to the current persistence context
            em.remove(managedHerci); // Remove the attached entity
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
