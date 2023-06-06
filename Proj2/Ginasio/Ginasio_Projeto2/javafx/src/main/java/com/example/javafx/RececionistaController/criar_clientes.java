package com.example.javafx.RececionistaController;

import com.AcessoBD.DAO.ClienteDAO;
import com.AcessoBD.repository.entities.Cliente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class criar_clientes {
    public TextField nome, mail, tele, nif, cpostal;
    public DatePicker dtNasc;
    public Label erros;

    Cliente c = new Cliente();
    ClienteDAO cDAO = new ClienteDAO();

    public void criar(ActionEvent event) {
        c.setNome(nome.getText());
        c.setDataNascimento(dtNasc.getValue());
        c.setEmail(mail.getText());
        c.setTelemovel(tele.getText());
        c.setNif(nif.getText());
        c.setCodigoPostal(cpostal.getText());
        c.setPassword("default");

        cDAO.create(c);
    }

    public void errorHandler(){}
}
