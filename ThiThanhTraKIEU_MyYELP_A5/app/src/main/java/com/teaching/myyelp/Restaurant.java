package com.teaching.myyelp;

import android.widget.ImageView;

public class Restaurant {
    int id;
    String nameofresto;
    float rating;
    String price;//display price in $$
    int price_pos;//price to sort
    String categorytype;
    String phonenumber;
    String address;
    String url;

    public Restaurant(String nameofresto, float rating, String price, String categorytype, String phonenumber, String address, String url) {
        this.nameofresto = nameofresto;
        this.rating = rating;
        this.price = price;
        this.categorytype = categorytype;
        this.phonenumber = phonenumber;
        this.address = address;
        this.url = url;
        if(price == null) price_pos = 0;
        else price_pos = price.length();
    }
    public Restaurant(int id, String nameofresto, float rating, String price, String categorytype, String phonenumber, String address, String url) {
        this.id = id;
        this.nameofresto = nameofresto;
        this.rating = rating;
        this.price = price;
        this.categorytype = categorytype;
        this.phonenumber = phonenumber;
        this.address = address;
        this.url = url;
        if(price == null) price_pos = 0;
        else price_pos = price.length();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getNameofresto() {
        return nameofresto;
    }

    public void setNameofresto(String nameofresto) {
        this.nameofresto = nameofresto;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getCategorytype() {
        return categorytype;
    }

    public void setCategorytype(String categorytype) {
        this.categorytype = categorytype;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
