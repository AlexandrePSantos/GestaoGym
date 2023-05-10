import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import repository.entities.Cliente;

public class Main {

    public static void main(String[] args) {
        // Create an EntityManagerFactory using the persistence.xml file
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persist_gym");

        // Create an EntityManager from the EntityManagerFactory
        EntityManager em = emf.createEntityManager();

        // Begin a transaction
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        // Create a new Cliente entity
        Cliente cliente = new Cliente();
        cliente.setNome("John Doe");
        cliente.setEmail("johndoe@example.com");
        cliente.setTelemovel("555-1234");

        // Persist the new Cliente entity
        em.persist(cliente);

        // Commit the transaction
        tx.commit();

        // Close the EntityManager and the EntityManagerFactory
        em.close();
        emf.close();
    }

}
