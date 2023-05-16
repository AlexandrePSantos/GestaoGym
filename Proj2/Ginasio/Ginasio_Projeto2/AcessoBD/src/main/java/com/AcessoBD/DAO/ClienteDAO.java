package com.AcessoBD.DAO;

import com.AcessoBD.repository.entities.Cliente;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

public class ClienteDAO {

    private static EntityManagerFactory emf;
    private EntityManager em;

    public ClienteDAO() {
        emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        em = emf.createEntityManager();
    }

    public void create(Cliente cliente) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(cliente);
        tx.commit();
    }

    public void update(Cliente cliente) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(cliente);
        tx.commit();
    }

    public void delete(int id) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Cliente cliente = em.find(Cliente.class, id);
        em.remove(cliente);
        tx.commit();
    }

    public Cliente getById(int id) {
        return em.find(Cliente.class, id);
    }

    public List<Cliente> getAll() {
        Query query = em.createQuery("SELECT c FROM Cliente c");
        return query.getResultList();
    }

    public List<Cliente> getByNome(String nome) {
        Query query = em.createQuery("SELECT c FROM Cliente c WHERE c.nome = :nome");
        query.setParameter("nome", nome);
        return query.getResultList();
    }

    public List<Cliente> getByCodigoPostal(String codigoPostal) {
        Query query = em.createQuery("SELECT c FROM Cliente c WHERE c.codigoPostal = :codigoPostal");
        query.setParameter("codigoPostal", codigoPostal);
        return query.getResultList();
    }

    public List<Cliente> getByDataNascimento(LocalDate dataNascimento) {
        Query query = em.createQuery("SELECT c FROM Cliente c WHERE c.dataNascimento = :dataNascimento");
        query.setParameter("dataNascimento", dataNascimento);
        return query.getResultList();
    }

    public void close() {
        em.close();
        emf.close();
    }
}
