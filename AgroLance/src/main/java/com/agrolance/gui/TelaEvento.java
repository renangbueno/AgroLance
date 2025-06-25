package com.agrolance.gui;

import com.agrolance.dao.EventoDAO;
import com.agrolance.model.Evento;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TelaEvento extends JFrame {

    private JTextField nomeField, localField;
    private JFormattedTextField dataField;
    private JTable tabela;
    private DefaultTableModel tabelaModel;

    public TelaEvento() {
        setTitle("Leilões - Cadastro e Listagem");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        JPanel painelFormulario = new JPanel(new GridLayout(4, 2));

        painelFormulario.add(new JLabel("Nome:"));
        nomeField = new JTextField();
        painelFormulario.add(nomeField);

        painelFormulario.add(new JLabel("Data (dd/MM/yyyy):"));
        dataField = new JFormattedTextField(new SimpleDateFormat("dd/MM/yyyy"));
        dataField.setValue(new Date());
        painelFormulario.add(dataField);

        painelFormulario.add(new JLabel("Local:"));
        localField = new JTextField();
        painelFormulario.add(localField);

        JButton botaoSalvar = new JButton("Cadastrar Leilão");
        botaoSalvar.addActionListener(this::salvarEvento);
        painelFormulario.add(botaoSalvar);

        getContentPane().add(painelFormulario, BorderLayout.NORTH);

        tabelaModel = new DefaultTableModel(new Object[]{"ID", "Nome", "Data", "Local"}, 0);
        tabela = new JTable(tabelaModel);
        JScrollPane scroll = new JScrollPane(tabela);
        getContentPane().add(scroll, BorderLayout.CENTER);

        atualizarTabela();

        setVisible(true);
    }

    private void salvarEvento(ActionEvent e) {
        try {
            String nome = nomeField.getText();
            String local = localField.getText();
            String dataStr = dataField.getText();

            Evento evento = new Evento();
            evento.setNome(nome);
            evento.setLocal(local);
            evento.setData(new SimpleDateFormat("dd/MM/yyyy").parse(dataStr));

            EventoDAO dao = new EventoDAO();
            dao.inserir(evento);

            atualizarTabela();

            JOptionPane.showMessageDialog(this, "Leilão cadastrado com sucesso!");
            nomeField.setText("");
            localField.setText("");
            dataField.setValue(new Date());

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
        }
    }

    private void atualizarTabela() {
        tabelaModel.setRowCount(0);
        EventoDAO dao = new EventoDAO();
        List<Evento> eventos = dao.listar();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (Evento ev : eventos) {
            tabelaModel.addRow(new Object[]{
                    ev.getId(),
                    ev.getNome(),
                    sdf.format(ev.getData()),
                    ev.getLocal()
            });
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TelaEvento::new);
    }
}
