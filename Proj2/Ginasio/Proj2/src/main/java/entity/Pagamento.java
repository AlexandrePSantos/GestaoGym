package entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Date;

@Entity
public class Pagamento {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "numpagamento", nullable = false)
    private int numpagamento;
    @Basic
    @Column(name = "valor", nullable = true, precision = 2)
    private BigDecimal valor;
    @Basic
    @Column(name = "estado", nullable = true, length = 20)
    private String estado;
    @Basic
    @Column(name = "datalimite", nullable = true)
    private Date datalimite;
    @Basic
    @Column(name = "dataefetuado", nullable = true)
    private Date dataefetuado;
    @Basic
    @Column(name = "metodopag", nullable = true, length = 100)
    private String metodopag;
    @Basic
    @Column(name = "numsubscricao", nullable = true)
    private Integer numsubscricao;
    @ManyToOne
    @JoinColumn(name = "numsubscricao", referencedColumnName = "numsubscricao")
    private Subscricao subscricaoByNumsubscricao;

    public int getNumpagamento() {
        return numpagamento;
    }

    public void setNumpagamento(int numpagamento) {
        this.numpagamento = numpagamento;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getDatalimite() {
        return datalimite;
    }

    public void setDatalimite(Date datalimite) {
        this.datalimite = datalimite;
    }

    public Date getDataefetuado() {
        return dataefetuado;
    }

    public void setDataefetuado(Date dataefetuado) {
        this.dataefetuado = dataefetuado;
    }

    public String getMetodopag() {
        return metodopag;
    }

    public void setMetodopag(String metodopag) {
        this.metodopag = metodopag;
    }

    public Integer getNumsubscricao() {
        return numsubscricao;
    }

    public void setNumsubscricao(Integer numsubscricao) {
        this.numsubscricao = numsubscricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pagamento pagamento = (Pagamento) o;

        if (numpagamento != pagamento.numpagamento) return false;
        if (valor != null ? !valor.equals(pagamento.valor) : pagamento.valor != null) return false;
        if (estado != null ? !estado.equals(pagamento.estado) : pagamento.estado != null) return false;
        if (datalimite != null ? !datalimite.equals(pagamento.datalimite) : pagamento.datalimite != null) return false;
        if (dataefetuado != null ? !dataefetuado.equals(pagamento.dataefetuado) : pagamento.dataefetuado != null)
            return false;
        if (metodopag != null ? !metodopag.equals(pagamento.metodopag) : pagamento.metodopag != null) return false;
        if (numsubscricao != null ? !numsubscricao.equals(pagamento.numsubscricao) : pagamento.numsubscricao != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numpagamento;
        result = 31 * result + (valor != null ? valor.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        result = 31 * result + (datalimite != null ? datalimite.hashCode() : 0);
        result = 31 * result + (dataefetuado != null ? dataefetuado.hashCode() : 0);
        result = 31 * result + (metodopag != null ? metodopag.hashCode() : 0);
        result = 31 * result + (numsubscricao != null ? numsubscricao.hashCode() : 0);
        return result;
    }

    public Subscricao getSubscricaoByNumsubscricao() {
        return subscricaoByNumsubscricao;
    }

    public void setSubscricaoByNumsubscricao(Subscricao subscricaoByNumsubscricao) {
        this.subscricaoByNumsubscricao = subscricaoByNumsubscricao;
    }
}
