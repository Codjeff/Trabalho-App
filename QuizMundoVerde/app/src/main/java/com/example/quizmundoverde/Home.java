package com.example.quizmundoverde;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Home extends AppCompatActivity {

    ImageView imageViewSobre;
    TextView textViewContato;

    Button Questionary;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        imageViewSobre = findViewById(R.id.Sobre);

        imageViewSobre.setOnClickListener(view -> {
            Intent in = new Intent(Home.this, Sobremain.class);
            startActivity(in);
        });

        textViewContato = findViewById(R.id.contato);
        textViewContato.setOnClickListener(view -> {
            Intent en = new Intent(Home.this, Contato.class);
            startActivity(en);
        });

        Questionary = findViewById(R.id.Questionary1);
        Questionary.setOnClickListener(view -> {
            Intent un = new Intent(Home.this, Descricao.class);
            startActivity(un);
        });
    }
}