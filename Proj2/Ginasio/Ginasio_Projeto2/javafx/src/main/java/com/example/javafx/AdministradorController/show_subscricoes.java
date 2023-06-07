package com.example.javafx.AdministradorController;

import com.AcessoBD.DAO.SubscricaoDAO;
import com.AcessoBD.repository.entities.Cliente;
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

public class show_subscricoes {
    public TableView<Subscricao> tblSubs;
    public TableColumn<Subscricao, Integer> num;
    public TableColumn<Subscricao, LocalDate> dtIni;
    public TableColumn<Subscricao, LocalDate> dtFim;
    public TableColumn<Subscricao, String> estado;
    public TableColumn<Subscricao, BigDecimal> valor;
    public TableColumn<Subscricao, Cliente> cli;

    Subscricao sub = new Subscricao();
    SubscricaoDAO subDao = new SubscricaoDAO();
    Cliente c = new Cliente();

    @FXML
    protected void initialize() {
        loadSubs();
    }

    public void loadSubs() {
        List<Subscricao> subscricao = subDao.getAll();

        num.setCellValueFactory(new PropertyValueFactory<>("numSubscricao"));
        dtIni.setCellValueFactory(new PropertyValueFactory<>("dataIni"));
        dtFim.setCellValueFactory(new PropertyValueFactory<>("dataFim"));
        estado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        valor.setCellValueFactory(new PropertyValueFactory<>("valor"));
        cli.setCellValueFactory(cellData -> {
            sub = cellData.getValue();
            c = sub.getCliente();
            ObservableValue<Cliente> observableValue = new ReadOnlyObjectWrapper<>(c);
            return observableValue;
        });
        cli.setCellFactory(column -> new TableCell<>() {
            @Override
            protected void updateItem(Cliente item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) { setText(null); } else { setText(item.getIdCliente() + " - " + item.getNome()); }
            }
        });

        tblSubs.setItems(FXCollections.observableArrayList(subscricao));
    }
}
