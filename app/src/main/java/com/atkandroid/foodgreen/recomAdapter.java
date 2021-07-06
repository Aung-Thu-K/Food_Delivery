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

public class recomAdapter extends RecyclerView.Adapter<recomAdapter.myViewHolder>{

    ArrayList<model> item = new ArrayList<>();
    Context context;

    public recomAdapter(ArrayList<model> item, Context context) {
        this.item = item;
        this.context = context;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recommended_style,parent,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        final model model = item.get(position);
        holder.re_img.setImageResource(model.getImg());
        holder.re_name.setText(model.getName());
        holder.re_rate.setText(model.getRate());
        holder.re_price.setText(model.getPrice());
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
        TextView re_name,re_rate,re_price;
        ImageView re_img;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            re_img = itemView.findViewById(R.id.re_img);
            re_name = itemView.findViewById(R.id.re_name);
            re_rate = itemView.findViewById(R.id.re_rate);
            re_price = itemView.findViewById(R.id.re_price);
        }
    }

}
