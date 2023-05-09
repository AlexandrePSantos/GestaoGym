package repository.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "aulagrupo")
public class Aulagrupo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numaula", nullable = false)
    private Integer id;

    @Column(name = "dataaula")
    private LocalDate dataaula;

    @Column(name = "tipoaula", length = 50)
    private String tipoaula;

    @Column(name = "vagas")
    private Integer vagas;

    @Column(name = "vagasdisp")
    private Integer vagasdisp;

    @Column(name = "duracao")
    private Integer duracao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idsala")
    private Sala idsala;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idfuncionario")
    private Funcionario idfuncionario;

    @OneToMany(mappedBy = "numaula")
    private Set<Linhaparticipante> linhaparticipantes = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDataaula() {
        return dataaula;
    }

    public void setDataaula(LocalDate dataaula) {
        this.dataaula = dataaula;
    }

    public String getTipoaula() {
        return tipoaula;
    }

    public void setTipoaula(String tipoaula) {
        this.tipoaula = tipoaula;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }

    public Integer getVagasdisp() {
        return vagasdisp;
    }

    public void setVagasdisp(Integer vagasdisp) {
        this.vagasdisp = vagasdisp;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    public Sala getIdsala() {
        return idsala;
    }

    public void setIdsala(Sala idsala) {
        this.idsala = idsala;
    }

    public Funcionario getIdfuncionario() {
        return idfuncionario;
    }

    public void setIdfuncionario(Funcionario idfuncionario) {
        this.idfuncionario = idfuncionario;
    }

    public Set<Linhaparticipante> getLinhaparticipantes() {
        return linhaparticipantes;
    }

    public void setLinhaparticipantes(Set<Linhaparticipante> linhaparticipantes) {
        this.linhaparticipantes = linhaparticipantes;
    }

}