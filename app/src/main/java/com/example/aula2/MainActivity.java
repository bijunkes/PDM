package com.example.aula2;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listNome;
    EditText textNome;
    Button buttonSalvar;
    ArrayList<String> nomes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        listNome = findViewById(R.id.listNome);
        textNome = findViewById(R.id.textNome);
        buttonSalvar = findViewById(R.id.buttonSalvar);
        nomes= new ArrayList<>();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nomes);
        listNome.setAdapter(adapter);

        buttonSalvar.setOnClickListener(e -> {
            String nome = textNome.getText().toString();
            if (!nome.isEmpty()){
                nomes.add(nome);
                adapter.notifyDataSetChanged();
            }
        });

        listNome.setOnItemLongClickListener((parent, view, position, id) -> {
            nomes.remove(position);
            adapter.notifyDataSetChanged();
            return true;
        });

    }

}