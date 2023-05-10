package com.adebisi.customer;

import com.adebisi.store.Product;
import com.adebisi.store.Store;
import com.adebisi.store.availabity_enum.Availability;

import java.util.ArrayList;

public class Customer {
   public String name;
   public int moneyOwned;

   public int totalCost=0;

   public boolean buyChecker =false;

   public ArrayList<PurchaseProduct> cart = new ArrayList<>();


   public Customer(String name, int moneyOwned){
       this.name = name;
       this.moneyOwned = moneyOwned;
   }





   public void buy(Store store , int productNumber, int quantity ){

       ArrayList<Product> productList = store.productList;
       Product purchaseProductDetails = productList.get((productNumber-1));

       double price= purchaseProductDetails.price;
       double total = price * quantity;
       if(!(purchaseProductDetails.productStatus == Availability.OUT_OF_STOCK)) {
           PurchaseProduct r = null;
           if (total <= moneyOwned && purchaseProductDetails.quanity >= quantity) {
               buyChecker = true;
               totalCost += total;
               moneyOwned -= total;
               store.income += total;

               purchaseProductDetails.quanity -= quantity;
               purchaseProductDetails.productStatus = (purchaseProductDetails.quanity ==0)? Availability.OUT_OF_STOCK :Availability.IN_STOCK;
               r = new PurchaseProduct(purchaseProductDetails.name, quantity, (int) total, (int) price);
               cart.add(r);

           } else {

               if (total >= moneyOwned) {
                   System.out.println("You don't have enough money to carry out this transaction");
               } else {
                   System.out.println("We only have " + purchaseProductDetails.quanity + " quanty of" + purchaseProductDetails.name);
               }
           }
       }else{
           System.out.println(purchaseProductDetails.name+" is out of stock");
       }


   }


    @Override
    public String toString() {
        return "{ Name: " +name +", " + "Balance: " + moneyOwned +  " }";
    }

    public void displayCartDetails(){
       for(PurchaseProduct x: cart){
           System.out.println(x);
       }
       System.out.println("  ");
        System.out.println("Total cost         \s \t\t\t\t\t\t\s\s\s\s$" + totalCost);
        System.out.println("Customer Change    \s \t\t\t\t\t\t\s\s\s\s$" + moneyOwned);
    }


    private class PurchaseProduct{
        public String productName;
        public int quantitPurchase;
        public int unitPrice;

        public int totalPrice;

        PurchaseProduct(String productName,int quantitPurchase, int totalCost, int unitPrice){
            this.productName = productName;
            this.quantitPurchase = quantitPurchase;
            this.totalPrice = totalCost;
            this.unitPrice = unitPrice;
        }

        @Override
        public String toString() {
            return productName + "\t\t\t" + "$"+ unitPrice +"/one" + "\t\t\t" + quantitPurchase+"qty" +"\t\t\t"+ "$"+totalPrice;
        }
    }
}
