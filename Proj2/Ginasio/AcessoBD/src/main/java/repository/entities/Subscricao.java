package repository.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "Subscricao")
public class Subscricao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numSubscricao")
    private int numSubscricao;

    @Column(name = "duracao")
    private String duracao;

    @Column(name = "dataIni")
    private Date dataIni;

    @Column(name = "dataFim")
    private Date dataFim;

    @Column(name = "valor")
    private BigDecimal valor;

    @Column(name = "modalidade")
    private int modalidade;

    @Column(name = "estado")
    private String estado;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Cliente cliente;

    public int getNumSubscricao() {
        return numSubscricao;
    }

    public void setNumSubscricao(int numSubscricao) {
        this.numSubscricao = numSubscricao;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public Date getDataIni() {
        return dataIni;
    }

    public void setDataIni(Date dataIni) {
        this.dataIni = dataIni;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public int getModalidade() {
        return modalidade;
    }

    public void setModalidade(int modalidade) {
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