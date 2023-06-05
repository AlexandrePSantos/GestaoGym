package com.AcessoBD.DAO;

import com.AcessoBD.repository.entities.Linhaexercicio;
import com.AcessoBD.repository.entities.Linhaparticipante;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class LinhaexercicioDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("persist_gym");

    public void save(Linhaexercicio linhaexercicio) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(linhaexercicio);
        em.getTransaction().commit();
        em.close();
    }

    public void update(Linhaexercicio linhaexercicio) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(linhaexercicio);
        em.getTransaction().commit();
        em.close();
    }

    public void delete(int idLinhaExercicio) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Linhaexercicio linhaexercicio = em.find(Linhaexercicio.class, idLinhaExercicio);
        if (linhaexercicio != null) {
            em.remove(linhaexercicio);
        }
        em.getTransaction().commit();
        em.close();
    }

    public Linhaexercicio getById(int idLinhaExercicio) {
        EntityManager em = emf.createEntityManager();
        Linhaexercicio linhaexercicio = em.find(Linhaexercicio.class, idLinhaExercicio);
        em.close();
        return linhaexercicio;
    }

    public List<Linhaexercicio> getAllById(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Linhaexercicio> query = em.createQuery("SELECT l FROM Linhaexercicio l WHERE l.exercicio.idExercicio = :id", Linhaexercicio.class);
            query.setParameter("id", id);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public List<Linhaexercicio> getAll() {
        EntityManager em = emf.createEntityManager();
        List<Linhaexercicio> linhaexercicios = em.createQuery("SELECT l FROM Linhaexercicio l", Linhaexercicio.class).getResultList();
        em.close();
        return linhaexercicios;
    }

}
