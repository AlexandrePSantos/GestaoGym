package entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
public class Aulagrupo {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "numaula", nullable = false)
    private int numaula;
    @Basic
    @Column(name = "dataaula", nullable = true)
    private Date dataaula;
    @Basic
    @Column(name = "tipoaula", nullable = true, length = 50)
    private String tipoaula;
    @Basic
    @Column(name = "vagas", nullable = true)
    private Integer vagas;
    @Basic
    @Column(name = "vagasdisp", nullable = true)
    private Integer vagasdisp;
    @Basic
    @Column(name = "duracao", nullable = true)
    private Integer duracao;
    @Basic
    @Column(name = "idsala", nullable = true)
    private Integer idsala;
    @Basic
    @Column(name = "idfuncionario", nullable = true)
    private Integer idfuncionario;
    @ManyToOne
    @JoinColumn(name = "idsala", referencedColumnName = "idsala")
    private Sala salaByIdsala;
    @ManyToOne
    @JoinColumn(name = "idfuncionario", referencedColumnName = "idfuncionario")
    private Funcionario funcionarioByIdfuncionario;
    @OneToMany(mappedBy = "aulagrupoByNumaula")
    private Collection<Linhaparticipante> linhaparticipantesByNumaula;

    public int getNumaula() {
        return numaula;
    }

    public void setNumaula(int numaula) {
        this.numaula = numaula;
    }

    public Date getDataaula() {
        return dataaula;
    }

    public void setDataaula(Date dataaula) {
        this.dataaula = dataaula;
    }

    public String getTipoaula() {
        return tipoaula;
    }

    public void setTipoaula(String tipoaula) {
        this.tipoaula = tipoaula;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }

    public Integer getVagasdisp() {
        return vagasdisp;
    }

    public void setVagasdisp(Integer vagasdisp) {
        this.vagasdisp = vagasdisp;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    public Integer getIdsala() {
        return idsala;
    }

    public void setIdsala(Integer idsala) {
        this.idsala = idsala;
    }

    public Integer getIdfuncionario() {
        return idfuncionario;
    }

    public void setIdfuncionario(Integer idfuncionario) {
        this.idfuncionario = idfuncionario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Aulagrupo aulagrupo = (Aulagrupo) o;

        if (numaula != aulagrupo.numaula) return false;
        if (dataaula != null ? !dataaula.equals(aulagrupo.dataaula) : aulagrupo.dataaula != null) return false;
        if (tipoaula != null ? !tipoaula.equals(aulagrupo.tipoaula) : aulagrupo.tipoaula != null) return false;
        if (vagas != null ? !vagas.equals(aulagrupo.vagas) : aulagrupo.vagas != null) return false;
        if (vagasdisp != null ? !vagasdisp.equals(aulagrupo.vagasdisp) : aulagrupo.vagasdisp != null) return false;
        if (duracao != null ? !duracao.equals(aulagrupo.duracao) : aulagrupo.duracao != null) return false;
        if (idsala != null ? !idsala.equals(aulagrupo.idsala) : aulagrupo.idsala != null) return false;
        if (idfuncionario != null ? !idfuncionario.equals(aulagrupo.idfuncionario) : aulagrupo.idfuncionario != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numaula;
        result = 31 * result + (dataaula != null ? dataaula.hashCode() : 0);
        result = 31 * result + (tipoaula != null ? tipoaula.hashCode() : 0);
        result = 31 * result + (vagas != null ? vagas.hashCode() : 0);
        result = 31 * result + (vagasdisp != null ? vagasdisp.hashCode() : 0);
        result = 31 * result + (duracao != null ? duracao.hashCode() : 0);
        result = 31 * result + (idsala != null ? idsala.hashCode() : 0);
        result = 31 * result + (idfuncionario != null ? idfuncionario.hashCode() : 0);
        return result;
    }

    public Sala getSalaByIdsala() {
        return salaByIdsala;
    }

    public void setSalaByIdsala(Sala salaByIdsala) {
        this.salaByIdsala = salaByIdsala;
    }

    public Funcionario getFuncionarioByIdfuncionario() {
        return funcionarioByIdfuncionario;
    }

    public void setFuncionarioByIdfuncionario(Funcionario funcionarioByIdfuncionario) {
        this.funcionarioByIdfuncionario = funcionarioByIdfuncionario;
    }

    public Collection<Linhaparticipante> getLinhaparticipantesByNumaula() {
        return linhaparticipantesByNumaula;
    }

    public void setLinhaparticipantesByNumaula(Collection<Linhaparticipante> linhaparticipantesByNumaula) {
        this.linhaparticipantesByNumaula = linhaparticipantesByNumaula;
    }
}
