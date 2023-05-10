package com.bd.DAL;

import javax.persistence.*;

@Entity
@Table(name = "ENCOMENDAS")
@NamedQueries({
        @NamedQuery(name = "Encomendas.findAll", query = "SELECT c FROM Encomendas c"),
        @NamedQuery(name = "Encomendas.findByIdencomenda", query = "SELECT c FROM Encomendas c WHERE c.idEncomenda = :id_encomenda"),
        @NamedQuery(name = "Encomendas.findAllByTipoPagamento", query = "SELECT c FROM Encomendas c WHERE c.tipopagamentoid = :id_tipopagamento"),
        @NamedQuery(name = "Encomendas.findAllPedConcluidosEstafeta",  query = "select distinct new   com.bd.DAL.listaPedidos  (en,  estenc, pr, ee, pre, tps) " +
                " from Encomendas  en, Estadosencomenda estenc, Pratos  pr, Encomendaestados ee, PratosEncomendados pre, Tipopagamentos  tps where en.idEncomenda = pre.idEncomenda and " +
                " pr.idPrato = pre.idPrato and ee.idEncomenda = en.idEncomenda and estenc.idEstadoencomenda = ee.idEstadoencomenda and tps.tipopagamentoid= en.tipopagamentoid and ee.idEstadoencomenda=2"),
        @NamedQuery(name = "Encomendas.findAllPed",  query = "select distinct new   com.bd.DAL.listaPedidos  (en,  estenc, pr, ee, pre, tps) " +
                " from Encomendas  en, Estadosencomenda estenc, Pratos  pr, Encomendaestados ee, PratosEncomendados pre, Tipopagamentos  tps where en.idEncomenda = pre.idEncomenda and " +
                " pr.idPrato = pre.idPrato and ee.idEncomenda = en.idEncomenda and estenc.idEstadoencomenda = ee.idEstadoencomenda and tps.tipopagamentoid= en.tipopagamentoid "),
        @NamedQuery(name = "Encomendas.findAllPedMarcados",  query = "select distinct new   com.bd.DAL.listaPedidos  (en,  estenc, pr, ee, pre, tps) " +
                " from Encomendas  en, Estadosencomenda estenc, Pratos  pr, Encomendaestados ee, PratosEncomendados pre, Tipopagamentos  tps where en.idEncomenda = pre.idEncomenda and " +
                " pr.idPrato = pre.idPrato and ee.idEncomenda = en.idEncomenda and estenc.idEstadoencomenda = ee.idEstadoencomenda and tps.tipopagamentoid= en.tipopagamentoid and estenc.idEstadoencomenda=1"),
        @NamedQuery(name = "Encomendas.findAllPedConcluidos",  query = "select distinct new   com.bd.DAL.listaPedidos (en,  estenc, pr, ee, pre, tps) " +
                " from Encomendas  en, Estadosencomenda estenc, Pratos  pr, Encomendaestados ee, PratosEncomendados pre, Tipopagamentos  tps where en.idEncomenda = pre.idEncomenda and " +
                " pr.idPrato = pre.idPrato and ee.idEncomenda = en.idEncomenda and estenc.idEstadoencomenda = ee.idEstadoencomenda and tps.tipopagamentoid= en.tipopagamentoid and estenc.idEstadoencomenda=2"),
        @NamedQuery(name = "Encomendas.findAllPedCancelados",  query = "select distinct new   com.bd.DAL.listaPedidos  (en,  estenc, pr, ee, pre, tps) " +
                " from Encomendas  en, Estadosencomenda estenc, Pratos  pr, Encomendaestados ee, PratosEncomendados pre, Tipopagamentos  tps where en.idEncomenda = pre.idEncomenda and " +
                " pr.idPrato = pre.idPrato and ee.idEncomenda = en.idEncomenda and estenc.idEstadoencomenda = ee.idEstadoencomenda and tps.tipopagamentoid= en.tipopagamentoid and estenc.idEstadoencomenda=3"),
        @NamedQuery(name = "Encomendas.findByIdCliente",  query = "select distinct new   com.bd.DAL.listaPedidos  (en,  estenc, pr, ee, pre, tps) " +
                " from Encomendas  en, Estadosencomenda estenc, Pratos  pr, Encomendaestados ee, PratosEncomendados pre, Tipopagamentos  tps where en.idEncomenda = pre.idEncomenda and " +
                " pr.idPrato = pre.idPrato and ee.idEncomenda = en.idEncomenda and estenc.idEstadoencomenda = ee.idEstadoencomenda and tps.tipopagamentoid= en.tipopagamentoid and en.idCliente = :id_cliente"),
        @NamedQuery(name = "Encomendas.findByIdClienteMarcadas",  query = "select distinct new   com.bd.DAL.listaPedidos  (en,  estenc, pr, ee, pre, tps) " +
                " from Encomendas  en, Estadosencomenda estenc, Pratos  pr, Encomendaestados ee, PratosEncomendados pre, Tipopagamentos  tps where en.idEncomenda = pre.idEncomenda and " +
                " pr.idPrato = pre.idPrato and ee.idEncomenda = en.idEncomenda and estenc.idEstadoencomenda = ee.idEstadoencomenda and tps.tipopagamentoid= en.tipopagamentoid and en.idCliente = :id_cliente and ee.idEstadoencomenda=1" ),
        @NamedQuery(name = "Encomendas.findByIdClienteConcluidas",  query = "select distinct new   com.bd.DAL.listaPedidos  (en,  estenc, pr, ee, pre, tps) " +
                " from Encomendas  en, Estadosencomenda estenc, Pratos  pr, Encomendaestados ee, PratosEncomendados pre, Tipopagamentos  tps where en.idEncomenda = pre.idEncomenda and " +
                " pr.idPrato = pre.idPrato and ee.idEncomenda = en.idEncomenda and estenc.idEstadoencomenda = ee.idEstadoencomenda and tps.tipopagamentoid= en.tipopagamentoid and en.idCliente = :id_cliente and ee.idEstadoencomenda=2"),
        @NamedQuery(name = "Encomendas.findByIdClienteCanceladas",  query = "select distinct new   com.bd.DAL.listaPedidos  (en,  estenc, pr, ee, pre, tps) " +
                " from Encomendas  en, Estadosencomenda estenc, Pratos  pr, Encomendaestados ee, PratosEncomendados pre, Tipopagamentos  tps where en.idEncomenda = pre.idEncomenda and " +
                " pr.idPrato = pre.idPrato and ee.idEncomenda = en.idEncomenda and estenc.idEstadoencomenda = ee.idEstadoencomenda and tps.tipopagamentoid= en.tipopagamentoid and en.idCliente = :id_cliente and ee.idEstadoencomenda=3"),
        @NamedQuery(name = "Encomendas.findByIdClienteEntregues",  query = "select distinct new   com.bd.DAL.listaPedidos  (en,  estenc, pr, ee, pre, tps) " +
                " from Encomendas  en, Estadosencomenda estenc, Pratos  pr, Encomendaestados ee, PratosEncomendados pre, Tipopagamentos  tps where en.idEncomenda = pre.idEncomenda and " +
                " pr.idPrato = pre.idPrato and ee.idEncomenda = en.idEncomenda and estenc.idEstadoencomenda = ee.idEstadoencomenda and tps.tipopagamentoid= en.tipopagamentoid and en.idCliente = :id_cliente and ee.idEstadoencomenda=4"),
        @NamedQuery(name = "Encomendas.findByIdClientePago",  query = "select distinct new   com.bd.DAL.listaPedidos  (en,  estenc, pr, ee, pre, tps) " +
                " from Encomendas  en, Estadosencomenda estenc, Pratos  pr, Encomendaestados ee, PratosEncomendados pre, Tipopagamentos  tps where en.idEncomenda = pre.idEncomenda and " +
                " pr.idPrato = pre.idPrato and ee.idEncomenda = en.idEncomenda and estenc.idEstadoencomenda = ee.idEstadoencomenda and tps.tipopagamentoid= en.tipopagamentoid and en.idCliente = :id_cliente and ee.idEstadoencomenda=5"),



})

