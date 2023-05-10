package repository.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Subscricao")
public class Subscricao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "num_subscricao")
    private Integer numSubscricao;

    @Column(name = "duracao")
    private String duracao;

    @Column(name = "data_ini")
    private LocalDate dataIni;

    @Column(name = "data_fim")
    private LocalDate dataFim;

    @Column(name = "valor")
    private BigDecimal valor;

    @Column(name = "modalidade")
    private Integer modalidade;

    @Column(name = "estado")
    private String estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    public Subscricao() {
    }

    public Subscricao(String duracao, LocalDate dataIni, LocalDate dataFim, BigDecimal valor, Integer modalidade,
                      String estado, Cliente cliente) {
        this.duracao = duracao;
        this.dataIni = dataIni;
        this.dataFim = dataFim;
        this.valor = valor;
        this.modalidade = modalidade;
        this.estado = estado;
        this.cliente = cliente;
    }

    public Integer getNumSubscricao() {
        return numSubscricao;
    }

    public void setNumSubscricao(Integer numSubscricao) {
        this.numSubscricao = numSubscricao;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public LocalDate getDataIni() {
        return dataIni;
    }

    public void setDataIni(LocalDate dataIni) {
        this.dataIni = dataIni;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Integer getModalidade() {
        return modalidade;
    }

    public void setModalidade(Integer modalidade) {
        this.modalidade = modalidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
