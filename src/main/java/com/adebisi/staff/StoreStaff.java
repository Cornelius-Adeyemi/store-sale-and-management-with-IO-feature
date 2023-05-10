package com.adebisi.staff;

public abstract class StoreStaff {

   public final String name;
   public final String id;
   public final String title;

    public StoreStaff(String name, String id, String position){

        this.name = name;
        this.id = id;
        this.title = position;
    }

    @Override
    public String toString() {
        return " Id: "+ id+"\n" +  "Name: "+name + "\n" + "Title "+ title;
    }
}
