package com.bd.DAL;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "ENCOMENDAESTADOS")
@NamedQueries({
        @NamedQuery(name = "Encomendaestados.findAll", query = "SELECT c FROM Encomendaestados c"),
        @NamedQuery(name = "Encomendaestados.findByIdencomenda", query = "SELECT c FROM Encomendaestados c WHERE c.idEncomenda = :id_encomenda"),
        @NamedQuery(name = "Encomendaestados.findAllByIdEstadoEncomenda", query = "SELECT c FROM Encomendaestados c WHERE c.idEstadoencomenda = :id_estadoEnc"),
})

@IdClass(EncomendaestadosPK.class)
public class Encomendaestados {
    private int idEncomenda;
    private int idEstadoencomenda;
    private Date data;

   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_ENCOMENDA", nullable = false, precision = 0)
    public int getIdEncomenda() {
        return idEncomenda;
    }

    public void setIdEncomenda(int idEncomenda) {
        this.idEncomenda = idEncomenda;
    }

    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_ESTADOENCOMENDA", nullable = false, precision = 0)
    public int getIdEstadoencomenda() {
        return idEstadoencomenda;
    }

    public void setIdEstadoencomenda(int idEstadoencomenda) {
        this.idEstadoencomenda = idEstadoencomenda;
    }

    @Basic
    @Column(name = "DATA", nullable = false)
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Encomendaestados that = (Encomendaestados) o;

        if (idEncomenda != that.idEncomenda) return false;
        if (idEstadoencomenda != that.idEstadoencomenda) return false;
        if (data != null ? !data.equals(that.data) : that.data != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idEncomenda;
        result = 31 * result + idEstadoencomenda;
        result = 31 * result + (data != null ? data.hashCode() : 0);
        return result;
    }
}
