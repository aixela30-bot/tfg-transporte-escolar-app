package com.example.transporteescolarapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HistorialRutasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial_rutas);

        TextView txtHistorial =
                findViewById(R.id.txtHistorial);

        String texto = "";

        for (Ruta ruta : DatosApp.historialRutas) {

            texto += "Fecha: " + ruta.getFecha() + "\n";
            texto += "Estado: " + ruta.getEstado() + "\n";
            texto += "Incidencias: " + ruta.getIncidencias() + "\n\n";
        }

        if (texto.isEmpty()) {
            texto = "No existen rutas registradas";
        }

        txtHistorial.setText(texto);
    }
}