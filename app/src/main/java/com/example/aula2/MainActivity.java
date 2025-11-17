package com.example.aula2;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase db;
    Button b;
    ListView l;
    EditText e;
    EditText txt;

    @SuppressLint("Range")
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

        b = findViewById(R.id.button);
        e = findViewById(R.id.editText);
        l = findViewById(R.id.listView);
        txt = findViewById(R.id.editText2);

        db = openOrCreateDatabase("app_database", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS notas (id INTEGER PRIMARY KEY AUTOINCREMENT, titulo VARCHAR, texto TEXT)");

        carregarListagem();

        b.setOnClickListener(v -> {
            String titulo = e.getText().toString();
            String texto = txt.getText().toString();

            ContentValues cv = new ContentValues();
            cv.put("titulo", titulo);
            cv.put("texto", texto);

            db.insert("notas", null, cv);

            carregarListagem();
        });

        l.setOnItemClickListener((parent, view, position, id) -> {
            String titulo = (String) parent.getItemAtPosition(position);
            Cursor cursor = db.rawQuery("SELECT texto FROM notas WHERE titulo = ?", new String[]{titulo});

            String texto = "";
            if (cursor.moveToFirst()) {
                // Recuperando o texto da nota
                texto = cursor.getString(cursor.getColumnIndex("texto"));
            }
            cursor.close();
            Intent intent = new Intent(MainActivity.this, ExibeItem.class);
            intent.putExtra("titulo", titulo);
            intent.putExtra("texto", texto);
            startActivity(intent);
        });
    }

    public void carregarListagem() {
        ArrayList<String> titulos = new ArrayList<String>();
        Cursor cursor = db.rawQuery("SELECT * FROM notas", null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            @SuppressLint("Range") String titulo = cursor.getString(cursor.getColumnIndex("titulo"));
            titulos.add(titulo);
            cursor.moveToNext();
        }

        ArrayAdapter<String> titulosAdapter = new ArrayAdapter<>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                titulos
        );
        l.setAdapter(titulosAdapter);
    }

}