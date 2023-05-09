package repository.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "planotreino")
public class Planotreino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numplano", nullable = false)
    private Integer id;

    @Column(name = "dtcriacao")
    private LocalDate dtcriacao;

    @Column(name = "estado", length = 20)
    private String estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idfuncionario")
    private Funcionario idfuncionario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idcliente")
    private Cliente idcliente;

    @OneToMany(mappedBy = "numplano")
    private Set<Linhaexercicio> linhaexercicios = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDtcriacao() {
        return dtcriacao;
    }

    public void setDtcriacao(LocalDate dtcriacao) {
        this.dtcriacao = dtcriacao;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Funcionario getIdfuncionario() {
        return idfuncionario;
    }

    public void setIdfuncionario(Funcionario idfuncionario) {
        this.idfuncionario = idfuncionario;
    }

    public Cliente getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Cliente idcliente) {
        this.idcliente = idcliente;
    }

    public Set<Linhaexercicio> getLinhaexercicios() {
        return linhaexercicios;
    }

    public void setLinhaexercicios(Set<Linhaexercicio> linhaexercicios) {
        this.linhaexercicios = linhaexercicios;
    }

}