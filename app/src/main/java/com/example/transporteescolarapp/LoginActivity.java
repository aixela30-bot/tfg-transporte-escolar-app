package com.example.transporteescolarapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText txtUsuario;
    EditText txtPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtUsuario = findViewById(R.id.etUsuario);
        txtPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(v -> {

            String usuario = txtUsuario.getText().toString();
            String password = txtPassword.getText().toString();

            if (usuario.equals("cuidador") && password.equals("1234")) {

                Intent intent = new Intent(
                        LoginActivity.this,
                        CuidadorActivity.class
                );
                startActivity(intent);

            } else if (usuario.equals("familia") && password.equals("1234")) {

                Intent intent = new Intent(
                        LoginActivity.this,
                        FamiliaActivity.class
                );
                startActivity(intent);

            } else {

                Toast.makeText(
                        this,
                        "Usuario o contraseña incorrectos",
                        Toast.LENGTH_SHORT
                ).show();
            }
        });
    }
}