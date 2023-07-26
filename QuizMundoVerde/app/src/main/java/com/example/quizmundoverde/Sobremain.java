package com.example.quizmundoverde;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Sobremain extends AppCompatActivity {

    ImageView voltarsb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobremain);

        voltarsb = findViewById(R.id.element);
        voltarsb.setOnClickListener(view -> {
            Intent an = new Intent(Sobremain.this, Home.class);
            startActivity(an);
        });
    }
}