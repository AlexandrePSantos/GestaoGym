package entity;

import jakarta.persistence.*;

@Entity
public class Linhaparticipante {

    @Id
    @Basic
    @Column(name = "numaula", nullable = false)
    private int numaula;
    @Basic
    @Column(name = "idcliente", nullable = false)
    private int idcliente;
    @ManyToOne
    @JoinColumn(referencedColumnName = "numaula", nullable = false)
    private Aulagrupo aulagrupoByNumaula;
    @ManyToOne
    @JoinColumn(referencedColumnName = "idcliente", nullable = false)
    private Cliente clienteByIdcliente;

    public int getNumaula() {
        return numaula;
    }

    public void setNumaula(int numaula) {
        this.numaula = numaula;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Linhaparticipante that = (Linhaparticipante) o;

        if (numaula != that.numaula) return false;
        if (idcliente != that.idcliente) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numaula;
        result = 31 * result + idcliente;
        return result;
    }

    public Aulagrupo getAulagrupoByNumaula() {
        return aulagrupoByNumaula;
    }

    public void setAulagrupoByNumaula(Aulagrupo aulagrupoByNumaula) {
        this.aulagrupoByNumaula = aulagrupoByNumaula;
    }

    public Cliente getClienteByIdcliente() {
        return clienteByIdcliente;
    }

    public void setClienteByIdcliente(Cliente clienteByIdcliente) {
        this.clienteByIdcliente = clienteByIdcliente;
    }
}
