package com.bd;

import com.bd.BLL.*;
import com.bd.DAL.*;
import org.hibernate.sql.Update;

import java.math.BigInteger;
import java.util.List;

public class Main {

    public static void main(String[] args) {




/*

        List<Pratos>   listaest = PratoBLL.readAll(true);
        for( Pratos est : listaest)
            System.out.println("descriçao: " + est.getDescricao());


     //  PratosEncomendados.findAllByListaPratos
        List<listaPedidosCozinheiro>   listaest = PratosEncomendadosBLL.readAllCoz(true);
        for(listaPedidosCozinheiro est : listaest)
            System.out.println("descriçao: " + est.getDescricao() + " quantidade:  " + est.getQtd() + " numero do pedido: " + est.getId_encomenda() );




        //cli.getIdCliente();
        //cli.setEstado(ClienteBLL.read(2));
      // ClienteBLL.update(cli);

        //ClienteBLL.updateEstado(2);

/*
        Clientes cli = new Clientes ();
        cli.setNome("Ana Lucia Maria");
        cli.setRua ("Rua Paque maio");
        cli.setCodpostal (456);
        cli.setNumtelemovel("60065");
        cli.setNif(BigInteger.valueOf(930));
        cli.setEstado(true);
       ClienteBLL.create(cli);

        System.out.println(cli.getIdCliente()+ cli.getNome());

        List<listaPedidos>   listaest = EncomendaBLL.readAll();
        for(listaPedidos est : listaest)
            System.out.println("nome " + est.getEncomendaestados() + " mail " + est.getId_encomenda());


 */
        //ClienteBLL.delete(5);
/*

        Estafeta est= new Estafeta();
        Users user = new Users ();
        Codpostais codpostais = new Codpostais();

        est.setEmail("joanous@delivery.com");
        est.setNumtelefone("99988487");
        est.setNome("Joano Lusi");
        est.setNif(98533);
        est.setIdEstafeta(57);
        est.setIdUser(BigInteger.valueOf(57));
        user.setNomeuser("joanolusi");
        user.setEmail("joanolus@dvery.com");
        user.setPassword("9897");
        user.setEstafeta(true);
        codpostais.setLocalidade("Baltar");
        //colocar o codpostal
        codpostais.setCodpostal(9982);

        UsersBLL.create(user);
        EstafetaBLL.create(est);
        CodPostaisBLL.create(codpostais);
>>>>>>> Stashed changes


*/
        /******************************************************
         *** ***********     USERS     ***********************
         ****************************************************

        //CRIAR USER
        Users user = new Users();
        user.setEmail("filipe_estafeta@gmail.com");
        user.setPassword("123"); //temos que encriptar
        user.setNomeuser("filipeestafeta");
        user.isEstafeta(1);
        UsersBLL.create(user);







/*
        /******************************************************
         *** ***********     pratos     ***********************
         ****************************************************
        ListaS dos pratos
                 List<Pratos> listaPra = PratoBLL.readAll("Omelete");
        for(Pratos pra1 : listaPra)
            System.out.println("ID " + pra1.getIdPrato() + " chama-se " + pra1.getDescricao() + "hjb" + pra1.getPrecoatual());

        Pratos pra = new Pratos();
        pra.setIdPrato((short) 1);
        pra.setDescricao("Omelete");
        pra.setStockdoses(4);
        pra.setPrecoatual(5);


        PratoBLL.create(pra);
        System.out.println("ID criado: " + pra.getIdPrato() + "Descricao: " + pra.getDescricao());

        List<Pratos> listaPra = PratoBLL.readAll("10");
        for(Pratos pra1 : listaPra)
            System.out.println("ID " + pra1.getIdPrato() + " chama-se " + pra1.getDescricao());

        //List<Pratos> listaPras = PratoBLL.readAll( "descricao");

 */


/*
         /******************************************************
         *** ***********     COD POSTAIS  ***********************
         *******************************************************

        List<Codpostais> listaCp = CodPostaisBLL.readAll("Vegas");
        for(Codpostais cp : listaCp)

            System.out.println("ID " + cp.getCodpostal() + " chama-se " + cp.getLocalidade());


        Codpostais cp =  new Codpostais();
        cp.setCodpostal("12");
        cp.setLocalidade("Maia");
        CodPostaisBLL.create(cp);

        System.out.println("ID criado: " + cp.getLocalidade());



        List<Codpostais> listaCp = CodPostaisBLL.readAll("Vegas");
        for(Codpostais cp : listaCp)

            System.out.println("ID " + cp.getCodpostal() + " chama-se " + cp.getLocalidade());





   */


         /******************************************************
         ***************   CLIENTES  **************************
         ******************************************************

        Clientes cli = new Clientes ();
        cli.setNome("Ana Lucia Maria");
        cli.setRua ("Rua BLALB44334LA");
        cli.setCodpostal ("10");
        cli.setNumtelemovel("600465");
        cli.setNif(Integer.parseInt("9993055"));

        ClienteBLL.create(cli);
        //ou
        //ClienteJpaController cliBll = new ClienteJpaController(factory);
        //cliBll.create(cli);
        //
        //
        System.out.println("ID criado: " + cli.getIdCliente());

        Clientes cl2 = ClienteBLL.read(cli.getIdCliente());

        if (cli.equals(cl2)) System.out.println("É o mesmo cliente!!!");
        else System.out.println("Pois!");


        List<Clientes> lista = ClienteBLL.readAll("Ana");
        for(Clientes cli1 : lista)
            System.out.println("ID " + cli1.getIdCliente() + " chama-se " + cli1.getNome() + " e mora em " + cli1.getRua());



      /*
        // TODO code application logic here

        Clientes cli = new Clientes ();
        cli.setIdCliente ('6');
        cli.setNome("Alambique de Almeida");
        cli.setNif ("444444");
        cli.setRua ("Rua Alfa  321");
        cli.setCodpostal ("23");
        cli.setNumtelemovel ("33333");
        cli.create();

        System.out.println("ID criado: " + cli.getIdCliente());

        /*
        Cliente cl2 = new Cliente();
        cl2.read(43);
        System.out.println("ID " + cl2.getIdCliente() + " chama-se " + cl2.getNome() + " e mora em " + cl2.getMorada());


        List<Clientes> listaDeClientes = Clientes.readAll( "nome");

        for(Clientes cl : listaDeClientes)
            System.out.println("ID " + cl.getIdCliente() + " chama-se " + cl.getNome() + " e mora em " + cl.getRua ());

        System.out.println("----------------------------------------------------------------------------------------");
        /*
        Cliente cl3 = new Cliente();
        cl3.read(118);
        System.out.println("ID " + cl3.getIdCliente() + " chama-se " + cl3.getNome() + " e mora em " + cl3.getMorada());

        cl3.setNome("Josefina d'Alenquer");
        cl3.setMorada("Praça da Liberdade");
        cl3.update();
        System.out.println("ID " + cl3.getIdCliente() + " chama-se " + cl3.getNome() + " e mora em " + cl3.getMorada());

        cl3.read(118);
        System.out.println("ID " + cl3.getIdCliente() + " chama-se " + cl3.getNome() + " e mora em " + cl3.getMorada());

        cl3.delete();
        */
    }
}
