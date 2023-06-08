package com.example.exemplospringmvc;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import com.example.exemplospringmvc.Model.Cliente;

@Controller
public class ClienteController {

    @GetMapping("/formCliente")
    public String formCliente(Model model) {
        Cliente cli = new Cliente();
        model.addAttribute("cli", cli);
        return "clienteForm";
    }

    @PostMapping("criarCliente")
    public String criarCliente(@ModelAttribute Cliente cli, Model model) {

        List<Cliente> listaDeClientes = new ArrayList<>();
        listaDeClientes.add(cli);

        model.addAttribute("lista", listaDeClientes);

        return "listClientes";
        //model.addAttribute("name", cli.getNome());
        //return "greeting";
    }

    @GetMapping("/listClientes")
    public String listarClientes(Model model) {
        List<String> listaDeClientes = new ArrayList<>();

        listaDeClientes.add("Joaquim Bastinhas");
        listaDeClientes.add("Maria Silva");
        listaDeClientes.add("Asdrubal");

        model.addAttribute("lista", listaDeClientes);
        return "listClientes";
    }

}