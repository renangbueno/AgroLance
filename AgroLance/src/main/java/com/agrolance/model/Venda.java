package com.agrolance.model;

import java.time.LocalDate;

public class Venda {

    private int idVenda;
    private int idEvento;
    private int idLote;
    private int idComprador;
    private int idVendedor;
    private double valorVenda;
    private LocalDate dataVenda;

    public Venda() {}

    public Venda(int idVenda, int idEvento, int idLote, int idComprador, int idVendedor, double valorVenda, LocalDate dataVenda) {
        this.idVenda = idVenda;
        this.idEvento = idEvento;
        this.idLote = idLote;
        this.idComprador = idComprador;
        this.idVendedor = idVendedor;
        this.valorVenda = valorVenda;
        this.dataVenda = dataVenda;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public int getIdLote() {
        return idLote;
    }

    public void setIdLote(int idLote) {
        this.idLote = idLote;
    }

    public int getIdComprador() {
        return idComprador;
    }

    public void setIdComprador(int idComprador) {
        this.idComprador = idComprador;
    }

    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }
}

