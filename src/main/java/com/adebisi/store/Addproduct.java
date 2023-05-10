package com.adebisi.store;

import com.adebisi.store.category_enum.Category;

public class Addproduct{

    public static void addproduct(String name, double price, int quantity, Category category, Store store){
        Product n = null;
        n = new Product(name, price, quantity, category );
        store.productList.add(n);

    }
}