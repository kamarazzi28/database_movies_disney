package services;

import dao.DisneyStudiaDao;
import entities.DisneyStudia;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.transaction.Transactional;
import java.util.List;

public class DisneyStudiaService implements DisneyStudiaDao {
    private EntityManagerFactory emf;

    public DisneyStudiaService() {
        emf = Persistence.createEntityManagerFactory("ApplicationPU");
    }

    @Override
    @Transactional
    public void save(DisneyStudia disneyStudia) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            if (em.find(DisneyStudia.class, disneyStudia.getNazevStudia()) == null) {
                em.persist(disneyStudia);
            } else {
                em.merge(disneyStudia);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public DisneyStudia findById(String nazevStudia) {
        EntityManager em = emf.createEntityManager();
        DisneyStudia disneyStudia = em.find(DisneyStudia.class, nazevStudia);
        em.close();
        return disneyStudia;
    }

    @Override
    public List<DisneyStudia> findAll() {
        EntityManager em = emf.createEntityManager();
        List<DisneyStudia> result = em.createQuery("SELECT d FROM DisneyStudia d", DisneyStudia.class).getResultList();
        em.close();
        return result;
    }

    @Override
    @Transactional
    public void delete(DisneyStudia disneyStudia) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            DisneyStudia managedDisneyStudia = em.merge(disneyStudia); // Attach the entity to the current persistence context
            em.remove(managedDisneyStudia); // Remove the attached entity
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
