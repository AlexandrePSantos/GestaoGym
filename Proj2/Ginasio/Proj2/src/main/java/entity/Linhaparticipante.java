package entity;

import javax.persistence.*;

@Entity
public class Linhaparticipante {
    @Basic
    @Column(name = "numaula", nullable = true)
    private Integer numaula;
    @Basic
    @Column(name = "idcliente", nullable = true)
    private Integer idcliente;
    @ManyToOne
    @JoinColumn(name = "numaula", referencedColumnName = "numaula")
    private Aulagrupo aulagrupoByNumaula;
    @ManyToOne
    @JoinColumn(name = "idcliente", referencedColumnName = "idcliente")
    private Cliente clienteByIdcliente;

    public Integer getNumaula() {
        return numaula;
    }

    public void setNumaula(Integer numaula) {
        this.numaula = numaula;
    }

    public Integer getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Integer idcliente) {
        this.idcliente = idcliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Linhaparticipante that = (Linhaparticipante) o;

        if (numaula != null ? !numaula.equals(that.numaula) : that.numaula != null) return false;
        if (idcliente != null ? !idcliente.equals(that.idcliente) : that.idcliente != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numaula != null ? numaula.hashCode() : 0;
        result = 31 * result + (idcliente != null ? idcliente.hashCode() : 0);
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
