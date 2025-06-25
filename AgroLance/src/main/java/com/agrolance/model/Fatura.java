package com.agrolance.model;

import java.time.LocalDate;

public class Fatura {

    public enum StatusFatura {
        PENDENTE, PAGO
    }

    private int idFatura;
    private int idVenda;
    private double valor;
    private LocalDate dataEmissao;
    private LocalDate dataVencimento;
    private StatusFatura status;

    public Fatura() {
        this.status = StatusFatura.PENDENTE;
    }

    // Getters e Setters
    public int getIdFatura() {
        return idFatura;
    }

    public void setIdFatura(int idFatura) {
        this.idFatura = idFatura;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDate getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(LocalDate dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public StatusFatura getStatus() {
        return status;
    }

    public void setStatus(StatusFatura status) {
        this.status = status;
    }
}
