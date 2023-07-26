package com.example.quizmundoverde;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Descricao extends AppCompatActivity {

    Button Continuarfase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descricao);

        Continuarfase = findViewById(R.id.voltardesc);
        Continuarfase.setOnClickListener(view -> {
            Intent in = new Intent(Descricao.this, MainActivity.class);
            startActivity(in);
        });
    }
}