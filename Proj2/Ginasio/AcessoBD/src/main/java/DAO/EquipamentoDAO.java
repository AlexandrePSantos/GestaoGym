package DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import repository.entities.Equipamento;

public class EquipamentoDAO {

    private EntityManagerFactory emf;

    public EquipamentoDAO() {
        emf = Persistence.createEntityManagerFactory("persist_gym");
    }

    public void create(Equipamento equipamento) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(equipamento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void update(Equipamento equipamento) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.merge(equipamento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void delete(int idEquipamento) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            Equipamento equipamento = em.getReference(Equipamento.class, idEquipamento);
            em.remove(equipamento);
            em.getTransaction().commit();
        } catch (EntityNotFoundException e) {
            System.err.println("Error deleting Equipamento. The Equipamento with id " + idEquipamento + " doesn't exist: " + e.getMessage());
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public Equipamento getById(int idEquipamento) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Equipamento.class, idEquipamento);
        } finally {
            em.close();
        }
    }

    public List<Equipamento> getAll() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT e FROM Equipamento e", Equipamento.class).getResultList();
        } finally {
            em.close();
        }
    }

    public void close() {
        emf.close();
    }
}