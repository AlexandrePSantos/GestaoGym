package repository.entities;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "exercicio")
public class Exercicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idexercicio", nullable = false)
    private Integer id;

    @Column(name = "nome", length = 20)
    private String nome;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idequipamento")
    private Equipamento idequipamento;

    @OneToMany(mappedBy = "idexercicio")
    private Set<Linhaexercicio> linhaexercicios = new LinkedHashSet<>();

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

    public Set<Linhaexercicio> getLinhaexercicios() {
        return linhaexercicios;
    }

    public void setLinhaexercicios(Set<Linhaexercicio> linhaexercicios) {
        this.linhaexercicios = linhaexercicios;
    }

}