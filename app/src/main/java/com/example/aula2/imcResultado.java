package com.example.aula2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class imcResultado extends AppCompatActivity {

    Button button;
    TextView textResultado, textPeso, textAltura, textTipo;
    ImageView imageViewTipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_resultado);

        textResultado = findViewById(R.id.textResultado);
        textPeso = findViewById(R.id.textResultadoPeso);
        textAltura = findViewById(R.id.textResultadoAltura);
        textTipo = findViewById(R.id.textTipo);
        imageViewTipo =findViewById(R.id.imageViewTipo);

        Intent i = getIntent();
        Bundle b = i.getExtras();

        double peso = b.getDouble("peso");
        double altura = b.getDouble("altura");

        double imc = peso/(altura*altura);

        textPeso.setText("Peso: " + String.format("%.2f", peso) + " Kg");
        textAltura.setText("Altura: " + String.format("%.2f", altura) + " m");
        String resultado = "IMC: " + String.format("%.2f", imc);
        textResultado.setText(resultado);

        if(imc < 18.5){
            imageViewTipo.setImageDrawable(getDrawable(R.drawable.abaixopeso));
            textTipo.setText("Abaixo do peso");
        }
        else if(imc >= 18.5 && imc <= 24.9){
            imageViewTipo.setImageDrawable(getDrawable(R.drawable.normal));
            textTipo.setText("Normal");
        }
        else if(imc >= 25 && imc <= 29.9){
            imageViewTipo.setImageDrawable(getDrawable(R.drawable.sobrepeso));
            textTipo.setText("Sobrepeso");
        }
        else if(imc >= 30 && imc <= 34.9){
            imageViewTipo.setImageDrawable(getDrawable(R.drawable.obesidade1));
            textTipo.setText("Obesidade 1");
        }
        else if(imc >= 35 && imc <= 39.9){
            imageViewTipo.setImageDrawable(getDrawable(R.drawable.obesidade2));
            textTipo.setText("Obesidade 2");
        }
        else if(imc >= 40){
            imageViewTipo.setImageDrawable(getDrawable(R.drawable.obesidade3));
            textTipo.setText("Obesidade 3");
        }
    }
}