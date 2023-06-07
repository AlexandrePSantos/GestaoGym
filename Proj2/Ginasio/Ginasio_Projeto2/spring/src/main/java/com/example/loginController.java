package com.example;

import com.AcessoBD.DAO.ClienteDAO;
import com.AcessoBD.repository.entities.Cliente;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;


@Controller
public class loginController {
    ClienteDAO cd = new ClienteDAO();

    @PostMapping("/redirectToDashboard")
    public String redirectToDashboard(@RequestParam("email") String email, @RequestParam("password") String password) {
        Cliente c = cd.getByEmail(email);

        if (c != null && c.getPassword().equals(password)) {
            return "redirect:/loadPerfil?iduser=" + c.getIdCliente();
        } else {
            // handle error case
            return "redirect:/error";
        }
    }
}
