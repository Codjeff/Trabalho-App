package com.example.quizmundoverde;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Contato extends AppCompatActivity {

    ImageView imageViewcnt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contato);

        imageViewcnt = findViewById(R.id.voltarcnt);
        imageViewcnt.setOnClickListener(view -> {
            Intent on = new Intent(Contato.this , Home.class);
            startActivity(on);
        });

    }
}