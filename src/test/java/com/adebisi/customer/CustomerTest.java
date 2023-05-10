package com.adebisi.customer;

import com.adebisi.staff.Cashier;
import com.adebisi.staff.Manager;
import com.adebisi.store.Store;
import com.adebisi.store.category_enum.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {


    Store store;
    Cashier susan;
    Cashier kola;
    Cashier tola;
    Cashier bola;
    Manager manager;
    @BeforeEach
    void unit(){
        Manager.employManager("Cornelius");
     store = new Store(50000, (Manager) Manager.getCurretManager());
      manager = store.currentManager;
         susan = manager.hireCashier(store,"Susan" );
         kola = manager.hireCashier(store,"kola" );
         tola = manager.hireCashier(store,"Tola" );
         bola = manager.hireCashier(store,"Bola" );

        store.addproduct("mango",20,0, Category.FOODSTUFF);
        store.addproduct("orange",20,50,Category.FOODSTUFF);
        store.addproduct("beans",20,50,Category.FOODSTUFF);
        store.addproduct("plantain",20,50,Category.FOODSTUFF);
        store.addproduct("peanut",20,50,Category.FOODSTUFF);
    }

    @Test
    @DisplayName("Testing when a customer tries to buy out of stoke product")
    void customerBuy() {
        Customer customer = new Customer("wale", 6000);
        customer.buy(store,1,2);

        assertAll(
                ()-> assertEquals(0,customer.cart.size()),
                ()->  assertEquals(6000, customer.moneyOwned)
        );
    }

    @Test
    @DisplayName("Testing when a customer tries to buy IN_STOCK product")
    void customerBuyA() {
        Customer customer = new Customer("wale", 6000);
        customer.buy(store,3,2);
        customer.buy(store,3,2);

        assertAll(
                ()-> assertEquals(2,customer.cart.size()),
                ()->  assertEquals(6000-80, customer.moneyOwned)
        );
    }

    @Test
    @DisplayName("Testing when a cashier attend to a customer")
    void cashierAttendToCustomer() {
        Customer customer = new Customer("wale", 6000);
        customer.buy(store,3,2);
        customer.buy(store,3,2);
        susan.sell(customer,store);

        assertAll(
                ()-> assertEquals(0,customer.cart.size()),
               ()->  assertEquals(false, customer.buyChecker)
        );
    }
}