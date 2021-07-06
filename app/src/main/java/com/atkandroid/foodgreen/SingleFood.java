package com.atkandroid.foodgreen;

import androidx.appcompat.app.AppCompatActivity;
import maes.tech.intentanim.CustomIntent;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SingleFood extends AppCompatActivity {

    ImageView single_food_img,btn_back;
    TextView single_food_name,single_food_rate,single_shop_name,single_food_price;
    Button btn_order_card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_food);
        single_food_img = findViewById(R.id.shop_food_img);
        single_food_name = findViewById(R.id.single_food_name);
        single_food_price = findViewById(R.id.single_food_price);
        single_food_rate = findViewById(R.id.single_food_rate);
        single_shop_name = findViewById(R.id.single_shop_name);
        btn_back = findViewById(R.id.back_btn);
        btn_order_card = findViewById(R.id.btn_order_cart);

        Bundle bundle2 =getIntent().getExtras();
        single_food_name.setText(bundle2.getString("food_name"));
        single_food_price.setText(bundle2.getString("food_price"));
        single_food_rate.setText(bundle2.getString("food_rate"));
        single_shop_name.setText(bundle2.getString("shop_name"));
        single_food_img.setImageResource(Integer.parseInt(bundle2.getString("food_img")));

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ii = new Intent(SingleFood.this,Home.class);
                startActivity(ii);
                CustomIntent.customType(SingleFood.this,"up-to-bottom");
            }
        });

        btn_order_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(SingleFood.this);
                dialog.setContentView(R.layout.mydialog);
                //dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.GREEN));
                TextView btn_yes = dialog.findViewById(R.id.btn_yes);
                TextView btn_no = dialog.findViewById(R.id.btn_no);

                btn_yes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                        Intent yes = new Intent(SingleFood.this,userData.class);
                        startActivity(yes);
                        CustomIntent.customType(SingleFood.this,"left-to-right");
                    }
                });
                btn_no.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                        Toast.makeText(SingleFood.this,"OK, Thanks!",Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();
            }
        });

    }
}