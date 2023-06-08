package com.AcessoBD.repository.entities;

import javax.persistence.*;

@Entity
@Table(name = "Linhaparticipante")
public class Linhaparticipante {

    @Id
    @Column(name = "id_linhaPart")
    private int idLinhaPart;

    @ManyToOne
    @JoinColumn(name = "num_aula")
    private Aulagrupo aulagrupo;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    public Linhaparticipante() {
    }

    public Linhaparticipante(Aulagrupo aulagrupo, Cliente cliente) {
        this.aulagrupo = aulagrupo;
        this.cliente = cliente;
    }

    public int getIdLinhaPart() {
        return idLinhaPart;
    }

    public void setIdLinhaPart(int idLinhaPart) {
        this.idLinhaPart = idLinhaPart;
    }

    public Aulagrupo getAulagrupo() {
        return aulagrupo;
    }

    public void setAulagrupo(Aulagrupo aulagrupo) {
        this.aulagrupo = aulagrupo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
