package com.teaching.foods;

public class Restaurant {
    private String name;
    private String address1;
    private int minPrice ;
    String deliveryTime;
    private boolean isFeatured ;
    private int bannerImage ;
    private Double rating ;
    private boolean isVegetarian ;

    public Restaurant(String name, String address1, int minPrice, String deliveryTime, int bannerImage, Double rating) {
        this.name = name;
        this.address1 = address1;
        this.minPrice = minPrice;
        this.deliveryTime = deliveryTime;
        this.bannerImage = bannerImage;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public int getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(int minPrice) {
        this.minPrice = minPrice;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public boolean isFeatured() {
        return isFeatured;
    }

    public void setFeatured(boolean featured) {
        isFeatured = featured;
    }

    public int getBannerImage() {
        return bannerImage;
    }

    public void setBannerImage(int bannerImage) {
        this.bannerImage = bannerImage;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public boolean isVegetarian() {
        return isVegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        isVegetarian = vegetarian;
    }
}
