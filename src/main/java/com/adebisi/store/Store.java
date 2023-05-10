package com.adebisi.store;

import com.adebisi.staff.Cashier;
import com.adebisi.staff.Manager;
import com.adebisi.store.category_enum.Category;

import java.util.ArrayList;
import java.util.HashMap;

public class Store {

     public double income;
     public  ArrayList<Product> productList = new ArrayList<>();



      public Manager currentManager;

     public  HashMap<String, Cashier> cashierList = new HashMap<>();

     public Store(double income, Manager currentManager ){
         this.income = income;

         this.currentManager = currentManager;
     }




    public Cashier getCashier(String cashierId){
         if(cashierList.containsKey(cashierId)){
            return  cashierList.get(cashierId);
         }else{
             System.out.println("wrong cashier details or cashier doesnt work here");
             return null;
         }

    }

    public void addproduct(String name, double price, int quantity, Category category){
        Product n = null;
        n = new Product(name, price, quantity, category );
        productList.add(n);

    }



}









