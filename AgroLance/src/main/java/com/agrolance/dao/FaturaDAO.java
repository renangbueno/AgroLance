package com.agrolance.dao;

import com.agrolance.model.Fatura;
import com.agrolance.model.Fatura.StatusFatura;
import com.agrolance.model.Conexao;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FaturaDAO {

    public boolean inserir(Fatura fatura) {
        String sql = "INSERT INTO fatura (id_venda, valor, data_emissao, data_vencimento, status) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Conexao.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, fatura.getIdVenda());
            stmt.setDouble(2, fatura.getValor());
            stmt.setDate(3, Date.valueOf(fatura.getDataEmissao()));
            stmt.setDate(4, Date.valueOf(fatura.getDataVencimento()));
            stmt.setString(5, fatura.getStatus().name());

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Erro ao inserir fatura: " + e.getMessage());
            return false;
        }
    }

    public List<Fatura> listarTodos() {
        List<Fatura> faturas = new ArrayList<>();
        String sql = "SELECT * FROM fatura";

        try (Connection conn = Conexao.obterConexao();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Fatura fatura = new Fatura();
                fatura.setIdFatura(rs.getInt("id_fatura"));
                fatura.setIdVenda(rs.getInt("id_venda"));
                fatura.setValor(rs.getDouble("valor"));
                fatura.setDataEmissao(rs.getDate("data_emissao").toLocalDate());
                fatura.setDataVencimento(rs.getDate("data_vencimento").toLocalDate());
                fatura.setStatus(StatusFatura.valueOf(rs.getString("status").toUpperCase()));

                faturas.add(fatura);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar faturas: " + e.getMessage());
        }

        return faturas;
    }
}
