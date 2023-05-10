package repository.entities;

import javax.persistence.*;

@Entity
@Table(name = "Equipamento")
public class Equipamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_equipamento")
    private Integer idEquipamento;

    @Column(name = "nome")
    private String nome;

    public Equipamento() {

    }

    public Equipamento(String nome) {
        this.nome = nome;
    }

    public Integer getIdEquipamento() {
        return idEquipamento;
    }

    public void setIdEquipamento(Integer idEquipamento) {
        this.idEquipamento = idEquipamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
