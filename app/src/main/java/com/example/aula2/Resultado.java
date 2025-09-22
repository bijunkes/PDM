package com.example.aula2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Resultado extends AppCompatActivity {
    TextView tv, tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.resultado);

        tv = findViewById(R.id.tv);
        tvResultado = findViewById(R.id.tvResultado);

        Intent i = getIntent();
        Bundle b = i.getExtras();

        double numero = b.getDouble("numero");

        tvResultado.setText(numero + " x 1: " + numero * 1 + numero + " x 2: " + numero * 2 + numero + " x 3: " + numero * 3);
    }
}