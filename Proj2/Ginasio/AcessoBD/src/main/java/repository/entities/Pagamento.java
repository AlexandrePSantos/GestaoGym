package repository.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "Pagamento")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numPagamento")
    private int numPagamento;

    @Column(name = "valor")
    private BigDecimal valor;

    @Column(name = "estado")
    private String estado;

    @Column(name = "dataPagamento")
    private Date dataPagamento;

    @Column(name = "metodo")
    private String metodo;

    @Column(name = "referencia")
    private String referencia;

    @Column(name = "entidade")
    private String entidade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "numSubscricao")
    private Subscricao subscricao;

    public int getNumPagamento() {
        return numPagamento;
    }

    public void setNumPagamento(int numPagamento) {
        this.numPagamento = numPagamento;
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

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getEntidade() {
        return entidade;
    }

    public void setEntidade(String entidade) {
        this.entidade = entidade;
    }

    public Subscricao getSubscricao() {
        return subscricao;
    }

    public void setSubscricao(Subscricao subscricao) {
        this.subscricao = subscricao;
    }
}
