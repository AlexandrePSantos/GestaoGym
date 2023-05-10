package com.bd.BLL;

import com.bd.DAL.Encomendaestados;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class EncomendaestadosBLL {


    private  static final String PERSISTENCE_UNIT_NAME = "default";
    private static EntityManagerFactory factory = null;
    @PersistenceContext
    private static EntityManager em = null;

    public static void create(Encomendaestados encoEstado){
        if(factory == null) {
            factory = Persistence.createEntityManagerFactory("default");
        }


        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin(); //iniciando a transação com bd
        em.persist(encoEstado); //Persistindo os dados
        em.getTransaction().commit();//guardou
    }

    public static Encomendaestados read(int idEstEnc){
        Encomendaestados enc = null;
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("Encomendaestados.findByIdencomenda");
        q1.setParameter("id_encomenda",idEstEnc);
        Object obj = q1.getSingleResult();

        if(obj != null){
            enc= ((Encomendaestados)obj);
        }
        else
            return null;


        return enc;
    }

    public static List<Encomendaestados> readAll(){
        List<Encomendaestados> listaEnc = new ArrayList<>();
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("Encomendaestados.findAll");
        List<Object> result = q1.getResultList();

        for(Object enc : result){
            listaEnc.add((Encomendaestados) enc);
        }

        return listaEnc;
    }

    public static List<Encomendaestados> readAll(int idEstadoEnc ){
        List<Encomendaestados> listaEnc = new ArrayList<>();
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("Encomendaestados.findAllByIdEstadoEncomenda");
        q1.setParameter("id_estadoEnc" , idEstadoEnc);
        List<Object> result = q1.getResultList();

        for(Object cli : result){
            listaEnc.add((Encomendaestados) cli);
        }

        return listaEnc;
    }

    public static void update(Encomendaestados enc){
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.merge(enc);
        em.getTransaction().commit();
    }

    public static void delete(Encomendaestados enc){
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.remove(enc);
        em.getTransaction().commit();
    }


}

