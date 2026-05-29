package com.example.transporteescolarapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class IncidenciasActivity extends AppCompatActivity {

    TextView txtIncidencias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incidencias);

        txtIncidencias = findViewById(R.id.txtIncidencias);

        mostrarIncidencias();
    }

    private void mostrarIncidencias() {

        String texto = "";

        for (Incidencia i : DatosApp.incidencias) {

            texto += "Menor: " + i.getMenor() + "\n";
            texto += "Incidencia: " + i.getDescripcion() + "\n\n";
        }

        if (texto.isEmpty()) {
            texto = "No existen incidencias registradas";
        }

        txtIncidencias.setText(texto);
    }
}