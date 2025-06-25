package com.agrolance.dao;

import com.agrolance.model.Despesa;
import com.agrolance.model.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.List;
import java.util.ArrayList;

public class DespesaDAO {

    public boolean inserir(Despesa despesa) {
        String sql = "INSERT INTO despesa (id_evento, descricao, valor, data) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexao.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, despesa.getIdEvento());
            stmt.setString(2, despesa.getDescricao());
            stmt.setDouble(3, despesa.getValor());
            stmt.setDate(4, Date.valueOf(despesa.getData()));

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Erro ao inserir despesa: " + e.getMessage());
            return false;
        }
    }

    public List<Despesa> listarTodos() {
        List<Despesa> despesas = new ArrayList<>();
        String sql = "SELECT * FROM despesa";

        try (Connection conn = Conexao.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Despesa despesa = new Despesa();
                despesa.setIdDespesa(rs.getInt("id_despesa"));
                despesa.setIdEvento(rs.getInt("id_evento"));
                despesa.setDescricao(rs.getString("descricao"));
                despesa.setValor(rs.getDouble("valor"));
                despesa.setData(rs.getDate("data").toLocalDate());
                despesas.add(despesa);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar despesas: " + e.getMessage());
        }

        return despesas;
    }
}
