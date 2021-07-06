package com.atkandroid.foodgreen;

import androidx.appcompat.app.AppCompatActivity;
import maes.tech.intentanim.CustomIntent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class success extends AppCompatActivity {
    Button btnFinal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);
        btnFinal = findViewById(R.id.btn_final);
        btnFinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(success.this,Home.class);
                startActivity(intent);
                CustomIntent.customType(success.this,"up-to-bottom");
            }
        });
    }
}