package com.agrolance.dao;

import com.agrolance.model.Conexao;
import com.agrolance.model.Lote;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoteDAO {

    public boolean inserir(Lote lote) {
        String sql = "INSERT INTO lote (numero, pesoTotal, qtdAnimais, idEvento) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexao.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, lote.getNumero());
            stmt.setDouble(2, lote.getPesoTotal());
            stmt.setInt(3, lote.getQtdAnimais());
            stmt.setInt(4, lote.getIdEvento());

            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0;

        } catch (SQLException e) {
            System.err.println("Erro ao inserir lote: " + e.getMessage());
            return false;
        }
    }

    public List<Lote> listar() {
        List<Lote> lotes = new ArrayList<>();
        String sql = "SELECT * FROM lote";

        try (Connection conn = Conexao.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Lote lote = new Lote();
                lote.setId(rs.getInt("id"));
                lote.setNumero(rs.getInt("numero"));
                lote.setPesoTotal(rs.getDouble("pesoTotal"));
                lote.setQtdAnimais(rs.getInt("qtdAnimais"));
                lote.setIdEvento(rs.getInt("idEvento"));
                lotes.add(lote);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar lotes: " + e.getMessage());
        }

        return lotes;
    }
}