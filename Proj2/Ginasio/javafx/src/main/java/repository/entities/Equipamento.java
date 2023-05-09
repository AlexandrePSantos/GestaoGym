package repository.entities;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "equipamento")
public class Equipamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idequipamento", nullable = false)
    private Integer id;

    @Column(name = "nome", length = 100)
    private String nome;

    @OneToMany(mappedBy = "idequipamento")
    private Set<Exercicio> exercicios = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Exercicio> getExercicios() {
        return exercicios;
    }

    public void setExercicios(Set<Exercicio> exercicios) {
        this.exercicios = exercicios;
    }

}