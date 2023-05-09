package repository.entities;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "AulaGrupo")
public class Aulagrupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numAula")
    private int numAula;

    @Column(name = "dataAula")
    private Date dataAula;

    @Column(name = "tipoAula")
    private String tipoAula;

    @Column(name = "vagas")
    private int vagas;

    @Column(name = "vagasDisp")
    private int vagasDisp;

    @Column(name = "duracao")
    private int duracao;

    @ManyToOne
    @JoinColumn(name = "idSala")
    private Sala sala;

    @ManyToOne
    @JoinColumn(name = "idFuncionario")
    private Funcionario funcionario;

    public int getNumAula() {
        return numAula;
    }

    public void setNumAula(int numAula) {
        this.numAula = numAula;
    }

    public Date getDataAula() {
        return dataAula;
    }

    public void setDataAula(Date dataAula) {
        this.dataAula = dataAula;
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
