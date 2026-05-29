package com.example.transporteescolarapp;

import java.util.ArrayList;

public class DatosApp {

    public static String estadoMenor = "Subido al autobús";
    public static String ultimaNotificacion = "El menor ha iniciado la ruta correctamente.";
    public static String ubicacionActual = "Parada 1";

    public static ArrayList<Incidencia> incidencias =
            new ArrayList<>();
    public static ArrayList<Ruta> historialRutas =
            new ArrayList<>();

    public static ArrayList<Parada> paradas =
            new ArrayList<>();


    static {

        paradas.add(new Parada("Mungia Centro", "07:45"));
        paradas.add(new Parada("Larramendi Ikastola", "08:00"));
        paradas.add(new Parada("Arene", "08:10"));
        paradas.add(new Parada("Billela", "08:20"));
    }
}