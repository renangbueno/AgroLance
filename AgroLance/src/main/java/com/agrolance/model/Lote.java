package com.agrolance.model;

public class Lote {
    private int id;
    private int numero;
    private double pesoTotal;
    private int qtdAnimais;
    private int idEvento;

    // Construtor vazio
    public Lote() {
    }

    // Construtor com todos os campos (opcional)
    public Lote(int id, int numero, double pesoTotal, int qtdAnimais, int idEvento) {
        this.id = id;
        this.numero = numero;
        this.pesoTotal = pesoTotal;
        this.qtdAnimais = qtdAnimais;
        this.idEvento = idEvento;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getPesoTotal() {
        return pesoTotal;
    }

    public void setPesoTotal(double pesoTotal) {
        this.pesoTotal = pesoTotal;
    }

    public int getQtdAnimais() {
        return qtdAnimais;
    }

    public void setQtdAnimais(int qtdAnimais) {
        this.qtdAnimais = qtdAnimais;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }
}
