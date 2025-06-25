package com.agrolance.dao;

import com.agrolance.model.Conexao;
import com.agrolance.model.Evento;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EventoDAO {

    public boolean inserir(Evento evento) {
        String sql = "INSERT INTO evento (nome, data, local) VALUES (?, ?, ?)";

        try (Connection conn = Conexao.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, evento.getNome());
            stmt.setDate(2, new java.sql.Date(evento.getData().getTime()));
            stmt.setString(3, evento.getLocal());

            int linhas = stmt.executeUpdate();
            return linhas > 0;

        } catch (SQLException e) {
            System.err.println("Erro ao inserir evento: " + e.getMessage());
            return false;
        }
    }

    public List<Evento> listar() {
        List<Evento> eventos = new ArrayList<>();
        String sql = "SELECT * FROM evento";

        try (Connection conn = Conexao.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Evento evento = new Evento();
                evento.setId(rs.getInt("id"));
                evento.setNome(rs.getString("nome"));
                evento.setData(rs.getDate("data"));
                evento.setLocal(rs.getString("local"));
                eventos.add(evento);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar eventos: " + e.getMessage());
        }

        return eventos;
    }
}
