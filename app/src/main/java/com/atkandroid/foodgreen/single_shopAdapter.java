package com.atkandroid.foodgreen;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import maes.tech.intentanim.CustomIntent;

public class single_shopAdapter extends RecyclerView.Adapter<single_shopAdapter.myHolder> {
    ArrayList<single_shop_model> item = new ArrayList<>();
    Context context;

    public single_shopAdapter(ArrayList<single_shop_model> item, Context context) {
        this.item = item;
        this.context = context;
    }

    @NonNull
    @Override
    public myHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_shop_card,parent,false);
        return new myHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final myHolder holder, int position) {
        final single_shop_model shop_model =item.get(position);
        holder.food_name.setText(shop_model.getFood_name());
        holder.food_price.setText(shop_model.getFood_price());
        holder.food_img.setImageResource(shop_model.getFood_img());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String s_food_name = shop_model.getFood_name();
                final String s_food_rate = shop_model.getFood_rate();
                final String s_food_price = shop_model.getFood_price();
                final String s_shop_name = shop_model.getShop_name();
                final int s_food_img = shop_model.getFood_img();
                Intent i = new Intent(context,SingleFood.class);
                Bundle bundle = new Bundle();
                bundle.putString("food_name",s_food_name);
                bundle.putString("food_price",s_food_price);
                bundle.putString("food_rate",s_food_rate);
                bundle.putString("shop_name",s_shop_name);
                bundle.putString("food_img", String.valueOf(s_food_img));
                i.putExtras(bundle);
                context.startActivity(i);
                CustomIntent.customType(context,"bottom-to-up");
            }
        });
    }

    @Override
    public int getItemCount() {
        return item.size();
    }

    public class myHolder extends RecyclerView.ViewHolder {
        ImageView food_img;
        TextView food_name,food_price;
        public myHolder(@NonNull View itemView) {
            super(itemView);
            food_img = itemView.findViewById(R.id.shop_food_img);
            food_name = itemView.findViewById(R.id.shop_food_name);
            food_price = itemView.findViewById(R.id.shop_food_price);
        }
    }

}
