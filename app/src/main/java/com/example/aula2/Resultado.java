package com.example.aula2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Resultado extends AppCompatActivity {
    TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_resultado);

        tvResultado = findViewById(R.id.tvNumero);

        Intent i = getIntent();
        Bundle b = i.getExtras();

        double numero = b.getDouble("numero");

        tvResultado.setText("1 x " + numero + " = " + numero * 1 + "\n2 x " + numero + " = " + numero * 2 + "\n3 x " + numero + " = " + numero * 3 + "\n4 x " + numero + " = " + numero * 4 + "\n5 x " + numero + " = " + numero * 5 + "\n6 x " + numero + " = " + numero * 6 + "\n7 x " + numero + " = " + numero * 7 + "\n8 x " + numero + " = " + numero * 8 + "\n9 x " + numero + " = " + numero * 9 + "\n10 x " + numero + " = " + numero * 10);
    }
}
