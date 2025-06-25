package com.agrolance.testes;

import com.agrolance.model.Conexao;
import java.sql.Connection;
import java.sql.SQLException;

public class TesteConexao {
    public static void main(String[] args) {
        try (Connection conn = Conexao.obterConexao()) {
            System.out.println("✅ Conexão com o banco realizada com sucesso.");
        } catch (SQLException e) {
            System.out.println("❌ Erro ao conectar: " + e.getMessage());
        }
    }
}
