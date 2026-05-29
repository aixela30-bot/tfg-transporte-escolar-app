package com.example.transporteescolarapp;

public class Parada {

    private String nombre;
    private String hora;

    public Parada(String nombre, String hora) {
        this.nombre = nombre;
        this.hora = hora;
    }

    public String getNombre() {
        return nombre;
    }

    public String getHora() {
        return hora;
    }
}