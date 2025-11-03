package com.example.aula2;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase db;
    Button b;
    ListView l;
    EditText e;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        db = openOrCreateDatabase("app_database", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS notas (id INTEGER PRIMARY KEY AUTOINCREMENT, titulo VARCHAR, texto TEXT)");
        ContentValues values = new ContentValues();
        values.put("titulo", "Nota de Exemplo");
        values.put("texto", "Esse é o texto da nota de exemplo");
        db.insert("notas", null, values);

        b = findViewById(R.id.button);
        b.setOnClickListener(v -> {
            e = findViewById(R.id.editText);
            String texto = e.getText().toString();
            ContentValues cv = new ContentValues();
            cv.put("titulo", "Nota do Usuário");
            cv.put("texto", texto);
            db.insert("notas", null, cv);
            Toast.makeText("Nota salva com sucesso", Toast.LENGTH_SHORT).show();
        });
    }
}