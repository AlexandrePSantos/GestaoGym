package com.AcessoBD.DAO;

import com.AcessoBD.repository.entities.Exercicio;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ExercicioDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("persist_gym");

    public void save(Exercicio exercicio) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(exercicio);
        em.getTransaction().commit();
        em.close();
    }

    public void update(Exercicio exercicio) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(exercicio);
        em.getTransaction().commit();
        em.close();
    }

    public void delete(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Exercicio exercicio = em.find(Exercicio.class, id);
        if (exercicio != null) {
            em.remove(exercicio);
        }
        em.getTransaction().commit();
        em.close();
    }

    public Exercicio getById(int id) {
        EntityManager em = emf.createEntityManager();
        Exercicio exercicio = em.find(Exercicio.class, id);
        em.close();
        return exercicio;
    }

    public List<Exercicio> getAll() {
        EntityManager em = emf.createEntityManager();
        List<Exercicio> exercicios = em.createQuery("SELECT e FROM Exercicio e", Exercicio.class).getResultList();
        em.close();
        return exercicios;
    }
}
