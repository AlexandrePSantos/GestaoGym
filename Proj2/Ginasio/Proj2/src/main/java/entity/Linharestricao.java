package entity;

import jakarta.persistence.*;

@Entity
public class Linharestricao {
    @Id
    @Basic
    @Column(name = "idrestricao", nullable = false)
    private int idrestricao;
    @Basic
    @Column(name = "idcliente", nullable = true)
    private Integer idcliente;
    @ManyToOne
    @JoinColumn(referencedColumnName = "idrestricao", nullable = false)
    private Restricaosaude restricaosaudeByIdrestricao;
    @ManyToOne
    @JoinColumn(referencedColumnName = "idcliente")
    private Cliente clienteByIdcliente;

    public int getIdrestricao() {
        return idrestricao;
    }

    public void setIdrestricao(int idrestricao) {
        this.idrestricao = idrestricao;
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

        Linharestricao that = (Linharestricao) o;

        if (idrestricao != that.idrestricao) return false;
        if (idcliente != null ? !idcliente.equals(that.idcliente) : that.idcliente != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idrestricao;
        result = 31 * result + (idcliente != null ? idcliente.hashCode() : 0);
        return result;
    }

    public Restricaosaude getRestricaosaudeByIdrestricao() {
        return restricaosaudeByIdrestricao;
    }

    public void setRestricaosaudeByIdrestricao(Restricaosaude restricaosaudeByIdrestricao) {
        this.restricaosaudeByIdrestricao = restricaosaudeByIdrestricao;
    }

    public Cliente getClienteByIdcliente() {
        return clienteByIdcliente;
    }

    public void setClienteByIdcliente(Cliente clienteByIdcliente) {
        this.clienteByIdcliente = clienteByIdcliente;
    }
}
