package DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import repository.entities.Planotreino;

public class PlanotreinoDAO {

    private EntityManagerFactory emf;

    public PlanotreinoDAO() {
        emf = Persistence.createEntityManagerFactory("persist_gym");
    }

    public void create(Planotreino planotreino) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(planotreino);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void update(Planotreino planotreino) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.merge(planotreino);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void delete(int numPlano) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            Planotreino planotreino = em.getReference(Planotreino.class, numPlano);
            em.remove(planotreino);
            em.getTransaction().commit();
        } catch (EntityNotFoundException e) {
            System.err.println("Error deleting PlanoTreino. The PlanoTreino with id " + numPlano + " doesn't exist: " + e.getMessage());
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public Planotreino getById(int numPlano) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Planotreino.class, numPlano);
        } finally {
            em.close();
        }
    }

    public List<Planotreino> getAll() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT pt FROM Planotreino pt", Planotreino.class).getResultList();
        } finally {
            em.close();
        }
    }

    public void close() {
        emf.close();
    }
}
