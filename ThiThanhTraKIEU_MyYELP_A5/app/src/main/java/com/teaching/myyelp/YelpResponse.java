package com.teaching.myyelp;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class YelpResponse {

    @SerializedName("total")
    public int total;

    @SerializedName("businesses")
    public ArrayList<sushi> businesses;

    class sushi {
        @SerializedName("name")
        public String name;

        @SerializedName("rating")
        float rating;

        @SerializedName("price")
        public String price;

        @SerializedName("categories")
        public ArrayList<category> categories;

        @SerializedName("phone")
        String phone;

        @SerializedName("location")
        public address location;

        @SerializedName("image_url")
        public String url;


        class address {
            @SerializedName("address1")
            String address1;

            @SerializedName("city")
            String city;

            @SerializedName("state")
            String state;
        }

        class category {
            @SerializedName("title")
            String title;
        }

    }
}
