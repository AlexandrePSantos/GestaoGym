package com.example.javafx.RececionistaController;

import com.AcessoBD.DAO.ClienteDAO;
import com.AcessoBD.DAO.LinhaparticipanteDAO;
import com.AcessoBD.repository.entities.Cliente;
import com.AcessoBD.repository.entities.Linhaparticipante;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.List;

public class show_clientes {
    public TableView<Linhaparticipante> tblParticipantes;
    public TableColumn<Linhaparticipante, Integer> numCli;
    public TableColumn<Linhaparticipante, Cliente> nomeCli;

    protected int idAulaAtual;

    LinhaparticipanteDAO lpDAO = new LinhaparticipanteDAO();
    ClienteDAO cliDAO = new ClienteDAO();

    protected void setAulagrupoId(int aulagrupoId) {
        this.idAulaAtual = aulagrupoId;
    }

    protected void loadData(int id) {
        List<Linhaparticipante> participantes = lpDAO.getAllById(id);

        numCli.setCellValueFactory(cellData -> {
            Cliente cliente = cellData.getValue().getCliente();
            Integer numeroCliente = cliente.getIdCliente();
            return new SimpleIntegerProperty(numeroCliente).asObject();
        });
        nomeCli.setCellValueFactory(cellData -> {
            Linhaparticipante linhaparticipante = cellData.getValue();
            Cliente cliente = cliDAO.getById(linhaparticipante.getCliente().getIdCliente());
            return new SimpleObjectProperty<>(cliente);
        });

        tblParticipantes.setItems(FXCollections.observableArrayList(participantes));
    }


}
