package com.example.aula2;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ExibeItem extends AppCompatActivity {
    TextView t;
    TextView txt;
    Button b;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.exibe_item);

        t = findViewById(R.id.titulo);
        b = findViewById(R.id.voltar);
        txt = findViewById(R.id.texto);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String titulo = getIntent().getStringExtra("titulo");
        t.setText(titulo);


        String texto = getIntent().getStringExtra("texto");
        txt.setText(texto);

        b.setOnClickListener(v -> {
            finish();
        });
    }
}