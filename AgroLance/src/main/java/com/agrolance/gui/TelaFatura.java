package com.agrolance.gui;

import com.agrolance.dao.FaturaDAO;
import com.agrolance.model.Fatura;
import com.agrolance.model.Fatura.StatusFatura;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDate;
import java.util.List;

public class TelaFatura {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Cadastro de Faturas");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(700, 450);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(7, 2, 5, 5));

        JTextField txtIdVenda = new JTextField();
        JTextField txtValor = new JTextField();
        JTextField txtDataEmissao = new JTextField("2025-06-25");
        JTextField txtDataVencimento = new JTextField("2025-07-10");

        String[] statusOptions = {"PENDENTE", "PAGA", "ATRASADA"};
        JComboBox<String> cmbStatus = new JComboBox<>(statusOptions);

        JButton btnSalvar = new JButton("Salvar Fatura");

        panel.add(new JLabel("ID Venda:"));
        panel.add(txtIdVenda);

        panel.add(new JLabel("Valor:"));
        panel.add(txtValor);

        panel.add(new JLabel("Data Emissão (AAAA-MM-DD):"));
        panel.add(txtDataEmissao);

        panel.add(new JLabel("Data Vencimento (AAAA-MM-DD):"));
        panel.add(txtDataVencimento);

        panel.add(new JLabel("Status:"));
        panel.add(cmbStatus);

        panel.add(new JLabel());
        panel.add(btnSalvar);

        // Tabela
        String[] colunas = {"ID", "ID Venda", "Valor", "Emissão", "Vencimento", "Status"};
        DefaultTableModel tableModel = new DefaultTableModel(colunas, 0);
        JTable tabela = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tabela);

        atualizarTabela(tableModel);

        btnSalvar.addActionListener(e -> {
            Fatura f = new Fatura();
            f.setIdVenda(Integer.parseInt(txtIdVenda.getText()));
            f.setValor(Double.parseDouble(txtValor.getText()));
            f.setDataEmissao(LocalDate.parse(txtDataEmissao.getText()));
            f.setDataVencimento(LocalDate.parse(txtDataVencimento.getText()));
            f.setStatus(StatusFatura.valueOf(cmbStatus.getSelectedItem().toString()));

            boolean sucesso = new FaturaDAO().inserir(f);
            if (sucesso) {
                JOptionPane.showMessageDialog(frame, "Fatura salva com sucesso!");
                atualizarTabela(tableModel);
            } else {
                JOptionPane.showMessageDialog(frame, "Erro ao salvar fatura.");
            }
        });

        frame.setLayout(new BorderLayout());
        frame.add(panel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private static void atualizarTabela(DefaultTableModel tableModel) {
        tableModel.setRowCount(0);
        List<Fatura> faturas = new FaturaDAO().listarTodos();
        for (Fatura f : faturas) {
            tableModel.addRow(new Object[]{
                f.getIdFatura(),
                f.getIdVenda(),
                f.getValor(),
                f.getDataEmissao(),
                f.getDataVencimento(),
                f.getStatus()
            });
        }
    }
}
