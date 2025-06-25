package com.agrolance.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrincipalGUI {

    public static void main(String[] args) {
        JFrame frame = new JFrame("AgroLance - Menu Principal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 51, 0)); // fundo verde escuro
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        frame.add(panel);

        Font buttonFont = new Font("Arial", Font.BOLD, 15);
        Color buttonColor = new Color(204, 255, 204); // verde claro

        JButton btnClientes = criarBotao("👤 Clientes", buttonFont, buttonColor, e -> TelaCliente.main(null));
        JButton btnEventos = criarBotao("📅 Leilões", buttonFont, buttonColor, e -> TelaEvento.main(null));
        JButton btnLotes = criarBotao("🐄 Lotes", buttonFont, buttonColor, e -> TelaLote.main(null));
        JButton btnVendas = criarBotao("💰 Vendas", buttonFont, buttonColor, e -> TelaVenda.main(null));
        JButton btnFaturas = criarBotao("🧾 Faturas", buttonFont, buttonColor, e -> TelaFatura.main(null));
        JButton btnRelatorios = criarBotao("📊 Relatórios", buttonFont, buttonColor, e -> TelaRelatorios.main(null));

        panel.add(Box.createVerticalStrut(20));
        panel.add(btnClientes);
        panel.add(Box.createVerticalStrut(10));
        panel.add(btnEventos);
        panel.add(Box.createVerticalStrut(10));
        panel.add(btnLotes);
        panel.add(Box.createVerticalStrut(10));
        panel.add(btnVendas);
        panel.add(Box.createVerticalStrut(10));
        panel.add(btnFaturas);
        panel.add(Box.createVerticalStrut(10));
        panel.add(btnRelatorios);

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
