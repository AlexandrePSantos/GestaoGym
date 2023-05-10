package com.bd.BLL;

import com.bd.DAL.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


public class EstafetaBLL {

    private static final String PERSISTENCE_UNIT_NAME = "default";
    private static EntityManagerFactory factory = null;
    @PersistenceContext
    private static EntityManager em = null;

    public static void create(Estafeta est) {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory("default");
        }


        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin(); //iniciando a transação com bd
        em.persist(est); //Persistindo os dados
        em.getTransaction().commit();//guardou
    }



/*    public  static  void  insert (Estafeta es){

        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();


        Query q1 = em.createNamedQuery("Estafeta.insert");

        em.getTransaction().begin();
        em.merge(es);
        em.getTransaction().commit();



    }*/

    public static Estafeta read(int id_estafeta) {
        Estafeta est = null;
        if (factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("Estafeta.findById_estafeta");
        q1.setParameter("id_estafeta", id_estafeta);
        Object obj = q1.getSingleResult();

        if (obj != null) {
            est = ((Estafeta) obj);
        } else
            return null;


        return est;
    }


    public static List<Estafeta> readAllEst(boolean estado) {
        List<Estafeta> listaEsta = new ArrayList<>();
        if (factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();


        Query q1 = em.createNamedQuery("Estafeta.findByEstado");
        q1.setParameter("isestado", estado);
        List<Object> result = q1.getResultList();

        for (Object estafeta : result) {
            listaEsta.add((Estafeta) estafeta);
        }

        return listaEsta;
    }

    public static Estafeta readByEmail(String email) {

        if (factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();


        Query q1 = em.createNamedQuery("Estafeta.findByEmail");
        q1.setParameter("email", email);
        Object obj = q1.getSingleResult();

        return (obj != null) ? ((Estafeta) obj) : null;

    }

    public static List<Estafetas> readAllEsta(boolean estado) {
        List<Estafetas> listaEst = new ArrayList<>();
        if (factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        TypedQuery<Estafetas> q1 = em.createNamedQuery("Estafeta.findAllPass", Estafetas.class);
        q1.setParameter("isestado", estado);
        // q1.setParameter("isestafeta", isEstafeta);
        List<Estafetas> result = q1.getResultList();

        for (Estafetas est : result) {
            listaEst.add((Estafetas) est);
        }

        return listaEst;
    }


    /*
    public static  boolean emailRepetidoEstafeta(String email) {
        Estafeta estafetas = null;
        List<Estafeta> listaEst = new ArrayList<>();
        if (factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("Estafeta.findAll");
        //q1.setParameter("email", email);

        List<Estafeta> result = q1.getResultList();
        System.out.println(q1);

        for (Estafeta es : result) {
            System.out.println(email);
            if (email.equals(es.getEmail())) {
                return true;
            }



        }
        return false;
    }




 */
    public static boolean emailRepetidoEstafetaNif(int nif) {
        Estafeta estafetas = null;
        List<Estafeta> listaEst = new ArrayList<>();
        if (factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("Estafeta.findAll");
        //q1.setParameter("email", email);

        List<Estafeta> result = q1.getResultList();
        System.out.println(q1);

        for (Estafeta es : result) {

            if (nif == (es.getNif())) {
                return true;
            }

        }
        return false;
    }


    public static List<Estafetas> readAll(boolean estado) {
        List<Estafetas> listaEst = new ArrayList<>();
        if (factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        TypedQuery<Estafetas> q1 = em.createNamedQuery("Estafeta.findAllPass", Estafetas.class);
        q1.setParameter("isestado", estado);
        List<Estafetas> result = q1.getResultList();

        for (Estafetas est : result) {
            listaEst.add((Estafetas) est);
        }

        return listaEst;
    }





/*
        public static List<Estafeta> readAll (String nome){
            List<Estafeta> listaEst = new ArrayList<>();
            if (factory == null)
                factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

            if (em == null) em = factory.createEntityManager();

            Query q1 = em.createNamedQuery("Estafeta.findAllByNome");
            q1.setParameter("nome", "%" + nome + "%");
            List<Object> result = q1.getResultList();

            for (Object est : result) {
                listaEst.add((Estafeta) est);
            }

            return listaEst;
        }


 */

    public static List<Estafeta> readAll() {
        List<Estafeta> listaEsta = new ArrayList<>();
        if (factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("Estafeta.findAll");
        List<Object> result = q1.getResultList();

        for (Object est : result) {
            listaEsta.add((Estafeta) est);
        }

        return listaEsta;
    }


    public static void update(Estafetas estafetas) {
        //List<Estafetas> listaEst = new ArrayList<>();
        if (factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.merge(estafetas);
        em.getTransaction().commit();


    }
/*
    public static  void updateEstado(Estafetas estafetas){


        //List<Estafetas> listaEst = new ArrayList<>();
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();
        TypedQuery<Estafetas> q1 = em.createNamedQuery("Estafeta.updates", Estafetas.class);



        em.getTransaction().begin();
        em.merge(estafetas);
        em.getTransaction().commit();


    }



 */

    public static void delete(int idEst) {
        if (factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        Estafeta e = read(idEst);

        em.getTransaction().begin();
        em.remove(e);
        em.getTransaction().commit();
    }


}






