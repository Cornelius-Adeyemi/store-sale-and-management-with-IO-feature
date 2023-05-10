package com.adebisi.store;

import com.adebisi.store.availabity_enum.Availability;
import com.adebisi.store.category_enum.Category;

public class Product {
    public final String name;
    public final double price;

    public Availability productStatus;

    public Category category;

    public int quanity;

    Product(String name, double price, int quantity, Category category){
        this.name = name;
        this.price = price;
        this.quanity = quantity;
        this.category = category;
        this.productStatus = (quantity> 0)?Availability.IN_STOCK :Availability.OUT_OF_STOCK;

    }

    @Override
    public String toString() {
        return "{ name: " +name +", " + "price: " + price + ", " + "quanity: " + quanity+ " Category: "+ category+" }";
    }
}
