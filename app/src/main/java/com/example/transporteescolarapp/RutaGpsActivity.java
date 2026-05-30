package com.example.transporteescolarapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RutaGpsActivity extends AppCompatActivity {

    TextView txtUbicacionActual, pinMapa;
    Button btnActualizarGps, btnVolver;

    int posicionActual = 0;

    String[] ubicaciones = {
            "📍 Ubicación actual: Aeropuerto de Bilbao",
            "📍 Ubicación actual: Laukariz",
            "📍 Ubicación actual: Mungia",
            "📍 Ubicación actual: Larramendi Ikastola"
    };

    float[] posicionesX = {30f, 120f, 190f, 235f};
    float[] posicionesY = {180f, 145f, 70f, 95f};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ruta_gps);

        txtUbicacionActual = findViewById(R.id.txtUbicacionActual);
        pinMapa = findViewById(R.id.pinMapa);
        btnActualizarGps = findViewById(R.id.btnActualizarGps);
        btnVolver = findViewById(R.id.btnVolver);

        actualizarPantalla();

        btnActualizarGps.setOnClickListener(v -> {
            if (posicionActual < ubicaciones.length - 1) {
                posicionActual++;
            }
            actualizarPantalla();
        });

        btnVolver.setOnClickListener(v -> finish());
    }

    private void actualizarPantalla() {
        txtUbicacionActual.setText(ubicaciones[posicionActual]);
        pinMapa.setTranslationX(posicionesX[posicionActual]);
        pinMapa.setTranslationY(posicionesY[posicionActual]);
    }
}