package com.AcessoBD.BLL;

import com.AcessoBD.DAO.LoginDAO;
import com.AcessoBD.repository.entities.Cliente;
import com.AcessoBD.repository.entities.Funcionario;
import com.AcessoBD.repository.entities.Login;

public class LogRegBLL {

    private LoginDAO loginDAO = new LoginDAO();

    public boolean loginCliente(String username, String password) {
        LoginDAO loginDAO = new LoginDAO();
        Login login = loginDAO.getByUsername(username);
        if (login != null && login.getPassword().equals(password)) {
            Cliente cliente = login.getCliente();
            // Successful login for a Cliente
            return cliente != null;
        }
        // Failed login
        return false;
    }

    public Integer loginFuncionario(String username, String password) {
        LoginDAO loginDAO = new LoginDAO();
        Login login = loginDAO.getByUsername(username);
        if (login != null && login.getPassword().equals(password)) {
            Funcionario funcionario = login.getFuncionario();
            if (funcionario != null) {
                // Check if Funcionario is Instrutor or Rececionista
                if (funcionario.getFuncao().equals("Instrutor")) {
                    // Successful login for a Funcionario
                    //retornar 1 (Instrutor)
                    return 1;
                } else if (funcionario.getFuncao().equals("Rececionista")) {
                    // Successful login for a Funcionario
                    //retornar 1 (Rececionista)
                    return 2;
                }
            }
        }
        // Failed login
        return 0;
    }
}
