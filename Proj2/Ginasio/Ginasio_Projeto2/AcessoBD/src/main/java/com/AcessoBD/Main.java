package com.AcessoBD;

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

        // Commit the transaction
        tx.commit();

        // Close the EntityManager and the EntityManagerFactory
        em.close();
        emf.close();
    }
}
