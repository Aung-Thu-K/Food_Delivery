package com.atkandroid.foodgreen;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import maes.tech.intentanim.CustomIntent;

public class myAdapter extends RecyclerView.Adapter<myAdapter.myViewHolder>{

    ArrayList<model> item = new ArrayList<>();
    Context context;

    public myAdapter(ArrayList<model> item, Context context) {
        this.item = item;
        this.context = context;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.popular_style,parent,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final myViewHolder holder, int position) {
        final model model = item.get(position);
        holder.food_img.setImageResource(model.getImg());
        holder.food_name.setText(model.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String s_food_name = model.getName();
                final String s_food_rate = model.getRate();
                final String s_food_price = model.getPrice();
                final String s_shop_name = model.getRest_name();
                final int s_food_img = model.getImg();
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


    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView food_name;
        ImageView food_img;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            food_img = itemView.findViewById(R.id.shop_food_img);
            food_name = itemView.findViewById(R.id.food_name);
        }
    }
}
