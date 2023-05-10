import com.adebisi.file_reader_writer.ReadAndUpdateFile;
import com.adebisi.staff.Cashier;
import com.adebisi.customer.Customer;
import com.adebisi.staff.Manager;
import com.adebisi.store.Addproduct;
import com.adebisi.store.Store;
import com.adebisi.store.category_enum.Category;
import com.adebisi.store.display.DIsplayProducts;
import com.adebisi.store.display.DisplayCashier;

public class Main {
    public static void main(String[] args) {
       Manager.employManager("Adebisi");
       Store store = new Store(50000, (Manager) Manager.getCurretManager());

       Manager myManager = store.currentManager;

        Cashier susan = myManager.hireCashier(store,"Susan" );
        Cashier kola = myManager.hireCashier(store,"kola" );
        Cashier tola = myManager.hireCashier(store,"Tola" );
        Cashier bola = myManager.hireCashier(store,"Bola" );

        DisplayCashier.display(store);
        System.out.println("************");
       // myManager.sackCashier(store,"cashier04" );
       // DisplayCashier.display(store);

        System.out.println("************");
        Addproduct addproduct = new Addproduct();
//        addproduct.addproduct("mango",20,50, Category.FOODSTUFF,store);
//        addproduct.addproduct("orange",20,50,Category.FOODSTUFF,store);
//        addproduct.addproduct("beans",20,50,Category.FOODSTUFF,store);
//        addproduct.addproduct("plantain",20,50,Category.FOODSTUFF,store);
//        addproduct.addproduct("peanut",20,50,Category.FOODSTUFF,store);
        String path = "/Users/decagon/IdeaProjects/task_two/src/main/java/com/adebisi/external_file/productSheet.xlsx";
        ReadAndUpdateFile readAndUpdateFile = new ReadAndUpdateFile();
        readAndUpdateFile.readFile(path,addproduct,store);

        DIsplayProducts.displayByCategory(store,Category.FASHION);



        Customer c = new Customer("Adebis",6000000);
        c.buy(store, 1,20);  // remain 50


        susan.sell(c,store);


        readAndUpdateFile.updateFile(path, store);

    }

}