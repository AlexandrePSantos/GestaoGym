package com.bd.DAL;

import javax.persistence.*;

@Entity
@Table(name = "TipoPagamentos")
@NamedQueries({
        @NamedQuery(name = "Tipopagamento.findAll", query = "SELECT c FROM Tipopagamentos c"),
        @NamedQuery(name = "Tipopagamento.findBytipopagamentoid", query = "SELECT c FROM Tipopagamentos c WHERE c.tipopagamentoid = :tipopagamentoid"),
        @NamedQuery(name = "Tipopgamento.findAllByDescricao", query = "SELECT c FROM Tipopagamentos c WHERE c.descricao LIKE :descricao"),
})
public class Tipopagamentos {
    private int tipopagamentoid;
    private String descricao;

    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "TIPOPAGAMENTOID", nullable = false, precision = 0)
    public int getTipopagamentoid() {
        return tipopagamentoid;
    }

    public void setTipopagamentoid(int tipopagamentoid) {
        this.tipopagamentoid = tipopagamentoid;
    }

    public  String toString(){
        return getDescricao();
    }

    @Basic
    @Column(name = "DESCRICAO", nullable = false, length = 100)
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tipopagamentos that = (Tipopagamentos) o;

        if (tipopagamentoid != that.tipopagamentoid) return false;
        if (descricao != null ? !descricao.equals(that.descricao) : that.descricao != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tipopagamentoid;
        result = 31 * result + (descricao != null ? descricao.hashCode() : 0);
        return result;
    }
}
