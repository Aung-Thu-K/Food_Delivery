package com.atkandroid.foodgreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import maes.tech.intentanim.CustomIntent;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class single_shop_style extends AppCompatActivity {

    ImageView shop_image;
    TextView shop_rate,shop_name;
    ImageView btnBack;
    RecyclerView shop_trad_rv,asian_rv,shop_popular_rv;
    single_shopAdapter tradAdapter,asianAdapter,popularAdapter;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_shop_style);
        shop_image = findViewById(R.id.shop_Image);
        shop_rate = findViewById(R.id.shop_rate);
        shop_name = findViewById(R.id.shop_Name);
        btnBack = findViewById(R.id.btn_shop_back);
        shop_trad_rv = findViewById(R.id.shop_trad_rv);
        asian_rv = findViewById(R.id.asian_rv);
        shop_popular_rv = findViewById(R.id.shop_popular_rv);

        Bundle bundle1 = getIntent().getExtras();
        shop_name.setText(bundle1.getString("shop_name"));
        shop_rate.setText(bundle1.getString("shop_rate"));
        shop_image.setImageResource(Integer.parseInt(bundle1.getString("shop_img")));

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(single_shop_style.this,Home.class);
                startActivity(i);
                CustomIntent.customType(single_shop_style.this,"up-to-bottom");
            }
        });

        ArrayList<single_shop_model> item = new ArrayList<>();
        item.add(new single_shop_model("Beef Corned","3.5","5500","CN Nine",R.drawable.b1));
        item.add(new single_shop_model("Chicken Marvel","4.5","4500","CN Nine",R.drawable.c1));
        item.add(new single_shop_model("Pizza Cheef","3.2","6500","CN Nine",R.drawable.pizza1));
        item.add(new single_shop_model("Rice Beef","4.1","2500","CN Nine",R.drawable.rice1));
        item.add(new single_shop_model("Yum Yum","3.8","1500","CN Nine",R.drawable.yum4));
        item.add(new single_shop_model("Drink Golden","4.2","1500","CN Nine",R.drawable.d8));
        tradAdapter = new single_shopAdapter(item,single_shop_style.this);
        shop_trad_rv.setLayoutManager(new LinearLayoutManager(single_shop_style.this,LinearLayoutManager.VERTICAL,false));
        shop_trad_rv.setAdapter(tradAdapter);


        ArrayList<single_shop_model> asian = new ArrayList<>();
        asian.add(new single_shop_model("Beef Marvel","4.5","5500","CN Nine",R.drawable.b4));
        asian.add(new single_shop_model("Chicken Corned","3.3","3500","MC Teen",R.drawable.c5));
        asian.add(new single_shop_model("Chicken World","4.8","4500","Star Mobile",R.drawable.c2));
        asian.add(new single_shop_model("Rice Chicken","2.2","3500","Mobile World",R.drawable.rice4));
        asian.add(new single_shop_model("Yum Yum","3.7","2500","CN Nine",R.drawable.yum2));
        asian.add(new single_shop_model("Drink Burble Tea","4.3","1500","Min Thar Gyi",R.drawable.d9));
        asianAdapter = new single_shopAdapter(asian,single_shop_style.this);
        asian_rv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        asian_rv.setAdapter(asianAdapter);


        ArrayList<single_shop_model> popular = new ArrayList<>();
        popular.add(new single_shop_model("Beef Cooled","3.9","5500","Mobile Star",R.drawable.b3));
        popular.add(new single_shop_model("Chicken Black","4.0","3500","Min Thar Gyi",R.drawable.c4));
        popular.add(new single_shop_model("Chicken","2.9","3500","Star Mobile",R.drawable.c3));
        popular.add(new single_shop_model("Rice Air","2.2","3000","Mobile World",R.drawable.rice2));
        popular.add(new single_shop_model("Yum Yum Master","2.7","2500","Master Check",R.drawable.yum3));
        popular.add(new single_shop_model("Drink Golden Tea","3.6","1500","Min Thar Gyi",R.drawable.d6));
        popularAdapter = new single_shopAdapter(popular,single_shop_style.this);
        shop_popular_rv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        shop_popular_rv.setAdapter(popularAdapter);
    }
}