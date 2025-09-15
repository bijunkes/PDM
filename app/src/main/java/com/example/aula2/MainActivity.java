package com.example.aula2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button button;

    EditText edPeso, edAltura;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        button=findViewById(R.id.button);
        edPeso=findViewById(R.id.edPeso);
        edAltura=findViewById(R.id.edAltura);

        button.setOnClickListener(v -> {
            Intent intent = new Intent(this, imcResultado.class);
            Bundle bundle = new Bundle();

            double peso = Double.parseDouble(edPeso.getText().toString());
            double altura = Double.parseDouble(edAltura.getTransitionName().toString());

            bundle.putDouble("peso",peso);
            bundle.putDouble("altura",altura);

            intent.putExtras(bundle);
            startActivity(intent);
        });
    }
}