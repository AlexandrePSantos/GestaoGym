/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemploGoodAndBad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author miguel
 */
public class Cliente {
    private int idCliente;
    private String nome;
    private String morada;
    private String cpostal;
    private Connection conn;
    
    public Cliente(){
        conn = Cliente.criarConexao();
    }

    public int getIdCliente() {
        return idCliente;
    }

    //public void setIdCliente(int idCliente) {
    //    this.idCliente = idCliente;
    //}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getCpostal() {
        return cpostal;
    }

    public void setCpostal(String cpostal) {
        this.cpostal = cpostal;
    }
    
    private static Connection criarConexao(){
        Connection conexao = null;
        try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
            }
        catch(ClassNotFoundException e) {
                System.out.println("Oops! Can't find class oracle.jdbc.driver.OracleDriver");
                System.exit(-1);
            }
        
        try{
                conexao = DriverManager.getConnection(
                        "jdbc:oracle:thin:@localhost:1521:XE", "miguel","miguel2023");
                //conn.setAutoCommit(false);
            }
        catch(Exception e){
                System.out.println("ERRO " + e.getMessage());
                //javax.swing.JOptionPane.showMessageDialog(null,e.getMessage(),"ERRO", javax.swing.JOptionPane.ERROR_MESSAGE);
                System.exit(-2);
            }
        
        return conexao;
    }
    
    // BAD
    public void create1() throws SQLException{
        
        String sqlCommand = "INSERT INTO CLIENTE COLUMNS (NOME, MORADA, CPOSTAL) " + 
                "VALUES ('" + this.nome + "', '" + this.morada + "', '" + this.cpostal + "')";
        Statement st = conn.createStatement();
        st.execute(sqlCommand);
    }
    
    //GOOD
    public void create() throws SQLException{
        String sqlCommand = "INSERT INTO CLIENTE COLUMNS (NOME, MORADA, CPOSTAL) " + 
                "VALUES (?, ?, ?)";
        
        PreparedStatement pst = conn.prepareStatement(sqlCommand);
        
        pst.setString(1, this.nome);
        pst.setString(2, this.morada);
        pst.setString(3, this.cpostal);
        
        pst.execute();
    }
    
    public void retrieve(int idCliente) throws SQLException{
        String sqlCommand = "SELECT NOME, MORADA, CPOSTAL FROM CLIENTE WHERE IdCliente = ?";
        
        PreparedStatement pst = conn.prepareStatement(sqlCommand);
        pst.setInt(1, idCliente);
        
        ResultSet rs = pst.executeQuery();
        if (rs.next()){
            if (rs.getString("NOME") != null)
                this.nome = rs.getString("NOME");
            if (rs.getString("MORADA") != null)
                this.morada = rs.getString("MORADA");
            if (rs.getString("CPOSTAL") != null)
                this.cpostal = rs.getString("CPOSTAL");
        }
        
    }

    public static List<Cliente> retrieveAll() throws SQLException{
        
        List<Cliente> resultAux = new ArrayList<>();
        
        Connection conn = criarConexao();
        String sqlCommand = "SELECT NOME, MORADA, CPOSTAL FROM CLIENTE";
        
        PreparedStatement pst = conn.prepareStatement(sqlCommand);
        
        ResultSet rs = pst.executeQuery();
        while (rs.next()){
            Cliente cli = new Cliente();
            if (rs.getString("NOME") != null)
                cli.setNome(rs.getString("NOME"));
            if (rs.getString("MORADA") != null)
                cli.setMorada(rs.getString("MORADA"));
            if (rs.getString("CPOSTAL") != null)
                cli.setCpostal(rs.getString("CPOSTAL"));
            
            resultAux.add(cli);
        }
        
        return resultAux;
    }

    public static List<Cliente> retrieveAll(String filtro) throws SQLException{

        List<Cliente> resultAux = new ArrayList<>();

        Connection conn = criarConexao();
        String sqlCommand = "SELECT NOME, MORADA, CPOSTAL FROM CLIENTE WHERE NOME LIKE ?";

        PreparedStatement pst = conn.prepareStatement(sqlCommand);

        pst.setString(1, "%"+filtro+"%");

        ResultSet rs = pst.executeQuery();
        while (rs.next()){
            Cliente cli = new Cliente();
            if (rs.getString("NOME") != null)
                cli.setNome(rs.getString("NOME"));
            if (rs.getString("MORADA") != null)
                cli.setMorada(rs.getString("MORADA"));
            if (rs.getString("CPOSTAL") != null)
                cli.setCpostal(rs.getString("CPOSTAL"));

            resultAux.add(cli);
        }

        return resultAux;
    }
}
