package DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import repository.entities.Pagamento;

public class PagamentoDAO {

    private final EntityManagerFactory emf;

    public PagamentoDAO() {
        emf = Persistence.createEntityManagerFactory("persist_gym");
    }

    public void create(Pagamento pagamento) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(pagamento);
            tx.commit();
        } catch (RuntimeException e) {
            tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public Pagamento read(int numPagamento) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Pagamento.class, numPagamento);
        } finally {
            em.close();
        }
    }

    public void update(Pagamento pagamento) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(pagamento);
            tx.commit();
        } catch (RuntimeException e) {
            tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public void delete(int numPagamento) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Pagamento pagamento = em.find(Pagamento.class, numPagamento);
            em.remove(pagamento);
            tx.commit();
        } catch (RuntimeException e) {
            tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public List<Pagamento> findAll() {
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery("SELECT p FROM Pagamento p");
            return query.getResultList();
        } finally {
            em.close();
        }
    }
}
