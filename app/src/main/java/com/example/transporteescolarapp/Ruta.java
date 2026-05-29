package com.example.transporteescolarapp;

public class Ruta {

    private String fecha;
    private String estado;
    private int incidencias;

    public Ruta(String fecha, String estado, int incidencias) {
        this.fecha = fecha;
        this.estado = estado;
        this.incidencias = incidencias;
    }

    public String getFecha() {
        return fecha;
    }

    public String getEstado() {
        return estado;
    }

    public int getIncidencias() {
        return incidencias;
    }
}