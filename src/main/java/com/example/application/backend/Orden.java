package com.example.application.backend;

import java.util.ArrayList;
import java.util.List;

public class Orden {

    public static List<Orden> listaOrdenes = new ArrayList<>();
    public static List<Orden> listaProduccion = new ArrayList<>();
    public static List<Orden> listaOrdenesCompletadas = new ArrayList<>();

    protected int numero;
    protected boolean tubos;
    protected boolean OrdenTerminada;

    public Orden (int numero){
        this.numero = numero;
        this.tubos = false;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isTubos() {
        return tubos;
    }

    public void setTubos(boolean tubos) {
        this.tubos = tubos;
    }

    public boolean isOrdenTerminada() { return OrdenTerminada; }

    public void setOrdenTerminada(boolean ordenTerminada) { OrdenTerminada = ordenTerminada; }

}
