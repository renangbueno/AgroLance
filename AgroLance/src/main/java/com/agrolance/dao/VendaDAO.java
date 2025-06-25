package com.agrolance.dao;

import com.agrolance.model.Venda;
import com.agrolance.model.Conexao;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VendaDAO {

    public boolean inserir(Venda venda) {
        String sql = "INSERT INTO venda (id_evento, id_lote, id_comprador, id_vendedor, valor_venda, data_venda) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, venda.getIdEvento());
            stmt.setInt(2, venda.getIdLote());
            stmt.setInt(3, venda.getIdComprador());
            stmt.setInt(4, venda.getIdVendedor());
            stmt.setDouble(5, venda.getValorVenda());
            stmt.setDate(6, Date.valueOf(venda.getDataVenda()));

            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao inserir venda: " + e.getMessage());
            return false;
        }
    }

    public List<Venda> listarTodos() {
        List<Venda> vendas = new ArrayList<>();
        String sql = "SELECT * FROM venda";

        try (Connection conn = Conexao.obterConexao();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Venda venda = new Venda();
                venda.setIdVenda(rs.getInt("id_venda"));
                venda.setIdEvento(rs.getInt("id_evento"));
                venda.setIdLote(rs.getInt("id_lote"));
                venda.setIdComprador(rs.getInt("id_comprador"));
                venda.setIdVendedor(rs.getInt("id_vendedor"));
                venda.setValorVenda(rs.getDouble("valor_venda"));
                venda.setDataVenda(rs.getDate("data_venda").toLocalDate());
                vendas.add(venda);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar vendas: " + e.getMessage());
        }

        return vendas;
    }
}

