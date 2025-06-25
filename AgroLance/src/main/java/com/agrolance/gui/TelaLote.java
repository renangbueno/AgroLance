package com.agrolance.gui;

import com.agrolance.dao.LoteDAO;
import com.agrolance.model.Lote;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TelaLote extends JFrame {
    private JTextField numeroField;
    private JTextField pesoTotalField;
    private JTextField qtdAnimaisField;
    private JTextField idEventoField;
    private JTable tabelaLotes;
    private DefaultTableModel tableModel;

    public TelaLote() {
        setTitle("Cadastro de Lotes");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(6, 2));

        panel.add(new JLabel("Número do Lote:"));
        numeroField = new JTextField();
        panel.add(numeroField);

        panel.add(new JLabel("Peso Total:"));
        pesoTotalField = new JTextField();
        panel.add(pesoTotalField);

        panel.add(new JLabel("Quantidade de Animais:"));
        qtdAnimaisField = new JTextField();
        panel.add(qtdAnimaisField);

        panel.add(new JLabel("ID do Evento:"));
        idEventoField = new JTextField();
        panel.add(idEventoField);

        JButton cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarLote();
            }
        });
        panel.add(cadastrarButton);

        JButton listarButton = new JButton("Listar Lotes");
        listarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarLotes();
            }
        });
        panel.add(listarButton);

        add(panel, BorderLayout.NORTH);

        tabelaLotes = new JTable();
        tableModel = new DefaultTableModel(new Object[]{"ID", "Número", "Peso Total", "Qtd Animais", "ID Evento"}, 0);
        tabelaLotes.setModel(tableModel);
        add(new JScrollPane(tabelaLotes), BorderLayout.CENTER);
    }

    private void cadastrarLote() {
        try {
            int numero = Integer.parseInt(numeroField.getText());
            double pesoTotal = Double.parseDouble(pesoTotalField.getText());
            int qtdAnimais = Integer.parseInt(qtdAnimaisField.getText());
            int idEvento = Integer.parseInt(idEventoField.getText());

            Lote lote = new Lote();
            lote.setNumero(numero);
            lote.setPesoTotal(pesoTotal);
            lote.setQtdAnimais(qtdAnimais);
            lote.setIdEvento(idEvento);

            LoteDAO dao = new LoteDAO();
            if (dao.inserir(lote)) {
                JOptionPane.showMessageDialog(this, "Lote cadastrado com sucesso!");
                limparCampos();
                listarLotes();
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao cadastrar lote.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos corretamente.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void listarLotes() {
        LoteDAO dao = new LoteDAO();
        List<Lote> lotes = dao.listar();

        tableModel.setRowCount(0);
        for (Lote l : lotes) {
            tableModel.addRow(new Object[]{l.getId(), l.getNumero(), l.getPesoTotal(), l.getQtdAnimais(), l.getIdEvento()});
        }
    }

    private void limparCampos() {
        numeroField.setText("");
        pesoTotalField.setText("");
        qtdAnimaisField.setText("");
        idEventoField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaLote tela = new TelaLote();
            tela.setVisible(true);
        });
    }
} 
