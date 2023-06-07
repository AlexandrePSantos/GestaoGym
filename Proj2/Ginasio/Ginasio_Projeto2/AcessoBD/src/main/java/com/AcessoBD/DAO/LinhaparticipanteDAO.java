package com.AcessoBD.DAO;

import com.AcessoBD.repository.entities.Linhaparticipante;

import javax.persistence.*;
import java.util.List;

public class LinhaparticipanteDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("persist_gym");

    public void save(Linhaparticipante linhaparticipante) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(linhaparticipante);
        em.getTransaction().commit();
        em.close();
    }

    public void update(Linhaparticipante linhaparticipante) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(linhaparticipante);
        em.getTransaction().commit();
        em.close();
    }

    public void delete(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Linhaparticipante linhaparticipante = em.find(Linhaparticipante.class, id);
        if (linhaparticipante != null) {
            em.remove(linhaparticipante);
        }
        em.getTransaction().commit();
        em.close();
    }

    public int getID() {
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery("SELECT MAX(l.idLinhaPart) FROM Linhaparticipante l");
            Integer maxId = (Integer) query.getSingleResult();
            return maxId != null ? maxId + 1 : 1;
        } finally {
            em.close();
        }
    }

    public Linhaparticipante getById(int id) {
        EntityManager em = emf.createEntityManager();
        Linhaparticipante linhaparticipante = em.find(Linhaparticipante.class, id);
        em.close();
        return linhaparticipante;
    }

    public List<Linhaparticipante> getAllById(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Linhaparticipante> query = em.createQuery("SELECT l FROM Linhaparticipante l WHERE l.aulagrupo.numAula = :id", Linhaparticipante.class);
            query.setParameter("id", id);
            return query.getResultList();
        } finally {
            em.close();
        }
    }


    public List<Linhaparticipante> getAll() {
        EntityManager em = emf.createEntityManager();
        List<Linhaparticipante> linhasparticipantes = em.createQuery("SELECT l FROM Linhaparticipante l", Linhaparticipante.class).getResultList();
        em.close();
        return linhasparticipantes;
    }
}
