package repository.entities;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "Planotreino")
public class Planotreino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numPlano")
    private int numPlano;

    @Column(name = "dtCriacao")
    private Date dtCriacao;

    @Column(name = "estado")
    private String estado;

    @ManyToOne
    @JoinColumn(name = "idFuncionario")
    private Funcionario funcionario;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Cliente cliente;

    // getters and setters
    public int getNumPlano() {
        return numPlano;
    }

    public void setNumPlano(int numPlano) {
        this.numPlano = numPlano;
    }

    public Date getDtCriacao() {
        return dtCriacao;
    }

    public void setDtCriacao(Date dtCriacao) {
        this.dtCriacao = dtCriacao;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
