package DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import repository.entities.Aulagrupo;

public class AulagrupoDAO {

    private EntityManagerFactory emf;

    public AulagrupoDAO() {
        emf = Persistence.createEntityManagerFactory("gym-management-system");
    }

    public void create(Aulagrupo aulagrupo) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(aulagrupo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void update(Aulagrupo aulagrupo) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.merge(aulagrupo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void delete(int numAula) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            Aulagrupo aulagrupo = em.getReference(Aulagrupo.class, numAula);
            em.remove(aulagrupo);
            em.getTransaction().commit();
        } catch (EntityNotFoundException e) {
            System.err.println("Error deleting AulaGrupo. The AulaGrupo with id " + numAula + " doesn't exist: " + e.getMessage());
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public Aulagrupo getById(int numAula) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Aulagrupo.class, numAula);
        } finally {
            em.close();
        }
    }

    public List<Aulagrupo> getAll() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT ag FROM Aulagrupo ag", Aulagrupo.class).getResultList();
        } finally {
            em.close();
        }
    }

    public void close() {
        emf.close();
    }
}

