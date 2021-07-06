package com.atkandroid.foodgreen;

public class single_shop_model {
    private String food_name,food_rate,food_price,shop_name;
    private int food_img;

    public single_shop_model() {
    }

    public single_shop_model(String food_name, String food_rate, String food_price, String shop_name, int food_img) {
        this.food_name = food_name;
        this.food_rate = food_rate;
        this.food_price = food_price;
        this.shop_name = shop_name;
        this.food_img = food_img;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public String getFood_rate() {
        return food_rate;
    }

    public void setFood_rate(String food_rate) {
        this.food_rate = food_rate;
    }

    public String getFood_price() {
        return food_price;
    }

    public void setFood_price(String food_price) {
        this.food_price = food_price;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public int getFood_img() {
        return food_img;
    }

    public void setFood_img(int food_img) {
        this.food_img = food_img;
    }

}
