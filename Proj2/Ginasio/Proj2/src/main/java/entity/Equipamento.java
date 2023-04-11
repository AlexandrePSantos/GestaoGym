package entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Equipamento {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idequipamento", nullable = false)
    private int idequipamento;
    @Basic
    @Column(name = "nome", nullable = true, length = 100)
    private String nome;
    @OneToMany(mappedBy = "equipamentoByIdequipamento")
    private Collection<Exercicio> exerciciosByIdequipamento;

    public int getIdequipamento() {
        return idequipamento;
    }

    public void setIdequipamento(int idequipamento) {
        this.idequipamento = idequipamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Equipamento that = (Equipamento) o;

        if (idequipamento != that.idequipamento) return false;
        if (nome != null ? !nome.equals(that.nome) : that.nome != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idequipamento;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        return result;
    }

    public Collection<Exercicio> getExerciciosByIdequipamento() {
        return exerciciosByIdequipamento;
    }

    public void setExerciciosByIdequipamento(Collection<Exercicio> exerciciosByIdequipamento) {
        this.exerciciosByIdequipamento = exerciciosByIdequipamento;
    }
}
