package supermarketproject;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.lang.Thread;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.Mnemonic;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import supermarketproject.Sale;

/**
 * 
 *
 * @author RJS
 */
public class FXMLMainFaceController extends Thread implements Initializable {

    @FXML
    private Label ctrlP;
    
    @FXML 
    private Label changeQteLab;
    
    @FXML
    private Label calculateLab;
    
    @FXML
    private GridPane toppane;
    
    @FXML
    private Label receivedLab;

    @FXML
    private Label renderedLab;
    
    @FXML
    private ImageView printer;

    @FXML
    private Button admin;
    
    @FXML
    private Button delRow;

    @FXML
    private TableColumn<Sale,String> cdColumn;

    @FXML
    private Button check;

    @FXML
    private CheckBox checkBox;

    @FXML
    private Button client1;

    @FXML
    private Button client11;

    @FXML
    private Button client2;

    @FXML
    private Button client3;

    @FXML
    private TextField codeBar;

    @FXML
    private TextField ctrlF8;

    @FXML
    private TableColumn<Sale, String> dColumn;
    
    @FXML 
    private Button changePass;

    @FXML
    private Label date;

    @FXML
    private Button delete;
    
    @FXML
    private Label itemsLab;
    
    @FXML
    private Label issue;

    @FXML
    private Button exit;

    @FXML
    private Label numBon;

    @FXML
    private Label userLab;

    @FXML
    private Label priceTotal;

    @FXML
    private Button products;

    @FXML
    private TableColumn<Sale, Float> qColumn;

    @FXML
    private TextField received;

    @FXML
    private TextField rendered;
    
    @FXML
    private AnchorPane mainp;

    @FXML
    private TableColumn<Sale, Float> sColumn;

    @FXML
    private Button sales;

    @FXML
    private Label time;
    
    @FXML
    private Label items;
    
    @FXML 
    private Label cp;

    @FXML
    private TableColumn<Sale, Float> uColumn;
        @FXML
    private TableView<Sale> table;

    @FXML
    private Button users;
    
    @FXML
    private Button control;
    
    @FXML
    private Button dbCon;
    
    @FXML
    private ImageView calculator;
    
    @FXML
    private Label ctrlC;
    
    private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private ObservableList <Sale> list = FXCollections.observableArrayList();

    
private void updateDateTime() {
    try {
        Date dateTime = new Date();
        SimpleDateFormat formatterDate = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatterTime = new SimpleDateFormat("HH:mm:ss");
        String date_ = formatterDate.format(dateTime);
        String time_ = formatterTime.format(dateTime);

        Platform.runLater(() -> {
            date.setText(date_);
            time.setText(time_);
            
        userLab.setText(Employee.name);
            total();
        });
    } catch (Exception ex) {
        System.out.println(ex);
    }
}

    //@FXML
    public  void exitFunc(){
        
        try{
            System.out.println("EXIT");
            System.exit(0);
            Platform.exit();
        }catch(Exception ex){
            System.out.println(ex+"");
        }
      
    }
    
    public void togleMode(){
        if(checkBox.isSelected()){
            //toppane.setStyle("-fx-background-color: #00796b");
            receivedLab.setTextFill(Color.WHITE);
            renderedLab.setTextFill(Color.WHITE);
            itemsLab.setTextFill(Color.WHITE);
            checkBox.setTextFill(Color.WHITE);
            cp.setTextFill(Color.WHITE);
            ctrlC.setTextFill(Color.WHITE);
            calculateLab.setStyle("-fx-background-color:#37474f");
            calculateLab.setTextFill(Color.WHITE);
            changeQteLab.setStyle("-fx-background-color:#37474f");
            
            changeQteLab.setTextFill(Color.WHITE);
            issue.setTextFill(Color.WHITE);
            mainp.setStyle("-fx-background-color:#37474f");
            
        }else{
            //toppane.setStyle("-fx-background-color: #4db6ac");
            receivedLab.setTextFill(Color.BLACK);
            renderedLab.setTextFill(Color.BLACK);
            itemsLab.setTextFill(Color.BLACK);
            checkBox.setTextFill(Color.BLACK);
            ctrlC.setTextFill(Color.BLACK);
            cp.setTextFill(Color.BLACK);
            calculateLab.setStyle("-fx-background-color: #f5f5f5");
            calculateLab.setTextFill(Color.BLACK);
            changeQteLab.setStyle("-fx-background-color: #f5f5f5");
            changeQteLab.setTextFill(Color.BLACK);
            issue.setTextFill(Color.BLACK);
            mainp.setStyle("-fx-background-color:#f5f5f5");
        }
    }
    
    
    public void openTab(){
        Pages p = new Pages("FXMLSearch.fxml",check, false);
        p.fixSize(true);
        p.setIcon("/supermarketproject/imgs/logo.png");
        p.setTitle("Search For A Product");
        p.newStrage();
    }
    
