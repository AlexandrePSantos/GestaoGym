package repository.entities;

import javax.persistence.*;

@Entity
@Table(name = "Exercicio")
public class Exercicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idExercicio")
    private int idExercicio;

    @Column(name = "nome")
    private String nome;

    @ManyToOne
    @JoinColumn(name = "idEquipamento")
    private Equipamento equipamento;

    public int getIdExercicio() {
        return idExercicio;
    }

    public void setIdExercicio(int idExercicio) {
        this.idExercicio = idExercicio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    @Override
    public String toString() {
        return "Exercicio [idExercicio=" + idExercicio + ", nome=" + nome + ", equipamento=" + equipamento + "]";
    }
}
