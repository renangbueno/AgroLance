package com.agrolance.gui;

import com.agrolance.dao.VendaDAO;
import com.agrolance.model.Venda;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.util.List;

public class TelaVenda {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Cadastro de Vendas");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JTextField txtIdEvento = new JTextField(10);
        JTextField txtIdLote = new JTextField(10);
        JTextField txtIdComprador = new JTextField(10);
        JTextField txtIdVendedor = new JTextField(10);
        JTextField txtValor = new JTextField(10);
        JTextField txtData = new JTextField(10);

        JButton btnSalvar = new JButton("Salvar Venda");
        JButton btnListar = new JButton("Listar Vendas");

        JTable tabela = new JTable(new DefaultTableModel(
                new Object[]{"ID", "Evento", "Lote", "Comprador", "Vendedor", "Valor", "Data"}, 0));
        JScrollPane scrollPane = new JScrollPane(tabela);

        panel.add(new JLabel("ID Evento:"));
        panel.add(txtIdEvento);
        panel.add(new JLabel("ID Lote:"));
        panel.add(txtIdLote);
        panel.add(new JLabel("ID Comprador:"));
        panel.add(txtIdComprador);
        panel.add(new JLabel("ID Vendedor:"));
        panel.add(txtIdVendedor);
        panel.add(new JLabel("Valor da Venda:"));
        panel.add(txtValor);
        panel.add(new JLabel("Data da Venda (AAAA-MM-DD):"));
        panel.add(txtData);
        panel.add(btnSalvar);
        panel.add(btnListar);
        panel.add(scrollPane);

        btnSalvar.addActionListener((ActionEvent e) -> {
            try {
                Venda venda = new Venda();
                venda.setIdEvento(Integer.parseInt(txtIdEvento.getText()));
                venda.setIdLote(Integer.parseInt(txtIdLote.getText()));
                venda.setIdComprador(Integer.parseInt(txtIdComprador.getText()));
                venda.setIdVendedor(Integer.parseInt(txtIdVendedor.getText()));
                venda.setValorVenda(Double.parseDouble(txtValor.getText()));
                venda.setDataVenda(LocalDate.parse(txtData.getText()));

                boolean sucesso = new VendaDAO().inserir(venda);
                JOptionPane.showMessageDialog(frame, sucesso ? "Venda salva!" : "Erro ao salvar venda");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Erro: " + ex.getMessage());
            }
        });

        btnListar.addActionListener((ActionEvent e) -> {
            DefaultTableModel model = (DefaultTableModel) tabela.getModel();
            model.setRowCount(0);
            List<Venda> vendas = new VendaDAO().listarTodos();
            for (Venda v : vendas) {
                model.addRow(new Object[]{
                        v.getIdVenda(),
                        v.getIdEvento(),
                        v.getIdLote(),
                        v.getIdComprador(),
                        v.getIdVendedor(),
                        v.getValorVenda(),
                        v.getDataVenda()
                });
            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}
