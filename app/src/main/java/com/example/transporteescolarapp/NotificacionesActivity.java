package com.example.transporteescolarapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class NotificacionesActivity extends AppCompatActivity {

    TextView txtMensajeNotificacion;
    Button btnEnviarSubida;
    Button btnEnviarBajada;
    Button btnEnviarIncidencia;
    Button btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificaciones);

        txtMensajeNotificacion = findViewById(R.id.txtMensajeNotificacion);
        btnEnviarSubida = findViewById(R.id.btnEnviarSubida);
        btnEnviarBajada = findViewById(R.id.btnEnviarBajada);
        btnEnviarIncidencia = findViewById(R.id.btnEnviarIncidencia);
        btnVolver = findViewById(R.id.btnVolver);

        btnEnviarSubida.setOnClickListener(v -> {
            txtMensajeNotificacion.setText("Notificación enviada: el menor ha subido al autobús.");
            Toast.makeText(this, "Aviso de subida enviado", Toast.LENGTH_SHORT).show();
        });

        btnEnviarBajada.setOnClickListener(v -> {
            txtMensajeNotificacion.setText("Notificación enviada: el menor ha bajado correctamente.");
            Toast.makeText(this, "Aviso de bajada enviado", Toast.LENGTH_SHORT).show();
        });

        btnEnviarIncidencia.setOnClickListener(v -> {
            txtMensajeNotificacion.setText("Notificación enviada: se ha registrado una incidencia en la ruta.");
            Toast.makeText(this, "Aviso de incidencia enviado", Toast.LENGTH_SHORT).show();
        });

        btnVolver.setOnClickListener(v -> finish());
    }
}