    //----------------------------------------------------------------------------------------------
    //To fill
    public Sale fillOneSale(){
        Sale s = new Sale();
        float price = DB.fechPriceByCodeBare(codeBar.getText());
        if(price == -1){
            JOptionPane.showMessageDialog(null, "The code bar is uncorect ,ther is not such this code bar in data base");
            return null;
        }
        //to do check if the codeBar is exist
        s.setCodeBar(codeBar.getText());
        s.setProduct(DB.fechProducNameByCodeBare(codeBar.getText()));                            //TO FILL
        s.setQte(Float.parseFloat(ctrlF8.getText()));
        //s.setId(list.size()+1);
        s.setPrice(DB.fechPriceByCodeBare(codeBar.getText()));
        s.setSum(s.getPrice() * s.getQte());
        s.setDate(date.getText());
        s.setTime(time.getText());
        return s;   
    }


   

public void addQte() {

    switch (Lists.pointerOfList) {
        case 1:
            if(Lists.list1.size() == 0)
                break;
            Sale sale1 = Lists.list1.get(Lists.list1.size() - 1); // Get the last Sale object in list1
            sale1.setQte(sale1.getQte() + 1); // Increase the quantity of the last Sale in list1
            sale1.setSum(sale1.getQte() * sale1.getPrice()); // Update the total sum
            break;
        case 2:
            if(Lists.list2.size() == 0)
                break;
            Sale sale2 = Lists.list2.get(Lists.list2.size() - 1); // Get the last Sale object in list2
            sale2.setQte(sale2.getQte() + 1); // Increase the quantity of the last Sale in list2
            sale2.setSum(sale2.getQte() * sale2.getPrice()); // Update the total sum
            break;
        default:
            Sale sale3 = Lists.list3.get(Lists.list3.size() - 1); // Get the last Sale object in list3
            sale3.setQte(sale3.getQte() + 1); // Increase the quantity of the last Sale in list3
            sale3.setSum(sale3.getQte() * sale3.getPrice()); // Update the total sum
            break;
    }
    table.refresh();
    total();
}

    
    
    
    
    //-----+++++++++++++++++++++++++++++++++++++++++++
   
   public void minusQte(){
     switch (Lists.pointerOfList) {
        case 1:
            Sale sale1 = Lists.list1.get(Lists.list1.size() - 1); // Get the last Sale object in list1
            sale1.setQte(sale1.getQte() - 1); // Increase the quantity of the last Sale in list1
            sale1.setSum(sale1.getQte() * sale1.getPrice()); // Update the total sum
            break;
        case 2:
            Sale sale2 = Lists.list2.get(Lists.list2.size() - 1); // Get the last Sale object in list2
            sale2.setQte(sale2.getQte() - 1); // Increase the quantity of the last Sale in list2
            sale2.setSum(sale2.getQte() * sale2.getPrice()); // Update the total sum
            break;
        default:
            Sale sale3 = Lists.list3.get(Lists.list3.size() - 1); // Get the last Sale object in list3
            sale3.setQte(sale3.getQte() - 1); // Increase the quantity of the last Sale in list3
            sale3.setSum(sale3.getQte() * sale3.getPrice()); // Update the total sum
            break;
    }
    table.refresh();
    total();
    }
   
