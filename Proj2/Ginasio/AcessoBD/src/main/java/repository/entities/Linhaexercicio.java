package repository.entities;

import javax.persistence.*;

@Entity
@Table(name = "linhaexercicio")
public class Linhaexercicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_linhaEx")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idExercicio")
    private Exercicio exercicio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "numPlano")
    private Planotreino planoTreino;

    @Column(name = "peso")
    private Double peso;

    @Column(name = "sets")
    private Integer sets;

    @Column(name = "reps")
    private Integer reps;

    @Column(name = "velocidade")
    private Integer velocidade;

    @Column(name = "duracao")
    private Integer duracao;

    public Linhaexercicio() {
    }

    public Linhaexercicio(Exercicio exercicio, Planotreino planoTreino, Double peso, Integer sets, Integer reps, Integer velocidade, Integer duracao) {
        this.exercicio = exercicio;
        this.planoTreino = planoTreino;
        this.peso = peso;
        this.sets = sets;
        this.reps = reps;
        this.velocidade = velocidade;
        this.duracao = duracao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
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
