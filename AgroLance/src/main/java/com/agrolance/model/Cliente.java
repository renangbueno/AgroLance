package com.agrolance.model;

public class Cliente {
    private int id;
    private String nome;
    private String fazenda;
    private String cpfCnpj;
    private TipoCliente tipo;
    private String telefone;
    private String email;

    // Construtores
    public Cliente() {}

    public Cliente(int id, String nome, String fazenda, String cpfCnpj, TipoCliente tipo, String telefone, String email) {
        this.id = id;
        this.nome = nome;
        this.fazenda = fazenda;
        this.cpfCnpj = cpfCnpj;
        this.tipo = tipo;
        this.telefone = telefone;
        this.email = email;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFazenda() {
        return fazenda;
    }
    public void setFazenda(String fazenda) {
        this.fazenda = fazenda;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }
    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public TipoCliente getTipo() {
        return tipo;
    }
    public void setTipo(TipoCliente tipo) {
        this.tipo = tipo;
    }

    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    // toString() opcional para depuração
    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", fazenda='" + fazenda + '\'' +
                ", cpfCnpj='" + cpfCnpj + '\'' +
                ", tipo=" + tipo +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
