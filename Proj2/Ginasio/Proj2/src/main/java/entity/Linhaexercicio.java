package entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Linhaexercicio {
    @Id
    @Basic
    @Column(name = "idexercicio", nullable = false)
    private int idexercicio;
    @Basic
    @Column(name = "numplano", nullable = false)
    private int numplano;
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
    @JoinColumn(referencedColumnName = "idexercicio", nullable = false)
    private Exercicio exercicioByIdexercicio;
    @ManyToOne
    @JoinColumn(referencedColumnName = "numplano", nullable = false)
    private Planotreino planotreinoByNumplano;

    public int getIdexercicio() {
        return idexercicio;
    }

    public void setIdexercicio(int idexercicio) {
        this.idexercicio = idexercicio;
    }

    public int getNumplano() {
        return numplano;
    }

    public void setNumplano(int numplano) {
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

        if (idexercicio != that.idexercicio) return false;
        if (numplano != that.numplano) return false;
        if (peso != null ? !peso.equals(that.peso) : that.peso != null) return false;
        if (sets != null ? !sets.equals(that.sets) : that.sets != null) return false;
        if (reps != null ? !reps.equals(that.reps) : that.reps != null) return false;
        if (velocidade != null ? !velocidade.equals(that.velocidade) : that.velocidade != null) return false;
        if (duracao != null ? !duracao.equals(that.duracao) : that.duracao != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idexercicio;
        result = 31 * result + numplano;
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
