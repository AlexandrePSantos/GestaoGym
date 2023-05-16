package com.bd.DAO;

import com.bd.repository.entities.Login;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class LoginDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("persist_gym");

    public void save(Login login) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(login);
        em.getTransaction().commit();
        em.close();
    }

    public void update(Login login) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(login);
        em.getTransaction().commit();
        em.close();
    }

    public void delete(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Login login = em.find(Login.class, id);
        if (login != null) {
            em.remove(login);
        }
        em.getTransaction().commit();
        em.close();
    }

    public Login getByUsername(String username) {
        EntityManager em = emf.createEntityManager();
        Login login = em.createQuery("SELECT l FROM Login l WHERE l.id = :username", Login.class)
                .setParameter("username", username)
                .getSingleResult();
        em.close();
        return login;
    }

    public List<Login> getAll() {
        EntityManager em = emf.createEntityManager();
        List<Login> logins = em.createQuery("SELECT l FROM Login l", Login.class).getResultList();
        em.close();
        return logins;
    }
}

