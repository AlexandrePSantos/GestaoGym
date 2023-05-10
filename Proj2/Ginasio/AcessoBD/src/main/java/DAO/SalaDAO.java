package DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import repository.entities.Sala;

public class SalaDAO {

    private EntityManagerFactory emf;
    private EntityManager em;

    public SalaDAO() {
        emf = Persistence.createEntityManagerFactory("persist_gym");
        em = emf.createEntityManager();
    }

    public void create(Sala sala) {
        em.getTransaction().begin();
        em.persist(sala);
        em.getTransaction().commit();
    }

    public Sala findById(int id) {
        return em.find(Sala.class, id);
    }

    public List<Sala> findAll() {
        TypedQuery<Sala> query = em.createQuery("SELECT s FROM Sala s", Sala.class);
        return query.getResultList();
    }

    public void update(Sala sala) {
        em.getTransaction().begin();
        em.merge(sala);
        em.getTransaction().commit();
    }

    public void delete(int id) {
        Sala sala = findById(id);
        em.getTransaction().begin();
        em.remove(sala);
        em.getTransaction().commit();
    }

    public void close() {
        em.close();
        emf.close();
    }
}