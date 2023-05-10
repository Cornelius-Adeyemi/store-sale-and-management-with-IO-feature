package com.adebisi.staff;

import com.adebisi.customer.Customer;
import com.adebisi.store.Store;

public class Cashier extends StoreStaff {


    //private static HashMap<String, Cashier> list = new HashMap<>();
     public Cashier(String name, String id, String position) {
        super(name, id, position);
    }

  public void sell( Customer c, Store store){
         if(store.cashierList.containsKey(id)) {
             if (c.buyChecker) {
                 System.out.println("********* RECEIPT **********");
                 System.out.println("Receipt issued by: " + name);
                 System.out.println("Receipt issued to: " + c.name);
                 c.displayCartDetails();
                 c.buyChecker = false;
                 c.totalCost =0;
                 c.cart.removeAll(c.cart);

             } else {
                 System.out.println("Please pick the product you want to get");
             }
         }else{
             System.out.println("This cashier no longer works for the store");
         }

  }








}
