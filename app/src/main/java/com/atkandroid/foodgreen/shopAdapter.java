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

public class shopAdapter extends RecyclerView.Adapter<shopAdapter.myViewHolder> {
    Context context;
    ArrayList<shopModel> item = new ArrayList<>();

    public shopAdapter(Context context, ArrayList<shopModel> item) {
        this.context = context;
        this.item = item;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shop_style,parent,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        final shopModel model = item.get(position);
        holder.shop_img.setImageResource(model.getShop_img());
        holder.shop_name.setText(model.getShop_name());
        holder.shop_long.setText(model.getShop_long());
        holder.shop_rate.setText(model.getShop_rate());
        holder.shop_open_time.setText(model.getShop_open_time());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String shop_name = model.getShop_name();
                String shop_rate = model.getShop_rate();
                int shop_img = model.getShop_img();
                Intent i = new Intent(context,single_shop_style.class);
                Bundle bundle = new Bundle();
                bundle.putString("shop_name",shop_name);
                bundle.putString("shop_rate",shop_rate);
                bundle.putString("shop_img", String.valueOf(shop_img));
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

    public class myViewHolder extends RecyclerView.ViewHolder{
        ImageView shop_img;
        TextView shop_name,shop_rate,shop_open_time,shop_long;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            shop_img = itemView.findViewById(R.id.shop_img);
            shop_long = itemView.findViewById(R.id.shop_long);
            shop_name = itemView.findViewById(R.id.shop_name);
            shop_rate = itemView.findViewById(R.id.shop_rate);
            shop_open_time = itemView.findViewById(R.id.shop_open_time);
        }
    }
}
