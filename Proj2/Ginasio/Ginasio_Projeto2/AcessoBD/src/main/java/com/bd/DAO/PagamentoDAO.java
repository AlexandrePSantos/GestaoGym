package com.bd.DAO;

import com.bd.repository.entities.Pagamento;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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

    public Pagamento getById(int id) {
        EntityManager em = emf.createEntityManager();
        Pagamento pagamento = em.find(Pagamento.class, id);
        em.close();
        return pagamento;
    }

    public List<Pagamento> getAll() {
        EntityManager em = emf.createEntityManager();
        List<Pagamento> pagamentos = em.createQuery("SELECT p FROM Pagamento p", Pagamento.class).getResultList();
        em.close();
        return pagamentos;
    }
}
