package repository.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "pagamento")
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numpagamento", nullable = false)
    private Integer id;

    @Column(name = "valor", precision = 5, scale = 2)
    private BigDecimal valor;

    @Column(name = "estado", length = 200)
    private String estado;

    @Column(name = "datapagamento")
    private LocalDate datapagamento;

    @Column(name = "metodo", length = 15)
    private String metodo;

    @Column(name = "referencia", length = 12)
    private String referencia;

    @Column(name = "entidade", length = 6)
    private String entidade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "numsubscricao")
    private Subscricao numsubscricao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public LocalDate getDatapagamento() {
        return datapagamento;
    }

    public void setDatapagamento(LocalDate datapagamento) {
        this.datapagamento = datapagamento;
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

    public Subscricao getNumsubscricao() {
        return numsubscricao;
    }

    public void setNumsubscricao(Subscricao numsubscricao) {
        this.numsubscricao = numsubscricao;
    }

}