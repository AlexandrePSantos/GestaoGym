package com.example;

import com.AcessoBD.DAO.*;
import com.AcessoBD.repository.entities.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class controller {

    ClienteDAO clienteDAO = new ClienteDAO();
    Cliente cliente = new Cliente();
    AulagrupoDAO aulagrupoDAO = new AulagrupoDAO();
    PlanotreinoDAO planotreinoDAO = new PlanotreinoDAO();
    SubscricaoDAO subscricaoDAO = new SubscricaoDAO();

    @PostMapping("/login")
    public void login(String email, String password, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        cliente = clienteDAO.getByEmail(email);
        if (cliente != null && cliente.getPassword().equals(password)) {
            response.sendRedirect("/templates/dashboard.html?user=" + cliente.getIdCliente());
        } else {
            out.println("<html>");
            out.println("<head><title>Alerta</title></head>");
            out.println("<body>");
            out.println("<script>alert('Dados incorretos. Por favor, verifique os campos novamente.');</script>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @PostMapping("/")
    public String logout(Model model) {
        return "login";
    }

    @GetMapping("/")
    public String ViewHomePage(Model model) {
        return "login";
    }
    @GetMapping("/templates/dashboard.html")
    public String viewDashboard(@RequestParam("user") String userId, Model model) {
        //load perfil
        Cliente cliente = clienteDAO.getById(Integer.parseInt(userId));
        model.addAttribute("cliente", cliente);

        //load aulas planeadas
        LocalDate dataAtual = LocalDate.now();
        List<Aulagrupo> aulasPlaneadas = aulagrupoDAO.getAll().stream()
                .filter(aula -> aula.getDataAula().isAfter(dataAtual))
                .collect(Collectors.toList());
        model.addAttribute("aulasPlaneadas", aulasPlaneadas);

        //load aulas realizadas
        List<Aulagrupo> aulasRealizadas = aulagrupoDAO.getAll().stream()
                .filter(aula -> aula.getDataAula().isBefore(dataAtual))
                .collect(Collectors.toList());
        model.addAttribute("aulasRealizadas", aulasRealizadas);

        //load planos
        List<Planotreino> planos = planotreinoDAO.getAll().stream()
                .filter(plano -> plano.getCliente().getIdCliente() == cliente.getIdCliente())
                .collect(Collectors.toList());
        model.addAttribute("planos", planos);

//load subscrições
        List<Subscricao> subscricoes = subscricaoDAO.getAll().stream()
                .filter(subscricao -> subscricao.getCliente().getIdCliente() == cliente.getIdCliente())
                .collect(Collectors.toList());
        model.addAttribute("subscricoes", subscricoes);


        return "dashboard";
    }
}
