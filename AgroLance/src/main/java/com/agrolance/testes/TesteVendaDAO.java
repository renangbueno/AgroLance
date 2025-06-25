package com.agrolance.testes;

import com.agrolance.dao.VendaDAO;
import com.agrolance.model.Venda;

import java.time.LocalDate;
import java.util.List;

public class TesteVendaDAO {
    public static void main(String[] args) {
        VendaDAO vendaDAO = new VendaDAO();

        // Teste de inserção
        Venda novaVenda = new Venda();
        novaVenda.setIdEvento(1);      // ID válido
        novaVenda.setIdLote(1);        // ID válido
        novaVenda.setIdComprador(2);   // ID válido
        novaVenda.setIdVendedor(3);    // ID válido
        novaVenda.setValorVenda(12500.00);
        novaVenda.setDataVenda(LocalDate.now());

        boolean inserido = vendaDAO.inserir(novaVenda);
        System.out.println("Venda inserida com sucesso? " + inserido);

        // Teste de listagem
        List<Venda> vendas = vendaDAO.listarTodos();
        System.out.println("Lista de vendas:");
        for (Venda venda : vendas) {
            System.out.println("ID: " + venda.getIdVenda() +
                               " | Evento: " + venda.getIdEvento() +
                               " | Lote: " + venda.getIdLote() +
                               " | Comprador: " + venda.getIdComprador() +
                               " | Vendedor: " + venda.getIdVendedor() +
                               " | Valor: R$" + venda.getValorVenda());
        }
    }
}
