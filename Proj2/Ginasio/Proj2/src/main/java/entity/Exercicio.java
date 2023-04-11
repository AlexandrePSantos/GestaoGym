package entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Exercicio {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idexercicio", nullable = false)
    private int idexercicio;
    @Basic
    @Column(name = "nome", nullable = true, length = 20)
    private String nome;
    @Basic
    @Column(name = "idequipamento", nullable = true)
    private Integer idequipamento;
    @ManyToOne(optional = false)
    @JoinColumn(referencedColumnName = "idequipamento")
    private Equipamento equipamentoByIdequipamento;
    @OneToMany(mappedBy = "exercicioByIdexercicio")
    private Collection<Linhaexercicio> linhaexerciciosByIdexercicio;

    public int getIdexercicio() {
        return idexercicio;
    }

    public void setIdexercicio(int idexercicio) {
        this.idexercicio = idexercicio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdequipamento() {
        return idequipamento;
    }

    public void setIdequipamento(Integer idequipamento) {
        this.idequipamento = idequipamento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Exercicio exercicio = (Exercicio) o;

        if (idexercicio != exercicio.idexercicio) return false;
        if (nome != null ? !nome.equals(exercicio.nome) : exercicio.nome != null) return false;
        if (idequipamento != null ? !idequipamento.equals(exercicio.idequipamento) : exercicio.idequipamento != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idexercicio;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (idequipamento != null ? idequipamento.hashCode() : 0);
        return result;
    }

    public Equipamento getEquipamentoByIdequipamento() {
        return equipamentoByIdequipamento;
    }

    public void setEquipamentoByIdequipamento(Equipamento equipamentoByIdequipamento) {
        this.equipamentoByIdequipamento = equipamentoByIdequipamento;
    }

    public Collection<Linhaexercicio> getLinhaexerciciosByIdexercicio() {
        return linhaexerciciosByIdexercicio;
    }

    public void setLinhaexerciciosByIdexercicio(Collection<Linhaexercicio> linhaexerciciosByIdexercicio) {
        this.linhaexerciciosByIdexercicio = linhaexerciciosByIdexercicio;
    }
}
