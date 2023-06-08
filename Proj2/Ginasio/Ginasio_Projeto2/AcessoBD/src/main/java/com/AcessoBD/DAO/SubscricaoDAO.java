package com.AcessoBD.DAO;

import com.AcessoBD.repository.entities.Cliente;
import com.AcessoBD.repository.entities.Subscricao;

import javax.persistence.*;
import java.util.List;

public class SubscricaoDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("persist_gym");

    public void save(Subscricao subscricao) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(subscricao);
        em.getTransaction().commit();
        em.close();
    }

    public void update(Subscricao subscricao) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(subscricao);
        em.getTransaction().commit();
        em.close();
    }

    public void delete(int numSubscricao) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Subscricao subscricao = em.find(Subscricao.class, numSubscricao);
        if (subscricao != null) {
            em.remove(subscricao);
        }
        em.getTransaction().commit();
        em.close();
    }

    public int getID() {
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery("SELECT MAX(l.numSubscricao) FROM Subscricao l");
            Integer maxId = (Integer) query.getSingleResult();
            return maxId != null ? maxId + 1 : 1;
        } finally {
            em.close();
        }
    }

    public Subscricao getByNumSubscricao(int numSubscricao) {
        EntityManager em = emf.createEntityManager();
        Subscricao subscricao = em.find(Subscricao.class, numSubscricao);
        em.close();
        return subscricao;
    }

    public List<Subscricao> getSubscricoesAtivasByCliente(Cliente cliente) {
        EntityManager em = emf.createEntityManager();
        // Execute a consulta JPQL para obter as subscrições ativas do cliente
        TypedQuery<Subscricao> query = em.createQuery("SELECT s FROM Subscricao s WHERE s.cliente = :cliente AND s.estado = 'Ativa'", Subscricao.class);
        query.setParameter("cliente", cliente);

        return query.getResultList();
    }


    public List<Subscricao> getAll() {
        EntityManager em = emf.createEntityManager();
        List<Subscricao> subscricoes = em.createQuery("SELECT s FROM Subscricao s", Subscricao.class).getResultList();
        em.close();
        return subscricoes;
    }
}
