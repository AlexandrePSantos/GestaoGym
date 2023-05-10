package DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import repository.entities.Linhaparticipante;

public class LinhaparticipanteDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("persist_gym");

    public void save(Linhaparticipante linhaparticipante) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(linhaparticipante);
        em.getTransaction().commit();
        em.close();
    }

    public void update(Linhaparticipante linhaparticipante) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(linhaparticipante);
        em.getTransaction().commit();
        em.close();
    }

    public void delete(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Linhaparticipante linhaparticipante = em.find(Linhaparticipante.class, id);
        if (linhaparticipante != null) {
            em.remove(linhaparticipante);
        }
        em.getTransaction().commit();
        em.close();
    }

    public Linhaparticipante getById(int id) {
        EntityManager em = emf.createEntityManager();
        Linhaparticipante linhaparticipante = em.find(Linhaparticipante.class, id);
        em.close();
        return linhaparticipante;
    }

    public List<Linhaparticipante> getAll() {
        EntityManager em = emf.createEntityManager();
        List<Linhaparticipante> linhasparticipantes = em.createQuery("SELECT l FROM Linhaparticipante l", Linhaparticipante.class).getResultList();
        em.close();
        return linhasparticipantes;
    }
}
