package com.agrolance.gui;

import com.agrolance.dao.ClienteDAO;
import com.agrolance.model.Cliente;
import com.agrolance.model.TipoCliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TelaCliente extends JFrame {
    private JTextField txtNome, txtCpfCnpj, txtFazenda, txtTelefone, txtEmail;
    private JComboBox<TipoCliente> cbTipo;

    public TelaCliente() {
        setTitle("Cadastro de Cliente");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(7, 2));

        txtNome = new JTextField();
        txtCpfCnpj = new JTextField();
        txtFazenda = new JTextField();
        txtTelefone = new JTextField();
        txtEmail = new JTextField();
        cbTipo = new JComboBox<>(TipoCliente.values());

        add(new JLabel("Nome:"));
        add(txtNome);
        add(new JLabel("CPF/CNPJ:"));
        add(txtCpfCnpj);
        add(new JLabel("Fazenda:"));
        add(txtFazenda);
        add(new JLabel("Telefone:"));
        add(txtTelefone);
        add(new JLabel("Email:"));
        add(txtEmail);
        add(new JLabel("Tipo:"));
        add(cbTipo);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.addActionListener(this::salvarCliente);
        add(btnSalvar);

        JButton btnFechar = new JButton("Fechar");
        btnFechar.addActionListener(e -> dispose());
        add(btnFechar);
    }

    private void salvarCliente(ActionEvent e) {
        Cliente cliente = new Cliente();
        cliente.setNome(txtNome.getText());
        cliente.setCpfCnpj(txtCpfCnpj.getText());
        cliente.setFazenda(txtFazenda.getText());
        cliente.setTelefone(txtTelefone.getText());
        cliente.setEmail(txtEmail.getText());
        cliente.setTipo((TipoCliente) cbTipo.getSelectedItem());

        ClienteDAO dao = new ClienteDAO();
        if (dao.inserir(cliente)) {
            JOptionPane.showMessageDialog(this, "Cliente cadastrado com sucesso!");
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar cliente.");
        }
    }

    public static void mostrar() {
        SwingUtilities.invokeLater(() -> new TelaCliente().setVisible(true));
    }

    public static void main(String[] args) {
        mostrar(); // uso direto pra testes
    }
}