   public void saleDB(){
       String d = date.getText();
       String t = time.getText();
       String username = userLab.getText();
       
       switch(Lists.pointerOfList){
           case 1:
               if(Lists.list1.size() < 1){
                   JOptionPane.showMessageDialog(null, "Your Table is Empty");
                   return;
               }
               for(Sale s : Lists.list1){
                   DB.addSale(username, s.getProduct(), s.getCodeBar(), s.getPrice(), s.getQte(), s.getSum(), d, t);
               }
               break;
           case 2:
               if(Lists.list2.size() < 1){
                   JOptionPane.showMessageDialog(null, "Your Table is Empty");
                   return;
               }
               for(Sale s : Lists.list2){
                   DB.addSale(username, s.getProduct(), s.getCodeBar(), s.getPrice(), s.getQte(), s.getSum(), d, t);
               }
               break;
           default :
               if(Lists.list3.size() < 1){
                   JOptionPane.showMessageDialog(null, "Your Table is Empty");
                   return;
               }
               for(Sale s : Lists.list3){
                   DB.addSale(username, s.getProduct(), s.getCodeBar(), s.getPrice(), s.getQte(), s.getSum(), d, t);
               }
               break;
       }
   }
    
   public void printInvoice(){
       saleDB();
       String invoice = "invoice_"+date.getText().replace("/", "-")+"____"+time.getText().replace(":", "-");
        PDFGenerator.pdfCreate(invoice, date.getText(), time.getText());
   }

public void addQteWithValue(float value) {
    switch (Lists.pointerOfList) {
        case 1:
            Sale sale1 = Lists.list1.get(Lists.list1.indexOf(Lists.index)); // Get the last Sale object in list1
            sale1.setQte(sale1.getQte() + value); // Increase the quantity of the last Sale in list1
            sale1.setSum(sale1.getQte() * sale1.getPrice()); // Update the total sum
            break;
        case 2:
            Sale sale2 = Lists.list2.get(Lists.list2.indexOf(Lists.index)); // Get the last Sale object in list2
            sale2.setQte(sale2.getQte() + value); // Increase the quantity of the last Sale in list2
            sale2.setSum(sale2.getQte() * sale2.getPrice()); // Update the total sum
            break;
        default:
            Sale sale3 = Lists.list3.get(Lists.list3.indexOf(Lists.index)); // Get the last Sale object in list3
            sale3.setQte(sale3.getQte() + value); // Increase the quantity of the last Sale in list3
            sale3.setSum(sale3.getQte() * sale3.getPrice()); // Update the total sum
            break;
    }
    table.refresh();
    total();
}

public void deletSale(){
    try{
        Lists.index = table.getSelectionModel().getSelectedIndex();
        System.out.println(Lists.index+"");
        if(Lists.index != -1)
        switch(Lists.pointerOfList){
            case 1:
                Lists.list1.remove(Lists.index);
                table.setItems(Lists.list1);
                table.refresh();
                break;
            case 2:
                Lists.list2.remove(Lists.index);
                table.setItems(Lists.list2);
                table.refresh();
                break;
            default:
                Lists.list3.remove(Lists.index);
                table.setItems(Lists.list3);
                table.refresh();
                break;
        }
        Lists.index = -1;
        total();
    }catch(Exception ex){
        return;
    }
}
 
public void changePassword(){
    
    Pages p = new Pages("FXMLUpdatePass.fxml", changePass,true);
   // p.changePage();
   p.fixSize(true);
   p.setIcon("/supermarketproject/imgs/logo.png");
   p.setTitle("Change Password");
    p.newStrage();
   
}
public void changeQte() {
    try {
        int selectedIndex = table.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            float newQuantity = Float.parseFloat(ctrlF8.getText());

            // Get the currently selected list based on Lists.pointerOfList
            ObservableList<Sale> selectedList;
            switch (Lists.pointerOfList) {
                case 1:
                    selectedList = Lists.list1;
                    break;
                case 2:
                    selectedList = Lists.list2;
                    break;
                default:
                    selectedList = Lists.list3;
                    break;
            }

            // Update the quantity of the selected sale in the selected list
            Sale selectedSale = selectedList.get(selectedIndex);
            selectedSale.setQte(newQuantity);

            // Update the total sum
            selectedSale.setSum(newQuantity * selectedSale.getPrice());

            // Refresh the TableView
            table.refresh();
            total();
            Lists.index = -1;
            ctrlF8.setText("");
        }
    } catch (NumberFormatException ex) {
        // Handle the case where the user enters an invalid value
        JOptionPane.showMessageDialog(null, "Please enter a valid numeric value.");
    }
}

    
    
    
    //-----+++++++++++++++++++++++++++++++++++++++++++
 

    //To fill
    public void addSaleToList1(){
        Sale s = fillOneSale();
        Lists.list1.add(s);
        table.setItems(Lists.list1);
        total();
    }
    
    public void addSaleToList2(){
        Sale s = fillOneSale();
        Lists.list2.add(s);
        table.setItems(Lists.list2);
        total();
    }
    
    //To fill
    public void addSaleToList3(){
        Sale s = fillOneSale();
        Lists.list3.add(s);
        table.setItems(Lists.list3);
        total();
    }
    
    public void client1Func(){
        Lists.pointerOfList = 1;
        table.setItems(Lists.list1);
        total();
    }

    public void client2Func(){
        Lists.pointerOfList = 2;
        table.setItems(Lists.list2);
        total();
    }
    
    public void client3Func(){
  
        Lists.pointerOfList = 3;
        table.setItems(Lists.list3);
        total();
    }
    
    public void deleteFunc(){
        
        switch (Lists.pointerOfList) {
            case 1:
                Lists.list1.clear();
                table.setItems(Lists.list1);
              
                break;
            case 2:
                Lists.list2.clear();
                table.setItems(Lists.list2);
                
                break;
            default:
                Lists.list3.clear();
                table.setItems(Lists.list3);
    
                break;
        }
        total();
    }
    
    public void total(){
        float total =  0.0f;
        String numItems = "";
        switch (Lists.pointerOfList) {
            case 1:
                items.setText(Lists.list1.size()+"");
                for(Sale s : Lists.list1){
                    total += s.getSum();
                } 
                numItems = Lists.list1.size()+"";
                break;
            case 2:
                items.setText(Lists.list2.size()+"");
                
                for(Sale s : Lists.list2){
                    total += s.getSum();
                } 
                 numItems = Lists.list1.size()+"";
                break;
            default:
                items.setText(Lists.list3.size()+"");
                for(Sale s : Lists.list3){
                    total += s.getSum();
                } 
                numItems = Lists.list1.size()+"";
                break;
        }
        
        priceTotal.setText(total+"");
        items.setText(numItems);
        if(priceTotal.getText().equals("0.0"))
            priceTotal.setText("0000.00");
    }
   
    
    public void receivedRendered(){
        if(received.getText().equals(""));
            rendered.setText("");
        float t = Float.parseFloat(priceTotal.getText());
        float one = Float.parseFloat(received.getText());
        //rendered.setText(" ");
        rendered.setText((one-t)+" ");
    }
    
    public void togleF8(){
        if(received.getText().equals(""))
            received.requestFocus();
        else{
            received.setText("");
            received.setFocusTraversable(false);
        }
            
    }
    public void productFunc(){
        if(Admin.isAdmin()){
            Pages p = new Pages("FXMLAddProducts.fxml", rendered);
             p.fixSize(true);
             p.setIcon("/supermarketproject/imgs/logo.png");
             p.setTitle("Add New Product");
            p.newStrage();
        }else{
            JOptionPane.showMessageDialog(null, "You are not ADMIN you have not the authorization !!!");
        }
    }
    
    public void usersFunc(){
        if(Admin.isAdmin()){
            Pages p = new Pages("FXMLAddUser.fxml", rendered);
             p.fixSize(true);
             p.setTitle("Add New User");
                p.setIcon("/supermarketproject/imgs/logo.png");
            p.newStrage();
        }else{
            JOptionPane.showMessageDialog(null, "You are not ADMIN you have not the authorization !!!");
        }
    }
    
    public void openAdminPage(){
        if(Admin.isAdmin()){
            Pages p = new Pages("FXMLAddmin.fxml", rendered);
            p.fixSize(true);
            p.setIcon("/supermarketproject/imgs/logo.png");
            p.setTitle("Add Admin");
            p.newStrage();
        }else{
            JOptionPane.showMessageDialog(null, "You are not ADMIN you have not the authorization !!!");
        }
    }
    
    public void controlFunc(){
        Pages p = new Pages("FXMLControlUser.fxml", rendered);
       p.fixSize(true);
       p.setIcon("/supermarketproject/imgs/logo.png");
       p.setTitle("Control");
        p.newStrage();
    }
    
    
    public void showSalesStat(){
        Pages p = new Pages("FXMLStat.fxml", rendered);
       p.setIcon("/supermarketproject/imgs/logo.png");
       p.setTitle("Statistics");
        p.newStrage();
    }
    
    
    public void openCalc(){
        Pages p = new Pages("FXMLCalculator.fxml", date);
        p.setIcon("/supermarketproject/imgs/logo.png");
        p.setTitle("Calculator");
        p.fixSize(true);
        p.newStrage();
    }
    
    public void openDBConfig(){
        Pages p = new Pages("FXMLDataBaseConnection.fxml", date);
        p.setIcon("/supermarketproject/imgs/logo.png");
        p.setTitle("Data Base Connection");
        p.fixSize(true);
        p.newStrage();
    }
    
