package com.AcessoBD.repository.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Planotreino")
public class Planotreino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "num_plano")
    private int numPlano;

    @Column(name = "dt_criacao")
    private LocalDate dtCriacao;

    @Column(name = "estado")
    private String estado;

    @ManyToOne
    @JoinColumn(name = "id_funcionario")
    private Funcionario funcionario;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    public Planotreino() {}

    public Planotreino(LocalDate dtCriacao, String estado, Funcionario funcionario, Cliente cliente) {
        this.dtCriacao = dtCriacao;
        this.estado = estado;
        this.funcionario = funcionario;
        this.cliente = cliente;
    }

    public int getNumPlano() {
        return numPlano;
    }

    public void setNumPlano(int numPlano) {
        this.numPlano = numPlano;
    }

    public LocalDate getDtCriacao() {
        return dtCriacao;
    }

    public void setDtCriacao(LocalDate dtCriacao) {
        this.dtCriacao = dtCriacao;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

}
