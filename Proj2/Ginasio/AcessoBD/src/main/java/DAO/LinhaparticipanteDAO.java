package DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import repository.entities.Linhaparticipante;

public class LinhaparticipanteDAO {

    private EntityManagerFactory emf;

    public LinhaparticipanteDAO() {
        emf = Persistence.createEntityManagerFactory("persist_gym");
    }

    public void create(Linhaparticipante linhaparticipante) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(linhaparticipante);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void update(Linhaparticipante linhaparticipante) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.merge(linhaparticipante);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void delete(int id) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            Linhaparticipante linhaparticipante = em.getReference(Linhaparticipante.class, id);
            em.remove(linhaparticipante);
            em.getTransaction().commit();
        } catch (EntityNotFoundException e) {
            System.err.println("Error deleting Linhaparticipante. The Linhaparticipante with id " + id + " doesn't exist: " + e.getMessage());
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public Linhaparticipante getById(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Linhaparticipante.class, id);
        } finally {
            em.close();
        }
    }

    public List<Linhaparticipante> getAll() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT lp FROM Linhaparticipante lp", Linhaparticipante.class).getResultList();
        } finally {
            em.close();
        }
    }

    public void close() {
        emf.close();
    }
}
