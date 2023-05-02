package entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "linhaexercicio")
public class Linhaexercicio {
    @Id
    @Column(name = "id_linhaex", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idexercicio")
    private Exercicio idexercicio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "numplano")
    private Planotreino numplano;

    @Column(name = "peso", precision = 4, scale = 1)
    private BigDecimal peso;

    @Column(name = "sets")
    private Integer sets;

    @Column(name = "reps")
    private Integer reps;

    @Column(name = "velocidade")
    private Integer velocidade;

    @Column(name = "duracao")
    private Integer duracao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Exercicio getIdexercicio() {
        return idexercicio;
    }

    public void setIdexercicio(Exercicio idexercicio) {
        this.idexercicio = idexercicio;
    }

    public Planotreino getNumplano() {
        return numplano;
    }

    public void setNumplano(Planotreino numplano) {
        this.numplano = numplano;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public Integer getSets() {
        return sets;
    }

    public void setSets(Integer sets) {
        this.sets = sets;
    }

    public Integer getReps() {
        return reps;
    }

    public void setReps(Integer reps) {
        this.reps = reps;
    }

    public Integer getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(Integer velocidade) {
        this.velocidade = velocidade;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

}