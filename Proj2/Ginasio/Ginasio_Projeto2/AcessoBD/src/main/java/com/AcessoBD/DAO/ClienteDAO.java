package com.AcessoBD.DAO;

import com.AcessoBD.repository.entities.Cliente;
import com.AcessoBD.repository.entities.Pagamento;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

public class ClienteDAO {

    private static EntityManagerFactory emf;
    private EntityManager em;

    public ClienteDAO() {
        emf = Persistence.createEntityManagerFactory("persist_gym");
        em = emf.createEntityManager();
    }

    public void save(Cliente cliente) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();
        em.close();
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

    public int getID() {
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery("SELECT MAX(l.idCliente) FROM Cliente l");
            Integer maxId = (Integer) query.getSingleResult();
            return maxId != null ? maxId + 1 : 1;
        } finally {
            em.close();
        }
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

    public Cliente getByEmail(String email) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT c FROM Cliente c WHERE c.email = :email");
        query.setParameter("email", email);
        Cliente cliente = (Cliente) query.getSingleResult();
        em.close();
        return cliente;
    }

    public void close() {
        em.close();
        emf.close();
    }
}
