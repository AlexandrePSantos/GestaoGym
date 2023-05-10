package com.bd.BLL;

import com.bd.DAL.Pratos;
import com.bd.DAL.PratosEncomendados;
import com.bd.DAL.listaPedidosCozinheiro;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


public class PratosEncomendadosBLL {
        private  static final String PERSISTENCE_UNIT_NAME = "default";
        private static EntityManagerFactory factory = null;
        @PersistenceContext
        private static EntityManager em = null;


    public static void create(PratosEncomendados praenc) {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory("default");
        }

        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin(); //iniciando a transação com bd
        em.persist(praenc); //Persistindo os dados
        em.getTransaction().commit();//guardou
    }

        public static PratosEncomendados read(int id_encomendas){
           PratosEncomendados PratEn = null;
            if(factory == null)
                factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

            if (em == null) em = factory.createEntityManager();

            Query q1 = em.createNamedQuery("PratosEncomendado.findById_encomendas");
            q1.setParameter("id_encomendas",id_encomendas);
            Object obj = q1.getSingleResult();

            if(obj != null){
                PratEn = ((PratosEncomendados)obj);
            }
            else
                return null;


            return PratEn;
        }

        public static List<PratosEncomendados> readAll(){
            List<PratosEncomendados> listaPratEn = new ArrayList<>();
            if(factory == null)
                factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

            if (em == null) em = factory.createEntityManager();

            Query q1 = em.createNamedQuery("PratosEncomendados.findAll");
            List<Object> result = q1.getResultList();

            for(Object PratEn : result){
                listaPratEn.add((PratosEncomendados) PratEn);
            }

            return listaPratEn;
        }



    public static List<PratosEncomendados> readAllEs(boolean estado){
        List<PratosEncomendados> listaPratEn = new ArrayList<>();
        //List<listaPedidosCozinheiro> listaPrat = new ArrayList<>();
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("PratosEncomendados.findAllEs");
        q1.setParameter("isestado", estado);
        List<Object> result = q1.getResultList();

        for(Object PratEn : result){
            listaPratEn.add((PratosEncomendados) PratEn);
        }

        return listaPratEn;
    }

    public static  List<listaPedidosCozinheiro>  reAllCoz(boolean estado){
        List<listaPedidosCozinheiro> listaPed = new ArrayList<>();

        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

         Query q1 = em.createNamedQuery("PratosEncomendados.findAllByListaPratos");
        q1.setParameter("isestado", estado);
        List<Object> result = q1.getResultList();

        for(Object PratEn : result){
            listaPed.add((listaPedidosCozinheiro) PratEn);
        }

        return listaPed;
    }

/*
    public void realAlltale (boolean estado){
            em.getTransaction().begin();

        List<listaPedidosCozinheiro> listaPed = (List<listaPedidosCozinheiro>)em.createQuery("SELECT l From PratosEncomendados l Order By l.qtddoses").getResultList();




    }


 */
    public static List<PratosEncomendados> readAll(Number idPrato){
        List<PratosEncomendados> listaPratEn = new ArrayList<>();
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("PratosEncomendados.findAllByIdprato");
        q1.setParameter("ID_PRATO", "%"+idPrato+"%");
        List<Object> result = q1.getResultList();

        for(Object PratEn : result){
            listaPratEn.add((PratosEncomendados) PratEn);
        }

        return listaPratEn;
    }


    public static void update(PratosEncomendados listaPed){
        List<PratosEncomendados> listaPratEn = new ArrayList<>();
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        //em.merge(listaPratEn);

        em.merge(listaPed);
        em.getTransaction().commit();


    }

}






