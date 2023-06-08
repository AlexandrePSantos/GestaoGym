package com.AcessoBD.DAO;

import com.AcessoBD.repository.entities.Cliente;
import com.AcessoBD.repository.entities.Funcionario;

import javax.persistence.*;
import java.util.List;

public class FuncionarioDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("persist_gym");

    public void save(Funcionario funcionario) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(funcionario);
        em.getTransaction().commit();
        em.close();
    }

    public void create(Funcionario funcionario) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(funcionario);
        tx.commit();
    }

    public void update(Funcionario funcionario) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(funcionario);
        em.getTransaction().commit();
        em.close();
    }

    public void delete(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Funcionario funcionario = em.find(Funcionario.class, id);
        if (funcionario != null) {
            em.remove(funcionario);
        }
        em.getTransaction().commit();
        em.close();
    }

    public int getID() {
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery("SELECT MAX(l.id) FROM Funcionario l");
            Integer maxId = (Integer) query.getSingleResult();
            return maxId != null ? maxId + 1 : 1;
        } finally {
            em.close();
        }
    }

    public Funcionario getById(int id) {
        EntityManager em = emf.createEntityManager();
        Funcionario funcionario = em.find(Funcionario.class, id);
        em.close();
        return funcionario;
    }

    public Funcionario getByEmail(String email) {
        EntityManager em = emf.createEntityManager();

        Query query = em.createQuery("SELECT f FROM Funcionario f WHERE f.email = :email");
        query.setParameter("email", email);

        Funcionario funcionario = (Funcionario) query.getSingleResult();

        em.close();

        return funcionario;
    }

    public List<Funcionario> getAll() {
        EntityManager em = emf.createEntityManager();
        List<Funcionario> funcionarios = em.createQuery("SELECT f FROM Funcionario f", Funcionario.class).getResultList();
        em.close();
        return funcionarios;
    }
}
