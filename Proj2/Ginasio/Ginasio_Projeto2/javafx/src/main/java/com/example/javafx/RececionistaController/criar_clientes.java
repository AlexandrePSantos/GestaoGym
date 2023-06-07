package com.example.javafx.RececionistaController;

import com.AcessoBD.DAO.ClienteDAO;
import com.AcessoBD.repository.entities.Cliente;
import javafx.event.ActionEvent;
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
        if (nome.getText().isEmpty() || dtNasc.getValue() == null || mail.getText().isEmpty() ||
                tele.getText().isEmpty() || nif.getText().isEmpty() || cpostal.getText().isEmpty()) {
            erros.setText("Tem de preencher todos os campos!");
        } else {
            int novoID = cDAO.getID() + 1; // Obter o próximo ID disponível
            c.setIdCliente(novoID);
            c.setNome(nome.getText());
            nome.clear();
            c.setDataNascimento(dtNasc.getValue());
            c.setEmail(mail.getText());
            mail.clear();
            c.setTelemovel(tele.getText());
            tele.clear();
            c.setNif(nif.getText());
            nif.clear();
            c.setCodigoPostal(cpostal.getText());
            cpostal.clear();
            c.setPassword("default");

            cDAO.create(c);
        }
    }
}
