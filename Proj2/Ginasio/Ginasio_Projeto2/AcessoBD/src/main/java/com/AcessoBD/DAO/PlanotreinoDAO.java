package com.AcessoBD.DAO;

import com.AcessoBD.repository.entities.Cliente;
import com.AcessoBD.repository.entities.Planotreino;

import javax.persistence.*;
import java.util.List;

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

    public int getID() {
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery("SELECT MAX(l.numPlano) FROM Planotreino l");
            Integer maxId = (Integer) query.getSingleResult();
            return maxId != null ? maxId + 1 : 1;
        } finally {
            em.close();
        }
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

    public List<Planotreino> getByClienteAndEstado(Cliente cli, String estado) {
        EntityManager em = emf.createEntityManager();
        try {
            String queryString = "SELECT p FROM Planotreino p WHERE p.cliente = :cliente AND p.estado = :estado";
            TypedQuery<Planotreino> query = em.createQuery(queryString, Planotreino.class);
            query.setParameter("cliente", cli);
            query.setParameter("estado", estado);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

}
