/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;



/**
 * Classe para realizar as operações de CRUD para o objeto cliente
 * @author aluno
 */
public class ClienteDAO {
    Connection conexao;
    Statement stmt;
    
    public void inserirNovoCliente(Cliente cliente) throws ClassNotFoundException, SQLException{
        conexao = getConnection();
        stmt = conexao.createStatement();
        String sql = "INSERT INTO cliente VALUES ("
                + "'" + cliente.getNome() + "', "
                + "'" + cliente.getCpf() + "', "
                + "" + cliente.getRenda() + ", "
                + "" + cliente.isAtivo() + ")";
        if(stmt.executeUpdate(sql) > 0)
            JOptionPane.showMessageDialog(null, "Dados do cliente inseridos com sucesso");
        else
            JOptionPane.showMessageDialog(null, "Erro de gravação no BD");
    }
    
    public Cliente buscarClienteNome(String nome) throws ClassNotFoundException, SQLException{
        Cliente cliente = new Cliente();
        conexao = getConnection();
        ResultSet rs;
        stmt = conexao.createStatement();
        rs = stmt.executeQuery("SELECT * FROM cliente WHERE nome = '" + nome + "'");
       if(rs.first()){
            cliente.setNome(rs.getString("nome"));
            cliente.setCpf(rs.getString("cpf"));
            cliente.setRenda(rs.getFloat("renda"));
            cliente.setAtivo(rs.getBoolean("ativo"));
            return cliente;
        } else {
           JOptionPane.showMessageDialog(null, "Cliente não encontrado");
           return null;
       }
    }
    
    public List<Cliente> listarTodos() throws ClassNotFoundException, SQLException{
        List<Cliente> listaCliente = new ArrayList<>();
        conexao = getConnection();
        ResultSet rs;
        stmt = conexao.createStatement();
        rs = stmt.executeQuery("SELECT * FROM cliente");
        while(rs.next()){
            Cliente cliente = new Cliente();
            cliente.setNome(rs.getString("nome"));
            cliente.setCpf(rs.getString("cpf"));
            cliente.setRenda(rs.getFloat("renda"));
            cliente.setAtivo(rs.getBoolean("ativo"));
            //adiciona objeto cliente a listaCliente
            listaCliente.add(cliente);
        }
        return listaCliente;
    }
    public Connection getConnection() throws ClassNotFoundException, SQLException{
        Connection con;
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        con = DriverManager.getConnection("jdbc:derby://localhost:1527/concessionaria", "root", "12345");
        return con;
    }
    public Connection getConnection1() throws ClassNotFoundException, SQLException{
        Connection con;
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/concessionaria", "root", "");
        return con;
    }
}
