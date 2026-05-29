package com.example.transporteescolarapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnCuidador;
    Button btnFamilia;
    Button btnCerrarSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCuidador = findViewById(R.id.btnCuidador);
        btnFamilia = findViewById(R.id.btnFamilia);
        btnCerrarSesion = findViewById(R.id.btnCerrarSesion);

        // Abrir panel cuidador
        btnCuidador.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CuidadorActivity.class);
            startActivity(intent);
        });

        // Abrir panel familia
        btnFamilia.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, FamiliaActivity.class);
            startActivity(intent);
        });

        // Cerrar sesión
        btnCerrarSesion.setOnClickListener(v -> finish());
    }
}