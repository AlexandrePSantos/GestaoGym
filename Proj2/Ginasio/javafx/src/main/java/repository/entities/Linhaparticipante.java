package repository.entities;

import javax.persistence.*;

@Entity
@Table(name = "linhaparticipante")
public class Linhaparticipante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_linhapart", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "numaula")
    private Aulagrupo numaula;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idcliente")
    private Cliente idcliente;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Aulagrupo getNumaula() {
        return numaula;
    }

    public void setNumaula(Aulagrupo numaula) {
        this.numaula = numaula;
    }

    public Cliente getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Cliente idcliente) {
        this.idcliente = idcliente;
    }

}