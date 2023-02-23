package com.teaching.myrestaurant;

public class CartList {
    private String foodName;
    private String quantity;
    private String price;
    private String total3;

    public CartList(String foodName, String quantity, String price, String total3) {
        this.foodName = foodName;
        this.quantity = quantity;
        this.price = price;
        this.total3 = total3;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTotal3() {
        return total3;
    }

    public void setTotal3(String total3) {
        this.total3 = total3;
    }
}
