package com.agrolance.model;

public enum TipoCliente {
    COMPRADOR,
    VENDEDOR,
    AMBOS;

    @Override
    public String toString() {
        switch (this) {
            case COMPRADOR: return "Comprador";
            case VENDEDOR: return "Vendedor";
            case AMBOS: return "Ambos";
            default: return super.toString();
        }
    }
}

