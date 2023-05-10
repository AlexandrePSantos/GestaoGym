package repository.entities;

import java.math.BigDecimal;
import javax.persistence.*;

@Entity
@Table(name = "Linhaexercicio")
public class Linhaexercicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_linhaEx")
    private int idLinhaExercicio;

    @ManyToOne
    @JoinColumn(name = "id_exercicio", referencedColumnName = "id_exercicio")
    private Exercicio exercicio;

    @ManyToOne
    @JoinColumn(name = "num_plano", referencedColumnName = "num_plano")
    private Planotreino planoTreino;

    @Column(name = "peso")
    private BigDecimal peso;

    @Column(name = "sets")
    private int sets;

    @Column(name = "reps")
    private int reps;

    @Column(name = "velocidade")
    private int velocidade;

    @Column(name = "duracao")
    private BigDecimal duracao;

    public Linhaexercicio() {}

    public Linhaexercicio(Exercicio exercicio, Planotreino planoTreino, BigDecimal peso, int sets, int reps, int velocidade, BigDecimal duracao) {
        this.exercicio = exercicio;
        this.planoTreino = planoTreino;
        this.peso = peso;
        this.sets = sets;
        this.reps = reps;
        this.velocidade = velocidade;
        this.duracao = duracao;
    }

    public int getIdLinhaExercicio() {
        return idLinhaExercicio;
    }

    public void setIdLinhaExercicio(int idLinhaExercicio) {
        this.idLinhaExercicio = idLinhaExercicio;
    }

    public Exercicio getExercicio() {
        return exercicio;
    }

    public void setExercicio(Exercicio exercicio) {
        this.exercicio = exercicio;
    }

    public Planotreino getPlanoTreino() {
        return planoTreino;
    }

    public void setPlanoTreino(Planotreino planoTreino) {
        this.planoTreino = planoTreino;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public BigDecimal getDuracao() {
        return duracao;
    }

    public void setDuracao(BigDecimal duracao) {
        this.duracao = duracao;
    }
}
