package DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import repository.entities.Linhaexercicio;

public class linhaexercicioDAO {

    private EntityManagerFactory emf;

    public linhaexercicioDAO() {
        emf = Persistence.createEntityManagerFactory("persist_gym");
    }

    public void create(Linhaexercicio Linhaexercicio) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(Linhaexercicio);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void update(Linhaexercicio Linhaexercicio) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.merge(Linhaexercicio);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void delete(int id_linhaEx) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            Linhaexercicio linhaEx = em.getReference(Linhaexercicio.class, id_linhaEx);
            em.remove(linhaEx);
            em.getTransaction().commit();
        } catch (EntityNotFoundException e) {
            System.err.println("Error deleting Linhaexercicio. The Linhaexercicio with id " + id_linhaEx + " doesn't exist: " + e.getMessage());
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public Linhaexercicio getById(int id_linhaEx) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Linhaexercicio.class, id_linhaEx);
        } finally {
            em.close();
        }
    }

    public List<Linhaexercicio> getAll() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT le FROM Linhaexercicio le", Linhaexercicio.class).getResultList();
        } finally {
            em.close();
        }
    }

    public void close() {
        emf.close();
    }
}
