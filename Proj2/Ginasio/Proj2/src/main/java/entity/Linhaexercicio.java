package entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Linhaexercicio {
    @Basic
    @Column(name = "idexercicio", nullable = true)
    private Integer idexercicio;
    @Basic
    @Column(name = "numplano", nullable = true)
    private Integer numplano;
    @Basic
    @Column(name = "peso", nullable = true, precision = 1)
    private BigDecimal peso;
    @Basic
    @Column(name = "sets", nullable = true)
    private Integer sets;
    @Basic
    @Column(name = "reps", nullable = true)
    private Integer reps;
    @Basic
    @Column(name = "velocidade", nullable = true)
    private Integer velocidade;
    @Basic
    @Column(name = "duracao", nullable = true)
    private Integer duracao;
    @ManyToOne
    @JoinColumn(name = "idexercicio", referencedColumnName = "idexercicio")
    private Exercicio exercicioByIdexercicio;
    @ManyToOne
    @JoinColumn(name = "numplano", referencedColumnName = "numplano")
    private Planotreino planotreinoByNumplano;

    public Integer getIdexercicio() {
        return idexercicio;
    }

    public void setIdexercicio(Integer idexercicio) {
        this.idexercicio = idexercicio;
    }

    public Integer getNumplano() {
        return numplano;
    }

    public void setNumplano(Integer numplano) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Linhaexercicio that = (Linhaexercicio) o;

        if (idexercicio != null ? !idexercicio.equals(that.idexercicio) : that.idexercicio != null) return false;
        if (numplano != null ? !numplano.equals(that.numplano) : that.numplano != null) return false;
        if (peso != null ? !peso.equals(that.peso) : that.peso != null) return false;
        if (sets != null ? !sets.equals(that.sets) : that.sets != null) return false;
        if (reps != null ? !reps.equals(that.reps) : that.reps != null) return false;
        if (velocidade != null ? !velocidade.equals(that.velocidade) : that.velocidade != null) return false;
        if (duracao != null ? !duracao.equals(that.duracao) : that.duracao != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idexercicio != null ? idexercicio.hashCode() : 0;
        result = 31 * result + (numplano != null ? numplano.hashCode() : 0);
        result = 31 * result + (peso != null ? peso.hashCode() : 0);
        result = 31 * result + (sets != null ? sets.hashCode() : 0);
        result = 31 * result + (reps != null ? reps.hashCode() : 0);
        result = 31 * result + (velocidade != null ? velocidade.hashCode() : 0);
        result = 31 * result + (duracao != null ? duracao.hashCode() : 0);
        return result;
    }

    public Exercicio getExercicioByIdexercicio() {
        return exercicioByIdexercicio;
    }

    public void setExercicioByIdexercicio(Exercicio exercicioByIdexercicio) {
        this.exercicioByIdexercicio = exercicioByIdexercicio;
    }

    public Planotreino getPlanotreinoByNumplano() {
        return planotreinoByNumplano;
    }

    public void setPlanotreinoByNumplano(Planotreino planotreinoByNumplano) {
        this.planotreinoByNumplano = planotreinoByNumplano;
    }
}
