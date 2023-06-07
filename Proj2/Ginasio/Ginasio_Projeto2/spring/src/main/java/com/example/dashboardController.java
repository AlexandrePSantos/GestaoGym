package com.example;

import com.AcessoBD.DAO.AulagrupoDAO;
import com.AcessoBD.DAO.ClienteDAO;
import com.AcessoBD.repository.entities.Aulagrupo;
import com.AcessoBD.repository.entities.Cliente;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class dashboardController {

    @GetMapping("/loadPerfil")
    public String loadPerfil(@RequestParam("iduser") int id) {
        // Use the 'id' parameter in your code
        // ...
        return "/templates/dashboard.html";
    }

//    ClienteDAO cDAO = new ClienteDAO();
//    AulagrupoDAO aDAO = new AulagrupoDAO();
//    int numCLi = 0;
//
//    public void showInfoCLiente(int id){
//        Cliente cli = cDAO.getById(id);
//
//    }
//
//    @GetMapping("/dashboard")
//    public String listarAulasPlaneadas(Model model) {
////      Restrição com localdate
//        List<Aulagrupo> aulasPlaneadas = aDAO.getAll();
//        model.addAttribute("aulasPlaneadas", aulasPlaneadas);
//
//
//        System.out.println(aulasPlaneadas);
//        return "listarAulasPlaneadas";
//    }
//    @GetMapping("dashboard")
//    public String listarAulasRealizadas(Model model) {
//        model.addAttribute("listaAulasReal", aDAO.getAll());
//
//        return "listarAulasRealizadas";
//    }
}