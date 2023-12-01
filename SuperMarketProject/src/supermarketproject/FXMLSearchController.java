
package supermarketproject;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


public class FXMLSearchController implements Initializable {

    @FXML
    private TableColumn<Products, String> cC;

    @FXML
    private TableColumn<Products, Integer> idC;

    @FXML
    private TableColumn<Products, String> pC;

    @FXML
    private TableColumn<Products, Float> prC;

    @FXML
    private Button search;

    @FXML
    private TextField searchInp;

    @FXML
    private TableView<Products> table;
    private ObservableList<Products> newList = AllProducts.products;
    private Products productResult = null;
    
    public void add(){
        switch (Lists.pointerOfList) {
            case 1:
                Lists.list1.add(new Sale(productResult.getProduct_name(),productResult.getCode_bar(),productResult.getPrice(),1));
                break;
            case 2:
                Lists.list2.add(new Sale(productResult.getProduct_name(),productResult.getCode_bar(),productResult.getPrice(),1));
                break;
            default:
                Lists.list3.add(new Sale(productResult.getProduct_name(),productResult.getCode_bar(),productResult.getPrice(),1));
                break;
        }
        searchInp.setText("");
    }
    
    public void selectedRow(){
        int index = table.getSelectionModel().getSelectedIndex();
        String product = newList.get(index).getProduct_name();
        productResult = newList.get(index);
        searchInp.setText(product);
       
    }
    
    public void matchedValue(){
        String match = searchInp.getText();
        newList = FXCollections.observableArrayList();
        for(Products p : AllProducts.products){
            boolean idCon = String.valueOf(p.getId()).toLowerCase().contains(match.toLowerCase());
            boolean productCon = p.getProduct_name().toLowerCase().contains(match.toLowerCase());
            boolean priceCon = String.valueOf(p.getPrice()).toLowerCase().contains(match.toLowerCase());
            boolean codBarCon = p.getCode_bar().toLowerCase().contains(match.toLowerCase());
            if (idCon || productCon || priceCon || codBarCon ) {
                newList.add(p);
            }
        }
        table.setItems(newList);
        table.refresh();
    }
    
    public void hideWindow(){
        searchInp.getScene().getWindow().hide();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
        Platform.runLater(()->{
            searchInp.getScene().addEventHandler(KeyEvent.KEY_PRESSED, e ->{
            
                if(e.getCode() == KeyCode.B && e.isControlDown()){
                    add();
                }else if(e.getCode() == KeyCode.N && e.isControlDown()){
                   hideWindow();
                }
            
            
            });
        
        });
        
        idC.setCellValueFactory(new PropertyValueFactory<Products,Integer>("id"));
        cC.setCellValueFactory(new PropertyValueFactory<Products,String>("code_bar"));
        prC.setCellValueFactory(new PropertyValueFactory<Products,Float>("price"));
        pC.setCellValueFactory(new PropertyValueFactory<Products, String>("product_name"));
        
        table.setItems(AllProducts.products);
       
    }    
    
}
