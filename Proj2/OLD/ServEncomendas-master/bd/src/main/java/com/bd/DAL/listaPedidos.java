package com.bd.DAL;

import java.util.Date;

public class listaPedidos {
    private  int id_encomenda;
    private int id_estafeta;
    private int id_cliente;
    private String descricao;
    private String data;
    private float precodose;
    private String encomendaestados;
    private  int qtd;
    private  String tp;



    public int getId_encomenda() {
        return id_encomenda;
    }

    public void setId_encomenda(int id_encomenda) {
        this.id_encomenda = id_encomenda;
    }

    public String getTp() {
        return tp;
    }

    public void setTp(String tp) {
        this.tp = tp;
    }

    public int getId_estafeta() {
        return id_estafeta;
    }

    public void setId_estafeta(int id_estafeta) {
        this.id_estafeta = id_estafeta;
    }


    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public float getPrecodose() {
        return precodose;
    }

    public void setPrecodose(float precodose) {
        this.precodose = precodose;
    }

    public String getEncomendaestados() {
        return encomendaestados;
    }

    public void setEncomendaestados(String encomendaestados) {
        this.encomendaestados = encomendaestados;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int idCLiente;

    public listaPedidos(Encomendas en, Estadosencomenda estenc, Pratos pr, Encomendaestados ee, PratosEncomendados prae, Tipopagamentos  tps ) {
        this.id_encomenda = en.getIdEncomenda();
        this.id_estafeta = en.getIdEstafeta();
        this.id_cliente = en.getIdCliente();
        this.descricao = pr.getDescricao();
        this.data = String.valueOf(ee.getData());
        this.precodose = prae.getPrecodose();
        this.encomendaestados = estenc.getDescricaoestado();
        this.tp = tps.getDescricao();
        this.qtd = prae.getQtddoses();
    }
}
