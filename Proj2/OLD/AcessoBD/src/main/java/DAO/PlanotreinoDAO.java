package DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import repository.entities.Planotreino;

public class PlanotreinoDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("persist_gym");

    public void save(Planotreino planotreino) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(planotreino);
        em.getTransaction().commit();
        em.close();
    }

    public void update(Planotreino planotreino) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(planotreino);
        em.getTransaction().commit();
        em.close();
    }

    public void delete(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Planotreino planotreino = em.find(Planotreino.class, id);
        if (planotreino != null) {
            em.remove(planotreino);
        }
        em.getTransaction().commit();
        em.close();
    }

    public Planotreino getById(int id) {
        EntityManager em = emf.createEntityManager();
        Planotreino planotreino = em.find(Planotreino.class, id);
        em.close();
        return planotreino;
    }

    public List<Planotreino> getAll() {
        EntityManager em = emf.createEntityManager();
        List<Planotreino> planosTreinos = em.createQuery("SELECT p FROM Planotreino p", Planotreino.class).getResultList();
        em.close();
        return planosTreinos;
    }
}
