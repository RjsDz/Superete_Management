
package supermarketproject;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javax.swing.JOptionPane;


public class FXMLAddminController implements Initializable {

    
    
    @FXML
    private Button deletBut;

    @FXML
    private Button exitBut;

    @FXML
    private Button sendBut;

    @FXML
    private TextField userInp;

    public void exit(){
        deletBut.getScene().getWindow().hide();
    }
    
    public void send(){
        String inp = userInp.getText();
        if(inp.equals("")){
            JOptionPane.showMessageDialog(null, "Please fill the field ");
            return;
        }
            
        int isAdmin = DB.isAdmin(inp);
        if(isAdmin == -1){
          JOptionPane.showMessageDialog(null, "ther is not such this name in database !!!!");
          return;
        }
        DB.addAdmin(inp);
        //JOptionPane.showMessageDialog(null, "The process was successfully.");
        userInp.setText("");
    }
    
    public void delete(){
        String inp = userInp.getText();
        if(inp.equals("")){
            JOptionPane.showMessageDialog(null, "Please fill the field ");
            return;
        }
            
        int isAdmin = DB.isAdmin(inp);
        if(isAdmin == -1){
          JOptionPane.showMessageDialog(null, "ther is not such this name in database !!!!");
          return;
        }
        DB.addNotAddmin(inp);
        //JOptionPane.showMessageDialog(null, "The process was successfully.");
        userInp.setText("");
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
