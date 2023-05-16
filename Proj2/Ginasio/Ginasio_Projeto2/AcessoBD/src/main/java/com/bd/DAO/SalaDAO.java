package com.bd.DAO;

import com.bd.repository.entities.Sala;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class SalaDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("persist_gym");

    public void save(Sala sala) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(sala);
        em.getTransaction().commit();
        em.close();
    }

    public void update(Sala sala) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(sala);
        em.getTransaction().commit();
        em.close();
    }

    public void delete(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Sala sala = em.find(Sala.class, id);
        if (sala != null) {
            em.remove(sala);
        }
        em.getTransaction().commit();
        em.close();
    }

    public Sala getById(int id) {
        EntityManager em = emf.createEntityManager();
        Sala sala = em.find(Sala.class, id);
        em.close();
        return sala;
    }

    public List<Sala> getAll() {
        EntityManager em = emf.createEntityManager();
        List<Sala> salas = em.createQuery("SELECT s FROM Sala s", Sala.class).getResultList();
        em.close();
        return salas;
    }
}
