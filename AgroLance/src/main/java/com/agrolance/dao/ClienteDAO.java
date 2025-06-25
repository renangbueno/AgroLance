package com.agrolance.dao;

import com.agrolance.model.Cliente;
import com.agrolance.model.Conexao;
import com.agrolance.model.TipoCliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    public boolean inserir(Cliente cliente) {
        String sql = "INSERT INTO cliente (nome, fazenda, cpfCnpj, tipo, telefone, email) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexao.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getFazenda());
            stmt.setString(3, cliente.getCpfCnpj());
            stmt.setString(4, cliente.getTipo().toString());
            stmt.setString(5, cliente.getTelefone());
            stmt.setString(6, cliente.getEmail());

            int linhasAfetadas = stmt.executeUpdate();
            return (linhasAfetadas > 0);
        } catch (SQLException e) {
            System.err.println("Erro ao inserir cliente: " + e.getMessage());
            return false;
        }
    }

    public List<Cliente> listar() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM cliente";
        try (Connection conn = Conexao.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setFazenda(rs.getString("fazenda"));
                cliente.setCpfCnpj(rs.getString("cpfCnpj"));
                cliente.setTipo(TipoCliente.valueOf(rs.getString("tipo").trim().toUpperCase()));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setEmail(rs.getString("email"));
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar clientes: " + e.getMessage());
        }
        return clientes;
    }
}
