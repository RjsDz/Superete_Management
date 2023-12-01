
package supermarketproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author RJS
 */
public class Lists {
    public static ObservableList<Sale> list1 = FXCollections.observableArrayList();
    public static ObservableList<Sale> list2 = FXCollections.observableArrayList();
    public static ObservableList<Sale> list3 = FXCollections.observableArrayList();
    public static int pointerOfList = 1;
    public static boolean root;
    public static int index = -1;
    

    public Lists() {
        System.out.println(list1.size());
    }
    
    
}
