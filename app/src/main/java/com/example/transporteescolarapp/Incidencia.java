package com.example.transporteescolarapp;

public class Incidencia {

    private String menor;
    private String descripcion;

    public Incidencia(String menor, String descripcion) {
        this.menor = menor;
        this.descripcion = descripcion;
    }

    public String getMenor() {
        return menor;
    }

    public String getDescripcion() {
        return descripcion;
    }
}