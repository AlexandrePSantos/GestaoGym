package DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import repository.entities.Subscricao;

public class SubscricaoDAO {

    private EntityManagerFactory emf;
    private EntityManager em;

    public SubscricaoDAO() {
        emf = Persistence.createEntityManagerFactory("persist_gym");
        em = emf.createEntityManager();
    }

    public void create(Subscricao subscricao) {
        em.getTransaction().begin();
        em.persist(subscricao);
        em.getTransaction().commit();
    }

    public Subscricao findById(int id) {
        Subscricao subscricao = em.find(Subscricao.class, id);
        return subscricao;
    }

    public List<Subscricao> findAll() {
        TypedQuery<Subscricao> query = em.createQuery("SELECT s FROM Subscricao s", Subscricao.class);
        List<Subscricao> subscricoes = query.getResultList();
        return subscricoes;
    }

    public void update(Subscricao subscricao) {
        em.getTransaction().begin();
        em.merge(subscricao);
        em.getTransaction().commit();
    }

    public void delete(Subscricao subscricao) {
        em.getTransaction().begin();
        em.remove(subscricao);
        em.getTransaction().commit();
    }

    public void close() {
        em.close();
        emf.close();
    }

}
