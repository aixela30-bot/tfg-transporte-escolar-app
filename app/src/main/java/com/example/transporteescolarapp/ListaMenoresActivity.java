package com.example.transporteescolarapp;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ListaMenoresActivity extends AppCompatActivity {

    private LinearLayout listaContainer;
    private TextView txtResumen;
    private TextView txtAlerta;

    private int menoresPendientes = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_menores);

        listaContainer = findViewById(R.id.listaContainer);
        txtResumen = findViewById(R.id.txtResumen);
        txtAlerta = findViewById(R.id.txtAlerta);

        Button btnVolver = findViewById(R.id.btnVolver);
        Button btnFinalizarRuta = findViewById(R.id.btnFinalizarRuta);

        actualizarResumen();

        agregarMenor("Jon", "🟢 Subido", "Sin incidencias");
        agregarMenor("Ane", "🔴 No asiste", "La familia ha avisado");
        agregarMenor("Markel", "🟢 Subido", "Sin incidencias");
        agregarMenor("Irati", "🟡 Pendiente", "Esperando en parada");

        btnFinalizarRuta.setOnClickListener(v -> {

            if (menoresPendientes > 0) {

                txtAlerta.setText(
                        "⚠ Atención: todavía quedan menores pendientes"
                );

                txtAlerta.setBackgroundColor(
                        Color.parseColor("#E53935")
                );

                Toast.makeText(
                        this,
                        "No se puede finalizar la ruta",
                        Toast.LENGTH_LONG
                ).show();

            } else {

                txtAlerta.setText(
                        "✔ Ruta finalizada correctamente"
                );

                txtAlerta.setBackgroundColor(
                        Color.parseColor("#43A047")
                );

                DatosApp.historialRutas.add(
                        new Ruta(
                                "29/05/2026",
                                "Finalizada",
                                DatosApp.incidencias.size()
                        )
                );

                Toast.makeText(
                        this,
                        "Todos los menores han bajado",
                        Toast.LENGTH_LONG
                ).show();
            }
        });

        btnVolver.setOnClickListener(v -> finish());
    }

    private void actualizarResumen() {

        txtResumen.setText(
                "4 menores registrados\n" +
                        "2 subidos · 1 ausencia · 1 pendiente"
        );
    }

    private void agregarMenor(
            String nombre,
            String estado,
            String comentario
    ) {

        LinearLayout tarjeta = new LinearLayout(this);

        tarjeta.setOrientation(LinearLayout.VERTICAL);
        tarjeta.setPadding(30, 30, 30, 30);
        tarjeta.setBackgroundColor(Color.WHITE);
        tarjeta.setElevation(8);

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

        params.setMargins(0, 0, 0, 28);

        tarjeta.setLayoutParams(params);

        TextView txtNombre = new TextView(this);

        txtNombre.setText(nombre);
        txtNombre.setTextSize(26);
        txtNombre.setTypeface(null, Typeface.BOLD);
        txtNombre.setTextColor(Color.parseColor("#0D47A1"));

        TextView txtEstado = new TextView(this);

        txtEstado.setText(estado);
        txtEstado.setTextSize(21);

        TextView txtComentario = new TextView(this);

        txtComentario.setText(
                "Observación: " + comentario
        );

        txtComentario.setTextSize(17);
        txtComentario.setTextColor(Color.DKGRAY);

        LinearLayout filaBotones = new LinearLayout(this);

        filaBotones.setOrientation(LinearLayout.HORIZONTAL);
        filaBotones.setGravity(Gravity.CENTER);
        filaBotones.setPadding(0, 22, 0, 0);

        Button btnBaja = crearBoton(
                "Baja",
                "#1E88E5"
        );

        btnBaja.setOnClickListener(v -> {

            txtEstado.setText("🔵 Bajado");

            txtComentario.setText(
                    "Observación: menor registrado como bajado"
            );

            menoresPendientes = 0;

            txtResumen.setText(
                    "4 menores registrados\n" +
                            "3 bajados · 1 ausencia"
            );

            Toast.makeText(
                    this,
                    nombre + " ha bajado",
                    Toast.LENGTH_SHORT
            ).show();
        });

        Button btnIncidencia = crearBoton(
                "Incidencia",
                "#E53935"
        );

        btnIncidencia.setOnClickListener(v -> {

            txtEstado.setText("🔴 Incidencia");

            txtComentario.setText(
                    "Observación: incidencia registrada por cuidador"
            );

            DatosApp.incidencias.add(
                    new Incidencia(
                            nombre,
                            "Incidencia registrada por cuidador"
                    )
            );

            Toast.makeText(
                    this,
                    "Incidencia registrada para " + nombre,
                    Toast.LENGTH_SHORT
            ).show();
        });

        filaBotones.addView(btnBaja);
        filaBotones.addView(btnIncidencia);

        tarjeta.addView(txtNombre);
        tarjeta.addView(txtEstado);
        tarjeta.addView(txtComentario);
        tarjeta.addView(filaBotones);

        listaContainer.addView(tarjeta);
    }

    private Button crearBoton(
            String texto,
            String color
    ) {

        Button boton = new Button(this);

        boton.setText(texto);
        boton.setTextColor(Color.WHITE);
        boton.setBackgroundColor(
                Color.parseColor(color)
        );

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        0,
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        1
                );

        params.setMargins(4, 0, 4, 0);

        boton.setLayoutParams(params);

        return boton;
    }
}