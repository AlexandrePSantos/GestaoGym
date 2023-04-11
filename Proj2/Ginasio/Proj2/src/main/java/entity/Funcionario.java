package entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Collection;

@Entity
public class Funcionario {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idfuncionario", nullable = false)
    private int idfuncionario;
    @Basic
    @Column(name = "nome", nullable = true, length = 100)
    private String nome;
    @Basic
    @Column(name = "email", nullable = true, length = 100)
    private String email;
    @Basic
    @Column(name = "telemovel", nullable = true, length = 10)
    private String telemovel;
    @Basic
    @Column(name = "nif", nullable = true, length = 10)
    private String nif;
    @Basic
    @Column(name = "dtnascimento", nullable = true)
    private Date dtnascimento;
    @Basic
    @Column(name = "salarioliquido", nullable = true, precision = 1)
    private BigDecimal salarioliquido;
    @Basic
    @Column(name = "funcao", nullable = true, length = 50)
    private String funcao;
    @OneToMany(mappedBy = "funcionarioByIdfuncionario")
    private Collection<Aulagrupo> aulagruposByIdfuncionario;
    @OneToMany(mappedBy = "funcionarioByIdfuncionario")
    private Collection<Planotreino> planotreinosByIdfuncionario;

    public int getIdfuncionario() {
        return idfuncionario;
    }

    public void setIdfuncionario(int idfuncionario) {
        this.idfuncionario = idfuncionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelemovel() {
        return telemovel;
    }

    public void setTelemovel(String telemovel) {
        this.telemovel = telemovel;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public Date getDtnascimento() {
        return dtnascimento;
    }

    public void setDtnascimento(Date dtnascimento) {
        this.dtnascimento = dtnascimento;
    }

    public BigDecimal getSalarioliquido() {
        return salarioliquido;
    }

    public void setSalarioliquido(BigDecimal salarioliquido) {
        this.salarioliquido = salarioliquido;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Funcionario that = (Funcionario) o;

        if (idfuncionario != that.idfuncionario) return false;
        if (nome != null ? !nome.equals(that.nome) : that.nome != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (telemovel != null ? !telemovel.equals(that.telemovel) : that.telemovel != null) return false;
        if (nif != null ? !nif.equals(that.nif) : that.nif != null) return false;
        if (dtnascimento != null ? !dtnascimento.equals(that.dtnascimento) : that.dtnascimento != null) return false;
        if (salarioliquido != null ? !salarioliquido.equals(that.salarioliquido) : that.salarioliquido != null)
            return false;
        if (funcao != null ? !funcao.equals(that.funcao) : that.funcao != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idfuncionario;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (telemovel != null ? telemovel.hashCode() : 0);
        result = 31 * result + (nif != null ? nif.hashCode() : 0);
        result = 31 * result + (dtnascimento != null ? dtnascimento.hashCode() : 0);
        result = 31 * result + (salarioliquido != null ? salarioliquido.hashCode() : 0);
        result = 31 * result + (funcao != null ? funcao.hashCode() : 0);
        return result;
    }

    public Collection<Aulagrupo> getAulagruposByIdfuncionario() {
        return aulagruposByIdfuncionario;
    }

    public void setAulagruposByIdfuncionario(Collection<Aulagrupo> aulagruposByIdfuncionario) {
        this.aulagruposByIdfuncionario = aulagruposByIdfuncionario;
    }

    public Collection<Planotreino> getPlanotreinosByIdfuncionario() {
        return planotreinosByIdfuncionario;
    }

    public void setPlanotreinosByIdfuncionario(Collection<Planotreino> planotreinosByIdfuncionario) {
        this.planotreinosByIdfuncionario = planotreinosByIdfuncionario;
    }
}
