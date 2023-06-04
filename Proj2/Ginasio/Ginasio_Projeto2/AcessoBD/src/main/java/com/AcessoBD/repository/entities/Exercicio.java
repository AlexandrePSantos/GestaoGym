package com.AcessoBD.repository.entities;

import javax.persistence.*;

@Entity
@Table(name = "Exercicio")
public class Exercicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_exercicio")
    private int idExercicio;

    @Column(name = "nome")
    private String nome;

    @Column(name = "equipamento")
    private String equipamento;


    public Exercicio() {}

    public Exercicio(String nome, String equipamento) {
        this.nome = nome;
        this.equipamento = equipamento;
    }

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

    public String getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(String equipamento) {
        this.equipamento = equipamento;
    }
}
