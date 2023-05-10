package com.example.fx.controllerAdmin;

public class TableClientAdmin {


    String encomendas;
    String codigopostal;
    String email;
    String morada;
    String password;
    String telefone;

    public TableClientAdmin(String encomendas, String codigopostal, String email, String morada, String password, String telefone, String nome) {
        this.encomendas = encomendas;
        this.codigopostal = codigopostal;
        this.email = email;
        this.morada = morada;
        this.password = password;
        this.telefone = telefone;
        this.nome = nome;
    }

    String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }



    public String getEncomendas() {
        return encomendas;
    }

    public void setEncomendas(String encomendas) {
        this.encomendas = encomendas;
    }

    public String getCodigopostal() {
        return codigopostal;
    }

    public void setCodigopostal(String codigopostal) {
        this.codigopostal = codigopostal;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


}
