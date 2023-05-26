package com.bd.BLL;

import com.bd.DAL.Clientes;
import com.bd.DAL.Pratos;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


public class PratoBLL {
    private static final String PERSISTENCE_UNIT_NAME = "default";

    private static EntityManagerFactory factory = null;
    @PersistenceContext
    private static EntityManager em = null;

    public static void create(Pratos pra) {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory("default");
        }


        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin(); //iniciando a transação com bd
        em.persist(pra); //Persistindo os dados
        em.getTransaction().commit();//guardou
    }


    public static Pratos read(int id_Prato) {
        Pratos pra = null;
        if (factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("Pratos.findById_Pratos");
        q1.setParameter("id_prato", id_Prato);
        Object obj = q1.getSingleResult();

        if (obj != null) {
            pra = ((Pratos) obj);
        } else
            return null;


        return pra;
    }

    public static List<Pratos> readAll(boolean estado) {
        List<Pratos> listaPra = new ArrayList<>();
        if (factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("Pratos.findAllByEstado");
        List<Object> result = q1.getResultList();

        for (Object pra : result) {
            listaPra.add((Pratos) pra);
        }

        return listaPra;
    }

    public static List<Pratos> readAll(String DESCRICAO) {
        List<Pratos> listaPra = new ArrayList<>();
        if (factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        Query q2 = em.createNamedQuery("Pratos.findAllByDescricao");
        q2.setParameter("DESCRICAO", "%" + DESCRICAO + "%");
        List<Object> result = q2.getResultList();


        for (Object pra : result) {
            listaPra.add((Pratos) pra);
        }

        return listaPra;
    }

    /**
     * FAZER UPDATE DO STOCK, PREÇO E PRATOS
     *
     * @param pra
     */
    public static void update(Pratos pra) {
        if (factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.merge(pra);
        em.getTransaction().commit();
    }

    public static  Pratos updateStock(Pratos stock) {
        if (factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();


        Query q1 = em.createNamedQuery("Pratos.findAllByStock");
        q1.setParameter("stockdoses", stock);
        Object obj = q1.getSingleResult();


        if (obj != null) {
            stock = ((Pratos) obj);

            em.getTransaction().begin();
            em.merge(stock);
            em.getTransaction().commit();

        } else
            return null;


        return stock;
    }



    public static void delete(int idPrato ){
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();
        Pratos p = read(idPrato);
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();
    }

    public static int readByNome(String descricao) {
        Pratos cli = null;
        if (factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();


        Query q1 = em.createNamedQuery("Pratos.findAllByNome");
        q1.setParameter("descricao", descricao);
        Object obj = q1.getSingleResult();
        if (obj != null) {
            cli = ((Pratos) obj);
        }

        assert cli != null;
        return cli.getIdPrato();
    }
}







