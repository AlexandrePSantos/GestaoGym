package com.bd.DAL;

import javax.persistence.*;
import javax.persistence.Entity;
import java.math.BigInteger;


@Entity
@Table(name = "Estafeta")
@NamedQueries(value = {
        @NamedQuery(name = "Estafeta.findByEmail", query = "SELECT c FROM Estafeta c Where c.email = :email"),
        @NamedQuery(name = "Estafeta.findAll", query = "SELECT c FROM Estafeta c"),
        @NamedQuery(name = "Estafeta.findById_estafeta", query = "SELECT c FROM Estafeta c WHERE c.idEstafeta = :id_estafeta"),
        @NamedQuery(name = "Estafeta.findByEstado", query = "Select c From Estafeta c  where c.estado = :isestado"),
        //@NamedQuery(name = "Estafeta.findAllByNome", query = "SELECT c FROM Estafeta c WHERE c.nome LIKE :nome"),
        @NamedQuery(name = "Estafeta.findAllPass", query = "select new com.bd.DAL.Estafetas (e, u)  from Estafeta  e, Users u  where u.email =  e.email and  e.estado = :isestado "),
       // @NamedQuery(name = "Estafeta.updates", query = "Update  com.bd.DAL.Estafetas e  set e.estado = true  where e.idEstafeta = :isestado" )
})
/*
@SqlResultSetMapping(name="updateResult", columns = { @ColumnResult(name = "count")})
@NamedNativeQueries({
        @NamedNativeQuery(
                name = "Estafeta.updates", query = "Update  com.bd.DAL.Estafetas e  " +
                "set e.estado = true  where e.idEstafeta = :isestado"
                ,resultSetMapping = "updateResult"
        )
})


 */
public class Estafeta {
    private int idEstafeta;
    private String nome;
    private String numtelefone;
    private int nif;
    private boolean estado;

    private BigInteger idUser;


    @Basic
    @Column(name = "ID_USER", nullable = true, precision = 0)
    public BigInteger getIdUser() {
        return idUser;
    }

    public void setIdUser(BigInteger idUser) {
        this.idUser = idUser;
    }

    @Basic
    @Column(name = "EMAIL", nullable = true, length = 60)
    private String email;

    @Basic
    @Column(name = "ESTADO", nullable = false, precision = 0)
    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_ESTAFETA", nullable = false, precision = 0)
    public int getIdEstafeta() {
        return idEstafeta;
    }

    public void setIdEstafeta(int idEstafeta) {
        this.idEstafeta = idEstafeta;
    }

    public int getIdEstafeta(int idEstafeta) {
       return idEstafeta;
    }

    @Basic
    @Column(name = "NUMTELEFONE", nullable = true, length = 20)
    public String getNumtelefone() {
        return numtelefone;
    }

    public void setNumtelefone(String numtelefone) {
        this.numtelefone = numtelefone;
    }

    @Basic
    @Column(name = "NIF", nullable = false, precision = 0)
    public int getNif() {
        return nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Estafeta estafeta = (Estafeta) o;

        if (idEstafeta != estafeta.idEstafeta) return false;
        if (nif != estafeta.nif) return false;
        if (nome != null ? !nome.equals(estafeta.nome) : estafeta.nome != null) return false;
        if (numtelefone != null ? !numtelefone.equals(estafeta.numtelefone) : estafeta.numtelefone != null)
            return false;
        if (email != null ? !email.equals(estafeta.email) : estafeta.email != null) return false;
        if (idUser != null ? !idUser.equals(estafeta.idUser) : estafeta.idUser != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idEstafeta;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (numtelefone != null ? numtelefone.hashCode() : 0);
        result = 31 * result + nif;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (idUser != null ? idUser.hashCode() : 0);

        return result;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
