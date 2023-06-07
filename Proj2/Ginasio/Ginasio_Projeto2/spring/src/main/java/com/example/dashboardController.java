package com.example;

import com.AcessoBD.DAO.ClienteDAO;
import com.AcessoBD.repository.entities.Cliente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class dashboardController {

    ClienteDAO cDAO = new ClienteDAO();
    int numCLi = 0;

    public void showInfoCLiente(int id){
        Cliente cli = cDAO.getById(id);

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