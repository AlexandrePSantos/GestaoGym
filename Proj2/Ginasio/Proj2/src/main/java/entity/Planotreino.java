package entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;

@Entity
public class Planotreino {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "numplano", nullable = false)
    private int numplano;
    @Basic
    @Column(name = "dtcriacao", nullable = true)
    private Date dtcriacao;
    @Basic
    @Column(name = "estado", nullable = true, length = 20)
    private String estado;
    @Basic
    @Column(name = "idfuncionario", nullable = true)
    private Integer idfuncionario;
    @Basic
    @Column(name = "idcliente", nullable = true)
    private Integer idcliente;
    @OneToMany(mappedBy = "planotreinoByNumplano")
    private Collection<Linhaexercicio> linhaexerciciosByNumplano;
    @ManyToOne
    @JoinColumn(name = "idfuncionario", referencedColumnName = "idfuncionario")
    private Funcionario funcionarioByIdfuncionario;
    @ManyToOne
    @JoinColumn(name = "idcliente", referencedColumnName = "idcliente")
    private Cliente clienteByIdcliente;

    public int getNumplano() {
        return numplano;
    }

    public void setNumplano(int numplano) {
        this.numplano = numplano;
    }

    public Date getDtcriacao() {
        return dtcriacao;
    }

    public void setDtcriacao(Date dtcriacao) {
        this.dtcriacao = dtcriacao;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getIdfuncionario() {
        return idfuncionario;
    }

    public void setIdfuncionario(Integer idfuncionario) {
        this.idfuncionario = idfuncionario;
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

        Planotreino that = (Planotreino) o;

        if (numplano != that.numplano) return false;
        if (dtcriacao != null ? !dtcriacao.equals(that.dtcriacao) : that.dtcriacao != null) return false;
        if (estado != null ? !estado.equals(that.estado) : that.estado != null) return false;
        if (idfuncionario != null ? !idfuncionario.equals(that.idfuncionario) : that.idfuncionario != null)
            return false;
        if (idcliente != null ? !idcliente.equals(that.idcliente) : that.idcliente != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numplano;
        result = 31 * result + (dtcriacao != null ? dtcriacao.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        result = 31 * result + (idfuncionario != null ? idfuncionario.hashCode() : 0);
        result = 31 * result + (idcliente != null ? idcliente.hashCode() : 0);
        return result;
    }

    public Collection<Linhaexercicio> getLinhaexerciciosByNumplano() {
        return linhaexerciciosByNumplano;
    }

    public void setLinhaexerciciosByNumplano(Collection<Linhaexercicio> linhaexerciciosByNumplano) {
        this.linhaexerciciosByNumplano = linhaexerciciosByNumplano;
    }

    public Funcionario getFuncionarioByIdfuncionario() {
        return funcionarioByIdfuncionario;
    }

    public void setFuncionarioByIdfuncionario(Funcionario funcionarioByIdfuncionario) {
        this.funcionarioByIdfuncionario = funcionarioByIdfuncionario;
    }

    public Cliente getClienteByIdcliente() {
        return clienteByIdcliente;
    }

    public void setClienteByIdcliente(Cliente clienteByIdcliente) {
        this.clienteByIdcliente = clienteByIdcliente;
    }
}
