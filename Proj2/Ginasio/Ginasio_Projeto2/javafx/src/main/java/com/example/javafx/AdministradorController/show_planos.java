package com.example.javafx.AdministradorController;

import com.AcessoBD.DAO.PlanotreinoDAO;
import com.AcessoBD.repository.entities.Cliente;
import com.AcessoBD.repository.entities.Funcionario;
import com.AcessoBD.repository.entities.Planotreino;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.List;

public class show_planos {


    public TableView<Planotreino> tblPlanos;
    public TableColumn<Planotreino, Integer> num;
    public TableColumn<Planotreino, LocalDate> dtCri;
    public TableColumn<Planotreino, String> estado;
    public TableColumn<Planotreino, Cliente> cli;
    public TableColumn<Planotreino, Funcionario> inst;

    Planotreino pt = new Planotreino();
    PlanotreinoDAO ptDAO = new PlanotreinoDAO();
    Cliente c = new Cliente();
    Funcionario func = new Funcionario();

    @FXML
    protected void initialize() {
        loadPlanos();
    }

    public void loadPlanos() {
        List<Planotreino> planos = ptDAO.getAll();

        num.setCellValueFactory(new PropertyValueFactory<>("numPlano"));
        dtCri.setCellValueFactory(new PropertyValueFactory<>("dtCriacao"));
        estado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        cli.setCellValueFactory(cellData -> {
            pt = cellData.getValue();
            c = pt.getCliente();
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
        inst.setCellValueFactory(cellData -> {
            pt = cellData.getValue();
            func = pt.getFuncionario();
            ObservableValue<Funcionario> observableValue = new ReadOnlyObjectWrapper<>(func);
            return observableValue;
        });
        inst.setCellFactory(column -> new TableCell<>() {
            @Override
            protected void updateItem(Funcionario item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) { setText(null); } else { setText(item.getId() + " - " + item.getNome()); }
            }
        });
        tblPlanos.setItems(FXCollections.observableArrayList(planos));
    }
}
