package com.atkandroid.foodgreen;

import androidx.appcompat.app.AppCompatActivity;
import de.hdodenhof.circleimageview.CircleImageView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class myAccount extends AppCompatActivity {

    private CircleImageView myAccountProfile;
    private TextView myAccountName;
    private String url;
    private Button btnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);

        myAccountProfile = findViewById(R.id.myAccountProfile);
        myAccountName = findViewById(R.id.myAccountName);
        btnHome = findViewById(R.id.btnHome);

        url = getIntent().getStringExtra("MyPhoto");
        Glide.with(this).load(url).into(myAccountProfile);
        myAccountName.setText(getIntent().getStringExtra("Name"));

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(myAccount.this,Home.class);
                startActivity(i);
            }
        });

    }
}