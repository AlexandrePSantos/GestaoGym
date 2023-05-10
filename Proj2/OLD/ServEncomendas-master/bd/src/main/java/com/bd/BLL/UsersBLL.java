package com.bd.BLL;

import com.bd.DAL.Users;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class UsersBLL {


        private  static final String PERSISTENCE_UNIT_NAME = "default";
        private static EntityManagerFactory factory = null;
        @PersistenceContext
        private static EntityManager em = null;

        /**
         *
         */
        public static void create(Users user){
            if(factory == null) {
                factory = Persistence.createEntityManagerFactory("default");
            }


            if (em == null) em = factory.createEntityManager();

            em.getTransaction().begin(); //iniciando a transação com bd
            em.persist(user); //Persistindo os dados
            em.getTransaction().commit();//guardou

        }

        /**
         *
         *
         *
         */
        public static Users read(BigInteger id_user){
            Users user = null;
            if(factory == null)
                factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

            if (em == null) em = factory.createEntityManager();

            Query q1 = em.createNamedQuery("Users.findByUser");
            q1.setParameter("id_user", id_user);
            Object obj = q1.getSingleResult();

            if(obj != null){
                user = ((Users)user);
            }
            else
                return null;


            return user;
        }



    public static List<Users> readAllGesAti(boolean is_gestor, boolean estado){

        List<Users> listaUser = new ArrayList<>();
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("Users.findByGestorAtivo");
        q1.setParameter("is_gestor", is_gestor);
        List<Object> result = q1.getResultList();

        for(Object user : result){
            listaUser.add((Users) user);
        }

        return listaUser;

    }


    public static List<Users> readAllGesDes(boolean is_gestor, boolean estado){

        List<Users> listaUser = new ArrayList<>();
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("Users.findByGestorDesativado");
        q1.setParameter("is_gestor", is_gestor);
        List<Object> result = q1.getResultList();

        for(Object user : result){
            listaUser.add((Users) user);
        }

        return listaUser;

    }




    public static List<Users> readAllCozAtivo(boolean is_cozinheiro, boolean estado){

        List<Users> listaUser = new ArrayList<>();
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("Users.findByCozinheiroAtivo");
        q1.setParameter("is_cozinheiro", is_cozinheiro);
        List<Object> result = q1.getResultList();

        for(Object user : result){
            listaUser.add((Users) user);
        }

        return listaUser;

    }




    public static List<Users> readAllCozDes(boolean is_cozinheiro, boolean estado){

        List<Users> listaUser = new ArrayList<>();
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("Users.findByCozinheiroDesativado");
        q1.setParameter("is_cozinheiro", is_cozinheiro);
        List<Object> result = q1.getResultList();

        for(Object user : result){
            listaUser.add((Users) user);
        }

        return listaUser;

    }


    public static Users login(String email, String password){
        Users user = null;
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("Users.findByLogin");
        q1.setParameter("emailUser", email);
        q1.setParameter("pass",password);
        System.out.println(q1.getMaxResults());
        Object obj = q1.getSingleResult();

        if(obj != null) {
            user = ((Users) obj);
        }

        return user;
    }


    public static  boolean emailRepetido(String email){
        Users user = null;
        List<Users> listaUser = new ArrayList<>();
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("Users.findAll");
        //q1.setParameter("email", email);

        List<Users> result = q1.getResultList();
        System.out.println(q1);

        for (Users us :result ){
            System.out.println(email);
            if(email.equals(us.getEmail())){
                return true;
            }

        }
        //  Users obj = (Users) q1.getSingleResult();
/*
        if(obj != null) {
            user = ((Users) obj);
        }



 */

        return false;

        }





        /**
         * @read listar todos os user
         * @return
         */
        public static List<Users> readAll(){
            List<Users> listaUser = new ArrayList<>();
            if(factory == null)
                factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

            if (em == null) em = factory.createEntityManager();

            Query q1 = em.createNamedQuery("Users.findAll");
             List<Object> result = q1.getResultList();

            for(Object user : result){
                listaUser.add((Users) user);
            }

            return listaUser;
        }





        public static void update(Users user){
            if(factory == null)
                factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

            if (em == null) em = factory.createEntityManager();

            em.getTransaction().begin();
            em.merge(user);
            em.getTransaction().commit();

        }

        /**
         *
         *Delete
         */

        public static void delete(BigInteger userID ){
            if(factory == null)
                factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

            if (em == null) em = factory.createEntityManager();
                Users u = read(userID);
            em.getTransaction().begin();
            em.remove(u);
            em.getTransaction().commit();
        }


    public static BigInteger readByNomeGes(String email, boolean estado, boolean gestor) {
        Users ge = null;
        if (factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();


        Query q1 = em.createNamedQuery("Users.findAllByGestor");
        q1.setParameter("email", email);
       // q1.setParameter("is_gestor", is_gestor);
        Object obj = q1.getSingleResult();
        if (obj != null) {
            ge = ((Users) obj);
        }

        assert ge != null;
        return ge.getIdUser();
    }
    public static BigInteger readByNome(String nomeuser) {
       Users cli = null;
        if (factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();


        Query q1 = em.createNamedQuery("Users.findByCozinheiroNome");
        q1.setParameter("nomeuser", nomeuser);
        Object obj = q1.getSingleResult();
        if (obj != null) {
            cli = ((Users) obj);
        }

        assert cli != null;
        return cli.getIdUser();
    }

    }








