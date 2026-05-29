package com.example.transporteescolarapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ParadasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paradas);

        TextView txtParadas =
                findViewById(R.id.txtParadas);

        String texto = "";

        for (Parada parada : DatosApp.paradas) {

            texto += parada.getHora()
                    + " - "
                    + parada.getNombre()
                    + "\n";
        }

        txtParadas.setText(texto);
    }
}