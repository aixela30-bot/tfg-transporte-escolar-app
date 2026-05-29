package com.example.transporteescolarapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FamiliaActivity extends AppCompatActivity {

    TextView txtEstadoMenor;
    TextView txtNotificacion;
    TextView txtUbicacion;
    Button btnVerUbicacion;
    Button btnActualizar;
    Button btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_familia);

        txtEstadoMenor = findViewById(R.id.txtEstadoMenor);
        txtNotificacion = findViewById(R.id.txtNotificacion);
        txtUbicacion = findViewById(R.id.txtUbicacion);

        btnVerUbicacion = findViewById(R.id.btnVerUbicacion);
        btnActualizar = findViewById(R.id.btnActualizar);
        btnVolver = findViewById(R.id.btnVolver);

        cargarDatos();

        btnActualizar.setOnClickListener(v -> {
            cargarDatos();
            Toast.makeText(this, "Datos actualizados", Toast.LENGTH_SHORT).show();
        });

        btnVerUbicacion.setOnClickListener(v -> {
            txtUbicacion.setText("Ubicación actual: " + DatosApp.ubicacionActual);
        });

        btnVolver.setOnClickListener(v -> finish());
    }

    private void cargarDatos() {
        txtEstadoMenor.setText("Estado del menor: " + DatosApp.estadoMenor);
        txtNotificacion.setText("Notificación: " + DatosApp.ultimaNotificacion);
        txtUbicacion.setText("Ubicación actual: " + DatosApp.ubicacionActual);
    }
}