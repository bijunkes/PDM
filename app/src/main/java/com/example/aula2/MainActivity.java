package com.example.aula2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView tvTabuada;
    EditText tvNumero;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        tvTabuada = findViewById(R.id.tvTabuada);
        tvNumero = findViewById(R.id.tvNumero);
        button = findViewById(R.id.button);

        button.setOnClickListener(v -> {
            Intent i = new Intent(this, Resultado.class);
            Bundle b = new Bundle();
            double numero = Double.parseDouble(tvNumero.getText().toString());
            b.putDouble("numero", numero);
            i.putExtras(b);
            startActivity(i);
        });
    }
}