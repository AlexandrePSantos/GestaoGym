package com.AcessoBD;

import com.AcessoBD.repository.entities.Funcionario;
import com.AcessoBD.repository.entities.Login;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        // Create an EntityManagerFactory using the persistence.xml file
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persist_gym");

        // Create an EntityManager from the EntityManagerFactory
        EntityManager em = emf.createEntityManager();

        // Begin a transaction
        EntityTransaction tx = em.getTransaction();
        tx.begin();

//        // Create a new Cliente entity
//        Cliente cliente = new Cliente();
//        cliente.setNome("John Doe3");
//        cliente.setEmail("johndoe@example.com");
//        cliente.setTelemovel("555-1234");
//
//        // Persist the new Cliente entity
//        em.persist(cliente);

        // Commit the transaction
//        tx.commit();
//
//        // Close the EntityManager and the EntityManagerFactory
//        em.close();
//        emf.close();

//        // Create a new Funcionario entity
//        Login login = new Login();
//        Funcionario func = new Funcionario();
//        login.setId("Inst1");
//        login.setPassword("123456");
//        func.setLogin(login);
//        // Persist the new Cliente entity
//        em.persist(login);
//        em.persist(func);
//
//        // Commit the transaction
//        tx.commit();
//
//        // Close the EntityManager and the EntityManagerFactory
//        em.close();
//        emf.close();
    }
}
