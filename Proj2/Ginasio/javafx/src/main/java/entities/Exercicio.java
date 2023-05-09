package entities;

import javax.persistence.*;

@Entity
@Table(name = "exercicio")
public class Exercicio {
    @Id
    @Column(name = "idexercicio", nullable = false)
    private Integer id;

    @Column(name = "nome", length = 20)
    private String nome;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idequipamento")
    private Equipamento idequipamento;

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

    public Equipamento getIdequipamento() {
        return idequipamento;
    }

    public void setIdequipamento(Equipamento idequipamento) {
        this.idequipamento = idequipamento;
    }

}