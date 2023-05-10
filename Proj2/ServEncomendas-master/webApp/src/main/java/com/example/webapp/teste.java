package com.example.webapp;


import com.bd.BLL.CodPostaisBLL;
import com.bd.DAL.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.bd.BLL.EncomendaBLL;
import com.bd.BLL.ClienteBLL;
import com.bd.BLL.PratoBLL;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Controller


public class teste {
    /*
    @Autowired /* spring ejetar o DAO
    private Pratos pratos;
*/

    @GetMapping("listar")
    public String listar(Model model) {
        //List <Pratos> pratosList= PratoBLL.readAll(true);
        List<listaPedidos> listaPedidos = EncomendaBLL.readAll2();
        //  List<Pratos> listEnc = new ArrayList<Pratos>();
        //listEnc.addAll(listEnc);
        // model.addAttribute("Pratos", pratosList);
        //model.addAttribute("Pratos", PratoBLL.readAll(true));
        model.addAttribute("listaPedidos", EncomendaBLL.readAll2());

        return "listar";
    }

    @GetMapping("codPostais")
    public String codPostais(Model model){
        List<Codpostais> codpostais = CodPostaisBLL.readAll();
        model.addAttribute("codpostais",CodPostaisBLL.readAll());
        return "codPostais";
    }

    @GetMapping("cli")
    public String clientes(Model model){
        List<Clientes> clientes = ClienteBLL.readAll();
        model.addAttribute("clientes",ClienteBLL.readAll());
        return "clientes";
    }

    @GetMapping("/paginaInicial")
    public String pagina(Model model) {
        return "paginaPrincipal";
    }

    @GetMapping("/")
    public String ViewHomePage(Model model) {

        return "login";
    }


}
