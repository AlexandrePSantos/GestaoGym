package com.bd.DAL;

import java.math.BigInteger;


public class Estafetas {

    private BigInteger nif;
    private String email;
    private String emailEst;
    private String telefone;
    private String nome;
    private String password;
    private boolean estado;
    //private boolean estadous;
    private  boolean isEstafeta;
    private BigInteger id_user;
    private int id_estafeta;


    public int getId_estafeta() {
        return id_estafeta;
    }

    public void setId_estafeta(int id_estafeta) {
        this.id_estafeta = id_estafeta;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public boolean getEstado(boolean estado) {
            return estado ;
    }



/*
    public boolean isEstadous() {
        return estadous;
    }

    public void setEstadous(boolean estadous) {
        this.estadous = estadous;
    }


 */
    public void setId_user(BigInteger id_user) {
        this.id_user = id_user;
    }

    public BigInteger getId_user() {
        return id_user;
    }


    public BigInteger getNif() {
        return nif;
    }

    public void setNif(BigInteger nif) {
        this.nif = nif;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEstafeta() {
        return isEstafeta;
    }

    public void setEstafeta(boolean estafeta) {
        isEstafeta = estafeta;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmailEst() {
        return emailEst;
    }

    public void setEmailEst(String emailEst) {
        this.emailEst = emailEst;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public Estafetas(Estafeta e, Users u) {
        this.nif = BigInteger.valueOf(e.getNif());
        this.email = u.getEmail();
        this.telefone = e.getNumtelefone();
        this.nome = u.getNomeuser();
        this.password = u.getPassword();
        this.id_user = u.getIdUser();
        this.estado = e.getEstado();
        this.id_estafeta = e.getIdEstafeta();
        this.emailEst = e.getEmail();
        this.isEstafeta = u.getEstafeta();

    }

}


