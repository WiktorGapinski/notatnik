package com.example.notatnik;

import android.os.Bundle;
import android.view.View;
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

    private ArrayList<Notatka> listaNotatek;
    private ArrayAdapter<Notatka> adapter;
    private ListView listViewNotatki;
    private EditText editTextTytul;
    private EditText editTextTresc;
    private Button buttonDodaj;

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

        listViewNotatki = findViewById(R.id.listViewNotatki);
        editTextTytul = findViewById(R.id.editTextTytul);
        editTextTresc = findViewById(R.id.editTextTresc);
        buttonDodaj = findViewById(R.id.buttonDodaj);

        listaNotatek = new ArrayList<>();
        listaNotatek.add(new Notatka("tenis", "Gra z Ewą w poniedziałek", false));

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaNotatek);
        listViewNotatki.setAdapter(adapter);

        buttonDodaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tytul = editTextTytul.getText().toString();
                String tresc = editTextTresc.getText().toString();
                Notatka nowaNotatka = new Notatka(tytul, tresc, false);
                listaNotatek.add(nowaNotatka);
                adapter.notifyDataSetChanged();
                editTextTytul.setText("");
                editTextTresc.setText("");
            }
        });
    }
}