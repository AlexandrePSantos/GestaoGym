package com.bd.BLL;

import com.bd.DAL.Tipopagamentos;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class TipoPagamentoBLL {

        private  static final String PERSISTENCE_UNIT_NAME = "default";
        private static EntityManagerFactory factory = null;
        @PersistenceContext
        private static EntityManager em = null;

        public static void create(Tipopagamentos tp){
            if(factory == null) {
                factory = Persistence.createEntityManagerFactory("default");
            }


            if (em == null) em = factory.createEntityManager();

            em.getTransaction().begin(); //iniciando a transação com bd
            em.persist(tp); //Persistindo os dados
            em.getTransaction().commit();//guardou
        }

        public static Tipopagamentos read(int tipopagamentoid){
            Tipopagamentos tp = null;
            if(factory == null)
                factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

            if (em == null) em = factory.createEntityManager();

            Query q1 = em.createNamedQuery("Tipopagamento.findBytipopagamentoid");
            q1.setParameter("tipopagamentoid", tipopagamentoid);
            Object obj = q1.getSingleResult();

            if(obj != null){
                tp = ((Tipopagamentos)obj);
            }
            else
                return null;


            return tp;
        }

        public static List<Tipopagamentos> readAll(){
            List<Tipopagamentos> listaTp = new ArrayList<>();
            if(factory == null)
                factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

            if (em == null) em = factory.createEntityManager();

            Query q1 = em.createNamedQuery("Tipopagamento.findAll");
            List<Object> result = q1.getResultList();

            for(Object tp : result){
                listaTp.add((Tipopagamentos) tp);
            }

            return listaTp;
        }

        public static List<Tipopagamentos> readAll(String descricao){
            List<Tipopagamentos> listaTp = new ArrayList<>();
            if(factory == null)
                factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

            if (em == null) em = factory.createEntityManager();

            Query q1 = em.createNamedQuery("Tipopgamento.findAllByDescricao");
            q1.setParameter("descricao", "%"+descricao+"%");
            List<Object> result = q1.getResultList();

            for(Object tp : result){
                listaTp.add((Tipopagamentos) tp);
            }

            return listaTp;
        }

        public static void delete(Tipopagamentos tp){
            if(factory == null)
                factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

            if (em == null) em = factory.createEntityManager();

            em.getTransaction().begin();
            em.remove(tp);
            em.getTransaction().commit();
        }
    }






