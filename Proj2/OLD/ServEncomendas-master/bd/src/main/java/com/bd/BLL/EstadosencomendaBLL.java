package com.bd.BLL;

import com.bd.DAL.Estadosencomenda;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class EstadosencomendaBLL {


    private  static final String PERSISTENCE_UNIT_NAME = "default";
    private static EntityManagerFactory factory = null;
    @PersistenceContext
    private static EntityManager em = null;

    public static void create(Estadosencomenda enc){
        if(factory == null) {
            factory = Persistence.createEntityManagerFactory("default");
        }


        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin(); //iniciando a transação com bd
        em.persist(enc); //Persistindo os dados
        em.getTransaction().commit();//guardou
    }

    public static Estadosencomenda read (int idEstado){
        Estadosencomenda enc = null;
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("Estadosencomenda.findAllByIdEstado");
        q1.setParameter("idEnc",idEstado);
        Object obj = q1.getSingleResult();

        if(obj != null){
            enc= ((Estadosencomenda)obj);
        }
        else
            return null;


        return enc;
    }

    public static List<Estadosencomenda> readAllMarcadas(){
        List<Estadosencomenda> listaEnc = new ArrayList<>();
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("Estadosencomenda.findAll");
        List<Object> result = q1.getResultList();

        for(Object enc : result){
            listaEnc.add((Estadosencomenda) enc);
        }

        return listaEnc;
    }

    public static List<Estadosencomenda> readAll(String descricao ){
        List<Estadosencomenda> listaEnc = new ArrayList<>();
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("Estadosencomenda.findAllByDescricaoEstado");
        q1.setParameter("descricaoestado" , "%"+descricao+"%");
        List<Object> result = q1.getResultList();

        for(Object cli : result){
            listaEnc.add((Estadosencomenda) cli);
        }

        return listaEnc;
    }

    public static void update(Estadosencomenda enc){
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.merge(enc);
        em.getTransaction().commit();
    }

    public static void delete( int enc){
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();
            Estadosencomenda ee= read(enc);
        em.getTransaction().begin();
        em.remove(ee);
        em.getTransaction().commit();
    }
}


