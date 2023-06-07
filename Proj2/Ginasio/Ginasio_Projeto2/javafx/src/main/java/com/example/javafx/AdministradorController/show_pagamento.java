package com.example.javafx.AdministradorController;

import com.AcessoBD.DAO.PagamentoDAO;
import com.AcessoBD.repository.entities.Pagamento;
import com.AcessoBD.repository.entities.Subscricao;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class show_pagamento {
    public TableView<Pagamento> tblPagamentos;
    public TableColumn<Pagamento, Integer> num;
    public TableColumn<Pagamento, LocalDate> data;
    public TableColumn<Pagamento, String> estado;
    public TableColumn<Pagamento, String> metodo;
    public TableColumn<Pagamento, String> ref;
    public TableColumn<Pagamento, BigDecimal> valor;
    public TableColumn<Pagamento, BigDecimal> entidade;
    public TableColumn<Pagamento, Subscricao> sub;

    Pagamento p = new Pagamento();
    PagamentoDAO pDAO = new PagamentoDAO();
    Subscricao s = new Subscricao();

    @FXML
    protected void initialize() {
        loadData();
    }

    protected void loadData() {
        List<Pagamento> pagamentos = pDAO.getAll();

        num.setCellValueFactory(new PropertyValueFactory<>("numPagamento"));
        data.setCellValueFactory(new PropertyValueFactory<>("dataPagamento"));
        estado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        metodo.setCellValueFactory(new PropertyValueFactory<>("metodo"));
        ref.setCellValueFactory(new PropertyValueFactory<>("referencia"));
        valor.setCellValueFactory(new PropertyValueFactory<>("valor"));
        entidade.setCellValueFactory(new PropertyValueFactory<>("entidade"));
        sub.setCellValueFactory(cellData -> {
            p = cellData.getValue();
            s = p.getSubscricao();
            ObservableValue<Subscricao> observableValue = new ReadOnlyObjectWrapper<>(s);
            return observableValue;
        });
        sub.setCellFactory(column -> new TableCell<>() {
            @Override
            protected void updateItem(Subscricao item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) { setText(null); } else { setText("" + item.getNumSubscricao()); }
            }
        });

        tblPagamentos.setItems(FXCollections.observableArrayList(pagamentos));
    }
}
