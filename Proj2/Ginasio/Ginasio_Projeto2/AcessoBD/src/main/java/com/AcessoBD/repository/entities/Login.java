package com.AcessoBD.repository.entities;

import javax.persistence.*;

@Entity
@Table(name = "login")
public class Login {
    @Id
    @Column(name = "id_user")
    private String id;

    @Column(name = "password")
    private String password;

    @OneToOne(mappedBy = "login", cascade = CascadeType.ALL)
    private Funcionario funcionario;

    @OneToOne(mappedBy = "login", cascade = CascadeType.ALL)
    private Cliente cliente;

    // default constructor
    public Login() {}

    // constructor with parameters
    public Login(String username, String password) {
        this.id = username;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Login{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", funcionario=" + funcionario +
                ", cliente=" + cliente +
                '}';
    }
}
