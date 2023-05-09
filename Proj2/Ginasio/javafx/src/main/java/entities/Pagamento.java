package entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "pagamento")
public class Pagamento {
    @Id
    @Column(name = "numpagamento", nullable = false)
    private Integer id;

    @Column(name = "valor", precision = 5, scale = 2)
    private BigDecimal valor;

    @Column(name = "estado", length = 20)
    private String estado;

    @Column(name = "datalimite")
    private LocalDate datalimite;

    @Column(name = "dataefetuado")
    private LocalDate dataefetuado;

    @Column(name = "metodopag", length = 100)
    private String metodopag;

    @Column(name = "referencia", length = 10)
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

    public LocalDate getDatalimite() {
        return datalimite;
    }

    public void setDatalimite(LocalDate datalimite) {
        this.datalimite = datalimite;
    }

    public LocalDate getDataefetuado() {
        return dataefetuado;
    }

    public void setDataefetuado(LocalDate dataefetuado) {
        this.dataefetuado = dataefetuado;
    }

    public String getMetodopag() {
        return metodopag;
    }

    public void setMetodopag(String metodopag) {
        this.metodopag = metodopag;
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