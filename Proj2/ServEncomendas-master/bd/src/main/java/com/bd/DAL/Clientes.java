package com.bd.DAL;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "CLIENTES")
@NamedQueries({

        @NamedQuery(name = "Clientes.findAll", query = "SELECT c FROM Clientes c"),
        @NamedQuery(name = "Clientes.findByNif", query = "SELECT c FROM Clientes c where c.nif= :nif"),
        @NamedQuery(name = "Clientes.findByIdcliente", query = "SELECT c FROM Clientes c WHERE c.idCliente = :id_cliente"),
        @NamedQuery(name = "Clientes.findAllByNome", query = "SELECT c FROM Clientes c WHERE c.nome LIKE :nome"),
        @NamedQuery(name = "Clientes.findByEstado" , query = "Select c From Clientes c  where c.estado = :isestado" ),

})
public class Clientes {
    private int idCliente;
    private String nome;
    private BigInteger nif;
    private String rua;
    private int codpostal;
    private String numtelemovel;
    private boolean estado;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_CLIENTE", nullable = false, precision = 0)
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    @Basic
    @Column(name = "ESTADO", nullable = false, precision = 0)
   public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
       this.estado = estado;
    }

    @Basic
    @Column(name = "NOME", nullable = false, length = 100)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Basic
    @Column(name = "NIF", nullable = false, precision = 0)
    public BigInteger getNif() {
        return nif;
    }

    public void setNif(BigInteger nif) {
        this.nif = nif;
    }

    @Basic
    @Column(name = "RUA", nullable = false, length = 100)
    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }



    @Basic
    @Column(name = "CODPOSTAL", nullable = false, precision = 0)
    public int getCodpostal() {
        return codpostal;
    }

    public void setCodpostal(Integer codpostal) {
        this.codpostal = codpostal;
    }

    public void setCodpostal(int codpostal) {
        this.codpostal = codpostal;
    }

    @Basic
    @Column(name = "NUMTELEMOVEL", nullable = false, length = 20)
    public String getNumtelemovel() {
        return numtelemovel;
    }

    public void setNumtelemovel(String numtelemovel) {
        this.numtelemovel = numtelemovel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Clientes clientes = (Clientes) o;

        if (idCliente != clientes.idCliente) return false;
        if (nif != clientes.nif) return false;
        if (codpostal != clientes.codpostal) return false;
        if (nome != null ? !nome.equals(clientes.nome) : clientes.nome != null) return false;
        if (rua != null ? !rua.equals(clientes.rua) : clientes.rua != null) return false;
        if (numtelemovel != null ? !numtelemovel.equals(clientes.numtelemovel) : clientes.numtelemovel != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCliente;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + nif.intValue();
        result = 31 * result + (rua != null ? rua.hashCode() : 0);
        result = 31 * result + codpostal;
        result = 31 * result + (numtelemovel != null ? numtelemovel.hashCode() : 0);
        return result;
    }


}
