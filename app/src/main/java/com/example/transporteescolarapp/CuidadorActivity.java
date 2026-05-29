package com.example.transporteescolarapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CuidadorActivity extends AppCompatActivity {

    Button btnListaMenores;
    Button btnRutaGps;
    Button btnEnviarNotificacion;
    Button btnVerIncidencias;
    Button btnVolver;
    Button btnHistorialRutas;
    Button btnParadas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuidador);

        btnListaMenores = findViewById(R.id.btnListaMenores);
        btnRutaGps = findViewById(R.id.btnRutaGps);
        btnEnviarNotificacion = findViewById(R.id.btnEnviarNotificacion);
        btnVerIncidencias = findViewById(R.id.btnVerIncidencias);
        btnHistorialRutas = findViewById(R.id.btnHistorialRutas);
        btnParadas = findViewById(R.id.btnParadas);
        btnVolver = findViewById(R.id.btnVolver);

        btnListaMenores.setOnClickListener(v -> {
            Intent intent = new Intent(
                    CuidadorActivity.this,
                    ListaMenoresActivity.class
            );
            startActivity(intent);
        });

        btnRutaGps.setOnClickListener(v -> {
            Intent intent = new Intent(
                    CuidadorActivity.this,
                    RutaGpsActivity.class
            );
            startActivity(intent);
        });

        btnEnviarNotificacion.setOnClickListener(v -> {
            Intent intent = new Intent(
                    CuidadorActivity.this,
                    NotificacionesActivity.class
            );
            startActivity(intent);
        });

        btnVerIncidencias.setOnClickListener(v -> {
            Intent intent = new Intent(
                    CuidadorActivity.this,
                    IncidenciasActivity.class
            );
            startActivity(intent);
        });

        btnHistorialRutas.setOnClickListener(v -> {
            Intent intent = new Intent(
                    CuidadorActivity.this,
                    HistorialRutasActivity.class
            );
            startActivity(intent);
        });

        btnParadas.setOnClickListener(v -> {

            Intent intent = new Intent(
                    CuidadorActivity.this,
                    ParadasActivity.class
            );

            startActivity(intent);
        });

        btnVolver.setOnClickListener(v -> finish());
    }
}