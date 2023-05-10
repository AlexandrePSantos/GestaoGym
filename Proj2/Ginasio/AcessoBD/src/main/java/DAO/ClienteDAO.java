package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import repository.entities.Cliente;

public class ClienteDAO {

    private static EntityManagerFactory emf;

    public ClienteDAO() {
        emf = Persistence.createEntityManagerFactory("my-persistence-unit");
    }

    public void adicionarCliente(Cliente cliente) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();
        em.close();
    }

    public void atualizarCliente(Cliente cliente) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(cliente);
        em.getTransaction().commit();
        em.close();
    }

    public void removerCliente(int idCliente) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Cliente cliente = em.find(Cliente.class, idCliente);
        em.remove(cliente);
        em.getTransaction().commit();
        em.close();
    }

    public Cliente buscarCliente(int idCliente) {
        EntityManager em = emf.createEntityManager();
        Cliente cliente = em.find(Cliente.class, idCliente);
        em.close();
        return cliente;
    }

    public List<Cliente> listarClientes() {
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT c FROM Cliente c");
        List<Cliente> clientes = q.getResultList();
        em.close();
        return clientes;
    }

}