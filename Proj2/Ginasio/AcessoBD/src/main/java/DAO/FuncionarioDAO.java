package DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import repository.entities.Funcionario;

public class FuncionarioDAO {

    private final EntityManagerFactory emf;

    public FuncionarioDAO() {
        emf = Persistence.createEntityManagerFactory("persist_gym");
    }

    public void create(Funcionario funcionario) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(funcionario);
        em.getTransaction().commit();
        em.close();
    }

    public Funcionario read(int idFuncionario) {
        EntityManager em = emf.createEntityManager();
        Funcionario funcionario = em.find(Funcionario.class, idFuncionario);
        em.close();
        return funcionario;
    }

    public void update(Funcionario funcionario) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(funcionario);
        em.getTransaction().commit();
        em.close();
    }

    public void delete(Funcionario funcionario) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(funcionario));
        em.getTransaction().commit();
        em.close();
    }

    public List<Funcionario> getAllFuncionarios() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT f FROM Funcionario f");
        List<Funcionario> funcionarios = query.getResultList();
        em.close();
        return funcionarios;
    }
}
