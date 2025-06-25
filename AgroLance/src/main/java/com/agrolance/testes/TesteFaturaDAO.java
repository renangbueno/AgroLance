package com.agrolance.testes;

import com.agrolance.dao.FaturaDAO;
import com.agrolance.model.Fatura;

import java.time.LocalDate;
import java.util.List;

public class TesteFaturaDAO {
    public static void main(String[] args) {
        FaturaDAO faturaDAO = new FaturaDAO();

        // Teste de inserção
        Fatura novaFatura = new Fatura();
        novaFatura.setIdVenda(1); // Substitua por um id_venda existente
        novaFatura.setValor(4000.00);
        novaFatura.setDataEmissao(LocalDate.now());
        novaFatura.setDataVencimento(LocalDate.now().plusDays(30));

        boolean inserido = faturaDAO.inserir(novaFatura);
        System.out.println("Fatura inserida com sucesso? " + inserido);

        // Teste de listagem
        List<Fatura> faturas = faturaDAO.listarTodos();
        System.out.println("Lista de faturas:");
        for (Fatura fatura : faturas) {
            System.out.println("ID: " + fatura.getIdFatura() +
                    ", Valor: " + fatura.getValor() +
                    ", Status: " + fatura.getStatus());
        }
    }
}
