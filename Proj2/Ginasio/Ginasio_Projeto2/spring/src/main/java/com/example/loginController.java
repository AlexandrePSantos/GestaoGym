package com.example;

import com.AcessoBD.DAO.ClienteDAO;
import com.AcessoBD.repository.entities.Cliente;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.asm.Label;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.io.PrintWriter;
//
//@Controller
//public class loginController {
//
//    public Label email;
//    public Label password;
//
//    Cliente c = new Cliente();
//    ClienteDAO cDAO = new ClienteDAO();
//
//    @PostMapping("/templates/dashboard.html")
//    public String login(String email, String password, HttpServletResponse response) throws IOException {
////        String username = request.getParameter("username");
////        String password = request.getParameter("password");
//
//        // Verificar se os campos de email e senha estão vazios
//        if (email.isEmpty() || password.isEmpty()) {
//            PrintWriter out = response.getWriter();
//            out.println("<html>");
//            out.println("<head><title>Alerta</title></head>");
//            out.println("<body>");
//            out.println("<script>alert('Dados incorretos. Por favor, verifique os campos novamente.');</script>");
//            out.println("</body>");
//            out.println("</html>");
//            return "/static/login.html";
//            // Terminar o método aqui para evitar exceções desnecessárias
//        }
//        else {
//            c = cDAO.getByEmail(email);
//        }
//        return "/templates/dashboard.html?user=" + c.getIdCliente();
//    }
//
//    @RequestMapping("/login.html")
//    public String showLoginPage() {
//        return "/static/login.html";
//    }
//}
