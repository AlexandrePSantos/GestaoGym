package com.bd.DAL;

import javax.persistence.*;

@Entity
@Table(name = "ESTADOSENCOMENDA")
@NamedQueries({
        @NamedQuery(name = "Estadosencomenda.findAll", query = "SELECT c FROM Estadosencomenda c"),
        @NamedQuery(name = "Estadosencomenda.findMarcada", query = "SELECT c FROM Estadosencomenda c where c.idEstadoencomenda=1"),
        @NamedQuery(name = "Estadosencomenda.findAllById", query = "SELECT c FROM Estadosencomenda c where c.idEstadoencomenda= :id_Estado"),
        @NamedQuery(name = "Estadosencomenda.findAllByDescricaoEstado", query = "SELECT c FROM Estadosencomenda c where c.descricaoestado = :descricaoestado"),
})

public class Estadosencomenda {
    private int idEstadoencomenda;
    private String descricaoestado;

   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_ESTADOENCOMENDA", nullable = false, precision = 0)
    public int getIdEstadoencomenda() {
        return idEstadoencomenda;
    }

    public void setIdEstadoencomenda(int idEstadoencomenda) {
        this.idEstadoencomenda = idEstadoencomenda;
    }

    @Basic
    @Column(name = "DESCRICAOESTADO", nullable = false, length = 50)
    public String getDescricaoestado() {
        return descricaoestado;
    }

    public void setDescricaoestado(String descricaoestado) {
        this.descricaoestado = descricaoestado;
    }

    @Override
    public String toString() {
        return   descricaoestado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Estadosencomenda that = (Estadosencomenda) o;

        if (idEstadoencomenda != that.idEstadoencomenda) return false;
        if (descricaoestado != null ? !descricaoestado.equals(that.descricaoestado) : that.descricaoestado != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idEstadoencomenda;
        result = 31 * result + (descricaoestado != null ? descricaoestado.hashCode() : 0);
        return result;
    }
}
