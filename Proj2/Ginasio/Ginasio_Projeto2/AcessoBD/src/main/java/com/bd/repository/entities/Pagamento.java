package com.bd.repository.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Pagamento")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "num_pagamento")
    private int numPagamento;

    @Column(name = "valor")
    private BigDecimal valor;

    @Column(name = "estado", length = 200)
    private String estado;

    @Column(name = "data_pagamento")
    private LocalDate dataPagamento;

    @Column(name = "metodo", length = 15)
    private String metodo;

    @Column(name = "referencia", length = 12)
    private String referencia;

    @Column(name = "entidade", length = 6)
    private String entidade;

    @ManyToOne
    @JoinColumn(name = "num_subscricao")
    private Subscricao subscricao;

    public Pagamento() {}

    public Pagamento(BigDecimal valor, String estado, LocalDate dataPagamento, String metodo, String referencia, String entidade) {
        this.valor = valor;
        this.estado = estado;
        this.dataPagamento = dataPagamento;
        this.metodo = metodo;
        this.referencia = referencia;
        this.entidade = entidade;
    }

    public int getNumPagamento() {
        return numPagamento;
    }

    public void setNumPagamento(int numPagamento) {
        this.numPagamento = numPagamento;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getEntidade() {
        return entidade;
    }

    public void setEntidade(String entidade) {
        this.entidade = entidade;
    }

    public Subscricao getSubscricao() {
        return subscricao;
    }

    public void setSubscricao(Subscricao subscricao) {
        this.subscricao = subscricao;
    }
}
