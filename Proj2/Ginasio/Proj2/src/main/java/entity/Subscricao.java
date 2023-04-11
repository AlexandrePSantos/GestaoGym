package entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Collection;

@Entity
public class Subscricao {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "numsubscricao", nullable = false)
    private int numsubscricao;
    @Basic
    @Column(name = "idcliente", nullable = true)
    private Integer idcliente;
    @Basic
    @Column(name = "duracao", nullable = true)
    private Integer duracao;
    @Basic
    @Column(name = "dataini", nullable = true)
    private Date dataini;
    @Basic
    @Column(name = "datafim", nullable = true)
    private Date datafim;
    @Basic
    @Column(name = "valemfalta", nullable = true, precision = 2)
    private BigDecimal valemfalta;
    @Basic
    @Column(name = "valtotal", nullable = true, precision = 2)
    private BigDecimal valtotal;
    @Basic
    @Column(name = "estado", nullable = true, length = 50)
    private String estado;
    @OneToMany(mappedBy = "subscricaoByNumsubscricao")
    private Collection<Pagamento> pagamentosByNumsubscricao;
    @ManyToOne
    @JoinColumn(name = "idcliente", referencedColumnName = "idcliente")
    private Cliente clienteByIdcliente;

    public int getNumsubscricao() {
        return numsubscricao;
    }

    public void setNumsubscricao(int numsubscricao) {
        this.numsubscricao = numsubscricao;
    }

    public Integer getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Integer idcliente) {
        this.idcliente = idcliente;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    public Date getDataini() {
        return dataini;
    }

    public void setDataini(Date dataini) {
        this.dataini = dataini;
    }

    public Date getDatafim() {
        return datafim;
    }

    public void setDatafim(Date datafim) {
        this.datafim = datafim;
    }

    public BigDecimal getValemfalta() {
        return valemfalta;
    }

    public void setValemfalta(BigDecimal valemfalta) {
        this.valemfalta = valemfalta;
    }

    public BigDecimal getValtotal() {
        return valtotal;
    }

    public void setValtotal(BigDecimal valtotal) {
        this.valtotal = valtotal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Subscricao that = (Subscricao) o;

        if (numsubscricao != that.numsubscricao) return false;
        if (idcliente != null ? !idcliente.equals(that.idcliente) : that.idcliente != null) return false;
        if (duracao != null ? !duracao.equals(that.duracao) : that.duracao != null) return false;
        if (dataini != null ? !dataini.equals(that.dataini) : that.dataini != null) return false;
        if (datafim != null ? !datafim.equals(that.datafim) : that.datafim != null) return false;
        if (valemfalta != null ? !valemfalta.equals(that.valemfalta) : that.valemfalta != null) return false;
        if (valtotal != null ? !valtotal.equals(that.valtotal) : that.valtotal != null) return false;
        if (estado != null ? !estado.equals(that.estado) : that.estado != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numsubscricao;
        result = 31 * result + (idcliente != null ? idcliente.hashCode() : 0);
        result = 31 * result + (duracao != null ? duracao.hashCode() : 0);
        result = 31 * result + (dataini != null ? dataini.hashCode() : 0);
        result = 31 * result + (datafim != null ? datafim.hashCode() : 0);
        result = 31 * result + (valemfalta != null ? valemfalta.hashCode() : 0);
        result = 31 * result + (valtotal != null ? valtotal.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        return result;
    }

    public Collection<Pagamento> getPagamentosByNumsubscricao() {
        return pagamentosByNumsubscricao;
    }

    public void setPagamentosByNumsubscricao(Collection<Pagamento> pagamentosByNumsubscricao) {
        this.pagamentosByNumsubscricao = pagamentosByNumsubscricao;
    }

    public Cliente getClienteByIdcliente() {
        return clienteByIdcliente;
    }

    public void setClienteByIdcliente(Cliente clienteByIdcliente) {
        this.clienteByIdcliente = clienteByIdcliente;
    }
}
