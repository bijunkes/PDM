package com.example.aula2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class imcResultado extends AppCompatActivity {

    Button b;
    TextView tvResultado;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.imcresultado);

        tvResultado=findViewById(R.id.tvResultado);
        imageView=findViewById(R.id.imageView);

        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        double peso = b.getDouble("peso");
        double altura = b.getDouble("altura");

        double imc = peso/(altura*altura);

        tvResultado.setText(Double.toString(imc));
        imageView.setImageResource(R.drawable.perfil);

        if(imc<18.9){imageView.setImageResource(R.drawable.abaixopeso)};
        if(imc=18.9 && imc<25){imageView.setImageResource(R.drawable.normal)};
        if(imc>=25 && imc <30){imageView.setImageResource(R.drawable.obesidade1)};
        if(imc>=30 && imc <35){imageView.setImageResource(R.drawable.obesidade2)};
    }
}