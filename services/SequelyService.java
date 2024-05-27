package services;

import dao.SequelyDao;
import entities.Sequely;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.transaction.Transactional;
import java.util.List;

public class SequelyService implements SequelyDao {
    private EntityManagerFactory emf;

    public SequelyService() {
        emf = Persistence.createEntityManagerFactory("ApplicationPU");
    }

    @Override
    @Transactional
    public void save(Sequely sequely) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            if (sequely.getIdSequel() == 0 || em.find(Sequely.class, sequely.getIdSequel()) == null) {
                em.persist(sequely);
            } else {
                em.merge(sequely);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public Sequely findById(Long id) {
        EntityManager em = emf.createEntityManager();
        Sequely sequely = em.find(Sequely.class, id);
        em.close();
        return sequely;
    }

    @Override
    public List<Sequely> findAll() {
        EntityManager em = emf.createEntityManager();
        List<Sequely> result = em.createQuery("SELECT s FROM Sequely s", Sequely.class).getResultList();
        em.close();
        return result;
    }

    @Override
    @Transactional
    public void delete(Sequely sequely) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Sequely managedSequely = em.merge(sequely);
            em.remove(managedSequely);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
