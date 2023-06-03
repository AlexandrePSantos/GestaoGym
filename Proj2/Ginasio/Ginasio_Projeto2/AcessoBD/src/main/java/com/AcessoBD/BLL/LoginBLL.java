package com.AcessoBD.BLL;

import com.AcessoBD.DAO.ClienteDAO;
import com.AcessoBD.DAO.FuncionarioDAO;
import com.AcessoBD.repository.entities.Cliente;
import com.AcessoBD.repository.entities.Funcionario;

public class LoginBLL {
    // WEB
    public boolean loginCliente(String email, String password) {
        ClienteDAO cd = new ClienteDAO();
        Cliente login = cd.getByEmail(email);
        return login != null && login.getPassword().equals(password);
    }

    // DESKTOP
    public Funcionario loginFuncionario(String email, String password) {
        FuncionarioDAO fd = new FuncionarioDAO();
        Funcionario login = fd.getByEmail(email);
        if (login != null && login.getPassword().equals(password)) {
            return login;
        }
        return null;
    }
}
