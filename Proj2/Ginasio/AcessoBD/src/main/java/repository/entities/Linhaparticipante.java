package repository.entities;

import javax.persistence.*;

@Entity
@Table(name = "linhaparticipante")
public class Linhaparticipante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_linhaPart")
    private int idLinhaPart;

    @ManyToOne
    @JoinColumn(name = "numAula", referencedColumnName = "numAula")
    private Aulagrupo aulagrupo;

    @ManyToOne
    @JoinColumn(name = "idCliente", referencedColumnName = "idCliente")
    private Cliente cliente;

    public int getIdLinhaPart() {
        return idLinhaPart;
    }

    public void setIdLinhaPart(int idLinhaPart) {
        this.idLinhaPart = idLinhaPart;
    }

    public Aulagrupo getAulagrupo() {
        return aulagrupo;
    }

    public void setAulagrupo(Aulagrupo aulagrupo) {
        this.aulagrupo = aulagrupo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
