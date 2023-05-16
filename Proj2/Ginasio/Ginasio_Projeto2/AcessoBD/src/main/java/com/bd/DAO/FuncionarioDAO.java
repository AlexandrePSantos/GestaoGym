package com.bd.DAO;

import com.bd.repository.entities.Funcionario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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

    public Funcionario getById(int id) {
        EntityManager em = emf.createEntityManager();
        Funcionario funcionario = em.find(Funcionario.class, id);
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
