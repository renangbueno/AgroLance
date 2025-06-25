package com.agrolance.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaRelatorios {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Relatórios - AgroLance");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 350);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 51, 0)); // Verde escuro
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        frame.add(panel);

        Font font = new Font("Arial", Font.BOLD, 15);
        Color buttonColor = new Color(204, 255, 204); // Verde claro

        JButton btnRelatorioClientes = criarBotao("📋 Relatório de Clientes", font, buttonColor, e -> {
            JOptionPane.showMessageDialog(frame, "Relatório de Clientes gerado!");
            // Aqui você poderia abrir uma nova janela com visualização
        });

        JButton btnRelatorioEventos = criarBotao("📅 Relatório de Leilões", font, buttonColor, e -> {
            JOptionPane.showMessageDialog(frame, "Relatório de Eventos gerado!");
        });

        JButton btnRelatorioVendas = criarBotao("💸 Relatório de Vendas", font, buttonColor, e -> {
            JOptionPane.showMessageDialog(frame, "Relatório de Vendas gerado!");
        });

        JButton btnExportar = criarBotao("🖨️ Exportar PDF", font, buttonColor, e -> {
            JOptionPane.showMessageDialog(frame, "Exportando relatório para PDF...");
        });

        panel.add(Box.createVerticalStrut(15));
        panel.add(btnRelatorioClientes);
        panel.add(Box.createVerticalStrut(10));
        panel.add(btnRelatorioEventos);
        panel.add(Box.createVerticalStrut(10));
        panel.add(btnRelatorioVendas);
        panel.add(Box.createVerticalStrut(10));
        panel.add(btnExportar);

        frame.setVisible(true);
    }

    private static JButton criarBotao(String texto, Font fonte, Color corFundo, ActionListener acao) {
        JButton botao = new JButton(texto);
        botao.setFont(fonte);
        botao.setBackground(corFundo);
        botao.setAlignmentX(Component.CENTER_ALIGNMENT);
        botao.setFocusPainted(false);
        botao.addActionListener(acao);
        return botao;
    }
}
