package com.AcessoBD.repository.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Subscricao")
public class Subscricao {

    @Id
    @Column(name = "num_subscricao")
    private Integer numSubscricao;

    @Column(name = "data_ini")
    private LocalDate dataIni;

    @Column(name = "data_fim")
    private LocalDate dataFim;

    @Column(name = "valor")
    private BigDecimal valor;

    @Column(name = "estado")
    private String estado;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    public Subscricao() {
    }

    public Subscricao(LocalDate dataIni, LocalDate dataFim, BigDecimal valor, String estado, Cliente cliente) {
        this.dataIni = dataIni;
        this.dataFim = dataFim;
        this.valor = valor;
        this.estado = estado;
        this.cliente = cliente;
    }

    public Integer getNumSubscricao() {
        return numSubscricao;
    }

    public void setNumSubscricao(Integer numSubscricao) {
        this.numSubscricao = numSubscricao;
    }

    public LocalDate getDataIni() {
        return dataIni;
    }

    public void setDataIni(LocalDate dataIni) {
        this.dataIni = dataIni;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
