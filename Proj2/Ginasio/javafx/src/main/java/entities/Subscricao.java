package entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "subscricao")
public class Subscricao {
    @Id
    @Column(name = "numsubscricao", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idcliente")
    private Cliente idcliente;

    @Column(name = "duracao")
    private Integer duracao;

    @Column(name = "dataini")
    private LocalDate dataini;

    @Column(name = "datafim")
    private LocalDate datafim;

    @Column(name = "valemfalta", precision = 5, scale = 2)
    private BigDecimal valemfalta;

    @Column(name = "valtotal", precision = 5, scale = 2)
    private BigDecimal valtotal;

    @Column(name = "estado", length = 50)
    private String estado;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cliente getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Cliente idcliente) {
        this.idcliente = idcliente;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    public LocalDate getDataini() {
        return dataini;
    }

    public void setDataini(LocalDate dataini) {
        this.dataini = dataini;
    }

    public LocalDate getDatafim() {
        return datafim;
    }

    public void setDatafim(LocalDate datafim) {
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

}