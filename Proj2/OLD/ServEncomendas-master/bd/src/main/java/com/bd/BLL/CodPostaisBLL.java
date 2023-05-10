package com.bd.BLL;

import com.bd.DAL.Codpostais;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


public class CodPostaisBLL {

        private  static final String PERSISTENCE_UNIT_NAME = "default";
        private static EntityManagerFactory factory = null;
        @PersistenceContext
        private static EntityManager em = null;

        public static void create(Codpostais cps){
            if(factory == null) {
                factory = Persistence.createEntityManagerFactory("default");
            }
            if (em == null) em = factory.createEntityManager();

            em.getTransaction().begin(); //iniciando a transação com bd
            em.persist(cps); //Persistindo os dados
            em.getTransaction().commit();//guardou
        }

        public static Codpostais read( String CODPOSTAIS){
            Codpostais cp = null;
            if(factory == null)
                factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

            if (em == null) em = factory.createEntityManager();

            Query q1 = em.createNamedQuery("CodPostais.findBycod");
            q1.setParameter("codpostal", CODPOSTAIS);
            Object obj = q1.getSingleResult();

            if(obj != null){
                cp = ((Codpostais)obj);
            }
            else
                return null;


            return cp;
        }

        public static List<Codpostais> readAll(){
            List<Codpostais> listaCp = new ArrayList<> ();
            if(factory == null)
                factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

            if (em == null) em = factory.createEntityManager();

            Query q1 = em.createNamedQuery("CodPostais.findAll");
            List<Object> result = q1.getResultList();

            for(Object cp : result){
                listaCp.add((Codpostais) cp);
            }

            return listaCp;
        }

        public static List<Codpostais> readAll(String Localidade){
            List<Codpostais> listaCp = new ArrayList<>();
            if(factory == null)
                factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

            if (em == null) em = factory.createEntityManager();

            Query q3 = em.createNamedQuery("CodPostais.findAllByLocalidade");
            q3.setParameter("Localidade", "%"+Localidade);
            List<Object> result = q3.getResultList();

            for(Object cp : result){
                listaCp.add((Codpostais) cp);
            }

            return listaCp;
        }

        public static void update(Codpostais cp){
            if(factory == null)
                factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

            if (em == null) em = factory.createEntityManager();

            em.getTransaction().begin();
            em.merge(cp);
            em.getTransaction().commit();
        }

        public static void delete(String cp){
            if(factory == null)
                factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

            if (em == null) em = factory.createEntityManager();
                Codpostais C = read(cp);
            em.getTransaction().begin();
            em.remove(C);
            em.getTransaction().commit();
        }


}











