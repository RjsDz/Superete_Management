package supermarketproject;

import com.sun.jdi.connect.spi.Connection;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ANIS INFO
 */
public class FXMLAddProductsController implements Initializable {
    @FXML
    private TextField productLab;

    @FXML
    private TextField priceLab;

    @FXML
    private TextField codeLab;

    @FXML
    private Button addButt;

    @FXML
    private Button updateButt;

    @FXML
    private Button deleteButt;

    @FXML
    private Button exitButt;
    
    public void cancel(){
        Pages p = new Pages("FXMLMainFace.fxml", deleteButt);
        p.closeWithNode(exitButt);
       
    }
    
    public void add(){
       
        try{
            DB.insertProduct(productLab.getText(), codeLab.getText(),Float.parseFloat(priceLab.getText()));
            productLab.setText("");
            priceLab.setText("");
            codeLab.setText("");
        }catch(Exception e){
            System.out.println(e+"");
        }
    }
    
    public void update(){
        try{
            if(codeLab.getText().equals("") || productLab.getText().equals("") || priceLab.getText().equals("")){
                JOptionPane.showMessageDialog(null, "ther is in field is emtpy, please fill all the field");
                return;
            }
            boolean isExist = DB.productFound(codeLab.getText());
            if(!isExist){
                JOptionPane.showMessageDialog(null, "Ther is not such this product in data base !!!");
                return;
            }
            DB.ubdateProduct(codeLab.getText(), productLab.getText(),Float.parseFloat(priceLab.getText()) );
            productLab.setText("");
            priceLab.setText("");
            codeLab.setText("");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ther is not such this product in data base .");
        }
    }
    
    public void delete(){
        try{
            if(codeLab.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Code Bar field is reqeired !!");
                return;
            }
            DB.deleteProduct(codeLab.getText());
            productLab.setText("");
            priceLab.setText("");
            codeLab.setText("");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ther is not such this product in data base .");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }
}
