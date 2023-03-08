/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemploGoodAndBad;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Miguel
 */
public class ExemploGoodAndBad {
    public static void main(String[] args) {
        List<Cliente> clis;
        try{
            clis = Cliente.retrieveAll("Silva");
        }
        catch(Exception ex){
            System.out.println("Erro");
            clis = new ArrayList<>();
        }
        
        for (Cliente cli : clis)
            System.out.println(cli.getNome());
        
        /*
        Cliente cli = new Cliente();
        
        try{
            cli.retrieve(3);
        }
        catch(SQLException ex){
            System.out.println("Erro: " + ex.getMessage());
        }
        
        System.out.println(cli.getNome());
        System.out.println(cli.getMorada());
        System.out.println(cli.getCpostal());
        */
        Cliente cli1 = new Cliente();
        cli1.setNome("Asdrubal Zacarias");
        cli1.setMorada("Rua XYZ");
        cli1.setCpostal("4321-123");
        try{
            cli1.create();
        }
        catch(SQLException ex){
            System.out.println("Erro: " + ex.getMessage());
        }
    }

       
}
