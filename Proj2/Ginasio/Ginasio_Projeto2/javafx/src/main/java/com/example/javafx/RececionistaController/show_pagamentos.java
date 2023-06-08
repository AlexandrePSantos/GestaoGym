package com.example.javafx.RececionistaController;

import com.AcessoBD.DAO.PagamentoDAO;
import com.AcessoBD.repository.entities.Pagamento;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class show_pagamentos {

    public TableView<Pagamento> tblPagamentos;
    public TableColumn<Pagamento, Integer> numCliPag;
    public TableColumn<Pagamento, LocalDate> dataCliPag;
    public TableColumn<Pagamento, String> estadoCliPag;
    public TableColumn<Pagamento, String> metodoCliPag;
    public TableColumn<Pagamento, String> refCliPag;
    public TableColumn<Pagamento, BigDecimal> valorCliPag;
    public TextField nCliPag;
    public Label errorPag;

    protected int idSubscricao;

    PagamentoDAO pDAO = new PagamentoDAO();

    protected void setSubscricaoId(int idSub) {
        this.idSubscricao = idSub;
    }

    protected void loadData(int idSub) {
        List<Pagamento> pagamentos = pDAO.getAllById(idSub);

        numCliPag.setCellValueFactory(new PropertyValueFactory<>("numPagamento"));
        dataCliPag.setCellValueFactory(new PropertyValueFactory<>("dataPagamento"));
        estadoCliPag.setCellValueFactory(new PropertyValueFactory<>("estado"));
        metodoCliPag.setCellValueFactory(new PropertyValueFactory<>("metodo"));
        refCliPag.setCellValueFactory(new PropertyValueFactory<>("referencia"));
        valorCliPag.setCellValueFactory(new PropertyValueFactory<>("valor"));

        tblPagamentos.setItems(FXCollections.observableArrayList(pagamentos));
    }

    public void confirmPagamento(ActionEvent event) {
        Pagamento p = pDAO.getById(Integer.parseInt(nCliPag.getText()));
        if (p.getEstado().equals("Por realizar") || p.getEstado().equals("Pago")) {
            errorPag.setText("Apenas pode confirmar pagamentos pendentes!");
            nCliPag.clear();
        } else {
            p.setEstado("Pago");
            pDAO.update(p);
            nCliPag.clear();
            loadData(idSubscricao);
        }
    }
}
