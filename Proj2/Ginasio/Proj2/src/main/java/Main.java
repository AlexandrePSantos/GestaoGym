import entity.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();

            Cliente alex = new Cliente();

        	alex.setIdcliente(10);
            alex.setNome("alex");
            alex.setEmail("teste123");
            alex.setTelemovel("12345");
            alex.setNif("123");
            alex.setDtnascimento(null);
            alex.setCpostal("123");

            entityManager.persist(alex);

            transaction.commit();
        } finally {
            if(transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
