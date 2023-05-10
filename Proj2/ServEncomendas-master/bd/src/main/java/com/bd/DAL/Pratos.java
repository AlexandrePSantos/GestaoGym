package com.bd.DAL;

import javax.persistence.*;

@Entity
@Table(name = "PRATOS")
@NamedQueries({
        @NamedQuery(name = "Pratos.findAll", query = "SELECT p FROM Pratos p"),
        @NamedQuery(name = "Pratos.findById_Pratos", query = "SELECT p FROM Pratos p WHERE  p.idPrato = :id_prato"),
        @NamedQuery(name = "Pratos.findAllByNome", query = "SELECT p FROM Pratos p WHERE  p.descricao = :descricao and p.estado = true"),
        @NamedQuery(name = "Pratos.findAllByDescricao", query = "SELECT p FROM Pratos p WHERE p.descricao LIKE :DESCRICAO"),
        @NamedQuery(name = "Pratos.findAllByEstado", query =    "SELECT p FROM Pratos p WHERE p.estado = true"),
        @NamedQuery(name = "Pratos.findAllByStock", query =    "SELECT p FROM Pratos p WHERE p.stockdoses = :stockdoses"),



})

public class Pratos {
    private int idPrato;
    private String descricao;
    private int stockdoses;
    private float precoatual;
    private boolean estado;


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_PRATO", nullable = false, precision = 0)
    public int getIdPrato() {
        return idPrato;
    }

    public void setIdPrato(int idPrato) {
        this.idPrato = idPrato;
    }

    @Basic
    @Column(name = "ESTADO", nullable = false, precision = 0)

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    @Basic
    @Column(name = "DESCRICAO", nullable = false, length = 150)
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Basic
    @Column(name = "STOCKDOSES", nullable = false, precision = 2)
    public int getStockdoses() {
        return stockdoses;
    }

    public void setStockdoses(int stockdoses) {
        this.stockdoses = stockdoses;
    }

    @Basic
    @Column(name = "PRECOATUAL", nullable = false, precision = 2)
    public float getPrecoatual() {
        return precoatual;
    }

    public void setPrecoatual(float precoatual) {
        this.precoatual = precoatual;
    }

    @Override
    public String toString() {
        return descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pratos pratos = (Pratos) o;

        if (idPrato != pratos.idPrato) return false;
        if (stockdoses != pratos.stockdoses) return false;
        if (precoatual != pratos.precoatual) return false;
        if (descricao != null ? !descricao.equals(pratos.descricao) : pratos.descricao != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idPrato;
        result = 31 * result + (descricao != null ? descricao.hashCode() : 0);
        result = 31 * result + stockdoses;

        return result;
    }


}
