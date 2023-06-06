package com.AcessoBD.repository.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private int idCliente;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "telemovel")
    private String telemovel;

    @Column(name = "nif")
    private String nif;

    @Column(name = "dt_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "cod_postal")
    private String codigoPostal;

    public Cliente() {
    }

    public Cliente(String nome, String email, String telemovel, String nif, LocalDate dataNascimento, String codigoPostal, String password) {
        this.nome = nome;
        this.email = email;
        this.telemovel = telemovel;
        this.nif = nif;
        this.dataNascimento = dataNascimento;
        this.codigoPostal = codigoPostal;
        this.password = password;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelemovel() {
        return telemovel;
    }

    public void setTelemovel(String telemovel) {
        this.telemovel = telemovel;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    @Override
    public String toString() {
        return nome;
    }
}
