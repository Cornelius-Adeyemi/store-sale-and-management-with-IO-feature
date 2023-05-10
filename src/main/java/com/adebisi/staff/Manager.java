package com.adebisi.staff;

import com.adebisi.store.Store;

public class Manager extends StoreStaff {

    private static Manager myManager = null;
    private static int num =1;

    private Manager(String name, String id, String position) {
        super(name, id, position);
    }

    public static String employManager(String name){
        if(myManager ==null){
          String id= "manager111";
          String title = "Manager";

          myManager= new Manager(name, id,title);
          return "A new manager has been employed to manage the store. The manager id is "+id;
        }else {

            return "The store already has a manger";
        }

    }


    public static Manager getCurretManager(){
        if(myManager ==null){
            System.out.println( "The store has no manager at the moment");
           return null;
        }else{
            return myManager;
        }
    }

    public  String sackCashier(Store store, String cashierId){
        if(store.cashierList.containsKey(cashierId)){
            String name = store.cashierList.get(cashierId).name;
            store.cashierList.remove(cashierId);

            return " you've successfully sacked "+name+ " from the store";
        }else{
            return "Their is no cashier with such id";
        }
    }

    public Cashier hireCashier(Store store, String name){
        Cashier r = null;
        if(store.cashierList.size()<6){
            String id = "cashier0" + num;
            r = new Cashier(name,id, "Cashier");
            store.cashierList.put(id,r);
            num++;
            System.out.println("The cashier id for " + r.name+ " is: "+ id);
            return r ;
        }else{
            System.out.println("maximum number of cashier the store can employ is 5");
            return null;
        }
    }


}
