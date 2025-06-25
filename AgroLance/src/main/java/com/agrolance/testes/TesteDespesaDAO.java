package com.agrolance.testes;

import com.agrolance.dao.DespesaDAO;
import com.agrolance.model.Despesa;

import java.time.LocalDate;
import java.util.List;

public class TesteDespesaDAO {
    public static void main(String[] args) {
        DespesaDAO despesaDAO = new DespesaDAO();

        // Teste de inserção
        Despesa novaDespesa = new Despesa();
        novaDespesa.setIdEvento(1); // Substituir por um ID de evento válido
        novaDespesa.setDescricao("Frete dos animais");
        novaDespesa.setValor(785.40);
        novaDespesa.setData(LocalDate.now());

        boolean inserido = despesaDAO.inserir(novaDespesa);
        System.out.println("Despesa inserida com sucesso? " + inserido);

        // Teste de listagem
        List<Despesa> despesas = despesaDAO.listarTodos();
        System.out.println("Lista de despesas:");
        for (Despesa d : despesas) {
            System.out.println("ID: " + d.getIdDespesa() +
                               " | Evento: " + d.getIdEvento() +
                               " | Descrição: " + d.getDescricao() +
                               " | Valor: " + d.getValor() +
                               " | Data: " + d.getData());
        }
    }
}
