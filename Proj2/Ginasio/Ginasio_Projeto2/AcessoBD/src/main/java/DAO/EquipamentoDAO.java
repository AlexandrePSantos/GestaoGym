package DAO;

import repository.entities.Equipamento;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class EquipamentoDAO {
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persist_gym");

    public void create(Equipamento equipamento) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(equipamento);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }

    public void update(Equipamento equipamento) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();
            entityManager.merge(equipamento);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }

    public void delete(int idEquipamento) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();
            Equipamento equipamento = entityManager.find(Equipamento.class, idEquipamento);
            entityManager.remove(equipamento);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }

    public Equipamento getById(int idEquipamento) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            return entityManager.find(Equipamento.class, idEquipamento);
        } finally {
            entityManager.close();
        }
    }

    public List<Equipamento> getAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            Query query = entityManager.createQuery("FROM Equipamento");
            return query.getResultList();
        } finally {
            entityManager.close();
        }
    }
}
