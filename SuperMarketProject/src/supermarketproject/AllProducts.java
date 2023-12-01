
package supermarketproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class AllProducts {
    public static ObservableList <Products> products = DB.fetchAllProducts();

    public AllProducts() {
        
        
    }
    
    
}
