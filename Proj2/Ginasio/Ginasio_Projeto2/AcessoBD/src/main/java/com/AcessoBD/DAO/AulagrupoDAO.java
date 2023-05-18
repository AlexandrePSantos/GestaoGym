package com.AcessoBD.DAO;

import com.AcessoBD.repository.entities.Aulagrupo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class AulagrupoDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("persist_gym");

    public void save(Aulagrupo aulagrupo) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(aulagrupo);
        em.getTransaction().commit();
        em.close();
    }

    public void update(Aulagrupo aulagrupo) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(aulagrupo);
        em.getTransaction().commit();
        em.close();
    }

    public void delete(int numAula) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Aulagrupo aulagrupo = em.find(Aulagrupo.class, numAula);
        if (aulagrupo != null) {
            em.remove(aulagrupo);
        }
        em.getTransaction().commit();
        em.close();
    }

    public Aulagrupo getById(int numAula) {
        EntityManager em = emf.createEntityManager();
        Aulagrupo aulagrupo = em.find(Aulagrupo.class, numAula);
        em.close();
        return aulagrupo;
    }

    public List<Aulagrupo> getAll() {
        EntityManager em = emf.createEntityManager();
        List<Aulagrupo> aulagrupos = em.createQuery("SELECT a FROM Aulagrupo a", Aulagrupo.class).getResultList();
        em.close();
        return aulagrupos;
    }

}
