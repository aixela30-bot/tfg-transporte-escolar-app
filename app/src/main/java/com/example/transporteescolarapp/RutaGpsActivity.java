package com.example.transporteescolarapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RutaGpsActivity extends AppCompatActivity {

    TextView txtEstadoRuta;
    TextView txtUbicacionActual;
    Button btnActualizarGps;
    Button btnVolver;

    int paradaActual = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ruta_gps);

        txtEstadoRuta = findViewById(R.id.txtEstadoRuta);
        txtUbicacionActual = findViewById(R.id.txtUbicacionActual);
        btnActualizarGps = findViewById(R.id.btnActualizarGps);
        btnVolver = findViewById(R.id.btnVolver);

        txtEstadoRuta.setText("Estado de ruta: En curso");
        txtUbicacionActual.setText("Ubicación actual: Parada 1");

        btnActualizarGps.setOnClickListener(v -> {
            paradaActual++;

            if (paradaActual == 2) {
                txtUbicacionActual.setText("Ubicación actual: Parada 2");
            } else if (paradaActual == 3) {
                txtUbicacionActual.setText("Ubicación actual: Parada 3");
            } else if (paradaActual == 4) {
                txtUbicacionActual.setText("Ubicación actual: Llegando a la ikastola");
            } else {
                txtEstadoRuta.setText("Estado de ruta: Finalizada");
                txtUbicacionActual.setText("Ubicación actual: Ikastola");
                Toast.makeText(this, "La ruta ha finalizado", Toast.LENGTH_SHORT).show();
            }
        });

        btnVolver.setOnClickListener(v -> finish());
    }
}