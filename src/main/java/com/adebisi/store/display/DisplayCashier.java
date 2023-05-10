package com.adebisi.store.display;

import com.adebisi.staff.Cashier;
import com.adebisi.store.Store;

public class DisplayCashier {

   public static void display(Store store){
       int number = 1;
       for(Cashier x: store.cashierList.values()){

           System.out.println(number + " " + x);
           System.out.println(" ");
           number++;
       }
   }
}
