package com.atkandroid.foodgreen;

import android.widget.ImageView;

public class shopModel {
    private int shop_img;
    private String shop_name,shop_rate,shop_long,shop_open_time;

    public shopModel() {
    }

    public shopModel(int shop_img, String shop_name, String shop_rate, String shop_long, String shop_open_time) {
        this.shop_img = shop_img;
        this.shop_name = shop_name;
        this.shop_rate = shop_rate;
        this.shop_long = shop_long;
        this.shop_open_time = shop_open_time;
    }

    public int getShop_img() {
        return shop_img;
    }

    public void setShop_img(int shop_img) {
        this.shop_img = shop_img;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public String getShop_rate() {
        return shop_rate;
    }

    public void setShop_rate(String shop_rate) {
        this.shop_rate = shop_rate;
    }

    public String getShop_long() {
        return shop_long;
    }

    public void setShop_long(String shop_long) {
        this.shop_long = shop_long;
    }

    public String getShop_open_time() {
        return shop_open_time;
    }

    public void setShop_open_time(String shop_open_time) {
        this.shop_open_time = shop_open_time;
    }
}
