/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import java.util.List;
import model.Cliente;
import model.ClienteDAO;

/**
 * Classe com as regras de negócio para cadastrar um manipular clientes
 * @author aluno
 */
public class ClienteCtrl {
    
    public void receberCliente(Cliente cliente) throws ClassNotFoundException, SQLException{
        ClienteDAO cliDAO = new ClienteDAO();
        cliDAO.inserirNovoCliente(cliente);
    }
    
    public Cliente buscarCliente(String nome) throws ClassNotFoundException, SQLException{
        ClienteDAO cliDAO = new ClienteDAO();
        Cliente cliente = cliDAO.buscarClienteNome(nome);
        return cliente;
    }
    
    public List<Cliente> listar() throws ClassNotFoundException, SQLException{
        ClienteDAO cliDAO = new ClienteDAO();
        List<Cliente> lista = cliDAO.listarTodos();
        return lista;
    }
}