@Override
public void initialize(URL url, ResourceBundle rb) {
    /*Sale s;
     s = new Sale("slfjd","dld",10,20);
     Sale b = new Sale("slfjd","dld",10,20);
    Lists.list1.setAll(s,b);*/
    //list.setAll(s);
    cdColumn.setCellValueFactory(new PropertyValueFactory<Sale,String>("codeBar"));
    dColumn.setCellValueFactory(new PropertyValueFactory<Sale,String>("product"));
    qColumn.setCellValueFactory(new PropertyValueFactory<Sale,Float>("qte"));
    uColumn.setCellValueFactory(new PropertyValueFactory<Sale,Float>("price"));
    sColumn.setCellValueFactory(new PropertyValueFactory<Sale,Float>("sum"));
    
    table.setItems(Lists.list1);
    

    // Date And Time.
    Platform.runLater(() ->{
           date.getScene().getWindow().setX(20);
           date.getScene().getWindow().setY(3);
            total();
            // Handle the F12 key event for exit button
            
         
            
    delete.getScene().addEventHandler(KeyEvent.KEY_PRESSED, event -> {
    if (event.getCode() == KeyCode.F11) {
        deleteFunc();
    } else if (event.getCode() == KeyCode.F12) {
        exitFunc();
    } else if (event.getCode() == KeyCode.F1) {
        client1Func();
    } else if (event.getCode() == KeyCode.F2) {
        client2Func();
    } else if (event.getCode() == KeyCode.F3) {
        client3Func();
    } else if (event.getCode() == KeyCode.F4) {
        minusQte();
    } else if (event.getCode() == KeyCode.F5) {
        addQte();
    } else if (event.getCode() == KeyCode.F6) {
        deletSale();
    } else if (event.getCode() == KeyCode.F8 && event.isControlDown()) {
        ctrlF8.requestFocus();
    } else if (event.getCode() == KeyCode.F9 && event.isControlDown()) {
        changeQte();
    } else if (event.getCode() == KeyCode.P && event.isControlDown()) {
        printInvoice();
    }else if(event.getCode() == KeyCode.F8){
        togleF8();
    }else if(event.getCode() == KeyCode.F10){
        openTab();
    }else if(event.getCode() == KeyCode.C && event.isControlDown()){
       openCalc();
    }
    event.consume(); // Consume the event to prevent it from being processed twice
});
            Lists.pointerOfList = 1;
            //addQte();
            });
            

            
            
            //=========================================
            date.setText("");
            time.setText("");
            // Schedule a task to update date and time every second
            scheduler.scheduleAtFixedRate(FXMLMainFaceController.this::updateDateTime, 0, 1, TimeUnit.SECONDS);
            //scheduler.scheduleAtFixedRate(FXMLMainFaceController.this::total, 0, 1, TimeUnit.SECONDS);
        
    
}



}
    

/*
* Fill  add and minus 
/and disign


*/