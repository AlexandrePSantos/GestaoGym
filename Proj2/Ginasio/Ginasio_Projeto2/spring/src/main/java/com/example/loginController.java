package com.example;

import com.AcessoBD.BLL.*;
import com.AcessoBD.DAO.*;
import com.AcessoBD.repository.entities.*;
import org.springframework.asm.Label;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.swing.*;
import java.math.BigDecimal;
import java.time.LocalDate;


@Controller
public class loginController {
    public JLabel nomeLbl, dnLbl, tlmLbl, psswdLbl, nifLbl, mailLbl;

    public String loadPerfil(int iduser) {
//        ClienteDAO cliDao = new ClienteDAO();
//        Cliente c = new Cliente();
//        if (cliDao.getById(iduser) != null) {
//            nomeLbl.setText("Nome: " + c.getNome());
//            dnLbl.setText("Data Nasc.: " + c.getDataNascimento());
//            tlmLbl.setText("Telemóvel: " + c.getTelemovel());
//            psswdLbl.setText("Password: " + c.getPassword());
//            nifLbl.setText("NIF: " + c.getNif());
//            mailLbl.setText("Email: " + c.getEmail());
//        }
        return "/templates/dashboard.html";
    }
}
