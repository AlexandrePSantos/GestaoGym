package com.bd.DAL;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.List;


@Entity
public class listaPedidosCozinheiro {
@Id
    private  int id_encomenda;
    private String descricao;
    private String encomendaestados;
    private  int qtd;
    private boolean estado;

    public listaPedidosCozinheiro() {

    }

    public int getId_encomenda() {
        return id_encomenda;
    }

    public void setId_encomenda(int id_encomenda) {
        this.id_encomenda = id_encomenda;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {

        this.estado = estado;
    }

    public listaPedidosCozinheiro(Encomendas en, Estadosencomenda estenc, Pratos pr, PratosEncomendados prae ) {
        this.id_encomenda = en.getIdEncomenda();
        this.descricao = pr.getDescricao();
        this.encomendaestados = estenc.getDescricaoestado();
        this.qtd = prae.getQtddoses();
        this.estado = prae.getEstado();



    }


}
