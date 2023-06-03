package com.AcessoBD.repository.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "Aulagrupo")
public class Aulagrupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "num_aula")
    private int numAula;

    @Column(name = "data_aula")
    private LocalDate dataAula;

    @Column(name = "hora_aula")
    private LocalTime horaAula;

    @Column(name = "tipo_aula")
    private String tipoAula;

    @Column(name = "vagas")
    private int vagas;

    @Column(name = "vagas_disp")
    private int vagasDisp;

    @Column(name = "duracao")
    private int duracao;

    @ManyToOne
    @JoinColumn(name = "id_sala")
    private Sala sala;

    @ManyToOne
    @JoinColumn(name = "id_funcionario")
    private Funcionario funcionario;

    public Aulagrupo() {}

    public Aulagrupo(LocalDate dataAula, LocalTime horaAula, String tipoAula, int vagas, int vagasDisp, int duracao, Sala sala, Funcionario funcionario) {
        this.dataAula = dataAula;
        this.horaAula = horaAula;
        this.tipoAula = tipoAula;
        this.vagas = vagas;
        this.vagasDisp = vagasDisp;
        this.duracao = duracao;
        this.sala = sala;
        this.funcionario = funcionario;
    }

    public int getNumAula() {
        return numAula;
    }

    public void setNumAula(int numAula) {
        this.numAula = numAula;
    }

    public LocalDate getDataAula() {
        return dataAula;
    }

    public void setDataAula(LocalDate dataAula) {
        this.dataAula = dataAula;
    }

    public LocalTime getHoraAula() {
        return horaAula;
    }

    public void setHoraAula(LocalTime horaAula) {
        this.horaAula = horaAula;
    }

    public String getTipoAula() {
        return tipoAula;
    }

    public void setTipoAula(String tipoAula) {
        this.tipoAula = tipoAula;
    }

    public int getVagas() {
        return vagas;
    }

    public void setVagas(int vagas) {
        this.vagas = vagas;
    }

    public int getVagasDisp() {
        return vagasDisp;
    }

    public void setVagasDisp(int vagasDisp) {
        this.vagasDisp = vagasDisp;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
}
