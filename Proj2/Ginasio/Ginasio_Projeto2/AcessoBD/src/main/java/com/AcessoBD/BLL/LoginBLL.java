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
    public Integer loginFuncionario(String email, String password) {
        FuncionarioDAO fd = new FuncionarioDAO();
        Funcionario login = fd.getByEmail(email);
        if (login != null && login.getPassword().equals(password)) {
            // Check the role of the Funcionario
            String funcao = login.getFuncao();
            switch (funcao) {
                // Successful login for an Instrutor
                case "Instrutor": return 1;
                // Successful login for an Administrador
                case "Administrador": return 2;
                // Successful login for a Rececionista
                case "Rececionista": return 3;
            }
        }
        // Invalid login credentials or Funcionario not found
        return 0;
    }
}
