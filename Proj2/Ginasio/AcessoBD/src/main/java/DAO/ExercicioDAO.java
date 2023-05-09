package DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import repository.entities.Exercicio;

public class ExercicioDAO {

    private final EntityManagerFactory emf;

    public ExercicioDAO() {
        emf = Persistence.createEntityManagerFactory("persist_gym");
    }

    public void create(Exercicio exercicio) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(exercicio);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void update(Exercicio exercicio) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.merge(exercicio);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void delete(int idExercicio) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            Exercicio exercicio = em.getReference(Exercicio.class, idExercicio);
            em.remove(exercicio);
            em.getTransaction().commit();
        } catch (EntityNotFoundException e) {
            System.err.println("Error deleting Exercicio. The Exercicio with id " + idExercicio + " doesn't exist: " + e.getMessage());
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public Exercicio getById(int idExercicio) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Exercicio.class, idExercicio);
        } finally {
            em.close();
        }
    }

    public List<Exercicio> getAll() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Exercicio> query = em.createQuery("SELECT e FROM Exercicio e", Exercicio.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public void close() {
        emf.close();
    }
}
