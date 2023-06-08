package com.AcessoBD.DAO;

import com.AcessoBD.repository.entities.Pagamento;

import javax.persistence.*;
import java.util.List;

public class PagamentoDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("persist_gym");

    public void save(Pagamento pagamento) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(pagamento);
        em.getTransaction().commit();
        em.close();
    }

    public void update(Pagamento pagamento) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(pagamento);
        em.getTransaction().commit();
        em.close();
    }

    public void delete(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Pagamento pagamento = em.find(Pagamento.class, id);
        if (pagamento != null) {
            em.remove(pagamento);
        }
        em.getTransaction().commit();
        em.close();
    }

    public int getID() {
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery("SELECT MAX(l.numPagamento) FROM Pagamento l");
            Integer maxId = (Integer) query.getSingleResult();
            return maxId != null ? maxId + 1 : 1;
        } finally {
            em.close();
        }
    }

    public Pagamento getById(int id) {
        EntityManager em = emf.createEntityManager();
        Pagamento pagamento = em.find(Pagamento.class, id);
        em.close();
        return pagamento;
    }

    public List<Pagamento> getAllById(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Pagamento> query = em.createQuery("SELECT p FROM Pagamento p where p.subscricao.numSubscricao = :id", Pagamento.class);
            query.setParameter("id", id);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public List<Pagamento> getAll() {
        EntityManager em = emf.createEntityManager();
        List<Pagamento> pagamentos = em.createQuery("SELECT p FROM Pagamento p", Pagamento.class).getResultList();
        em.close();
        return pagamentos;
    }
}
