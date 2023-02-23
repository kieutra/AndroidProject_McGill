package com.teaching.foods;

public class Restaurant {
    private String name;
    private String address1;
    private double deliveryFee ;
    String deliveryTime;
    private boolean isFeatured ;
    private int bannerImage ;
    private Double rating ;
    private boolean isVegetarian ;

    public Restaurant(String name, String address1, double deliveryFee, String deliveryTime, int bannerImage, Double rating) {
        this.name = name;
        this.address1 = address1;
        this.deliveryFee = deliveryFee;
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

    public double getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(double deliveryFee) {
        this.deliveryFee = deliveryFee;
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
