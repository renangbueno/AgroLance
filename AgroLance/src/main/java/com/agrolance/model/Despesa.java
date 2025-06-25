package com.agrolance.model;

import java.time.LocalDate;

public class Despesa {

    private int idDespesa;
    private int idEvento;
    private String descricao;
    private double valor;
    private LocalDate data;

    public Despesa() {}

    public Despesa(int idDespesa, int idEvento, String descricao, double valor, LocalDate data) {
        this.idDespesa = idDespesa;
        this.idEvento = idEvento;
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
    }

    public int getIdDespesa() {
        return idDespesa;
    }

    public void setIdDespesa(int idDespesa) {
        this.idDespesa = idDespesa;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