public class Encomendas {
    private int idEncomenda;
    private int valortotal;
    private int idCliente;
    private Integer idEstafeta;
    private int tipopagamentoid;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_ENCOMENDA", nullable = false, precision = 0)
    public int getIdEncomenda() {
        return idEncomenda;
    }

    public void setIdEncomenda(int idEncomenda) {
        this.idEncomenda = idEncomenda;
    }

    @Basic
    @Column(name = "VALORTOTAL", nullable = false, precision = 2)
    public int getValortotal() {
        return valortotal;
    }

    public void setValortotal(int valortotal) {
        this.valortotal = valortotal;
    }

    @Basic
    @Column(name = "ID_CLIENTE", nullable = false, precision = 0)
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }


    @Basic
    @Column(name = "ID_ESTAFETA", nullable = true, precision = 0)
    public Integer getIdEstafeta() {
        return idEstafeta;
    }

    public void setIdEstafeta(Integer idEstafeta) {
        this.idEstafeta = idEstafeta;
    }

    @Basic
    @Column(name = "TIPOPAGAMENTOID", nullable = false, precision = 0)
    public int getTipopagamentoid() {
        return tipopagamentoid;
    }

    public void setTipopagamentoid(int tipopagamentoid) {
        this.tipopagamentoid = tipopagamentoid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Encomendas that = (Encomendas) o;

        if (idEncomenda != that.idEncomenda) return false;
        if (valortotal != that.valortotal) return false;
        if (idCliente != that.idCliente) return false;
        if (tipopagamentoid != that.tipopagamentoid) return false;
        if (idEstafeta != null ? !idEstafeta.equals(that.idEstafeta) : that.idEstafeta != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idEncomenda;
        result = 31 * result + valortotal;
        result = 31 * result + idCliente;
        result = 31 * result + (idEstafeta != null ? idEstafeta.hashCode() : 0);
        result = 31 * result + tipopagamentoid;
        return result;
    }
}
