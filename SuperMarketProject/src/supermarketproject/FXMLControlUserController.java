package supermarketproject;

import java.net.URL;
import java.text.NumberFormat;
import java.util.ResourceBundle;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javax.swing.JOptionPane;


public class FXMLControlUserController implements Initializable {

    @FXML
    private DatePicker dateInp;

    @FXML
    private Label moneyLab;

    @FXML
    private TableView<Sale> table;

    @FXML
    private TextField userInp;

    @FXML
    private TableColumn<Sale, String> users;
    
    @FXML
    private Button butt;
    
    @FXML
    private ImageView doorClose;
    
    ObservableList<Sale> newList = DB.usersController();
    private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    
    
    public ObservableList<Sale> list;
    
    
public void search() {
    String date = dateInp.getValue() + "";
    date = date.trim();
    String user = userInp.getText();
    user = user.trim();
    System.out.println("Date: " + date);
    System.out.println("User: " + user);

    if (date.equals("") || user.equals("")) {
        JOptionPane.showMessageDialog(null, "Please, fill all the input fields!");
        return;
    }

    try {
        float sum = DB.getSumOFOneDateByUser(date, user);

        // Format the sum as currency
       
        String formattedSum = sum+"";

        moneyLab.setText(formattedSum);
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "An error occurred while retrieving the sum.");
    }
}

    
   public void filter() {
    String user = userInp.getText().trim();

    if (user.equals("")) {
        table.setItems(list);
    } else {
        newList.clear();
        for (Sale s : DB.usersController()) {
            if (s.getUsername().contains(user)) {
                newList.add(s);
            }
        }
        table.setItems(newList);
    }
    table.refresh();
}


    public void select(){
        int index = table.getSelectionModel().getSelectedIndex();
        
        String user = list.get(index).getUsername();
        userInp.setText(user);
    }
    
    public void closeWind(){
        butt.getScene().getWindow().hide();
    }
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        users.setCellValueFactory(new PropertyValueFactory<Sale,String>("username"));
        
        Platform.runLater(()->{
            butt.getScene().addEventHandler(KeyEvent.KEY_PRESSED, e->{
            if(e.getCode() == KeyCode.S  && e.isControlDown()){
                search();
            }else if(e.getCode() == KeyCode.E && e.isControlDown()){
                closeWind();
            }
            
            });
            list = DB.usersController();
            newList = list;
            table.setItems(list);
            table.refresh();
        });
    }    
    
}
